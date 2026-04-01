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

import com.example.demo.model.Reserva;
import com.example.demo.service.ReservaService;

@RestController
@RequestMapping("/reservas")
@CrossOrigin
public class ReservaController {

	@Autowired
	private ReservaService service;
	
	//crear
	@PostMapping
	public ResponseEntity<Reserva> postReserva(@RequestBody Reserva reserva) {
		Reserva nueva= service.postReserva(reserva);
		if(nueva !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
		}else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	//buscar reserva por id
	@GetMapping("/{id}")
	public ResponseEntity<Reserva> getReserva(@PathVariable Long id){
		Optional<Reserva> encontrado= service.getReserva(id);
		return encontrado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());	
	}
	
	//listar todas las reservas
	@GetMapping
	public ResponseEntity<Iterable<Reserva>> getReservas(){
		Iterable<Reserva> it = service.getReservas();
		return ResponseEntity.ok(it);
	}
	
	//eliminar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReserva(@PathVariable Long id) {
		boolean eliminado= service.deleteReserva(id);
		if(eliminado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//aceptar reserva
	@PutMapping("/{id}/aceptar")
	public ResponseEntity<Reserva> aceptarReserva(@PathVariable Long id){
		 Reserva reserva = service.aceptarReserva(id);

		    if (reserva != null) {
		        return ResponseEntity.ok(reserva);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	
	//rechazar reserva
	@PutMapping("/{id}/rechazar")
	public ResponseEntity<Reserva> rechazarReserva(@PathVariable Long id){
		 Reserva reserva = service.rechazarReserva(id);

		    if (reserva != null) {
		        return ResponseEntity.ok(reserva);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	
}
