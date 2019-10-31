package com.Remote;

import java.util.List;
import javax.ejb.Remote;
import com.entidades.TipoUsuario;
import com.entidades.Usuario;
import com.exception.ServiciosException;


@Remote
public interface UsuarioBeanRemote {
	
	boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario)throws ServiciosException;

	boolean EliminarUsuario(long id) throws ServiciosException;
	
	boolean ModificarUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario)throws ServiciosException;

	TipoUsuario ObtenerTipoUsu(Long id);
	
    List<Usuario> Login (String usuario, String pass);
}
