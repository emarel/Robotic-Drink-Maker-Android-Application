package com.example.michael.roboticdrinkmaker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class BoomBoomPow extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boom_boom_pow);


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
        query.getInBackground("kwLA7KgDlG", new GetCallback<ParseObject>() {
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
                } else {
                    // something went wrong
                    int sprite = 101;
                    TextView tv4 = (TextView) findViewById(R.id.text2);
                    tv4.setText(String.valueOf(sprite));
                }
            }
        });


        setupMessageButton();
    }

    private void setupMessageButton() {

        //Get a reference to a button.
        Button messageButton1 = (Button) findViewById(R.id.make_boomboompow);
        //set the click listener to run code.
        messageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Go home, you're drunk.",Toast.LENGTH_LONG).show();
                Intent messageButtonActivity = new Intent(BoomBoomPow.this, ListViewExampleActivity.class);
                BoomBoomPow.this.startActivity(messageButtonActivity);
            }
        });

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
