package com.coalvalue.enumType;

import com.coalvalue.configuration.CommonConstant;
import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/3/31.
 */
public enum EventEnum {

    APPRROVED_ORDER ("approvedOrder","批准订单" ,1,null),

    CREATE_ORDER ("createdOrder", "新建订单",2,null),
    APROVED_CANVASSING ("approvedCanvassing","同意揽货", 3,null),
    UPDATE_SUPPLY ("updateSupply","更新供给", 4,null),
    CHANGE_PRICE_PROMOTION("promotionChangePrice", "修改促销价格",5,null), DEAL_AGREE("agree deal","同意交易", 5,null), DEAL_SELLER_REJECT("seller reject deal", "卖家拒绝交易",5 ,null), REQUEST_DEAL_PROMOTION("request coal deal for promotion","请求交易", 5,null),
    DEAL_REJECT("reject deal","拒绝交易", 5,null), SHIPMENT_CREATE_ADD_TRUCK("create shipment add truck","添加车辆，建立运单", 6,null),

    SHIPMENT_SHIPPED("shippinged","发货", 10,new ArrayList(){{add(CommonConstant.RESPONSIBLE_PERSON_ORDER_BUYER_TYPE);add(CommonConstant.RESPONSIBLE_PERSON_ORDER_SELLER_TYPE);add(CommonConstant.ORDER_TYPE_SCATTERED_PLAN);}}),



    SHIPMENT_DRIVER_SIGNED("driver_signed","司机签名", 10,new ArrayList(){{add(CommonConstant.RESPONSIBLE_PERSON_ORDER_BUYER_TYPE);add(CommonConstant.RESPONSIBLE_PERSON_ORDER_SELLER_TYPE);add(CommonConstant.ORDER_TYPE_SCATTERED_PLAN);}}),


    SHIPMENT_VALIDATE_ARRIVAL("shipment arrival validated","验证到场", 6,new ArrayList(){{add(CommonConstant.RESPONSIBLE_PERSON_ORDER_BUYER_TYPE);add("");}}),
    CANVASSING_CREATE_DRIVER_ACTIVE("driver active create canvassing","司机主动请求揽货", 3,new ArrayList(){{add(CommonConstant.RESPONSIBLE_PERSON_CAPACITY_APPLICATION_TYPE);add(CommonConstant.RESPONSIBLE_PERSON_CANVASSING_DRIVER);}}),
    CANVASSING_CREATE_DRIVER_ACTIVE_NO_FEEDBACK_TO_DRIVER("driver active create canvassing no feadback","司机主动请求揽货", 3,new ArrayList(){{add(CommonConstant.RESPONSIBLE_PERSON_CAPACITY_APPLICATION_TYPE);}}),



    CANVASSING_ARRIVAL_VALIDATE("deliver arrival validate canvassing","揽货车辆到场", 3,null),
    SHIPMENT_CREATE_FOR_CANVASSING("create shipment from arrival validate canvassing","由揽货单 建立运单", 3,null),
    SHIPMENT_SIGN("sing shipment", "签收运单",3,null),

    SHIPMENT_Consignee_sign("Consignee_sign_shipment", "收货人签收",3,null),
    SHIPMENT_reject_sign("SHIPMENT_reject_sign", "收货人拒绝签收",3,null),
    SHIPMENT_settle_freight("SHIPMENT_settle_freight", "结算运费",3,null),



    CANVASSING_CANCEL("cancel shipment","运单签收", 3,null),
    PROMOTION_CHANGE_PRICE("promotion change price","促销调整价格", 3,null),
    PUBLIST_VACANT("publist vacant","发布空车信息", 3,null),
    CAPACITY_APPLY_CREATE("create capacity application","建立找车请求", 3,null),
    CANVASSING_CREATE_DRIVER_PASSIVE("driver passive create canvassing","司机被动建立揽货", 3,null),
    SHIPMENT_CREATE_FOR_CANVASSING_NO_ORDER("create shipment from arrival validate canvassing NO order","无订单 由揽货 建立 运单", 3,null),
    USER_CREATE_BY_COMPANY("create user by company admin", "公司建立 用户 ",3,null),  CAPACITY_APPLY_CHANGE_FREIGHTTON("change capcity price", "调整运费",3,null),

