package com.metrovia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrovia.dto.UbicacionDTO;
import com.metrovia.service.UbicacionService;

@RestController
@RequestMapping("/ubicacion")
@CrossOrigin(origins = "*")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }
    
    @PostMapping
    public ResponseEntity<String> recibirUbicacion(@RequestBody UbicacionDTO ubicacion) {
        ubicacionService.agregarOActualizarUbicacion(ubicacion);
        System.out.println("IdUnidad: " + ubicacion.getIdUnidad());
        System.out.println("Latitud: " + ubicacion.getLat());
        System.out.println("Longitud: " + ubicacion.getLon());
        return ResponseEntity.ok("Ubicación recibida");
    }

    @GetMapping
    public ResponseEntity<List<UbicacionDTO>> listarUbicaciones() {
        List<UbicacionDTO> lista = ubicacionService.obtenerUbicacionesActualizadas();
        return ResponseEntity.ok(lista);
    }
}
