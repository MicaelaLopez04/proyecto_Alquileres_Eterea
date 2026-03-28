package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDate fechaInicio;
	@Column
	private LocalDate fechaFin;
	
	@Column
	private Long cantidadPersonas;
	@Column(length= 500)
	private String descripcion;
	@Enumerated(EnumType.STRING)
	private EstadoReserva estado;
	
	private Long usuarioId; 
	private Long departamentoId;
	
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reserva(Long id, LocalDate fechaInicio, LocalDate fechaFin, Long cantidadPersonas, String descripcion,
			EstadoReserva estado, Long usuarioId, Long departamentoId) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadPersonas = cantidadPersonas;
		this.descripcion = descripcion;
		this.estado = estado;
		this.usuarioId = usuarioId;
		this.departamentoId = departamentoId;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Long getCantidadPersonas() {
		return cantidadPersonas;
	}


	public void setCantidadPersonas(Long cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public EstadoReserva getEstado() {
		return estado;
	}


	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}


	public Long getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}


	public Long getDepartamentoId() {
		return departamentoId;
	}


	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}


	public Long getId() {
		return id;
	}
	
	
	
}
