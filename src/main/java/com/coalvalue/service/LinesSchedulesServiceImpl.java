package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.ScheduleLinesSchedules;
import com.coalvalue.repository.LineRepository;
import com.coalvalue.repository.ScheduleLinesSchedulesRepository;
import com.coalvalue.web.valid.LinesSchedulesCreateForm;
import com.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
@Service("linesSchedulesService")
public class LinesSchedulesServiceImpl extends BaseServiceImpl implements LinesSchedulesService {



    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private ScheduleLinesSchedulesRepository scheduleLinesSchedulesRepository;


    private static final Logger logger = LoggerFactory.getLogger(LinesSchedulesServiceImpl.class);



    @Override
    public Page<ScheduleLinesSchedules> queryStations(Integer userId, Pageable pageable) {
        return scheduleLinesSchedulesRepository.findAll(pageable);
    }



    @Override
    @Transactional
    public ScheduleLinesSchedules create(LinesSchedulesCreateForm lineCreateForm) {

        ScheduleLinesSchedules line = new ScheduleLinesSchedules();
        line.setStatus(lineCreateForm.getStatus());
        line.setDescription(lineCreateForm.getDescription());
        line.setArrivalTime(lineCreateForm.getArrivalTime());
        line.setStatus(lineCreateForm.getStatus());
        line.setDepartureTime(lineCreateForm.getDepartureTime());



        return scheduleLinesSchedulesRepository.save(line);
    }

    @Override
    @Transactional
    public ScheduleLinesSchedules edit(LinesSchedulesCreateForm lineCreateForm) {


        ScheduleLinesSchedules line = scheduleLinesSchedulesRepository.findOne(lineCreateForm.getId());
        if(line == null){
            line = new ScheduleLinesSchedules();

            line.setStatus(lineCreateForm.getStatus());
            line.setDescription(lineCreateForm.getDescription());
            line.setArrivalTime(lineCreateForm.getArrivalTime());
            line.setStatus(lineCreateForm.getStatus());
            line.setDepartureTime(lineCreateForm.getDepartureTime());

            return scheduleLinesSchedulesRepository.save(line);
        }else{
            return null;
        }

    }

    @Override
    public OperationResult valid(LinesSchedulesCreateForm locationCreateForm) {
        OperationResult operationResult = new OperationResult();
        operationResult.setSuccess(false);

        ScheduleLinesSchedules line = null;//scheduleLinesSchedulesRepository.findByDepartureStationAndArrivalStation(locationCreateForm.getDepartureStation(), locationCreateForm.getArrivalStation());
        if(line != null){
            operationResult.setResultMessage("ERROR");
        }

        return operationResult;
    }


}
