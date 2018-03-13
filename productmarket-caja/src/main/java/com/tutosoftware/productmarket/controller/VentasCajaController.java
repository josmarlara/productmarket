package com.tutosoftware.productmarket.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutosoftware.productmarket.entity.Item;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.Venta;
import com.tutosoftware.productmarket.entity.VentaDetalle;
import com.tutosoftware.productmarket.service.ProductoService;
import com.tutosoftware.productmarket.service.VentasCajaService;
import com.tutosoftware.productmarket.util.Ticket;



@Controller
public class VentasCajaController {
	
	@Autowired
	VentasCajaService ventasCajaService;
	
	@Autowired
	private ProductoService productoService;
	
	
	@RequestMapping(value = {"/"})
	public ModelAndView agregarProducto() {
		
		return new ModelAndView("caja");
	}
	
	
	
	
	
	
	
	@SuppressWarnings (value="unchecked")
	@RequestMapping(value ="/agregarProducto")
	 public ModelAndView  ventas(@RequestParam("codigoBarras") String codigoBarras,ModelMap model,HttpSession session){
	    System.out.println("*********Probando**********");
		Producto producto = null;
		
		if(codigoBarras.trim().length() != 0 ){
		
		producto= ventasCajaService.obtenerProducto(codigoBarras);
		
		if(producto != null){
			
		
		
		
		
		long id= producto.getIdProducto();
		
		
		if(session.getAttribute("cart") == null){
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(producto,1));
			session.setAttribute("cart",cart);
			
			
		}else{
			List<Item> cart = (List<Item>)session.getAttribute("cart");
			int index = siExisteProductoCompra(id,session);
			if(index == -1)
			  cart.add(new Item(producto,1));
			else{
				int cantidad = cart.get(index).getCantidad()+1;
			    cart.get(index).setCantidad(cantidad);
			}	
			
			session.setAttribute("cart",cart);
		}	
		
			
		}else{
			model.put("vacio","Introduce el producto al inventario");
			return new ModelAndView("caja");
			
		}
		
		
		
		
		return new ModelAndView("caja");
		
		}else{
			model.put("vacio","Introduce el código de barras");
			return new ModelAndView("caja");
		}
		
	}
	
	
	
	
	@SuppressWarnings (value="unchecked")
	private int siExisteProductoCompra(long id,HttpSession session){
		
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		for(int i=0;i < cart.size();i++)
			if(cart.get(i).getProducto().getIdProducto() == id)
				return i;
		  	
		
		return -1;
		
	}
	

	
	@RequestMapping("/cancelarCompra")
	public ModelAndView cancelar(HttpSession session){
		
		
		session.removeAttribute("cart");
		
		return new ModelAndView("caja");
		
		
	}
	
	
	
	
	
	
	@SuppressWarnings (value="unchecked")
	@RequestMapping("/borrarProducto")
	public ModelAndView eliminarCarritoCompra(@RequestParam long idProducto,HttpSession session) {
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		int index = siExisteProductoCompra(idProducto,session);
		cart.remove(index);
		session.setAttribute("cart",cart);
		return new ModelAndView("caja");
		
	}
	
	
	
	
	@RequestMapping("/pagar")
	public ModelAndView pagarProductos(HttpSession session){
		
		String llaveCaja = UUID.randomUUID().toString();
		agregarVentaBD(llaveCaja);
		Venta venta = ventasCajaService.obtenerVenta(llaveCaja);
		
		agregarVentaDetalleBD(venta,session);
		
		imprimirTicketinicio(venta,session);
		session.removeAttribute("cart");
		
		return new ModelAndView("caja");
		
		
	}
	
	
	private void agregarVentaBD(String llaveCaja){
		
		Venta venta = new Venta();
		double total=0;
		
		venta.setLlaveVenta(llaveCaja);
		venta.setTotal(total);
		venta.setFecha(new Date());
		
		ventasCajaService.agregarVenta(venta);
		
	}

	@SuppressWarnings (value="unchecked")
	private void agregarVentaDetalleBD(Venta venta,HttpSession session){
		
		VentaDetalle ventaDetalle = new VentaDetalle();
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		Producto productoActualizarInventario = new Producto();
		double totalVentas=0;
		for(int i=0;i < cart.size();i++){
			ventaDetalle.setIdVenta(venta.getIdVenta());
			ventaDetalle.setCantidad(cart.get(i).getCantidad());
			ventaDetalle.setIdProducto(cart.get(i).getProducto().getIdProducto());
			ventaDetalle.setTotal(cart.get(i).getProducto().getPrecio() * cart.get(i).getCantidad());
			ventasCajaService.agregarVentaDetalle(ventaDetalle);
			productoActualizarInventario = cart.get(i).getProducto();
			productoActualizarInventario.setCantidad(cart.get(i).getProducto().getCantidad()-cart.get(i).getCantidad());
			productoService.actualizarProducto(productoActualizarInventario);
			totalVentas += cart.get(i).getProducto().getPrecio() * cart.get(i).getCantidad();
			
		}
		
		venta.setTotal(totalVentas);
		
		ventasCajaService.actualizarVenta(venta);
		
		
	}
	
	@SuppressWarnings (value="unchecked")
	private void imprimirTicketinicio(Venta venta,HttpSession session){
		String idVenta =String.valueOf(venta.getIdVenta());
		String fecha = convertirFechaString(venta.getFecha());
		String productos="";
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		String cantidad ="";
		String precio ="";
		String total="";
		double totalVenta=0;
		
		for(int i=0;i < cart.size();i++){
			cantidad = String.valueOf(cart.get(i).getCantidad());
			precio = String.valueOf(cart.get(i).getProducto().getPrecio());
			total=String.valueOf(cart.get(i).getProducto().getPrecio() * cart.get(i).getCantidad());
			productos += cantidad+" "+cart.get(i).getProducto().getNombreProducto()+" "+precio+" "+
			total+"\n";
			
			totalVenta += cart.get(i).getProducto().getPrecio() * cart.get(i).getCantidad();
		}
		
		String totalVentas=String.valueOf(totalVenta);
		
		Ticket ticket = new Ticket("1",idVenta,"JOSE MARTIN",fecha,productos,totalVentas);
		
		
		ticket.print();
	}
	
	    public String convertirFechaString(Date date){
		
		   return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);	
		}

}
