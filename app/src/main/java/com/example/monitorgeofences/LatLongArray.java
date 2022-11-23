package com.example.monitorgeofences;

public class LatLongArray {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    String id;
    double lat;

    public LatLongArray(String id, double lat, double longi) {
        this.id = id;
        this.lat = lat;
        this.longi = longi;
    }

    double longi;
}
