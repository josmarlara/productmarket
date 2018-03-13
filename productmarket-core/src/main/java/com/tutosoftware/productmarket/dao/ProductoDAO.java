package com.tutosoftware.productmarket.dao;

import java.util.List;

import com.tutosoftware.productmarket.entity.Producto;



public interface ProductoDAO {
	
	public long agregarProducto(Producto producto);
	public List<Producto> obtenerProductos();
	public List<Producto> obtenerProductos(String nombreProducto);
	public Producto actualizarProducto(Producto producto);
	public Producto obtenerProducto(long id);
	public void eliminarProducto(long id);

}
