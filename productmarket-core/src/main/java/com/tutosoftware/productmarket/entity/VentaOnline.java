package com.tutosoftware.productmarket.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventaonline")
public class VentaOnline implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	
	@Id
	private long idpedido;
	
	
	@Column(name="total")
	private Double total;


	public long getIdpedido() {
		return idpedido;
	}


	public void setIdpedido(long idpedido) {
		this.idpedido = idpedido;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}
	

}
