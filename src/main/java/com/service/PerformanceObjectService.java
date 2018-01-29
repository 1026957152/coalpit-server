package com.service;


import com.coalvalue.domain.entity.PerformanceObject;
import com.coalvalue.domain.entity.PerformanceObjectItem;
import com.coalvalue.enumType.PerformanceAttationConditionItemEnum;
import com.coalvalue.enumType.PerformanceStatisticFunctionEnum;
import com.coalvalue.enumType.ResourceType;

import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface PerformanceObjectService extends BaseService {



    PerformanceObject get(Integer id, ResourceType district, PerformanceStatisticFunctionEnum constructYulinmeiIndex);

    List<PerformanceObjectItem> getItems(PerformanceObject performanceObject, PerformanceAttationConditionItemEnum districtCompany);


    PerformanceObject get(PerformanceObject performanceObject, String text);


    List<PerformanceObject> get(ResourceType district, PerformanceStatisticFunctionEnum constructYulinmeiIndex);

    PerformanceObject getById(Integer id);
}
