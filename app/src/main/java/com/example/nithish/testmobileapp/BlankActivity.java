package com.example.nithish.testmobileapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BlankActivity extends AppCompatActivity {
    private static final int REQUEST_READ_CALL_LOGS = 1;
    private List<com.example.nithish.testmobileapp.CallLog> callLogs = new ArrayList<>();
    public ListView callLogList;
    public CallLogAdapter callLogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        callLogList = findViewById(R.id.CallLog);
        Intent fromMainActivitIntent = getIntent();
        callLogAdapter = new CallLogAdapter(getApplicationContext(), getCallLogAccess());
        callLogList.setAdapter(callLogAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (REQUEST_READ_CALL_LOGS) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getCallLogAccess();
                    Log.i("Tag", "onRequestPermissionsResult: inside case 1");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    Toast.makeText(this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }

            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public List<com.example.nithish.testmobileapp.CallLog> getCallLogAccess() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            boolean hasPermission = (ContextCompat.checkSelfPermission(getBaseContext(),
                    Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED);
            if (!hasPermission) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG},
                        REQUEST_READ_CALL_LOGS);
                getCallLogAccess();
            }
        }
        Log.i("TAG", "getCallLogAccess: Inside this method");
        Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int CallerNumber = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        // int Callername=cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
        int CalledDate = cursor.getColumnIndex(CallLog.Calls.DATE);
        int Callduration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        int Calltype = cursor.getColumnIndex(CallLog.Calls.TYPE);
        StringBuilder CallDetials = new StringBuilder();
        while (cursor.moveToNext()) {
            com.example.nithish.testmobileapp.CallLog callLog = new com.example.nithish.testmobileapp.CallLog();
            callLog.setNumber(cursor.getString(CallerNumber));
            callLog.setCallDuration(cursor.getString(Callduration));
/*
            SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
*/
            callLog.setCalledDate((cursor.getString(CalledDate)));


            // String CallernameS=cursor.getString(Callername);
            /*Date dateS = new Date(CalledDateS);*/
            switch (Integer.parseInt(cursor.getString(Calltype))) {
                case CallLog.Calls.OUTGOING_TYPE:
                    callLog.setTypeOfCall("Outgoing");
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    callLog.setTypeOfCall("MissedCalls");
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    callLog.setTypeOfCall("Incomming Calls");
                    break;


            }
            /*if(CallTypeStr=="MissedCalls"){
                Log.i("info","got missed calls");
            }*/
            callLogs.add(callLog);



        /*    for (int i=0; i<=CallDetials.length();i++){
                if(CallTypeStr=="Missedcalls"){
                    List<String>missedCalls=new ArrayList<>();
                    missedCalls.addAll()
                }
        }*/


        }
/*
        Log.v("Data From Activity", fromMainActivitIntent.getStringExtra("Hai"));
*/
        return callLogs;
    }
}
