package com.coalvalue.service;


import com.coalvalue.domain.entity.CoalAddress;
import com.service.BaseService;

/**
 * Created by Peter Xu on 04/04/2015.
 */
public interface DeliveryAddressService extends BaseService {


    CoalAddress createCoalAddress(CoalAddress destination);

    CoalAddress getCoalAddress(Integer deliveryAddressId);


}
