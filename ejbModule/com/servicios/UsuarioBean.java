//UsuarioBean
package com.servicios;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import com.entidades.*;
import com.exception.ServiciosException;
import com.Remote.UsuarioBeanRemote;
import com.dao.TipoUsuariodao;
import com.dao.Usuariodao;


@Stateless
@LocalBean
public  class UsuarioBean implements UsuarioBeanRemote {


	@EJB 
	private Usuariodao usuariodao;
	@EJB
	private TipoUsuariodao tipousuariodao;
	
	Usuario usu = new Usuario();
	public UsuarioBean()
	{}
	
	@Override
	public boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario)throws ServiciosException
	{
		boolean pudeCrear;
		
		 usu = new Usuario(id,pass,usuario,nombre,apellido,estado,tipodoc,numerodoc,direccion,mail,tipousuario);
		 
		try {
			
			this.usuariodao.AgregarUsuario(usu); 
			pudeCrear = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pudeCrear = false;
			usu = new Usuario();
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
	}// modificar.

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
	
	public List<Usuario> Login (String usuario, String pass)
	{
		return usuariodao.Login(usuario, pass);
	}


	public List<Usuario> obtenerusuarios()
	{
		return usuariodao.obtenerusuarios();
	}

	@Override
	public TipoUsuario ObtenerTipoUsu(Long id) {
		return usuariodao.ObtenerTipoUsu(id);
	}





}

