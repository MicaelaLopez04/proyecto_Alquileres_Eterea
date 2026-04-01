package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	//crear usuario
	public Usuario postUsuario(Usuario usuario) {
		return repo.save(usuario);
	}
	
	//eliminar usuario
	public boolean deleteUsuario(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
			
		return false;
	}
	//buscar por id 
	public Optional<Usuario> getUsuario(Long id) {
		return repo.findById(id);
	}
	
	//listar todos los usuarios
	public List<Usuario> getUsuarios(){
		return repo.findAll();	
	}
	
	//actualizar usuario
	public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {

	    return repo.findById(id).map(u -> {
	        u.setApellido(usuario.getApellido());
	        u.setEdad(usuario.getEdad());
	        u.setEmail(usuario.getEmail());
	        u.setNombre(usuario.getNombre());
	        u.setPassword(usuario.getPassword());
	        u.setRol(usuario.getRol());

	        return repo.save(u);
	    });
	}
	
	//buscar por email
	public Optional<Usuario> getUsuarioByEmail(String email) {
		return repo.findByEmail(email);
	}
}
