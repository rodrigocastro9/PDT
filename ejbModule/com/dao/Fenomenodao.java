package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Estado;
import com.entidades.Fenomeno;
import com.entidades.Localidad;
import com.entidades.Telefono;
import com.entidades.TipoUsuario;
import com.exception.ServiciosException;



@Stateless
@LocalBean
public class Fenomenodao {

	@PersistenceContext
	private EntityManager em;
	
	public void AgregarFenomeno (Fenomeno fenomeno) throws ServiciosException
	{
		try {
			em.persist(fenomeno);
			em.flush();
			
	}catch(PersistenceException e)
		{
		System.out.println ("Error al querer Agregar el Fenomeno.");
		}
	}
		
	public void ModificarFenomeno (Fenomeno fenomeno) throws ServiciosException
	{
		try 
		{
			em.merge(fenomeno);
			em.flush();
			
			
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer actualizar el Fenomeno.");
		}
	}
	
	public void BorrarFenomeno (long id) throws ServiciosException
	{
		try 
		{
			Fenomeno fen = em.find(Fenomeno.class, id);
			em.remove(fen);
			em.flush();
		}catch(PersistenceException e) 
		{

			System.out.println ("No se pudo eliminar el Fenomeno.");
		}
	}
	
	public List<Fenomeno>obtenerfenomenos ()
	{
		TypedQuery<Fenomeno> query= em.createQuery("SELECT F FROM Fenomeno F",Fenomeno.class);
			return query.getResultList();
	}
	
	public Fenomeno obtenerfenomenoporcodigo(String codigo)
	{
		return this.em.find(Fenomeno.class,codigo);
	}
	
	public List<Fenomeno> existeFenomeno(String codigo)
	{
		//Fenomeno fen = new Fenomeno();
		TypedQuery<Fenomeno> query = em.createQuery("SELECT COD FROM Fenomeno COD where COD.codigo LIKE : codigo",Fenomeno.class).setParameter("codigo",codigo);
		return query.getResultList();
		
	}
	
	public Fenomeno obtenercodigoFen(long codigofen) {

		return this.em.find(Fenomeno.class, codigofen);

	}

	 public Telefono obtenertelefonoemergencia(String nombre) {
		  
		  TypedQuery<Telefono> query = em.createQuery("SELECT TU FROM Telefono TU where TU.nombre LIKE: nombre ",Telefono.class)
				  .setParameter("nombre", nombre);
			return query.getSingleResult();
		  //SELECT u FROM Usuario u WHERE u.Usuario LIKE :nombre AND u.PASS LIKE :pass
		}
	    
    public List<Telefono> obtenerTelEmergencia() {
    	 TypedQuery<Telefono> query = this.em.createQuery("select u FROM Telefono u", Telefono.class);
  		
    	List<Telefono> tus = query.getResultList();
    	 
    	 return tus;	
    }    

    public Fenomeno obtenerFenomeno(String codigo) {

	    	TypedQuery<Fenomeno> query = em.createQuery("SELECT f FROM Fenomeno f where f.codigo LIKE : codigo",Fenomeno.class).setParameter("codigo",codigo);
	    	
	    	return query.getSingleResult();

		}    
    
    public Fenomeno obtenerNombreFen(String nombreFen) {

    	TypedQuery<Fenomeno> query = em.createQuery("SELECT f FROM Fenomeno f where f.nombreFen LIKE : nombreFen",Fenomeno.class).setParameter("nombreFen",nombreFen);
    	
    	Fenomeno f = query.getSingleResult();
    	
    	return f;

	}    

    public List <Fenomeno> obtenerFenomenosTodos(String codigo){
    	
    	TypedQuery<Fenomeno> query = em.createQuery("SELECT f FROM Fenomeno f where f.codigo LIKE : codigo",Fenomeno.class).setParameter("codigo",codigo);
		
    		
    	return query.getResultList();
    }
    
	    
	    
	    
}
