// src/main/java/com/metrovia/controller/UnidadController.java
package com.metrovia.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrovia.model.Unidad;
import com.metrovia.service.UnidadService;

@RestController
@RequestMapping("/ubicacion")
@CrossOrigin(origins = "*")
public class UnidadController {

    private final UnidadService unidadService;

    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }

    // Recibir la ubicación del conductor
    @PostMapping
    public void recibirUbicacion(@RequestBody Unidad unidad) {
        unidadService.actualizarUbicacion(unidad);
    }

    // Obtener todas las ubicaciones actuales
    @GetMapping
    public Collection<Unidad> obtenerUnidades() {
        return unidadService.obtenerUbicaciones().values();
    }
}
