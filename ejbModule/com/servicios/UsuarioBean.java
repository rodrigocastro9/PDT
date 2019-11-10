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
	
	//Validar la existencia de un usuario por su cedula
	@Override
	public List<Usuario> existeUsuario(String nomUsu)throws ServiciosException  {

		
	 List<Usuario> usuarios = this.usuariodao.existeUsuario(nomUsu);
   	 return usuarios;
	}
	
	@Override
	public boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, String tipousuario)throws ServiciosException
	{
		boolean pudeCrear;
		 
		TipoUsuario tipoUsu = this.tipousuariodao.obtenertipousuario(tipousuario);
		 
		 usu = new Usuario(id,pass,usuario,nombre,apellido,estado,tipodoc,numerodoc,direccion,mail,tipoUsu);
		 
		try {
			this.usuariodao.AgregarUsuario(usu);
			pudeCrear = true;
		} catch (Exception e) {
			pudeCrear = false;
		}

		return pudeCrear;

	}
	
	@Override
	public boolean ModificarUsuario(Long id, String nombre, String apellido, String tipoDoc, String NumDoc, String direccion,
			String correo, String pass, String estado, String tipousuario)throws ServiciosException
	{
		
		TipoUsuario tipoUsu = this.tipousuariodao.obtenertipousuario(tipousuario);
		
		boolean pudeModificar;
		usu.setPass(pass);
		usu.setNombre(nombre);
		usu.setApellido(apellido);
		usu.setTipodoc(tipoDoc);
		usu.setNumerodoc(NumDoc);
		usu.setDireccion(direccion);
		usu.setMail(correo);
		usu.setTipousuario(tipoUsu);
	
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
	public boolean EliminarUsuario(Long usuario) throws ServiciosException{
		boolean pudeEliminar;
		try {
			this.usuariodao.EliminarUsuario(usuario);
			pudeEliminar=true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			pudeEliminar=false;
		}
		return pudeEliminar;
	}
	
	@Override
	public List<Usuario> Login (String usuario, String pass)
	{
		return usuariodao.Login(usuario, pass);
	}

}

