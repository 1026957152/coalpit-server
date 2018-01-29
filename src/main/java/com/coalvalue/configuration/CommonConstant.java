package com.coalvalue.configuration;

/**
 * Created by yunpxu on 1/7/2015.
 */
public class CommonConstant {

    public static final boolean TEST = true ;
    public static final String TEST_WEB_APP_ROOT_KEY = "D:/mei_0628/src/main/webapp/WEB-INF/files" ;
    public static final String MAIN_SERVER_UUID = "00000000000000000000000000000000";

    public static final String TEST_HOST = "347dab18.ngrok.io";

    public static final String Test_local_host = "192.168.1.107:8085";


    public static final String LOCAL_HOST = "localhost:8085";

    //Session Context Key in Session
    public static final String SESSION_CONTEXT = "SESSION_CONTEXT";

    //----------------------Entity Related Status Start-----------------
    //User Role Id
    public static final int ROLE_ID_BUYER = 40;
    public static final int ROLE_ID_SELLER = 30;
    public static final int ROLE_ID_WAREHOUSE = 45;
    public static final int ROLE_ID_SELLDELIVERY = 50;
    public static final int ROLE_ID_REGISTE_USER = 10;
    public static final int ROLE_ID_COMPANY_ADMIN = 20;
    public static final int ROLE_ID_COMPANY_USER = 21;
    public static final int ROLE_ID_LOGISTICS = 60;
    public static final int ROLE_ID_PRIVATECAPACITY = 80;
    public static final int ROLE_ID_CUSTOMSERVICE = 70;
    public static final int ROLE_ID_INSPECTION_USER = 90;

    public static final int ROLE_ID_PERSONAL_USER = 110;
    public static final int ROLE_ID_Consignee_USER = 120;
    public static final int ROLE_ID_BROKER_USER = 130;
    public static final int ROLE_ID_GONVERMENT_USER = 140;
    public static final int ROLE_ID_COALPIT_USER = 150;

    public static final int ROLE_ID_COALPIT_DELIVER = 160;
    public static final int ROLE_COALPIT_DELIVER_MANAGEMER = 161;



    public static final int ROLE_ID_FINANCIAL_CONTROLLER = 170;

    public static final int ROLE_ID_FINANCE_CASHIER = 180;

    //User Status
    public static final String USER_STATUS_LOCKED = "Locked";
    public static final String USER_STATUS_ACTIVE = "Active";

    //User Type
    public static final String USER_TYPE_ADMIN = "Admin";
    public static final String USER_TYPE_USER = "User";
    public static final String USER_TYPE_BROKER = "Broker";
    public static final String USER_TYPE_GONVERMENT = "Gonverment";

    public static final String USER_TYPE_COALPIT = "Coalpit";
    public static final String USER_TYPE_COALPIT_DELIVER = "Coalpit deliver";



    public static final String ADMIN_ROLE = "administrator";

    //User Role Type
    public static final String USER_ROLE_SELLER = "ROLE_SELLER";
    public static final String USER_ROLE_BUYER = "ROLE_BUYER";
    public static final String USER_ROLE_LOGISTICS = "ROLE_LOGISTICS";
    public static final String USER_ROLE_DRIVER = "ROLE_DRIVER";
    public static final String USER_ROLE_WAREHOUSE = "ROLE_WAREHOUSE";

    public static final String USER_ROLE_SELLER_DELIVER ="ROLE_SELLER_DELIVER" ;

    public static final String USER_ROLE_INSPECTION = "ROLE_INSPECTION";
    public static final String USER_ROLE_BROKER = "ROLE_BROKER";
    public static final String USER_ROLE_GONVERMENT = "USER_ROLE_GONVERMENT";

    public static final String USER_ROLE_COALPIT = "ROLE_COALPIT";
    public static final String ROLE_REGISTERED_USER = "ROLE_REGISTERED_USER";
    public static final String USER_ROLE_COMPANY_ADMIN = "ROLE_COMPANY_ADMIN";

    public static final String USER_ROLE_COALPIT_DELIVER = "ROLE_COALPIT_DELIVER";
    public static final String USER_ROLE_COMPANY_USER = "ROLE_COMPANY_USER";




    public static final String TRANSPORT_OPERATION_STATUS_CREATE = "create";
    public static final String TRANSPORT_OPERATION_STATUS_LOADING = "loading";
    public static final String TRANSPORT_OPERATION_STATUS_CREATE_PENDING = "create pending";
    public static final String TRANSPORT_OPERATION_STATUS_FORCE_LEAVE = "force_leave";
    public static final String TRANSPORT_OPERATION_STATUS_LEAVE = "leave";

    public static final String TRANSPORT_OPERATION_STATUS_CANCEL = "cancel";

    public static final String TRANSPORT_OPERATION_STATUS_LEAVE_AND_UPLOAD_CAMERA = "leave_upload_camera";

    public static final String TRANSPORT_OPERATION_STATUS_COMPLETED = "Completed";



    public static final String TRANSPORT_OPERATION_STATUS_CREATE_PENDING_CANVASSING = "canvassing create pending";

    public static final String TRANSPORT_OPERATION_STATUS_AGREE_ENTER = "agree enter";



    public static final String TRANSPORT_OPERATION_STATUS_REJECT = "reject";
    public static final String TRANSPORT_OPERATION_STATUS_LEAVE_create_shipment="leave create shipment";
    public static final String TRANSPORT_OPERATION_STATUS_PARTNER_CREATE_PENDING = "partner pending" ;
    public static final String TRANSPORT_OPERATION_STATUS_PENDING_ENTER_PARTNER = "pending enter partner" ;
    public static final String TRANSPORT_OPERATION_CREATE_PENDING_SCATTERED = "scattered create pending" ;
    public static final String TRANSPORT_OPERATION_PARTNER_LEAVE = "partner leave" ;
    public static final String TRANSPORT_OPERATION_PARTNER_LOADING = "partner loading" ;
    public static final String TRANSPORT_OPERATION_Waiting_Print_delivery_order = "waiting print delivery order" ;
    public static final String TRANSPORT_OPERATION_finance_audit_approved = "finance_audit_approved" ;

