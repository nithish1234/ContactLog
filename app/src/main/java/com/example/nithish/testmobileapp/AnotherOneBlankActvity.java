package com.example.nithish.testmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnotherOneBlankActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_one_blank_actvity);
        Intent FromAnotherOneBlankActvity= getIntent();
    }

}
