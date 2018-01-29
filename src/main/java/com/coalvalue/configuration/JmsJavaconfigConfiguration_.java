package com.coalvalue.configuration;


import com.jmsService.PriceStatisticJMSListener;
import com.jmsService.PriceStatisticJmsService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.*;

//@Configuration
public class JmsJavaconfigConfiguration_ {
  private static final String JMS_BROKER_URL = "vm://embedded?broker.persistent=false,useShutdownHook=false";

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";



    private static final String ORDER_QUEUE = "order-queue";


    @Autowired
    private PriceStatisticJMSListener priceStatisticJMSListener;




    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        //connectionFactory.setTrustedPackages(Arrays.asList("com.websystique.springmvc"));
        return connectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory,
                                                               DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);

        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory,
                                                               DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        //factory.setPubSubDomain(true);
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        ;
        return factory;
    }



    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        template.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);



        template.setReceiveTimeout(10000);
        return template;
    }

    @Bean
    DefaultMessageListenerContainer priceStatistic(ConnectionFactory connectionFactory) throws Exception {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(priceStatisticJMSListener);
        container.setDestinationName(PriceStatisticJmsService.myTopic_messages);
        container.setSessionAcknowledgeMode(4);
        //  container.setTaskExecutor(taskExecutor());

        return container;
    }


}