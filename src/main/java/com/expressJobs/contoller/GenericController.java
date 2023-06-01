package com.expressJobs.contoller;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expressJobs.models.Departamento;
import com.expressJobs.models.Distrito;
import com.expressJobs.models.PrefTelefono;
import com.expressJobs.models.Producto;
import com.expressJobs.models.Provincia;
import com.expressJobs.services.GenericService;

@RestController
@RequestMapping("/api/generic")
public class GenericController {
	
    private final GenericService genericService;

    public GenericController(GenericService genericService) {
        this.genericService = genericService;
    }
	
    
    @GetMapping("/obtenerPrefTelefonos")
    @ResponseBody
    public CompletableFuture<List<PrefTelefono>> obtenerPrefTelefono() {
        return genericService.ejecutarObtenerPrefTelefono()
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return Collections.emptyList(); // Devolver una lista vacía en caso de error
                });
    }
    
    @GetMapping("/obtenerDepartamentos")
    @ResponseBody
    public CompletableFuture<List<Departamento>> obtenerDepartamento() {
        return genericService.ejecutarObtenerDepartamento()
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return Collections.emptyList(); // Devolver una lista vacía en caso de error
                });
    }

    
    @GetMapping("/obtenerProvincia/{id}")
    @ResponseBody
    public CompletableFuture<List<Provincia>> obtenerProvincia(@PathVariable Integer id) {
    	 return genericService.ejecutarObtenerProvincia(id)
                 .exceptionally(ex -> {
                     // Manejar la excepción
                     // Por ejemplo, registrar el error o lanzar una excepción personalizada
                     return Collections.emptyList(); // Devolver una lista vacía en caso de error
                 });
    }
    
    @GetMapping("/obtenerDistrito/{id}")
    @ResponseBody
    public CompletableFuture<List<Distrito>> obtenerDistrito(@PathVariable Integer id) {
    	 return genericService.ejecutarObtenerDistrito(id)
                 .exceptionally(ex -> {
                     // Manejar la excepción
                     // Por ejemplo, registrar el error o lanzar una excepción personalizada
                     return Collections.emptyList(); // Devolver una lista vacía en caso de error
                 });
    }
}
