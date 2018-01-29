package com.coalvalue.web;


import com.coalvalue.domain.entity.Station;
import com.coalvalue.service.CompanyService;
import com.coalvalue.service.DeliveryAddressService;
import com.coalvalue.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by silence yuan on 2015/7/12.
 */

@Controller
@RequestMapping(value= {"/mobile/usercenter/map"})
public class MobileUserMapController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MobileUserMapController.class);



    @Autowired
    private CompanyService companyService;



    @Autowired
    private DeliveryAddressService deliveryAddressService;





    @Autowired
    private StationService stationService;






    @RequestMapping( value = "/map_config", method = RequestMethod.GET)
    public ModelAndView map_config(@RequestParam(value = "id", required = false) Integer index, Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("/templates/map_configuration");

            Station station = stationService.getById(index);

            Map location = stationService.getLocation(station);


            modelAndView.addObject("station",station);
            modelAndView.addObject("location",location);

            String updateLongitudeLatitudeUrl =   linkTo(methodOn(MobileUserMapController.class).updateLongitudeLatitude(station.getId(),null,null)).withSelfRel().getHref();
            modelAndView.addObject("updateLongitudeLatitudeUrl",updateLongitudeLatitudeUrl);




        return modelAndView;

    }



    @RequestMapping(value = "/command=updateLongitudeLatitude", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateLongitudeLatitude( @RequestParam(value = "id", required = false) Integer id,@RequestParam(value = "longitudeLatitude",required = false) String longitudeLatitude, Authentication authentication) {



        Map<String, Object> ret = new LinkedHashMap<String, Object>();
        Map<String, Object> result = new LinkedHashMap<String, Object>();



        Station station = stationService.getById(id);


        String[] parts = longitudeLatitude.split(",");
        String longitude = parts[0];
        String latitude = parts[1];
        station = stationService.updateLongitudeLatitude(station,longitude,latitude);



        result.put("companyName", station.getLatitude());
        result.put("abbreviationName", station.getLongitude());


        ret.put("result", result);

        ret.put("code", "0");
        return ret;
    }

}
