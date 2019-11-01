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
	
	
	public void EliminarUsuario (String usuario)
	{
		try 
		{
			Usuario usu = em.find(Usuario.class,usuario);
					em.remove(usu);
					em.flush();
		}catch(PersistenceException e) 
		{

			System.out.println ("No se pudo eliminar el usuario.");
		}
	}
	  
	    
	    public List<Usuario> Login (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.USUARIO LIKE :nombre AND u.PASS LIKE :pass",Usuario.class)
					.setParameter("nombre", usuario)
					.setParameter("pass",pass);
			return query.getResultList();
	    	
	    }
	    
	    
	    public TipoUsuario ObtenerTipoUsu (long id){
	    	TypedQuery<TipoUsuario> query = em.createQuery("SELECT u FROM TIPOSUSUARIOS u.id_tipo like :id", TipoUsuario.class)
	    			.setParameter("id",id);
			return query.getResultList().get(0);

	    }
	    
	    
	    public List<Usuario> obtenerusuarios()
	    {
	    	TypedQuery<Usuario> query = em.createQuery("SELECT U FROM USUARIO U",Usuario.class);
	    	
	    	return query.getResultList();
	    }
		
	    public Usuario obtenerUsuario(String ci) {

		return this.em.find(Usuario.class, ci);

	}
		public List<TipoUsuario> obtenerTodoslosTipos() {
			TypedQuery<TipoUsuario> query = this.em.createQuery("select T from TIPOSUSUARIOS T", TipoUsuario.class);
			return query.getResultList();
		}

	    
	  
	
}

		

		
	
		
		
	


