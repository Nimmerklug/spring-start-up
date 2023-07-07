package org.example.springboot.controllers;

import jakarta.validation.Valid;
import org.example.springboot.entity.Department;
import org.example.springboot.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/departments")
public class DepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department addDepartment(@Valid @RequestBody /*json to obj*/ Department department) {
        //DepartmentService service = new DepartmentServiceImpl();
        LOGGER.info("Started Adding new Department by addDepartment(" + department + ") method");
        return departmentService.addDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartmentList() {
        //DepartmentService service = new DepartmentServiceImpl();
        LOGGER.info("Started Getting all Departments by getDepartmentList() method ");
        return departmentService.getDepartmentList();
    }

    @GetMapping("{id}")
    public Department getDepartmentByID(@PathVariable("id") Long departmentID) {
        //DepartmentService service = new DepartmentServiceImpl();
        return departmentService.getDepartmentByID(departmentID);
    }

    @GetMapping("name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        //DepartmentService service = new DepartmentServiceImpl();
        return departmentService.getDepartmentByName(departmentName);
    }

    @DeleteMapping("{id}")
    public Department deleteDepartmentByID(@PathVariable("id") Long departmentID) {
        //DepartmentService service = new DepartmentServiceImpl();
        return departmentService.deleteDepartmentByID(departmentID);
    }

    @PutMapping("{id}")
    public Department updateDepartmentByID(@PathVariable("id") Long departmentID, @RequestBody Department department) {
        //DepartmentService service = new DepartmentServiceImpl();
        return departmentService.updateDepartmentByID(departmentID, department);
    }
}
