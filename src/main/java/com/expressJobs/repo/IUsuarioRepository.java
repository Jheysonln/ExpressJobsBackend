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
            @Param("pNom_usuario") String nom_usuario,
            @Param("pApe_usuario") String ape_usuario,
            @Param("pCorreo_usuario") String correo_usuario,
            @Param("pPassword_usuario") String password_usuario,
            @Param("pId_prefijo_telefono") String id_prefijo_telefono,
            @Param("pTelefono_usuario") String telefono_usuario,
            @Param("pId_tipodocumento") String id_tipodocumento,
            @Param("pNum_documento") String num_documento,
            @Param("pId_Depa") int id_Depa,
            @Param("pId_provincia") int id_provincia,
            @Param("pId_dist") int id_dist,
            @Param("pDirec_usuario") String  direc_usuario,
            @Param("pId_rol") int id_rol,
            @Param("pId_especialidad") int id_especialidad
       
    );

    
    @Procedure(name = "actualizarUsuario", outputParameterName = "exito")
    Boolean actualizarUsuario(
            @Param("pId_usuario") Long id_usuario,
            @Param("pNom_usuario") String nom_usuario,
            @Param("pApe_usuario") String ape_usuario,
            @Param("pCorreo_usuario") String correo_usuario,
            @Param("pPassword_usuario") String password_usuario,
            @Param("pId_prefijo_telefono") String id_prefijo_telefono,
            @Param("pTelefono_usuario") String telefono_usuario,
            @Param("pId_tipodocumento") String id_tipodocumento,
            @Param("pNum_documento") String num_documento,
            @Param("pId_Depa") int id_Depa,
            @Param("pId_provincia") int id_provincia,
            @Param("pId_dist") int id_dist,
            @Param("pDirec_usuario") String  direc_usuario,
            @Param("pId_rol") int id_rol,
            @Param("pId_especialidad") int id_especialidad
    );

    @Procedure(name = "eliminarUsuario", outputParameterName = "exito")
    Boolean eliminarUsuario(
            @Param("pId_usuario") Long id
    );

    @Query(nativeQuery = true, value = "CALL obtenerUsuarios()")
    List<Usuario> obtenerUsuarios();

    @Query(nativeQuery = true, value = "CALL obtenerUsuarioPorId(:pId_usuario)")
    List<Usuario> obtenerUsuariosPorId(@Param("pId_usuario") Long id_usuario);
}
