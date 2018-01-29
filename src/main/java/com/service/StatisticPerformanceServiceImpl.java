package com.service;



import com.coalvalue.domain.entity.*;
import com.coalvalue.enumType.InventoryTransferTypeEnum;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.enumType.StatisticPerformanceTypeEnum;
import com.coalvalue.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("statisticPerformanceService")
public class StatisticPerformanceServiceImpl extends BaseServiceImpl implements StatisticPerformanceService {



    public static String  CALCULATE_METHOD_avarage = "avarage";
    public static String  CALCULATE_METHOD_add = "add";


    @Autowired
    private StatisticPerformanceRepository statisticPerformanceRepository;
    @Autowired
    private ItemTransferEntryRepository inventoryTransferEntryRepository;
    @Autowired
    private InventoryTransferRepository inventoryTransferRepository;




    @Autowired
    private StatisticService statisticService;

    @Autowired
    private TimeStatisticPerformanceRepository timeStatisticPerformanceRepository;

    @Autowired
    private TimeStatisticListRepository timeStatisticListRepository;



    @Autowired
    private KeyNameRepository keyNameRepository;



    @Override
    public StatisticPerformance getCompanyStatistic(Integer companyId, StatisticPerformanceTypeEnum type, Class c) {

        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findByItemIdAndItemTypeAndName(companyId, ResourceType.COMPANY.getText(), type.getText());
        if(statisticPerformance == null){
            statisticPerformance = new StatisticPerformance();
            statisticPerformance.setItemType(ResourceType.COMPANY.getText());
            statisticPerformance.setItemId(companyId);
            statisticPerformance.setName(type.getText());
            statisticPerformance.setType(c.getName());
            statisticPerformance.setIntValue(0);

            statisticPerformanceRepository.save(statisticPerformance);
        }

        return statisticPerformance;
    }


    @Override
    @Transactional
    public StatisticPerformance setIntValue(StatisticPerformance statisticPerformance_, Integer value, Integer increment) {

        return setIntValueAndStoreItem(statisticPerformance_,value,increment,null);
    }


    @Override
    @Transactional
    public StatisticPerformance setIntValueAndStoreItem(StatisticPerformance statisticPerformance_, Integer value, Integer increment, Integer id) {
        Map map = null;
        if(id!= null){
            map = new HashMap<>();
            map.put("id",id);
        }

        return setIntValueAndStoreItemMap(statisticPerformance_,value,increment,map);
    }

    @Override
    @Transactional
    public StatisticPerformance setIntValueAndStoreItemMap(StatisticPerformance statisticPerformance_, Integer value, Integer increment, Map map) {

        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());

        statisticPerformance.setIntValue(value);


        if(increment != null){
            TimeStatistic statistic = statisticService.getCurrentTimeStatistic();
            TimeStatisticPerformance timeStatisticPerformance = timeStatisticPerformanceRepository.findByTimeIdAndPerformanceId(statistic.getId(),statisticPerformance.getId());
            if(timeStatisticPerformance == null){
                timeStatisticPerformance = new TimeStatisticPerformance();
                timeStatisticPerformance.setIntValue(0);
                timeStatisticPerformance.setPerformanceId(statisticPerformance.getId());
                timeStatisticPerformance.setTimeId(statistic.getId());


            }


            timeStatisticPerformance.setIntValue(timeStatisticPerformance.getIntValue() + increment);
            timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);