    public static final String TRANSPORT_OPERATION_finance_audit_pending = "finance_audit_pending" ;
    public static final String TRANSPORT_OPERATION_STATUS_Gathering_documents = "Gathering_documents" ;
    public static final String TRANSPORT_OPERATION_distributor_force_COMPLETE = "distributor_force_complete_transport" ;



    public static final String CHECK_COLLECTION_STATUS_CREATE_PENDING = "pending";

    public static final String CHECK_COLLECTION_STATUS_COMPLETED = "completed";
    public static final String CHECK_COLLECTION_STATUS_REJECT = "rejected";



    public static final String SCENE_DRIVER_PUBLISH_VACANT_HAS_NO_TRUCK = "driver publish vacant has no truck";
    public static final String SCENE_ARRIVAL_STORAGE_HAS_NO_ACCOUNT = "arrival storage has no account";
    public static final String SCENE_CUSTOMER_DIRECT_CREATE_ORDER = "customer direct create order";
    public static final String SCENE_HOME_PAGE_CAPACITY_SUPPLY = "home page capacity supply";
    public static final String SCENE_SCAN_TRANSOPRT = "scan transport";



    public static final String RESPONSIBLE_PERSON_ORDER_SELLER_SHIPPER_PRINCIPAL = "order seller shipper principal";
    public static final String TRANSPORT_OPERATION_TYPE_SCATTERED = "scattered";
    public static final String TRANSPORT_OPERATION_TYPE_CANVASSING = "canvassing";

    public static final String TRANSPORT_OPERATION_TYPE_PARTNER = "partner";
    public static final String TRANSPORT_OPERATION_TYPE_SCATTERED_STORAGE_CREATE = "storage create scattered";
    public static final String TRANSPORT_OPERATION_TYPE_SCATTERED_STORAGE_SCAN = "storage scan create scattered";
    public static final String SCATTERED_STORAGE_CREATE_PARTER_NOT_CONTROLE = "storage create scattered pit without control";




    public static final String RESPONSIBLE_PERSON_STORAGE_MANAGER = "storage manager";
    public static final String RESPONSIBLE_PERSON_CAPACITY_SUPPLY_TYPE = "capacity supply";
    public static final String RESPONSIBLE_PERSON_COAL_SUPPLY = "coalsupply";

    public static final String RESPONSIBLE_PERSON_SHIPMENT_DRIVER = "shipment driver";
    public static final String RESPONSIBLE_PERSON_TRANSPORT_OPERATION_DRIVER = "transport driver";
    public static final String RESPONSIBLE_PERSON_TEAM_DEAL = "team_deal";

    public static final String STATUS_STORAGE_OPEN = "open";
    public static final String STATUS_STORAGE_CLOSE = "close";
    public static final String RESOURCCE_TYPE_TRUCK = "truck";
    public static final String RESOURCCE_TYPE_USER = "user";
    public static final String RESOURCCE_TYPE_COOP_APPLICATION = "coop application";

    public static final String RESOURCCE_TYPE_Product_type = "Product_type";


    public static final String RESOURCCE_TYPE_CAPITAL_PAYMENT = "capital payment";
    public static final String RESOURCCE_TYPE_ROUTE = "route";
    public static final String RESOURCCE_TYPE_ROUTE_POINT = "route_point";



    public static final String RESOURCCE_TYPE_PRICE_CATEGORY = "price category";
    public static final String RESOURCCE_TYPE_COOP_PRODUCT = "coop product";
    public static final String RESOURCCE_TYPE_TEAM_DEAL = "team deal";
    public static final String RESOURCCE_TYPE_TOPIC = "topic";
    public static final String RESOURCCE_TYPE_DEAL_INSTANCE = "deal_instance";
    public static final String RESOURCCE_TYPE_PERFORMANCE_INFO = "performance_info";
    public static final String RESOURCCE_TYPE_PERFORMANCE_OBJECT = "performance_object";


    public static final String RESOURCCE_TYPE_CUSTOMER_NAME = "customer_meno";
    public static final String RESOURCCE_TYPE_MQTT_TOPIC = "mqtt_topic";
    public static final String RESOURCCE_TYPE_YARD_QUEUING = "yard_queuing";
    public static final String RESOURCCE_TYPE_COLLABORATOR = "RESOURCCE_TYPE_COLLABORATOR";

    public static final String RESOURCCE_TYPE_CHECK_COLLECTION = "check_collection";

    public static final String TEAM_DEAL_MULTISTEP_QUOTATION = "team_deal_multistep_quotation";


    public static final String NO_TYPE_CANVASSING = "canvassing";
    public static final String NO_TYPE_ORDER = "order";
    public static final String NO_TYPE_DEAL = "deal";
    public static final String PRINT_ITEM_TYPE_BILL_OF_LADING = "bill of lading";
    public static final String SHIPMENT_TYPE_TRANSPORT_OPERATION = "transport_operation";
    public static final String SHIPMENT_TYPE_TYPE_CANVASSING = "canvassing";
    public static final String SHIPMENT_TYPE_TYPE_SCATTED = "scatted";
    public static final String SHIPMENT_TYPE_TYPE_ORDER = "order";
    public static final String SHIPPING_REJECT_SIGNED = "reject_signed";


    public static String USER_ROLE_Consignee ="ROLE_CONSIGNEE";

    public static final String ADMIN_ROLE_SERVER ="ROLE_CUSTOM_SERVICE" ;


