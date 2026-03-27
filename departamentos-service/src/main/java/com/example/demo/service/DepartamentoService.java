package com.example.demo.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repo;
	

	public Optional<Departamento> getDepartamentoById(Long id) {
		return repo.findById(id);
	}


	public boolean deleteDepartamento(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public Iterable<Departamento> getDepartamentos() {
		return repo.findAll();
	}

	public Optional<Departamento> updateDepartamento(Departamento departamento, Long id) {
		return repo.findById(id).map(dep->{
			dep.setNombre(departamento.getNombre());
			dep.setDireccion(departamento.getDireccion());
			dep.setDescripcion(departamento.getDescripcion());
			dep.setCapacidad(departamento.getCapacidad());
			dep.setPrecio(departamento.getPrecio());	
			
			return repo.save(dep);
		});
	}

	public Departamento postDepartamento(Departamento departamento) {
		return repo.save(departamento);
	}

}
