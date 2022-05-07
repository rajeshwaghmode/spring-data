package com.java.learn.springframework.data.jdbc.repository;

import com.java.learn.springframework.data.jdbc.model.VectorAssumption;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VectorAssumptionJdbcRepository extends JdbcRepository {

    @Transactional
    public void save(VectorAssumption v) {
        String insertQuery = "INSERT INTO VECTOR_ASSUMPTION (BREAKOUT_ID, TENOR) VALUES (?, ?)";
        super.save(insertQuery, (pss) -> {
            pss.setLong(1, v.getBreakoutId());
            pss.setString(2, v.getTenor());
        });
    }
}
