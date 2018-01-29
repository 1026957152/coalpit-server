package com.coalvalue.web;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.entity.Line;
import com.coalvalue.service.GeneralServiceImpl;
import com.coalvalue.service.LineService;
import com.coalvalue.service.LocationService;
import com.coalvalue.web.valid.LineCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
@RequestMapping(value= {"/mobile/line"})
public class MobileLineController {
    private static final Logger logger = LoggerFactory.getLogger(MobileLineController.class);





    @Autowired
    private LocationService locationService;
    @Autowired
    private LineService lineService;



    @Autowired
    private GeneralServiceImpl generalService;


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView searchCompanies(@RequestParam(value = "q", required = false) String searchTerm){//,Authentication authentication)  {


        ModelAndView modelAndView = new ModelAndView("/templates/line_index");
        modelAndView.addObject("q",searchTerm);

        String companiesUrl = linkTo(methodOn(MobileLineController.class).stations("", null)).withSelfRel().getHref();
        modelAndView.addObject("stationsUrl",companiesUrl);
        generalService.setGeneral(modelAndView);



        List<Line> locationList = lineService.getLines();

        modelAndView.addObject("lines",locationList);

        String command_create_url = linkTo(methodOn(MobileLineController.class).create(null, null)).withSelfRel().getHref();
        modelAndView.addObject("command_create_url",command_create_url);


        String command_edit_url = linkTo(methodOn(MobileLineController.class).edit(null, null,null)).withSelfRel().getHref();
        modelAndView.addObject("command_edit_url",command_edit_url);
        return modelAndView;
    }




    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Page<Line> stations(@RequestParam(value = "q", required = false) String searchTerm, @PageableDefault Pageable pageable)  {



        return lineService.queryStations(null,pageable);
    }



    @RequestMapping(value = "/command=create", method = RequestMethod.GET)
    @ResponseBody
    public Object command_get_product_starage(@RequestParam(value = "id",required = true) Integer id,@RequestBody LineCreateForm lineCreateForm,Authentication authentication) {
        // jsmMessageService.sendStatisticMessage("editPrice");

        logger.debug("get_product_price_categories === param is : productId is :{} ", id);



   //     User user = (User) authentication.getPrincipal();







        Map<String, Object> map = new HashMap<String, Object>();

        map.put("code","0");
        map.put("desc","成功");


        List<Object> companyMap = new ArrayList<Object>();



        Line line = lineService.create(lineCreateForm);

        return line;
    }





    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody

    public Map create(@Valid LineCreateForm locationCreateForm,
                      Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);


        OperationResult operationResult = lineService.valid(locationCreateForm);
        if(!operationResult.isSuccess()){
            ret.put("message", operationResult.getErrorMessage());
        }



        Line location = lineService.create(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody

    public Map edit(@Valid LineCreateForm locationCreateForm, BindingResult bindingResult,
                    Authentication authentication) {

        logger.debug("----- param is  id : {},  price:{}, notificationToIds:{}, returnTo:{}，sendMessageToFollower is:{}", locationCreateForm.toString());

        Map ret = new HashMap<String, String>();
        ret.put("status", false);
        if(bindingResult.hasErrors()){
            ret.put("message", bindingResult.getAllErrors().toString());
        }


        Line location = lineService.edit(locationCreateForm);
        if(location != null){


            ret.put("status", true);
        }


        return ret;

    }
}
