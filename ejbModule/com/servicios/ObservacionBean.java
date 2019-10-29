package com.servicios;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.Remote.ObservacionBeanRemote;
import com.dao.Observaciondao;
import com.entidades.*;
import com.exception.ServiciosException;

import java.sql.Blob;



@Stateless
@LocalBean
public class ObservacionBean implements ObservacionBeanRemote {


		@EJB
		private Observaciondao obsDao;
	Observacion obs = new Observacion();
	
    public ObservacionBean() 
    {}
    
	@Override
    public boolean CrearObservacion(Long id, Usuario usuario, Fenomeno fenomeno, Localidad localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, Estado estado, Date fecha) throws ServiciosException
    {
    	boolean pudeCrear;
    	obs = new Observacion(id, usuario, fenomeno, localidad, descripcion, imagen, latitud ,longitud, altitud, estado, fecha);
    	try {
    		this.obsDao.AgregarObservacion(obs, usuario.getId(), estado.getId(), fenomeno.getCodigo(), localidad.getId());
    		pudeCrear = true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		pudeCrear = false;
    	}
    	
    	return pudeCrear;	
    }
	
	@Override
    public boolean ModificarObservacion(Long id, Usuario usuario, Fenomeno fenomeno, Localidad localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, Estado estado, Date fecha) throws ServiciosException
    {
    	boolean pudeModificar;
    	
    	obs.setId(id);
    	obs.setUsuario(usuario);
    	obs.setFenomeno(fenomeno);
    	obs.setLocalidad(localidad);
    	obs.setDescripcion(descripcion);
    	obs.setImagen(imagen);
    	obs.setLatitud(latitud);
    	obs.setLongitud(longitud);
    	obs.setAltitud(altitud);
    	obs.setEstado(estado);
    	obs.setFecha(fecha);
    	
    	try {
    		this.obsDao.ModificarObservacion(obs);
    		pudeModificar = true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		pudeModificar = false;
    	}
    	
    	return pudeModificar;	
    }
	
	@Override
	public boolean EliminarObservacion(long id) throws ServiciosException{
    	boolean pudeEliminar;
		try {
			this.obsDao.EliminarObservacion(id);
			pudeEliminar=true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			pudeEliminar=false;
		}
		return pudeEliminar;
	}
	
	@Override
	public List<Observacion> ListarObservacionporID(long ID_OBSERVACION){

		return this.obsDao.ListarObservacionporID(ID_OBSERVACION);
	}
	
	@Override
	public List<Observacion> obtenerTodasObservaciones(){

		return this.obsDao.obtenerTodasObservaciones();
	}

	
}
