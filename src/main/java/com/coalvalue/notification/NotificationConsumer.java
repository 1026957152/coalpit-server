package com.coalvalue.notification;


import com.coalvalue.repository.BehaviouralRepository;
import com.coalvalue.service.BehaviouralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {
 



    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private BehaviouralService behaviouralService;

    @Autowired
    private BehaviouralRepository behaviouralRepository;

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {



        behaviouralService.create(notificationDataEvent.getData());





        System.out.println("behavioural---- " + ":" );


    }
}