package org.example.springboot.repository;

import org.example.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // create our own query statement with implementation findBY<filenames in camel style> -> findByDepartmentName
    //the list of keywords can be find docs
    public Department findByDepartmentName(String departmentName);

    // the same deal but with IgnoreCase sensitive
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    //mandatory create query
    //@Query(value = "Select * From department",countQuery = "Select count(*) From department",nativeQuery = true)
    //public Page<Department> selectAllFromDepartment();
}
