package com.tutosoftware.productmarket.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class Venta implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVenta;
	
	

	@Column(name="llaveventa")
	private String llaveVenta;
	
	@Column(name="total")
	private Double total;
	
	@Column(name="fecha")
	private Date fecha;
	
	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public String getLlaveVenta() {
		return llaveVenta;
	}

	public void setLlaveVenta(String llaveVenta) {
		this.llaveVenta = llaveVenta;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
