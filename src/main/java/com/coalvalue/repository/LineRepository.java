package com.coalvalue.repository;


import com.coalvalue.domain.entity.Line;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Peter Xu on 09/24/2017.
 */
public interface LineRepository extends BaseJpaRepository<Line, Integer> {

    Line findByDepartureStationAndArrivalStation(Integer departureStation, Integer arrivalStation);

    Page<Line> findByDepartureStation(Integer departureStation, Pageable pageable);
}
