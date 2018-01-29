package com.coalvalue.repository;


import com.coalvalue.domain.entity.TimeStatisticPerformance;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TimeStatisticPerformanceRepository extends BaseJpaRepository<TimeStatisticPerformance, Integer> {



    TimeStatisticPerformance findByTimeIdAndPerformanceId(Integer id, Integer id1);


    Page<TimeStatisticPerformance> findByPerformanceId(Integer id, Pageable pageRequest);

    List<TimeStatisticPerformance> findTop2ByTimeIdAndPerformanceIdOrderByCreateDateDesc(Integer id, Integer id1);

    List<TimeStatisticPerformance> findTop2ByPerformanceIdOrderByCreateDateDesc(Integer id);

}
