package com.java.learn.springframework.data.jdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Portfolio {
    @Id
    private Long id;
    private String name;
    private LocalDate effectiveFromDate;
    private List<CoreAssumption> cores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEffectiveFromDate() {
        return effectiveFromDate;
    }

    public void setEffectiveFromDate(LocalDate effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    public List<CoreAssumption> getCores() {
        return cores;
    }

    public void setCores(List<CoreAssumption> cores) {
        this.cores = cores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portfolio)) return false;
        Portfolio portfolio = (Portfolio) o;
        return id.equals(portfolio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", effectiveFromDate=" + effectiveFromDate +
                '}';
    }
}
