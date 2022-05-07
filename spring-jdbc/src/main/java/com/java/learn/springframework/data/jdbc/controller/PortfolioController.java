package com.java.learn.springframework.data.jdbc.controller;

import com.java.learn.springframework.data.jdbc.model.CoreAssumption;
import com.java.learn.springframework.data.jdbc.model.Portfolio;
import com.java.learn.springframework.data.jdbc.model.VectorAssumption;
import com.java.learn.springframework.data.jdbc.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.time.LocalDate.now;
import static java.util.Arrays.asList;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    PortfolioService service;

    @PostMapping("/")
    public String createPortfolio() {
        List<Portfolio> portfolios = createAndGetPortfolios();
        service.insertPortfolio(portfolios.get(getRandomNumberUsingNextInt(0, 2)));
        return "Success";
    }

    private List<Portfolio> createAndGetPortfolios() {
        List<Portfolio> portfolios = new ArrayList<>();

        VectorAssumption v1 =  new VectorAssumption(); v1.setTenor("O/N");
        CoreAssumption c1 =  new CoreAssumption(); c1.setType("CR"); c1.setVectors(asList(v1));
        Portfolio p1 = new Portfolio(); p1.setName("P1"); p1.setEffectiveFromDate(now()); p1.setCores(asList(c1));

        VectorAssumption v2 =  new VectorAssumption(); v2.setTenor("O/N");
        CoreAssumption c2 =  new CoreAssumption(); c2.setType("CR"); c2.setVectors(asList(v2));
        Portfolio p2 = new Portfolio(); p2.setName("P2"); p2.setEffectiveFromDate(now());  p2.setCores(asList(c2));

        portfolios.add(p1);
        portfolios.add(p2);

        return portfolios;
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
