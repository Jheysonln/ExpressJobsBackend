package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.Menus;

@Repository
public interface IMenuRepository extends JpaRepository<Menus, Long> {
	@Query(nativeQuery = true, value = "CALL obtenerMenus(:pDes_rol)")
    List<Menus> obtenerMenus(@Param("pDes_rol") String des_rol);
}