    UPDATE_USER_LOCATION("user update wx location","更新位置信息", 3,null),
    CANVASSING_CHANGE_FREIGHT("user change canvassing freight", "调整揽货 canvassings 运费",3,null),
    CAPACITY_APPLY_CANCELL("user CANCELL capacity apply", "取消找车请求",3,null),
    CANVASSING_APPROVED("user APPROVED canvassing", "同意揽货",3,null),
    CANVASSING_CREATE_TRANSPORT("canvassing_create_transport", "揽活新建提煤单",3,null),
    CANVASSING_REJECT("canvassing_reject", "拒绝揽活",3,null),
    CANVASSING_SET_ARRIVAL("canvassing_send_arrival", "设置到场",3,null),




    PROMOTION_CREATE("user CREATE promotion","用户建立促销", 3,null),
    SHIPMENT_UPLOAD_RECEIPT("user UPLOAD receipt","用户上传回单", 3,null),
    SHIPMENT_CANCELL_BY_DRIVER("user cancell shipment", "司机取消运单",3,null), CAPACITY_APPLY_SEND_INVITE_CAPACITY_SUPPLIER("capacity apply invite capacity supplier", "找车请求邀请 司机",3,null),
    CANVASSING_REJECTED_CANCELL("applier cancell canvassing pending","揽货被拒绝取消", 3,null), TRANSPORT_OPERATION_SHIPMENT_SHIPPED ("transport operation create shipment","堆场作业新建运单发货", 3,null),
    CREATE_SHIPMENT_SHIPPED ("create shipment shipped","建立 运单 并发货 ", 3,null), CREATE_TRANSPORT_OPERATION_FROM_CANVASSING("canvassing create transport operation","建立 堆场作用 ", 3,null),
    TRANSPORT_OPERATION_AGREE("agree transport operation","同意堆场作用 ", 3,null),
    TRANSPORT_OPERATION_LOAD_COMPLETE("load complete transport operation","堆场装载完成 ", 3,null),
    SHIPMENT_consignor_force_confirm("force confirm operation","经销商强制确认 ", 3,null),
    SHIPMENT_sign_confirm("sign_confirm","签名确认 ", 3,null),
    SHIPMENT_sign_complete("sign_complete","签名确认 ", 3,null),

 //

    TRANSPORT_OPERATION_distributor_force_COMPLETE(CommonConstant.TRANSPORT_OPERATION_distributor_force_COMPLETE,"经销商强制完成 ", 3,null),
    TRANSPORT_OPERATION_distributor_create_shipment("distributor_create_shipment for transport","经销商建立运单 ", 3,null),


    TRANSPORT_OPERATION_CANCEL("cancell transport operation","取消堆场装货 ", 3,null),



    TRANSPORT_OPERATION_CREATE_SHIPMENT_SHIPPED("transport operation create shipment","同意堆场作用 ", 3,null),
    TransportDetailsActivity_btn_print(CommonConstant.TransportDetailsActivity_btn_print,"打印 ", 3,null),
    TRANSPORT_OPERATION_ARRIVAL_NOFICATION("transport arrival notification","提煤但 现场了。 ", 3,null),


    CREATE_ORDER_BY_SUPPLIER("supplier create order","同意堆场作用 ", 3,null),

    CREATE_ORDER_may_from_deal_instance_BY_SUPPLIER("deal_instance_supplier_create_order","新建订单", 3,null),


    TRANSPORT_OPERATION_SET_STATUS_LEAVE_PASSIVE("set operation leave status ","被动设置离场 ", 3,null), TRANSPORT_OPERATION_REJECT_ENTER("reject to enter ","拒绝进场 ", 3,null),
    TRANSPORT_OPERATION_SCAN_CREATE_scattered("transport operation create from scattered ","被动设置离场 ", 3,null),

