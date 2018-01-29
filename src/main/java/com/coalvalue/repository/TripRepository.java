package com.coalvalue.repository;

import com.coalvalue.domain.Trip;
import com.coalvalue.repository.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by Peter Xu on 10/02/2017.
 */
public interface TripRepository extends BaseJpaRepository<Trip, Integer> {

    List<Trip> findByLineId(Integer id);
}
