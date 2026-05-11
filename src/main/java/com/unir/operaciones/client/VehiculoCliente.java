package com.unir.operaciones.client;

import com.unir.operaciones.dto.VehiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-vehiculos")
public interface VehiculoCliente {

    @GetMapping("/api/vehiculos/{id}")
    VehiculoDTO obtenerPorId(@PathVariable int id);

    @PutMapping("/api/vehiculos/{id}")
    VehiculoDTO actualizar(@PathVariable int id, @RequestBody VehiculoDTO vehiculo);
}
