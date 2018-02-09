package com.example.nithish.testmobileapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlankActivity extends AppCompatActivity {
    private static final int REQUEST_READ_CALL_LOGS = 1;
    private List<com.example.nithish.testmobileapp.CallLog> callLogs = new ArrayList<>();
    List<com.example.nithish.testmobileapp.CallLog> missedCallList = new ArrayList<>();

    public ListView callLogList;
    public CallLogAdapter callLogAdapter;
   public int CallerNumber;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        callLogList = findViewById(R.id.CallLog);
        Intent fromMainActivitIntent = getIntent();


        callLogAdapter = new CallLogAdapter(getApplicationContext(), getCallLogAccess());
        callLogList.setAdapter(callLogAdapter);
        button = findViewById(R.id.sendMessageBtn);

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
        final int CallerNumber = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        //int Callername=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int CalledDate = cursor.getColumnIndex(CallLog.Calls.DATE);
        int Callduration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        int Calltype = cursor.getColumnIndex(CallLog.Calls.TYPE);

        while (cursor.moveToNext()) {
            com.example.nithish.testmobileapp.CallLog callLog = new com.example.nithish.testmobileapp.CallLog();
            callLog.setNumber(cursor.getString(CallerNumber));
            callLog.setCallDuration("duration" + cursor.getString(Callduration));
            // CalledDateS.format(callLog.setCalledDate(cursor.getString(CalledDate)));            SimpleDateFormat CalledDateS=new SimpleDateFormat("dd/MM/yyyy");

            callLog.setCallDuration(cursor.getString(Callduration));


            switch (Integer.parseInt(cursor.getString(Calltype))) {
                case CallLog.Calls.OUTGOING_TYPE:
                    callLog.setTypeOfCall("OutgoingCall");
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    callLog.setTypeOfCall("MissedCall");
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    callLog.setTypeOfCall("Incomming Call");
                    break;
                case CallLog.Calls.REJECTED_TYPE:
                    callLog.setTypeOfCall("Rejected Call");


            }

            callLogs.add(callLog);
            for (int i = 0; i < callLogs.size(); i++) {
                if (callLogs.get(i).getTypeOfCall().equals("MissedCall")) {
                    missedCallList.add(callLogs.get(i));
                    break;
                }
            }
        }

        return missedCallList;





    }






}