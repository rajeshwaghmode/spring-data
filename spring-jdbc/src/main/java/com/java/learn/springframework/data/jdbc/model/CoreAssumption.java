package com.java.learn.springframework.data.jdbc.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public class CoreAssumption {
    @Id
    private Long breakoutId;
    private Long portfolioId;
    private String type;
    private List<VectorAssumption> vectors;

    public Long getBreakoutId() {
        return breakoutId;
    }

    public void setBreakoutId(Long breakoutId) {
        this.breakoutId = breakoutId;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<VectorAssumption> getVectors() {
        return vectors;
    }

    public void setVectors(List<VectorAssumption> vectors) {
        this.vectors = vectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreAssumption)) return false;
        CoreAssumption that = (CoreAssumption) o;
        return breakoutId.equals(that.breakoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breakoutId);
    }
}