    //User  Type
    public static final String USER_TYPE_SELLER = "seller";
    public static final String USER_TYPE_BUYER = "buyer";
    public static final String USER_TYPE_LOGISTICS = "logistics";
    public static final String USER_TYPE_DRIVER = "driver";
    public static final String USER_TYPE_WAREHOUSE = "warehouse";

    public static final String USER_TYPE_SELLER_DELIVER ="deliver" ;

    public static final String USER_TYPE_INSPECTION = "inspection";
    public static final String USER_TYPE_BUYER_DELIVER = "buyer deliever";

    public static String USER_TYPE_Consignee = "consignee";
    public static String USER_TYPE_Anonymous = "Anonymous";

    //Company Type
    public static final String COMPANY_TYPE_SELLER = "seller";
    public static final String COMPANY_TYPE_BUYER = "buyer";
    public static final String COMPANY_TYPE_LOGISTICS = "logistics";

    public static final String COMPANY_TYPE_INSPECTION = "inspection";
    public static final String COMPANY_TYPE_WAREHOUSE = "warehouse";
    public static final String COMPANY_TYPE_BROKER = "broker";
    public static final String COMPANY_TYPE_COALPIT = "coalpit";
    //


    //add by zhaoyuan 29/06/2015
    public static final String COMPANY_IS_PUBLIC = "1";
    public static final String COMPANY_ISNOT_PUBLIC = "0";


    // add by zhaoyuan 01/07/2015
    public static final String COMPANY_PENDINGAPPROVAL = "PENDINGAPPROVAL";
    public static final String COMPANY_CANCELLED = "CANCELLED";
    public static final String COMPANY_APPROVED = "APPROVED";
    public static final String COMPANY_CLOSED = "CLOSED";
    public static final String COMPANY_VERIFICATION_BRAND = "BRAND";
    public static final String COMPANY_PARTIALAPPLICATION = "PARTIAL_APPLICATION";

    public static final String COMPANY_NORMAL = "NORMAL";

    public static final  Integer ADMIN_ID = 1;
    public static final Integer TRADE_SYSTEM = 0 ;
    public static final String ORDER_LOGISTIC_MODE_SELLER = "seller" ;

    public static final String ORDER_LOGISTIC_MODE_BUYER = "buyer" ;


    public static final String QUOTATION_STATUS_CREATED = "Created";
    public static final String QUOTATION_STATUS_COMPLETED = "Completed";
    public static final String QUOTATION_STATUS_BUYER_PENDING = "Buyer pending" ;
    public static final String QUOTATION_STATUS_SELLER_PENDING = "Seller pending" ;
    public static final String QUOTATION_STATUS_BUYER_REJECTED = "Buyer rejected" ;
    public static final String QUOTATION_STATUS_SELLER_REJECTED = "Seller rejected" ;
    public static final String QUOTATION_STATUS_NEGOTIATING = "Negotiating" ;


    public static final Integer TRADECENTER = -1;
    public static final String USER_AUTH_PHONE_STATUS_AUTHED = "Authed" ;
    public static final String USER_AUTH_PHONE_STATUS_UNAUTHED = "Unauthed" ;

    public static final String USER_AUTH_MAIL_STATUS_AUTHED = "Authed" ;
    public static final String USER_AUTH_MAIL_STATUS_UNAUTHED = "Authed" ;
    public static final String DEFAULT_IMAGE_URL = "/css/defaultUrl.jpg";
    public static final String DEFAULT_USER_IMAGE_URL = "/css/defaultUrl.jpg";



    public static final String RESOURCCE_TYPE_COAL_PRODUCT = "product";
    public static final String RESOURCCE_TYPE_COAL_SUPPLY = "coalSupply";
    public static final String RESOURCCE_TYPE_CAPACITY_DEMAND = "capacityDemand";
    public static final String RESOURCCE_TYPE_COAL_DEMAND = "coalDemand";
    public static final String RESOURCCE_TYPE_COAL_COMPANY = "company";
    public static final String RESOURCCE_TYPE_SHIPMENT = "shipment";
    public static final String RESOURCCE_TYPE_COAL_TYPE = "coalType";
    public static final String RESOURCCE_TYPE_COAL_ORDER_TYPE = "coalOrder";
    public static final String RESOURCCE_TYPE_ROLE = "role";

        public static final String RESOURCCE_TYPE_equipment_led = "equipment_led";


    public static final String RESOURCCE_TYPE_system = "system";
    public static final String RESOURCCE_TYPE_district = "district";
    public static final String RESOURCCE_TYPE_attribute = "attribute";



    public static final String RESOURCCE_TYPE_MARKETING_SCHEME  ="marketingScheme";

    public static final String SHIPMENT_VRIFICATION_STATUS_VERIFIED = "verified";
    public static final String SHIPMENT_VRIFICATION_STATUS_UNVERIFIED = "unVerified";
    public static final String CANVASSING_ARRIVAL_VRIFICATION_STATUS_UNVERIFIED = "canvassing unVerified";
    public static final String CANVASSING_ARRIVAL_VRIFICATION_STATUS_VERIFIED = "canvassing arrival verified";
    public static final String SHIPMENT_SIGN_VRIFICATION_STATUS_VERIFIED = "shipment sign verified";
    public static final String SHIPMENT_SIGN_VRIFICATION_STATUS_UNVERIFIED = "shipment sign UNVerified";


    public static final String TERMINAL_WX = "fromWx";
    public static final String TERMINAL_WX_NOCLICK = "atWx no click";


    public static final String RESPONSIBLE_PERSON_PROMOTION_TYPE = "promotion";
    public static final String RESPONSIBLE_PERSON_ORDER_BUYER_TYPE = "order_buyer";
    public static final String RESPONSIBLE_PERSON_ORDER_SELLER_TYPE = "order_seller";

