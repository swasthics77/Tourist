package com.example.android.tourist;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.DialogPreference;
import android.provider.Contacts;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static android.location.LocationManager.*;

/**
 * Created by swasthi_cs77 on 01-Apr-15.
 */
public class GPSTracker extends Service implements LocationListener {

    private final Context context;

    boolean isGPSEnabled = false;
    boolean canGetLocation = false;
    boolean isNetworkEnabled = false;
    Location location;

    double latitude;
    double longitude;
    //String dist = "error";
    //double distance;
    //double dist1;
    //double result;
    // Distance2 dist1;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    protected LocationManager locationManager;

    public GPSTracker(Context context) {
        this.context = context;
        getLocation();

        // dist1=Distance.getRouteDistance(12.56,77.56,12.96,77.95);

        // dist = Distance.getDistance("Bangalore", "Mysore");
        // result = GetDistance(12.94, 77.569, 12.56, 77.95);
        // getdist();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(NETWORK_PROVIDER);

            if (!isGPSEnabled && isNetworkEnabled) {

            } else {
                this.canGetLocation = true;
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this
                    );

                }
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(NETWORK_PROVIDER);
                    if (location != null) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
            }
            if (isGPSEnabled) {
                if (location == null) {

                    locationManager.requestLocationUpdates(
                            NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this
                    );

                }
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(GPS_PROVIDER);
                    if (location != null) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    public void stopUsingGPS() {
        if (locationManager != null) {
            locationManager.removeUpdates(GPSTracker.this);
        }
    }

    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }
        return longitude;
    }

   /* public boolean canGetLocation() {
        return this.canGetLocation;
    }*/




    @Override
    public void onLocationChanged(Location location) {

    }


    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
