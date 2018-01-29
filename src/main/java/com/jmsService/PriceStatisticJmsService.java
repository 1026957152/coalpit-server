package com.jmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

/*import com.coalvalue.service.BaseServiceImpl;
import com.coalvalue.service.MessageService;
import com.coalvalue.service.ServerService;
import com.coalvalue.weixin.util.MessageUtil;*/


@Service
public class PriceStatisticJmsService extends JmsBaseService {

    public static final String myTopic_messages = "queue.solrMessages";
    private static final String myTopic_responseMessages = "myTopic.chatResponseMessages";
	private final JmsTemplate jmsTemplate;

/*    @Autowired
    MessageService messageService;*/

/*    @Autowired
    ServerService serverService;*/
    @Autowired
	public PriceStatisticJmsService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

    private ExecutorService executorService;


    public void sendMessage(String queueRequest) {
        jmsTemplate.send(myTopic_messages, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage objMessage = session.createTextMessage(queueRequest);
                System.out.println("send messgae  request -------------------- ");
                return objMessage;
            }

        });

    }



/*
    @JmsListener(destination = myTopic_responseMessages, containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(String email) {
        System.out.println("Received <" + email + ">");
        String[] strings = email.split(":",2);
        if(strings.length != 1){
            CrunchifyMessage crunchifyMessage = new CrunchifyMessage();
            crunchifyMessage.setOpenId(strings[0]);
            crunchifyMessage.setCrunchifyMsg(strings[1]);
            crunchifyMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            messageService.sendCustomMessage(crunchifyMessage);
        }



      //  sendMessage(email);

    }*/

    public void sendMessage(String fromUserName, String content) {



     /*   if(serverService.isServiceReady(ServiceTypeEnum.Hubot)){
            if(POWER_COMMANDS.contains(content)){
                if(POWER_USERS.contains(fromUserName)){//# User is allowed access to this command
                    //next();
                    Map map= new HashMap<>();
                    map.put("from", fromUserName);
                    map.put("message", "wu " +content);
                    String jsonString = JSON.toJSONString(map);
                    sendMessage(jsonString);

                }else{// # Restricted command, but user isn't in whitelist

                    // done()
                    System.out.print("I'm sorry, @#{context.response.message.user.name}, but you don't have access to do that.");
                }
            }else{// # This is not a restricted command; allow everyone
                //next();
                Map map= new HashMap<>();
                map.put("from", fromUserName);
                map.put("message", "wu "  +content);
                String jsonString = JSON.toJSONString(map);
                sendMessage(jsonString);
            }
        }else{
            logger.error("--------------------------------- Hubot Service Not Ready");
        }

*/




    }

    List POWER_COMMANDS = Arrays.asList("deploy.web");// # String that matches the listener ID


    List POWER_USERS = Arrays.asList("jdoe");// # String that matches the user ID set by the adapter


}