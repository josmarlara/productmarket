package com.tutosoftware.productmarket.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutosoftware.productmarket.dao.VentasOnlineDAO;
import com.tutosoftware.productmarket.entity.Pedido;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.VentaDetalleOnline;
import com.tutosoftware.productmarket.entity.VentaOnline;
import com.tutosoftware.productmarket.util.HibernateUtil;



@Repository
public class VentasOnlineDAOImpl implements VentasOnlineDAO {
	
	
	@Autowired
	  private HibernateUtil hibernateUtil;
	
	
	VentasOnlineDAOImpl(){
		
	}
	
	
	
	

	@Override
	public List<Producto> obtenerProductos(String nombreProducto) {
		String query = "FROM Producto p WHERE p.nombreProducto like '%"+ nombreProducto +"%' and p.cantidad > 0 ";
		return hibernateUtil.fetchAll(query);
	}

	@Override
	public long agregarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(pedido);
	}

	@Override
	public Pedido obtenerPedido(String llavePedido) {
      String hql ="from Pedido as p where p.llave = '"+llavePedido+"'";
	  Pedido pedidoResult = hibernateUtil.fetchByUniqueResult(hql);
		return pedidoResult;
	}

	@Override
	public long agregarVentaDetalleOnline(VentaDetalleOnline ventaDetalleOnline) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(ventaDetalleOnline);
	}

	@Override
	public long agregarVentaOnline(VentaOnline ventaOnline) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(ventaOnline);
	}

}
