package com.Remote;

import javax.ejb.Remote;

import com.entidades.TipoUsuario;

@Remote
public interface UsuarioRemote {
	
	boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario);

}
