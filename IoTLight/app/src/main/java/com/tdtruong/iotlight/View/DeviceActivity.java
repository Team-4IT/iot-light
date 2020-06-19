package com.tdtruong.iotlight.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tdtruong.iotlight.Model.SplitData;
import com.tdtruong.iotlight.R;

public class DeviceActivity extends AppCompatActivity {
    private String name = "Null";
    private int temperature = 0;
    private int humidity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_activity);
        Log.w("inside","DeviceActivity");

        displayOnScreen();
    }
    public void getData(SplitData data){
        this.temperature = data.getTemp();
        this.humidity = data.getHumi();
        displayOnScreen();
    }
    public void getName(String name){
        this.name = name;
    }

    protected void displayOnScreen(){
        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        TextView txtDeviceName = findViewById(R.id.device_id);
        TextView txtTemperature = findViewById(R.id.txt_temperature);
        TextView txtHumidity = findViewById(R.id.txt_humidity);
        txtDeviceName.setText(this.name);
        txtTemperature.setText(this.temperature +"oC");
        txtHumidity.setText(this.humidity+"%");
    }
}