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
			em.merge(usuario);
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
	
<<<<<<< Updated upstream
	//Metodo para el login de usuario
    public List<Usuario> Login (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario LIKE :usuario AND u.pass LIKE :pass",Usuario.class)
					.setParameter("usuario", usuario)
=======
	public List<Usuario> Login (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.Usuario LIKE :nombre AND u.PASS LIKE :pass",Usuario.class)
					.setParameter("nombre", usuario)
>>>>>>> Stashed changes
					.setParameter("pass",pass);
			return query.getResultList();
	    	
	    }
    
  	public Usuario existeUsuario(String nomUsu) {
  		
  		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario U WHERE U.usuario LIKE : nomUsu",Usuario.class).setParameter("nomUsu",nomUsu);
		
  		Usuario us  = query.getSingleResult();
  		
  		return us;
  	}
  	
  	
}
	  
	


		

		
	
		
		
	


