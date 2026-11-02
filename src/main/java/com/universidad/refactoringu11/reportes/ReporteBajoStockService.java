
package com.universidad.refactoringu11.reportes;

import com.universidad.refactoringu11.inventario.NotificadorBajoStock;
import com.universidad.refactoringu11.inventario.Producto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Registra las alertas de productos que requieren reabastecimiento
 * y permite generar un reporte con ellas.
 */
@Service
public class ReporteBajoStockService implements NotificadorBajoStock {

    private final List<AlertaBajoStock> alertas =
            new CopyOnWriteArrayList<>();

    /**
     * Registra un producto que requiere reabastecimiento.
     *
     * @param producto producto que requiere reabastecimiento
     * @param cantidadReorden cantidad necesaria para reabastecer
     */
    @Override
    public void notificar(Producto producto, int cantidadReorden) {

        Objects.requireNonNull(
                producto,
                "El producto no puede ser nulo"
        );

        if (cantidadReorden <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad de reorden debe ser mayor que cero"
            );
        }

        alertas.add(new AlertaBajoStock(
                producto,
                cantidadReorden,
                LocalDateTime.now()
        ));
    }

    /**
     * Genera un reporte con las alertas registradas.
     *
     * @return reporte de productos con bajo stock
     */
    public String generarReporte() {

        if (alertas.isEmpty()) {
            return "No existen alertas de bajo stock.";
        }

        return alertas.stream()
                .map(alerta ->
                        "Producto: " + alerta.producto()
                                + " | Cantidad a reordenar: "
                                + alerta.cantidadReorden()
                                + " | Fecha: "
                                + alerta.fecha()
                )
                .collect(Collectors.joining(
                        System.lineSeparator()
                ));
    }

    /**
     * Obtiene una copia de las alertas registradas.
     *
     * @return lista inmutable de alertas
     */
    public List<AlertaBajoStock> obtenerAlertas() {
        return List.copyOf(alertas);
    }

    /**
     * Elimina las alertas registradas.
     */
    public void limpiar() {
        alertas.clear();
    }
}
