package com.coalvalue.repository;


import com.coalvalue.domain.entity.Station;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by Peter Xu on 09/24/2017.
 */
public interface StationRepository extends BaseJpaRepository<Station, Integer> {

    Station findById(Integer index);

    List<Station> findByIdIn(List<Integer> ids);
}
