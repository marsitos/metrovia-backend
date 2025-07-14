package com.metrovia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrovia.model.Unidad; // Ajusta el paquete según tu proyecto
import com.metrovia.repository.UnidadRepository; // Ajusta el paquete

@RestController
@RequestMapping("/test")
public class TestController {

    private final UnidadRepository unidadRepository;

    public TestController(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    @GetMapping("/unidades")
    public List<Unidad> listarUnidades() {
        return unidadRepository.findAll();
    }
}
