package com.service;

import com.coalvalue.domain.entity.PerformanceInfo;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.repository.PerformanceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("performanceService")
public class PerformanceServiceImpl extends BaseServiceImpl implements PerformanceService {



    @Autowired
    private PerformanceInfoRepository performanceInfoRepository;




    @Override
    @Transactional
    public PerformanceInfo operatePerformance(Integer id, ResourceType shipment, String total_order_count, Class integerClass, Object i) {
        PerformanceInfo coalOrder = performanceInfoRepository.findByItemIdAndItemTypeAndName(id, shipment.getText(), total_order_count);
        if(coalOrder == null){

            coalOrder = new PerformanceInfo();
            coalOrder.setIntValue(0);
            coalOrder.setDecimalValue(new BigDecimal(0));
            coalOrder.setItemId(id);
            coalOrder.setItemType(shipment.getText());
            coalOrder.setValueType(integerClass.getName());
            coalOrder.setName(total_order_count);

            coalOrder = performanceInfoRepository.save(coalOrder);
        }
        if(i instanceof Integer){
            coalOrder.setIntValue((Integer)i+coalOrder.getIntValue());

        }
        if(i instanceof BigDecimal){
            coalOrder.setDecimalValue(((BigDecimal) i).add(coalOrder.getDecimalValue()));

        }
        return performanceInfoRepository.save(coalOrder);
    }

/*    @Override
    public Map getPerformance(Integer id, ResourceType dealInstance, PerformanceItem_Deal_Enum total_oer_count) {
        List<PerformanceInfo> performanceInfoList =  performanceInfoRepository.findByItemIdAndItemType(id,dealInstance.getText());
        Map map = new HashMap<>();
        for(PerformanceInfo performanceInfo:performanceInfoList){
            map.put(PerformanceItem_Deal_Enum.fromString(performanceInfo.getName()).getText(),performanceInfo.getValueType().equals(Integer.class.getName())?performanceInfo.getIntValue():performanceInfo.getDecimalValue());
        }
        return map;
    }*/

    @Override
    @Transactional
    public PerformanceInfo getPerformance(Integer id, ResourceType dealInstance, String text,Class bigDecimalClass) {
        PerformanceInfo coalOrder = performanceInfoRepository.findByItemIdAndItemTypeAndName(id, dealInstance.getText(), text);
        if(coalOrder == null){

            coalOrder = new PerformanceInfo();
            coalOrder.setIntValue(0);
            coalOrder.setDecimalValue(new BigDecimal(0));
            coalOrder.setItemId(id);
            coalOrder.setItemType(dealInstance.getText());
            coalOrder.setValueType(bigDecimalClass.getName());
            coalOrder.setName(text);

            coalOrder = performanceInfoRepository.save(coalOrder);
        }
        return coalOrder;
    }

    @Override
    public List<PerformanceInfo> findByItemIdAndItemType(Integer id, String text) {
        List<PerformanceInfo> performanceInfoList =  performanceInfoRepository.findByItemIdAndItemType(id,text);

        return performanceInfoList;
    }

    @Override
    public List<PerformanceInfo> getPerformanceByItemTypeAndName(ResourceType company, String total_delivered_quantity) {
        List<PerformanceInfo> performanceInfoList =  performanceInfoRepository.findByItemTypeAndName(company.getText(),total_delivered_quantity);
        return  performanceInfoList;
    }

}
