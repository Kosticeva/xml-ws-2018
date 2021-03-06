package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.TPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TPriceRepository extends JpaRepository<TPrice, Integer> {

    List<TPrice> findByStartDateBeforeAndEndDateAfter(Date startDateCopy, Date endDateCopy);
}
