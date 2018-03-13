package com.tutosoftware.productmarket.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ventadetalleonline")
public class VentaDetalleOnline implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	private long idPedido;
	
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="idproducto")
	private long idProducto;
	
	@Column(name="costoProducto")
	private Double costoProducto;

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public Double getCostoProducto() {
		return costoProducto;
	}

	public void setCostoProducto(Double costoProducto) {
		this.costoProducto = costoProducto;
	}

}
