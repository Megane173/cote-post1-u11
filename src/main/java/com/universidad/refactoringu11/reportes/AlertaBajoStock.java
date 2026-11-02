package com.universidad.refactoringu11.reportes;

import com.universidad.refactoringu11.inventario.Producto;

import java.time.LocalDateTime;

/**
 * Representa un evento de producto que requiere reabastecimiento.
 *
 * @param producto producto que generó la alerta
 * @param cantidadReorden unidades necesarias para reabastecer
 * @param fecha fecha en que se registró la alerta
 */
public record AlertaBajoStock(
        Producto producto,
        int cantidadReorden,
        LocalDateTime fecha
) {
}
