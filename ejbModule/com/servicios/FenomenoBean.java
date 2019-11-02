package com.servicios;

import java.util.List;

import javax.ejb.EJB;

import com.Remote.FenomenoBeanRemote;
import com.dao.Fenomenodao;
import com.entidades.Fenomeno;
import com.exception.ServiciosException;

public class FenomenoBean implements FenomenoBeanRemote {
	
	@EJB
	private Fenomenodao fenomenodao;
	public FenomenoBean() 
	{}
	Fenomeno fenomeno= new Fenomeno();
	
	@Override
	public boolean crearFenomeno(long codigo,String nombreFen,String descripcion) throws ServiciosException
	{
		boolean pudecrear;
		fenomeno =new Fenomeno(codigo,nombreFen,descripcion);
		try
		{
			this.fenomenodao.AgregarFenomeno(fenomeno);
			pudecrear=true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			pudecrear=false;
		}
		return pudecrear;
	} 
	@Override
	public boolean modificarFenomeno(long codigo,String nombreFen,String descripcion) throws ServiciosException
	{
		boolean pudeModificar;
		fenomenodao.obtenerfenomenoporcodigo(codigo);
		fenomeno.setDescripcion(descripcion);
		fenomeno.setNombreFen(nombreFen);
		 
		
		try
		{
			this.fenomenodao.ModificarFenomeno(fenomeno);
			pudeModificar=true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			pudeModificar=false;
		}
		return pudeModificar;
	} 
	@Override
	public boolean EliminarFenomeno(long codigo,String nombreFen,String descripcion) throws ServiciosException
	{
		boolean pudeborrar;
		try
		{
			this.fenomenodao.BorrarFenomeno(codigo);
			pudeborrar=true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			pudeborrar=false;
		}
		return pudeborrar;
	} 
	@Override
	public List<Fenomeno> Obtenertodoslosfenomenos()
	{
		return this.fenomenodao.obtenerfenomenos();
	}
	
}
