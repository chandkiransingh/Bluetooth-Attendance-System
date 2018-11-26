package com.example.ck.minorlayout;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class attandance4 extends AppCompatActivity {
    private static final String TAG = "register4";
    ArrayList<String> alreadyDevices=new ArrayList<>();
    ArrayList<String> prenties= new ArrayList<>();
    BluetoothAdapter mBluetoothAdapter;
    public ArrayList<BluetoothDevice> mBTDevices = new ArrayList<>();
    public DeviceListAdapter mDeviceListAdapter;
    ListView lvNewDevices,savedDevices;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    String branchcompare;
    public ArrayList<DeviceItem> listes = new ArrayList<>();
    String branch,email,subjects,teacher;
    AttendanceListAdapter mAttendanceListAdapter;
    Button submitBtn;
    CheckBox checkBox;
    TextView nodevices;
    int count;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attandance4);
        Button btnONOFF = (Button) findViewById(R.id.btnONOFF);
        savedDevices = (ListView) findViewById(R.id.savedDevices);
        lvNewDevices = (ListView) findViewById(R.id.lvNewDevices);
        submitBtn=findViewById(R.id.submitBtn);
        checkBox= findViewById(R.id.select_all);
        nodevices = findViewById(R.id.nodevices);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAll(isChecked);
                // count++; //count the number of times select all value is clicked
                // Log.d(TAG, "onCheckedChanged: count value is : "+count);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAttendance();
            }
        });

        mBTDevices = new ArrayList<>();
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        btnONOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: enabling/disabling bluetooth.");
                enableDisableBT();
            }
        });

    }

    // Create a BroadcastReceiver for ACTION_FOUND
    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);
                switch(state){
                    case BluetoothAdapter.STATE_OFF:
                        Log.d(TAG, "onReceive: STATE OFF");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Log.d(TAG, "mBroadcastReceiver1: STATE TURNING OFF");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Log.d(TAG, "mBroadcastReceiver1: STATE ON");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.d(TAG, "mBroadcastReceiver1: STATE TURNING ON");
                        break;
                }
            }
        }
    };


    /**
     * Broadcast Receiver for changes made to bluetooth states such as:
     * 1) Discoverability mode on/off or expire.
     */
    private final BroadcastReceiver mBroadcastReceiver2 = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)) {

                int mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR);

                switch (mode) {
                    //Device is in Discoverable Mode
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Enabled.");
                        break;
                    //Device not in discoverable mode
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Disabled. Able to receive connections.");
                        break;
                    case BluetoothAdapter.SCAN_MODE_NONE:
                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Disabled. Not able to receive connections.");
                        break;
                    case BluetoothAdapter.STATE_CONNECTING:
                        Log.d(TAG, "mBroadcastReceiver2: Connecting....");
                        break;
                    case BluetoothAdapter.STATE_CONNECTED:
                        Log.d(TAG, "mBroadcastReceiver2: Connected.");
                        break;
                }

            }
        }
    };


    /**
     * Broadcast Receiver for listing devices that are not yet paired
     * -Executed by btnDiscover() method.
     */


    private BroadcastReceiver mBroadcastReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            final HashMap<String, DeviceItem> maps = new HashMap<String, DeviceItem>();
            Log.d(TAG, "onReceive: ACTION FOUND.");

            if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                final BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                //todo added by ritik
                if(!mBTDevices.contains(device))
                mBTDevices.add(device);
                Log.d(TAG, "onReceive: " + device.getName() + ": " + device.getAddress());
                mDeviceListAdapter = new DeviceListAdapter(context, R.layout.device_adapter_view, mBTDevices);
                lvNewDevices.setAdapter(mDeviceListAdapter);
                checkFound();
                final HashMap<String, String> map = new HashMap<>();
                map.put(device.getName(), device.getAddress());
                Log.d(TAG, "map value is: " + map);
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

                intent = getIntent();
                 branch = intent.getStringExtra("branch");
                 email = intent.getStringExtra("email");
                 subjects = intent.getStringExtra("subjects");
                 teacher = intent.getStringExtra("teacher");

                Log.d(TAG, "onReceive:  device name is : "+device.getName());
                branchcompare = device.getName();
                if(branchcompare!=null && branchcompare.length()>7)
                {
                    branchcompare = device.getName().substring(3, 5);
                }
                else
                {
                    Log.d(TAG, "onReceive: device name is not valid");
                }

                Log.d(" branch ", "onReceive: branch compare: "+branchcompare+" branch: "+branch);

                if (branch.equals(branchcompare)) {
                    // Toast.makeText(register4.this, "device registered" + device.getName(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onReceive: device name is correct");
                   // myRef.child(email).child(teacher).child(branch).child(subjects).child(device.getAddress()).child(String.valueOf(date)).setValue(device.getName());
                }

                else {
                    Log.d(TAG, "onReceive: device name not correct");
                    //Toast.makeText(register4.this,"Change device name to roll number 99ICS999",Toast.LENGTH_SHORT).show();
                }


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference emails = database.getReference(email);
                DatabaseReference teahers = emails.child(teacher);
                final DatabaseReference branches = teahers.child(branch);
                DatabaseReference subject = branches.child(subjects);

                subject.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //get all key and values
                        for(DataSnapshot obj:dataSnapshot.getChildren())
                        {
                            String key = obj.getKey();                  // MAC Adddress
                            String value = obj.getValue().toString();   //date and roll number
                            Log.d("Key and Value", "onDataChange: " + key + "and value: " + value);
                            int length = (value).length();
                            String finalvalue = value.substring(length-9,length-1);  // here we get the roll number
                            Log.d(" length ", "onDataChange: length  "+length);
                            Log.d(finalvalue, "onDataChange: finalvalue  "+finalvalue);

                            DeviceItem deviceItem = new DeviceItem();


                            branchcompare = finalvalue;
                            if(branchcompare!=null && branchcompare.length()>7)
                            {
                                branchcompare = finalvalue.substring(3, 5);
                            }
                            else
                            {
                                Log.d(TAG, " device name is not valid");
                            }

                            Log.d(" branch ", "onReceive: branch compare: "+branchcompare+" branch: "+branch);

                            if (branch.equals(branchcompare)) {
                                deviceItem.Name = finalvalue;
                                deviceItem.Address=key;
                                Log.d("branch", "cksingh"+finalvalue);
                            }

                            else {
                                Log.d(TAG, "onReceive: device name not correct");
                                //Toast.makeText(register4.this,"Change device name to roll number 99ICS999",Toast.LENGTH_SHORT).show();
                            }



                            if(!alreadyDevices.contains(deviceItem.Address) && branch.equals(branchcompare))
                            {
                                listes.add(deviceItem);
                                alreadyDevices.add(deviceItem.Address);
                            }
                        }
                        Log.d("Ritik", "onDataChange: "+maps.toString());

                        //listes = new ArrayList<DeviceItem>(maps.values());
                        Log.d("Ritik", "devices size: "+listes.size());
                        //ListAdapter arrayAdapter = new ArrayAdapter<String>(attandance4.this,android.R.layout.simple_list_item_1,listes);

                        mAttendanceListAdapter = new AttendanceListAdapter(attandance4.this, R.layout.attendance_adapter_view, listes);
                       //nodevices.setText(""+listes.size());

                        savedDevices.setAdapter(mAttendanceListAdapter);
                        // savedDevices.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        }
    };


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver1);
        unregisterReceiver(mBroadcastReceiver2);
        //mBluetoothAdapter.cancelDiscovery();
    }

    public void enableDisableBT(){
        if(mBluetoothAdapter == null){
            Log.d(TAG, "enableDisableBT: Does not have BT capabilities.");
        }
        if(!mBluetoothAdapter.isEnabled()){
            Log.d(TAG, "enableDisableBT: enabling BT.");
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
        if(mBluetoothAdapter.isEnabled()){
            Log.d(TAG, "enableDisableBT: disabling BT.");
            mBluetoothAdapter.disable();

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }


    }


    public void btnDiscover(View view) {
        Log.d(TAG, "btnDiscover: Looking for unpaired devices.");

        if(mBluetoothAdapter.isDiscovering()){
            mBluetoothAdapter.cancelDiscovery();
            Log.d(TAG, "btnDiscover: Canceling discovery.");
            mBTDevices.clear();

            //check BT permissions in manifest
            checkBTPermissions();

            mBluetoothAdapter.startDiscovery();
            IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mBroadcastReceiver3, discoverDevicesIntent);
        }
        if(!mBluetoothAdapter.isDiscovering()){

            //check BT permissions in manifest
            checkBTPermissions();
            mBTDevices.clear();
            mBluetoothAdapter.startDiscovery();
            IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mBroadcastReceiver3, discoverDevicesIntent);
        }
    }

    /**
     * This method is required for all devices running API23+
     * Android must programmatically check the permissions for bluetooth. Putting the proper permissions
     * in the manifest is not enough.
     *
     * NOTE: This will only execute on versions > LOLLIPOP because it is not needed otherwise.
     */
    private void checkBTPermissions() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
            }
        }

        else{
            Log.d(TAG, "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.");
        }
    }


    public void submitAttendance(){

        ArrayList<DeviceItem> attendance = mAttendanceListAdapter.getmDevices();
        for(int i=0;i<attendance.size();i++){
            DeviceItem student = attendance.get(i);
            if(student.selected)
            {
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Log.d("Ritik", "submitAttendance: "+email+teacher+branch+subjects+student.Address+student.Name+date);
                myRef.child(email).child(teacher).child(branch).child(subjects).child(student.Address).child(date).setValue(student.Name);
                myRef.child(email).child(teacher).child(branch).child(subjects).child("TotalDate").child(date).setValue("P");
                Toast.makeText(attandance4.this,"Attendance Submitted successfully",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Log.d(TAG, "submitAttendance: students not selected ");
               // Toast.makeText(attandance4.this,"Select Students first",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void checkAll(Boolean selection)
    {
        for(int i=0;i<listes.size();i++)
            listes.get(i).selected=selection;
        Log.d("cksingh", "selected "+listes);
        mAttendanceListAdapter.notifyDataSetChanged();
    }

    public void checkFound(){
        Log.d("Ritik", "checkFound: ");


        for(int i=0;i<mBTDevices.size();i++) {

            prenties.add(mBTDevices.get(i).getAddress());
            Log.d("Ritik", "checkFound: "+mBTDevices.get(i).getAddress());
        }
        Log.d("Ritik", "checkFound: size of devices"+prenties.size());

        for(int j=0;j<listes.size();j++) {

            Log.d(TAG, "sssssss: "+listes.get(j).Address);
            if (prenties.contains(listes.get(j).Address)) {

                Log.d("Ritik", "checking"+listes.get(j).Name);
                if (mAttendanceListAdapter != null)
                    mAttendanceListAdapter.check(j);
            }
        }


    }
    public void onBackPressed() {
        finish();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
