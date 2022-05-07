package com.java.learn.springframework.data.jdbc.repository;

import com.java.learn.springframework.data.jdbc.model.CoreAssumption;
import com.java.learn.springframework.data.jdbc.model.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreAssumptionRepository extends CrudRepository<CoreAssumption, Long> {
    
}
