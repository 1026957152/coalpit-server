package com.coalvalue.repository;


import com.coalvalue.domain.entity.TimeStatistic;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TimeStatisticRepository extends BaseJpaRepository<TimeStatistic, Integer> {



    List<TimeStatistic> findByCreateDateAfter(Date s);

    Page<TimeStatistic> findAll(Pageable pageable);



    List<TimeStatistic> findByCreateDateBetween(Date start, Date end);

    TimeStatistic findTop1ByCreateDateBetweenOrderByCreateDateAsc(Date start, Date end);


}