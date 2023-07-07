package com.mvc.controllers;

import com.mvc.controllers.dao.PersonDAOJDBC;
import com.mvc.models.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/peoplev2")
public class Peoplev2Controller {

    private final PersonDAOJDBC personDAO;

    @Autowired //constractor injection
    public Peoplev2Controller(PersonDAOJDBC personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getPeopleList(Model model) {
        //get list of people from DAO
        //Model return list to user
        model.addAttribute("peoplev2", personDAO.getPeople());
        return "peoplev2/index";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") int id, Model model) {
        //get person by id from DAO
        model.addAttribute("person", personDAO.getPerson(id));
        return "peoplev2/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {/*Model model){model.addAttribute("person",new Person());*/
        return "peoplev2/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) { //before putting attributes value to class obj they need to be validated
        //the error messages from validation go to binding
        if (bindingResult.hasErrors()) {
            return "peoplev2/new";
        }

        personDAO.add(person);
        return "redirect:/peoplev2";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "peoplev2/edit";
    }

    @PatchMapping("/{id}") //need filter that would redirect here post request
    public String update(@PathVariable("id") int id, @ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "peoplev2/edit";
        }

        personDAO.update(id, person);
        return "redirect:/peoplev2";
    }

    @DeleteMapping("/{id}") //need filter that would redirect here post request
    public String delete(@PathVariable("id") int id) {
        personDAO.remove(id);
        return "redirect:/peoplev2";
    }
}
