package com.servicios;

import java.util.Arrays;
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
	
	
	//dato de prueba
	private List<String> palabras = Arrays.asList("insulto1", "insulto2", "insulto3");
	
    public ObservacionBean() 
    {}
    
	@Override
    public boolean CrearObservacion(Long id, Usuario usuario, Fenomeno fenomeno, Localidad localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, Estado estado, Date fecha) throws ServiciosException
    {
    	boolean pudeCrear;
    	obs = new Observacion(id, usuario, fenomeno, localidad, descripcion, imagen, latitud ,longitud, altitud, estado, fecha);
    	
    	//pasar lista de palabras inconvenientes en el segundo parametro
    	if(!this.validarDescripcion(obs, this.palabras))
    		obs.setDescripcion("CONTENIDO INCONVENIENTE");
    	
    	try {
    		
    		this.obsDao.AgregarObservacion(obs, usuario.getId(), estado.getId(), fenomeno.getId(), localidad.getId());
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
    	
    	obs.setId(id); // el id no deberia poder modificarse Soy rodrigo
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
    	
    	//pasar lista de palabras inconvenientes en el segundo parametro
    	if(!this.validarDescripcion(obs, this.palabras))
    		obs.setDescripcion("CONTENIDO INCONVENIENTE");
    	
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

		 List <Observacion> observaciones = this.obsDao.obtenerTodasObservaciones();		
		 return observaciones;
	}
	
	@Override
	public boolean validarDescripcion(Observacion obs, List<String> palabras) {
		boolean estaLimpia = true; 
		int i = 0;
		
		while(estaLimpia && i < palabras.size()) {
			if(obs.getDescripcion().contains(palabras.get(i)))
				estaLimpia = false;
		}
		
		return estaLimpia;		
	}

	@Override
	public List<Fenomeno> obtenerTodosFenomenos(){

		 List <Fenomeno> fenomenos = this.obsDao.obtenerTodosFenomenos();		
		 return fenomenos;
	}
	
	@Override
	public List<Localidad> obtenerTodasLocalidades(){

		 List <Localidad> localidades = this.obsDao.obtenerTodasLocalidades();		
		 return localidades;
	}
	
	@Override
	public List<Estado> obtenerTodosEstados(){

		 List <Estado> estados = this.obsDao.obtenerTodasEstados();		
		 return estados;
	}
	
	
	
}
