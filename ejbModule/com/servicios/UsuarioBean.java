//UsuarioBean
package com.servicios;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import com.entidades.*;
import com.exception.ServiciosException;
import com.Remote.UsuarioRemote;
import com.dao.Usuariodao;


@Stateless
@LocalBean
public class UsuarioBean implements UsuarioRemote {


	@EJB 
	private Usuariodao usuariodao;
	Usuario usu = new Usuario();
	public UsuarioBean()
	{}
	@Override
	public boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario)throws ServiciosException
	{
		boolean pudeCrear;
		usu= new Usuario(id, pass, usuario, nombre, apellido, estado, tipodoc ,numerodoc, direccion, mail, tipousuario);
		try {
			this.usuariodao.AgregarUsuario(usuario, id); 
			pudeCrear = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pudeCrear = false;
		}

		return pudeCrear;

	}
	@Override
	public boolean ModificarUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario)throws ServiciosException
	{
		boolean pudeModificar;
		usu= new Usuario(id, pass, usuario, nombre, apellido, estado, tipodoc ,numerodoc, direccion, mail, tipousuario);
		try {
			this.usuariodao.Modificarusuario(usu);
			pudeModificar=true;
		}catch(PersistenceException e)
		{
			System.out.print("No se pudo actualizar el usuario.");
			pudeModificar=false;
		}
		return pudeModificar;
	}

	@Override
	public boolean EliminarUsuario(long id) throws ServiciosException{
		boolean pudeEliminar;
		try {
			this.usuariodao.EliminarUsuario(id);
			pudeEliminar=true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			pudeEliminar=false;
		}
		return pudeEliminar;
	}
	
	public List<Usuario> ObtenerUsuarioYPass (String usuario, String pass)
	{
		return usuariodao.ObtenerUsuarioYPass(usuario, pass);
	}

	public  List<TipoUsuario> ObtenerTipoUsu ()
	{
		return usuariodao.ObtenerTipoUsu();
	}

	public List<Usuario> obtenerusuarios()
	{
		return usuariodao.obtenerusuarios();
	}





}

