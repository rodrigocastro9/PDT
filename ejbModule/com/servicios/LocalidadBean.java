package com.servicios;

import java.util.List;

import javax.ejb.EJB;

import com.Remote.LocalidadBeanRemote;
import com.dao.Localidaddao;
import com.entidades.Localidad;

public class LocalidadBean implements LocalidadBeanRemote{

	@EJB 
	private Localidaddao locdao;
	
	public LocalidadBean()
	{}
	@Override
	public List<Localidad> obtenerTodasLocalidades(){

		List <Localidad> localidades = locdao.obtenerTodasLocalidades();
		
		return localidades;
	}
}
