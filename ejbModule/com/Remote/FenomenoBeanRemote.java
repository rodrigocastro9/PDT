package com.Remote;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Fenomeno;
import com.exception.ServiciosException;
@Remote
public interface FenomenoBeanRemote {
	
	boolean crearFenomeno(long codigo,String nombreFen,String descripcion) throws ServiciosException;
	boolean modificarFenomeno(long codigo,String nombreFen,String descripcion) throws ServiciosException;
	boolean EliminarFenomeno(long codigo,String nombreFen,String descripcion) throws ServiciosException;
	 List<Fenomeno> Obtenertodoslosfenomenos();

}
