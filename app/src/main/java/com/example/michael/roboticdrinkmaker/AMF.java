package com.example.michael.roboticdrinkmaker;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;


public class AMF extends ActionBarActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amf);


        TextView tv=(TextView)findViewById(R.id.custom);
        Typeface face= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv.setTypeface(face);

        TextView tv1=(TextView)findViewById(R.id.custom1);
        Typeface face1= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv1.setTypeface(face1);

        TextView tv2=(TextView)findViewById(R.id.custom2);
        Typeface face2= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv2.setTypeface(face2);

        TextView tv3=(TextView)findViewById(R.id.custom3);
        Typeface face3= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv3.setTypeface(face3);

        TextView tv4=(TextView)findViewById(R.id.custom4);
        Typeface face4= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv4.setTypeface(face4);

        TextView tv5=(TextView)findViewById(R.id.custom5);
        Typeface face5= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv5.setTypeface(face5);

        TextView tv6=(TextView)findViewById(R.id.custom6);
        Typeface face6= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv6.setTypeface(face6);

        TextView tv7=(TextView)findViewById(R.id.custom7);
        Typeface face7= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv7.setTypeface(face7);

        TextView tv8=(TextView)findViewById(R.id.custom8);
        Typeface face8= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv8.setTypeface(face8);

        TextView tv9=(TextView)findViewById(R.id.custom9);
        Typeface face9= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv9.setTypeface(face9);


        TextView tv10=(TextView)findViewById(R.id.custom10);
        Typeface face10= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv10.setTypeface(face10);

        TextView tv11=(TextView)findViewById(R.id.custom11);
        Typeface face11= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv11.setTypeface(face11);

        TextView tv12=(TextView)findViewById(R.id.custom12);
        Typeface face12= Typeface.createFromAsset(getAssets(), "RemachineScript_Personal_Use.ttf");
        tv12.setTypeface(face12);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Drink");
        query.getInBackground("IOjETnGT6n", new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your game score
                    double vodka = object.getDouble("Vodka");
                    TextView tv1 = (TextView) findViewById(R.id.text1);
                    tv1.setText(String.valueOf(vodka));
                    double gin = object.getDouble("Gin");
                    TextView tv2 = (TextView) findViewById(R.id.text2);
                    tv2.setText(String.valueOf(gin));
                    double rum = object.getDouble("Rum");
                    TextView tv3 = (TextView) findViewById(R.id.text3);
                    tv3.setText(String.valueOf(rum));
                    double tequila = object.getDouble("Tequila");
                    TextView tv4 = (TextView) findViewById(R.id.text4);
                    tv4.setText(String.valueOf(tequila));
                    double midori = object.getDouble("Midori");
                    TextView tv5 = (TextView) findViewById(R.id.text5);
                    tv5.setText(String.valueOf(midori));
                    double malibu = object.getDouble("Malibu");
                    TextView tv6 = (TextView) findViewById(R.id.text6);
                    tv6.setText(String.valueOf(malibu));
                    double bluecuracao = object.getDouble("BlueCuracao");
                    TextView tv7 = (TextView) findViewById(R.id.text7);
                    tv7.setText(String.valueOf(bluecuracao));
                    double sourmix = object.getDouble("SourMix");
                    TextView tv8 = (TextView) findViewById(R.id.text8);
                    tv8.setText(String.valueOf(sourmix));
                    double sprite = object.getDouble("Sprite");
                    TextView tv9 = (TextView) findViewById(R.id.text9);
                    tv9.setText(String.valueOf(sprite));
                    double orangejuice = object.getDouble("OrangeJuice");
                    TextView tv10 = (TextView) findViewById(R.id.text10);
                    tv10.setText(String.valueOf(orangejuice));
                    double cranberryjuice = object.getDouble("CranberryJuice");
                    TextView tv11 = (TextView) findViewById(R.id.text11);
                    tv11.setText(String.valueOf(cranberryjuice));
                    double pineapplejuice = object.getDouble("PineappleJuice");
                    TextView tv12 = (TextView) findViewById(R.id.text12);
                    tv12.setText(String.valueOf(pineapplejuice));

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
                } else {
                    // something went wrong
                    int sprite = 101;
                    TextView tv4 = (TextView) findViewById(R.id.text2);
                    tv4.setText(String.valueOf(sprite));
                }



            }



        });

        itemMiddleButton = (Button) findViewById(R.id.itemMiddle);


        //need to work with bluetooth adapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        checkBTState();


        itemMiddleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(data);
                Toast msg = Toast.makeText(getBaseContext(),
                        "Your drink is now being made!", Toast.LENGTH_SHORT);
                msg.show();
            }
        });


        //setupMessageButton();
    }

  /*  private void setupMessageButton() {

        //Get a reference to a button.
        Button messageButton1 = (Button) findViewById(R.id.make_amf);
        //set the click listener to run code.
        messageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Go home, you're drunk.",Toast.LENGTH_LONG).show();
                Intent messageButtonActivity = new Intent(AMF.this, ListViewExampleActivity.class);
                AMF.this.startActivity(messageButtonActivity);
            }
        });

    }*/


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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_am, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
