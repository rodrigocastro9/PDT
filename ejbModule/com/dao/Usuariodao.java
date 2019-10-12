package com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entidades.*;


@Stateless
public class Usuariodao {

	
		@PersistenceContext
		private EntityManager em;
		
	public void AgregarUsuario(Usuario usuario,Long id_tipo) throws Exception 
		{
		try {
			Usuario usuarionuevo = new Usuario();
			//Acapodriatraer nombre usuario
			usuarionuevo.setTipousuario(em.find(TipoUsuario.class,id_tipo));
			em.persist(usuarionuevo);
			em.flush();
				
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer consultar el usuario.");
		}
		}
	
	
}

		

		
	
		
		
	


