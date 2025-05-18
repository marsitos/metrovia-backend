package com.metrovia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.metrovia.dto.UbicacionDTO;

@Service
public class UbicacionService {

    // Cambiar la lista por un mapa, para guardar ubicaciones por idUnidad
    private final Map<String, UbicacionDTO> ubicacionesMap = new HashMap<>();

    // Guardar o actualizar ubicación por idUnidad
    public void agregarOActualizarUbicacion(UbicacionDTO ubicacion) {
        ubicacionesMap.put(ubicacion.getIdUnidad(), ubicacion);
    }

    // Obtener todas las ubicaciones actuales
    public List<UbicacionDTO> obtenerUbicacionesActualizadas() {
        return new ArrayList<>(ubicacionesMap.values());
    }
}
