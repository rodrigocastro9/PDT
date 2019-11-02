package com.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Fenomeno;
import com.exception.ServiciosException;

@Stateless
@LocalBean
public class Fenomenodao {

	@PersistenceContext
	private EntityManager em;
	
	public void AgregarFenomeno (Fenomeno fenomeno) throws ServiciosException
	{
		try 
		{
			em.persist(fenomeno);
			em.flush();
			
		}catch(PersistenceException e)
		{
			System.out.println ("No se pudo dar de alta el Fenomeno."+e.getStackTrace());
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
	
	public void BorrarFenomeno (long codigo) throws ServiciosException
	{
		try 
		{
			Fenomeno fen = em.find(Fenomeno.class, codigo);
			em.remove(fen);
			em.flush();
		}catch(PersistenceException e) 
		{

			System.out.println ("No se pudo eliminar el Fenomeno.");
		}
	}
	
	
	public List<Fenomeno>obtenerfenomenos ()
	{
		TypedQuery<Fenomeno> query= em.createQuery("SELECT F FROM FENOMENO F",Fenomeno.class);
			return query.getResultList();
	}
	
	
	public Fenomeno obtenerfenomenoporcodigo(long codigo)
	{
		return this.em.find(Fenomeno.class,codigo);
	}
	
	
	
}
