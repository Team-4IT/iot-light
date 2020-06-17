package com.tdtruong.iotlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tdtruong.iotlight.Model.MQTTHelper;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    MQTTHelper mqttHelper;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void startMQTT(){
        mqttHelper = new MQTTHelper(getApplicationContext());
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
                Log.d("mqtt data","complete" );
            }
            @Override
            public void connectionLost(Throwable throwable) {
                Log.d("mqtt data","lost" );
            }
            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage)
                    throws Exception {

                JSONArray jsonArray = new JSONArray(mqttMessage.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String device_id = jsonObject.getString("device_id");
                String location = jsonObject.getString("values");

                JSONArray arr_value = new JSONArray(location);
                String str_longitude = arr_value.getString(0);
                String str_latitude = arr_value.getString(1);
                float longitude = Float.parseFloat(str_longitude);
                float latitude = Float.parseFloat(str_latitude);


                Log.d(TAG, "messageArrived: DeviceInfo" + " " + device_id + " " + longitude + " " + latitude);

                // Handle data

                // Load Device

            }
            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            }
        });
    }
}
