package com.tdtruong.iotlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.tdtruong.iotlight.Model.Notification;
import com.tdtruong.iotlight.adapter.AdapterNotification;

import java.util.ArrayList;

public class warningNotification extends AppCompatActivity {

    ListView lstwarn;
    //    ArrayAdapter<String> arrayAdapter;
    ArrayList warnList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_notification);

        lstwarn = findViewById(R.id.lstwarning);

        warnList.add(new Notification("Thien", "Cao 1m82 , body 6 mui , nguc no vong cung",R.drawable.humedity));
        warnList.add(new Notification("Tho", "Cao 1m7 , body nhu cc , nguc max fault",R.drawable.temperature));
        warnList.add(new Notification("Truong", "max on , em gai mua hoi nhieu",R.drawable.warning));

        final AdapterNotification myAdapter = new AdapterNotification(this,R.layout.customview,warnList);
        lstwarn.setAdapter(myAdapter);

    }
}