    public static final String RESPONSIBLE_PERSON_CAPACITY_APPLICATION_TYPE = "capacity_application";
    public static final String RESPONSIBLE_PERSON_CAPACITY_APPLICATION_TYPE_SHIPPER_PRINCIPAL = "capacity shipper principal";


    public static final String RESPONSIBLE_PERSON_COAL_DEMAND_TYPE = "coal_demand";
    public static final String RESPONSIBLE_PERSON_QUOTATION_SELLER_TYPE = "quotation_seller";
    public static final String RESPONSIBLE_PERSON_QUOTATION_BUYER_TYPE = "quotation_buyer";


    public static final String RESPONSIBLE_PERSON_DEAL_BUYER_TYPE = "deal_buyer";
    public static final String RESPONSIBLE_PERSON_DEAL_instance_BUYER_TYPE = "deal_instance_buyer";
    public static final String RESPONSIBLE_PERSON_DEAL_SELLER_TYPE = "deal_seller";
    public static final String RESPONSIBLE_PERSON_ORDER_CARRIER_TYPE = "order carrier";
    public static final String RESPONSIBLE_PERSON_ORDER_TYPE_SCATTERED_PLAN = "scattered plan";
    public static final String RESPONSIBLE_PERSON_CANVASSING_DRIVER = "canvassing driver";
    public static final String RESPONSIBLE_PERSON_ORDER_TYPE_SCATTERED_PLAN_DELIVER = "order type scattered plan deliver";
    public static final String RESPONSIBLE_PERSON_ORDER_BUYER_consignee = "buyer consignee";
    public static final String RESPONSIBLE_PERSON_STORAGE_counterman= "counterman";



    public static final String RESPONSIBLE_COLLABORATOR_TYPE = "collaborator";

    public static final String RESOURCCE_TYPE_COAL_PROMOTION = "promotion";

    public static final String RESOURCCE_TYPE_USER_DRIVER = "driver user";
    public static final String RESOURCCE_TYPE_CANVASSING = "canvassing";
    public static final String RESOURCCE_TYPE_TRANSPORT_OPERATION = "transport operation";

    public static final String RESOURCCE_TYPE_SCATTERED_ORDER = "scattered order";
    public static final String RESOURCCE_TYPE_COAL_DEAL = "coal deal";
    public static final String RESOURCCE_TYPE_STORAGE_TYPE = "storage";
    public static final String RESOURCCE_TYPE_Quality_indicator = "quality indicator";

    public static final String RESPONSIBLE_PERSON_SHIPMENT_consignee = "shipment_consignee";
    public static final String RESPONSIBLE_PERSON_SHIPMENT_shipper = "shipment_shipper";
    public static final String RESPONSIBLE_PERSON_TRANSPORT_shipper = "transport_shipper";

    public static final String RESPONSIBLE_PERSON_TRANSPORT_storage_counterman = "transport_storage_counterman";

    public static final String RESPONSIBLE_PERSON_COPPERATIVE_APPLICATION = "cooperative_application";

    public static final String UPDATE_UNREAD = "unread";
    public static final String UPDATE_READED = "readed";

    public static final String INTERNAL_MESSAGE_UNREAD = "message_unread";
    public static final String INTERNAL_MESSAGE_READ = "message_read";


    public static final String X_WX_AUTH_TOKEN = "X-WX-Auth-Token";
    public static final String TERMINAL_SOURCE = "terminal_source";
    public static final String TERMINAL_WX_OPENID = "terminal_wx_openid";

    public static final Integer TAG_CALORIFIC = 3;
    public static final Integer TAG_SIZE = 4;
    public static final Integer TAG_SURFUR = 5;
    public static final String ANONYMOUS_USER_WX_TIPMESSAGE = "匿名提醒注册";
    public static final String ANONYMOUS_USER_WX_TIPMESSAGE_PUBLISH_UNOCCUPIED = "command publish unoccupied";
    public static final String TERMINAL_SOURCE_WEB = "web";

    public static final String PRIVATE_CAPACITY_STATUS_CREATED = null;
    public static final int DISPLAY_ITEM_NUM = 6;
    public static final String QRCODE_CANVASS_TYPE = "canvassing";
    public static final String QRCODE_CAPACITY_APPLY_ACTION_ARRIVAL = "capacity apply arrival action";
    public static final String QRCODE_ACCOUNT_ACTION_ACTIVE_COMPANY_USER = "active company user account action";

    public static final String IS_AUTHENTICATED = "isAuthenticated";
    public static final String ISNOT_AUTHENTICATED = "isNotAuthenticated";
    public static final String MESSAGE_TYPE_WX = "wx";

    public static final String MESSAGE_TYPE_SMS = "sms";
    public static final String MESSAGE_TYPE_WX_CUSTOM = "wxcustom";


    public static final String MESSAGE_SEND_ATTEMPT = "send attempt";
    public static final String MESSAGE_SEND_SUCCESS = "send success";

    public static final String MESSAGE_SEND_FAILURE = "send failure";
    public static final String MESSAGE_USER_RECEIVED = "user received";
    public static final String MESSAGE_USER_BLOCK = "user block";
    public static final String MESSAGE_SYSTEM_FAILED = "system failed";
    public static final String MESSAGE_SEND_NO_BINDOPENID = "no bind openid";


    public static final String DELIVERY_MODE_SELLER_APPOINTS = "seller appoint";
    public static final String DELIVERY_MODE_Buyer_APPOINTS = "buyer appoint";
    public static final String CARGO_CANVASSING_TYPE_REQUIREMENT_SHIPMENT = "requirement shipment";
    public static final String CARGO_CANVASSING_TYPE_REQUIREMENT_CARGO = "requirement cargo";


