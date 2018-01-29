package com.service;

import com.coalvalue.domain.entity.PerformanceInfo;
import com.coalvalue.enumType.ResourceType;

import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface PerformanceService extends BaseService {



    PerformanceInfo operatePerformance(Integer id, ResourceType shipment, String total_order_count, Class integerClass, Object i);



    PerformanceInfo getPerformance(Integer id, ResourceType dealInstance, String text, Class bigDecimalClass);

    List<PerformanceInfo> findByItemIdAndItemType(Integer id, String text);

    List<PerformanceInfo> getPerformanceByItemTypeAndName(ResourceType company, String total_delivered_quantity);







}
