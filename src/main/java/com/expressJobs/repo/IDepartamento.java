package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Departamento;

@Repository
public interface IDepartamento extends JpaRepository<Departamento, Integer>{
    @Query(nativeQuery = true, value = "CALL obtenerDepartamento()")
    List<Departamento> obtenerDepartamento();
}
