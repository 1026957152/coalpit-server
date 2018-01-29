package com.coalvalue.repository;


import com.coalvalue.domain.entity.PerformanceInfo;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PerformanceInfoRepository extends BaseJpaRepository<PerformanceInfo, Integer> {



    List<PerformanceInfo> findByItemIdAndItemType(Integer id, String text);

    PerformanceInfo findByItemIdAndItemTypeAndName(Integer id, String text, String text1);

    List<PerformanceInfo> findByItemTypeAndName(String text, String text1);



}
