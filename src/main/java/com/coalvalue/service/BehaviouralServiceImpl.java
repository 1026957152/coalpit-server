package com.coalvalue.service;


import com.coalvalue.domain.entity.Behavioural;
import com.coalvalue.notification.NotificationData;
import com.coalvalue.repository.BehaviouralRepository;
import com.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("behaviouralService")
public class BehaviouralServiceImpl extends BaseServiceImpl implements BehaviouralService {

    @Autowired
    private BehaviouralRepository behaviouralRepository;


    @Override
    @Transactional
    public void create(NotificationData data) {

        Behavioural behavioural = new Behavioural();
        behavioural = behaviouralRepository.save(behavioural);

    }
}
