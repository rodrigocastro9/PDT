package com.Remote;

import java.util.List;
import javax.ejb.Remote;
import com.entidades.TipoUsuario;
import com.entidades.Usuario;


@Remote
public interface UsuarioRemote {
	
	boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,

			String numerodoc, String direccion, String mail, TipoUsuario tipousuario);



	
    List<Usuario> ObtenerUsuarioYPass (String usuario, String pass);
    List<Usuario> ObtenerTipoUsu (String usuario, String pass);

}
