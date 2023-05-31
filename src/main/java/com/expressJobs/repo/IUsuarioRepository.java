package com.expressJobs.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.expressJobs.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	
    @Procedure(name = "crearUsuario", outputParameterName = "exito")
    Boolean crearUsuario(
            @Param("usuario_nombre") String nombreUsuario,
            @Param("usuario_apellido") String apellidoUsuario,
            @Param("usuario_correo") String correoUsuario,
            @Param("usuario_contrasenia") String contraseniaUsuario,
            @Param("usuario_prefijo") String prefijoUsuario,
            @Param("usuario_telefono") String telefonoUsuario,
            @Param("usuario_idDocumento") String idDocumentoUsuario,
            @Param("usuario_documento") String documentoUsuario,
            @Param("usuario_idDepartamento") Integer idDepartamento,
            @Param("usuario_idProvincia") Integer idProvincia,
            @Param("usuario_idDistrito") Integer idDistrito,
            @Param("usuario_direccion") String  direccion,
            @Param("usuario_idRol") Integer idRol,
            @Param("usuario_idEspecialidad") Integer idEspecialidad
       
    );

    
    @Procedure(name = "actualizarUsuario", outputParameterName = "exito")
    Boolean actualizarUsuario(
            @Param("usuario_id") Long idUsuario,
            @Param("usuario_nombre") String nombreUsuario,
            @Param("usuario_apellido") String apellidoUsuario,
            @Param("usuario_correo") String correoUsuario,
            @Param("usuario_contrasenia") String contraseniaUsuario,
            @Param("usuario_prefijo") String prefijoUsuario,
            @Param("usuario_telefono") String telefonoUsuario,
            @Param("usuario_idDocumento") String idDocumentoUsuario,
            @Param("usuario_documento") String documentoUsuario,
            @Param("usuario_idDepartamento") Integer idDepartamento,
            @Param("usuario_idProvincia") Integer idProvincia,
            @Param("usuario_idDistrito") Integer idDistrito,
            @Param("usuario_direccion") String  direccion,
            @Param("usuario_idRol") Integer idRol,
            @Param("usuario_idEspecialidad") Integer idEspecialidad
    );

    @Procedure(name = "eliminarUsuario", outputParameterName = "exito")
    Boolean eliminarUsuario(
            @Param("usuario_id") Long id
    );

    @Query(nativeQuery = true, value = "CALL obtenerUsuarios()")
    List<Usuario> obtenerUsuarios();

    @Query(nativeQuery = true, value = "CALL obtenerUsuarioPorId(:usuario_id)")
    List<Usuario> obtenerUsuariosPorId(@Param("usuario_id") Long idUsuario);
}
