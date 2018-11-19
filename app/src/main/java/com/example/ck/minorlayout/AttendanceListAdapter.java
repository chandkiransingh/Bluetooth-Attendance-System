package com.example.ck.minorlayout;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AttendanceListAdapter extends ArrayAdapter<DeviceItem> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<DeviceItem> mDevices;
    private int  mViewResourceId;

    public AttendanceListAdapter(Context context, int tvResourceId, ArrayList<DeviceItem> devices){
       //todo check this ritik
        super(context, tvResourceId,devices);
        this.mDevices = devices;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = tvResourceId;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(mViewResourceId, null);
        Log.d("Ritik", "getView: "+position);
        TextView deviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

                deviceName.setText(mDevices.get(position).Name);

        Log.d("Ritik", "getView: "+position+mDevices.get(position).selected);
        if(mDevices.get(position).selected!=null)
            checkBox.setChecked(mDevices.get(position).selected);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mDevices.get(position).selected=isChecked;
            }
        });
        return convertView;
    }

    public ArrayList<DeviceItem> getmDevices(){
        return mDevices;
    }
    public void check(int position){
        Log.d("Ritik", "check: function");
        mDevices.get(position).selected=true;
        notifyDataSetChanged();
    }


}