package com.tutosoftware.productmarket.service;

import java.util.List;

import com.tutosoftware.productmarket.entity.Pedido;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.VentaDetalleOnline;
import com.tutosoftware.productmarket.entity.VentaOnline;


public interface VentasOnlineService {
	
	public List<Producto> obtenerProductos(String nombreProducto);
	public long agregarPedido(Pedido pedido);
	public Pedido obtenerPedido(String llavePedido);
	public long agregarVentaDetalleOnline(VentaDetalleOnline ventaDetalleOnline);
    public long agregarVentaOnline(VentaOnline ventaOnline);

}
