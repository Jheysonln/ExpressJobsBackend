package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Especialidad;
import com.expressJobs.models.Usuario;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Long>{

	@Procedure(name = "crearEspecialidad", outputParameterName = "exito")
    Boolean crearEspecialidad(
            @Param("pNom_especialidad") String nom_especialidad
       
    );
	
	@Procedure(name = "actualizarEspecialidad", outputParameterName = "exito")
    Boolean actualizarEspecialidad(
    		@Param("pId_especialidad") Long id_especialidad,
            @Param("pNom_especialidad") String nom_especialidad
       
    );
	

    @Procedure(name = "eliminarEspecialidad", outputParameterName = "exito")
    Boolean eliminarEspecialidad(
            @Param("pId_especialidad") Long id_especialidad
    );

    @Query(nativeQuery = true, value = "CALL obtenerEspecialidad()")
    List<Especialidad> obtenerEspecialidades();

    @Query(nativeQuery = true, value = "CALL obtenerEspecialidadPorId(:pId_especialidad)")
    List<Especialidad> obtenerEspecialidadesPorId(@Param("pId_especialidad") Long id_especialidad);

	
	
}
