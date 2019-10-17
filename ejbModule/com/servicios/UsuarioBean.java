//UsuarioBean
package com.servicios;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.entidades.*;
import com.Remote.UsuarioRemote;
import com.dao.Usuariodao;


@Stateless
@LocalBean
public class UsuarioBean implements UsuarioRemote {

<<<<<<< Updated upstream
@EJB 
private Usuariodao usuariodao;

public UsuarioBean()
{}

public boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
		String numerodoc, String direccion, String mail, TipoUsuario tipousuario)
{
	boolean pudeCrear;
	Usuario usuarionuevo= new Usuario(id, pass, usuario, nombre, apellido, estado, tipodoc ,numerodoc, direccion, mail, tipousuario);
	try {
		this.usuariodao.AgregarUsuario(usuarionuevo, 1l);
		pudeCrear = true;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		pudeCrear = false;
	}

	return pudeCrear;
	
=======
	@EJB 
	private Usuariodao usuariodao;

	public UsuarioBean()
	{}

	public boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail)
	{
		boolean pudeCrear;
		Usuario usuarionuevo= new Usuario(id, pass, usuario, nombre, apellido, estado, tipodoc ,numerodoc, direccion, mail );
		try {
			this.usuariodao.AgregarUsuario(usuarionuevo, 1l);
			pudeCrear = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pudeCrear = false;
		}

		return pudeCrear;

	}
	/*@Override
public String toString() {
	return "Usuario [id=" + id + ", pass=" + pass + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido="
			+ apellido + ", estado=" + estado + ", tipodoc=" + tipodoc + ", numerodoc=" + numerodoc + ", direccion="
			+ direccion + ", mail=" + mail + "]";
>>>>>>> Stashed changes
}


	@Override
	public List<Usuario> ObtenerUsuarioYPass(String usuario, String pass) {

		return this.usuariodao.ObtenerUsuarioYPass(usuario, pass);
	}


	@Override
	public List<Usuario> ObtenerTipoUsu(String usuario, String pass){
		return this.usuariodao.ObtenerTipoUsu(usuario, pass);
	}


}
