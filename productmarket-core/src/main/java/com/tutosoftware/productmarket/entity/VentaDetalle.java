package com.tutosoftware.productmarket.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventadetalle")
public class VentaDetalle implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	
	@Id
	private long idVenta;
	
	

	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="idproducto")
	private long idProducto;
	
	@Column(name="total")
	private Double total;
	
	
	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
