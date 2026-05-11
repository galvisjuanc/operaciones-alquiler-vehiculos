package com.unir.operaciones.web.controller;

import com.unir.operaciones.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operaciones")
public class OperacionController {

    @Autowired
    private OperacionService service;

    @PostMapping("/alquilar/{id}")
    public ResponseEntity<String> alquilar(@PathVariable int id) {
        String resultado = service.procesarAlquiler(id);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/cancelaralquiler/{id}")
    public ResponseEntity<String> cancelarAlquilerVehiculo(@PathVariable int id) {
        String resultado = service.cancelarAlquiler(id);
        return ResponseEntity.ok(resultado);
    }
}
