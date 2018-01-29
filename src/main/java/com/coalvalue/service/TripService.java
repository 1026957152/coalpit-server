package com.coalvalue.service;

import com.coalvalue.domain.Trip;
import com.coalvalue.web.valid.TripCreateForm;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
public interface TripService extends BaseService {


    Page<Trip> queryStations(Integer userId, Pageable pageable);


    @Transactional
    Trip create(TripCreateForm lineCreateForm);

    @Transactional
    Trip edit(TripCreateForm locationCreateForm);

    List<Trip> getTrips();


}
