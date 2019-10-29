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

    public void AgregarObservacion(Observacion nuevaObs, Long idUsu, Long idEst, Long idFen, Long idLocal) throws ServiciosException 
	{
    	try {
			nuevaObs.setUsuario(em.find(Usuario.class, idUsu));
			nuevaObs.setEstado(em.find(Estado.class, idEst));
			nuevaObs.setFenomeno(em.find(Fenomeno.class, idFen));
			nuevaObs.setLocalidad(em.find(Localidad.class, idLocal));
			em.persist(nuevaObs);
			em.flush();
				
		}catch(PersistenceException e)
			{
				throw new ServiciosException ("Error al querer agregar la observacion.");
			}
	}

    public void ModificarObservacion(Observacion observacion) throws ServiciosException
	{
		try {
			em.merge(observacion);
			em.flush();
		}catch(PersistenceException e)
		{
			throw new ServiciosException("No se pudo modificar la observacion");		
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
	    	throw new ServiciosException("Error al intentar eliminar la observacion.");
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
    
   /* public List<Observacion> ListarObservacionporZona(long ID_Zona)
	{
    	TypedQuery<Observacion> query = em.createQuery("SELECT O FROM OBSERVACIONES O WHERE O.ID_OBSERVACION LIKE :id", Observacion.class)
				.setParameter("ID_OBSERVACION", ID_OBSERVACION); 
		return query.getResultList();
	}*/
    
}
