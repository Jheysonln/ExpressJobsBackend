package com.expressJobs.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.expressJobs.models.Departamento;
import com.expressJobs.models.Distrito;
import com.expressJobs.models.Menus;
import com.expressJobs.models.PrefTelefono;
import com.expressJobs.models.Provincia;
import com.expressJobs.models.Rol;
import com.expressJobs.models.SubMenus;
import com.expressJobs.models.Usuario;
import com.expressJobs.repo.IDepartamento;
import com.expressJobs.repo.IDistrito;
import com.expressJobs.repo.IMenuRepository;
import com.expressJobs.repo.IProvincia;
import com.expressJobs.repo.SubMenusRepository;

@Service
public class GenericService {

    private final IDepartamento depaRepository;
    private final IProvincia provRepository;
    private final IDistrito distRepository;
    private final IMenuRepository menuRepository;
    private final SubMenusRepository submenuRepository;
    
    public  GenericService(IDepartamento depaRepository, 
    		IProvincia provRepository, IDistrito distRepository,IMenuRepository menuRepository,
    		SubMenusRepository submenuRepository) {
        this.depaRepository = depaRepository;
        this.provRepository = provRepository;
        this.distRepository = distRepository;
        this.menuRepository = menuRepository;
        this.submenuRepository = submenuRepository;
    }
    
    public CompletableFuture<List<Departamento>> ejecutarObtenerDepartamento() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Departamento> departamento =  depaRepository.obtenerDepartamento();
                return departamento;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los despartamentos...", e);
            }
        });
    }
    
    
    public CompletableFuture<List<Provincia>> ejecutarObtenerProvincia(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Provincia> provincia =  provRepository.obtenerProvincia(id);
                return provincia;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener las provincias...", e);
            }
        });
    }
    
    public CompletableFuture<List<Distrito>> ejecutarObtenerDistrito(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Distrito> distrito = distRepository.obtenerDistrito(id);
                return distrito;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los distrito...", e);
            }
        });
    }
    
    public CompletableFuture<List<Menus>> ejecutarObtenerMenus(String rol) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Menus> menus = menuRepository.obtenerMenus(rol);
                for (Menus menu : menus) {
                    Long id_menu = menu.getId_menu();
                    List<SubMenus> submenus = submenuRepository.obtenerSubMenus(id_menu);
                    menu.setSubitem(submenus);
                }
                return menus;
            } catch (Exception e) {
                throw new RuntimeException("Error al obtener los distrito...", e);
            }
        });
    }
}
