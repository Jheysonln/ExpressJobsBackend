package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expressJobs.models.Rol;
import com.expressJobs.models.Usuario;

public interface IRolesRepository extends JpaRepository<Rol, Long> {

	@Query(nativeQuery = true, value = "CALL obtenerRoles(:pId_rol)")
	List<Rol> obtenerRoles(@Param("pId_rol") Long id_rol);

}
