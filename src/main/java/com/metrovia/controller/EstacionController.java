package com.metrovia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrovia.dto.UnidadCercanaDTO;
import com.metrovia.service.EstacionService;

@RestController
@RequestMapping("/api/estacion")
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    @GetMapping("/{id}/unidades")
    public List<UnidadCercanaDTO> obtenerUnidadesCercanas(@PathVariable int id) {
        return estacionService.obtenerUnidadesCercanas(id);
    }
}