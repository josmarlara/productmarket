package com.tutosoftware.productmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutosoftware.productmarket.dao.VentasOnlineDAO;
import com.tutosoftware.productmarket.entity.Pedido;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.VentaDetalleOnline;
import com.tutosoftware.productmarket.entity.VentaOnline;
import com.tutosoftware.productmarket.service.VentasOnlineService;



@Service
@Transactional
public class VentasOnlineServiceImpl implements VentasOnlineService {
	
	@Autowired
	 private VentasOnlineDAO ventasOnlineDAO;
	
	
	public VentasOnlineServiceImpl(){
		
	}

	@Override
	public List<Producto> obtenerProductos(String nombreProducto) {
		// TODO Auto-generated method stub
		return ventasOnlineDAO.obtenerProductos(nombreProducto);
	}

	@Override
	public long agregarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return ventasOnlineDAO.agregarPedido(pedido);
	}

	@Override
	public Pedido obtenerPedido(String llavePedido) {
		// TODO Auto-generated method stub
		return ventasOnlineDAO.obtenerPedido(llavePedido);
	}

	@Override
	public long agregarVentaDetalleOnline(VentaDetalleOnline ventaDetalleOnline) {
		// TODO Auto-generated method stub
		return ventasOnlineDAO.agregarVentaDetalleOnline(ventaDetalleOnline);
	}

	@Override
	public long agregarVentaOnline(VentaOnline ventaOnline) {
		// TODO Auto-generated method stub
		return ventasOnlineDAO.agregarVentaOnline(ventaOnline);
	}

}
