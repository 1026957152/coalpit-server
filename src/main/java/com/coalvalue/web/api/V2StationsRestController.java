package com.coalvalue.web.api;


import com.coalvalue.domain.BrandEnterprise;
import com.coalvalue.domain.entity.Station;
import com.coalvalue.enumType.BrandEnterpriseFeatureEnum;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.service.BrandEnterpriseService;
import com.coalvalue.service.StationService;
import com.coalvalue.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/api/v2/stations")
public class V2StationsRestController extends BaseController {


    @Autowired
    private StationService stationService;

    @Autowired
    private BrandEnterpriseService brandEnterpriseService;


    @Autowired
    private PagedResourcesAssembler<Map> pagedAssembler;


/*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource>  detail(@PathVariable("id") Integer orderId) {


        CargoCanvassing cargoCanvassing  =  cargoCanvassingService.queryCanvassingById(orderId);

        Resource<CargoCanvassing> resource = new Resource(cargoCanvassing);

        return new ResponseEntity<Resource>(resource, HttpStatus.OK);

    }*/


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object all(@PathVariable(value = "id") Integer id,Authentication authentication) {
        logger.debug("============ param is {}", id);


    //    LineDto lineDto = new LineDto();


        Station teamDeals = stationService.getById(id);
        Resource<Map> resource = new Resource(teamDeals);
        return new ResponseEntity<Resource>(resource, HttpStatus.OK);


    }




    @RequestMapping(value = "/featured", method = RequestMethod.GET)
    public Object getFeatureStations(/*@PathVariable(value = "id") Integer id*/) {
      //  logger.debug("============ param is {}", id);


        //    LineDto lineDto = new LineDto();
        List<BrandEnterprise> brandEnterpriseList = brandEnterpriseService.getEnterpriseByFeature(BrandEnterpriseFeatureEnum.BRAND_STATION);

        List<Integer> ids = brandEnterpriseList.stream().map(e->e.getItemId()).collect(Collectors.toList());

        List<Station> teamDeals = stationService.getByIds(ids);

        Resources<Map> resource = new Resources(teamDeals);
        return new ResponseEntity<Resources>(resource, HttpStatus.OK);


    }



    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public Object getFeatureStations(@RequestParam(value = "stationIds") Integer[] stationIds) {
        //  logger.debug("============ param is {}", id);


        List<Integer> ids = Arrays.asList(stationIds);
        List<Station> teamDeals = stationService.getByIds(ids);

        List<Map> maps = new ArrayList<>();
        for(Station location:teamDeals){
            Map map = new HashMap<>();

            map.put("longitude",location.getLongitude());
            map.put("latitude",location.getLatitude());
            map.put("name",location.getName());
            map.put("id",location.getId());
            maps.add(map);
        }
        Resources<Map> resource = new Resources(teamDeals);
        return new ResponseEntity<Resources>(resource, HttpStatus.OK);


    }


}
