package com.iflytek;


import com.coalvalue.configuration.MqttReceiver;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttReceiveSample {

public static void main(String[] args) {

    String topic        = "MQTT Examples";
    String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://0.0.0.0:1883";
    String clientId     = "JavaSample";
    MemoryPersistence persistence = new MemoryPersistence();

    MqttReceiver pahoDemo = new MqttReceiver();
    try {
        MqttClient sampleClient = new MqttClient(broker, MqttClient.generateClientId(), persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        System.out.println("Connecting to broker: "+broker);

        sampleClient.setCallback(pahoDemo);
        sampleClient.connect(connOpts);

        sampleClient.subscribe(topic);



        System.out.println("Connected");




/*

        sampleClient.disconnect();
        System.out.println("Disconnected");
        System.exit(0);*/
    } catch(MqttException me) {
        System.out.println("reason "+me.getReasonCode());
        System.out.println("msg "+me.getMessage());
        System.out.println("loc "+me.getLocalizedMessage());
        System.out.println("cause "+me.getCause());
        System.out.println("excep "+me);
        me.printStackTrace();
    }
}
}