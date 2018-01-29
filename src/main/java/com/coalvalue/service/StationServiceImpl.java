package com.coalvalue.service;

import com.coalvalue.domain.entity.Station;
import com.coalvalue.repository.StationRepository;
import com.coalvalue.web.valid.StationCreateForm;
import com.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
@Service("stationService")
public class StationServiceImpl extends BaseServiceImpl implements StationService {


    @Autowired
    private StationRepository stationRepository;


    private static final Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);



    @Override
    public Page<Station> queryStations(Integer userId, Pageable pageable) {
        return stationRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public Station create(StationCreateForm lineCreateForm) {

        Station line = new Station();
        line.setName(lineCreateForm.getName());
        line.setDescription(lineCreateForm.getDescription());
        line.setCompanyId(lineCreateForm.getCompanyId());
        line.setStatus(lineCreateForm.getStatus());
        line.setLocationId(lineCreateForm.getLocationId());
        line.setType(lineCreateForm.getType());


        return stationRepository.save(line);
    }

    @Override
    @Transactional
    public Station edit(StationCreateForm locationCreateForm) {


        Station line = stationRepository.findOne(locationCreateForm.getId());
        if(line != null){
            line.setName(locationCreateForm.getName());
            line.setDescription(locationCreateForm.getDescription());
            line.setName(locationCreateForm.getName());

            line.setCompanyId(locationCreateForm.getCompanyId());
            line.setStatus(locationCreateForm.getStatus());
            line.setLocationId(locationCreateForm.getLocationId());
            line.setType(locationCreateForm.getType());

            return stationRepository.save(line);
        }else{
            return null;
        }

    }

    @Override
    public List<Station> getStations() {
        return stationRepository.findAll();
    }

    @Override
    public Station getById(Integer index) {



        return stationRepository.findById(index);
    }

    @Override
    public Map getLocation(Station station) {


        Map map = new HashMap<>();

        map.put("longitude",station.getLongitude());
        map.put("latitude",station.getLatitude());
        return map;

    }

    @Override
    @Transactional
    public Station updateLongitudeLatitude(Station station, String longitude, String latitude) {
        station.setLongitude(longitude);
        station.setLatitude(latitude);
        return stationRepository.save(station);
    }

    @Override
    public List<Station> getByIds(List<Integer> ids) {
        return stationRepository.findByIdIn(ids);


    }


}