    public static final String CAPACITY_SUPPLY_PENDING = "pending";
    public static final String CAPACITY_SUPPLY_COMPLETE = "complete";
    public static final String CAPACITY_SUPPLY_CANCEL = "cancel";
    public static final String CAPACITY_APPLY_CANCEL = "cancel";

    public static final String FAORITE_ANONYMOUS = "favorite anonymous";
    public static final String ORDER_TYPE_SCATTERED_PLAN = "scattered plan";


    public static final String OPERATION_STATUS_SUCCESS = "success";
    public static final String OPERATION_STATUS_ATTEMPT = "attempt";
    public static final String CONTEXT_SHIPMENT_LIST_BY_DRIVER = "shipment list by driver";
    public static final String CONTEXT_PUBLISH_VANCANT_WAITING_UPDATE_LOCATION_BY_DRIVER = "publish vacant waiting update location";
    public static final String SECRETE_PASSAGE_TO_CAPACITY_SUPPLER = "secrete passage to capacity supplier";
    public static final String FAVORITE_LEVEL_ONE = "favorite level one";
    public static final String FAVORITE_LEVEL_TWO = "favorite level two";
    public static final String FAVORITE_LEVEL_TEN = "favorite level ten";
    public static final String FAVORITE_LEVEL_ELEVEN = "favorite level eleven";



//    public static final String CAPACITY_SUPPLY_PENDING = "pending";


    public static int STRING_COMPANY_SHORT_DESC_LENGTH = 50;
    public static Integer WX_LIMIT_DYNAMIC_MESSAGE_COUNT = 6;
    public static String QRCODE_STATUS_Invalid = "invalid";
    public static String QRCODE_STATUS_Valid = "valid";
    public static String NAME_formal="formal";
    ;
    public static String NAME_informal="informal";
    public static String USER_authentication_type_PHONE = "phone";
    public static String Channal_SMS = "sms";
    public static String Channal_WEIXIN = "weixin";
    public static String Channal_EMAIL = "email";
    public static String Channal_INNER_MESSAGE = "innermessage";
    public static String personal_account ="personal";
    public static String corporation_account = "corporation";
    public static String NOTIFICATION_PERSON_Canvassing = "notification person canvassing";
    public static String NOTIFICATION_MESSAGE_TYPE_Canvassing = "canvassing";
    public static String NOTIFICATION_MESSAGE_TYPE_transportOperation = "transportOperation";
    public static String CoopApplication_type_be_employer = "be_employer";
    public static String CoopApplication_type_Be_collabortor = "be_collabortor";

    public static String CoopApplication_applied_or_applying_be_applied = "be_applied";
    public static String CoopApplication_applied_or_applying_be_applying = "be_applying";




    public static String follow_type_mqtt_topic = "mqtt_topic";


    private final short CLIENT_CANCHANGETO_PARTIALAPPLICATION = 37;
    private final short CLIENT_CANCHANGETO_APPROVED = 38;
    private final short CLIENT_CANCHANGETO_CANCELLED = 39;
    private final short CLIENT_CANCHANGETO_ONHOLD = 40;
    private final short CLIENT_CANCHANGETO_CLOSED = 41;

    private final short CLIENT_CANCHANGETO_PENDINGAPPROVAL = 42;

    public static final String SIGNUP_MODE_BY_PHONE = "phone";

    public static final String SIGNUP_MODE_BY_EMAIL = "mail";
    public static final String SIGNUP_MODE_BY_WEIXIN = "weixin";


    //Mail History
    public static final String MAIL_TYPE_ACCOUNT = "1";
    public static final String MAIL_TYPE_FPWD = "2";

    //Mail Action
    public static final String MAIL_ACTION_PROCESSING = "Processing";
    public static final String MAIL_ACTION_COMPLETED = "Completed";
    public static final String MAIL_ACTION_REGISTER = "Register";
    public static final String MAIL_ACTION_RESETPWD = "ResetPwd";

    public static final String SMS_ACTION_PROCESSING = "Processing";

    public static final String SMS_ACTION_COMPLETED = "Completed";
    public static final String SMS_ACTION_REGISTER = "Register";
    public static final String SMS_ACTION_RESETPWD = "ResetPwd";
    public static final String SMS_ACTION_PHONE_AUTH = "PhoneAuth";

    public static final String SMS_ACTION_PHONE_AUTH_CREATE = "AuthCreated";
    public static final String SMS_ACTION_PHONE_AUTH_COMPLETED = "AuthCompleted";



    //BUYER AND SELLER Quotation Statu
    public static final Integer BUYER_ACTION_ENQUIRY = 0;
    public static final Integer SELLER_ACTION_QUOTATION = 1;
    public static final Integer BUYER_TRADE_REQUEST = 0;
    public static final Integer SELLER_TRADE_REQUEST = 1;
    public static final Integer TRADE_ACTION_REQUEST = 2;
    public static final Integer TRADE_ACTION_AGREE = 3;
    public static final Integer TRADE_ACTION_REJECT =4;

    //demandStatus
    //for create a temporary demand
    public static final String DEMAND_STATUS_TEMP = "Temp";
    public static final String DEMAND_STATUS_INIT = "Init";
    public static final String DEMAND_STATUS_QUOTE = "Quoted";


    //supplyStatus
    public static final String SUPPLY_STATUS_TEMP = "Temp";
    public static final String SUPPLY_STATUS_INIT = "Init";
    public static final String SUPPLY_STATUS_ENQUIRED = "Enquired";
    public static final String SUPPLY_STATUS_PUBLIC= "Public";
    public static final String SUPPLY_STATUS_PRIVATE= "Private";


    public static final String SUPPLY_STATUS_VALID = "Valid";
    public static final String SUPPLY_STATUS_INVALID = "Invalid";


