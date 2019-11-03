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

	boolean EliminarUsuario(Long usuario) throws ServiciosException;
	
	boolean ModificarUsuario(Long id,String nombre, String apellido, String tipoDoc, String NumDoc, String direccion, String correo,
			String password, String estado, TipoUsuario tipoUsuario)throws ServiciosException;
	
	
	//Obtener tipo de usuario por id
	TipoUsuario ObtenerTipoUsu(Long id);
	
	//Login de usuario
    List<Usuario> Login (String usuario, String pass);
    
    //Validar la existencia de un usuario por su cedula
	Usuario existeUsuario(String usu)throws ServiciosException;
	
	//Listar todos los tipos de usuario
	//List <TipoUsuario> obtenerTodoslosTipos();

	//Listar todos los usuarios
	List<Usuario> obtenerusuarios();


}
