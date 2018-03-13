package com.tutosoftware.productmarket.entity;

import java.io.Serializable;

import com.tutosoftware.productmarket.entity.Producto;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Producto producto = new Producto();
	private int cantidad;
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Item(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Item() {
		super();
	}

}
