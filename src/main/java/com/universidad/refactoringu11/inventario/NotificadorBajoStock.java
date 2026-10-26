package com.universidad.refactoringu11.inventario;

public interface NotificadorBajoStock {
    void notificar(Producto producto, int cantidadReorden);
    // el cuerpo de la implementacion queda a cargo del estudiante en ReporteBajoStockService
}
