package com.expressJobs.contoller;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expressJobs.models.PrefTelefono;
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
}
