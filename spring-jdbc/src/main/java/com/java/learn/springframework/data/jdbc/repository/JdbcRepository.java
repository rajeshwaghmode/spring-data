package com.java.learn.springframework.data.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

public class JdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public final void save(String dmlQuery, PreparedStatementSetter pss) {
        jdbcTemplate.update(dmlQuery, pss);
    }

    public final <T> T query(String selectQeury, ResultSetExtractor<T> rse, Object... args) {
        return jdbcTemplate.query(selectQeury, rse, args);
    }
}
