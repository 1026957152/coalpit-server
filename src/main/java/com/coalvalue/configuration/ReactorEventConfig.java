package com.coalvalue.configuration;


import com.coalvalue.notification.NotificationConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

import java.util.concurrent.CountDownLatch;

import static reactor.bus.selector.Selectors.$;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ReactorEventConfig implements CommandLineRunner {

    private static final int NUMBER_OF_QUOTES = 10;

    @Bean
    Environment env() {
        return Environment.initializeIfEmpty()
                          .assignErrorJournal();
    }
    @Autowired
    private NotificationConsumer notificationConsumer;
/*
    @Autowired
    private NotificationWeixinTextConsumer notificationWeixinTextConsumer;


    @Autowired
    private NotificationWeixinEventConsumer notificationWeixinClickConsumer;
*/

    @Bean
    EventBus createEventBus(Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }

	@Autowired
	private EventBus eventBus;


	@Bean
	public CountDownLatch latch() {
		return new CountDownLatch(NUMBER_OF_QUOTES);
	}

	@Override
	public void run(String... args) throws Exception {
		//eventBus.on($("quotes"), receiver);
       eventBus.on($("notificationConsumer"), notificationConsumer);
/*
        eventBus.on($("notificationWeixinClickConsumer"), notificationWeixinClickConsumer);
        eventBus.on($("notificationWeixinTextConsumer"), notificationWeixinTextConsumer);
*/

        //publisher.publishQuotes(NUMBER_OF_QUOTES);
	}



}