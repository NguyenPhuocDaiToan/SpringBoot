package com.test;

import com.test.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    Page<History> findHistoriesByCreateDateBetweenAndPointAddGreaterThan(Pageable pageable, Date startDate,
                                                                           Date endDate, int point_add);
    Page<History> findHistoriesByCreateDateBetweenAndPointChangeGreaterThan(Pageable pageable, Date startDate,
                                                                           Date endDate, int point);
}
