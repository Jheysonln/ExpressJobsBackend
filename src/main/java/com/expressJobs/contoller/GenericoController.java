package com.expressJobs.contoller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expressJobs.models.Departamento;
import com.expressJobs.models.Distrito;
import com.expressJobs.models.Generico;
import com.expressJobs.models.Menus;
import com.expressJobs.models.PrefTelefono;
import com.expressJobs.models.Producto;
import com.expressJobs.models.Provincia;
import com.expressJobs.request.DashboardRequest;
import com.expressJobs.request.GenericoRequest;
import com.expressJobs.services.GenericoService;

@RestController
@RequestMapping("/api/generic")
public class GenericoController {
	
    private final GenericoService genericoService;

    public GenericoController(GenericoService genericoService) {
        this.genericoService = genericoService;
    }
	
    
    
    @GetMapping("/obtenerDepartamentos")
    @ResponseBody
    public CompletableFuture<List<Departamento>> obtenerDepartamento() {
        return genericoService.ejecutarObtenerDepartamento()
                .exceptionally(ex -> {
                    // Manejar la excepción
                    // Por ejemplo, registrar el error o lanzar una excepción personalizada
                    return Collections.emptyList(); // Devolver una lista vacía en caso de error
                });
    }

    
    @GetMapping("/obtenerProvincia/{id}")
    @ResponseBody
    public CompletableFuture<List<Provincia>> obtenerProvincia(@PathVariable Integer id) {
    	 return genericoService.ejecutarObtenerProvincia(id)
                 .exceptionally(ex -> {
                     // Manejar la excepción
                     // Por ejemplo, registrar el error o lanzar una excepción personalizada
                     return Collections.emptyList(); // Devolver una lista vacía en caso de error
                 });
    }
    
    @GetMapping("/obtenerDistrito/{id}")
    @ResponseBody
    public CompletableFuture<List<Distrito>> obtenerDistrito(@PathVariable Integer id) {
    	 return genericoService.ejecutarObtenerDistrito(id)
                 .exceptionally(ex -> {
                     // Manejar la excepción
                     // Por ejemplo, registrar el error o lanzar una excepción personalizada
                     return Collections.emptyList(); // Devolver una lista vacía en caso de error
                 });
    }
    



    @PostMapping("/crearGenerico")
    public CompletableFuture<Boolean> crearGenerico(@RequestBody GenericoRequest request) {
        String cod_tabla_gnr = request.getCod_tabla();
        String cod_fila_gnr = request.getCod_fila();
        String  desc_corta_gnr = request.getDesc_corta();
        String  desc_larga_gnr = request.getDesc_larga();
        String  valor_texto_1_gnr = request.getValor_texto_1();
        String  valor_texto_2_gnr = request.getValor_texto_2();
        String  valor_texto_3_gnr = request.getValor_texto_3();
        String  valor_texto_4_gnr = request.getValor_texto_4();
        String estado_generico_gnr = request.getEstado_generico();
        Date fecha_registro_generico_gnr = request.getFecha_registro_generico();


        
        
        return genericoService.ejecutarCrearGenerico(cod_tabla_gnr ,
        		cod_fila_gnr ,
        		desc_corta_gnr ,
        		desc_larga_gnr ,
        		valor_texto_1_gnr ,
        		valor_texto_2_gnr ,
        		valor_texto_3_gnr ,
        		valor_texto_4_gnr ,
        		estado_generico_gnr ,
        		fecha_registro_generico_gnr)
                .exceptionally(ex -> {
                    return false; 
                });
    }
	
    @GetMapping("/obtenerGenerico")
    @ResponseBody
    public CompletableFuture<List<Generico>> obtenerGenerico() {
        return genericoService.ejecutarObtenerGenerico()
                .exceptionally(ex -> {
                    return Collections.emptyList(); 
                });
    }
    
    @GetMapping("/obtenerGenericoId/{id}")
    public CompletableFuture<ResponseEntity<Generico>> obtenerGenericoPorId(@PathVariable Long id_generico) {
        return genericoService.ejecutarObtenerGenericoPorId(id_generico)
                .thenApply(generico -> ResponseEntity.ok(generico))
                .exceptionally(ex -> {
                    String errorMessage = "Error al obtener el generico por su ID: " + ex.getMessage();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }
    
    @DeleteMapping("/eliminarGenerico/{id}")
    public CompletableFuture<Boolean> eliminarGenerico(@PathVariable Long id_generico) {
        return genericoService.ejecutarEliminarGenerico(id_generico)
                .exceptionally(ex -> {

                    return false; 
                });
    }
    
    @PostMapping("/obtenerDashboard")
    public CompletableFuture<List<Menus>> obtenerDistrito(@RequestBody DashboardRequest requestBody) {
        try {
            String des_rol = requestBody.getDes_rol();
            CompletableFuture<List<Menus>> menus = genericoService.ejecutarObtenerMenus(des_rol);
            return menus;
        } catch (Exception ex) {
            return CompletableFuture.completedFuture(Collections.emptyList());
        }
    }
    
    
    
    
    
    
    
    
    
    
}
