package com.example.nithish.testmobileapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nithish on 2/7/2018.
 */

public class CallLogAdapter extends ArrayAdapter<CallLog> {
    private final Context context;
    private List<CallLog> callLogs;

    public CallLogAdapter(@NonNull Context context, @NonNull List<CallLog> callLogs) {
        super(context, -1, callLogs);
        this.context = context;
        this.callLogs = callLogs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.call_log, parent, false);
        TextView callerNumber = (TextView) rowView.findViewById(R.id.ph_number);
        TextView callerType = (TextView) rowView.findViewById(R.id.type_of_call);
        TextView callerDuration = (TextView) rowView.findViewById(R.id.duration_of_call);
        TextView callerDate = (TextView) rowView.findViewById(R.id.date_of_call);
       // TextView callername = (TextView) rowView.findViewById(R.id.name_of_the_caller);





        callerNumber.setText(callLogs.get(position).getNumber());
        callerType.setText(callLogs.get(position).getTypeOfCall());
        callerDuration.setText(callLogs.get(position).getCallDuration());
        callerDate.setText(callLogs.get(position).getCalledDate());
        //callername.setText(callLogs.get(position).getCallername());


        return rowView;
    }
}
