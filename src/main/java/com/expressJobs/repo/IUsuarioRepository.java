package com.expressJobs.repo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.result.Output;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Rol;
import com.expressJobs.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	
	@Procedure(name = "crearUsuario", outputParameterName = "exito")
	Long crearUsuario(
	        @Param("pNom_usuario") String username,
	        @Param("pApe_usuario") String ape_usuario,
	        @Param("pCorreo_usuario") String email,
	        @Param("pPassword_usuario") String password,
	        @Param("pPasswordConfirm_usuario") String password_confirm,
	        @Param("pId_prefijo_telefono") Integer id_prefijo_telefono,
	        @Param("pTelefono_usuario") String telefono_usuario,
	        @Param("pId_tipodocumento") Integer id_tipodocumento,
	        @Param("pNum_documento") String num_documento,
	        @Param("pId_Depa") Integer id_Depa,
	        @Param("pId_provincia") Integer id_provincia,
	        @Param("pId_dist") Integer id_dist,
	        @Param("pDirec_usuario") String direc_usuario,
	        @Param("pId_rol") Long id_rol,
	        @Param("pId_especialidad") Integer id_especialidad,
	        @Param("pFecha_registro") Date fecha_registro
	);
    
    @Procedure(name = "crearUsuarioRol", outputParameterName = "exito")
    Long crearUsuarioRol(
            @Param("pId_usuario") Long pId_usuario,
            @Param("pId_rol") Long pId_rol
    );
    
    @Procedure(name = "actualizarUsuario", outputParameterName = "exito")
    Boolean actualizarUsuario(
            @Param("pId_usuario") Long id_usuario,
            @Param("pNom_usuario") String username,
            @Param("pApe_usuario") String ape_usuario,
            @Param("pCorreo_usuario") String email,
            @Param("pPassword_usuario") String password,
            @Param("pPasswordConfirm_usuario") String password_confirm,
            @Param("pId_prefijo_telefono") int id_prefijo_telefono,
            @Param("pTelefono_usuario") String telefono_usuario,
            @Param("pId_tipodocumento") int id_tipodocumento,
            @Param("pNum_documento") String num_documento,
            @Param("pId_Depa") int id_Depa,
            @Param("pId_provincia") int id_provincia,
            @Param("pId_dist") int id_dist,
            @Param("pDirec_usuario") String  direc_usuario,
            @Param("pId_rol") Long id_rol,
            @Param("pId_especialidad") int id_especialidad
    );

    @Procedure(name = "eliminarUsuario", outputParameterName = "exito")
    Boolean eliminarUsuario(
            @Param("pId_usuario") Long id_usuario
    );

    @Query(nativeQuery = true, value = "CALL obtenerUsuarioPorId(:pId_usuario)")
    List<Usuario> obtenerUsuariosPorId(@Param("pId_usuario") Long id_usuario);
    

    /*@Query(nativeQuery = true, value = "CALL obtenerUsuariosPaginado(:p_pageNumber, :p_pageSize)")
    List<Usuario> obtenerUsuariosPaginado(@Param("p_pageNumber") int pagina, @Param("p_pageSize") int registrosPorPagina);*/
    
    @Procedure(name = "obtenerUsuariosPaginado")
    List<Usuario> obtenerUsuariosPaginado(@Param("p_pageNumber") int p_pageNumber, @Param("p_pageSize") int p_pageSize);
    
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);

}
