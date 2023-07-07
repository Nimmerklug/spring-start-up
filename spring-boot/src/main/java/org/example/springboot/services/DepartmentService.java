package org.example.springboot.services;

import org.example.springboot.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department addDepartment(Department department);

    List<Department> getDepartmentList();

    Department getDepartmentByID(Long departmentID);

    Department deleteDepartmentByID(Long departmentID);

    Department updateDepartmentByID(Long departmentID, Department department);

    Department getDepartmentByName(String departmentName);
}