    public static final String SUPPLY_STATUS_DELETE = "Delete";
    public static final String SUPPLY_STATUS_ORIGINAL = "Original";
    public static final String SUPPLY_STATUS_CREATE = "Created";
    public static final String SUPPLY_STATUS_RELEASED = "Released";
    public static final String SUPPLY_STATUS_Cancel = "Cancel";


    public static final String SUPPLY_STATUS_CLOSED = "Closed";
    public static final String SUPPLY_STATUS_SUSPENDED = "Suspended";

    public static final String SUPPLY_STATUS_inter_Marketing = "inter_Marketing";




    //orderLoad mode;
    public static final String LOADMODE_COOP = "warehouse";
    public static final String LOADMODE_SELF = "self_operated";

    //Contract Status
    public static final String CONTRACT_ACTION_CREATED = "Created";
    public static final String CONTRACT_ACTION_CONFIRMED = "Confirmed";
    public static final String CONTRACT_ACTION_WAITING = "Waiting";
    public static final String CONTRACT_ACTION_COMPLETED = "Completed";
    public static final String CONTRACT_ACTION_REJECTED = "Rejected";

    //deal Status add by zhoayuan 01/07/2015
    public static final String DEAL_CREATED = "Created";
    public static final String DEAL_APPROVED = "Approved";
    public static final String DEAL_CONFIRMED = "Confirmed";
    public static final String DEAL_WAITING = "Waiting";
    public static final String DEAL_COMPLETED = "Completed";
    public static final String DEAL_REJECTED = "Rejected";

    public static final String DEAL_PENDING_CENTER_APPROVE = "Pending center approval";
    public static final String DEAL_SELLER_PENDING = "Seller pending";
    public static final String DEAL_BUYER_PENDING = "Buyer pending";

    public static final String coop_relationship_active_status = "active";
    public static final String coop_relationship_pending_status = "pending";

    // 促销信息状态
    public static final String PROMOTION_CREATED="Created";
    public static final String PROMOTION_PENDING ="Pending"; // 待审核

    public static final String PROMOTION_RELEASED ="Released"; // 待审核


    public static final String PROMOTION_APPROVED="Approved"; // 待审核
    public static final String PROMOTION_REJECTED = "Rejected";
    public static final String PROMOTION_CLOSED = "Closed" ; // 关闭过期


  //  public static final String PROMOTION_QUTATION="审核通过，发布中";
    //public static final String PROMOTION_QUTATION="倒计时，发布中";
    //public static final String PROMOTION_QUTATION="销售中，发布中";
    //public static final String PROMOTION_QUTATION="撤销";
    //public static final String PROMOTION_QUTATION="已过期";
    //public static final String PROMOTION_QUTATION="完成";

    public static final String DEAL_TYPE_GROUP="GroupPurchase";
    public static final String DEAL_TYPE_QUTATION="QutationPruchase";

    //Truck Status
    public static final String TRUCK_STATUS_AVAILABLE = "available";
    public static final String TRUCK_STATUS_PENTING = "pending";


    public static final String TRUCK_STATUS_SHIPPING = "shipping";


    //Shipping Status

    public static final String SHIPPING_STATUS_CREATED = "created";
    public static final String SHIPPING_STATUS_LOADING = "loading";
    public static final String SHIPPING_STATUS_SHIPPING = "shipping";

    public static final String SHIPPING_STATUS_SIGNED = "signed";
    public static final String SHIPPING_STATUS_UNSETTLED = "unsettled";


    public static final String SHIPPING_STATUS_SETTLING = "settling";

    public static final String SHIPPING_STATUS_SETTLED = "settled";
    public static final String SHIPPING_STATUS_SETTLED_FREIGHT = "selled freight";

    //add at 2015/8/18
    public static final String SHIPPING_STATUS_INVOICED = "Invoiced";


    public static final String SHIPPING_STATUS_CANCELED = "Cancelled"; // 订单新建后， 可能出现这样的状态

    public static final String SHIPPING_STATUS_confirm = "confirm"; // 订单新建后， 可能出现这样的状态

    public static final String SHIPPING_STATUS_Gathering_documents = "Gathering_documents"; // 订单新建后， 可能出现这样的状态
    public static final String SHIPPING_STATUS_CHECKING = "checking"; // 订单新建后， 可能出现这样的状态
    public static final String SHIPPING_STATUS_CHECKED = "checked"; // 订单新建后， 可能出现这样的状态


    //Order Status
    public static final String ORDER_STATUS_PENDING = "pending";


    public static final String ORDER_STATUS_UNCHECKED = "unchecked";

    public static final String ORDER_STATUS_CANCELED = "canceled";

    public static final String ORDER_STATUS_REJECTED = "reject";

    public static final String ORDER_STATUS_GRANTED = "checked";

    public static final String ORDER_STATUS_PENDING_PAYMENT = "pending payment";


    public static final String ORDER_STATUS_SHIPPING = "shipping";

    public static final String ORDER_STATUS_PARTIALLY_SHIPPED = "partially shipped";


    public static final String ORDER_STATUS_SETTLED = "settled";
    public static final String ORDER_STATUS_UNSETTLED = "unsettled";
    public static final String ORDER_STATUS_CLEARING = "clearing";
    public static final String ORDER_STATUS_CLEARED = "cleared";
    public static final String ORDER_STATUS_UNCLEARED = "uncleared";


    public static final String ORDER_STATUS_COMPLETE = "Complete";

    public static final String ORDER_STATUS_CLOSED = "Closed";

    public static final String ORDER_STATUS_PARTIAL_APPLICATION = "partial application";
    public static final String ORDER_STATUS_ON_HOLD = "On Hold";
    public static final String ORDER_STATUS_CREATED = "Created";


