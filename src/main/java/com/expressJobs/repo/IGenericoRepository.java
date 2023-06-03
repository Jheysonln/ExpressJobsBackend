package com.expressJobs.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.expressJobs.models.Generico;


@Repository
public interface IGenericoRepository extends JpaRepository<Generico, Long>{

	
	@Procedure(name = "crearGenerico", outputParameterName = "exito")
    Boolean crearGenerico(
            @Param("pCod_tabla") String cod_tabla,
            @Param("pCod_fila") String cod_fila,
            @Param("pDesc_corta") String desc_corta,
            @Param("pDesc_larga") String desc_larga,
            @Param("pValor_texto_1") String valor_texto_1,
            @Param("pValor_texto_2") String valor_texto_2,
            @Param("pValor_texto_3") String valor_texto_3,
            @Param("pValor_texto_4") String valor_texto_4,
            @Param("pEstado_generico") String estado_generico,
            @Param("pFecha_registro_generico") Date fecha_registro_generico
       
    );
	
	@Procedure(name = "eliminarGenerico", outputParameterName = "exito")
    Boolean eliminarGenerico(
            @Param("pId_generico_tabla") Long id_generico_tabla
    );

	
    @Query(nativeQuery = true, value = "CALL obtenerGenerico()")
    List<Generico> obtenerGenerico();

    @Query(nativeQuery = true, value = "CALL obtenerGenericoPorId(:pId_generico_tabla)")
    List<Generico> obtenerGenericoPorId(@Param("pId_generico_tabla") Long id_generico_tabla);
    
}
