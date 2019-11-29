package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Localidad;
import com.entidades.TipoUsuario;

@Remote
public interface LocalidadBeanRemote {

	List <Localidad> obtenerTodasLocalidades();
	
	Localidad obtenerLocalidad(String localidad);
	
}
