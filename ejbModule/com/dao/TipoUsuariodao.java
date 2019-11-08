package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Fenomeno;
import com.entidades.TipoUsuario;
@Stateless
public class TipoUsuariodao {
	
	@PersistenceContext
	private EntityManager em;

	
	  public TipoUsuario obtenertipousuario(String tipousuario) {
		  
		  TypedQuery<TipoUsuario> query = em.createQuery("SELECT TU FROM TipoUsuario TU where TU.nombre LIKE : tipousuario",TipoUsuario.class).setParameter("tipousuario",tipousuario);
			return query.getSingleResult();
		  
		}
	    

	    //Metodo para listar todos los tipos de usuario
	    public List<TipoUsuario> obtenerTodoslosTipos() {
	    	 TypedQuery<TipoUsuario> query = this.em.createQuery("SELECT U FROM TipoUsuario U", TipoUsuario.class);
	  		
	    	List<TipoUsuario> tus = query.getResultList();
	    	 
	    	 return tus;
	  		
			
	    }    

}
