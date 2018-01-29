package com.service;


import com.coalvalue.domain.entity.PerformanceObject;
import com.coalvalue.domain.entity.PerformanceObjectItem;
import com.coalvalue.enumType.PerformanceAttationConditionItemEnum;
import com.coalvalue.enumType.PerformanceStatisticFunctionEnum;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.repository.PerformanceObjectItemRepository;
import com.coalvalue.repository.PerformanceObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("performanceObjectService")
public class PerformanceObjectServiceImpl extends BaseServiceImpl implements PerformanceObjectService {


    @Autowired
    private PerformanceObjectRepository performanceObjectRepository;

    @Autowired
    private PerformanceObjectItemRepository performanceObjectItemRepository;





    @Override
    @Transactional
    public PerformanceObject get(Integer id, ResourceType district, PerformanceStatisticFunctionEnum constructYulinmeiIndex) {
        PerformanceObject performanceObject = performanceObjectRepository.findByItemIdAndItemTypeAndFunction(id, district.getText(), constructYulinmeiIndex.getText());
        if(performanceObject == null){
            performanceObject = new PerformanceObject();
            performanceObject.setItemType(district.getText());
            performanceObject.setItemId(id);

            performanceObject.setFunction(constructYulinmeiIndex.getText());
            performanceObject = performanceObjectRepository.save(performanceObject);
        }
        return performanceObject;
    }

    @Override
    public List<PerformanceObjectItem> getItems(PerformanceObject performanceObject, PerformanceAttationConditionItemEnum districtCompany) {
        return performanceObjectItemRepository.findByObjectIdAndType(performanceObject.getId(), districtCompany.getText());
    }

    @Override
    public PerformanceObject get(PerformanceObject performance, String text) {
        PerformanceObject performanceObject = performanceObjectRepository.findByItemIdAndItemTypeAndName(performance.getId(), ResourceType.PERFORMANCE_OBJECT.getText(),text);
        if(performanceObject == null){
            performanceObject = new PerformanceObject();
            performanceObject.setItemType(ResourceType.PERFORMANCE_OBJECT.getText());
            performanceObject.setItemId(performance.getId());
            performanceObject.setName(text);
            performanceObject = performanceObjectRepository.save(performanceObject);
        }
        return performanceObject;
    }

    @Override
    public List<PerformanceObject> get(ResourceType district, PerformanceStatisticFunctionEnum constructYulinmeiIndex) {
        List<PerformanceObject> performanceObject = performanceObjectRepository.findByItemTypeAndFunction(district.getText(), constructYulinmeiIndex.getText());
        return performanceObject;

    }

    @Override
    public PerformanceObject getById(Integer id) {
        return performanceObjectRepository.findById(id);
    }


}
