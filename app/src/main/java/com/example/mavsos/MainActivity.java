package com.example.mavsos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_alarm;
    EditText editNum;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alarm = (Button)findViewById(R.id.btn2);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.s1);

        btn_alarm.setOnClickListener (new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mp.start();
           }

        });

        ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        editNum = findViewById(R.id.editNum);
        btn = (Button)findViewById(R.id.emergeButton);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String message = "I am at School. I am in Trouble. Please Send Help";
                String number = editNum.getText().toString();

                SmsManager mySM = SmsManager.getDefault();
                mySM.sendTextMessage(number, null, message, null, null);

            }
        });

    }

}