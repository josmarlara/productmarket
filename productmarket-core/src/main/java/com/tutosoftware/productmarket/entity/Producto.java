package com.tutosoftware.productmarket.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;
	
	@Column(name="idreferencia")
	private Integer idReferencia;
	
	@Column(name="nombreproducto")
	private String nombreProducto;
	
	@Column(name="codigobarras")
	private String codigoBarras;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="precio")
	private Double precio;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="imagen")
	private byte[]  imagen;
	
	@Column(name="tipoimagen")
	private String tipoImagen;
	
	@Column(name="unidad")
	private String unidad;

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdReferencia() {
		return idReferencia;
	}

	public void setIdReferencia(Integer idReferencia) {
		this.idReferencia = idReferencia;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
