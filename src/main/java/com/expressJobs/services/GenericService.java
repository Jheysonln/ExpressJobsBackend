package com.expressJobs.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.Departamento;
import com.expressJobs.models.Distrito;
import com.expressJobs.models.PrefTelefono;
import com.expressJobs.models.Producto;
import com.expressJobs.models.Provincia;
import com.expressJobs.repo.IDepartamento;
import com.expressJobs.repo.IDistrito;
import com.expressJobs.repo.IGenericRepository;
import com.expressJobs.repo.IProvincia;

@Service
public class GenericService {

    private final IGenericRepository genericRepository;
    private final IDepartamento depaRepository;
    private final IProvincia provRepository;
    private final IDistrito distRepository;
    
    public  GenericService(IGenericRepository genericRepository, IDepartamento depaRepository, IProvincia provRepository, IDistrito distRepository) {
        this.genericRepository =  genericRepository;
        this.depaRepository = depaRepository;
        this.provRepository = provRepository;
        this.distRepository = distRepository;
    }

    public CompletableFuture<List<PrefTelefono>> ejecutarObtenerPrefTelefono() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<PrefTelefono> preftelefonos =  genericRepository.obtenerPrefTelefono();
                return preftelefonos;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los prefijos de los telefonos", e);
            }
        });
    }
    
    public CompletableFuture<List<Departamento>> ejecutarObtenerDepartamento() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Departamento> departamento =  depaRepository.obtenerDepartamento();
                return departamento;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los despartamentos...", e);
            }
        });
    }
    
    
    public CompletableFuture<List<Provincia>> ejecutarObtenerProvincia(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Provincia> provincia =  provRepository.obtenerProvincia(id);
                return provincia;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener las provincias...", e);
            }
        });
    }
    
    public CompletableFuture<List<Distrito>> ejecutarObtenerDistrito(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Distrito> distrito = distRepository.obtenerDistrito(id);
                return distrito;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los distrito...", e);
            }
        });
    }
}
