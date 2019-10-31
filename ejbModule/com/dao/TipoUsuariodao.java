package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entidades.TipoUsuario;

public class TipoUsuariodao {
	
	@PersistenceContext
	private EntityManager em;

	
	  public TipoUsuario obtenertipousuario(String tipousuario) {

			return this.em.find(TipoUsuario.class, tipousuario);

		}

}
