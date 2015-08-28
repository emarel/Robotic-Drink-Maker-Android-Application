package com.example.michael.roboticdrinkmaker;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDrink extends Activity {

    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12;
    private Button btnSubmit;
    Button itemMiddleButton;
    double values[];
    String combination = "";
    String data = "";

    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter bluetoothAdapter = null;
    private BluetoothSocket bluetoothSocket = null;
    private OutputStream outputData = null;

    // Well known SPP UUID

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // Insert your bluetooth devices MAC address
    private static String address = "98:D3:31:20:31:C1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_drink);




        addListenerOnButton();
        addListenerOnSpinnerItemSelection();


        itemMiddleButton = (Button) findViewById(R.id.itemMiddle);


        //need to work with bluetooth adapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        checkBTState();


        itemMiddleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //put code here
                for(int i = 0; i<12; i++) {
                    if (values[i] == 0) {
                        combination = combination + "M";
                    }
                    else if(values[i] == .5){
                        combination = combination + "N";
                    }
                    else if(values[i] == 1){
                        combination = combination + "O";
                    }
                    else if(values[i] == 1.5){
                        combination = combination + "P";
                    }
                    else if(values[i] == 2){
                        combination = combination + "Q";
                    }
                    else if(values[i] == 2.5){
                        combination = combination + "R";
                    }
                    else if(values[i] == 3){
                        combination = combination + "S";
                    }
                    else if(values[i] == 3.5){
                        combination = combination + "T";
                    }
                    else if(values[i] == 4){
                        combination = combination + "U";
                    }
                    else if(values[i] == 4.5){
                        combination = combination + "V";
                    }
                    else if(values[i] == 5){
                        combination = combination + "W";
                    }
                    else if(values[i] == 5.5){
                        combination = combination + "X";
                    }
                    else
                    {
                        combination = "ERROR";
                    }
                }
                data = data + "A" + combination.substring(0,1);
                data = data + "B" + combination.substring(1,2);
                data = data + "C" + combination.substring(2,3);
                data = data + "D" + combination.substring(3,4);
                data = data + "E" + combination.substring(4,5);
                data = data + "F" + combination.substring(5,6);
                data = data + "G" + combination.substring(6,7);
                data = data + "H" + combination.substring(7,8);
                data = data + "I" + combination.substring(8,9);
                data = data + "J" + combination.substring(9,10);
                data = data + "K" + combination.substring(10,11);
                data = data + "L" + combination.substring(11,12);
                data = data + "YZ";


                sendData(data);
                Toast msg = Toast.makeText(getBaseContext(),
                        "Your drink is now being made!", Toast.LENGTH_SHORT);
                msg.show();
            }
        });
    }

    // add items into spinner dynamically

    private void exitApplication(String title, String message)
    {
        Toast msg = Toast.makeText(getBaseContext(),
                title + " - " + message, Toast.LENGTH_SHORT);
        msg.show();
        finish();
    }

    private void sendData(String message)
    {
        byte[] ArrayToSend = new byte[message.length()];
        char[] charmessage = message.toCharArray();
        for(int i = 0; i < message.length(); i++)
        {
            ArrayToSend[i] = (byte)charmessage[i];

        }
        try{
            outputData.write(ArrayToSend);
        }
        catch (IOException e)
        {
            String msg = "In onResume() and an exception occurred during write: " + e.getMessage();

            exitApplication("Fatal Error", msg);
        }
    }
	  	/*
		  //this is the function for the data to be sent to the bluetooth module
		    byte[] dataToBluetooth = message.getBytes();
		    try
		    {
		    	//try sending data
		      outputData.write(dataToBluetooth);
		    }
		    catch (IOException e)
		    {
		      String msg = "In onResume() and an exception occurred during write: " + e.getMessage();

		      	exitApplication("Fatal Error", msg);
		    }
		    */


    @Override
    public void onResume()
    {
        super.onResume();

        //Set up connection to the bluetooth using the MAC address
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);

        //Using the MAC address of the bluetooth and the common UUID
        try
        {
            bluetoothSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        }
        catch (IOException e)
        {
            exitApplication("Fatal Error", "In onResume() and socket create failed: " + e.getMessage() + ".");
        }
        bluetoothAdapter.cancelDiscovery();

        // Try to Establish the connection.
        try
        {
            bluetoothSocket.connect();
        }
        catch (IOException e)
        {
            try
            {
                bluetoothSocket.close();
            }
            catch (IOException e2)
            {
                exitApplication("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }

        // Create a data stream so we can talk to server.
        try
        {
            outputData = bluetoothSocket.getOutputStream();
        }
        catch (IOException e)
        {
            exitApplication("Fatal Error", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();

        if (outputData != null)
        {
            try
            {
                outputData.flush();
            }
            catch (IOException e)
            {
                exitApplication("Fatal Error", "In onPause() and failed to flush output stream: " + e.getMessage() + ".");
            }
        }

        try
        {
            bluetoothSocket.close();
        }
        catch (IOException e2)
        {
            exitApplication("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
        }
    }

    private void checkBTState()
    {
        // Check for Bluetooth support and then check to make sure it is turned on

        // Emulator doesn't support Bluetooth and will return null
        if(bluetoothAdapter==null)
        {
            exitApplication("Fatal Error", "Bluetooth Not supported.");
        }
        else
        {
            if (bluetoothAdapter.isEnabled())
            {}
            else
            {
                //Asks the user if they would like to turn on bluetooth.
                Intent enableBtIntent = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }




    public void addListenerOnSpinnerItemSelection() {

       /* TextView tv=(TextView)findViewById(R.id.custom);
        Typeface face= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv.setTypeface(face);

        TextView tv1=(TextView)findViewById(R.id.customa);
        Typeface face1= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv1.setTypeface(face1);

        TextView tv2=(TextView)findViewById(R.id.customb);
        Typeface face2= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv2.setTypeface(face2);

        TextView tv3=(TextView)findViewById(R.id.customc);
        Typeface face3= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv3.setTypeface(face3);

        TextView tv4=(TextView)findViewById(R.id.customd);
        Typeface face4= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv4.setTypeface(face4);

        TextView tv5=(TextView)findViewById(R.id.custome);
        Typeface face5= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv5.setTypeface(face5);

        TextView tv6=(TextView)findViewById(R.id.customf);
        Typeface face6= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv6.setTypeface(face6);

        TextView tv7=(TextView)findViewById(R.id.customg);
        Typeface face7= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv7.setTypeface(face7);

        TextView tv8=(TextView)findViewById(R.id.customh);
        Typeface face8= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv8.setTypeface(face8);

        TextView tv9=(TextView)findViewById(R.id.customi);
        Typeface face9= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv9.setTypeface(face9);


        TextView tv10=(TextView)findViewById(R.id.customj);
        Typeface face10= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv10.setTypeface(face10);

        TextView tv11=(TextView)findViewById(R.id.customk);
        Typeface face11= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv11.setTypeface(face11);

        TextView tv12=(TextView)findViewById(R.id.customl);
        Typeface face12= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv12.setTypeface(face12);*/

        spinner1 = (Spinner) findViewById(R.id.spinner1);
       // spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner2 = (Spinner) findViewById(R.id.spinner2);
       // spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner3 = (Spinner) findViewById(R.id.spinner2);
       // spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner4 = (Spinner) findViewById(R.id.spinner4);
       // spinner4.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner5 = (Spinner) findViewById(R.id.spinner5);
       // spinner5.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner6 = (Spinner) findViewById(R.id.spinner6);
       // spinner6.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner7 = (Spinner) findViewById(R.id.spinner7);
       // spinner7.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner8 = (Spinner) findViewById(R.id.spinner8);
        //spinner8.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner9 = (Spinner) findViewById(R.id.spinner9);
       // spinner9.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner10 = (Spinner) findViewById(R.id.spinner10);
       // spinner10.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner11 = (Spinner) findViewById(R.id.spinner11);
       // spinner11.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        spinner12 = (Spinner) findViewById(R.id.spinner12);
       // spinner12.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner2);
        spinner4 = (Spinner) findViewById(R.id.spinner2);
        spinner5 = (Spinner) findViewById(R.id.spinner2);
        spinner6 = (Spinner) findViewById(R.id.spinner2);
        spinner7 = (Spinner) findViewById(R.id.spinner2);
        spinner8 = (Spinner) findViewById(R.id.spinner2);
        spinner9 = (Spinner) findViewById(R.id.spinner2);
        spinner10 = (Spinner) findViewById(R.id.spinner2);
        spinner11 = (Spinner) findViewById(R.id.spinner2);
        spinner12 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        String value1 = String.valueOf(spinner1.getSelectedItem());
        double vodka = Double.parseDouble(value1);
        String value2 = String.valueOf(spinner1.getSelectedItem());
        double gin = Double.parseDouble(value2);
        String value3 = String.valueOf(spinner1.getSelectedItem());
        double rum = Double.parseDouble(value3);
        String value4 = String.valueOf(spinner1.getSelectedItem());
        double tequila = Double.parseDouble(value4);
        String value5 = String.valueOf(spinner1.getSelectedItem());
        double midori = Double.parseDouble(value5);
        String value6 = String.valueOf(spinner1.getSelectedItem());
        double malibu = Double.parseDouble(value6);
        String value7= String.valueOf(spinner1.getSelectedItem());
        double bluecuracao = Double.parseDouble(value7);
        String value8 = String.valueOf(spinner1.getSelectedItem());
        double sourmix = Double.parseDouble(value8);
        String value9 = String.valueOf(spinner1.getSelectedItem());
        double sprite = Double.parseDouble(value9);
        String value10 = String.valueOf(spinner1.getSelectedItem());
        double orangejuice = Double.parseDouble(value10);
        String value11 = String.valueOf(spinner1.getSelectedItem());
        double cranberryjuice = Double.parseDouble(value11);
        String value12 = String.valueOf(spinner1.getSelectedItem());
        double pineapplejuice = Double.parseDouble(value12);

        values = new double[12];
        values[0] = vodka;
        values[1] = gin;
        values[2] = rum;
        values[3] = tequila;
        values[4] = midori;
        values[5] = malibu;
        values[6] = bluecuracao;
        values[7] = sourmix;
        values[8] = sprite;
        values[9] = orangejuice;
        values[10] = cranberryjuice;
        values[11] = pineapplejuice;

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                /*Toast.makeText(CustomDrink.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()) +
                                "\nSpinner 3 : "+ String.valueOf(spinner3.getSelectedItem()) +
                                "\nSpinner 4 : "+ String.valueOf(spinner4.getSelectedItem()) +
                                "\nSpinner 5 : "+ String.valueOf(spinner5.getSelectedItem()) +
                                "\nSpinner 6 : "+ String.valueOf(spinner6.getSelectedItem()) +
                                "\nSpinner 7 : "+ String.valueOf(spinner7.getSelectedItem()) +
                                "\nSpinner 8 : "+ String.valueOf(spinner8.getSelectedItem()) +
                                "\nSpinner 9 : "+ String.valueOf(spinner9.getSelectedItem()) +
                                "\nSpinner 10 : "+ String.valueOf(spinner10.getSelectedItem()) +
                                "\nSpinner 11 : "+ String.valueOf(spinner11.getSelectedItem()) +
                                "\nSpinner 12 : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();*/

                for(int i = 0; i<12; i++) {
                    if (values[i] == 0) {
                        combination = combination + "M";
                    }
                    else if(values[i] == .5){
                        combination = combination + "N";
                    }
                    else if(values[i] == 1){
                        combination = combination + "O";
                    }
                    else if(values[i] == 1.5){
                        combination = combination + "P";
                    }
                    else if(values[i] == 2){
                        combination = combination + "Q";
                    }
                    else if(values[i] == 2.5){
                        combination = combination + "R";
                    }
                    else if(values[i] == 3){
                        combination = combination + "S";
                    }
                    else if(values[i] == 3.5){
                        combination = combination + "T";
                    }
                    else if(values[i] == 4){
                        combination = combination + "U";
                    }
                    else if(values[i] == 4.5){
                        combination = combination + "V";
                    }
                    else if(values[i] == 5){
                        combination = combination + "W";
                    }
                    else if(values[i] == 5.5){
                        combination = combination + "X";
                    }
                    else
                    {
                        combination = "ERROR";
                    }
                }


            }

        });
    }
}