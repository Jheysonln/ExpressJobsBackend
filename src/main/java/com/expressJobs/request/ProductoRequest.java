package com.expressJobs.request;

import java.math.BigDecimal;

public class ProductoRequest {
    private String nombre;
    private BigDecimal precio;
    private String descripcion;

    public ProductoRequest() {
        // Constructor vacío (puedes omitirlo si no necesitas inicializar los campos)
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}