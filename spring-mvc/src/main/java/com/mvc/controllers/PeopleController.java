package com.mvc.controllers;

import com.mvc.controllers.dao.PersonWithoutDAO;
import com.mvc.models.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonWithoutDAO personDAO;

    @Autowired //constractor injection
    public PeopleController(PersonWithoutDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getPeopleList(Model model) {
        //get list of people from DAO
        //Model return list to user
        model.addAttribute("people", personDAO.getPeople());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") int id, Model model) {
        //get person by id from DAO
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {/*Model model){model.addAttribute("person",new Person());*/
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) { //before putting attributes value to class obj they need to be validated
        //the error messages from validation go to binding
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/edit";
    }

    @PatchMapping("/{id}") //need filter that would redirect here post request
    public String update(@PathVariable("id") int id, @ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}") //need filter that would redirect here post request
    public String delete(@PathVariable("id") int id) {
        personDAO.remove(id);
        return "redirect:/people";
    }
}
