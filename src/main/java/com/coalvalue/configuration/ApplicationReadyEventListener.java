package com.coalvalue.configuration;/*
package com.coalvalue.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coalvalue.enumType.ServiceTypeEnum;
import com.service.TulingApiProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>, Ordered {
    private Logger logger = LoggerFactory.getLogger(ApplicationReadyEventListener.class);
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    @Value("${serviceUrl}")
    private String serviceUrl;


    @Value("${sendMessageUrl}")
    private String sendMessageUrl;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        logger.debug("begin --------------------------------------------- register service, to master");

        Map map = new HashMap<>();
        map.put("id", ServiceTypeEnum.INDEX_STATISTIC.getText());
        map.put("Body","I like pie");
        Map date = new HashMap<>();
        date.put("name", ServiceTypeEnum.INDEX_STATISTIC.getDisplayText());

        map.put("data",date);

        String jsonObject = JSON.toJSONString(map);

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    JSONObject result = TulingApiProcess.getTulingResult(serviceUrl,"");

                    String apiUrl = result.getString("register_url");
                    TulingApiProcess.getTulingResultPostStateEvent(apiUrl, null,jsonObject);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        logger.debug("end --------------------------------------------- register service, to master");

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }


}*/
