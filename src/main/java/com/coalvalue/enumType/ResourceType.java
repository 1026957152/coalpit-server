package com.coalvalue.enumType;

import com.coalvalue.configuration.CommonConstant;

//import com.mchange.v2.c3p0.impl.C3P0ImplUtils;

/**
 * Created by silence yuan on 2015/8/18.
 */
public enum ResourceType {

/*

    　1、 信汇（Mail Transfer, M/T）
            　2、 电汇（Telegraphic Transfer, T/T）
            　3、 票汇（Demand Draft, D/D）
            4.    付款交单（Document against Payment,D/P）
            5.    承兑交单（Document against acceptance, D/A）
            6.   信用证（Letter of Credit, L/C）

*/

    COAL_PRODUCT (CommonConstant.RESOURCCE_TYPE_COAL_PRODUCT,1),

    COAL_SUPPLY (CommonConstant.RESOURCCE_TYPE_COAL_SUPPLY,1),

    CAPACITY_DEMAND (CommonConstant.RESOURCCE_TYPE_CAPACITY_DEMAND, 2),
    COAL_DEMAND (CommonConstant.RESOURCCE_TYPE_COAL_DEMAND, 3),
    COMPANY (CommonConstant.RESOURCCE_TYPE_COAL_COMPANY, 4), DRIVER(CommonConstant.RESOURCCE_TYPE_USER_DRIVER, 1),
    CANVASSING(CommonConstant.RESOURCCE_TYPE_CANVASSING, 1),
    COAL_PROMOTION(CommonConstant.RESOURCCE_TYPE_COAL_PROMOTION, 1),
    SHIPMENT(CommonConstant.RESOURCCE_TYPE_SHIPMENT, 1), SCATTERED_ORDER(CommonConstant.RESOURCCE_TYPE_SCATTERED_ORDER,1),
    COAL_TYPE(CommonConstant.RESOURCCE_TYPE_COAL_TYPE, 1), TRANSPORT_OPERATION(CommonConstant.RESOURCCE_TYPE_TRANSPORT_OPERATION, 1), COAL_DEAL(CommonConstant.RESOURCCE_TYPE_COAL_DEAL, 1),
    COAL_ORDER(CommonConstant.RESOURCCE_TYPE_COAL_ORDER_TYPE, 1), STORAGE(CommonConstant.RESOURCCE_TYPE_STORAGE_TYPE, 1), Quality_indicator(CommonConstant.RESOURCCE_TYPE_Quality_indicator, 1),

     TRUCK (CommonConstant.RESOURCCE_TYPE_TRUCK, 1),
    USER (CommonConstant.RESOURCCE_TYPE_USER, 1), PAYMENT(CommonConstant.RESOURCCE_TYPE_CAPITAL_PAYMENT, 1),
    COOP_APPLICATION(CommonConstant.RESOURCCE_TYPE_COOP_APPLICATION, 1), Product_type(CommonConstant.RESOURCCE_TYPE_Product_type,1 ),
    ROUTE(CommonConstant.RESOURCCE_TYPE_ROUTE, 1),
    ROUTE_POINT(CommonConstant.RESOURCCE_TYPE_ROUTE_POINT, 1),



    PRICE_CATEGORY(CommonConstant.RESOURCCE_TYPE_PRICE_CATEGORY, 1),


    COOP_PRODUCT(CommonConstant.RESOURCCE_TYPE_COOP_PRODUCT, 1),
    TEAM_DEAL(CommonConstant.RESOURCCE_TYPE_TEAM_DEAL, 1),
    TOPIC(CommonConstant.RESOURCCE_TYPE_TOPIC, 1),
    TEAM_DEAL_MULTISTEP_QUOTATION(CommonConstant.RESOURCCE_TYPE_TOPIC, 1),
    DEAL_INSTANCE(CommonConstant.RESOURCCE_TYPE_DEAL_INSTANCE, 1) ,
    PERFORMANCE_INFO(CommonConstant.RESOURCCE_TYPE_PERFORMANCE_INFO, 1) ,
    PERFORMANCE_OBJECT(CommonConstant.RESOURCCE_TYPE_PERFORMANCE_OBJECT, 1) ,


    Customer_memo(CommonConstant.RESOURCCE_TYPE_CUSTOMER_NAME, 1) ,
    MQTT_TOPIC(CommonConstant.RESOURCCE_TYPE_MQTT_TOPIC, 1) ,
    YARD_QUEUING(CommonConstant.RESOURCCE_TYPE_YARD_QUEUING, 1),
    COLLABORATOR(CommonConstant.RESOURCCE_TYPE_COLLABORATOR, 1),


    CHECK_COLLECTION(CommonConstant.RESOURCCE_TYPE_CHECK_COLLECTION, 1),
    MARKETING_SCHEME(CommonConstant.RESOURCCE_TYPE_MARKETING_SCHEME, 1),

    ROLE(CommonConstant.RESOURCCE_TYPE_ROLE, 1),
    equipment_led(CommonConstant.RESOURCCE_TYPE_equipment_led, 1), SYSTEM(CommonConstant.RESOURCCE_TYPE_system, 1),
    DISTRICT(CommonConstant.RESOURCCE_TYPE_district, 1),
    ATTRIBUTE(CommonConstant.RESOURCCE_TYPE_attribute, 1);




    private final String statusText;
    private final Integer id;

    private ResourceType(String statusText, Integer id) {
        this.statusText = statusText;
        this.id = id;
    }
    public String getText() {
        return this.statusText;
    }

    public Integer getId() {
        return this.id;
    }

    public static ResourceType fromString(String text) {
        for (ResourceType status : ResourceType.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }


}