            if(map != null){
                Integer id = (Integer)map.get("id");
                Class type = (Class)map.get("type");
                Integer intValue = (Integer)map.get("intValue");
                BigDecimal decimalValue = (BigDecimal)map.get("decimalValue");
                Predicate<List<TimeStatisticList>> matched = (Predicate<List<TimeStatisticList>>)map.get("matched");

                List<TimeStatisticList> timeStatisticLists  = timeStatisticListRepository.findByTimeIdAndItemId(timeStatisticPerformance.getId(), id);


                List<Integer> ids = timeStatisticLists.stream().map(e -> e.getItemId()).collect(Collectors.toList());
                ids.forEach(e->logger.debug("list --- {}",e));
                logger.debug("--------- id {}",id);


              /*  if(matched == null){
                    matched = s -> s == id;
                }*/



                List<Integer> itemIds = timeStatisticLists.stream().map(e->e.getItemId()).collect(Collectors.toList());
                if(matched.test(timeStatisticLists)){
                    TimeStatisticList timeStatisticList = new TimeStatisticList();
                    timeStatisticList.setTimeId(timeStatisticPerformance.getId());
                    timeStatisticList.setItemId(id);

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticListRepository.save(timeStatisticList);
                }else{

                    TimeStatisticList timeStatisticList = null;
                    for(TimeStatisticList timeStatisticList1:timeStatisticLists){
                        if(timeStatisticList1.getItemId() == id){
                            timeStatisticList = timeStatisticList1;
                        }
                    }
                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticListRepository.save(timeStatisticList);


                }



            }




        }

        return statisticPerformanceRepository.save(statisticPerformance);
    }

    @Override
    @Transactional
    public StatisticPerformance setBigDecimalValue(StatisticPerformance statisticPerformance_, BigDecimal value, BigDecimal increment) {

        Map map = new HashMap<>();

        map.put("recordTrend",true);
        map.put("recordItem",false);
        map.put("trendMethod","add");
        map.put("increment",increment);
        return  setBigDecimalValue(statisticPerformance_,value,map);

    }

    @Override
    public StatisticPerformance setBigDecimalValue(StatisticPerformance statisticPerformance_, BigDecimal value, BigDecimal increment, Boolean method) {
        Map map = new HashMap<>();

        map.put("recordTrend",true);
        map.put("recordItem",false);

        if(method){
            map.put("trendMethod","add");
        }else{
            map.put("trendMethod","");
        }
        map.put("increment",increment);
        return  setBigDecimalValue(statisticPerformance_,value,map);
    }

    @Override
    @Transactional
    public StatisticPerformance setBigDecimalValue(StatisticPerformance statisticPerformance_, BigDecimal value ,Map map){
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());

        statisticPerformance.setDecimalValue(value);


        Boolean recordTrend = (Boolean)map.get("recordTrend");
        Boolean recordItem = (Boolean)map.get("recordItem");
        String trendMethod = (String)map.get("trendMethod");
        BigDecimal increment = (BigDecimal)map.get("increment");


        logger.debug("----setBigDecimalValue :param is : {}, statisticPerformance:{}", map,statisticPerformance.toString());
        if(recordTrend){


            TimeStatistic statistic = statisticService.getCurrentTimeStatistic();
            TimeStatisticPerformance timeStatisticPerformance = timeStatisticPerformanceRepository.findByTimeIdAndPerformanceId(statistic.getId(),statisticPerformance.getId());
            if(timeStatisticPerformance == null){
                timeStatisticPerformance = new TimeStatisticPerformance();
                timeStatisticPerformance.setDecimalValue(new BigDecimal(0));
                timeStatisticPerformance.setPerformanceId(statisticPerformance.getId());
                timeStatisticPerformance.setTimeId(statistic.getId());
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }


            if(recordItem){

                logger.debug("--------- recordItem   {}",recordItem);
                Integer id = (Integer)map.get("id");
                Class type = (Class)map.get("type");
                Integer intValue = (Integer)map.get("intValue");
                BigDecimal decimalValue = (BigDecimal)map.get("decimalValue");
                Predicate<List<Integer>> matched = (Predicate<List<Integer>>)map.get("matched");

                List<TimeStatisticList> itemIds  = timeStatisticListRepository.findByTimeId(timeStatisticPerformance.getId());


                List<Integer> ids = itemIds.stream().map(e -> e.getItemId()).collect(Collectors.toList());
                ids.forEach(e->logger.debug("list --- {}",e));
                logger.debug("--------- id {}",id);


                if(matched.test(ids)){

                    logger.debug("--------- 开始 ITEM 不存在， 新建 相关 item ");
                    TimeStatisticList timeStatisticList = new TimeStatisticList();
                    timeStatisticList.setTimeId(timeStatisticPerformance.getId());
                    timeStatisticList.setItemId(id);

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticList = timeStatisticListRepository.save(timeStatisticList);
                    logger.debug("--------- 结束 ITEM 不存在， 新建 相关 item   {}",timeStatisticList.toString());


                    Map map1 = new HashMap<>();
                    if(trendMethod.equals("avarage")){
                        map1.put("nbValues",itemIds.size()+1);
                    }

                    timeStatisticPerformance.setDecimalValue(trendMethod(trendMethod,timeStatisticPerformance.getDecimalValue(),increment,map1));
                    timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);

                }else{



                    TimeStatisticList timeStatisticList = itemIds.stream().filter(line -> line.getItemId().equals(id)).collect(Collectors.toList()).get(0);
                    logger.debug("--------- ITEM  存在，存在， 那么就更新一下 更新  {}",timeStatisticList.toString());

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticListRepository.save(timeStatisticList);

                }


            }else{
                Map map1 = new HashMap<>();
                if(trendMethod.equals(CALCULATE_METHOD_avarage)){
                    List<TimeStatisticList> itemIds  = timeStatisticListRepository.findByTimeIdAndItemId(timeStatisticPerformance.getId(), (Integer)map.get("id"));
                    map1.put("nbValues",itemIds.size()+1);
                }

                timeStatisticPerformance.setDecimalValue(trendMethod(trendMethod,timeStatisticPerformance.getDecimalValue(),increment,map1));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }
        }


        return statisticPerformanceRepository.save(statisticPerformance);


    }

    @Override
    @Transactional
    public StatisticPerformance setStringValue(StatisticPerformance statisticPerformance_, String value) {

        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());
        statisticPerformance.setStringValue(value);
        return statisticPerformanceRepository.save(statisticPerformance);
    }



    @Override
    @Transactional
    public StatisticPerformance setBooleanValue(StatisticPerformance statisticPerformance_, Boolean value) {
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());
        statisticPerformance.setBooleanValue(value);
        return statisticPerformanceRepository.save(statisticPerformance);
    }

    @Override
    public List getCompanyStatistic(Integer companyId) {

        List list = new ArrayList<>();
        List<StatisticPerformance> statisticPerformanceList = statisticPerformanceRepository.findByItemIdAndItemType(companyId, ResourceType.COMPANY.getText());
        Map map = new HashMap<>();

        for(StatisticPerformance statisticPerformance: statisticPerformanceList){
            map.put("name", StatisticPerformanceTypeEnum.fromString(statisticPerformance.getName()).getDisplayText());
            map.put("value",getValue(statisticPerformance));
            list.add(map);
        }

        return list;


    }


    @Override
    public List getStatistic(Integer itemId,ResourceType resourceType) {

        List list = new ArrayList<>();
        List<StatisticPerformance> statisticPerformanceList = statisticPerformanceRepository.findByItemIdAndItemType(itemId, resourceType.getText());


        for(StatisticPerformance statisticPerformance: statisticPerformanceList){
            Map map = new HashMap<>();
            if(statisticPerformance.getName().equals(StatisticPerformanceTypeEnum.digest.getText())){

                KeyName keyName = keyNameRepository.findByDigest(statisticPerformance.getDigest());
                map.put("name",keyName.getName());
                map.put("value",getValue(statisticPerformance));
            }else{
                map.put("name", StatisticPerformanceTypeEnum.fromString(statisticPerformance.getName()).getDisplayText());
                map.put("value",getValue(statisticPerformance));
            }


            list.add(map);
        }

        return list;


    }

    @Override
    @Transactional
    public StatisticPerformance getStatistic(Integer id, ResourceType collaborator, StatisticPerformanceTypeEnum collaborator_transport_issued_count,Class integerClass) {
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findByItemIdAndItemTypeAndName(id, collaborator.getText(), collaborator_transport_issued_count.getText());
        if(statisticPerformance == null){
            statisticPerformance = new StatisticPerformance();
            statisticPerformance.setItemType(collaborator.getText());
            statisticPerformance.setItemId(id);
            statisticPerformance.setName(collaborator_transport_issued_count.getText());
            statisticPerformance.setType(integerClass.getName());
            statisticPerformance.setIntValue(0);

            statisticPerformance.setDecimalValue(new BigDecimal(0));
            statisticPerformanceRepository.save(statisticPerformance);
        }

        return statisticPerformance;
    }


    @Override
    @Transactional
    public StatisticPerformance getStatisticByDigestType(Integer id, ResourceType collaborator, String digest, Class integerClass) {
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findByItemIdAndItemTypeAndDigest(id, collaborator.getText(), digest);
        if(statisticPerformance == null){
            statisticPerformance = new StatisticPerformance();
            statisticPerformance.setItemType(collaborator.getText());
            statisticPerformance.setItemId(id);
            statisticPerformance.setName(StatisticPerformanceTypeEnum.digest.getText());
            statisticPerformance.setDigest(digest);
            statisticPerformance.setType(integerClass.getName());
            statisticPerformance.setIntValue(0);
            statisticPerformance.setDecimalValue(new BigDecimal(0));
            statisticPerformanceRepository.save(statisticPerformance);
        }

        return statisticPerformance;
    }

    @Override
    @Transactional
    public String getPwd(String name, String s) {
        String md5 = md5(s);
        KeyName keyName = keyNameRepository.findByDigest(md5);

        if(keyName == null){
            keyName = new KeyName();
            keyName.setDigest(md5);
            keyName.setName(name);
            keyNameRepository.save(keyName);
        }
        return keyName.getDigest();
    }

    @Override
    public List<TimeStatisticPerformance> getTopNByTypeAndItemId(int limit, ResourceType company, StatisticPerformanceTypeEnum company_sales_total_quantity, Integer itemId) {

        logger.debug("limit {}, itemID {}", limit, itemId);
        Sort sort = new Sort(Sort.Direction.ASC, "createDate");//

        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findByItemIdAndItemTypeAndName(itemId,company.getText(),company_sales_total_quantity.getText());

        Page<TimeStatisticPerformance> timeStatistics = timeStatisticPerformanceRepository.findByPerformanceId(statisticPerformance.getId(),new PageRequest(0, limit, sort));

        List<Integer> ids = new ArrayList<Integer>();
        for(TimeStatisticPerformance timeStatistic : timeStatistics){
            ids.add(timeStatistic.getId());
            logger.debug("=== timeStatistic is :{}", timeStatistic.toString());
        }


        return timeStatistics.getContent();
    }

    @Override
    public List<TimeStatisticPerformance> getTopNByStatisticPerformance(int limit, StatisticPerformance statisticPerformance) {

        logger.debug("limit {}, statisticPerformance {}", limit,statisticPerformance.toString());
        Sort sort = new Sort(Sort.Direction.ASC, "createDate");//

        Page<TimeStatisticPerformance> timeStatistics = timeStatisticPerformanceRepository.findByPerformanceId(statisticPerformance.getId(),new PageRequest(0, limit, sort));

        List<Integer> ids = new ArrayList<Integer>();
        for(TimeStatisticPerformance timeStatistic : timeStatistics){
            ids.add(timeStatistic.getId());
            logger.debug("=== timeStatistic is :{}", timeStatistic.toString());
        }


        return timeStatistics.getContent();
    }


    @Override
    public List<StatisticPerformance> getStatistic(ResourceType district, StatisticPerformanceTypeEnum district_avarage_price) {
        List<StatisticPerformance> statisticPerformances = statisticPerformanceRepository.findByItemTypeAndName(district.getText(), district_avarage_price.getText());
       return statisticPerformances;
    }

    @Override
    public String getKeyNameByDigest(String digest) {
        return keyNameRepository.findByDigest(digest).getName();
    }

    @Override
    public StatisticPerformance getById(Integer companyId) {
        return statisticPerformanceRepository.findById(companyId);
    }

    @Override
    public List<TimeStatisticList> getTimeStatisticList(Integer id) {
        List<TimeStatisticList> itemIds  = timeStatisticListRepository.findByTimeId(id);

        return itemIds;
    }

    @Override
    @Transactional
    public StatisticPerformance getStatisticByIdType(Integer id, ResourceType performanceInfo, Class integerClass) {
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findByItemIdAndItemTypeAndName(id, performanceInfo.getText(), StatisticPerformanceTypeEnum.ID.getText());
        if(statisticPerformance == null){
            statisticPerformance = new StatisticPerformance();
            statisticPerformance.setItemType(performanceInfo.getText());
            statisticPerformance.setItemId(id);
            statisticPerformance.setName(StatisticPerformanceTypeEnum.ID.getText());

            statisticPerformance.setType(integerClass.getName());
            statisticPerformance.setIntValue(0);
            statisticPerformance.setDecimalValue(new BigDecimal(0));
            statisticPerformanceRepository.save(statisticPerformance);
        }

        return statisticPerformance;
    }

    @Override
    public List<TimeStatisticList> getTimeStatisticItemRecords(List<TimeStatisticPerformance> records) {
        List<Integer> ids = records.stream().map(e-> e.getId()).collect(Collectors.toList());
        return timeStatisticListRepository.findByTimeIdIn(ids);
    }

    private Object getValue(StatisticPerformance statisticPerformance) {

        if(statisticPerformance.getType().equals(String.class.getName())){
            return  statisticPerformance.getStringValue();
        }
        if(statisticPerformance.getType().equals(Integer.class.getName())){
            return  statisticPerformance.getIntValue();
        }
        if(statisticPerformance.getType().equals(Boolean.class.getName())){
            return statisticPerformance.getBooleanValue();
        }
        if(statisticPerformance.getType().equals(BigDecimal.class.getName())){
            return statisticPerformance.getDecimalValue();
        }
        return null;
    }
    public static String md5(String str){
        String pwd = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            pwd = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pwd;
    }






    public BigDecimal trendMethod(String method, BigDecimal oldValue, BigDecimal increment, Map map) {


        logger.debug(" method :{}, oldValue :{}, increment :{}, map {}", method,oldValue,increment,map.toString());
        if(method.equals("add")){
            return oldValue.add(increment);
        }else if(method.equals("avarage")){
            BigDecimal average = oldValue;

            Integer nbValues = (Integer)map.get("nbValues");
            average = average.add((increment.subtract(average)).divide(new BigDecimal(nbValues),4,BigDecimal.ROUND_HALF_UP));
            return average;
        }else{
            return increment;
        }


    }









    @Override
    @Transactional
    public StatisticPerformance setBigDecimalValueForPriceIndex(StatisticPerformance statisticPerformance_, BigDecimal value, Map map){
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());

        statisticPerformance.setDecimalValue(value);


        Boolean recordTrend = (Boolean)map.get("recordTrend");
        Boolean recordItem = (Boolean)map.get("recordItem");
        String trendMethod = (String)map.get("trendMethod");
        BigDecimal increment = (BigDecimal)map.get("increment");
        Map<Integer,BigDecimal> weights = (Map)map.get("weights");

        for(Map.Entry<Integer,BigDecimal>  entry: weights.entrySet()){
            logger.debug("----------- weight content is :{},{}", entry.getKey(),entry.getValue());
        }


        logger.debug("----setBigDecimalValue :param is : {}, statisticPerformance:{}", map,statisticPerformance.toString());
        if(recordTrend){


            TimeStatistic statistic = statisticService.getCurrentTimeStatistic();

            TimeStatisticPerformance timeStatisticPerformance = timeStatisticPerformanceRepository.findByTimeIdAndPerformanceId(statistic.getId(),statisticPerformance.getId());

            if(timeStatisticPerformance == null){
                timeStatisticPerformance = new TimeStatisticPerformance();
                timeStatisticPerformance.setDecimalValue(new BigDecimal(0));
                timeStatisticPerformance.setPerformanceId(statisticPerformance.getId());
                timeStatisticPerformance.setTimeId(statistic.getId());
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }


            if(recordItem){

                logger.debug("--------- recordItem   {}",recordItem);
                Integer id = (Integer)map.get("id");
                Class type = (Class)map.get("type");
                Integer intValue = (Integer)map.get("intValue");
                BigDecimal decimalValue = (BigDecimal)map.get("decimalValue");
                Predicate<List<Integer>> matched = (Predicate<List<Integer>>)map.get("matched");

                List<TimeStatisticList> timeStatisticLists  = timeStatisticListRepository.findByTimeId(timeStatisticPerformance.getId());


                List<Integer> ids = timeStatisticLists.stream().map(e -> e.getItemId()).collect(Collectors.toList());
                ids.forEach(e->logger.debug("list --- {}",e));
                logger.debug("--------- id {}",id);

                TimeStatisticList timeStatisticList = null;
                if(matched.test(ids)){

                    logger.debug("--------- 开始 ITEM 不存在， 新建 相关 item ");
                    timeStatisticList = new TimeStatisticList();
                    timeStatisticList.setTimeId(timeStatisticPerformance.getId());
                    timeStatisticList.setItemId(id);

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticList = timeStatisticListRepository.save(timeStatisticList);
                    logger.debug("--------- 结束 ITEM 不存在， 新建 相关 item   {}",timeStatisticList.toString());

                    timeStatisticLists.add(timeStatisticList);
                }else{
                    timeStatisticList = timeStatisticLists.stream().filter(line -> line.getItemId().equals(id)).collect(Collectors.toList()).get(0);

                }



                BigDecimal todayTotalWeight = new BigDecimal(0);
                for(TimeStatisticList statisticList: timeStatisticLists){
                    todayTotalWeight = todayTotalWeight.add(weights.get(statisticList.getItemId()));

                    logger.debug("------ todayTotalWeight :{}", todayTotalWeight);
                }
                logger.debug("------ recoard item :{}", timeStatisticLists.stream().map(e->e.getItemId()).collect(Collectors.toList()).toArray());
                logger.debug("------ todayTotalWeight :{}", todayTotalWeight);



                BigDecimal average = new BigDecimal(0);

                for(TimeStatisticList statisticList: timeStatisticLists){


                    if(statisticList.getItemId() == timeStatisticList.getItemId()){
                        statisticList.setDecimalValue(decimalValue);
                    }
                    logger.debug("-------------- ITEM  :{}", statisticList.getItemId());
                    if(weights.get(statisticList.getItemId())!= null){
                        BigDecimal weightedWeight = weights.get(statisticList.getItemId()).divide(todayTotalWeight,4,BigDecimal.ROUND_HALF_UP);
                        logger.debug("-------------- ITEM  weightedWeight is :{}", weightedWeight);
                        average =average.add(statisticList.getDecimalValue().multiply(weightedWeight));
                    }else{
                        logger.error("----------------------------------------- 没有找到 权重");
                    }

                }

                logger.debug("-------------- total   average valeu is :{}", average);
                timeStatisticList.setDecimalValue(decimalValue);
                timeStatisticList.setIntValue(intValue);
                timeStatisticListRepository.save(timeStatisticList);
                logger.debug("--------- ITEM  存在，存在， 那么就更新一下 更新  {}",timeStatisticList.toString());






                List<TimeStatisticPerformance> timeStatisticPerformances = timeStatisticPerformanceRepository.findTop2ByPerformanceIdOrderByCreateDateDesc(statisticPerformance.getId());

                TimeStatisticPerformance preTimeStatisticPerformance = null;
                if(timeStatisticPerformances.size() == 2){

                    preTimeStatisticPerformance = timeStatisticPerformances.get(1);

                    logger.debug("--------- size is {}",timeStatisticPerformances.size() );
                    logger.debug("--------- preTimeStatisticPerformance is {}",preTimeStatisticPerformance.toString() );

                }else if(timeStatisticPerformances.size() == 1){

                    logger.debug("--------- size is {}",timeStatisticPerformances.size() );

                }
                if(preTimeStatisticPerformance != null){
                    List<TimeStatisticList> preTimeStatisticLists  = timeStatisticListRepository.findByTimeId(preTimeStatisticPerformance.getId());



                    BigDecimal preWeightSum = new BigDecimal(0);
                    for(TimeStatisticList timeStatisticList1: preTimeStatisticLists){
                        preWeightSum =preWeightSum.add(weights.get(timeStatisticList1.getItemId()));
                    }

                    BigDecimal preAndTodayWeightSum = todayTotalWeight.add(preWeightSum);

                    logger.debug("------- 与 昨天（上一个周期） 的  加权平均  {}",timeStatisticList.toString());
                    average = preTimeStatisticPerformance.getDecimalValue().multiply(preWeightSum.divide(preAndTodayWeightSum,4,BigDecimal.ROUND_HALF_UP)).add(average.multiply(preWeightSum.divide(preAndTodayWeightSum,4,BigDecimal.ROUND_HALF_UP)));
                    timeStatisticPerformance.setDecimalValue(average);
                }
                timeStatisticPerformance.setDecimalValue(average);
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);




            }else{
                Map map1 = new HashMap<>();
                if(trendMethod.equals(CALCULATE_METHOD_avarage)){
                    List<TimeStatisticList> itemIds  = timeStatisticListRepository.findByTimeIdAndItemId(timeStatisticPerformance.getId(), (Integer)map.get("id"));
                    map1.put("nbValues",itemIds.size()+1);
                }
                //preTimeStatisticPerformance =



                timeStatisticPerformance.setDecimalValue(trendMethod(trendMethod,timeStatisticPerformance.getDecimalValue(),increment,map1));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }
        }


        return statisticPerformanceRepository.save(statisticPerformance);


    }




    @Override
    @Transactional
    public StatisticPerformance setBigDecimalValueForInstancePrice(StatisticPerformance statisticPerformance_, BigDecimal value, Map map){
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());

        statisticPerformance.setDecimalValue(value);


        Boolean recordTrend = (Boolean)map.get("recordTrend");
        Boolean recordItem = (Boolean)map.get("recordItem");
        String trendMethod = (String)map.get("trendMethod");
        BigDecimal increment = (BigDecimal)map.get("increment");




        logger.debug("----setBigDecimalValue :param is : {}, statisticPerformance:{}", map,statisticPerformance.toString());
        if(recordTrend){


            TimeStatistic statistic = statisticService.getCurrentTimeStatistic();
            TimeStatisticPerformance timeStatisticPerformance = timeStatisticPerformanceRepository.findByTimeIdAndPerformanceId(statistic.getId(),statisticPerformance.getId());
            if(timeStatisticPerformance == null){
                timeStatisticPerformance = new TimeStatisticPerformance();
                timeStatisticPerformance.setDecimalValue(new BigDecimal(0));
                timeStatisticPerformance.setPerformanceId(statisticPerformance.getId());
                timeStatisticPerformance.setTimeId(statistic.getId());
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }


            if(recordItem){

                logger.debug("--------- recordItem   {}",recordItem);
                Integer id = (Integer)map.get("id");
                Class type = (Class)map.get("type");
                Integer intValue = (Integer)map.get("intValue");
                BigDecimal decimalValue = (BigDecimal)map.get("decimalValue");
                Predicate<List<Integer>> matched = (Predicate<List<Integer>>)map.get("matched");

                List<TimeStatisticList> timeStatisticLists  = timeStatisticListRepository.findByTimeId(timeStatisticPerformance.getId());


                List<Integer> ids = timeStatisticLists.stream().map(e -> e.getItemId()).collect(Collectors.toList());
                ids.forEach(e->logger.debug("list --- {}",e));
                logger.debug("--------- id {}",id);

                TimeStatisticList timeStatisticList = null;
                if(matched.test(ids)){

                    logger.debug("--------- 开始 ITEM 不存在， 新建 相关 item ");
                    timeStatisticList = new TimeStatisticList();
                    timeStatisticList.setTimeId(timeStatisticPerformance.getId());
                    timeStatisticList.setItemId(id);

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticList = timeStatisticListRepository.save(timeStatisticList);
                    logger.debug("--------- 结束 ITEM 不存在， 新建 相关 item   {}",timeStatisticList.toString());




                    timeStatisticLists.add(timeStatisticList);
                }else{
                    timeStatisticList = timeStatisticLists.stream().filter(line -> line.getItemId().equals(id)).collect(Collectors.toList()).get(0);

                }







                for(TimeStatisticList statisticList: timeStatisticLists){


                    if(statisticList.getItemId() == timeStatisticList.getItemId()){
                        statisticList.setDecimalValue(decimalValue);
                    }
                    logger.debug("-------------- ITEM  :{}", statisticList.getItemId());


                }


                timeStatisticList.setDecimalValue(decimalValue);
                timeStatisticList.setIntValue(intValue);
                timeStatisticListRepository.save(timeStatisticList);
                logger.debug("--------- ITEM  存在，存在， 那么就更新一下 更新  {}",timeStatisticList.toString());


                timeStatisticPerformance.setDecimalValue(timeStatisticPerformance.getDecimalValue().add(increment));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);




            }else{

                timeStatisticPerformance.setDecimalValue(timeStatisticPerformance.getDecimalValue().add(increment));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }
        }


        return statisticPerformanceRepository.save(statisticPerformance);


    }




    @Override
    @Transactional
    public StatisticPerformance setBigDecimalValueForInventory(StatisticPerformance statisticPerformance_, BigDecimal value, Map map){
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());

        statisticPerformance.setDecimalValue(value);


        Boolean recordTrend = (Boolean)map.get("recordTrend");
        Boolean recordItem = (Boolean)map.get("recordItem");
        String trendMethod = (String)map.get("trendMethod");
        BigDecimal increment = (BigDecimal)map.get("increment");




        logger.debug("----setBigDecimalValue :param is : {}, statisticPerformance:{}", map,statisticPerformance.toString());
        if(recordTrend){


            TimeStatistic statistic = statisticService.getCurrentTimeStatistic();
            TimeStatisticPerformance timeStatisticPerformance = timeStatisticPerformanceRepository.findByTimeIdAndPerformanceId(statistic.getId(),statisticPerformance.getId());
            if(timeStatisticPerformance == null){
                timeStatisticPerformance = new TimeStatisticPerformance();
                timeStatisticPerformance.setDecimalValue(new BigDecimal(0));
                timeStatisticPerformance.setPerformanceId(statisticPerformance.getId());
                timeStatisticPerformance.setTimeId(statistic.getId());
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }


            if(recordItem){

                logger.debug("--------- recordItem   {}",recordItem);
                Integer id = (Integer)map.get("id");
                Class type = (Class)map.get("type");
                Integer intValue = (Integer)map.get("intValue");
                BigDecimal decimalValue = (BigDecimal)map.get("decimalValue");
                Predicate<List<Integer>> matched = (Predicate<List<Integer>>)map.get("matched");

                List<TimeStatisticList> timeStatisticLists  = timeStatisticListRepository.findByTimeId(timeStatisticPerformance.getId());


                List<Integer> ids = timeStatisticLists.stream().map(e -> e.getItemId()).collect(Collectors.toList());
                ids.forEach(e->logger.debug("list --- {}",e));
                logger.debug("--------- id {}",id);

                TimeStatisticList timeStatisticList = null;
                if(matched.test(ids)){

                    logger.debug("--------- 开始 ITEM 不存在， 新建 相关 item ");
                    timeStatisticList = new TimeStatisticList();
                    timeStatisticList.setTimeId(timeStatisticPerformance.getId());
                    timeStatisticList.setItemId(id);

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticList = timeStatisticListRepository.save(timeStatisticList);
                    logger.debug("--------- 结束 ITEM 不存在， 新建 相关 item   {}",timeStatisticList.toString());




                    timeStatisticLists.add(timeStatisticList);
                }else{
                    timeStatisticList = timeStatisticLists.stream().filter(line -> line.getItemId().equals(id)).collect(Collectors.toList()).get(0);

                }







                for(TimeStatisticList statisticList: timeStatisticLists){


                    if(statisticList.getItemId() == timeStatisticList.getItemId()){
                        statisticList.setDecimalValue(decimalValue);
                    }
                    logger.debug("-------------- ITEM  :{}", statisticList.getItemId());


                }


                timeStatisticList.setDecimalValue(decimalValue);
                timeStatisticList.setIntValue(intValue);
                timeStatisticListRepository.save(timeStatisticList);
                logger.debug("--------- ITEM  存在，存在， 那么就更新一下 更新  {}",timeStatisticList.toString());


                timeStatisticPerformance.setDecimalValue(timeStatisticPerformance.getDecimalValue().add(increment));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);




            }else{

                timeStatisticPerformance.setDecimalValue(timeStatisticPerformance.getDecimalValue().add(increment));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }
        }


        return statisticPerformanceRepository.save(statisticPerformance);


    }




    @Override
    public void reduceInvetory(Integer id, ResourceType type, Integer capacityId, BigDecimal quantityOnHand, BigDecimal netWeight) {


/*        inventory.setQuantityOnHand(inventory.getQuantityOnHand().subtract(netWeight));

        inventory = inventoryRepository.save(inventory);*/

        //InventoryTransfer transfer = new InventoryTransfer();
        //transfer.setAmount(netWeight);
       // transfer =inventoryTransferRepository.save(transfer);

        ItemTransferEntry transferEntry = new ItemTransferEntry();
        transferEntry.setItemId(id);
        transferEntry.setItemType(type.getText());
        transferEntry.setObjectId(id);
        transferEntry.setQuantityOnHand(quantityOnHand);
       // transferEntry.setTransferId(transfer.getId());

        transferEntry.setAmount(netWeight);
        transferEntry.setType(InventoryTransferTypeEnum.OUT.getText());

        transferEntry =inventoryTransferEntryRepository.save(transferEntry);



      //  return null;
    }

    @Override
    @Transactional
    public void reduceInvetory(Integer id, ResourceType performanceInfo, Integer userId) {
        ItemTransferEntry transferEntry = new ItemTransferEntry();
        transferEntry.setItemId(id);
        transferEntry.setItemType(performanceInfo.getText());
        transferEntry.setObjectId(userId);
/*
        transferEntry.setQuantityOnHand(quantityOnHand);
        transferEntry.setAmount(netWeight);
        transferEntry.setType(InventoryTransferTypeEnum.OUT.getText());
*/

        transferEntry =inventoryTransferEntryRepository.save(transferEntry);
    }


    @Override
    @Transactional
    public StatisticPerformance setBigDecimalValueForRouteFreight(StatisticPerformance statisticPerformance_, BigDecimal value, Map map){
        StatisticPerformance statisticPerformance = statisticPerformanceRepository.findById(statisticPerformance_.getId());

        statisticPerformance.setDecimalValue(value);


        Boolean recordTrend = (Boolean)map.get("recordTrend");
        Boolean recordItem = (Boolean)map.get("recordItem");
        String trendMethod = (String)map.get("trendMethod");
        BigDecimal increment = (BigDecimal)map.get("increment");




        logger.debug("----setBigDecimalValue :param is : {}, statisticPerformance:{}", map,statisticPerformance.toString());
        if(recordTrend){


            TimeStatistic statistic = statisticService.getCurrentTimeStatistic();
            TimeStatisticPerformance timeStatisticPerformance = timeStatisticPerformanceRepository.findByTimeIdAndPerformanceId(statistic.getId(),statisticPerformance.getId());
            if(timeStatisticPerformance == null){
                timeStatisticPerformance = new TimeStatisticPerformance();
                timeStatisticPerformance.setDecimalValue(new BigDecimal(0));
                timeStatisticPerformance.setPerformanceId(statisticPerformance.getId());
                timeStatisticPerformance.setTimeId(statistic.getId());
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }


            if(recordItem){

                logger.debug("--------- recordItem   {}",recordItem);
                Integer id = (Integer)map.get("id");
                Class type = (Class)map.get("type");
                Integer intValue = (Integer)map.get("intValue");
                BigDecimal decimalValue = (BigDecimal)map.get("decimalValue");
                Predicate<List<Integer>> matched = (Predicate<List<Integer>>)map.get("matched");

                List<TimeStatisticList> timeStatisticLists  = timeStatisticListRepository.findByTimeId(timeStatisticPerformance.getId());


                List<Integer> ids = timeStatisticLists.stream().map(e -> e.getItemId()).collect(Collectors.toList());
                ids.forEach(e->logger.debug("list --- {}",e));
                logger.debug("--------- id {}",id);

                TimeStatisticList timeStatisticList = null;
                if(matched.test(ids)){

                    logger.debug("--------- 开始 ITEM 不存在， 新建 相关 item ");
                    timeStatisticList = new TimeStatisticList();
                    timeStatisticList.setTimeId(timeStatisticPerformance.getId());
                    timeStatisticList.setItemId(id);

                    timeStatisticList.setDecimalValue(decimalValue);
                    timeStatisticList.setIntValue(intValue);
                    timeStatisticList = timeStatisticListRepository.save(timeStatisticList);
                    logger.debug("--------- 结束 ITEM 不存在， 新建 相关 item   {}",timeStatisticList.toString());




                    timeStatisticLists.add(timeStatisticList);
                }else{
                    timeStatisticList = timeStatisticLists.stream().filter(line -> line.getItemId().equals(id)).collect(Collectors.toList()).get(0);

                }







                for(TimeStatisticList statisticList: timeStatisticLists){


                    if(statisticList.getItemId() == timeStatisticList.getItemId()){
                        statisticList.setDecimalValue(decimalValue);
                    }
                    logger.debug("-------------- ITEM  :{}", statisticList.getItemId());


                }


                timeStatisticList.setDecimalValue(decimalValue);
                timeStatisticList.setIntValue(intValue);
                timeStatisticListRepository.save(timeStatisticList);
                logger.debug("--------- ITEM  存在，存在， 那么就更新一下 更新  {}",timeStatisticList.toString());


                timeStatisticPerformance.setDecimalValue(timeStatisticPerformance.getDecimalValue().add(increment));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);




            }else{

                timeStatisticPerformance.setDecimalValue(timeStatisticPerformance.getDecimalValue().add(increment));
                timeStatisticPerformance = timeStatisticPerformanceRepository.save(timeStatisticPerformance);
            }
        }


        return statisticPerformanceRepository.save(statisticPerformance);


    }

}