    CANVASSING_ARRIVAL_STORAGE_SCAN("canvassing arrival storage scan","堆场扫描二维码签到 ", 3,null),
    CREATE_ORDER_BY_CONSUMER_DIRECT("order create consumer direct","买家直接下单购买", 3,null),
    APPRROVED_ORDER_CUSTOMER_DIRECT("order approved consumer direct","卖家同意直接下单购买", 3,null),
    CAPACITY_APPLY_CREATE_FOR_ORDER("create capacity for order","新建 管理订单运输需求  ", 3,null), STORAGE_principal_create_countman("create storage principal","新建 堆场 发货 负责人  ", 3,null),
    STORAGE_principal_create_admin("create storage admin","新建 堆场 管理 负责人  ", 3,null),
    CANVASSING_ARRIVAL_storage_confirn("canvassing arrival storage confirn","揽货到达堆场，确认  ", 3,null),
    Quality_indicator_create("Quality indicator create","新建质量指标  ", 3,null), STORAGE_principal_delete("storage principal delete","删除负责人", 3,null),
    TRANSPORT_OPERATION_CREATE_scattered("storage create scattered","堆场发货人建立散单  ", 3,null),

    COALSUPPLY_create("create coalsupply","新建煤炭供给  ", 3,null), TRANSPORT_OPERATION_SHIPMENT_SHIPPED_to_driver("create shipment to notice driver","通知司机  ", 3,null),
    TRANSPORT_OPERATION_CLOUD_PRINT_lading_bill("coud print lading bill","云打印提煤单  ", 3,null),
    TRANSPORT_OPERATION_AGREE_sendToCollaborator("agree transport operation coop bill of lading","同意堆场作业，合作商 提煤 ", 3,null),

    SHIPMENT_SETTLE("agree transport operation coop bill of lading","同意堆场作业，合作商 提煤 ", 3,null),
    SHIPMENT_SETTLE_FREIGHT("settle freight","结算运费 ", 3,null),
    CANVASSING_REJECTED("reject","拒绝 ", 3,null), Product_type_create("product type create","拒绝 ", 3,null), COALSUPPLY_release("release coalsupply","发布产品 ", 3,null),
    COALSUPPLY_cloase("close","关闭 ", 3,null), PROMOTION_CLOSE_STATUS("close","关闭 ", 3,null),
    CREATE_Intentional_district("add intentional district","添加意向地址", 3,null),
    LOGIN_WEB("web login","web 登录", 3,null),
    COALPIT_MAKE_OUT_OF_PRODUCTION("make out of production","设置停产", 3,null),
    COALSUPPLY_CHANGE_PRICE("change price","修改价格", 3,null), TRUCK_BIND_ACCOUNT("bind Wx and create account","新建司机帐号绑定微信",3,null),
    TRANSPORT_OPERATION_print_shipment_contract("打印 运输合同 ","打印 运输合同", 3,null),
    TRANSPORT_OPERATION_PRINT_lading_bill("打印提货单 ","打印提货单", 3,null),
    PROMOTION_RELEASE_STATUS("发布产品 ","发布产品", 3,null),

    SHIPMENT_CREATE("新建运单 ","新建运单", 3,null), COAL_PROMOTION_add_Principal("增加负责人 ","增加负责人", 3,null), COAL_PROMOTION_principal_delete("减少直销负责人 ","减少直销负责人", 3,null),
    SHIPMENT_shipout("运单发货 ","运单发货", 3,null),

    SHIPMENT_confirm_by_driver("SHIPMENT_confirm_by_driver ","司机确认运单", 3,null),


    Statistic_DAY_quantity_by_product_for_company("统计信息_每天_公司分产品出矿量 ","统计信息_每天_公司分产品出矿量", 3,null),
    SHIPMENT_CREATE_FOR_GENERAL("统计信息_每天_公司分产品出矿量 ","统计信息_每天_公司分产品出矿量", 3,null),

    COAL_SUPPLY_add_Principal("增加产品负责人 ","增加产品负责人", 3,null),
    COALPROMOTION_ADD_inventory("增加库存 ","增加库存", 3,null),



    COALPROMOTION_create_ladder_quote("建立梯度价格 ","建立梯度价格", 3,null),
    TEAM_DEAL_CREATE("建立团购项目 ","建立团购项目", 3,null),
    DEAL_INSTANCE_APPROVED_Then_waiting_for_payment("同意_订购_等待支付 ","同意_订购_等待支付", 3,null),

    DEAL_INSTANCE_CREATE("新建交易 ","新建交易", 3,null),

    TEAM_DEAL_create_ladder_quote("建立梯度价格 ","建立梯度价格", 3,null),
    TEAM_DEAL_delete_ladder_quote("删除梯度价格 ","删除梯度价格", 3,null),

