package com.expressJobs.contoller;

import java.math.BigDecimal;
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

import com.expressJobs.models.Producto;
import com.expressJobs.models.Usuario;
import com.expressJobs.request.ProductoRequest;
import com.expressJobs.request.UsuarioRequest;
import com.expressJobs.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
	
    @PostMapping("/crearUsuario")
    public CompletableFuture<Boolean> crearUsuario(@RequestBody UsuarioRequest request) {
        String nombreUsuario = request.getNombreUsuario();
        String apellidoUsuario = request.getApellidoUsuario();
        String  correoUsuario = request.getCorreoUsuario();
        String  contraseniaUsuario = request.getContraseniaUsuario();
        String  prefijoUsuario = request.getPrefijoUsuario();
        String  telefonoUsuario = request.getTelefonoUsuario();
        String  idDocumentoUsuario = request.getIdDocumentoUsuario();
        String  documentoUsuario = request.getDocumentoUsuario();
        Integer idDepartamento = request.getIdDepartamento();
        Integer idProvincia = request.getIdProvincia();
        Integer idDistrito = request.getIdDistrito();
        String  direccion = request.getDireccion();
        Integer idRol = request.getIdRol();
        Integer idEspecialidad =request.getidEspecialidad();

        
        
        return usuarioService.ejecutarCrearUsuario(nombreUsuario ,
        		apellidoUsuario ,
        		correoUsuario ,
        		contraseniaUsuario ,
        		prefijoUsuario ,
        		telefonoUsuario ,
        		idDocumentoUsuario ,
        		documentoUsuario ,
        		idDepartamento ,
        		idProvincia ,
        		idDistrito ,
        		direccion ,
        		idRol ,
        		idEspecialidad)
                .exceptionally(ex -> {
                    return false; 
                });
    }
	
    @GetMapping("/obtenerUsuarios")
    @ResponseBody
    public CompletableFuture<List<Usuario>> obtenerUsuarios() {
        return usuarioService.ejecutarObtenerUsuarios()
                .exceptionally(ex -> {
                    return Collections.emptyList(); 
                });
    }
    
    @GetMapping("/obtenerUsuarioId/{id}")
    public CompletableFuture<ResponseEntity<Usuario>> obtenerUsuarioPorId(@PathVariable Long idusuario) {
        return usuarioService.ejecutarObtenerUsuarioPorId(idusuario)
                .thenApply(usuario -> ResponseEntity.ok(usuario))
                .exceptionally(ex -> {
                    String errorMessage = "Error al obtener el usuario por su ID: " + ex.getMessage();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }

    @PutMapping("/actualizarUsuario/{id}")
    public CompletableFuture<Boolean> actualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioRequest request) {
        String nombreUsuario = request.getNombreUsuario();
        String apellidoUsuario = request.getApellidoUsuario();
        String  correoUsuario = request.getCorreoUsuario();
        String  contraseniaUsuario = request.getContraseniaUsuario();
        String  prefijoUsuario = request.getPrefijoUsuario();
        String  telefonoUsuario = request.getTelefonoUsuario();
        String  idDocumentoUsuario = request.getIdDocumentoUsuario();
        String  documentoUsuario = request.getDocumentoUsuario();
        Integer idDepartamento = request.getIdDepartamento();
        Integer idProvincia = request.getIdProvincia();
        Integer idDistrito = request.getIdDistrito();
        String  direccion = request.getDireccion();
        Integer idRol = request.getIdRol();
        Integer idEspecialidad =request.getidEspecialidad();

        return usuarioService.ejecutarActualizarUsuario(idUsuario, nombreUsuario ,
        		apellidoUsuario ,
        		correoUsuario ,
        		contraseniaUsuario ,
        		prefijoUsuario ,
        		telefonoUsuario ,
        		idDocumentoUsuario ,
        		documentoUsuario ,
        		idDepartamento ,
        		idProvincia ,
        		idDistrito ,
        		direccion ,
        		idRol,
        		idEspecialidad)
                .exceptionally(ex -> {

                    return false; 
                });
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public CompletableFuture<Boolean> eliminarUsuario(@PathVariable Long idUsuario) {
        return usuarioService.ejecutarEliminarUsuario(idUsuario)
                .exceptionally(ex -> {

                    return false; 
                });
    }
	
}
