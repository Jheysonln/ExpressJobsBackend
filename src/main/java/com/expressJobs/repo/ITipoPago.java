package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.TipoPago;

@Repository
public interface ITipoPago extends JpaRepository<TipoPago, String>{

	@Query(nativeQuery = true, value = "call obtenerTipoPago(:p_id)")
	List<TipoPago> obtenerTipoPago(@Param("p_id")String id);
}
