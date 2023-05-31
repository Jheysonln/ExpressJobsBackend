package com.expressJobs.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.PrefTelefono;
import com.expressJobs.models.Producto;
import com.expressJobs.repo.IGenericRepository;
import com.expressJobs.repo.IProductoRepository;

@Service
public class GenericService {

    private final IGenericRepository genericRepository;

    public  GenericService(IGenericRepository genericRepository) {
        this.genericRepository =  genericRepository;
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
}
