package com.coalvalue.web.api;


import com.coalvalue.dto.LineDto;
import com.coalvalue.service.LineService;
import com.coalvalue.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/api/v2/lines")
public class V2LinesRestController extends BaseController {


    @Autowired
    private LineService lineService;

    @Autowired
    private PagedResourcesAssembler<Map> pagedAssembler;


/*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource>  detail(@PathVariable("id") Integer orderId) {


        CargoCanvassing cargoCanvassing  =  cargoCanvassingService.queryCanvassingById(orderId);

        Resource<CargoCanvassing> resource = new Resource(cargoCanvassing);

        return new ResponseEntity<Resource>(resource, HttpStatus.OK);

    }*/


    @RequestMapping(value = "/paged", method = RequestMethod.GET)
    public Object all( LineDto lineDto,@PageableDefault(sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable,Authentication authentication) {
        logger.debug("============ param is {}", lineDto.toString());


    //    LineDto lineDto = new LineDto();


        Page<Map> teamDeals = lineService.getMapPaged(lineDto,pageable);

/*
        long size = teamDeals.getSize();
        long number = teamDeals.getNumber();
        long totalElements = teamDeals.getTotalElements();
        long totalPages = totalElements / size;*/
        PagedResources<Resource<Map>> pagedResources = pagedAssembler.toResource(teamDeals);

        return pagedResources;//new HttpEntity<PagedResources<Resource>>(pagedResources);

    }


}
