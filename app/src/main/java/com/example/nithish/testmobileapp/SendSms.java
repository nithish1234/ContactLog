package com.example.nithish.testmobileapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SendSms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BlankActivity activity=new BlankActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.setData(Uri.parse("sms:" + activity.getCallLogAccess().get(activity.CallerNumber)));
        startActivity(smsIntent);


    }

}
