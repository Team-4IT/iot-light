package com.tdtruong.iotlight.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tdtruong.iotlight.Model.SplitData;
import com.tdtruong.iotlight.R;

public class DeviceActivity extends AppCompatActivity {
    private TextView txtDeviceName;
    private TextView txtTemperature;
    private TextView txtHumidity;
    private String name = "Null";
    private int temperature = 0;
    private int humidity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_activity);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        txtDeviceName = findViewById(R.id.device_id);
        txtTemperature = findViewById(R.id.txt_temperature);
        txtHumidity = findViewById(R.id.txt_humidity);

        txtTemperature.setText(this.temperature +"oC");
        txtHumidity.setText(this.humidity+"%");
    }
    public void getData(SplitData data){
        this.temperature = data.getTemp();
        this.humidity = data.getHumi();
    }
    public void getName(String name){
        this.name = name;
    }
}