    TEAM_DEAL_EDIT("修改_团购项目 ","修改_团购项目", 3,null), TEAM_DEAL_PUBLISH("发布_团购项目 ","发布_团购项目", 3,null),
    TEAM_DEAL_CLOSE("关闭_团购项目 ","关闭_团购项目", 3,null),
    TEAM_DEAL_suspended("暂停_团购项目 ","停_团购项目", 3,null),
    TEAM_DEAL_Cancel("撤销_团购项目 ","撤销_团购项目", 3,null),



    PRODUCT_CREATE ("新建产品","新建产品",1,null),
    PRODUCT_PUBLISH("发布产品", "发布产品",2,null),
    PRODUCT_REJECT( "拒绝产品", "拒绝产品",2,null),
    PRODUCT_PENDING("请求产品", "请求产品",2,null),

    PRODUCT_CLOSE ("关闭产品", "关闭产品 ",2,null),
    PRODUCT_suspended ("暂停产品 ", "暂停产品 ",2,null),
    PRODUCT_inter_Marketing ("内部销售 ", "内部销售 ",2,null),


    PRODUCT_CANCEL ( "取消产品 ", "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_btn_change_price ( CommonConstant.ProductDetailsActivity_btn_change_price, "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_btn_change_inventory ( CommonConstant.ProductDetailsActivity_btn_change_inventory,  "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_btn_print (  CommonConstant.ProductDetailsActivity_btn_print,  "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_btn_show_qrcode ( CommonConstant.ProductDetailsActivity_btn_show_qrcode,  "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_btn_change_principal ( CommonConstant.ProductDetailsActivity_btn_change_principal,  "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_to_QualityReportDetailsActivity ( CommonConstant.ProductDetailsActivity_to_QualityReportDetailsActivity,  "取消产品 ",2,null),
    PRODUCT_ProductDetailsActivity_btn_change_quality_report( CommonConstant.ProductDetailsActivity_btn_change_quality_report,  "取消产品 ",2,null),







    CHANGE_PRICE("调价 ","调价", 3,null), CREATE_ORDER_may_from_customer_BY_SUPPLIER("customer_supplier_create_order","customer_supplier_create_order" ,3,null ),
    MANAGEMENT_CHANGE_COMPANY_BUSSINESS_STATUS("_CHANGE_COMPANY_BUSSINESS_STATUS","修改公司经营状态" ,3,null),
    TRANSPORT_OPERATION_CREATE  ("transport_create","新建作业" ,3,null),





    SHIPMENT_Take_photos (CommonConstant.SHIPMENT_Take_photos, "照相",2,null),

    SHIPMENT_print (CommonConstant.SHIPMENT_print, "打印",2,null),

    SHIPMENT_financal_check ("SHIPMENT_financal_check", "财务审核",2,null),

    SHIPMENT_check_complete ("SHIPMENT_check_complete", "审核完成",2,null),
    manufacturer_LEAVE_AND_UPLOAD_CAMERA ("manufacturer_LEAVE_AND_UPLOAD_CAMERA", "装载拍摄资料",2,null),
    distributor_LEAVE_AND_UPLOAD_CAMERA ("distributor_LEAVE_AND_UPLOAD_CAMERA", "装载拍摄资料",2,null),



    QUARTZ_JOB_PAUSE ("SHIPMENT_check_complete", "SHIPMENT_check_complete",2,null),
    QUARTZ_JOB_resume ("QUARTZ_JOB_resume", "QUARTZ_JOB_resume",2,null),

    QUARTZ_JOB_DELETE ("QUARTZ_JOB_DELETE", "QUARTZ_JOB_DELETE",2,null),
    QUARTZ_JOB_resume_ALL ("QUARTZ_JOB_resume_ALL", "QUARTZ_JOB_resume_ALL",2,null),



    QUARTZ_TRIGGER_resume ("QUARTZ_TRIGGER_resume", "QUARTZ_TRIGGER_resume",2,null),
    QUARTZ_TRIGGER_pause ("QUARTZ_TRIGGER_pause", "QUARTZ_TRIGGER_pause",2,null),
    QUARTZ_JOB_pause_jobs ("QUARTZ_JOB_pause_jobs", "审核完成",2,null),

    TRANSPORT_OPERATION_finance_audit ("TRANSPORT_OPERATION_finance_audit", "财务审核",2,null),

    ORDER_CREATE ("ORDER_CREATE", "建立交易",2,null),
    ORDER_CLOSE ("ORDER_CLOSE", "关闭",2,null),
    ORDER_CANCEL ("ORDER_CANCEL", "取消",2,null),
    ORDER_CREATE_CAPACITY (CommonConstant.OrderDetailsActivity_ORDER_CREATE_CAPACITY, "建立运输需求",2,null),
    ORDER_OrderDetailsActivity_btn_print (CommonConstant.OrderDetailsActivity_btn_print, "打印",2,null),
    INVENTORY_SET_OPEN ("INVENTORY_SET_OPEN", "设置公开 ",2,null),
    INVENTORY_SET_CLOSE ("INVENTORY_SET_CLOSE", "设置关闭 ",2,null),
    INVENTORY_CHANGE_INVENTORY("INVENTORY_CHANGE_INVENTORY", "修改库存 ",2,null),
    ROUTE_CREATE(CommonConstant.EVENT_ROUTE_CREATE, "新建入住公司 ",2,null),

    USER_REGISTER(CommonConstant.EVENT_USER_REGISTER, "新建入住公司 ",2,null),

    FrgDelivery_btn_canvassing(CommonConstant.FrgDelivery_btn_canvassing, "修改库存 ",2,null),
    FrgDelivery_btn_shipment(CommonConstant.FrgDelivery_btn_shipment, "修改库存 ",2,null),
    FrgDelivery_btn_submit_audit(CommonConstant.FrgDelivery_btn_submit_audit, "修改库存 ",2,null),
    FrgDelivery_btn_auditing(CommonConstant.FrgDelivery_btn_auditing, "修改库存 ",2,null),



    QualityReportDetailsActivity_btn_preview(CommonConstant.QualityReportDetailsActivity_btn_preview, "修改库存 ",2,null),
    QualityReportDetailsActivity_btn_print_btn_upload_photo(CommonConstant.QualityReportDetailsActivity_btn_print_btn_upload_photo, "修改库存 ",2,null),
    QualityReportDetailsActivity_btn_edit(CommonConstant.QualityReportDetailsActivity_btn_edit, "修改库存 ",2,null),

    DEAL_INSTANCE_APPROVED (CommonConstant.DEAL_INSTANCE_APPROVED, "关闭 ",2,null),
    DEAL_INSTANCE_PENDING (CommonConstant.DEAL_INSTANCE_PENDING, "请求审核 ",2,null),


    DEAL_INSTANCE_CREATE_ORDER (CommonConstant.DEAL_INSTANCE_CREATE_ORDER, "暂停团购项目 ",2,null),
    DEAL_INSTANCE_CANCEL (CommonConstant.DEAL_INSTANCE_CANCEL, "经销商取消 ",2,null),
    DEAL_INSTANCE_REJECTED(CommonConstant.DEAL_INSTANCE_REJECTED, "经销商取消 ",2,null),


    SOLR_CREATE_PRODUCT(CommonConstant.EVENT_SOLR_CREATE_PRODUCT,"",2,null)
    ;



    private final String statusText;
    private final String displayText;
    private final Integer id;

    public String getDisplayText() {
        return displayText;
    }

    private final List<String> sendMessageTo;

    public List<String> noMessageTo = new ArrayList<String>();


    public List<String> getSendMessageTo() {
        return sendMessageTo;
    }

    private EventEnum(String statusText, String displayText, Integer id, List<String> sendMessageTo) {
        this.statusText = statusText;
        this.displayText = displayText;
        this.id = id;
        this.sendMessageTo = sendMessageTo;
    }


    public String getText() {
        return this.statusText;
    }

    public Integer getId() {
        return this.id;
    }

    public static EventEnum fromString(String text) {
        for (EventEnum status : EventEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<ListItem> retriveCampanyTypese() {

        List<ListItem> list = new ArrayList<ListItem>();
        for(EventEnum status : EventEnum.values()) {
            ListItem element = new ListItem(status.getId(),status.getText());
            list.add(element);
        }

        return list;

    }

}
