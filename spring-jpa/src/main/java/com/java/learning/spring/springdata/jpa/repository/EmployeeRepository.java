package com.java.learning.spring.springdata.jpa.repository;

import com.java.learning.spring.springdata.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
