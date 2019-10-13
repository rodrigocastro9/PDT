package com.Remote;

import javax.ejb.Remote;

@Remote
public interface UsuarioRemote {
	
	boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail);

}
