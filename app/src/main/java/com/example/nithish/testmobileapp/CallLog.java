package com.example.nithish.testmobileapp;

import java.util.Date;

/**
 * Created by Nithish on 2/7/2018.
 */

public class CallLog {
    String number;
   // String  callerName;
    String callDuration;
    Date calledDate;
    String typeOfCall;



    public Date getCalledDate() {
        return  calledDate;
    }

    public void setCalledDate(Date calledDate) {
        this.calledDate = calledDate;
    }


//    public String getCallername() {
//        return callerName;
//    }
//
//    public void setCallername(String callerName) {
//        callerName = callerName;
//    }


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
