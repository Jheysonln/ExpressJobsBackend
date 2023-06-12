package com.expressJobs.contoller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expressJobs.models.PaginationResult;
import com.expressJobs.models.Producto;
import com.expressJobs.models.Rol;
import com.expressJobs.models.Usuario;
import com.expressJobs.repo.IUsuarioRepository;
import com.expressJobs.request.ProductoRequest;
import com.expressJobs.request.UsuarioRequest;
import com.expressJobs.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class UsuarioController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/obtenerUsuariosPaginado")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USERWORKER')")
	@ResponseBody
	public CompletableFuture<List<Usuario>> obtenerUsuariosPaginado(@RequestParam("pagina") int pagina, @RequestParam("registrosPorPagina") int registrosPorPagina) {
	//public CompletableFuture<List<Usuario>> obtenerUsuariosPaginado() {
		try {
			CompletableFuture<List<Usuario>> user = usuarioService.ejecutarObtenerUsuariosPaginado(pagina, registrosPorPagina);
			return user;
		} catch (Exception ex) {
			return CompletableFuture.completedFuture(Collections.emptyList());
		}
	}

	@GetMapping("/obtenerUsuarioId/{idusuario}")
	public CompletableFuture<ResponseEntity<Usuario>> obtenerUsuarioPorId(@PathVariable Long idusuario) {
		try {
			CompletableFuture<Usuario> user = usuarioService.ejecutarObtenerUsuarioPorId(idusuario);
			return user.thenApply(usuario -> ResponseEntity.ok(usuario));
		} catch (Exception ex) {
			String errorMessage = "Error al obtener el usuario por su ID: " + ex.getMessage();
			return CompletableFuture
					.completedFuture(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
		}
	}

	@PostMapping("/crearUsuario")
	public CompletableFuture<Long> crearUsuario(@RequestBody UsuarioRequest user) {
		try {
			String pwdEncriptado = user.getPassword();
			String passwordUsuario = passwordEncoder.encode(pwdEncriptado);

			Long rol = (user.getId_rol() != null && user.getId_rol() != 0) ? user.getId_rol() : 1L;

			Usuario usuario = new Usuario();
			usuario.setUsername(user.getUsername());
			usuario.setApe_usuario(user.getApe_usuario());
			usuario.setEmail(user.getEmail());
			usuario.setPassword(passwordUsuario);
			usuario.setPassword_confirm(passwordUsuario);
			usuario.setId_prefijo_telefono(user.getId_prefijo_telefono());
			usuario.setTelefono_usuario(user.getTelefono_usuario());
			usuario.setId_tipodocumento(user.getId_tipodocumento());
			usuario.setNum_documento(user.getNum_documento());
			usuario.setId_Depa(user.getId_Depa());
			usuario.setId_provincia(user.getId_provincia());
			usuario.setId_dist(user.getId_dist());
			usuario.setDirec_usuario(user.getDirec_usuario());
			usuario.setId_rol(rol);
			usuario.setId_especialidad(user.getId_especialidad());
			usuario.setFecha_registro(new Date());

			CompletableFuture<Long> resultIdUser = usuarioService.ejecutarCrearUsuario(usuario);

			CompletableFuture<Long> result = resultIdUser
					.thenComposeAsync(id -> (id > 0) ? usuarioService.ejecutarInsertUserRol(id, rol)
							: CompletableFuture.completedFuture(0L));
			return result;

		} catch (Exception ex) {
			return CompletableFuture.completedFuture(-1L);
		}
	}

	@PutMapping("/actualizarUsuario/{idUsuario}")
	public CompletableFuture<Boolean> actualizarUsuario(@PathVariable Long idUsuario,
			@RequestBody UsuarioRequest user) {
		try {

			String pwdEncriptado = user.getPassword();
			String passwordUsuario = passwordEncoder.encode(pwdEncriptado);

			Long rol = (user.getId_rol() != null && user.getId_rol() != 0) ? user.getId_rol() : 1L;

			Usuario usuario = new Usuario();
			usuario.setId_usuario(idUsuario);
			usuario.setUsername(user.getUsername());
			usuario.setApe_usuario(user.getApe_usuario());
			usuario.setEmail(user.getEmail());
			usuario.setPassword(passwordUsuario);
			usuario.setPassword_confirm(passwordUsuario);
			usuario.setId_prefijo_telefono(user.getId_prefijo_telefono());
			usuario.setTelefono_usuario(user.getTelefono_usuario());
			usuario.setId_tipodocumento(user.getId_tipodocumento());
			usuario.setNum_documento(user.getNum_documento());
			usuario.setId_Depa(user.getId_Depa());
			usuario.setId_provincia(user.getId_provincia());
			usuario.setId_dist(user.getId_dist());
			usuario.setDirec_usuario(user.getDirec_usuario());
			usuario.setId_rol(rol);
			usuario.setId_especialidad(user.getId_especialidad());

			CompletableFuture<Boolean> result = usuarioService.ejecutarActualizarUsuario(usuario);
			return result;

		} catch (Exception ex) {
			return CompletableFuture.completedFuture(false);
		}

	}

	@DeleteMapping("/eliminarUsuario/{idUsuario}")
	public CompletableFuture<Boolean> eliminarUsuario(@PathVariable Long idUsuario) {
		try {
			CompletableFuture<Boolean> result = usuarioService.ejecutarEliminarUsuario(idUsuario);
			return result;
		} catch (Exception ex) {
			return CompletableFuture.completedFuture(false);
		}
	}
	
	 @GetMapping("/obtenerUsuarioEmail/{email}")
	    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email) {
	        Usuario usuario = usuarioRepository.findByEmail(email);
	        if (usuario != null) {
	            return ResponseEntity.ok(usuario);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
