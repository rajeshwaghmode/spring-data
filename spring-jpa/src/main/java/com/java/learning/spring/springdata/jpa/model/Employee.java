package com.java.learning.spring.springdata.jpa.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Optional;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Cacheable  //This is optional
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)  //Mandatory
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Column
    private String name;
    private Long salary;
    private String managerId;

    @ManyToOne
    private Department department;

    public Employee(){}

    public Employee(String id, String name, String managerId){
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public Employee(String name, String managerId){
        this.name = name;
        this.managerId = managerId;
    }
    public String getId() {
        return id;
    }

    public Optional<String> getName() {
        return Optional.of(name);
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Optional<String> getManagerId() {
        return Optional.of(managerId);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        return 20 * this.managerId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Employee)
            return false;

        if(this == obj) return true;

        Employee emp = (Employee) obj;

        return this.id.equalsIgnoreCase(emp.getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}
