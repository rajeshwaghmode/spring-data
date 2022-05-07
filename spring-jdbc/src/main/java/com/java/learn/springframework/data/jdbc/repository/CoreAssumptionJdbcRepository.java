package com.java.learn.springframework.data.jdbc.repository;

import com.java.learn.springframework.data.jdbc.model.CoreAssumption;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.NESTED;

@Repository
public class CoreAssumptionJdbcRepository extends JdbcRepository {

    @Transactional(propagation = NESTED)
    public CoreAssumption findByPortfolioId(Long portfolioId) {
        String selectQuery = "SELECT BREAKOUT_ID, PORTFOLIO_ID, TYPE FROM CORE_ASSUMPTION WHERE PORTFOLIO_ID = ?";
        return super.query(selectQuery, (rs) -> {
            CoreAssumption c = new CoreAssumption();
            while(rs.next()) {
                c.setBreakoutId(rs.getLong(1));
                c.setPortfolioId(rs.getLong(2));
                c.setType(rs.getString(3));
                break;
            }
            return c;
        }, portfolioId);
    }

    @Transactional
    public void save(CoreAssumption c) {
        String insertQuery = "INSERT INTO CORE_ASSUMPTION (PORTFOLIO_ID, TYPE) VALUES (?, ?)";
        super.save(insertQuery, (pss) -> {
            pss.setLong(1, c.getPortfolioId());
            pss.setString(2, c.getType());
        });
    }
}
