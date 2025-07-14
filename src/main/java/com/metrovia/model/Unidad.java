package com.metrovia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Unidad {
    @Id
    private String id;
    private double lat;//latitud
    private double lon;//longitud

    public Unidad() {}

    public Unidad(String id, double lat, double lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
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
    
}
