package com.expressJobs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expressJobs.models.SubMenus;

@Repository
public interface SubMenusRepository extends JpaRepository<SubMenus, Long> {
	@Query(nativeQuery = true, value = "CALL obtenerSubMenus(:pId_menu)")
    List<SubMenus> obtenerSubMenus(@Param("pId_menu") Long id_menu);
}