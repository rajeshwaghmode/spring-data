package com.java.learning.spring.springdata.jpa.service;

import com.java.learning.spring.springdata.jpa.model.Department;
import com.java.learning.spring.springdata.jpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "departmentService")
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public void saveAll(List<Department> departments){
        repository.saveAll(departments);
    }

    public List<Department> findAll(){
        return repository.findAll();
    }
}
