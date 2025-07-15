package com.metrovia.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metrovia.dto.UbicacionDTO;
import com.metrovia.dto.UnidadCercanaDTO;

@Service
public class EstacionService {

    private final UbicacionService ubicacionService;

    public EstacionService(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    // Estaciones fijas en memoria con sus IDs
    private final List<Estacion> estaciones = List.of(
        new Estacion(0, -2.091617, -79.942195),
        new Estacion(1, -2.096153, -79.936247),
        new Estacion(2, -2.104120361181248, -79.93501554386026),
        new Estacion(3, -2.112456, -79.933319),
        new Estacion(4, -2.117494, -79.932254),
        new Estacion(5, -2.12631, -79.9316972),
        new Estacion(6, -2.1356969, -79.9337551),
        new Estacion(7, -2.1396232, -79.9340118),
        new Estacion(8, -2.1433007, -79.9343396),
        new Estacion(9, -2.1484251, -79.9330418),
        new Estacion(10, -2.1531501, -79.9312479),
        new Estacion(11, -2.155632, -79.9301624),
        new Estacion(12, -2.1587561, -79.9288335),
        new Estacion(13, -2.1648032, -79.923607),
        new Estacion(14, -2.1700231, -79.9188109),
        new Estacion(15, -2.1761219, -79.9123315),
        new Estacion(16, -2.178413, -79.9088075),
        new Estacion(17, -2.1804274, -79.9037913),
        new Estacion(18, -2.1846548, -79.9007839),
        new Estacion(19, -2.186869, -79.894901),
        new Estacion(20, -2.1904151, -79.8956051),
        new Estacion(21, -2.1931992, -79.8956271),
        new Estacion(22, -2.1943155, -79.8909449),
        new Estacion(23, -2.194963, -79.8880367),
        new Estacion(24, -2.197726, -79.885103),
        new Estacion(25, -2.1965202, -79.8824468),
        new Estacion(26, -2.1954969, -79.8855598)
    );

    public List<UnidadCercanaDTO> obtenerUnidadesCercanas(int estacionId) {
        Estacion estacion = estaciones.stream()
            .filter(e -> e.getId() == estacionId)
            .findFirst()
            .orElse(null);

        if (estacion == null) return List.of();

        List<UnidadCercanaDTO> cercanas = new ArrayList<>();

        // Obtén las unidades activas actuales del UbicacionService
        List<UbicacionDTO> unidadesActivas = ubicacionService.obtenerUbicacionesActualizadas();

        for (UbicacionDTO unidad : unidadesActivas) {
            double distancia = calcularDistanciaKm(
                estacion.getLat(), estacion.getLon(),
                unidad.getLat(), unidad.getLon()
            );

            // Puedes ajustar el umbral de distancia para filtrar unidades cercanas
            if (distancia <= 6.0) { 
                cercanas.add(new UnidadCercanaDTO(unidad.getIdUnidad(), distancia));
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
