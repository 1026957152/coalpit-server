package com.coalvalue.web;

import com.coalvalue.domain.entity.Location;
import com.coalvalue.domain.entity.Station;
import com.coalvalue.service.GeneralServiceImpl;
import com.coalvalue.service.LocationService;
import com.coalvalue.service.StationService;
import com.coalvalue.web.valid.StationCreateForm;
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
@RequestMapping(value= {"/mobile/stations"})
public class MobileStationController {
    private static final Logger logger = LoggerFactory.getLogger(MobileStationController.class);




    @Autowired
    private StationService stationService;


    @Autowired
    private LocationService locationService;

    @Autowired
    private GeneralServiceImpl generalService;



    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView searchCompanies(@RequestParam(value = "q", required = false) String searchTerm){//,Authentication authentication)  {


        ModelAndView modelAndView = new ModelAndView("/templates/station_index");
        modelAndView.addObject("q",searchTerm);

        String companiesUrl = linkTo(methodOn(MobileStationController.class).stations("", null)).withSelfRel().getHref();
        modelAndView.addObject("stationsUrl",companiesUrl);

        List<Location> locationList = locationService.getLocations();

        modelAndView.addObject("locations",locationList);
        generalService.setGeneral(modelAndView);





        String command_create_url = linkTo(methodOn(MobileStationController.class).create(null, null,null)).withSelfRel().getHref();
        modelAndView.addObject("command_create_url",command_create_url);


        String command_edit_url = linkTo(methodOn(MobileStationController.class).edit(null, null,null)).withSelfRel().getHref();
        modelAndView.addObject("command_edit_url",command_edit_url);


        String map_config_url = linkTo(methodOn(MobileUserMapController.class).map_config(null, null)).withSelfRel().getHref();
        modelAndView.addObject("map_config_url",map_config_url);



        return modelAndView;
    }




    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Page<Station> stations(@RequestParam(value = "q", required = false) String searchTerm, @PageableDefault Pageable pageable)  {



        return stationService.queryStations(null,pageable);
    }






    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody

    public Map create(@Valid StationCreateForm locationCreateForm,BindingResult bindingResult,
                      Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);

        if(bindingResult.hasErrors()){
            ret.put("message", bindingResult.getAllErrors().toString());
        }

        Station location = stationService.create(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody

    public Map edit(@Valid StationCreateForm locationCreateForm, BindingResult bindingResult,
                    Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);

        if(bindingResult.hasErrors()){
            ret.put("message", bindingResult.getAllErrors().toString());
        }
        Station location = stationService.edit(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }
}
