package com.tutosoftware.productmarket.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutosoftware.productmarket.dao.ProductoDAO;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.util.HibernateUtil;



@Repository
public class ProductoDAOImpl implements ProductoDAO {
	
	
	
	@Autowired
	  private HibernateUtil hibernateUtil;
	 
	 public ProductoDAOImpl(){
		 
	 }
	
	

	@Override
	public long agregarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(producto);
	}

	@Override
	public List<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchAll(Producto.class);
	}

	@Override
	public List<Producto> obtenerProductos(String nombreProducto) {
		// TODO Auto-generated method stub
		String query = "FROM Producto p WHERE p.nombreProducto like '%"+ nombreProducto +"%'";
		return hibernateUtil.fetchAll(query);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return hibernateUtil.update(producto);
	}

	@Override
	public Producto obtenerProducto(long id) {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchById(id,Producto.class);
	}

	@Override
	public void eliminarProducto(long id) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		producto.setIdProducto(id);
		hibernateUtil.delete(producto);

	}

}
