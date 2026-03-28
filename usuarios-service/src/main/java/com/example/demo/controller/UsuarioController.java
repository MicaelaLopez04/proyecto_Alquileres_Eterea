package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return service.postUsuario(usuario);	
	}
	
	//eliminar usuario
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		service.deleteUsuario(id);
	}
	
	//buscar por id
	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return service.getUsuario(id);
	}
	
	//buscar todos lo usuarios
	@GetMapping
	public List<Usuario> getUsuarios(){
		return service.getUsuarios();
	}
	
	//actualizo usuario
	@PutMapping("/{id}")
	public Usuario updateUsuario(@PathVariable Long id,  @RequestBody Usuario usuario){
		return service.updateUsuario(id, usuario);
	}
	
	//buscar por email
	@GetMapping("/email")
	public Usuario getUusuarioByEmail(@RequestParam String email) {
		return service.getUsuarioByEmail(email);
	}
}
