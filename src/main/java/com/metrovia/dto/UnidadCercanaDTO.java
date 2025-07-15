package com.metrovia.dto;

public class UnidadCercanaDTO {
    private String idUnidad;
    private double distancia;

    public UnidadCercanaDTO() {
    }

    public UnidadCercanaDTO(String idUnidad, double distancia) {
        this.idUnidad = idUnidad;
        this.distancia = distancia;
    }

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}