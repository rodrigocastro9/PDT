package com.servicios;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import com.Remote.FenomenoBeanRemote;
import com.dao.Fenomenodao;
import com.entidades.Fenomeno;
import com.entidades.Telefono;
import com.exception.ServiciosException;



@Stateless
@LocalBean
public class FenomenoBean implements FenomenoBeanRemote {
	
	@EJB
	private Fenomenodao fenomenodao;
	public FenomenoBean() 
	{}
	//Fenomeno fenomeno= new Fenomeno();
	
	@Override
	public boolean crearFenomeno(long id,String codigo,String estado, String nombreFen,String descripcion,String nombre) throws ServiciosException
	{
		boolean pudecrear;
		Telefono tels = (Telefono) fenomenodao.obtenertelefonoemergencia(nombre);
		
		
		Fenomeno fenomeno =new Fenomeno(id,codigo,estado,nombreFen,descripcion, tels);
		try
		{
			this.fenomenodao.AgregarFenomeno(fenomeno);
			pudecrear=true;
		}catch(PersistenceException e)
		{
			System.out.println("Falla el insert al querer insertar ");
			
			pudecrear=false;
		}
		return pudecrear;
	} 
	@Override
	public boolean modificarFenomeno(long id, String codigo,String estado,String nombreFen,String descripcion,String tel) throws ServiciosException
	{
		
		List<Telefono> tels = fenomenodao.obtenertelefonoemergencia(tel);
		Telefono telefono= (Telefono) tels;
		
		boolean pudeModificar;
		fenomenodao.existeFenomeno(codigo);
		
		Fenomeno fenomeno= new Fenomeno();
			fenomeno.setCodigo(codigo);
			fenomeno.setEstado(estado);
			fenomeno.setDescripcion(descripcion);
			fenomeno.setNombreFen(nombreFen);
			fenomeno.setTelefonos(telefono);
			
			
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
	public List<Fenomeno> existecodigo(String codigo)throws ServiciosException {

    	   	 List<Fenomeno> fenomeno = this.fenomenodao.existeFenomeno(codigo);
	    	 return fenomeno;
    }
	
	@Override
	public boolean EliminarFenomeno(long codigo) throws ServiciosException
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

	@Override
	public List<Telefono> obtenerTelEmergencia(){
		List<Telefono> TelE= fenomenodao.obtenerTelEmergencia();
		return TelE;
	}


	
	
	
	
	
}
