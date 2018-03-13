package com.tutosoftware.productmarket.dao;

import java.util.List;

import com.tutosoftware.productmarket.entity.Usuario;



public interface LoginDAO {
	
	public Usuario obtenerLogin(Usuario usuario);
    public long agregarUsuarioLogin(Usuario usuario);
    public List<Usuario> obtenerUsuarios();
    public Usuario actualizarUsuario(Usuario usuario);
    public Usuario obtenerUsuario(long id);
    public void eliminarUsuario(long id);

}
