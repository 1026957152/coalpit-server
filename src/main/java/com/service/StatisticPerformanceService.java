package com.service;


import com.coalvalue.domain.entity.StatisticPerformance;
import com.coalvalue.domain.entity.TimeStatisticList;
import com.coalvalue.domain.entity.TimeStatisticPerformance;
import com.coalvalue.enumType.ResourceType;
import com.coalvalue.enumType.StatisticPerformanceTypeEnum;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface StatisticPerformanceService extends BaseService {



    StatisticPerformance getCompanyStatistic(Integer companyId, StatisticPerformanceTypeEnum type, Class c);

    StatisticPerformance setIntValue(StatisticPerformance statisticPerformance_, Integer value, Integer increment);

    @Transactional
    StatisticPerformance setIntValueAndStoreItem(StatisticPerformance statisticPerformance_, Integer value, Integer increment, Integer id);


    StatisticPerformance setIntValueAndStoreItemMap(StatisticPerformance statisticPerformance_, Integer value, Integer increment, Map map);


    StatisticPerformance setBigDecimalValue(StatisticPerformance statisticPerformance_, BigDecimal value, BigDecimal bigDecimal);
    StatisticPerformance setBigDecimalValue(StatisticPerformance statisticPerformance_, BigDecimal value, BigDecimal bigDecimal, Boolean method);

    StatisticPerformance setBigDecimalValue(StatisticPerformance statisticPerformance_, BigDecimal value, Map map);

    StatisticPerformance setStringValue(StatisticPerformance statisticPerformance_, String value);

    StatisticPerformance setBooleanValue(StatisticPerformance statisticPerformance_, Boolean value);

    List getCompanyStatistic(Integer companyId);

    List getStatistic(Integer itemId, ResourceType resourceType);

    StatisticPerformance getStatistic(Integer id, ResourceType collaborator, StatisticPerformanceTypeEnum collaborator_transport_issued_count, Class integerClass);


    @Transactional
    StatisticPerformance getStatisticByDigestType(Integer id, ResourceType collaborator, String collaborator_transport_issued_count, Class integerClass);

    String getPwd(String s1, String s);

    List<TimeStatisticPerformance> getTopNByTypeAndItemId(int i, ResourceType company, StatisticPerformanceTypeEnum company_sales_total_quantity, Integer id);


    List<TimeStatisticPerformance> getTopNByStatisticPerformance(int limit, StatisticPerformance statisticPerformance);

    List<StatisticPerformance> getStatistic(ResourceType district, StatisticPerformanceTypeEnum district_avarage_price);


    String getKeyNameByDigest(String digest);

    StatisticPerformance getById(Integer companyId);

    List<TimeStatisticList> getTimeStatisticList(Integer id);

    StatisticPerformance getStatisticByIdType(Integer id, ResourceType performanceInfo, Class integerClass);

    List<TimeStatisticList> getTimeStatisticItemRecords(List<TimeStatisticPerformance> records);



    StatisticPerformance setBigDecimalValueForPriceIndex(StatisticPerformance statisticPerformance_, BigDecimal value, Map map);

    @Transactional
    StatisticPerformance setBigDecimalValueForInstancePrice(StatisticPerformance statisticPerformance_, BigDecimal value, Map map);

    @Transactional
    StatisticPerformance setBigDecimalValueForInventory(StatisticPerformance statisticPerformance_, BigDecimal value, Map map);

    void reduceInvetory(Integer id, ResourceType type, Integer capacityId, BigDecimal quantityOnHand, BigDecimal netWeight);
    void reduceInvetory(Integer id, ResourceType performanceInfo, Integer userId);
    @Transactional
    StatisticPerformance setBigDecimalValueForRouteFreight(StatisticPerformance statisticPerformance_, BigDecimal value, Map map);



}
