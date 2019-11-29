package com.dao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.*;


@Stateless
public class Usuariodao {

	
		@PersistenceContext
		private EntityManager em;
	
		
	public void AgregarUsuario(Usuario usuario) throws Exception 
		{
		try {
			em.persist(usuario);	
			em.flush();
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer agregar el usuario.");
		}
		}
	
	public void Modificarusuario(Usuario usuario)
	{
		try {
			em.merge(usuario);
			em.flush();
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer modificar el usuario.");
		}
	}
		
	public void EliminarUsuario (Long id)
	{
		try 
		{
			Usuario usu = em.find(Usuario.class,id);
					em.remove(usu);
					em.flush();
		}catch(PersistenceException e) 
		{

			System.out.println ("No se pudo eliminar el usuario.");
		}
	}

	//Lista de usuario por nombre de usuario y password
	public List<Usuario> Login (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario LIKE :usuario AND u.pass LIKE :pass",Usuario.class)
					.setParameter("usuario", usuario)
					.setParameter("pass",pass);
			 List <Usuario> usuarios = query.getResultList();
	    	
			 return usuarios;
			 
	    }
    
	//Lista de usuario por nombre de usuario
  	public List<Usuario> existeUsuario(String usuario) {
  		
  		TypedQuery<Usuario> query = em.createQuery("SELECT U FROM Usuario U WHERE U.usuario LIKE :usuario",Usuario.class).setParameter("usuario",usuario);
		
  		List<Usuario> us  =  query.getResultList();
  		
  		return us;
  	}
  	
  	//Obtener usuario por nombre de usuario
  	public Usuario obtenerUsuario(String usuario) {

	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where u.usuario LIKE : usuario",Usuario.class).setParameter("usuario",usuario);
			return query.getSingleResult();

		} 
}
	  
	


		

		
	
		
		
	


