package com.mvc.controllers;


import com.mvc.controllers.dao.StudentDAOHibernate;
import com.mvc.models.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentHibernateController {

    private final StudentDAOHibernate studentDAO;

    @Autowired //constractor injection
    public StudentHibernateController(StudentDAOHibernate studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping()
    public String getStudentsList(Model model) {
        //get list of people from DAO
        //Model return list to user
        model.addAttribute("students", studentDAO.getStudents());
        return "students/index";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable("id") int id, Model model) {
        //get student by id from DAO
        model.addAttribute("student", studentDAO.getStudent(id));
        return "students/show";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {/*Model model){model.addAttribute("person",new Student());*/
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) { //before putting attributes value to class obj they need to be validated
        //the error messages from validation go to binding
        if (bindingResult.hasErrors()) {
            return "students/new";
        }

        studentDAO.add(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentDAO.getStudent(id));
        return "students/edit";
    }

    @PatchMapping("/{id}") //need filter that would redirect here post request
    public String update(@PathVariable("id") int id, @ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "students/edit";
        }

        studentDAO.update(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}") //need filter that would redirect here post request
    public String delete(@PathVariable("id") int id) {
        studentDAO.remove(id);
        return "redirect:/students";
    }
}
