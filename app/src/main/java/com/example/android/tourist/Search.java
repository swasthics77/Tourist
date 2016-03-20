package com.example.android.tourist;

import android.app.ProgressDialog;
import android.app.Service;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Search extends ActionBarActivity {
    public static String edit;
    Toolbar toolbar1;
    public HandleJSON obj;
    public static String dists1 = "", times1 = "";  //Stores list of names, distance from destination and time to reach of respective person


    public static String source1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar1 = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar1);

        Button btn = (Button) findViewById(R.id.find);
        final EditText editText = (EditText) findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit = editText.getText().toString();

                dists1 = "";
                times1 = "";

                GPSTracker gps = new GPSTracker(Search.this);
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();
                //  String source = ips.getSource();
                //s  Toast.makeText(
                //s        getApplicationContext(), "Your location is -\nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();


                source1 = "" + Double.toString(latitude) + "," + "" + Double.toString(longitude);
                //s ArrayList<String> locs = ips.getLocs();     //Contains location of other participants
                // Inputs ips = new Inputs();   //Class in which receiving inputs from server is implemented

                // sfor(int i=0;i<5;i++) {
                new JSONParse().execute();
            }
        });
    }

    private class JSONParse extends AsyncTask<String, String, HandleJSON> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Search.this);
            pDialog.setMessage("Locating...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        @Override
        protected HandleJSON doInBackground(String... args) {
            String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + source1 + "&destination=" + edit + "&mode=driving";
            obj = new HandleJSON(url);
            obj.fetchJSON();
            while (obj.parsingComplete) ;
            dists1 += obj.getDistanceNow() + "\n";
            times1 += obj.getTimeToday() + "\n";
            obj = null;
            return null;

        }
        //s names += "Person" + " " + Integer.toString(i + 1) + "\n";
        //names += ips.getNames(i);
        //s names+=" "+Double.toString(latitude)+","+" "+Double.toString(longitude);

        protected void onPostExecute(HandleJSON json) {
            pDialog.dismiss();
            TextView textView = (TextView) findViewById(R.id.textDist1);
            TextView textView1 = (TextView) findViewById(R.id.textTime1);
            textView.setText(dists1);
            textView1.setText(times1);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
