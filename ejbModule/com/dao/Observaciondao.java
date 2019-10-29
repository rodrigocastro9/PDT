package com.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.exception.ServiciosException;
import com.entidades.*;

@Stateless
@LocalBean
public class Observaciondao {

    public Observaciondao() 
    {}
    
    @PersistenceContext
	private EntityManager em;

    public void AgregarObservacion(Observacion observacion, Long id) throws ServiciosException 
	{
    	try {
			Observacion nuevaObs = new Observacion();		
					
			em.persist(nuevaObs);
			em.flush();
				
		}catch(PersistenceException e)
			{
				System.out.println ("Error al querer consultar la observacion.");
			}
	}

    public void ModificarObservacion(Observacion observacion) throws ServiciosException
	{
		try {
			em.merge(observacion);
			em.flush();
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer modificar la observacion.");
		}
	}
        
    public void EliminarObservacion (long id) throws ServiciosException
    {
	    try {
	    	
	    	Observacion obs = em.find(Observacion.class, id);
	    	
	    	em.remove(obs);
	    	em.flush();
	    }
	    
	    catch(PersistenceException e)
	    {
	    	System.out.println("Error al intentar eliminar la observacion.");
	    }
    }
 
	public List<Observacion> ListarObservacionporID(long ID_OBSERVACION)
	{
    	TypedQuery<Observacion> query = em.createQuery("SELECT O FROM OBSERVACIONES O WHERE O.ID_OBSERVACION LIKE :id", Observacion.class)
				.setParameter("ID_OBSERVACION", ID_OBSERVACION); 
		return query.getResultList();
	}
    
    public List<Observacion> obtenerTodasObservaciones() 
    {

		TypedQuery<Observacion> query = this.em.createQuery("select O from OBSERVACIONES O", Observacion.class);
		return query.getResultList();
	}
    
    
}
