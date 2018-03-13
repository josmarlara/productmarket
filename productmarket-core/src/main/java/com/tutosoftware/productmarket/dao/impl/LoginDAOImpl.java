package com.tutosoftware.productmarket.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutosoftware.productmarket.dao.LoginDAO;
import com.tutosoftware.productmarket.entity.Usuario;
import com.tutosoftware.productmarket.util.HibernateUtil;


@Repository
public class LoginDAOImpl implements LoginDAO {
	
	
	 @Autowired
	  private HibernateUtil hibernateUtil;
	 
	 
      public LoginDAOImpl(){
		 
	 }
	 
	

	@Override
	public Usuario obtenerLogin(Usuario usuario) {
		
		
        String hql="from Usuario as u where u.usuario = '"+usuario.getUsuario()+"' and u.password = '"+usuario.getPassword()+"'";
		
		Usuario usuarioResult = hibernateUtil.fetchByUniqueResult(hql);
		// TODO Auto-generated method stub
		return usuarioResult;
	}

	@Override
	public long agregarUsuarioLogin(Usuario usuario) {
		// TODO Auto-generated method stub
		return (Long) hibernateUtil.create(usuario);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchAll(Usuario.class);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return hibernateUtil.update(usuario);
	}

	@Override
	public Usuario obtenerUsuario(long id) {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchById(id,Usuario.class);
	}

	@Override
	public void eliminarUsuario(long id) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		hibernateUtil.delete(usuario);

	}

}
