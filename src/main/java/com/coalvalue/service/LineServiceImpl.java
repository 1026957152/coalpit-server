package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.Trip;
import com.coalvalue.domain.entity.Line;
import com.coalvalue.domain.entity.Station;
import com.coalvalue.dto.LineDto;
import com.coalvalue.repository.CompanyRepository;
import com.coalvalue.repository.LineRepository;
import com.coalvalue.repository.StationRepository;
import com.coalvalue.repository.TripRepository;
import com.coalvalue.web.valid.LineCreateForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
@Service("lineService")
public class LineServiceImpl extends BaseServiceImpl implements LineService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private QualityInspectionService qualityInspectionService;


    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private LineRepository lineRepository;


    private static final Logger logger = LoggerFactory.getLogger(LineServiceImpl.class);



    @Override
    public Page<Line> queryStations(Integer userId, Pageable pageable) {
        return lineRepository.findAll(pageable);
    }



    @Override
    @Transactional
    public Line create(LineCreateForm lineCreateForm) {

        Line line = new Line();
        line.setLineName(lineCreateForm.getLineName());
        line.setDescription(lineCreateForm.getDescription());
        line.setArrivalStation(lineCreateForm.getArrivalStation());
        line.setStatus(lineCreateForm.getStatus());
        line.setDepartureStation(lineCreateForm.getDepartureStation());



        return lineRepository.save(line);
    }

    @Override
    @Transactional
    public Line edit(LineCreateForm lineCreateForm) {


        Line line = lineRepository.findOne(lineCreateForm.getId());
        if(line == null){
            line = new Line();
            line.setLineName(lineCreateForm.getLineName());
            line.setDescription(lineCreateForm.getDescription());
            line.setArrivalStation(lineCreateForm.getArrivalStation());
            line.setStatus(lineCreateForm.getStatus());
            line.setDepartureStation(lineCreateForm.getDepartureStation());


            return lineRepository.save(line);
        }else{
            return null;
        }

    }

    @Override
    public OperationResult valid(LineCreateForm locationCreateForm) {
        OperationResult operationResult = new OperationResult();
        operationResult.setSuccess(false);

        Line line = lineRepository.findByDepartureStationAndArrivalStation(locationCreateForm.getDepartureStation(), locationCreateForm.getArrivalStation());
        if(line != null){
            operationResult.setResultMessage("ERROR");

        }



        return operationResult;
    }


    @Override
    public List<Line> getLines() {
        return lineRepository.findAll();
    }

    @Override
    public Page<Map> getMapPaged(LineDto lineDto, Pageable pageable) {
        Page<Line> pages = lineRepository.findByDepartureStation(lineDto.getDepartureStation(),pageable);


        ObjectMapper m = new ObjectMapper();

        Page<Map> page = pages.map(new Converter<Line, Map>() {
            public Map convert(Line objectEntity) {


                Station station = stationRepository.findOne(objectEntity.getDepartureStation());

                Map map = new HashMap();
                map.put("departureStation",station.getName());


                station = stationRepository.findOne(objectEntity.getArrivalStation());

                map.put("arrivalStation",station.getName());

                map.put("lineName",objectEntity.getLineName());
                map.put("description",objectEntity.getDescription());
                map.put("status",objectEntity.getStatus());


                List<Map> tripMaps = new ArrayList<Map>();
                List<Trip> trips = tripRepository.findByLineId(objectEntity.getId());
                for(Trip trip:trips){
                    m.convertValue(trip,Map.class);
                    Map<String,Object> mappedObject = m.convertValue(trip,Map.class);
                    tripMaps.add(mappedObject);
                }

                map.put("trips",tripMaps);

                return map;
            }
        });

        return page;

    }


}
