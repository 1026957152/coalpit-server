package com.coalvalue.service;

import com.coalvalue.domain.entity.Location;
import com.coalvalue.repository.LocationRepository;
import com.coalvalue.web.valid.LocationCreateForm;
import com.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
@Service("locationService")
public class LocationServiceImpl extends BaseServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;




    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);


    @Override
    public Page<Location> queryStations(Integer userId, Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Location create(LocationCreateForm lineCreateForm) {

        Location line = new Location();
        line.setName(lineCreateForm.getName());
        line.setDescription(lineCreateForm.getDescription());
        line.setCountryId(lineCreateForm.getCountryId());
        line.setPostalCode(lineCreateForm.getPostalCode());

        return locationRepository.save(line);
    }

    @Override
    @Transactional
    public Location edit(LocationCreateForm locationCreateForm) {


        Location line = locationRepository.findOne(locationCreateForm.getId());
        if(line != null){
            line.setName(locationCreateForm.getName());
            line.setDescription(locationCreateForm.getDescription());
            line.setCountryId(locationCreateForm.getCountryId());
            line.setPostalCode(locationCreateForm.getPostalCode());

            return locationRepository.save(line);
        }else{
            return null;
        }

    }

    @Override
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }


}
