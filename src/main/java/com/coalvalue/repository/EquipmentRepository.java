package com.coalvalue.repository;


import com.coalvalue.domain.BrandEnterprise;
import com.coalvalue.domain.entity.Equipment;
import com.coalvalue.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface EquipmentRepository extends BaseJpaRepository<Equipment, Integer> {


    Equipment findByUserIdAndPin(String userId, String pwd);

    Equipment findById(Integer clientId);

    List<Equipment> findByCompanyIdAndType(Integer id, String text);

    Page<Equipment> findByCompanyId(Integer id, Pageable pageable);


    Equipment findByCompanyIdAndTypeAndName(Integer companyId, String text, String deviceId);

}
