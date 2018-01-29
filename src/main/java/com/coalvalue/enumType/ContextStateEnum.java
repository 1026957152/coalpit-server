package com.coalvalue.enumType;

public enum ContextStateEnum {
	WAIT_QUERY,
	WAIT_LEARN,
	WAIT_CONFIRM,
	WAIT_WEATHER_CITY,
	WAIT_MUSIC_INFO,
    WAIT_IMAGE_INFO,
    WAIT_LOCATION_INFO,

    SELLER_WAIT_CHANGE_PRICE,






    WAIT_SUPPLY_QUERY,


    General_CAPACITY_MARKET,
    General_COAL_MARKET,



    General_FAVORITE,

    General_STATISTIC,

    General_DEAL,
    General_ORDER,
    General_SHIPMENT,



    WAIT_UPLOAD_SIGN_IMAGE_INFO,

    CONTEXT_PUBLISH_VANCANT_WAITING_UPDATE_LOCATION_BY_DRIVER,


    DDD, CONTEXT_CANVASSING_ARRIVAL_WAITING_ARRIVAL_CONFIRM_BY_DRIVER, CONTEXT_SHIPMENT_SHIPPING_WAITING_UPLOAD_RECEIPT_BY_DRIVER,
    SCENE_DRIVER_PUBLISH_VACANT_HAS_NO_TRUCK ,CONTEXT_Anonymous_driver_arrival_storage_create_account, CONTEXT_SCENE_Anonymous_driver_create_account,
    CONTEXT_CANVASSING_ARRIVAL_UPLOAD_LOCATION, CONTEXT_SCENE_space_transport_operation_want_to_leave, CONTEXT_scene_shipment_sign_by_consignee_waiting_confirm, CONTEXT_SCENE_create_capacity_recommend_to_DRIVER, CONTEXT_scene_change_promotion_price_waiting_get_quality_detail, CONTEXT_SCENE_scatterd_space_transport_operation_want_to_enter, CONTEXT_SHIPMENT_SHIPPED_MESSAGE_TO_BUYER_WAITING_DETAIL, CONTEXT_SCENE_Anonymous_broker_create_account,



    CONTEXT_SCENE_coal_size_hengshan_area,
    CONTEXT_SCENE_coal_type_hengshan_area,
    CONTEXT_SCENE_hengshan_area,
    CONTEXT_SCENE_price_category_type_hengshan_area,
    CONTEXT_SCENE_coalpit_hengshan_area
          ,CONTEXT_SCENE_settlement_mode_hengshan_area,
    CONTEXT_SCENE_coal_size_hengshan_separation_area,
    CONTEXT_SCENE_origin_entry_hengshan_broker_area, CONTEXT_CANVASSING_creata_WAITING_approved_by_applier,
    CONTEXT_SCENE_agree_coal_deal_waiting_detail_contract_BY_buyer, CONTEXT_SCENE_Anonymous_coalsupply_scan_broker_create_account,
    SCENE_ARRIVAL_STORAGE_HAS_NO_ACCOUNT , CONTEXT_SCENE_Anonymous_capacity_apply_canvass_action_scan_driver_create_account,
    CONTEXT_SCENE_Anonymous_gonverment_create_account,
    SCENE_broker_has_no_delivery_address_to_create,
    CONTEXT_SCENE_Anonymous_purchase_coalsupply_broker_create_account, SCENE_capacity_apply_canvass_driver_has_no_truck_create_truck,
    SCENE_broker_has_no_storageSpace_create_coalsupply,
    CONTEXT_SCENE_Anonymous_purchase_coalpromotion_broker_create_account,
    SCENE_broker_has_no_storageSpace_create_capacity_apply, SCENE_broker_has_no_quality_create_coalpromotion, SCENE_broker_has_no_quality_create_coalsupply, CONTEXT_SCENE_Anonymous_capacity_apply_LOGIN_action, SCENE_waiting_upload_signinfo_by_driver,
    CONTEXT_SCENE_Anonymous_coal_supply_LOGIN_action, SCENE_broker_has_no_storageSpace_create_coalpromotion,
    CONTEXT_SCENE_hengsh_driver,
    SCENE_wx_driver_has_no_truck_create_truck,
    SCENE_driver_has_no_truck_create_truck,
    CONTEXT_SCENE_Anonymous_capacity_apply_LOGIN_action_Follow_company, CONTEXT_SCENE_Anonymous_capacity_supply_LOGIN_action,
    CONTEXT_SCENE_Anonymous_capacity_supply_create_account,
    CONTEXT_SCENE_Anonymous_tow_step_create_account,
    SCENE_has_no_information_completed_create_order,
    SCENE_wx_user_infomation_ACTION_complete, SCENE_STORAGE_create_transport_operation,
    CONTEXT_SCENE_coalpit_create_company_users,
    CONTEXT_SCENE_buyer_create_company_users,
    CONTEXT_SCENE_seller_create_company_users,
    CONTEXT_SCENE_broker_create_company_users, CONTEXT_COMPANY_SCAN_quality_indicator,
    CONTEXT_SCENE_space_ACTION_add_counterman, SCENE_action_perfect_company_information, SCENE_action_perfect_user_information,
    CONTEXT_SCENE_storage_loading_status_partner_status, CONTEXT_SCENE_space_ACTION_change_counterman,
    CONTEXT_BIND_USER_ACCOUNT,
    CONTEXT_SCENE_register_hengshan,
    Canvassing_create_transport_operation,
    Transportation_create_transport_operation,SCAN_DELIVER_ORDER_CREATE_DRIVER_ACCOUNT,
    Message_report_get_more_detail, CONTEXT_scene_change_product_price_waiting_get_detail;
            ;


    public static ContextStateEnum getEnumFromString(String state){
		if(state != null)
		{
			try{
				return Enum.valueOf(ContextStateEnum.class, state.trim());
			}catch(IllegalArgumentException ex)
			{
				
			}
		}
		return null;	
	}



}
