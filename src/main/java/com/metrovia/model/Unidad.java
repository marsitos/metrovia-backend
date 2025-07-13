// src/main/java/com/metrovia/model/Unidad.java
package com.metrovia.model;

public class Unidad {
    private String id;
    private double lat;
    private double lon;
    private long timestamp; // <--- Nuevo campo

    public Unidad() {}

    public Unidad(String id, double lat, double lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.timestamp = System.currentTimeMillis(); // <--- Inicializamos
    }

    // Getters y Setters
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

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
