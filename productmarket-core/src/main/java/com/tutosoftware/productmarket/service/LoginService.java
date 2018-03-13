package com.tutosoftware.productmarket.service;

import java.util.List;

import com.tutosoftware.productmarket.entity.Usuario;

public interface LoginService {
	
	public Usuario obtenerLogin(Usuario usuario);
	public long agregarUsuarioLogin(Usuario usuario);
	public List<Usuario> obtenerUsuarios();
	public Usuario actualizarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(long id);
	public void eliminarUsuario(long id);

}
