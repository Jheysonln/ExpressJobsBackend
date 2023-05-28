package com.expressJobs.contoller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.expressJobs.models.Producto;
import com.expressJobs.repo.IProductoRepository;
import com.expressJobs.request.ProductoRequest;
import com.expressJobs.services.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/crearProducto")
    public CompletableFuture<Boolean> crearProducto(@RequestBody ProductoRequest request) {
        String nombre = request.getNombre();
        BigDecimal precio = request.getPrecio();
        String descripcion = request.getDescripcion();

        return productoService.ejecutarCrearProducto(nombre, precio, descripcion)
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return false; // Devolver un valor predeterminado en caso de error
                });
    }

    @GetMapping("/obtenerProductos")
    @ResponseBody
    public CompletableFuture<List<Producto>> obtenerProductos() {
        return productoService.ejecutarObtenerProductos()
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return Collections.emptyList(); // Devolver una lista vacía en caso de error
                });
    }

    @GetMapping("/obtenerProductoId/{id}")
    public CompletableFuture<ResponseEntity<Producto>> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.ejecutarObtenerProductoPorId(id)
                .thenApply(producto -> ResponseEntity.ok(producto))
                .exceptionally(ex -> {
                    String errorMessage = "Error al obtener el producto por su ID: " + ex.getMessage();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }

    @PutMapping("/actualizarProducto/{id}")
    public CompletableFuture<Boolean> actualizarProducto(@PathVariable Long id, @RequestBody ProductoRequest request) {
        String nombre = request.getNombre();
        BigDecimal precio = request.getPrecio();
        String descripcion = request.getDescripcion();

        return productoService.ejecutarActualizarProducto(id, nombre, precio, descripcion)
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return false; // Devolver un valor predeterminado en caso de error
                });
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public CompletableFuture<Boolean> eliminarProducto(@PathVariable Long id) {
        return productoService.ejecutarEliminarProducto(id)
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return false; // Devolver un valor predeterminado en caso de error
                });
    }
}
