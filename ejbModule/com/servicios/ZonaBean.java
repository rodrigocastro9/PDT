package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dao.Zonadao;
import com.entidades.Zona;
import com.exception.ServiciosException;

@Stateless
@LocalBean

public class ZonaBean {
	
	@EJB
	private Zonadao zonadao;
	Zona zona = new Zona();
	
	public ZonaBean()
	{}
	
	

	public boolean CrearZona(long id, String nombre) throws ServiciosException
	{
		boolean pudeCrear;
		zona= new Zona(id,nombre);
		try 
		{
			this.zonadao.CrearZona(zona);
			pudeCrear = true;
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
    		pudeCrear = false;
		}
		return pudeCrear;
	}
	public boolean ModificarZona(long id, String nombre_zona) throws ServiciosException
	{
		boolean pudeModficar;
		zona.setNombre_zona(nombre_zona); //Modificamos solamente el nombre, entiendo que el id no se deberia modificar.
		try 
		{
			this.zonadao.ModificarZona(zona);
			pudeModficar = true;
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			pudeModficar = false;
		}
		return pudeModficar;
	}
	
	public boolean EliminarZona(long id) throws ServiciosException{
    	boolean pudeEliminar;
		try {
			this.zonadao.EliminarZona(id);
			pudeEliminar=true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			pudeEliminar=false;
		}
		return pudeEliminar;
	}
	
	public List<Zona> ObtenertodasZonas() throws ServiciosException{

		return this.zonadao.ObtenerZona();
	}
}
