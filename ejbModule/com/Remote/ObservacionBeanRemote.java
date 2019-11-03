package com.Remote;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.entidades.*;
import com.exception.ServiciosException;

@Remote
public interface ObservacionBeanRemote {

	boolean CrearObservacion (Long id, Usuario usuario, Fenomeno fenomeno, Localidad localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, Estado estado, Date fecha) throws ServiciosException;
	
	boolean ModificarObservacion(Long id, Usuario usuario, Fenomeno fenomeno, Localidad localidad, 
    		String descripcion, Blob imagen, float latitud, float longitud, float altitud, Estado estado, Date fecha) throws ServiciosException;
	 
	boolean EliminarObservacion(long id) throws ServiciosException;
	
	List<Observacion> ListarObservacionporID(long ID_OBSERVACION);
	
	List <Observacion> obtenerTodasObservaciones();
	
	List<Observacion> ListarObservacionporZona(String NomZona);
	
	boolean validarDescripcion(Observacion obs, List<String> palabras);
	
}
