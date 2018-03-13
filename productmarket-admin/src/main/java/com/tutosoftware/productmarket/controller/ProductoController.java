package com.tutosoftware.productmarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tutosoftware.productmarket.entity.ArchivoImagen;
import com.tutosoftware.productmarket.entity.Producto;
import com.tutosoftware.productmarket.service.ProductoService;



@Controller
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	public ProductoController(){
		
		 
		
	}
	
	
	@RequestMapping("/agregarProducto")
	public  ModelAndView agregarProducto(ModelMap model) {
		
		ArchivoImagen archivoImagen = new ArchivoImagen();
		model.addAttribute("producto", archivoImagen);
		
		return new ModelAndView("agregarProducto");
	}
	
	
	
	@RequestMapping("/guardarProducto")
	public  ModelAndView guardarProducto(ArchivoImagen archivoImagen)throws IOException {
		
		
		agregarProductoBD(archivoImagen);
		
		
		return new ModelAndView("redirect:verProductos.html");
	}
	
	
	private void agregarProductoBD(ArchivoImagen archivoImagen)throws IOException{
		Producto producto = new Producto();
		MultipartFile multipartFile = archivoImagen.getFile();
		producto.setIdReferencia(archivoImagen.getIdReferencia());
		producto.setNombreProducto(archivoImagen.getNombreProducto());
		producto.setCodigoBarras(archivoImagen.getCodigoBarras());
		producto.setDescripcion(archivoImagen.getDescripcion());
		producto.setCantidad(archivoImagen.getCantidad());
		producto.setPrecio(archivoImagen.getPrecio());
		producto.setImagen(multipartFile.getBytes());
		producto.setTipoImagen(multipartFile.getContentType());
		producto.setUnidad(archivoImagen.getUnidad());
		
		
		productoService.agregarProducto(producto);
	}
	
	@RequestMapping("/verProductos")
	public  ModelAndView verProductos() {
		
	
		
	    
	     List<Producto> productoList = productoService.obtenerProductos();
	       
	      
		
		return new ModelAndView("verProductos","productoList",productoList);
	}
	
	
	 @RequestMapping("/buscarProducto")
	    public ModelAndView buscarProducto(@RequestParam("nombreProducto") String nombreProducto) {  
	    	List<Producto> productoList = productoService.obtenerProductos(nombreProducto);
	        return new ModelAndView("verProductos", "productoList",productoList);    	
	    }
	 
	 @RequestMapping("/editarProducto")
		public  ModelAndView verUsuarios(@RequestParam long id,ModelMap model) {
			
		 ArchivoImagen archivoImagen = new ArchivoImagen();
		model.addAttribute("producto", archivoImagen);  
		 
		 
		 
		 Producto producto = null;
			
		 
		     producto= productoService.obtenerProducto(id);
		           
		      
			
			return new ModelAndView("modificarProducto","productoObj",producto);
		}
	 
	 
	 @RequestMapping("/modificarProducto")
	    public  ModelAndView modificarProducto(ArchivoImagen archivoImagen)throws IOException{
		 
		 
		 actualizarProductoBD(archivoImagen);
		 
		 return new ModelAndView("redirect:verProductos.html");
		 
	 }
	 
	 
	 private void actualizarProductoBD(ArchivoImagen archivoImagen)throws IOException{
			Producto producto = new Producto();
			MultipartFile multipartFile = archivoImagen.getFile();
		    System.out.println("Esto es lo que imprime: "+multipartFile.getContentType());
			
		    
		    String tipoArchivo = "application/octet-stream";
		    
		    String tipoArchivoCargado = multipartFile.getContentType();
		    
		    
			if(tipoArchivo.equals(tipoArchivoCargado)){
				
				
               Producto productoImagen=null;
				
				productoImagen= productoService.obtenerProducto(archivoImagen.getIdProducto());
				
				producto.setIdProducto(archivoImagen.getIdProducto());
				producto.setIdReferencia(archivoImagen.getIdReferencia());
				producto.setNombreProducto(archivoImagen.getNombreProducto());
				producto.setCodigoBarras(archivoImagen.getCodigoBarras());
				producto.setDescripcion(archivoImagen.getDescripcion());
				producto.setCantidad(archivoImagen.getCantidad());
				producto.setPrecio(archivoImagen.getPrecio());
				producto.setUnidad(archivoImagen.getUnidad());
				producto.setImagen(productoImagen.getImagen());
				producto.setTipoImagen(productoImagen.getTipoImagen());
				
				
				
				
				
				
				
				
				
			}else{  
				producto.setIdProducto(archivoImagen.getIdProducto());
				producto.setIdReferencia(archivoImagen.getIdReferencia());
				producto.setNombreProducto(archivoImagen.getNombreProducto());
				producto.setCodigoBarras(archivoImagen.getCodigoBarras());
				producto.setDescripcion(archivoImagen.getDescripcion());
				producto.setCantidad(archivoImagen.getCantidad());
				producto.setPrecio(archivoImagen.getPrecio());
				producto.setImagen(multipartFile.getBytes());
				producto.setTipoImagen(multipartFile.getContentType());
				producto.setUnidad(archivoImagen.getUnidad());
				
			}
			
			
		
			
			
			productoService.actualizarProducto(producto);
		}
	 
	 
	 @RequestMapping("/eliminarProducto")
	 public  ModelAndView eliminarUsuario(@RequestParam long id) {
		 
		 productoService.eliminarProducto(id);
		 
		return new ModelAndView("redirect:verProductos.html"); 
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
	
	


}
