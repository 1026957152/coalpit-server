package com.coalvalue.repository;


import com.coalvalue.domain.entity.TimeStatisticList;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TimeStatisticListRepository extends BaseJpaRepository<TimeStatisticList, Integer> {



  //  List<Integer> findIdByTimeId(Integer id);

    List<TimeStatisticList> findByTimeId(Integer id);

   // List<Integer> findItemIdByTimeId(Integer id);

    List<TimeStatisticList> findByTimeIdIn(List<Integer> ids);

    List<TimeStatisticList> findByTimeIdAndItemId(Integer id, Integer id1);

}
