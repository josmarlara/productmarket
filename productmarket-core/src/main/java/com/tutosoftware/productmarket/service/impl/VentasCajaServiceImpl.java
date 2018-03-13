package com.tutosoftware.productmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutosoftware.productmarket.dao.VentasCajaDAO;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.Venta;
import com.tutosoftware.productmarket.entity.VentaDetalle;
import com.tutosoftware.productmarket.service.VentasCajaService;


@Service
@Transactional
public class VentasCajaServiceImpl implements VentasCajaService {
	
	
	@Autowired
	private VentasCajaDAO ventasCajaDAO;
	
	public VentasCajaServiceImpl(){
		
	}

	@Override
	public Producto obtenerProducto(String codigoBaras) {
		// TODO Auto-generated method stub
		return ventasCajaDAO.obtenerProducto(codigoBaras);
	}

	@Override
	public long agregarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return ventasCajaDAO.agregarVenta(venta);
	}

	@Override
	public Venta obtenerVenta(String llaveCaja) {
		// TODO Auto-generated method stub
		return ventasCajaDAO.obtenerVenta(llaveCaja);
	}

	@Override
	public long agregarVentaDetalle(VentaDetalle ventaDetalle) {
		// TODO Auto-generated method stub
		return ventasCajaDAO.agregarVentaDetalle(ventaDetalle);
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return ventasCajaDAO.actualizarVenta(venta);
	}

}
