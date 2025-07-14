package com.metrovia.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.metrovia.model.Unidad;

@Service
public class UnidadService {

    private final Map<String, Unidad> ubicaciones = new ConcurrentHashMap<>();

    public void actualizarUbicacion(Unidad unidad) {
        ubicaciones.put(unidad.getId(), unidad);
    }

    public Map<String, Unidad> obtenerUbicaciones() {
        return ubicaciones;
    }
}
