package com.universidad.refactoringu11.reportes;

import com.universidad.refactoringu11.inventario.InventarioService;
import org.springframework.stereotype.Service;

@Service
public class ReporteBajoStockService {

    private final InventarioService inventarioService;

    public ReporteBajoStockService(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public String generarReporte() {
        // recorre los productos bajo stock minimo expuestos por InventarioService
        // y arma un reporte de texto plano (implementacion a cargo del estudiante)
        return "Reporte de bajo stock pendiente de implementar";
    }
}