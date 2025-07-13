package com.metrovia.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.metrovia.model.Unidad;

@Service
public class UnidadService {

    private final Map<String, UnidadConTiempo> ubicaciones = new ConcurrentHashMap<>();

    public void actualizarUbicacion(Unidad unidad) {
        String id = unidad.getId();
        UnidadConTiempo existente = ubicaciones.get(id);

        if (existente != null) {
            existente.getUnidad().setLat(unidad.getLat());
            existente.getUnidad().setLon(unidad.getLon());
            existente.actualizarTimestamp();
        } else {
            ubicaciones.put(id, new UnidadConTiempo(unidad, System.currentTimeMillis()));
        }

        limpiarUnidadesInactivas();
    }

    public Map<String, Unidad> obtenerUbicaciones() {
        limpiarUnidadesInactivas();
        return ubicaciones.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().getUnidad()
            ));
    }

    private void limpiarUnidadesInactivas() {
        long ahora = System.currentTimeMillis();
        long limiteInactividad = 60_000; // 1 minuto

        ubicaciones.entrySet().removeIf(entry ->
            (ahora - entry.getValue().getTimestamp()) > limiteInactividad
        );
    }

    // Clase interna
    private static class UnidadConTiempo {
        private final Unidad unidad;
        private long timestamp;

        public UnidadConTiempo(Unidad unidad, long timestamp) {
            this.unidad = unidad;
            this.timestamp = timestamp;
        }

        public Unidad getUnidad() {
            return unidad;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void actualizarTimestamp() {
            this.timestamp = System.currentTimeMillis();
        }
    }
}
