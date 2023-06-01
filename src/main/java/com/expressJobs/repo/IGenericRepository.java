package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.PrefTelefono;


@Repository
public interface IGenericRepository extends JpaRepository<PrefTelefono, Long>{

	
    @Query(nativeQuery = true, value = "CALL obtenerPrefTelefono()")
    
    
    
    List<PrefTelefono> obtenerPrefTelefono();
}
