package com.coalvalue.service;

import com.coalvalue.domain.entity.Station;
import com.coalvalue.web.valid.StationCreateForm;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
public interface StationService extends BaseService {



    Page<Station> queryStations(Integer userId, Pageable pageable);


    @Transactional
    Station create(StationCreateForm lineCreateForm);

    @Transactional
    Station edit(StationCreateForm locationCreateForm);

    List<Station> getStations();


    Station getById(Integer index);

    Map getLocation(Station station);

    Station updateLongitudeLatitude(Station station, String longitude, String latitude);


    List<Station> getByIds(List<Integer> ids);
}
