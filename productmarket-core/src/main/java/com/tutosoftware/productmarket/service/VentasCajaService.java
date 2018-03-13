package com.tutosoftware.productmarket.service;

import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.Venta;
import com.tutosoftware.productmarket.entity.VentaDetalle;

public interface VentasCajaService {
	
	public Producto obtenerProducto(String codigoBaras);
	public long agregarVenta(Venta venta);
	public Venta obtenerVenta(String llaveCaja);
	public long agregarVentaDetalle(VentaDetalle ventaDetalle);
    public Venta actualizarVenta(Venta venta);

}
