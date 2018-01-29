package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;

import com.coalvalue.domain.entity.Equipment;
import com.coalvalue.domain.entity.PlateRecognition;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.notification.NotificationData;

import com.coalvalue.repository.PlateRecognitionRepository;

import com.coalvalue.web.valid.PlateRecognitionCreateForm;
import com.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**
 * Created by silence yuan on 2015/7/25.
 */
@Service("plateRecognitionService")
public class PlateRecognitionServiceImpl extends BaseServiceImpl implements PlateRecognitionService {


    @Autowired
    private PlateRecognitionRepository plateRecognitionRepository;

    @Autowired
    EventBus eventBus;



    @Override
    public OperationResult record(Equipment equipment_, PlateRecognitionCreateForm canvassingCreateForm_) {


        PlateRecognition plateRecognition = new PlateRecognition();



        plateRecognition = plateRecognitionRepository.save(plateRecognition);


        NotificationData notificationData = new NotificationData();
  //      notificationData.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_EVENT);
        notificationData.setObject(plateRecognition);
        eventBus.notify("notificationConsumer", Event.wrap(notificationData));



        OperationResult operationResult = new OperationResult();
        operationResult.setResultObject(plateRecognition);
        operationResult.setSuccess(true);
        return operationResult;
    }
}
