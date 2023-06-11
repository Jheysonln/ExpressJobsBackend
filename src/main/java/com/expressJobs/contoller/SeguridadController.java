package com.expressJobs.contoller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expressJobs.models.Usuario;
import com.expressJobs.services.UsuarioService;

@RestController
@RequestMapping("/api/seguridad")
public class SeguridadController {
	
	@Autowired
	public UsuarioService usuarioService;
	// Grabar
	@GetMapping("/login/{email}/{password}")
	public CompletableFuture<ResponseEntity<Usuario>> obtenerUsuarioPorEmailYPassword(@PathVariable String email, @PathVariable String password) {
        return usuarioService.ejecutarObtenerUsuarioPorEmailYPassword(email, password)
                .thenApply(usuario -> ResponseEntity.ok(usuario))
                .exceptionally(ex -> {
                    String errorMessage = "Error al obtener el usuario por su email: " + ex.getMessage();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }
}
