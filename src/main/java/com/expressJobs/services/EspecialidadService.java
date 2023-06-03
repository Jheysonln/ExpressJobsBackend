package com.expressJobs.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.Especialidad;
import com.expressJobs.repo.IEspecialidadRepository;

@Service
public class EspecialidadService {
	

	private final IEspecialidadRepository especialidadRepository;

    public EspecialidadService(IEspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }
    
    public CompletableFuture<Boolean> ejecutarCrearEspecialidad(String nombreEspecialidad) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = especialidadRepository.crearEspecialidad(nombreEspecialidad);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
    
    public CompletableFuture<List<Especialidad>> ejecutarObtenerEspecialidad() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Especialidad> especialidades = especialidadRepository.obtenerEspecialidades();
                return especialidades;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener las especialidades", e);
            }
        });
    }

    public CompletableFuture<Especialidad> ejecutarObtenerEspecialidadPorId(Long idEspecialidad) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Especialidad> especialidades = especialidadRepository.obtenerEspecialidadesPorId(idEspecialidad);
                if (!especialidades.isEmpty()) {
                    return especialidades.get(0);
                } else {
                    throw new RuntimeException("No se encontró ninguna Especialidad con el ID especificado");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener la Especialidadpor su ID", e);
            }
        });
    }
    
    public CompletableFuture<Boolean> ejecutarActualizarEspecialidad(Long idEspecialidad,String nombreEspecialidad) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = especialidadRepository.actualizarEspecialidad(idEspecialidad , nombreEspecialidad);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }

    public CompletableFuture<Boolean> ejecutarEliminarEspecialidad(Long idEspecialidad) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = especialidadRepository.eliminarEspecialidad(idEspecialidad);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
    
}
