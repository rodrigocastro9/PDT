package com.servicios;

import java.util.List;
import javax.ejb.EJB;
import com.Remote.EstadoBeanRemote;
import com.dao.Estadodao;
import com.entidades.Estado;

public class EstadoBean implements EstadoBeanRemote{
	@EJB 
	private Estadodao estdao;
	
	public EstadoBean()
	{}
	
	
	@Override
	public List<Estado> obtenerTodosEstados(){

		 List <Estado> estados = this.estdao.obtenerTodasEstados();		
		 return estados;
	}

}
