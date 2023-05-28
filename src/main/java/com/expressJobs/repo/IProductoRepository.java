package com.expressJobs.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Procedure(name = "crearProducto", outputParameterName = "exito")
    Boolean crearProducto(
            @Param("nombre") String nombre,
            @Param("precio") BigDecimal precio,
            @Param("descripcion") String descripcion
    );

    @Procedure(name = "actualizarProducto", outputParameterName = "exito")
    Boolean actualizarProducto(
            @Param("producto_id") Long id,
            @Param("nombre") String nombre,
            @Param("precio") BigDecimal precio,
            @Param("descripcion") String descripcion
    );

    @Procedure(name = "eliminarProducto", outputParameterName = "exito")
    Boolean eliminarProducto(
            @Param("producto_id") Long id
    );

    @Query(nativeQuery = true, value = "CALL obtenerProductos()")
    List<Producto> obtenerProductos();

    @Query(nativeQuery = true, value = "CALL obtenerProductoPorId(:producto_id)")
    List<Producto> obtenerProductosPorId(@Param("producto_id") Long id);
}
