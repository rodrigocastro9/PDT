package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Fenomeno;
import com.exception.ServiciosException;
@Remote
public interface FenomenoBeanRemote {
	
	boolean crearFenomeno(long id,String codigo,String nombreFen,String descripcion) throws ServiciosException;
	boolean modificarFenomeno(long id, String codigo, String nombreFen,String descripcion) throws ServiciosException;
	boolean EliminarFenomeno(long codigo) throws ServiciosException;
	 List<Fenomeno> existecodigo(String codigo)throws ServiciosException;
	 List<Fenomeno> Obtenertodoslosfenomenos();
	 

}
