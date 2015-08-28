package com.example.michael.roboticdrinkmaker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class ListViewExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewexampleactivity);

        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[] { "Bay Breeze", "Aqua Cure", "AMF", "Caribou Lou", "Caribbean Mist", "Fruit Fusion", "Malibu Maddness", "Anchor Splash", "Barking Spider", "Blue Sex", "Orange Sunrise", "Boom Boom Pow",
                "Midori Sour", "Vodka Sprite", "Vodka Cranberry", "Blackout", "Dos Amigos Chicorita", "Cobra", "TGV", "Cooler", "Ghost Goblet","Hoola Hoop", "Midori Margarita", "Screwdriver", "Soylent Green", "Melon Ball", "Grand Cosmopolitan", "Scooter", "Bailey's Madras"};
        java.util.Arrays.sort(values);
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
//			    Toast.makeText(getApplicationContext(),
//				((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                String choice = ((TextView) view).getText().toString();

                //NOTE: CHANGE TO SWITCH STATEMENTS.
                if(choice == "Bay Breeze")
                {
                    Intent intent2 = new Intent(getApplicationContext(), BayBreeze.class);
                    startActivity(intent2);
                }
                else if(choice == "Aqua Cure")
                {
                    Intent intent2 = new Intent(getApplicationContext(), AMF.class);
                    startActivity(intent2);
                }
                else if(choice == "AMF")
                {
                    Intent intent2 = new Intent(getApplicationContext(), AMF.class);
                    startActivity(intent2);
                }
                else if(choice == "Caribou Lou")
                {
                    Intent intent2 = new Intent(getApplicationContext(), CaribouLou.class);
                    startActivity(intent2);
                }
                else if(choice == "Caribbean Mist")
                {
                    Intent intent2 = new Intent(getApplicationContext(), CaribbeanMist.class);
                    startActivity(intent2);
                }
                else if(choice == "Fruit Fusion")
                {
                    Intent intent2 = new Intent(getApplicationContext(), FruitFusion.class);
                    startActivity(intent2);
                }

                else if(choice == "Malibu Maddness")
                {
                    Intent intent2 = new Intent(getApplicationContext(), MalibuMadness.class);
                    startActivity(intent2);
                }

                else if(choice == "Anchor Splash")
                {
                    Intent intent2 = new Intent(getApplicationContext(), AMF.class);
                    startActivity(intent2);
                }

                else if(choice == "Barking Spider")
                {
                    Intent intent2 = new Intent(getApplicationContext(), AMF.class);
                    startActivity(intent2);
                }

                else if(choice == "Blue Sex")
                {
                    Intent intent2 = new Intent(getApplicationContext(), BlueSex.class);
                    startActivity(intent2);
                }

                else if(choice == "Orange Sunrise")
                {
                    Intent intent2 = new Intent(getApplicationContext(), OrangeSunrise.class);
                    startActivity(intent2);
                }

                else if(choice == "Boom Boom Pow")
                {
                    Intent intent2 = new Intent(getApplicationContext(), BoomBoomPow.class);
                    startActivity(intent2);
                }

                else if(choice == "Midori Sour")
                {
                    Intent intent2 = new Intent(getApplicationContext(), MidoriSour.class);
                    startActivity(intent2);
                }

                else if(choice == "Vodka Sprite")
                {
                    Intent intent2 = new Intent(getApplicationContext(), VodkaSprite.class);
                    startActivity(intent2);
                }

                else if(choice == "Vodka Cranberry")
                {
                    Intent intent2 = new Intent(getApplicationContext(), AMF.class);
                    startActivity(intent2);
                }

                else if(choice == "Blackout")
                {
                    Intent intent2 = new Intent(getApplicationContext(), TheBlackout.class);
                    startActivity(intent2);
                }

                else
                {
                    Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent3);
                }
            }
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

}

