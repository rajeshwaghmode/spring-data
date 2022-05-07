package com.java.learning.spring.springdata.jpa.repository;

import com.java.learning.spring.springdata.jpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Override
    <S extends Department> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Department>  findAll();
}
