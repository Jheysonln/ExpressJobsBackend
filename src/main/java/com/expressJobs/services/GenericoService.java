package com.expressJobs.services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.Departamento;
import com.expressJobs.models.Distrito;
import com.expressJobs.models.Generico;
import com.expressJobs.models.PrefTelefono;
import com.expressJobs.models.Producto;
import com.expressJobs.models.Provincia;
import com.expressJobs.models.Usuario;
import com.expressJobs.repo.IDepartamento;
import com.expressJobs.repo.IDistrito;
import com.expressJobs.repo.IGenericoRepository;
import com.expressJobs.repo.IProvincia;

@Service
public class GenericoService {

    private final IGenericoRepository genericoRepository;
    private final IDepartamento depaRepository;
    private final IProvincia provRepository;
    private final IDistrito distRepository;
    
    public  GenericoService(IGenericoRepository genericoRepository, IDepartamento depaRepository, IProvincia provRepository, IDistrito distRepository) {
        this.genericoRepository =  genericoRepository;
        this.depaRepository = depaRepository;
        this.provRepository = provRepository;
        this.distRepository = distRepository;
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
    
    
    public CompletableFuture<Boolean> ejecutarCrearGenerico(String cod_tabla_gnrc, String cod_fila_gnrc, String desc_corta_gnrc, String desc_larga_gnrc, String valor_texto_1_gnrc, String valor_texto_2_gnrc,String valor_texto_3_gnrc, String valor_texto_4_gnrc, String estado_generico_gnrc, Date fecha_registro_generico_gnrc) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = genericoRepository.crearGenerico(cod_tabla_gnrc, cod_fila_gnrc, desc_corta_gnrc, desc_larga_gnrc, valor_texto_1_gnrc, valor_texto_2_gnrc,valor_texto_3_gnrc, valor_texto_4_gnrc, estado_generico_gnrc, (java.sql.Date) fecha_registro_generico_gnrc);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
    
    
    public CompletableFuture<Boolean> ejecutarEliminarGenerico(Long id_generico) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = genericoRepository.eliminarGenerico(id_generico);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
    
    
    public CompletableFuture<List<Generico>> ejecutarObtenerGenerico() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Generico> genericos = genericoRepository.obtenerGenerico();
                return genericos;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los genericos", e);
            }
        });
    }

    public CompletableFuture<Generico> ejecutarObtenerGenericoPorId(Long id_generico) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Generico> genericos = genericoRepository.obtenerGenericoPorId(id_generico);
                if (!genericos.isEmpty()) {
                    return genericos.get(0);
                } else {
                    throw new RuntimeException("No se encontró ningún generico con el ID especificado");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener el generico por su ID", e);
            }
        });
    }
    
    
    
    
    
    
    
    
    
    
}
