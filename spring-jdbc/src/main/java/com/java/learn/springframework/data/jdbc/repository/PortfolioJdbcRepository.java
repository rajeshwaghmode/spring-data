package com.java.learn.springframework.data.jdbc.repository;

import com.java.learn.springframework.data.jdbc.model.Portfolio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static java.sql.Date.valueOf;
import static org.springframework.transaction.annotation.Propagation.NESTED;

@Repository
public class PortfolioJdbcRepository extends JdbcRepository {

    @Transactional(propagation = NESTED)
    public Portfolio findByName(String name) {
        String selectQuery = "SELECT ID, NAME, EFFECTIVE_FROM_DATE FROM PORTFOLIO WHERE NAME = ?";
        return super.query(selectQuery, (rs) -> {
            Portfolio p = new Portfolio();
            while(rs.next()) {
                p.setId(rs.getLong(1));
                p.setName(rs.getString(2));
                p.setEffectiveFromDate(rs.getDate(3).toLocalDate());
                break;
            }
            return p;
        }, name);
    }

    @Transactional
    public void save(Portfolio p) {
        String insertQuery = "INSERT INTO PORTFOLIO (NAME, EFFECTIVE_FROM_DATE) VALUES (?, ?)";
        super.save(insertQuery, (pss) -> {
            pss.setString(1, p.getName());
            pss.setDate(2, valueOf(p.getEffectiveFromDate()));
        });
    }
}
