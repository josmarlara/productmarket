package com.tutosoftware.productmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutosoftware.productmarket.entity.Usuario;
import com.tutosoftware.productmarket.service.LoginService;
import com.tutosoftware.productmarket.dao.LoginDAO;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	 private LoginDAO loginDAO;
	
	
	 public LoginServiceImpl(){
		 
	 }
	
	

	@Override
	public Usuario obtenerLogin(Usuario usuario) {
		// TODO Auto-generated method stub
		return loginDAO.obtenerLogin(usuario);
	}

	@Override
	public long agregarUsuarioLogin(Usuario usuario) {
		// TODO Auto-generated method stub
		return loginDAO.agregarUsuarioLogin(usuario);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return loginDAO.obtenerUsuarios();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return loginDAO.actualizarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuario(long id) {
		// TODO Auto-generated method stub
		return loginDAO.obtenerUsuario(id);
	}

	@Override
	public void eliminarUsuario(long id) {
		// TODO Auto-generated method stub
		
		loginDAO.eliminarUsuario(id);

	}

}
