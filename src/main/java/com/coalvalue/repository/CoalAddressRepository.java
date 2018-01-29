package com.coalvalue.repository;

import com.coalvalue.domain.entity.CoalAddress;
import com.coalvalue.repository.base.BaseJpaRepository;

/**
 * Created by zhaoyuan on 9/12/2015.
 */
public interface CoalAddressRepository extends BaseJpaRepository<CoalAddress, Integer> {


    CoalAddress findById(Integer deliveryAddressId);

}

