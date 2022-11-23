package com.example.monitorgeofences;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.ArrayList;
import java.util.List;

public class GeoFenceBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper notificationHelper = new NotificationHelper(context);

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        if (geofencingEvent.hasError()) {
            System.out.println("onReceive: " + "onReceive: Error receiving event");
            return;
        }
        List<Geofence> geofenceList = geofencingEvent.getTriggeringGeofences();
        ArrayList<String> triggeringGeofencesList = new ArrayList<>();
        for (Geofence geofence : geofenceList) {
            System.out.println("onReceive: " + geofence.getRequestId());
            triggeringGeofencesList.add(geofence.getRequestId());
        }
        int transitionType = geofencingEvent.getGeofenceTransition();

        switch (transitionType) {
            case Geofence.GEOFENCE_TRANSITION_ENTER:
                notificationHelper.sendNotification("You have entered to geofence area", "", MapsActivity.class);
                break;
            case Geofence.GEOFENCE_TRANSITION_DWELL:
                notificationHelper.sendNotification("You are roaming in geofence area", "", MapsActivity.class);
                break;
            case Geofence.GEOFENCE_TRANSITION_EXIT:
                notificationHelper.sendNotification("You have exited from geofence area", "", MapsActivity.class);
                break;

        }
    }
}