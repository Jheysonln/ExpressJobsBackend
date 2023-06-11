package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Especialidad;

@Repository
public interface IEspecialidad extends JpaRepository<Especialidad, String>{

	@Query(nativeQuery = true, value = "call obtenerEspecialidad(:p_id)")
	List<Especialidad> obtenerEspecialidad(@Param("p_id")String id);
}
