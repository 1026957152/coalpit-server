package com.service;


import com.coalvalue.domain.OperationResult;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface LedService extends BaseService {


    OperationResult sendMessage(String message);

}
