package com.coalvalue.service;


import com.service.BaseService;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface MqttService extends BaseService {


    void access();

    public void sendNetworkStatus(String status);
}
