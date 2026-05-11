package com.unir.operaciones.service;

import com.unir.operaciones.client.VehiculoCliente;
import com.unir.operaciones.dto.VehiculoDTO;
import org.springframework.stereotype.Service;

@Service
public class OperacionService {

    private final  VehiculoCliente vehiculoCliente;

    public OperacionService(VehiculoCliente vehiculoCliente) {
        this.vehiculoCliente = vehiculoCliente;
    }

    public String procesarAlquiler(int vehiculoId) {
        // 1. Consultar al otro microservicio
        VehiculoDTO vehiculo = vehiculoCliente.obtenerPorId(vehiculoId);

        // 2. Validar disponibilidad
        if ("DISPONIBLE".equals(vehiculo.estado())) {

            // 3. Crear nuevo objeto con estado cambiado (si usas records, creas uno nuevo)
            VehiculoDTO actualizado = new VehiculoDTO(
                    vehiculo.marca(), vehiculo.modelo(),
                    vehiculo.placa(), "NO_DISPONIBLE"
            );

            // 4. Notificar al microservicio de vehículos la actualización
            vehiculoCliente.actualizar(vehiculoId, actualizado);

            return "Alquiler registrado con éxito.";
        }

        return "El vehículo no está disponible actualmente.";
    }
}
