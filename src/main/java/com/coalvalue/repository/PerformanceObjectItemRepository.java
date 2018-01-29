package com.coalvalue.repository;


import com.coalvalue.domain.entity.PerformanceObjectItem;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PerformanceObjectItemRepository extends BaseJpaRepository<PerformanceObjectItem, Integer> {



    List<PerformanceObjectItem> findByItemId(Integer id);

    List<PerformanceObjectItem> findByObjectId(Integer id);

    List<PerformanceObjectItem> findByObjectIdAndType(Integer id, String text);


}
