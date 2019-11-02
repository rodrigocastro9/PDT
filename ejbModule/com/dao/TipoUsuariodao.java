package com.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entidades.TipoUsuario;
@Stateless
public class TipoUsuariodao {
	
	@PersistenceContext
	private EntityManager em;

	
	  public TipoUsuario obtenertipousuario(long idtipousu) {

			return this.em.find(TipoUsuario.class, idtipousu);

		}

}
