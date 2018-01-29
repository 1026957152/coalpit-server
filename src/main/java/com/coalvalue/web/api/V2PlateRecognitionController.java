package com.coalvalue.web.api;


import com.coalvalue.domain.OperationResult;

import com.coalvalue.domain.entity.Equipment;
import com.coalvalue.domain.entity.PlateRecognition;


import com.coalvalue.service.EquipmentService;
import com.coalvalue.service.PlateRecognitionService;

import com.coalvalue.web.BaseController;

import com.coalvalue.web.valid.PlateRecognitionCreateForm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Map;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/api/v2/plateRecognition")
public class V2PlateRecognitionController extends BaseController {


    @Autowired
    private PlateRecognitionService plateRecognitionService;



    @Autowired
    private EquipmentService equipmentService;






    @RequestMapping(value = "/{capacityId}/plate", method = RequestMethod.POST)
    public ResponseEntity createCanvassing(@PathVariable(value = "capacityId",required = false) Integer capacityId,@RequestBody PlateRecognitionCreateForm canvassingCreateForm_) {
        logger.debug("param is: {}", canvassingCreateForm_.toString());


        Equipment equipment = equipmentService.getById(capacityId);




        OperationResult operationResult =  plateRecognitionService.record(equipment, canvassingCreateForm_);


        if(operationResult.isSuccess()){
            PlateRecognition plateRecognition = (PlateRecognition)operationResult.getResultObject();


            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plateRecognition.getId()).toUri();

            return ResponseEntity.created(location).build();
        }


        return null;




    }



}
