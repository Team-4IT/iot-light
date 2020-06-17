package com.tdtruong.iotlight.Model;

import android.content.Context;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
public class MQTTHelper {
    final String serverUri = "tcp://13.76.250.158:1883";
    final String clientId = "The Last";
    final String subTempTopic = "Topic/TempHumi";
    final String subLightTopic = "Topic/Light";
    final String username = "BKvm2";
    final String password = "Hcmut_CSE_2020";

    public MqttAndroidClient mqttAndroidClient;
    public MQTTHelper(Context context){
        mqttAndroidClient = new MqttAndroidClient(context, serverUri,
                clientId);
        mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
                Log.w("mqtt", s);
            }
            @Override
            public void connectionLost(Throwable throwable) {
            }
            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage)
                    throws Exception {
                Log.w("Mqtt", mqttMessage.toString());
            }
            @Override
            public void deliveryComplete(IMqttDeliveryToken
                                                 iMqttDeliveryToken) {
            }
        });
        connect(subTempTopic);
        connect(subLightTopic);
    }
    public void setCallback(MqttCallbackExtended callback) {
        mqttAndroidClient.setCallback(callback);
    }
    private void connect(final String subTopic){
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        try {
            mqttAndroidClient.connect(mqttConnectOptions, null, new
                    IMqttActionListener() {
                        @Override
                        public void onSuccess(IMqttToken asyncActionToken) {
                            DisconnectedBufferOptions disconnectedBufferOptions = new
                                    DisconnectedBufferOptions();
                            disconnectedBufferOptions.setBufferEnabled(true);
                            disconnectedBufferOptions.setBufferSize(100);
                            disconnectedBufferOptions.setPersistBuffer(false);
                            disconnectedBufferOptions.setDeleteOldestMessages(false);
                            mqttAndroidClient.setBufferOpts(disconnectedBufferOptions);
                            subscribeToTopic(subTopic);
                        }
                        @Override
                        public void onFailure(IMqttToken asyncActionToken, Throwable
                                exception) {
                            Log.w("Mqtt", "Failed to connect to: " + serverUri +
                                    exception.toString());
                        }
                    });
        } catch (MqttException ex){
            ex.printStackTrace();
        }
    }
    private void subscribeToTopic(String subTopic) {
        try {
            mqttAndroidClient.subscribe(subTopic, 0, null, new
                    IMqttActionListener() {
                        @Override
                        public void onSuccess(IMqttToken asyncActionToken) {
                            Log.w("Mqtt","Subscribed!");
                        }
                        @Override
                        public void onFailure(IMqttToken asyncActionToken, Throwable
                                exception) {Log.w("Mqtt", "Subscribed fail!");
                        }
                    });
        } catch (MqttException ex) {
            System.err.println("Exceptionst subscribing");
            ex.printStackTrace();
        }
    }
}