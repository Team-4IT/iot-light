package com.tdtruong.iotlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginApp extends AppCompatActivity {

    EditText edtuser , edtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);

        edtuser = (EditText) findViewById(R.id.inputuser);
        edtpass = (EditText) findViewById(R.id.inputpass);

    }

    public void clickLogin(View view) {
        if(edtuser.getText().toString().equals("admin") && edtpass.getText().toString().equals("admin")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Login Fault , Plaese Login Again !!" , Toast.LENGTH_LONG).show();
        }
    }
}
