package com.java.learn.springframework.data.jdbc.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class VectorAssumption {
    @Id
    private Long id;
    private Long breakoutId;
    private String tenor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBreakoutId() {
        return breakoutId;
    }

    public void setBreakoutId(Long breakoutId) {
        this.breakoutId = breakoutId;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VectorAssumption)) return false;
        VectorAssumption vectorAssumption = (VectorAssumption) o;
        return id.equals(vectorAssumption.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
