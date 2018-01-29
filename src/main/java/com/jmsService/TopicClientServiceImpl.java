package com.jmsService;

import com.coalvalue.domain.CrunchifyMessage;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.util.concurrent.ExecutorService;


@Service
public class TopicClientServiceImpl {
    private static final String myTopic_messages = "myTopic.messages";
	private static final String myTopic_accessToken = "myTopic.accessToken";
    private static final String myTopic_controll_accessToken = "myTopic.controller.accessToken";
	private final JmsTemplate jmsTemplate;




    @Autowired
	public TopicClientServiceImpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        BasicThreadFactory factory = new BasicThreadFactory.Builder()
                .namingPattern("myspringbean-thread-%d").build();
        AccessTokenThread accessTokenThread = new AccessTokenThread();
/*        executorService =  Executors.newSingleThreadExecutor(factory);
        executorService.execute(accessTokenThread );
        executorService.shutdown();*/
    }

    private class AccessTokenThread implements Runnable {


        @Override
        public void run() {
            System.out.println("begin into access tocken get process");

            while (true) {

                    for(int i =0;i<10;i++){
                        String message = "message_" + System.currentTimeMillis();
                        sendMessage(message);
                        System.out.println(message);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }




            }
        }
    }

    public void sendMessage(String queueRequest) {
        jmsTemplate.send(myTopic_messages, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage objMessage = session.createTextMessage(queueRequest);
                return objMessage;
            }

        });

    }


    @JmsListener(destination =myTopic_controll_accessToken)// "in.queue.ms")
    public void receiveTemplateMessage(CrunchifyMessage message) {

        System.out.println(" ========== we have recieve message in queue  :" +myTopic_controll_accessToken +"     WITH CONTENT" + message.toString());

        if(message.getOpenId() != null){
            //runService.runMessageTemplate(message);
        }else {
            System.out.println("openId is null:" +"in queue   :" + myTopic_controll_accessToken );
        }


    }




}