package com.java.learn.springframework.data.jdbc.service;

import com.java.learn.springframework.data.jdbc.model.CoreAssumption;
import com.java.learn.springframework.data.jdbc.model.Portfolio;
import com.java.learn.springframework.data.jdbc.model.VectorAssumption;
import com.java.learn.springframework.data.jdbc.repository.CoreAssumptionJdbcRepository;
import com.java.learn.springframework.data.jdbc.repository.PortfolioJdbcRepository;
import com.java.learn.springframework.data.jdbc.repository.VectorAssumptionJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class PortfolioService {

    @Autowired
    PortfolioJdbcRepository portfolioJdbcRepo;
    @Autowired

    CoreAssumptionJdbcRepository coreJdbcRepo;

    @Autowired
    VectorAssumptionJdbcRepository vectorJdbcRepo;

    Logger log = LoggerFactory.getLogger(PortfolioService.class.getSimpleName());

    @Transactional(propagation = REQUIRES_NEW)
    public void insertPortfolio(Portfolio p) {
        this.saveComplete(p);
    }

    public void saveComplete(Portfolio p) {
        portfolioJdbcRepo.save(p);
        Portfolio savedPortfolio = portfolioJdbcRepo.findByName(p.getName());
        log.info("New PortfolioId Generated: {}", savedPortfolio.getId());
        for (CoreAssumption c: p.getCores()) {
            c.setPortfolioId(savedPortfolio.getId());
            coreJdbcRepo.save(c);

            CoreAssumption savedCoreAssumption = coreJdbcRepo.findByPortfolioId(c.getPortfolioId());
            log.info("New BreakoutId Generated: {}", savedCoreAssumption.getBreakoutId());
            for (VectorAssumption v: c.getVectors()) {
                v.setBreakoutId(savedCoreAssumption.getBreakoutId());
                vectorJdbcRepo.save(v);
            }
        }
    }
}
