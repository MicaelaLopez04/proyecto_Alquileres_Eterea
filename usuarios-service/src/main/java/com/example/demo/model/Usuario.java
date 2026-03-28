package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String nombre;
	@Column
	private String apellido;
	@Column 
	private Long edad;
	@Column(unique= true, nullable = false)
	private String email;
	@Column
	private String password;
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(Long id, String nombre, String apellido, Long edad, String email, String password, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Long getEdad() {
		return edad;
	}


	public void setEdad(Long edad) {
		this.edad = edad;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Long getId() {
		return id;
	}
	
	
	
}
