package com.expressJobs.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seguridad")
public class SeguridadController {
	
	// Grabar
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map login(@RequestParam String email, @RequestParam String password) {
		Map<String, Object> map = new HashMap<>();
	    map.put("respuesta", "ok");
	    return map;
	}
}
