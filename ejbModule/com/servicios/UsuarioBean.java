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
	
}
	public List<Usuario> ObtenerUsuarioYPass (String usuario, String pass)
	{
		return usuariodao.ObtenerUsuarioYPass(usuario, pass);
	}
	
   public  List<Usuario> ObtenerTipoUsu (String usuario, String pass)
    {
    	return usuariodao.ObtenerTipoUsu(usuario, pass);
    }


}

