package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.PrefijoTelefono;

@Repository
public interface IPrefijoTelefono extends JpaRepository<PrefijoTelefono, String>{

	@Query(nativeQuery = true, value = "call obtenerPrefijoTelefono(:p_id)")
	List<PrefijoTelefono> obtenerPrefijoTelefono(@Param("p_id")String id);
}
