package com.expressJobs.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressJobs.models.Producto;
import com.expressJobs.repo.IProductoRepository;

@Service
public class ProductoService {

    private final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public CompletableFuture<Boolean> ejecutarCrearProducto(String nombre, BigDecimal precio, String descripcion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = productoRepository.crearProducto(nombre, precio, descripcion);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }

    public CompletableFuture<List<Producto>> ejecutarObtenerProductos() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Producto> productos = productoRepository.obtenerProductos();
                return productos;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los productos", e);
            }
        });
    }

    public CompletableFuture<Producto> ejecutarObtenerProductoPorId(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Producto> productos = productoRepository.obtenerProductosPorId(id);
                if (!productos.isEmpty()) {
                    return productos.get(0);
                } else {
                    throw new RuntimeException("No se encontró ningún producto con el ID especificado");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener el producto por su ID", e);
            }
        });
    }

    public CompletableFuture<Boolean> ejecutarActualizarProducto(Long id, String nombre, BigDecimal precio, String descripcion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = productoRepository.actualizarProducto(id, nombre, precio, descripcion);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }

    public CompletableFuture<Boolean> ejecutarEliminarProducto(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = productoRepository.eliminarProducto(id);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
}
