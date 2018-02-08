package com.example.nithish.testmobileapp;

/**
 * Created by Nithish on 2/7/2018.
 */

public class CallLog {
    String number;
    String callDuration;
    String calledDate;
    String typeOfCall;

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

    public String getCalledDate() {
        return calledDate;
    }

    public void setCalledDate(String calledDate) {
        calledDate = calledDate;
    }

    public String getTypeOfCall() {
        return typeOfCall;
    }

    public void setTypeOfCall(String typeOfCall) {
        this.typeOfCall = typeOfCall;
    }
}
