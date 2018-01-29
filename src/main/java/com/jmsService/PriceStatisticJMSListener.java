package com.jmsService;

import com.coalvalue.domain.entity.PerformanceInfo;
import com.coalvalue.domain.entity.PerformanceObject;
import com.coalvalue.domain.entity.PerformanceObjectItem;
import com.coalvalue.domain.entity.StatisticPerformance;

import com.coalvalue.enumType.*;

import com.service.PerformanceObjectService;
import com.service.PerformanceService;
import com.service.StatisticPerformanceService;
import com.service.StatisticPerformanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Component
public class PriceStatisticJMSListener extends JmsBaseService implements MessageListener  {
    @Autowired
    private StatisticPerformanceService statisticPerformanceService;

    @Autowired
    private PerformanceObjectService performanceObjectService;


    @Autowired
    private PerformanceService performanceService;



    public JmsTemplate getJmsTemplate() {
        return getJmsTemplate();
    }
        public void onMessage(Message message) {
            try {


                MapMessage mapMessage = (MapMessage) message;//jmsTemplate.receive(destination);

                EventEnum event = EventEnum.fromString(mapMessage.getString("event"));
                PerformanceStatisticFunctionEnum function = PerformanceStatisticFunctionEnum.fromString(mapMessage.getString("function"));

                logger.debug("event is {}, function is {} ", event.getDisplayText(), function.getDisplayText());
                if(event.equals(EventEnum.SOLR_CREATE_PRODUCT)){
                //    instance_price_change_rank(mapMessage);

                }
                if(event.equals(EventEnum.CAPACITY_APPLY_CREATE)){
                  //  add_path(mapMessage);

                }

                message.acknowledge();
            }
            catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }



/*    public Employee receiveMessage() throws JMSException {
        Map map = (Map) getJmsTemplate().receiveAndConvert();
        return new Employee((String) map.get("name"), (Integer) map.get("age"));
    }*/




    private void construct_yulinmei_index(MapMessage mapMessage) throws JMSException {



        Integer districtId = mapMessage.getInt("districtId");
        Integer companyId = mapMessage.getInt("companyId");
        Integer priceCategoryId = mapMessage.getInt("priceCategoryId");
        String productGranularity = mapMessage.getString("productGranularity");
        BigDecimal priceCategoryValue = new BigDecimal(mapMessage.getDouble("priceCategoryValue"));

        logger.debug("--------------- get message ", mapMessage.toString());
        logger.debug("--------------- get message districtId {} companyId{} priceCategoryId {} productGranularity{},priceCategoryValue {}",districtId,companyId,priceCategoryId, productGranularity,priceCategoryValue,mapMessage.toString());


        PerformanceObject performanceObject = performanceObjectService.get(districtId,ResourceType.DISTRICT,PerformanceStatisticFunctionEnum.CONSTRUCT_YULINMEI_INDEX);

        List<PerformanceObjectItem> performanceObjectItemrs = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_COMPANY);
        List<PerformanceObjectItem> performanceObjectItemrsGranularity = performanceObjectService.getItems(performanceObject,PerformanceAttationConditionItemEnum.DISTRICT_GRANULARITY);

        List<Integer> ids = performanceObjectItemrs.stream().map(e->e.getItemId()).collect(Collectors.toList());
        List<String> granularityIds = performanceObjectItemrsGranularity.stream().map(e -> e.getName()).collect(Collectors.toList());

