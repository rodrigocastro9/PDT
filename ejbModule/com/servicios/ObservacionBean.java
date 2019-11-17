package com.servicios;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.Remote.ObservacionBeanRemote;
import com.dao.*;
import com.entidades.*;
import com.exception.ServiciosException;

import java.sql.Blob;



@Stateless
@LocalBean
public class ObservacionBean implements ObservacionBeanRemote {


	@EJB
	private Observaciondao obsDao;
	Observacion obs = new Observacion();
	@EJB
	private Usuariodao usuDao;
	Usuario usu = new Usuario();
	@EJB
	private Localidaddao locDao;
	Localidad loc = new Localidad();
	@EJB
	private Estadodao estDao;
	Estado est = new Estado();
	@EJB
	private Fenomenodao fenDao;
	Fenomeno fen = new Fenomeno();
	
	
	//dato de prueba
	private List<String> palabras = Arrays.asList("insulto1", "insulto2", "insulto3");
	
    public ObservacionBean() 
    {}
    
	@Override
    public boolean CrearObservacion(Long id, String usuario, String fenomeno, String localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, String estado, Date fecha) throws ServiciosException
    {
    	boolean pudeCrear;
    	
    	Usuario usu = this.usuDao.obtenerUsuario(usuario);
		Fenomeno fen = this.fenDao.obtenerFenomeno(fenomeno);
		Localidad loc = this.locDao.obtenerLocalidad(localidad);
		Estado est = this.estDao.obtenerEstadonombre(estado);
    	
    	obs = new Observacion(id, usu, fen, loc, descripcion, imagen, latitud ,longitud, altitud, est, fecha);
    	
    	//pasar lista de palabras inconvenientes en el segundo parametro
    	if(!this.validarDescripcion(obs, this.palabras))
    		obs.setDescripcion("CONTENIDO INCONVENIENTE");
    	
    	try {
    		
    		this.obsDao.AgregarObservacion(obs, usu.getId(), est.getId(), fen.getId(), loc.getId());
    		pudeCrear = true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		pudeCrear = false;
    	}
    	
    	return pudeCrear;	
    }
	
	@Override
    public boolean ModificarObservacion(Long id, String usuario, String fenomeno, String localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, String estado, Date fecha) throws ServiciosException
    {		
    	boolean pudeModificar;
    	
    	Usuario usu = this.usuDao.obtenerUsuario(usuario);
		Fenomeno fen = this.fenDao.obtenerFenomeno(fenomeno);
		Localidad loc = this.locDao.obtenerLocalidad(localidad);
		Estado est = this.estDao.obtenerEstadonombre(estado);
    	
    	
    	
    	obs.setId(id); // el id no deberia poder modificarse Soy rodrigo
    	obs.setUsuario(usu);
    	obs.setFenomeno(fen);
    	obs.setLocalidad(loc);
    	obs.setDescripcion(descripcion);
    	obs.setImagen(imagen);
    	obs.setLatitud(latitud);
    	obs.setLongitud(longitud);
    	obs.setAltitud(altitud);
    	obs.setEstado(est);
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
	public List<Observacion> existeObservacion(String codigo){
		List <Observacion> observaciones = this.obsDao.existeObservacion(codigo);		
		 return observaciones;
	}	
	
}
