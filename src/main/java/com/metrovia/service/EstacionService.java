package com.metrovia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metrovia.dto.UnidadCercanaDTO;
import com.metrovia.model.Unidad;

@Service
public class EstacionService {

    // Estaciones fijas en memoria
    private final List<Estacion> estaciones = List.of(
        new Estacion(0, -2.091617, -79.942195),
        new Estacion(1, -2.096153, -79.936247),
        new Estacion(2, -2.104120361181248, -79.93501554386026)
        // ... agrega las demás estaciones con ID
    );

    // Lista simulada de unidades en memoria o cargada de algún servicio
    private final List<Unidad> unidadesActivas = new ArrayList<>();

    public List<UnidadCercanaDTO> obtenerUnidadesCercanas(int estacionId) {
        Estacion estacion = estaciones.stream()
            .filter(e -> e.getId() == estacionId)
            .findFirst()
            .orElse(null);

        if (estacion == null) return List.of();

        List<UnidadCercanaDTO> cercanas = new ArrayList<>();

        for (Unidad unidad : unidadesActivas) {
            double distancia = calcularDistanciaKm(
                estacion.getLat(), estacion.getLon(),
                unidad.getLat(), unidad.getLon()
            );

            if (distancia <= 3.0) { // puedes ajustar el rango
                cercanas.add(new UnidadCercanaDTO(unidad.getId(), distancia));
            }
        }

        return cercanas;
    }

    private double calcularDistanciaKm(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371; // Radio de la Tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    // Para que otras clases puedan inyectar unidades (puede cambiar esto por conexión real)
    public void setUnidadesActivas(List<Unidad> unidades) {
        this.unidadesActivas.clear();
        this.unidadesActivas.addAll(unidades);
    }

    // Clase interna para estaciones (puedes moverla a un archivo si lo deseas)
    private static class Estacion {
        private int id;
        private double lat;
        private double lon;

        public Estacion(int id, double lat, double lon) {
            this.id = id;
            this.lat = lat;
            this.lon = lon;
        }

        public int getId() { return id; }
        public double getLat() { return lat; }
        public double getLon() { return lon; }
    }
}