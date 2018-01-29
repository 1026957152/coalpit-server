package com.service;

import com.coalvalue.domain.entity.LogMessage;
import com.domain.entity.Events;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface LogMessageService extends BaseService {



    @Transactional
    public LogMessage create(LogMessage advice);

    public LogMessage update(LogMessage article);


    Page<LogMessage> getMessageFeadBack(Events event, Pageable pageable);

    LogMessage findByMsgidAndWeixinOpenId(String msgID, String fromUserName);
}
