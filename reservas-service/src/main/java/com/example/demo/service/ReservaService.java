package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.EstadoReserva;
import com.example.demo.model.Reserva;
import com.example.demo.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ReservaRepository repo;
	
	//crear reserva (pendiente)
	public Reserva postReserva(Reserva reserva) {

	    // 🔥 VALIDAR USUARIO
	    try {
	        restTemplate.getForObject(
	            "http://localhost:8081/usuarios/" + reserva.getUsuarioId(),
	            Object.class
	        );
	    } catch (Exception e) {
	        return null;
	    }

	    // 🔥 VALIDAR DEPARTAMENTO
	    try {
	        restTemplate.getForObject(
	            "http://localhost:8080/departamentos/" + reserva.getDepartamentoId(),
	            Object.class
	        );
	    } catch (Exception e) {
	        return null;
	    }

	    // estado inicial
	    reserva.setEstado(EstadoReserva.Pendiente);

	    return repo.save(reserva);
	}
	
	//obtener reserva por id
	public Optional<Reserva> getReserva(Long id) {
		return repo.findById(id);
	}
	//obtener todas las reservas
	public Iterable<Reserva> getReservas(){
		return repo.findAll();
	}
	//eliminar reserva
	public boolean deleteReserva(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	//aceptar reserva
	public Reserva aceptarReserva(Long id) {
		Reserva r= repo.findById(id).orElse(null);
		if(r !=null) {
			
			if (r.getEstado() != EstadoReserva.Pendiente) {
			    return null;
			}
			r.setEstado(EstadoReserva.Aceptada);
			return repo.save(r);
		}
		return null;
	}
	
	//rechazar reserva
	public Reserva rechazarReserva(Long id) {
		Reserva r= repo.findById(id).orElse(null);
		
		if(r !=null) {
			if (r.getEstado() != EstadoReserva.Pendiente) {
			    return null;
			}
			r.setEstado(EstadoReserva.Rechazada);
			return repo.save(r);
		}
		return null;
	}
}
