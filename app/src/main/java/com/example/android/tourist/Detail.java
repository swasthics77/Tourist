package com.example.android.tourist;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Outline;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class Detail extends ActionBarActivity {
    Toolbar toolbar;
    public TextView distance,time;
    public HandleJSON obj;
    public  static String dists="", times="";  //Stores list of names, distance from destination and time to reach of respective person
    public static String locs="";
    public String s1="driving";
    public static String source;
    public static String myval;
    private android.support.v7.widget.ShareActionProvider mShareActionProvider;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        View addButton = findViewById(R.id.add_button);
        addButton.setOutlineProvider(new ViewOutlineProvider() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void getOutline(View view, Outline outline) {
                int diameter = getResources().getDimensionPixelSize(R.dimen.diameter);
                outline.setOval(0, 0, diameter, diameter);
            }
        });
        addButton.setClipToOutline(true);
        Intent intent = getIntent();
        myval = intent.getStringExtra("Text");
        TextView text = (TextView) findViewById(R.id.textv);


        text.setText(myval);
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("image");
        ImageView v = (ImageView) findViewById(R.id.imag);

        v.setImageResource(pic);



        locs = "";

        if (Screen1.pos == 0) {
            locs = "8.603061, 76.962999";

        }
        if (Screen1.pos == 1) {
            locs = "10.56,77.59";
        }
        if (Screen1.pos == 2) {
            locs = "15.5589,73.7533";
        }
        if (Screen1.pos == 3) {
            locs = "8.733,76.7170";
        }

        if (Screen1.pos == 4) {
            locs = "13.72,74.6410";
        }
        if (Screen1.pos == 5) {
            locs = "12.9547,74.8047";
        }
        if (Screen1.pos == 6) {
            locs = "13.3795,74.6730";
        }
        if (Screen1.pos == 7) {
            locs = "14.8000,74.1300";
        }
       if (Screen2.position == 0) {
            locs = "32.2700,77.1700";
        }
        if (Screen2.position == 1) {
            locs = "29.2300,79.2700";
        }
        if (Screen2.position == 2) {
            locs = "18.9866,73.2679";
        }
        if (Screen2.position == 3) {
            locs = "31.1033,77.1722";
        }
        if (Screen2.position == 4) {
            locs = "10.0892,77.0597";
        }
        if (Screen2.position == 5) {
            locs = "11.4100,76.7000";
        }
        if (Screen2.position == 6) {
            locs = "27.0500,88.2667";
        }
        if (Screen2.position == 7) {
            locs = "10.2300,77.4800";
        }
        if (Screen2.position == 8) {
            locs = "13.8608,74.8747";
        }
        if (Screen3.pos1 == 0) {
            locs = "15.3128,74.3142";
        }
        if (Screen3.pos1 == 1) {
            locs = "11.7280,75.8860";
        }
        if (Screen3.pos1 == 2) {
            locs = "10.2236,77.5983";
        }
        if (Screen3.pos1 == 3) {
            locs = "14.2289,74.8119";
        }
        if (Screen3.pos1 == 4) {
            locs = "23.2569,92.7625";
        }
        if (Screen3.pos1 == 5) {
            locs = "21.9327,86.3801";
        }
        if (Screen3.pos1 == 6) {
            locs = "25.445,91.2285";
        }
        if (Screen3.pos1 == 7) {
            locs = "13.6947,75.0181";
        }
        if (Screen3.pos1 == 8) {
            locs = "25.2757,91.6870";
        }


        ImageButton btn1 = (ImageButton) findViewById(R.id.add_button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Getting a reference to listview of main.xml layout file


                // distance = (TextView) findViewById(R.id.textDist);
                //time = (TextView) findViewById(R.id.textTime);


                dists = "";
                times = "";


                GPSTracker gps = new GPSTracker(Detail.this);
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();
                //  String source = ips.getSource();
                //s  Toast.makeText(
                //s        getApplicationContext(), "Your location is -\nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();


                source = "" + Double.toString(latitude) + "," + "" + Double.toString(longitude);
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

                pDialog = new ProgressDialog(Detail.this);
                pDialog.setMessage("Locating...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
            }


            @Override
            protected HandleJSON doInBackground(String... args) {
                String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + source + "&destination=" + locs + "&mode=" + s1;
                obj = new HandleJSON(url);
                obj.fetchJSON();
                while (obj.parsingComplete) ;
                dists += obj.getDistanceNow() + "\n";
                times += obj.getTimeToday() + "\n";
                obj = null;
                return null;

            }
            //s names += "Person" + " " + Integer.toString(i + 1) + "\n";
            //names += ips.getNames(i);
            //s names+=" "+Double.toString(latitude)+","+" "+Double.toString(longitude);

            protected void onPostExecute(HandleJSON json) {
                pDialog.dismiss();
                FragmentManager fm = getFragmentManager();
                Dialog testDialog = new Dialog();


                testDialog.setRetainInstance(true);

                testDialog.show(fm, "fragment_name");

                //s}


            }


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_detail, menu);
        getMenuInflater().inflate(R.menu.menu_detail, menu);

        // Set up ShareActionProvider's default share intent
        MenuItem shareItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (android.support.v7.widget.ShareActionProvider)
                MenuItemCompat.getActionProvider(shareItem);
        mShareActionProvider.setShareIntent(getDefaultIntent());

        return super.onCreateOptionsMenu(menu);


    }
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,myval);
        return intent;
    }

    private void showPopUp3() {

        final CharSequence[] items = {"Driving", "Walking", "Public Transit"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("MODE OF TRANSPORT");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Dialog d=new Dialog();
                if (i==0)
                {
                    s1="driving";
                    d.M="Driving";
                    Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                }
                if (i==1)
                {
                    s1="walking";
                    d.M="Walking";
                    Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                }
                if (i==2)
                {
                    s1="driving";
                    d.M="Public Transit";
                    Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                }

            }
        });
        AlertDialog alert = builder.create();
//And if the line above didn't bring ur dialog up use this bellow also:
        alert.show();
    }
        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            showPopUp3();

            return true;
        }
            if (id==R.id.action_map)
            {
                openPreferredLocationInMap();
            }

        return super.onOptionsItemSelected(item);
    }

  private void openPreferredLocationInMap()
  {
    //  SharedPreferences sharedPrefs=
            //  PreferenceManager.getDefaultSharedPreferences(this);
     // String location = sharedPrefs.getString("location",locs);

        String uri="google.navigation:q="+locs;
      Uri gmmIntentUri = Uri.parse(uri);
      Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
      mapIntent.setPackage("com.google.android.apps.maps");
      startActivity(mapIntent);
  }

}
