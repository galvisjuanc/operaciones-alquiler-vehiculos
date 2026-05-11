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

        VehiculoDTO vehiculo = vehiculoCliente.obtenerPorId(vehiculoId);

        if ("DISPONIBLE".equals(vehiculo.estado())) {

            VehiculoDTO actualizado = new VehiculoDTO(
                    vehiculo.marca(), vehiculo.modelo(),
                    vehiculo.placa(), "NO_DISPONIBLE"
            );

            vehiculoCliente.actualizar(vehiculoId, actualizado);

            return "Alquiler registrado con éxito.";
        }

        return "El vehículo no está disponible actualmente.";
    }

    public String cancelarAlquiler(int vehiculoId) {

        VehiculoDTO vehiculoAlquilado = vehiculoCliente.obtenerPorId(vehiculoId);

        if("NO_DISPONIBLE".equals(vehiculoAlquilado.estado())) {

            VehiculoDTO actualizado = new VehiculoDTO(
                    vehiculoAlquilado.marca(), vehiculoAlquilado.modelo(),
                    vehiculoAlquilado.placa(), "DISPONIBLE"
            );

            vehiculoCliente.actualizar(vehiculoId, actualizado);

            return "El alquiler ha sido cancelado. Vehiculo nuevamente disponible";
        }

        return "El vehiculo no ha sido alquilado.";
    }
}