    //Capital Account Status
    public static final String ACCOUNT_STATUS_UNCHECKED = "unchecked";
    public static final String ACCOUNT_STATUS_CHECKED = "checked";

    //Capital Account Type
    public static final String ACCOUNT_BUYER_PAYMENT = "BuyerPayment";
    public static final String ACCOUNT_SELLER_SETTLEMENT = "Settlement";
    public static final String ACCOUNT_SELLER_CLEAR = "Clear";


    public static final String FOLLOW_COMPANY_VALIDITY = "validity";
    public static final String FOLLOW_COMPANY_INVALIDITY = "invalidity";

    public static final String FOLLOW_TAG_VALIDITY = "validity";
    public static final String FOLLOW_TAG_INVALIDITY = "invalidity";


    public static final String TRUCK_FOR_SHIPPING_SHIPPING = "shipping";
    public static final String TRUCK_FOR_SHIPPING_NOARRIVAL = "no_arrival";



    // Capacity Apply status add by zhaoyuan 07/08/2015

    public static final String CAPACITY_APPLY_APPLING = "applying";
    public static final String CAPACITY_APPLY_RESPONSED = "response";
    public static final String CAPACITY_APPLY_LOSE_EFFECTION = "lose effection";
    public static final String CAPACITY_APPLY_CRAFT = "craft";

    //----------------------Entity Related Status End-----------------

    //Mail Template
    public static final String TEMPLATE_ACCOUNT = "ActiveAccountTemplate.ftl";
    public static final String TEMPLATE_FPWD = "FindPasswordTemplate.ftl";

    public static final String SORT_STANDARD_TYPE = "type";

    public static final String CANVASSING_CREATED = "Created";
    public static final String CANVASSING_CANCEL = "Cancel" ;
    public static final String CANVASSING_APPROVED = "Approved";
    public static final String CANVASSING_ORGERNING = "Approved";
    public static final String CANVASSING_REJECTED = "Rejected";
    public static final String CANVASSING_ARRIVAL = "Arrival" ;
    public static final String CANVASSING_REJECTED_CANCELL = "Cancell rejected";



    // 银行账号类型
    public static final String BANK_ACCOUNT_CORPORATION = "corporation";
    public static final String BANK_ACCOUNT_PERSONAL = "personal";
    public static final String BANK_ACCOUNT_TRADECENTER = "trade_center";



    // 支付状态
    public static final String PAYMENT_COMPLETED = "Completed";
    public static final String PAYMENT_PENDING = "Pending ";  // 付款请求中
    public static final String PAYMENT_REJECTED = "Rjected ";  // 已拒绝
    public static final String PAYMENT_REVERSED = "Revocked ";  // 已撤销


    // 合同模板状态 add by silence yuan 2015-07-28
    public static final String CONTRACT_TEMPLATE_DRAFT = "Draft"; //草稿
    public static final String CONTRACT_TEMPLATE_CONFIRM = "Confirm ";  // 确定
    public static final String CONTRACT_TEMPLATE_INACTIVE = "Inactive ";  // 失效
    public static final String CONTRACT_TEMPLATE_ASSESS = "Assess ";  // 审核
    public static final String CONTRACT_TEMPLATE_ACTIVE = "Active ";  // 有效
    public static final String CONTRACT_TEMPLATE_RELEASE = "Release";  // 发布
    public static final String CONTRACT_TEMPLATE_ELIMINATE = "Eliminate ";  // 清除


    public static final String ENTITY_TYPE_SUPPLY = "CoalSupply ";  // 清除
    public static final String ENTITY_TYPE_DEMAND = "CoalDemand";  //

    public static final String COAL_DEMAND_PUBLIC = "public";  // 清除
    public static final String COAL_DEMAND_PRIVATE = "private";  //


    public static final String CAPITAL_TRANSACTION_WITHDRAW = "withdraw";
    public static final String CAPITAL_TRANSACTION_PAY = "pay";
    public static final String CAPITAL_TRANSACTION_RECHARGE = "recharge";



    public static final String CAPITAL_TRANSACTION_PAY_CHECKOUT = "Checkout";
    public static final String CAPITAL_TRANSACTION_PAY_REJECT = "Reject";
    public static final String CAPITAL_TRANSACTION_PAY_COMPLETED = "Completed";




    public static final String CAPITAL_TRANSACTION_WDITHRAW_PENDING = "Pending";
    public static final String CAPITAL_TRANSACTION_WDITHRAW_FAILED = "Failed";
    public static final String CAPITAL_TRANSACTION_WDITHRAW_VOID = "Void";
    public static final String CAPITAL_TRANSACTION_WDITHRAW_COMPLETED = "Completed";

    public static final String CAPITAL_TRANSACTION_RECHARGE_PENDING = "Pending";
    public static final String CAPITAL_TRANSACTION_RECHARGE_FAILED = "Failed";
    public static final String CAPITAL_TRANSACTION_RECHARGE_VOID = "Void";
    public static final String CAPITAL_TRANSACTION_RECHARGE_COMPLETED = "Completed";





    public static final String STATUS_HISTORY_ORDER_TYPE = "coalorder";

    public static final String STATUS_HISTORY_DEAL_TYPE = "coadeal";

    public static final String STATUS_HISTORY_COMPANY_TYPE = "company";

    ;
    public static final String STATUS_INITIAL = "Initial";
    public static final String STATUS_FINAL = "Final";


    public static String PAYMENT_STATUS_PAID = "Paid";

    public static String PAYMENT_STATUS_UNPAID = "Unpaid";

    public static String PAYMENT_STATUS_PARTIALPAID = "Partial paid";
    public static String PAYMENT_STATUS_PENDING_PAID = "Pending paid";





    public static String SMS_ORDER_CREATE = "smsOrderCreate";

