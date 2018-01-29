package com.coalvalue.service;

import com.coalvalue.domain.OperationResult;
import com.coalvalue.domain.entity.Company;
import com.coalvalue.domain.entity.Equipment;
import com.coalvalue.domain.entity.StorageSpace;
import com.coalvalue.enumType.EquipmentTypeEnum;
import com.coalvalue.enumType.ResourceType;
import com.domain.entity.User;
import com.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface EquipmentService extends BaseService {



    Equipment userLogin(String userId, String pwd, String loginIP, Object o);

    Equipment login(String userId, String pwd, String loginIP, Object o);

    Page<Equipment> query(Pageable pageRequest, User user);

    @Transactional
    OperationResult create(String deviceId, EquipmentTypeEnum typeEnum, User user);

    Map<String, Object> getByMapId(Integer clientId);

    void sendMessage(Equipment transportOperation, String message, User user);


    String getBulletinDisplayContent(Equipment equipment);

    OperationResult command_change_diplay_content(Equipment transportOperation, String message, User user);

    List<Equipment> getPrinterForCompany(Company company);


    OperationResult printer(StorageSpace storageSpace, String text);

    List<Equipment> getLedForCompany(Company company);

    Map<String,Object> getEquipmentByCompany(Company company, Pageable pageable, User user);

    Equipment getById(Integer clientId);


    @Transactional
    Equipment updateEquipment(Equipment equipment);

    void setAttribute(Equipment equipment, String text);

    void changePrice(Company company, Map map);


}
