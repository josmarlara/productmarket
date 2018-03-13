package com.tutosoftware.productmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutosoftware.productmarket.dao.ProductoDAO;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.service.ProductoService;



@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
	
	
	@Autowired
	 private ProductoDAO productoDAO;
	
	
	 public ProductoServiceImpl(){
		 
	 }

	@Override
	public long agregarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoDAO.agregarProducto(producto);
	}

	@Override
	public List<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return productoDAO.obtenerProductos();
	}

	@Override
	public List<Producto> obtenerProductos(String nombreProducto) {
		// TODO Auto-generated method stub
		return productoDAO.obtenerProductos(nombreProducto);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoDAO.actualizarProducto(producto);
	}

	@Override
	public Producto obtenerProducto(long id) {
		// TODO Auto-generated method stub
		return productoDAO.obtenerProducto(id);
	}

	@Override
	public void eliminarProducto(long id) {
		// TODO Auto-generated method stub
		productoDAO.eliminarProducto(id);

	}

}
