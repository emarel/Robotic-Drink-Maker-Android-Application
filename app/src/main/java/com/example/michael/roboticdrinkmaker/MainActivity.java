package com.example.michael.roboticdrinkmaker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "DMORByLMQ43Kb0He5rsmGP2ZaSeCsQP0iKnWNG46", "CYDgYod9LvBfRHgBtG5yY2SdMXZ6GiKUkBVm4b2w");



        setupMessageButton();

    }

    private void setupMessageButton() {
        //Get a reference to a button.
        Button messageButton1 = (Button) findViewById(R.id.Drinks);
        Button messageButton2 = (Button) findViewById(R.id.CustomDrinks);
        //set the click listener to run code.
        messageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Go home, you're drunk.",Toast.LENGTH_LONG).show();
                Intent messageButtonActivity = new Intent(MainActivity.this, ListViewExampleActivity.class);
                MainActivity.this.startActivity(messageButtonActivity);
            }
        });
        messageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Go home, you're drunk.",Toast.LENGTH_LONG).show();
                Intent messageButtonActivity = new Intent(MainActivity.this, CustomDrink.class);
                MainActivity.this.startActivity(messageButtonActivity);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
