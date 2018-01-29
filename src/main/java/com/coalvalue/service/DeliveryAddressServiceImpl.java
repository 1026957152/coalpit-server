package com.coalvalue.service;


import com.coalvalue.domain.entity.CoalAddress;
import com.coalvalue.repository.CoalAddressRepository;
import com.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Peter Xu on 04/04/2015.
 */
@Service("deliveryAddress")
@Transactional(readOnly = true)
public class DeliveryAddressServiceImpl extends BaseServiceImpl implements DeliveryAddressService {



    @Autowired
    private CoalAddressRepository coalAddressRepository;



    @Override
    @Transactional
    public CoalAddress createCoalAddress(CoalAddress destination) {


        return coalAddressRepository.save(destination);
    }

    @Override
    public CoalAddress getCoalAddress(Integer deliveryAddressId) {

        return coalAddressRepository.findById(deliveryAddressId);
    }



}
