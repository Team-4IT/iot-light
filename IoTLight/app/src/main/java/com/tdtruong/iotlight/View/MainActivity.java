package com.tdtruong.iotlight.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.tdtruong.iotlight.Model.Device;
import com.tdtruong.iotlight.Model.MQTTHelper;
import com.tdtruong.iotlight.R;
import com.tdtruong.iotlight.adapter.DeviceAdapter;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MQTTHelper mqttHelper;
    private static RecyclerView rvListDevice;
    private static ArrayList<Device> mDevices;
    private static DeviceAdapter mDeviceAdapter;


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        rvListDevice = findViewById(R.id.recyclerview_device);
        mDevices = new ArrayList<>();

        creatDeviceList();

        mDeviceAdapter = new DeviceAdapter(this,mDevices);
        rvListDevice.setAdapter(mDeviceAdapter);
        rvListDevice.setLayoutManager(new LinearLayoutManager(this));
    }

    private void creatDeviceList() {
        Device mDevice1 = new Device("Device1","0",30,30);
        Device mDevice2 = new Device("Device2","1",40,40);
        mDevices.add(mDevice1);
        mDevices.add(mDevice2);
    }

    private void addEvents() {

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
                String temp_humi = jsonObject.getString("values");

                JSONArray arr_value = new JSONArray(temp_humi);
                String str_temp = arr_value.getString(0);
                String str_humi = arr_value.getString(1);
                float temperature = Float.parseFloat(str_temp);
                float humidity = Float.parseFloat(str_humi);


                Log.d(TAG, "messageArrived: DeviceInfo" + " " + device_id + " " + temperature + " " + humidity);

                // Handle data

                // Load Device

            }
            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            }
        });
    }
}
