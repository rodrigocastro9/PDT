package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Zona;
import com.exception.ServiciosException;

public class Zonadao {

	@PersistenceContext
	private EntityManager em;



	public void CrearZona(Zona zona) throws ServiciosException {
		try{

			em.persist(zona);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear la Zona");
		}
	}

	public void ModificarZona(Zona zona) throws ServiciosException { // podria pasarle unicamente el nombre y no necesariamente toda la clase zona.
		try{

			em.merge(zona);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo modificar la Zona");
		}
	}

	public void EliminarZona(long id) throws ServiciosException {
		try{
			Zona zona=em.find(Zona.class,id);
			em.remove(zona);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo Eliminar la Zona");
		}
	}


	public List<Zona>  ObtenerZona() throws ServiciosException {
		try{
			TypedQuery <Zona> query = em.createQuery("Select z from Zona z",Zona.class);
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear la carrera");
		}
	}





}
