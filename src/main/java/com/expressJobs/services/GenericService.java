package com.expressJobs.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.Departamento;
import com.expressJobs.models.Distrito;
import com.expressJobs.models.Especialidad;
import com.expressJobs.models.PrefijoTelefono;
import com.expressJobs.models.Provincia;
import com.expressJobs.models.TipoDocumento;
import com.expressJobs.models.TipoPago;
import com.expressJobs.repo.IDepartamento;
import com.expressJobs.repo.IDistrito;
import com.expressJobs.repo.IEspecialidad;
import com.expressJobs.repo.IPrefijoTelefono;
import com.expressJobs.repo.IProvincia;
import com.expressJobs.repo.ITipoDocumento;
import com.expressJobs.repo.ITipoPago;

@Service
public class GenericService {

    private final IDepartamento depaRepository;
    private final IProvincia provRepository;
    private final IDistrito distRepository;
    private final ITipoDocumento tdRepository;
    private final ITipoPago tpRepository;
    private final IPrefijoTelefono ptRepository;
    private final IEspecialidad eRepository;
    
    public  GenericService(IDepartamento depaRepository, IProvincia provRepository, IDistrito distRepository, ITipoDocumento tdRepository,
    						ITipoPago tpRepository, IPrefijoTelefono ptRepository, IEspecialidad eRepository) {
        this.depaRepository = depaRepository;
        this.provRepository = provRepository;
        this.distRepository = distRepository;
        this.tdRepository = tdRepository;
        this.tpRepository = tpRepository;
        this.ptRepository = ptRepository;
        this.eRepository = eRepository;
    }
    
    public CompletableFuture<List<Especialidad>> ejecutarObtenerEspecialidad(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Especialidad> esp = eRepository.obtenerEspecialidad(id);
                return esp;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener las especialidades...", e);
            }
        });
    }
    
    public CompletableFuture<List<PrefijoTelefono>> ejecutarObtenerPrefijoTelefono(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<PrefijoTelefono> pt = ptRepository.obtenerPrefijoTelefono(id);
                return pt;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los prefijo de telefono...", e);
            }
        });
    }
    
    public CompletableFuture<List<TipoPago>> ejecutarObtenerTipoPago(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<TipoPago> tp = tpRepository.obtenerTipoPago(id);
                return tp;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los tipo de pago...", e);
            }
        });
    }
    
    public CompletableFuture<List<TipoDocumento>> ejecutarObtenerTipoDocuento(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<TipoDocumento> td = tdRepository.obtenerTipoDocuento(id);
                return td;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los tipo de documento...", e);
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
