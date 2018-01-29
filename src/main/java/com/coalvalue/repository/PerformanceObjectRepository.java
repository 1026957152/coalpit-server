package com.coalvalue.repository;


import com.coalvalue.domain.entity.PerformanceObject;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PerformanceObjectRepository extends BaseJpaRepository<PerformanceObject, Integer> {



    PerformanceObject findByItemIdAndItemType(Integer id, String text);

    List<PerformanceObject> findByItemType(String text);

    PerformanceObject findById(Integer id);


    List<PerformanceObject> findByItemTypeAndFunction(String text, String text1);

    PerformanceObject findByItemIdAndItemTypeAndFunction(Integer id, String text, String text1);

    PerformanceObject findByItemIdAndItemTypeAndName(Integer id, String text, String text1);
}
