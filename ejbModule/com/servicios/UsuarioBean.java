//UsuarioBean
package com.servicios;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.entidades.*;
import com.remote.UsuarioRemote;
import com.dao.UsuarioDao;


@Stateless
@LocalBean
public class UsuarioBean implements UsuarioRemote {

@EJB 
private UsuarioDao usuariodao;

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
		// ca va el cofigo se falla el insert
		pudeCrear = false;
	}

	
	
	
	
	
	return pudeCrear;
	
}
/*@Override
public String toString() {
	return "Usuario [id=" + id + ", pass=" + pass + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido="
			+ apellido + ", estado=" + estado + ", tipodoc=" + tipodoc + ", numerodoc=" + numerodoc + ", direccion="
			+ direccion + ", mail=" + mail + "]";
}

	}*/

}
