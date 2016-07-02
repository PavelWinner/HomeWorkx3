package com.example.pavelgrynko.homeworkx3;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;


public class MainActivity extends Activity {

    Button bt_app;
    Button bt_call;
    Button bt_sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_app = (Button) findViewById(R.id.bt_app);
        bt_call = (Button) findViewById(R.id.bt_call);
        bt_sms = (Button) findViewById(R.id.bt_sms);


        View.OnClickListener onClickListener = new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bt_app:
                        Intent myIntent = new Intent(MainActivity.this,
                                SecondActivity.class);
                        startActivity(myIntent);
                        break;
                    case R.id.bt_call:
                        String phone = "+380935813687";
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        startActivity(intent);
                        break;
                    case R.id.bt_sms:
                        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                        smsIntent.setType("vnd.android-dir/mms-sms");
                        smsIntent.putExtra("sms_body", "TEXT SMS");
                        startActivity(smsIntent);
                        break;


                }

            }

        };

        bt_app.setOnClickListener(onClickListener);
        bt_call.setOnClickListener(onClickListener);
        bt_sms.setOnClickListener(onClickListener);


    }
}
