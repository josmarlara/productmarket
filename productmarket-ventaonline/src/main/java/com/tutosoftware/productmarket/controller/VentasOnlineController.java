package com.tutosoftware.productmarket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutosoftware.productmarket.entity.Item;
import com.tutosoftware.productmarket.entity.Orden;
import com.tutosoftware.productmarket.entity.Pedido;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.entity.VentaDetalleOnline;
import com.tutosoftware.productmarket.entity.VentaOnline;
import com.tutosoftware.productmarket.service.ProductoService;
import com.tutosoftware.productmarket.service.VentasOnlineService;

@Controller
public class VentasOnlineController {
	
	
	@Autowired
	private VentasOnlineService ventasOnlineService;
	
	
	@Autowired
	private ProductoService productoService;
	
	
	
	
	public VentasOnlineController(){
		
		
	}

	
	
	@RequestMapping(value = {"/buscarProductos", "/"})
	public ModelAndView buscarProducto() {
		
		return new ModelAndView("buscar");
	}
	
	
	@RequestMapping("/buscarProducto")
	public ModelAndView mostrarProducto(@RequestParam("nombreProducto") String nombreProducto,ModelMap model) {
		
		if(nombreProducto.trim().length() != 0 ){
			ModelAndView modelo = new ModelAndView("mostrarProducto");
			List<Producto> productoList = ventasOnlineService.obtenerProductos(nombreProducto);
			
			modelo.addObject("productoList",productoList);
			
			return modelo;
			
		}else{
			model.put("vacio","Escribe el nombre del producto");
			return new ModelAndView("buscar");
		}
	}
	
	@SuppressWarnings (value="unchecked")
	@RequestMapping("/agregarCompra")
	public  ModelAndView agregarCarritoCompra(@RequestParam long id,HttpSession session) {
		Producto producto = null;
		 
		 producto = productoService.obtenerProducto(id);
		
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
        
		
		return new ModelAndView("informacionCompra");
	}
	
	@RequestMapping("/verCompra")
	public ModelAndView verCarritoCompra() {
		
		
		
		
		return new ModelAndView("informacionCompra");
		
	}
	
	
	
	
	
	@SuppressWarnings (value="unchecked")
	private int siExisteProductoCompra(long id,HttpSession session){
		
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		for(int i=0;i < cart.size();i++)
			if(cart.get(i).getProducto().getIdProducto() == id)
				return i;
		  	
		
		return -1;
		
	}
	
	@SuppressWarnings (value="unchecked")
	@RequestMapping("/borrarProducto")
	public ModelAndView eliminarCarritoCompra(@RequestParam long id,HttpSession session) {
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		int index = siExisteProductoCompra(id,session);
		cart.remove(index);
		session.setAttribute("cart",cart);
		return new ModelAndView("informacionCompra");
		
	}
	
	
	@RequestMapping("/comprar")
	public ModelAndView pedido(@ModelAttribute Orden orden){
		
		
		//session.removeAttribute("cart");
		
		return new ModelAndView("pedido");
		
		
	}
	
	
	
	@RequestMapping("/registrar")
	public ModelAndView registrarPedido(@Valid Orden orden, BindingResult result){
		
		ModelAndView model = new ModelAndView();
        model.addObject("orden", orden);
        model.setViewName(result.hasErrors() ? "pedido" : "comprar");
		//session.removeAttribute("cart");
		
		return model;
		
		
	}
	
	
	@RequestMapping("/cancelarCompra")
	public ModelAndView cancelar(HttpSession session){
		
		
		session.removeAttribute("cart");
		
		return new ModelAndView("buscar");
		
		
	}
	
	
	@RequestMapping("/pagar")
	public ModelAndView pagarProductos(@ModelAttribute Orden orden,HttpSession session){
		
		
		
		
		
		String llavePedido = UUID.randomUUID().toString();
		agregarPedidoBD(orden,llavePedido);
		Pedido pedido = ventasOnlineService.obtenerPedido(llavePedido);
		//System.out.println(pedido.getIdPedido());
		
		agregarVentaDetalleBD(pedido.getIdPedido(),session);
		
		
		session.removeAttribute("cart");
		
		return new ModelAndView("buscar");
		
		
	}
	
	
	
	@RequestMapping("/imagenProducto")
	  public void imagenProducto(HttpServletRequest request, HttpServletResponse response, Model model,
			  @RequestParam long id)throws IOException{
		 
		 Producto producto = null;
		 
		 producto = productoService.obtenerProducto(id);
		 
		 response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
       response.getOutputStream().write(producto.getImagen());
   
       response.getOutputStream().close();
		 
	 }
	
	
	private void agregarPedidoBD(Orden orden,String llavePedido){
		
		Pedido pedido = new Pedido();
		pedido.setLlave(llavePedido);
		pedido.setNombre(orden.getNombre());
		pedido.setApellidoPaterno(orden.getApellidoPaterno());
		pedido.setApellidoMaterno(orden.getApellidoMaterno());
		pedido.setCalle(orden.getCalle());
		pedido.setEntrecalles(orden.getEntrecalles());
		pedido.setColonia(orden.getColonia());
		pedido.setMunicipio(orden.getMunicipio());
		pedido.setEstado(orden.getEstado());
		pedido.setPais(orden.getPais());
		pedido.setCodigoPostal(orden.getCodigoPostal());
		pedido.setTelefono(orden.getTelefono());
		pedido.setEmail(orden.getEmail());
		pedido.setFecha(new Date());
		
		ventasOnlineService.agregarPedido(pedido);
		//System.out.println("***************Probando metodo**************************");
		//System.out.println(llavePedido);
		//System.out.println(orden.getNombre());
		
	}
	
	@SuppressWarnings (value="unchecked")
	private void agregarVentaDetalleBD(long idPedido,HttpSession session){
		VentaDetalleOnline ventaDetalleOnline = new VentaDetalleOnline();
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		Producto productoActualizarInventario = new Producto();
		VentaOnline ventasOnline = new VentaOnline();
		double totalVentas=0;
		for(int i=0;i < cart.size();i++){
			ventaDetalleOnline.setIdPedido(idPedido);
			ventaDetalleOnline.setCantidad(cart.get(i).getCantidad());
			ventaDetalleOnline.setIdProducto(cart.get(i).getProducto().getIdProducto());
			ventaDetalleOnline.setCostoProducto(cart.get(i).getProducto().getPrecio() * cart.get(i).getCantidad());
			ventasOnlineService.agregarVentaDetalleOnline(ventaDetalleOnline);
			productoActualizarInventario = cart.get(i).getProducto();
			productoActualizarInventario.setCantidad(cart.get(i).getProducto().getCantidad()-cart.get(i).getCantidad());
			productoService.actualizarProducto(productoActualizarInventario);
			totalVentas += cart.get(i).getProducto().getPrecio() * cart.get(i).getCantidad();
			
		}
		
		ventasOnline.setIdpedido(idPedido);
		ventasOnline.setTotal(totalVentas);
		ventasOnlineService.agregarVentaOnline(ventasOnline);
		
		
		
		
		
	}
	
	
	
	
}
