package com.tutosoftware.productmarket.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutosoftware.productmarket.dao.VentasCajaDAO;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.Venta;
import com.tutosoftware.productmarket.entity.VentaDetalle;
import com.tutosoftware.productmarket.util.HibernateUtil;

@Repository
public class VentasCajaDAOImpl implements VentasCajaDAO {
	
	@Autowired
	  private HibernateUtil hibernateUtil;
	
	
	VentasCajaDAOImpl(){
		
	}

	@Override
	public Producto obtenerProducto(String codigoBarras) {
		// TODO Auto-generated method stub
		String hql ="from Producto as p where p.codigoBarras = '"+codigoBarras+"'";
		Producto productoResult = hibernateUtil.fetchByUniqueResult(hql);
		return productoResult;
	}

	@Override
	public long agregarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(venta);
	}

	@Override
	public Venta obtenerVenta(String llaveCaja) {
		// TODO Auto-generated method stub
        String hql ="from Venta as p where p.llaveVenta = '"+llaveCaja+"'";
		Venta ventaResult = hibernateUtil.fetchByUniqueResult(hql);
		return ventaResult;
	}

	@Override
	public long agregarVentaDetalle(VentaDetalle ventaDetalle) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(ventaDetalle);
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return hibernateUtil.update(venta);
	}

}
