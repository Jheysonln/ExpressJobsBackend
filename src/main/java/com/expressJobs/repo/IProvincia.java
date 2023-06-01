package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Provincia;

@Repository
public interface IProvincia extends JpaRepository<Provincia, Integer>{

    @Query(nativeQuery = true, value = "CALL obtenerProvincia(:pId_depa)")
    List<Provincia> obtenerProvincia(@Param("pId_depa") Integer id_depa);
}
