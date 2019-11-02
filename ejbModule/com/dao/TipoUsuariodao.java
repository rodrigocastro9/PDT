package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.TipoUsuario;
@Stateless
public class TipoUsuariodao {
	
	@PersistenceContext
	private EntityManager em;

	
	  public TipoUsuario obtenertipousuario(long idtipousu) {

			return this.em.find(TipoUsuario.class, idtipousu);

		}
	  

	    //Metodo para listar todos los tipos de usuario
	    public List<TipoUsuario> obtenerTodoslosTipos() {
	    		String consulta = "Select t from tiposusuario t";
				TypedQuery<TipoUsuario> query = this.em.createQuery(consulta, TipoUsuario.class);

				return query.getResultList();
			}
	    
	    

}
