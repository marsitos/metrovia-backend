package com.metrovia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.metrovia.dto.UbicacionDTO;

@Service
public class UbicacionService {

    private final Map<String, UbicacionDTO> ubicacionesMap = new HashMap<>();

    public void agregarOActualizarUbicacion(UbicacionDTO ubicacion) {
        ubicacionesMap.put(ubicacion.getIdUnidad(), ubicacion);
    }

    public List<UbicacionDTO> obtenerUbicacionesActualizadas() {
        return ubicacionesMap.values().stream()
                .filter(ubicacion -> ubicacion != null)
                .collect(Collectors.toList());
    }
}