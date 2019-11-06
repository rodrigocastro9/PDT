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
    	TypedQuery<Observacion> query = em.createQuery("SELECT O FROM OBSERVACIONES O WHERE O.ID_OBSERVACION LIKE :ID_OBSERVACION", Observacion.class)
				.setParameter("ID_OBSERVACION", ID_OBSERVACION); 
		return query.getResultList();
	}
    
    public List<Observacion> obtenerTodasObservaciones() 
    {

		TypedQuery<Observacion> query = this.em.createQuery("select O from OBSERVACIONES O", Observacion.class);
		return query.getResultList();
	}
    
    public List<Observacion> ListarObservacionporZona(String nomZona)
	{
    	TypedQuery<Observacion> query = em.createQuery("SELECT O FROM Observacion O JOIN Localidad L ON O.localidad = L.id \r\n" + 
    			"JOIN Departamento D ON L.departamento = D.id JOIN Zona Z on Z.id = D.zona WHERE Z.nombre_zona LIKE :NomZona", Observacion.class)
				.setParameter("nomZona", nomZona); 
		return query.getResultList();
	}

  /*  public List<Observacion> ListarObservacionporCaraFenoFech(String NomCaraFenoFech)
	{
    	TypedQuery<Observacion> query = em.createQuery("SELECT O FROM OBSERVACIONES O JOIN localidad L ON O.id_localidad = L.id_localidad \r\n" + 
    			"JOIN departamento D ON L.id_departamento=D.id_departamento JOIN zona z on z.id_zona = D.id_zona WHERE D.id_zona LIKE :id_zona", Observacion.class)
				.setParameter("NomZona", NomZona); 
		return query.getResultList();
	}
    */
}
