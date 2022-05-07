package com.java.learn.springframework.data.jdbc.repository;

import com.java.learn.springframework.data.jdbc.model.CoreAssumption;
import com.java.learn.springframework.data.jdbc.model.VectorAssumption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VectorAssumptionRepository extends CrudRepository<VectorAssumption, Long> {
    
}
