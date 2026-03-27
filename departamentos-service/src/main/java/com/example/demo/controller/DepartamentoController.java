package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Departamento;
import com.example.demo.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin
public class DepartamentoController {

	@Autowired 
	private DepartamentoService service;
	

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
		Optional<Departamento> encontrado = service.getDepartamentoById(id);
		return encontrado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	//crea
	@PostMapping
	public ResponseEntity<Departamento> postDepartamento(@RequestBody Departamento departamento){
		Departamento nuevo = service.postDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
	}
	
	//elimina
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartamento(@PathVariable Long id) {
		boolean eliminado= service.deleteDepartamento(id);
		if(eliminado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//obtener todos los departamentos
	@GetMapping
	public ResponseEntity<Iterable<Departamento>> getDepartamentos() {
		Iterable<Departamento> it= service.getDepartamentos();
		return ResponseEntity.ok(it);
	}
	
	//actualiza departamento
	@PutMapping("/{id}")
	public ResponseEntity<Departamento> putDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
		return service.updateDepartamento(departamento, id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	

	
	
	
}
