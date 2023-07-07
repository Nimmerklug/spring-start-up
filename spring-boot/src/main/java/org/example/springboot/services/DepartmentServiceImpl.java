package org.example.springboot.services;

import org.example.springboot.entity.Department;
import org.example.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(Long departmentID) {
        //return departmentRepository.findById(departmentID).get();
        return departmentRepository.findById(departmentID)
                .orElseThrow(() -> new IllegalStateException(String.format("Department with id:|%d| doesn't exist", departmentID)));
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        //return departmentRepository.findByDepartmentName(departmentName); //we didn't implement this method manually
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName); //we didn't implement this method manually
    }

    @Override
    public Department deleteDepartmentByID(Long departmentID) {
        Department deletedDepartment = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new IllegalStateException(String.format("Department with id:|%d| doesn't exist", departmentID)));

        departmentRepository.deleteById(departmentID);

        return deletedDepartment;
    }

    @Override
    public Department updateDepartmentByID(Long departmentID, Department department) {
        Department updatedDepartment = getDepartmentByID(departmentID);

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equals(department.getDepartmentName())) {
            updatedDepartment.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equals(department.getDepartmentAddress())) {
            updatedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equals(department.getDepartmentCode())) {
            updatedDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(updatedDepartment);
    }

}
