package com.coalvalue.web;

import com.coalvalue.domain.Trip;
import com.coalvalue.domain.entity.Line;
import com.coalvalue.service.GeneralServiceImpl;
import com.coalvalue.service.LineService;
import com.coalvalue.service.TripService;
import com.coalvalue.web.valid.TripCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping(value= {"/mobile/trip"})
public class MobileTripController {
    private static final Logger logger = LoggerFactory.getLogger(MobileTripController.class);




    @Autowired
    private TripService tripService;

    @Autowired
    private LineService lineService;

    @Autowired
    private GeneralServiceImpl generalService;



    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView searchCompanies(@RequestParam(value = "q", required = false) String searchTerm){//,Authentication authentication)  {


        ModelAndView modelAndView = new ModelAndView("/templates/trip_index");
        modelAndView.addObject("q",searchTerm);

        String companiesUrl = linkTo(methodOn(MobileTripController.class).stations("", null)).withSelfRel().getHref();
        modelAndView.addObject("stationsUrl",companiesUrl);

        generalService.setGeneral(modelAndView);

        List<Line> locationList = lineService.getLines();

        modelAndView.addObject("lines",locationList);

        String command_create_url = linkTo(methodOn(MobileTripController.class).create(null, null)).withSelfRel().getHref();
        modelAndView.addObject("command_create_url",command_create_url);


        String command_edit_url = linkTo(methodOn(MobileTripController.class).edit(null, null,null)).withSelfRel().getHref();
        modelAndView.addObject("command_edit_url",command_edit_url);

        return modelAndView;
    }




    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Page<Trip> stations(@RequestParam(value = "q", required = false) String searchTerm, @PageableDefault Pageable pageable)  {



        return tripService.queryStations(null,pageable);
    }





    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody

    public Map create(@Valid TripCreateForm locationCreateForm,
                      Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);

        Trip location = tripService.create(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody

    public Map edit(@Valid TripCreateForm locationCreateForm, BindingResult bindingResult,
                    Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);

        if(bindingResult.hasErrors()){
            ret.put("message", bindingResult.getAllErrors().toString());
        }
        Trip location = tripService.edit(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }

}
