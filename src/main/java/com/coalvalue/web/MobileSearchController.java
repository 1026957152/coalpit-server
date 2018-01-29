package com.coalvalue.web;

import com.coalvalue.domain.entity.CoalAddress;
import com.coalvalue.domain.entity.Company;

import com.coalvalue.enumType.InventoryStatusEnum;

import com.coalvalue.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
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
@RequestMapping(value= {"/mobile/solr/search"})
public class MobileSearchController {
    private static final Logger logger = LoggerFactory.getLogger(MobileSearchController.class);




    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProductService productService ;


    @Autowired
    private InventoryService inventoryService;


    @Autowired
    private DeliveryAddressService deliveryAddressService;



    @Autowired
    private QualityInspectionService qualityInspectionService;




   // @Autowired
  //  private MobileService mobileService;

    @Autowired
    private GeneralServiceImpl generalService;



    @RequestMapping(value = "/companyIndex", method = RequestMethod.GET)
    public ModelAndView searchCompanies(@RequestParam(value = "q", required = false) String searchTerm){//,Authentication authentication)  {


        ModelAndView modelAndView = new ModelAndView("/templates/bigsearch");
        modelAndView.addObject("q",searchTerm);
        //mobileService.setAuthenticationInfo(authentication,modelAndView);

        if (searchTerm != null) {
       //     companies = searchService.searchCompany(searchTerm);
        }
        String companiesUrl = linkTo(methodOn(MobileSearchController.class).searchCompany("",null)).withSelfRel().getHref();
        modelAndView.addObject("companiesUrl",companiesUrl);
        modelAndView.addObject("navIndex", "search");


        generalService.setGeneral(modelAndView);


        return modelAndView;
    }




    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    @ResponseBody
    public Map searchCompany(@RequestParam(value = "q", required = false) String searchTerm,@PageableDefault Pageable pageable)  {

        String[] strings = searchTerm.split(" ");

        searchTerm = searchTerm.replace(",","");
        logger.debug("----------------- param is :{}", searchTerm);
        if (searchTerm != null) {
            //     companies = searchService.searchCompany(searchTerm);
        }
        logger.debug("we are in search company");





        ObjectMapper oMapper = new ObjectMapper();
        List<Map> maps = new ArrayList<>();


        Map<String,Object> objectMap = new HashMap<>();

        objectMap.put("content",maps);
        return objectMap;
    }


}
