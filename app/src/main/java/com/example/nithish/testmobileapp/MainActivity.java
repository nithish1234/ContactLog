package com.example.nithish.testmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeName(View v) {
        Intent blankActiviIntent = new Intent(this,BlankActivity.class);
/*        TextView txtView=findViewById(R.id.txtId);
        txtView.setText("smaple spacing");
        blankActiviIntent.putExtra("Hai","Hello");*/
        startActivity(blankActiviIntent);
    }


}
