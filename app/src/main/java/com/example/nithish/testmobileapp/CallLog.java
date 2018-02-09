package com.example.nithish.testmobileapp;

import java.util.Date;

/**
 * Created by Nithish on 2/7/2018.
 */

public class CallLog {
    String number;
    //String Callername;
    String callDuration;
    String calledDate;
    String typeOfCall;



    public String getCalledDate() {
        return calledDate;
    }

    public void setCalledDate(String calledDate) {
        this.calledDate = calledDate;
    }


   /* public String getCallername() {
        return Callername;
    }

    public void setCallername(String callername) {
        Callername = callername;
    }*/


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        callDuration = callDuration;
    }

  


    public String getTypeOfCall() {
        return typeOfCall;
    }

    public void setTypeOfCall(String typeOfCall) {
        this.typeOfCall = typeOfCall;
    }
}
