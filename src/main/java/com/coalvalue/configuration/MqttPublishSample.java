package com.coalvalue.configuration;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttPublishSample {

    String topic        = "MQTT Examples";
    String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://localhost:1883";
    String clientId     = "JavaSample";


    public  MqttAsyncClient mqttClient;

        private class DemoCallback implements MqttCallback {

        public void connectionLost(Throwable cause) {
            System.out.println("Connection lost - attempting reconnect.");
           // mqttClient =  connect();

        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken arg0) {
            // Not needed in this simple demo
        }

        @Override
        public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
            mqttReceiver.messageArrived(arg0,arg1);
            // Not needed in this simple demo
        }



            public void connectComplete(boolean reconnect, String serverURI) {
                if (reconnect) {
                    System.out.println("Connection Reconnected! To: " + serverURI);
                } else {
                    System.out.println("Initial Connection! To: " + serverURI);
                    //  sync.doNotify();
                }
                addSubscriptions();
            }
    }

    MemoryPersistence persistence = new MemoryPersistence();

    DemoCallback demoCallback = new DemoCallback();
    MqttReceiver mqttReceiver = new MqttReceiver();
@Bean
public MqttAsyncClient mqttClient() {



    mqttClient =  connect();

    return mqttClient;


}
    /**
     *
     */
    public void addSubscriptions() {
        try {
            // topics on m2m.io are in the form <domain>/<stuff>/<thing>
            mqttClient.subscribe(topic,0);

        } catch (MqttSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public MqttAsyncClient  connect() {
        try {
            MqttConnectOptions connOpt = new MqttConnectOptions();
            connOpt.setCleanSession(false);
            connOpt.setKeepAliveInterval(30);
            connOpt.setConnectionTimeout(60);
            connOpt.setAutomaticReconnect(true);

            String[] brokerList = new String[1];
            brokerList[0] = broker;
            //brokerList[1] = BROKER_URL2;
            connOpt.setServerURIs(brokerList);



            DisconnectedBufferOptions bufferOpts = new DisconnectedBufferOptions();
            bufferOpts.setBufferEnabled(true);
            bufferOpts.setBufferSize(100);            // 100 message buffer
            bufferOpts.setDeleteOldestMessages(true); // Purge oldest messages when buffer is full
            bufferOpts.setPersistBuffer(false);       // Do not buffer to disk

            //MqttClient sampleClient = new MqttClient(broker, clientId, persistence);

            MqttAsyncClient sampleClient = new MqttAsyncClient(brokerList[0], clientId, persistence);// new MqttClient(broker, clientId, persistence);

            sampleClient.setBufferOpts(bufferOpts);

            System.out.println("Connecting to broker: "+broker);

            IMqttToken mqttToken = sampleClient.connect(connOpt);
            if (mqttToken.isComplete())
            {
                if (mqttToken.getException() != null)
                {
                    // TODO: retry
                }
            }


           // sampleClient.setCallback(demoCallback);
          //  sampleClient.subscribe(topic,0);
            return sampleClient;

        }catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
            return null;
        }



   /*     // TODO Auto-generated method stub
        mqttClient = new MqttClient("mqtt://localhost", "pubsub-1");
        mqttClient.setCallback(callback);
        mqttClient.connect();
        mqttClient.subscribe(topics);*/
    }
}