    public static String TRUCK_SOURCE_SELFRUN = "selfrun" ;
    public static String TRUCK_SOURCE_LOGISTICS = "logistics" ;
    public static String TRUCK_SOURCE_DIRECTAPPLY = "logistics" ;


    public static final String SHIPMENT_SOURCE_CANVASSING = "canvassing";
    public static final String SHIPMENT_SOURCE_ORDER = "coalOrder";


    public static final String SHIPMENT_SOURCE_SELFRUN = "selfrun";
    public static final String SHIPMENT_SOURCE_LOGISTICS_SELFRUN ="logistics_selfrun" ;



    public static final String DELIVERY_MODE_SELF_PICKUP = "self pickup";

    public static final String DELIVERY_MODE_HOME_DELIVERY = "home delivery";


    public static final String follow_type_tag = "tag";

    public static final String follow_type_company = "company";
    public static final String follow_type_route = "route";

    public static final String ITEM_TYPE_PROMOTION ="promotion" ;

    public static final String STATUE_UNSUBSCRIBE = "UnSubScribe";
    public static final String STATUE_SUBSCRIBE = "SubScribe";


    public static final Integer WX_MENU_GROUP_ID_UNGROUP = 0;
    public static final Integer WX_MENU_GROUP_ID_SELLER_OR_BUYER = 100;
    public static final Integer WX_MENU_GROUP_ID_DRIVER = 101;
    public static final Integer WX_MENU_GROUP_ID_SELLER_DELIVER = 102;
    public static final Integer WX_MENU_GROUP_ID_BUYER = 103;
    public static final Integer WX_MENU_GROUP_ID_LOGISTICS = 104;

    public static final String Product_type_Coop = "product coop";


/*    Checkout - The checkout has not been completed.
    Processing - The payment is being processed.
            Pending - The payment has been processed but is not yet complete (ex. authorized but not captured).
    Failed - The payment was rejected (ex. credit card was declined).
    Void - The payment should not be applied against the order.
            Completed

              https://guides.spreecommerce.com/user/payment_states.html
            */

    //百度map key
    public static final String BAIDU_MAP_KEY = "SHgVOH45YkrihCytDtHSEx2g";
    public static Integer COMPANY_mycompany_id = 179;

    public static final String InvitationCode_STATUS_Invalid = "Invalid";
    public static final String InvitationCode_STATUS_Valid = "Valid";

    public static final String BRAND_ENTERPRISE_STATUS_RELEASE = "released";

    public static final Integer DISTRICT_HENGSHAN_ID = 4;


    public static final String OrderDetailsActivity_ORDER_CREATE_CAPACITY = "OrderDetailsActivity_ORDER_CREATE_CAPACITY";

    public static final String OrderDetailsActivity_btn_print = "OrderDetailsActivity_btn_print";



    public static String ProductDetailsActivity_btn_change_price = "ProductDetailsActivity_btn_change_price";
    public static String ProductDetailsActivity_btn_change_inventory = "ProductDetailsActivity_btn_change_inventory";
    public static String ProductDetailsActivity_btn_print = "ProductDetailsActivity_btn_print";
    public static String ProductDetailsActivity_btn_show_qrcode = "ProductDetailsActivity_btn_show_qrcode";
    public static String ProductDetailsActivity_btn_change_principal = "ProductDetailsActivity_btn_change_principal";
    public static String ProductDetailsActivity_to_QualityReportDetailsActivity = "ProductDetailsActivity_to_QualityReportDetailsActivity";

    public static String ProductDetailsActivity_btn_change_quality_report = "ProductDetailsActivity_btn_change_quality_report";


    public static String EVENT_ROUTE_CREATE = "EVENT_ROUTE_CREATE";
    public static String EVENT_USER_REGISTER = "EVENT_USER_REGISTER";

    public static String EVENT_SOLR_CREATE_PRODUCT = "EVENT_SOLR_CREATE_PRODUCT";


    public static String FrgDelivery_btn_canvassing = "FrgDelivery_btn_canvassing";
    public static String FrgDelivery_btn_shipment = "FrgDelivery_btn_shipment";
    public static String FrgDelivery_btn_submit_audit = "FrgDelivery_btn_submit_audit";
    public static String FrgDelivery_btn_auditing = "FrgDelivery_btn_auditing";


    public static String QualityReportDetailsActivity_btn_preview = "QualityReportDetailsActivity_btn_preview";
    public static String QualityReportDetailsActivity_btn_print_btn_upload_photo = "QualityReportDetailsActivity_btn_print_btn_upload_photo";
    public static String QualityReportDetailsActivity_btn_edit = "QualityReportDetailsActivity_btn_edit";


    public static String TransportDetailsActivity_btn_print = "TransportDetailsActivity_btn_print";

    public static final String DISCOVERY_ITEM_TYPE_DEMAND = "discovery_item_type_demand";
    public static final String DEAL_INSTANCE_APPROVED = "DEAL_INSTANCE_APPROVED";
    public static final String DEAL_INSTANCE_PENDING = "DEAL_INSTANCE_PENDING";


    public static final String DEAL_INSTANCE_CREATE_ORDER = "DEAL_INSTANCE_CREATE_ORDER";
    public static final String DEAL_INSTANCE_CANCEL = "DEAL_INSTANCE_CANCEL";
    public static final String DEAL_INSTANCE_REJECTED = "DEAL_INSTANCE_REJECTED";

    public static String SHIPMENT_Take_photos = "SHIPMENT_Take_photos";

    public static String SHIPMENT_print = "SHIPMENT_print";


    public static String marketingscheme_item_paymentmethod = "paymentmethod";
    public static String marketingscheme_item_logisticmode = "logisticmode";
    public static String marketingscheme_item_settlement = "settlement";
    public static String marketingscheme_item_invoicemode = "invoicemode";

}
