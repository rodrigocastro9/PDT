package com.Remote;

import java.util.List;
import javax.ejb.Remote;
import com.entidades.TipoUsuario;
import com.entidades.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {
	
	boolean CrearUsuario(Long id,String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail, String tipousuario)throws ServiciosException;

	boolean EliminarUsuario(Long usuario) throws ServiciosException;
	
	boolean ModificarUsuario(Long id,String nombre, String apellido, String tipoDoc, String NumDoc, String direccion, String correo,
			String password, String estado, TipoUsuario tipoUsuario)throws ServiciosException;
	
<<<<<<< Updated upstream
	
	//Obtener tipo de usuario por id
	TipoUsuario ObtenerTipoUsu(Long id);
	
	//Login de usuario
     List<Usuario> Login (String usuario, String pass);
=======
    List<Usuario> Login (String usuario, String pass);
>>>>>>> Stashed changes
    
	Usuario existeUsuario(String usu)throws ServiciosException;
	


}
