package com.tutosoftware.productmarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tutosoftware.productmarket.entity.Usuario;
import com.tutosoftware.productmarket.service.LoginService;
import com.tutosoftware.productmarket.validation.UsuarioValidation;



@Controller
@SessionAttributes("userObj")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	public LoginController(){
		
	}
	
    
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UsuarioValidation()); // registramos el validador
    }
	
	
	
	
	 @RequestMapping("/login")
	public  ModelAndView loginUser(@ModelAttribute Usuario usuario) {
		
		return new ModelAndView("login");
	}

	 @RequestMapping("/verificarLogin")
	public ModelAndView verificarLogin(ModelMap model,@ModelAttribute Usuario usuario){
		
		if(usuario.getUsuario().trim().length() != 0 &&  usuario.getPassword().trim().length() != 0){
			usuario=loginService.obtenerLogin(usuario);
			if(usuario != null){
				ModelAndView modelo = new ModelAndView("home");
				modelo.addObject("usuario",usuario);
				modelo.addObject("userObj",usuario);
				return modelo;
				
			}else{
				model.put("falla","usuario o password incorrecto");
				return new ModelAndView("login");
			}
			
			
		}else{
			model.put("vacio","falta un dato usuario o password vació");
			return new ModelAndView("login");
			
		}
		
	}
	
	 @RequestMapping("/agregarUsuario")
		public  ModelAndView agregarUsuario(@ModelAttribute Usuario usuario) {
			
			return new ModelAndView("agregarUsuario");
		}
	 
	 
	 @RequestMapping("/guardarUsuario")
		public  ModelAndView guardarUsuario(ModelMap model,@Valid Usuario usuario,BindingResult result) {
			
		// si hay errores volvemos a la vista del formulario
			if ( result.hasErrors() ) {
				return new ModelAndView("agregarUsuario");
			}
		 
			
				 loginService.agregarUsuarioLogin(usuario);
		         
				 	  
			
		          return new ModelAndView("redirect:verUsuarios.html");
		}
	 
	 
	 @RequestMapping("/verUsuarios")
		public  ModelAndView verUsuarios() {
			
		
			
		 
		     List<Usuario> usuarioList = loginService.obtenerUsuarios();
		           
		      
			
			return new ModelAndView("verUsuarios","usuarioList",usuarioList);
		}
	 
	 
	 @RequestMapping("/editarUsuario")
		public  ModelAndView verUsuarios(@RequestParam long id, @ModelAttribute Usuario usuario) {
			
		
			
		 
		     usuario= loginService.obtenerUsuario(id);
		           
		      
			
			return new ModelAndView("modificarUsuario","usuarioObj",usuario);
		}
	 
	 
	 @RequestMapping("/modificarUsuario")
		public  ModelAndView actualizarUsuario(ModelMap model,@Valid Usuario usuario,BindingResult result) {
			
		// si hay errores volvemos a la vista del formulario
			if ( result.hasErrors() ) {
				return new ModelAndView("modificarUsuario");
			}
		  
				 
				 loginService.actualizarUsuario(usuario) ;
	        	
	        	
				
				 return new ModelAndView("redirect:verUsuarios.html");
		}
	 
	 
	 
	 @RequestMapping("/eliminarUsuario")
		public  ModelAndView eliminarUsuario(@RequestParam long id) {
			
		
			
		 
		     loginService.eliminarUsuario(id);
		           
		     
	           
		      
				
				return new ModelAndView("redirect:verUsuarios.html"); 
			
			
		}
	 
	 
	 
	 @RequestMapping("/salir")
		public  ModelAndView salir(@ModelAttribute Usuario usuario, WebRequest request, SessionStatus status) {
		     status.setComplete();
		    request.removeAttribute("userObj", WebRequest.SCOPE_SESSION);
			return new ModelAndView("login");
		}

}
