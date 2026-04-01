package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	//crear usuario
	@PostMapping
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
		Usuario nuevo= service.postUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
	}
	
	//eliminar usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
		boolean eliminado= service.deleteUsuario(id);
		
		if(eliminado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//buscar por id	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
		Optional<Usuario> encontrado = service.getUsuario(id);
		return encontrado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	//buscar todos lo usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios(){
		List<Usuario> usuarios= service.getUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
	
	//actualizo usuario
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,  @RequestBody Usuario usuario){
		return service.updateUsuario(id, usuario).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	//buscar por email
	@GetMapping("/email")
	public ResponseEntity<Usuario> getUusuarioByEmail(@RequestParam String email) {
		Optional<Usuario> encontrado= service.getUsuarioByEmail(email);
		return encontrado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	
	
	
	
	
	

	
	

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