        if(CoalSizeEnum.面煤.getText().equals(productGranularity)){
            logger.debug("---------- list PerformanceObjectItem {}, companyId:{}", ids.toArray(), companyId);
            if(ids.contains(companyId) && granularityIds.contains(CoalSizeEnum.fromString(productGranularity).getText())){

                PerformanceObject performanceObject1 = performanceObjectService.get(performanceObject, CoalSizeEnum.fromString(productGranularity).getText());
                logger.debug("-ids.contains(company.getId()  performanceObject1{} }", performanceObject1.toString());
                PerformanceInfo performanceInfo = performanceService.operatePerformance(performanceObject1.getId(), ResourceType.PERFORMANCE_OBJECT, PerformanceObject_Enum.Single.getText(),BigDecimal.class,priceCategoryValue);

                StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, BigDecimal.class);
                Map mapParam = new HashMap<>();

                mapParam.put("intValue",priceCategoryId);
                mapParam.put("decimalValue",priceCategoryValue);


                mapParam.put("id",companyId);
                Predicate<List<Integer>> matched = s -> !(s.contains(companyId));
                mapParam.put("matched",matched);

                mapParam.put("recordTrend",true);
                mapParam.put("recordItem",true);
                mapParam.put("trendMethod", StatisticPerformanceServiceImpl.CALCULATE_METHOD_avarage);
                mapParam.put("increment",priceCategoryValue);

                Map<Integer,BigDecimal> weights = performanceObjectItemrs.stream().collect(Collectors.toMap(PerformanceObjectItem::getItemId, c -> c.getWeight()));
                mapParam.put("weights",weights);
                statisticPerformanceService.setBigDecimalValueForPriceIndex(statisticPerformance, priceCategoryValue, mapParam);

            }

        }





        System.out.print("--------------------------MyProjectJMSListener is:");
    }




    private void INSTANCE_PRICE_BY_GRANULARITY_BY_AREA(MapMessage mapMessage) throws JMSException {



        Integer districtId = mapMessage.getInt("districtId");
        Integer companyId = mapMessage.getInt("companyId");
        Integer productId = mapMessage.getInt("productId");

        Integer priceCategoryId = mapMessage.getInt("priceCategoryId");
        String productGranularity = mapMessage.getString("productGranularity");
        BigDecimal priceCategoryValue = new BigDecimal(mapMessage.getDouble("priceCategoryValue"));

        logger.debug("--------------- get message ", mapMessage.toString());
        logger.debug("--------------- get message districtId {} companyId{} priceCategoryId {} productGranularity{},priceCategoryValue {}",districtId,companyId,priceCategoryId, productGranularity,priceCategoryValue,mapMessage.toString());


        PerformanceObject performanceObject = performanceObjectService.get(districtId,ResourceType.DISTRICT,PerformanceStatisticFunctionEnum.INSTANCE_PRICE_BY_GRANULARITY_BY_AREA);
        logger.debug("-------------------------------------------  performanceObject{} }", performanceObject.toString());
        List<PerformanceObjectItem> performanceObjectItemrs = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_COMPANY);
        List<PerformanceObjectItem> performanceObjectItemrsGranularity = performanceObjectService.getItems(performanceObject,PerformanceAttationConditionItemEnum.DISTRICT_GRANULARITY);

        List<Integer> ids = performanceObjectItemrs.stream().map(e->e.getItemId()).collect(Collectors.toList());
        List<String> granularityIds = performanceObjectItemrsGranularity.stream().map(e -> e.getName()).collect(Collectors.toList());



        logger.debug("---------- list PerformanceObjectItem {}, companyId:{}", ids.toArray(), companyId);
        // if(ids.contains(companyId) && granularityIds.contains(CoalSizeEnum.fromString(productGranularity).getText())){

        PerformanceObject performanceObject1 = performanceObjectService.get(performanceObject, CoalSizeEnum.fromString(productGranularity).getText());
        logger.debug("-ids.contains(company.getId()  performanceObject1{} }", performanceObject1.toString());


        PerformanceInfo performanceInfo = performanceService.operatePerformance(performanceObject1.getId(), ResourceType.PERFORMANCE_OBJECT, PerformanceObject_Enum.Single.getText(),BigDecimal.class,priceCategoryValue);

        StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, BigDecimal.class);
        Map mapParam = new HashMap<>();

        mapParam.put("intValue",priceCategoryId);
        mapParam.put("decimalValue",priceCategoryValue);


        mapParam.put("id",productId);
        Predicate<List<Integer>> matched = s -> !(s.contains(productId));
        mapParam.put("matched",matched);

        mapParam.put("recordTrend",true);
        mapParam.put("recordItem",true);
        mapParam.put("trendMethod", StatisticPerformanceServiceImpl.CALCULATE_METHOD_add);
        mapParam.put("increment",priceCategoryValue);

       // Map<Integer,BigDecimal> weights = performanceObjectItemrs.stream().collect(Collectors.toMap(PerformanceObjectItem::getItemId, c -> c.getWeight()));
        //mapParam.put("weights",weights);
        statisticPerformanceService.setBigDecimalValueForInstancePrice(statisticPerformance, priceCategoryValue, mapParam);





        System.out.print("--------------------------MyProjectJMSListener is:");
    }





    private void RECORD_COMPANY_STATUS(MapMessage mapMessage) throws JMSException {




        Integer companyId = mapMessage.getInt("companyId");



        String intendStatus = mapMessage.getString("intendStatus");
        String originalStatus = mapMessage.getString("originalStatus");
        Integer districtId = mapMessage.getInt("districtId");

        logger.debug("--------------- get message ", mapMessage.toString());

        PerformanceObject performanceObject = performanceObjectService.get(districtId,ResourceType.DISTRICT,PerformanceStatisticFunctionEnum.RECORD_COMPANY_STATUS);
        logger.debug("-------------------------------------------  performanceObject{} }", performanceObject.toString());

        List<PerformanceObjectItem> performanceObjectItemrs = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_COMPANY);
        List<PerformanceObjectItem> performanceObjectItemrsGranularity = performanceObjectService.getItems(performanceObject,PerformanceAttationConditionItemEnum.DISTRICT_GRANULARITY);

        List<Integer> ids = performanceObjectItemrs.stream().map(e->e.getItemId()).collect(Collectors.toList());
        List<String> granularityIds = performanceObjectItemrsGranularity.stream().map(e -> e.getName()).collect(Collectors.toList());

        logger.debug("---------- list PerformanceObjectItem {}, companyId:{}", ids.toArray(), companyId);
        // if(ids.contains(companyId) && granularityIds.contains(CoalSizeEnum.fromString(productGranularity).getText())){


        PerformanceObject performanceObject1 = performanceObjectService.get(performanceObject,intendStatus);
        logger.debug("-ids.contains(company.getId()  performanceObject1{} }", performanceObject1.toString());


        PerformanceInfo performanceInfo = performanceService.operatePerformance(performanceObject1.getId(), ResourceType.PERFORMANCE_OBJECT, PerformanceObject_Enum.Single.getText(),Integer.class,1);

        StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, Integer.class);
        Map mapParam = new HashMap<>();

        mapParam.put("intValue",companyId);
        mapParam.put("decimalValue",new BigDecimal(0));


        mapParam.put("id",companyId);
        Predicate<List<Integer>> matched = s -> !(s.contains(companyId));
        mapParam.put("matched",matched);

        mapParam.put("recordTrend",true);
        mapParam.put("recordItem",true);
        mapParam.put("trendMethod", StatisticPerformanceServiceImpl.CALCULATE_METHOD_add);
        //mapParam.put("increment",priceCategoryValue);


        statisticPerformanceService.setIntValueAndStoreItemMap(statisticPerformance, 1,1, mapParam);





        System.out.print("--------------------------MyProjectJMSListener is:");
    }


    private void INSTANCE_PRODUCT_STATUS_VARIATION(MapMessage mapMessage) throws JMSException {

        Integer productId = mapMessage.getInt("productId");

        String intendStatus = mapMessage.getString("intendStatus");
        String originalStatus = mapMessage.getString("originalStatus");
        Integer districtId = mapMessage.getInt("districtId");

        logger.debug("--------------- get message ", mapMessage.toString());

        PerformanceObject performanceObject = performanceObjectService.get(districtId,ResourceType.DISTRICT,PerformanceStatisticFunctionEnum.INSTANCE_PRODUCT_STATUS_VARIATION);
        logger.debug("-------------------------------------------  performanceObject{} }", performanceObject.toString());

        List<PerformanceObjectItem> performanceObjectItemrs = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_COMPANY);
        List<PerformanceObjectItem> performanceObjectItemrsGranularity = performanceObjectService.getItems(performanceObject,PerformanceAttationConditionItemEnum.DISTRICT_GRANULARITY);

        List<Integer> ids = performanceObjectItemrs.stream().map(e->e.getItemId()).collect(Collectors.toList());
        List<String> granularityIds = performanceObjectItemrsGranularity.stream().map(e -> e.getName()).collect(Collectors.toList());

        logger.debug("---------- list PerformanceObjectItem {}, productId:{}", ids.toArray(), productId);
        // if(ids.contains(productId) && granularityIds.contains(CoalSizeEnum.fromString(productGranularity).getText())){


        PerformanceObject performanceObject1 = performanceObjectService.get(performanceObject,intendStatus);
        logger.debug("-ids.contains(company.getId()  performanceObject1{} }", performanceObject1.toString());


        PerformanceInfo performanceInfo = performanceService.operatePerformance(performanceObject1.getId(), ResourceType.PERFORMANCE_OBJECT, PerformanceObject_Enum.Single.getText(),Integer.class,1);

        StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, Integer.class);
        Map mapParam = new HashMap<>();

        mapParam.put("intValue",productId);
        mapParam.put("decimalValue",new BigDecimal(0));


        mapParam.put("id",productId);
        Predicate<List<Integer>> matched = s -> !(s.contains(productId));
        mapParam.put("matched",matched);

        mapParam.put("recordTrend",true);
        mapParam.put("recordItem",true);
        mapParam.put("trendMethod", StatisticPerformanceServiceImpl.CALCULATE_METHOD_add);
        //mapParam.put("increment",priceCategoryValue);

        statisticPerformanceService.setIntValueAndStoreItemMap(statisticPerformance, 1,1, mapParam);

        System.out.print("--------------------------MyProjectJMSListener is:");
    }


    private void INSTANCE_INVENTORY_RANK(MapMessage mapMessage) throws JMSException {

        String granularity = mapMessage.getString("granularity");
        Double quantityOnHand = mapMessage.getDouble("quantityOnHand");
        Integer inventoryId = mapMessage.getInt("inventoryId");
        Integer districtId = mapMessage.getInt("districtId");

        BigDecimal variation = new BigDecimal(mapMessage.getDouble("variation"));



        logger.debug("--------------- get message ", mapMessage.toString());


        PerformanceObject performanceObject = performanceObjectService.get(districtId, ResourceType.DISTRICT, PerformanceStatisticFunctionEnum.INSTANCE_INVENTORY_RANK);


        List<PerformanceObjectItem> performanceObjectItemrs = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_COMPANY);
        List<PerformanceObjectItem> performanceObjectItemrsGranularity = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_GRANULARITY);

        List<Integer> ids = performanceObjectItemrs.stream().map(e -> e.getItemId()).collect(Collectors.toList());
        List<String> granularityIds = performanceObjectItemrsGranularity.stream().map(e -> e.getName()).collect(Collectors.toList());

      //  logger.debug("---------- list PerformanceObjectItem {}, companyId:{}", ids.toArray(), company.getId());
        //if (ids.contains(company.getId())) {

        logger.debug("---------- list performanceObject {}", performanceObject.toString());
        PerformanceObject performanceObject1 = performanceObjectService.get(performanceObject, CoalSizeEnum.fromString(granularity).getText());
        logger.debug("-ids.contains(company.getId()  performanceObject1{} }", performanceObject1.toString());
        PerformanceInfo performanceInfo = performanceService.operatePerformance(performanceObject1.getId(), ResourceType.PERFORMANCE_OBJECT, PerformanceObject_Enum.Single.getText(), BigDecimal.class, variation);

        StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, BigDecimal.class);
        Map mapParam = new HashMap<>();

        mapParam.put("intValue", inventoryId);
        mapParam.put("decimalValue", variation);


        mapParam.put("id", inventoryId);
        Predicate<List<Integer>> matched = s -> !(s.contains(inventoryId));
        mapParam.put("matched", matched);

        mapParam.put("recordTrend", true);
        mapParam.put("recordItem", true);
        mapParam.put("trendMethod", StatisticPerformanceServiceImpl.CALCULATE_METHOD_add);
        mapParam.put("increment", variation);
        statisticPerformanceService.setBigDecimalValueForInventory(statisticPerformance, variation, mapParam);
        System.out.print("--------------------------MyProjectJMSListener is:");
    }




    private void CONSTRUCT_ROUTE_AVERAGE_FREIGHT(MapMessage mapMessage)throws JMSException  {


        Integer routeId = mapMessage.getInt("routeId");
        Integer capacityId = mapMessage.getInt("capacityId");

        BigDecimal freight = new BigDecimal(mapMessage.getDouble("freight"));



        logger.debug("--------------- get message ", mapMessage.toString());


        PerformanceObject performanceObject = performanceObjectService.get(routeId, ResourceType.ROUTE, PerformanceStatisticFunctionEnum.CONSTRUCT_ROUTE_AVERAGE_FREIGHT);


        List<PerformanceObjectItem> performanceObjectItemrs = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_COMPANY);
        List<PerformanceObjectItem> performanceObjectItemrsGranularity = performanceObjectService.getItems(performanceObject, PerformanceAttationConditionItemEnum.DISTRICT_GRANULARITY);

        List<Integer> ids = performanceObjectItemrs.stream().map(e -> e.getItemId()).collect(Collectors.toList());
        List<String> granularityIds = performanceObjectItemrsGranularity.stream().map(e -> e.getName()).collect(Collectors.toList());

        //  logger.debug("---------- list PerformanceObjectItem {}, companyId:{}", ids.toArray(), company.getId());
        //if (ids.contains(company.getId())) {

        logger.debug("---------- list performanceObject {}", performanceObject.toString());
        PerformanceObject performanceObject1 = performanceObjectService.get(performanceObject, "freight");
        logger.debug("-ids.contains(company.getId()  performanceObject1{} }", performanceObject1.toString());
        PerformanceInfo performanceInfo = performanceService.operatePerformance(performanceObject1.getId(), ResourceType.PERFORMANCE_OBJECT, PerformanceObject_Enum.Single.getText(), BigDecimal.class, freight);

        StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, BigDecimal.class);
        Map mapParam = new HashMap<>();

        mapParam.put("intValue", routeId);
        mapParam.put("decimalValue", freight);


        mapParam.put("id", routeId);
        Predicate<List<Integer>> matched = s -> !(s.contains(routeId));
        mapParam.put("matched", matched);

        mapParam.put("recordTrend", true);
        mapParam.put("recordItem", true);
        mapParam.put("trendMethod", StatisticPerformanceServiceImpl.CALCULATE_METHOD_add);
        mapParam.put("increment", freight);
        statisticPerformanceService.setBigDecimalValueForRouteFreight(statisticPerformance, freight, mapParam);
        statisticPerformanceService.reduceInvetory(routeId,ResourceType.ROUTE,capacityId,freight,freight);
        System.out.print("--------------------------MyProjectJMSListener is:");

    }


    private void TOTAL_ROUTE(MapMessage mapMessage)throws JMSException  {


        Integer routeId = mapMessage.getInt("routeId");
        Integer capacityId = mapMessage.getInt("capacityId");

      //  BigDecimal freight = new BigDecimal(mapMessage.getDouble("freight"));

        logger.debug("--------------- get message ", mapMessage.toString());

        PerformanceInfo performanceInfo = performanceService.operatePerformance(routeId, ResourceType.ROUTE, PerformanceItem_Route_Enum.Total_count.getText(), Integer.class, 1);
        StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, Integer.class);
        statisticPerformanceService.setIntValue(statisticPerformance, 1, 1);
        System.out.print("--------------------------MyProjectJMSListener is:");

    }
    private void INSTANCE_USER_REGISTER(MapMessage mapMessage)throws JMSException  {


        Integer userId = mapMessage.getInt("userId");
        String userType = mapMessage.getString("userType");
        Integer companyId = mapMessage.getInt("companyId");


        //BigDecimal freight = new BigDecimal(mapMessage.getDouble("freight"));

        logger.debug("--------------- get message ", mapMessage.toString());


        PerformanceInfo performanceInfo = performanceService.operatePerformance(0, ResourceType.SYSTEM, PerformanceItem_System_Enum.USER_REGISTER.getText(), Integer.class, 1);
       // StatisticPerformance statisticPerformance = statisticPerformanceService.getStatisticByIdType(performanceInfo.getId(), ResourceType.PERFORMANCE_INFO, Integer.class);
      //  statisticPerformanceService.setIntValue(statisticPerformance, 1, 1);

        statisticPerformanceService.reduceInvetory(performanceInfo.getId(),ResourceType.PERFORMANCE_INFO,userId);
        System.out.print("--------------------------INSTANCE_USER_REGISTER is:");

    }
}