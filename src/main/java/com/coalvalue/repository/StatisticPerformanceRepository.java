package com.coalvalue.repository;


import com.coalvalue.domain.entity.StatisticPerformance;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface StatisticPerformanceRepository extends BaseJpaRepository<StatisticPerformance, Integer> {


    StatisticPerformance findByItemIdAndItemTypeAndName(Integer companyId, String text, String text1);

    StatisticPerformance findById(Integer id);

    List<StatisticPerformance> findByItemIdAndItemType(Integer companyId, String text);

    StatisticPerformance findByItemIdAndItemTypeAndDigest(Integer id, String text, String digest);

    List<StatisticPerformance> findByItemTypeAndName(String text, String text1);
}
