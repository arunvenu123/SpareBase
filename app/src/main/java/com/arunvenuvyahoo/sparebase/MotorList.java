package com.arunvenuvyahoo.sparebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MotorList extends ArrayAdapter<Motor> {

    private Activity context;
    private List<Motor> motorList;

    public MotorList( Activity context, List<Motor> motorList) {
        super(context, R.layout.motor_listview, motorList);
        this.context = context;
        this.motorList = motorList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater  = context.getLayoutInflater();
        View motorListViewItem = inflater.inflate(R.layout.motor_listview,null,true);

        TextView makeListview = (TextView) motorListViewItem.findViewById(R.id.makeList);
        TextView machineListview = (TextView) motorListViewItem.findViewById(R.id.machineList);
        TextView locationListview = (TextView) motorListViewItem.findViewById(R.id.locationList);
        TextView detailsListView = (TextView) motorListViewItem.findViewById(R.id.detailsList);

        Motor motor = motorList.get(position);
        makeListview.setText(motor.getMakeOfMotor());
        machineListview.setText(motor.getMachineUsed());
        locationListview.setText(motor.getLocationOfmotor());
        detailsListView.setText(motor.getDetailsOfMotor());

        return motorListViewItem;


    }
}
