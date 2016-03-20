package com.example.android.tourist;

import java.net.HttpURLConnection;



import android.annotation.SuppressLint;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HandleJSON {               //Class handles JSON response from google api
    private String distanceNow = "date";
    private String timeToday = "time";
    private String urlString = null;

    public volatile boolean parsingComplete = true;
    public HandleJSON(String url){
        this.urlString = url;
    }
    public String getDistanceNow(){
        return distanceNow;
    }

    public String getTimeToday(){
        return timeToday;
    }

    @SuppressLint("NewApi")
    public void readAndParseJSON(String in) {
        try {
            JSONObject reader = new JSONObject(in);

            JSONArray routes = reader.getJSONArray("routes");
            JSONObject temp1 = routes.getJSONObject(0);
            JSONArray legs = temp1.getJSONArray("legs");
            JSONObject stats = legs.getJSONObject(0);
            JSONObject distance = stats.getJSONObject("distance");
            JSONObject time = stats.getJSONObject("duration");

            //JSONObject sys  = reader.getJSONObject("date");
            distanceNow = distance.getString("text");
            timeToday = time.getString("text");

//            distanceNow = "conc";
//            timeToday = "api works";

            parsingComplete = false;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void fetchJSON(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();

                    String data = convertStreamToString(stream);

                    readAndParseJSON(data);
                    stream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}