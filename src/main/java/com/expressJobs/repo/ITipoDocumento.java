package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.TipoDocumento;

@Repository
public interface ITipoDocumento extends JpaRepository<TipoDocumento, String>{

    @Query(nativeQuery = true, value = "CALL obtenerTipoDocuento(:p_id)")
    List<TipoDocumento> obtenerTipoDocuento(@Param("p_id") String id);
}
