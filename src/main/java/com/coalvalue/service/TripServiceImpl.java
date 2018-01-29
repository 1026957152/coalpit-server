package com.coalvalue.service;

import com.coalvalue.domain.Trip;
import com.coalvalue.repository.TripRepository;
import com.coalvalue.web.valid.TripCreateForm;
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
@Service("tripService")
//@Transactional(readOnly = true)
public class TripServiceImpl extends BaseServiceImpl implements TripService {



    @Autowired
    private TripRepository tripRepository;


    private static final Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);



    @Override
    public Page<Trip> queryStations(Integer userId, Pageable pageable) {
        return tripRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public Trip create(TripCreateForm lineCreateForm) {

        Trip line = new Trip();
        line.setArrivalTime(lineCreateForm.getArrivalTime());
        line.setDescription(lineCreateForm.getDescription());
        line.setDepartureTime(lineCreateForm.getDepartureTime());
        line.setStatus(lineCreateForm.getStatus());
        line.setLineId(lineCreateForm.getLineId());

        line.setOpenTopWagonPrice(lineCreateForm.getOpenTopWagonPrice());
        line.setFlatWagonPrice(lineCreateForm.getFlatWagonPrice());

        return tripRepository.save(line);
    }

    @Override
    @Transactional
    public Trip edit(TripCreateForm lineCreateForm) {


        Trip line = tripRepository.findOne(lineCreateForm.getId());
        if(line != null){
            line.setArrivalTime(lineCreateForm.getArrivalTime());
            line.setDescription(lineCreateForm.getDescription());
            line.setDepartureTime(lineCreateForm.getDepartureTime());
            line.setStatus(lineCreateForm.getStatus());
            line.setLineId(lineCreateForm.getLineId());


            return tripRepository.save(line);
        }else{
            return null;
        }

    }

    @Override
    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }





}
