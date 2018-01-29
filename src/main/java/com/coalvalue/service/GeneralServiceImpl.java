package com.coalvalue.service;

import com.coalvalue.repository.CompanyRepository;
import com.coalvalue.web.*;
import com.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//import org.springframework.security.core.Authentication;

/**
 * Created by silence yuan on 2015/6/28.
 */
@Service("generalService")
public class GeneralServiceImpl extends BaseServiceImpl {

    @Autowired
    private CompanyRepository companyRepository;


    private static final Logger logger = LoggerFactory.getLogger(GeneralServiceImpl.class);





    public void setGeneral(ModelAndView modelAndView) {
        List<Map> links = new ArrayList<Map>();

        String locationsIndexUrl = linkTo(methodOn(MobileLocationController.class).index("")).withSelfRel().getHref();
        modelAndView.addObject("locationsIndexUrl",locationsIndexUrl);
        Map map = new HashMap();
        map.put("name", "locations");
        map.put("url", locationsIndexUrl);

        links.add(map);

        String tripsIndexUrl = linkTo(methodOn(MobileTripController.class).searchCompanies("")).withSelfRel().getHref();
        modelAndView.addObject("tripsIndexUrl",tripsIndexUrl);

        map = new HashMap();
        map.put("name", "trips");
        map.put("url", tripsIndexUrl);

        links.add(map);


        String stationsIndexUrl = linkTo(methodOn(MobileStationController.class).searchCompanies("")).withSelfRel().getHref();
        modelAndView.addObject("stationsIndexUrl",stationsIndexUrl);


        map = new HashMap();
        map.put("name", "stations");
        map.put("url", stationsIndexUrl);

        links.add(map);

        String linesIndexUrl = linkTo(methodOn(MobileLineController.class).searchCompanies("")).withSelfRel().getHref();
        modelAndView.addObject("linesIndexUrl",linesIndexUrl);


        map = new HashMap();
        map.put("name", "lines");
        map.put("url", linesIndexUrl);

        links.add(map);

        String linesSchedulesUrl = linkTo(methodOn(MobileLinesSchedulesController.class).index("")).withSelfRel().getHref();
        modelAndView.addObject("linesSchedulesUrl",linesSchedulesUrl);

        map = new HashMap();
        map.put("name", "linesSchedules");
        map.put("url", linesSchedulesUrl);

        links.add(map);



        modelAndView.addObject("links",links);


    }












}
