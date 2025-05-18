package com.metrovia.dto;

public class UbicacionDTO {
    private String idUnidad;  // identificador único de la unidad
    private double lat;
    private double lon;

    public UbicacionDTO() {}
    
    public String getIdUnidad() {
        return idUnidad;
    }
    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
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
