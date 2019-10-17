package com.dao;

<<<<<<< Updated upstream
=======
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

>>>>>>> Stashed changes
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
	  
	    
	    public List<Usuario> ObtenerUsuarioYPass (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.USUARIO LIKE :nombre AND u.PASS LIKE :pass",Usuario.class)
					.setParameter("nombre", usuario)
					.setParameter("pass",pass);
			return query.getResultList();
	    	
	    }
	    
	    
	    
	    public List<Usuario> ObtenerTipoUsu (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.USUARIO LIKE :nombre AND u.PASS LIKE :pass AND u.ID_TIPO =1",Usuario.class)
					.setParameter("nombre", usuario)
					.setParameter("pass",pass);
			return query.getResultList();

	    }
	
}

		

		
	
		
		
	


