package com.expressJobs.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.expressJobs.models.PaginationResult;
import com.expressJobs.models.Rol;
import com.expressJobs.models.Usuario;
import com.expressJobs.repo.IRolesRepository;
import com.expressJobs.repo.IUsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final IUsuarioRepository usuarioRepository;
	private final IRolesRepository rolRepository;

	public UsuarioService(IUsuarioRepository usuarioRepository, IRolesRepository rolRepository) {
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
	}

	public CompletableFuture<Long> ejecutarCrearUsuario(Usuario usuario) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Long exito = usuarioRepository.crearUsuario(usuario.getUsername(), usuario.getApe_usuario(),
						usuario.getEmail(), usuario.getPassword(), usuario.getPassword_confirm(),
						usuario.getId_prefijo_telefono(), usuario.getTelefono_usuario(), usuario.getId_tipodocumento(),
						usuario.getNum_documento(), usuario.getId_Depa(), usuario.getId_provincia(),
						usuario.getId_dist(), usuario.getDirec_usuario(), usuario.getId_rol(),
						usuario.getId_especialidad(), usuario.getFecha_registro());
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
				System.out.println(usuarios);
				// Iterate over the usuarios and fetch the roles for each usuario
				for (Usuario usuario : usuarios) {
					Long idRol = usuario.getId_rol();
					List<Rol> roles = rolRepository.obtenerRoles(idRol);
					usuario.setListRoles(roles);
				}

				return usuarios;
			} catch (Exception e) {
				throw new RuntimeException("Error al obtener los usuarios", e);
			}
		});
	}

//    public CompletableFuture<List<Rol>> ejecutarObtenerRol(Long idRol) {
//    	return CompletableFuture.supplyAsync(() -> {
//            try {
//                List<Rol> rol = rolRepository.obtenerRoles(idRol);
//                return rol;
//            } catch (Exception e) {
//                throw new RuntimeException("Error al obtener los usuarios", e);
//            }
//        });
//    }

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

	public CompletableFuture<Boolean> ejecutarActualizarUsuario(Usuario usuario) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Boolean exito = usuarioRepository.actualizarUsuario(usuario.getId_usuario(), usuario.getUsername(),
						usuario.getApe_usuario(), usuario.getEmail(), usuario.getPassword(),
						usuario.getPassword_confirm(), usuario.getId_prefijo_telefono(), usuario.getTelefono_usuario(),
						usuario.getId_tipodocumento(), usuario.getNum_documento(), usuario.getId_Depa(),
						usuario.getId_provincia(), usuario.getId_dist(), usuario.getDirec_usuario(),
						usuario.getId_rol(), usuario.getId_especialidad());
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

	public CompletableFuture<Long> ejecutarInsertUserRol(Long userId, Long rolId) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Long id_usuario = userId;
				Long id_rol = rolId;
				Long exito = usuarioRepository.crearUsuarioRol(id_usuario, id_rol);
				return exito;
			} catch (Exception e) {
				throw new RuntimeException("Error al ejecutar el procedimiento almacenado :" + e);
			}
		});
	}

}
