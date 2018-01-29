package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;

import com.coalvalue.domain.entity.Equipment;
import com.coalvalue.web.valid.PlateRecognitionCreateForm;
import com.service.BaseService;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface PlateRecognitionService extends BaseService {



    OperationResult record(Equipment equipment, PlateRecognitionCreateForm canvassingCreateForm_);

}
