package com.tutosoftware.productmarket.dao;

import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.Venta;
import com.tutosoftware.productmarket.entity.VentaDetalle;

public interface VentasCajaDAO {
	
public Producto obtenerProducto(String codigoBarras);
	
	public long agregarVenta(Venta venta);
	
	public Venta obtenerVenta(String llaveCaja);
	
	public long agregarVentaDetalle(VentaDetalle ventaDetalle);
	
	public Venta actualizarVenta(Venta venta);

}
