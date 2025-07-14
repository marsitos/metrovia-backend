package com.metrovia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.metrovia.dto.UbicacionDTO;
import com.metrovia.model.Unidad;
import com.metrovia.repository.UnidadRepository;

@Service
public class UbicacionService {

    private final UnidadRepository unidadRepository;

    public UbicacionService(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    // Guardar o actualizar ubicación en la base de datos
    public void agregarOActualizarUbicacion(UbicacionDTO dto) {
        Unidad unidad = unidadRepository.findById(dto.getIdUnidad())
                .orElse(new Unidad());

        unidad.setId(dto.getIdUnidad());
        unidad.setLat(dto.getLat());
        unidad.setLon(dto.getLon());
        unidadRepository.save(unidad);
        System.out.println("Guardando en BD: " + unidad.getId() + " -> " + unidad.getLat() + ", " + unidad.getLon());
    }

    // Obtener todas las ubicaciones actuales desde la BD y convertirlas a DTO
    public List<UbicacionDTO> obtenerUbicacionesActualizadas() {
        return unidadRepository.findAll().stream().map(unidad -> {
            UbicacionDTO dto = new UbicacionDTO();
            dto.setIdUnidad(unidad.getId());
            dto.setLat(unidad.getLat());
            dto.setLon(unidad.getLon());
            return dto;
        }).collect(Collectors.toList());
    }
}
