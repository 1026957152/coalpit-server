package com.coalvalue.web;

import com.coalvalue.domain.ScheduleLinesSchedules;
import com.coalvalue.domain.Trip;
import com.coalvalue.domain.entity.Station;
import com.coalvalue.service.GeneralServiceImpl;
import com.coalvalue.service.LinesSchedulesService;
import com.coalvalue.service.StationService;
import com.coalvalue.service.TripService;
import com.coalvalue.web.valid.LinesSchedulesCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//import org.springframework.security.core.Authentication;

//import com.coalvalue.repositorySecondary.ProductRepository;

/**
 * Created by silence yuan on 2015/7/12.
 */

@Controller
@RequestMapping(value= {"/mobile/linesSchedules"})
public class MobileLinesSchedulesController {
    private static final Logger logger = LoggerFactory.getLogger(MobileLinesSchedulesController.class);




    @Autowired
    private StationService stationService;

    @Autowired
    private TripService tripService;

    @Autowired
    private GeneralServiceImpl generalService;

    @Autowired
    private LinesSchedulesService linesSchedulesService;


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "q", required = false) String searchTerm){//,Authentication authentication)  {


        ModelAndView modelAndView = new ModelAndView("/templates/lines_schedules_index");
        modelAndView.addObject("q",searchTerm);



        List<Trip> locationList = tripService.getTrips();

        modelAndView.addObject("trips",locationList);

        List<Station> stations = stationService.getStations();

        modelAndView.addObject("stations",stations);

        String companiesUrl = linkTo(methodOn(MobileLinesSchedulesController.class).stations("", null)).withSelfRel().getHref();
        modelAndView.addObject("linesSchedulesUrl",companiesUrl);
        String command_create_url = linkTo(methodOn(MobileLinesSchedulesController.class).create(null, null)).withSelfRel().getHref();
        modelAndView.addObject("command_create_url",command_create_url);


        String command_edit_url = linkTo(methodOn(MobileLinesSchedulesController.class).edit(null, null)).withSelfRel().getHref();
        modelAndView.addObject("command_edit_url",command_edit_url);



        generalService.setGeneral(modelAndView);


        return modelAndView;
    }




    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Page<ScheduleLinesSchedules> stations(@RequestParam(value = "q", required = false) String searchTerm, @PageableDefault Pageable pageable)  {



        return linesSchedulesService.queryStations(null,pageable);
    }





    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody

    public Map create(@Valid LinesSchedulesCreateForm locationCreateForm,
                                      Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);

        ScheduleLinesSchedules location = linesSchedulesService.create(locationCreateForm);
            if(location != null){


                ret.put("status", true);
            }


        return ret;

    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody

    public Map edit(@Valid LinesSchedulesCreateForm locationCreateForm,
                      Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);

        ScheduleLinesSchedules location = linesSchedulesService.edit(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }




}
