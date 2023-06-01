package com.expressJobs.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.Usuario;
import com.expressJobs.repo.IUsuarioRepository;

@Service
public class UsuarioService {
	
	private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public CompletableFuture<Boolean> ejecutarCrearUsuario(String nombreUsuario, String apellidoUsuario, String  correoUsuario, String  contraseniaUsuario, String  prefijoUsuario, String  telefonoUsuario,	 String  idDocumentoUsuario, String  documentoUsuario, Integer idDepartamento, Integer idProvincia, Integer idDistrito, String  direccion, Integer idRol, Integer idEspecialidad) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = usuarioRepository.crearUsuario(nombreUsuario,  apellidoUsuario,   correoUsuario,   contraseniaUsuario,   prefijoUsuario,   telefonoUsuario,	   idDocumentoUsuario,   documentoUsuario,  idDepartamento,  idProvincia,  idDistrito,   direccion,  idRol, idEspecialidad);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
    
    public CompletableFuture<List<Usuario>> ejecutarObtenerUsuarios() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Usuario> usuarios = usuarioRepository.obtenerUsuarios();
                return usuarios;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los usuarios", e);
            }
        });
    }

    public CompletableFuture<Usuario> ejecutarObtenerUsuarioPorId(Long idUsuario) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Usuario> usuarios = usuarioRepository.obtenerUsuariosPorId(idUsuario);
                if (!usuarios.isEmpty()) {
                    return usuarios.get(0);
                } else {
                    throw new RuntimeException("No se encontró ningún usuario con el ID especificado");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener el usuario por su ID", e);
            }
        });
    }
    
    public CompletableFuture<Boolean> ejecutarActualizarUsuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, String  correoUsuario, String  contraseniaUsuario, String  prefijoUsuario, String  telefonoUsuario,	 String  idDocumentoUsuario, String  documentoUsuario, Integer idDepartamento, Integer idProvincia, Integer idDistrito, String  direccion, Integer idRol, Integer idEspecialidad) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = usuarioRepository.actualizarUsuario(idUsuario, nombreUsuario,  apellidoUsuario,   correoUsuario,   contraseniaUsuario,   prefijoUsuario,   telefonoUsuario,	   idDocumentoUsuario,   documentoUsuario,  idDepartamento,  idProvincia,  idDistrito,   direccion,  idRol, idEspecialidad);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }

    public CompletableFuture<Boolean> ejecutarEliminarUsuario(Long idUsuario) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Boolean exito = usuarioRepository.eliminarUsuario(idUsuario);
                return exito;
            } catch (Exception e) {
                throw new RuntimeException("Error al ejecutar el procedimiento almacenado", e);
            }
        });
    }
    
}
