package com.tutosoftware.productmarket.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Orden {
	

	
	 @NotBlank
	private String nombre;

	 @NotBlank
	private String apellidoPaterno;
		
	 
	private String apellidoMaterno;
		
	 @NotBlank		
	private String calle;
		
	 
	private String entrecalles;
		
	 @NotBlank	
	private String colonia;
		
	 @NotBlank	
	private String municipio;
		
	@NotBlank	
	private String estado;
		
	@NotBlank		
	private String pais;
		
	@NotBlank	
	private String codigoPostal;
		
	@NotBlank	                
	private String telefono;
		
	@Email
	@NotBlank		
	private String email;
	 
	 public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEntrecalles() {
		return entrecalles;
	}

	public void setEntrecalles(String entrecalles) {
		this.entrecalles = entrecalles;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
