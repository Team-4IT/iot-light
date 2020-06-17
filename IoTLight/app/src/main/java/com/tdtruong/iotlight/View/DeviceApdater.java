package com.tdtruong.iotlight.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tdtruong.iotlight.R;

public class DeviceApdater extends AppCompatActivity {
    private TextView txtDeviceName;
    private TextView txtTemperature;
    private TextView txtHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_item);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        txtDeviceName = findViewById(R.id.device_id);
        txtTemperature = findViewById(R.id.txt_temperature);
        txtHumidity = findViewById(R.id.txt_humidity);
    }
}