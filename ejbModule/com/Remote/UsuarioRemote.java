package com.Remote;

import java.util.List;

import javax.ejb.Remote;

<<<<<<< Updated upstream
import com.entidades.TipoUsuario;
=======
import com.entidades.Usuario;
>>>>>>> Stashed changes

@Remote
public interface UsuarioRemote {
	
	boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
<<<<<<< Updated upstream
			String numerodoc, String direccion, String mail, TipoUsuario tipousuario);

=======
			String numerodoc, String direccion, String mail);
	
    List<Usuario> ObtenerUsuarioYPass (String usuario, String pass);
    List<Usuario> ObtenerTipoUsu (String usuario, String pass);
>>>>>>> Stashed changes
}
