package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Distrito;

@Repository
public interface IDistrito extends JpaRepository<Distrito, Integer>{
    @Query(nativeQuery = true, value = "CALL obtenerDistrito(:pId_prov)")
    List<Distrito> obtenerDistrito(@Param("pId_prov") Integer id_prov);
}
