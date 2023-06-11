package com.expressJobs.contoller;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expressJobs.models.Especialidad;
import com.expressJobs.request.EspecialidadRequest;
import com.expressJobs.services.EspecialidadService;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {


	private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }
	
    @PostMapping("/crearEspecialidad")
    public CompletableFuture<Boolean> crearEspecialidad(@RequestBody EspecialidadRequest request) {
        String nombreEspecialidad = request.getNom_especialidad();
   

        
        
        return especialidadService.ejecutarCrearEspecialidad(nombreEspecialidad )
                .exceptionally(ex -> {
                    return false; 
                });
    }
	
    @GetMapping("/obtenerEspecialidad")
    @ResponseBody
    public CompletableFuture<List<Especialidad>> obtenerEspecialidad() {
        return especialidadService.ejecutarObtenerEspecialidad()
                .exceptionally(ex -> {
                    return Collections.emptyList(); 
                });
    }
    
    @GetMapping("/obtenerEspecialidadId/{id}")
    public CompletableFuture<ResponseEntity<Especialidad>> obtenerEspecialidadPorId(@PathVariable Long idEspecialidad) {
        return especialidadService.ejecutarObtenerEspecialidadPorId(idEspecialidad)
                .thenApply(especialidad -> ResponseEntity.ok(especialidad))
                .exceptionally(ex -> {
                    String errorMessage = "Error al obtener la Especialidad por su ID: " + ex.getMessage();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }

    @PutMapping("/actualizarEspecialidad/{id}")
    public CompletableFuture<Boolean> actualizarEspecialidad(@PathVariable Long idEspecialidad, @RequestBody EspecialidadRequest request) {
        String nombreEspecialidad = request.getNom_especialidad();
        

        return especialidadService.ejecutarActualizarEspecialidad(idEspecialidad, nombreEspecialidad
        		)
                .exceptionally(ex -> {

                    return false; 
                });
    }

    @DeleteMapping("/eliminarEspecialidad/{id}")
    public CompletableFuture<Boolean> eliminarEspecialidad(@PathVariable Long idEspecialidad) {
        return especialidadService.ejecutarEliminarEspecialidad(idEspecialidad)
                .exceptionally(ex -> {

                    return false; 
                });
    }
}
