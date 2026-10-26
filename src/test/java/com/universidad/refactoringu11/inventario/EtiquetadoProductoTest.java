package com.universidad.refactoringu11.inventario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtiquetadoProductoTest {

    private final EtiquetadoProducto etiquetado = new EtiquetadoProducto();

    @Test
    void libro_incluyeExentoDeIva() {
        Producto p = new Producto(1L, "Refactoring", TipoProducto.LIBRO, 60.0, 10, 2);
        assertEquals("[LIBRO] Refactoring - Exento de IVA", etiquetado.generarEtiqueta(p));
    }

    @Test
    void electronico_incluyeGarantia() {
        Producto p = new Producto(2L, "Teclado", TipoProducto.ELECTRONICO, 100.0, 10, 2);
        assertEquals("[ELECTRO] Teclado - Garantia 1 ano", etiquetado.generarEtiqueta(p));
    }

    @Test
    void generarEtiqueta_Ropa_DevuelveEtiquetaConIndicacionDeTalla() {
        // Arrange
        Producto producto = new Producto(
                1L, "Camisa", TipoProducto.ROPA, 50000.0, 10, 5
        );
        EtiquetadoProducto etiquetado = new EtiquetadoProducto();
        // Act
        String etiqueta = etiquetado.generarEtiqueta(producto);
        // Assert
        assertEquals("[ROPA] Camisa - Ver talla", etiqueta);
    }

    @Test
    void generarEtiqueta_Alimento_DevuelveEtiquetaConIndicacionDePerecedero() {
        // Arrange
        Producto producto = new Producto(
                2L, "Leche", TipoProducto.ALIMENTO, 5000.0, 20, 5
        );
        EtiquetadoProducto etiquetado = new EtiquetadoProducto();
        // Act
        String etiqueta = etiquetado.generarEtiqueta(producto);
        // Assert
        assertEquals("[ALIMENTO] Leche - Perecedero", etiqueta);
    }
}