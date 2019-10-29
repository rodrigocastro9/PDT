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
	
		
	public void AgregarUsuario(Usuario usuario,Long id) throws Exception 
		{
		try {
			Usuario usuarionuevo = new Usuario();
			usuarionuevo.setTipousuario(em.find(TipoUsuario.class,id));
			em.persist(usuarionuevo);
			em.flush();
				
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer consultar el usuario.");
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
	
	
	public void Borrarusuario (long id)
	{
		try 
		{
			Usuario usuario= em.find(Usuario.class,id);
					em.remove(usuario);
					em.flush();
		}catch(PersistenceException e) 
		{

			System.out.println ("No se pudo eliminar el usuario.");
		}
	}
	  
	    
	    public List<Usuario> ObtenerUsuarioYPass (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.USUARIO LIKE :nombre AND u.PASS LIKE :pass",Usuario.class)
					.setParameter("nombre", usuario)
					.setParameter("pass",pass);
			return query.getResultList();
	    	
	    }
	    
	    
	    public List<TipoUsuario> ObtenerTipoUsu (){
	    	TypedQuery<TipoUsuario> query = em.createQuery("SELECT u FROM TIPOSUSUARIOS", TipoUsuario.class);
			return query.getResultList();

	    }
	    
	    
	    public List<Usuario> obtenerusuarios()
	    {
	    	TypedQuery<Usuario> query = em.createQuery("SELECT U FROM USUARIO U",Usuario.class);
	    	return query.getResultList();
	    }
	
}

		

		
	
		
		
	


