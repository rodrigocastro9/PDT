package com.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.*;





@Stateless
public class Usuariodao {

	
		@PersistenceContext
		private EntityManager em;
	
		
	public void AgregarUsuario(Usuario usuario) throws Exception 
		{
		try {
			
			em.persist(usuario);
			em.flush();
				
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer consultar el usuario.");
		}
		}
	
	public void Modificarusuario(Usuario usuario)
	{
		try {
			em.merge(usuario);
			em.flush();
		}catch(PersistenceException e)
		{
			System.out.println ("Error al querer modificar el usuario.");
		}
	}
		
	public void EliminarUsuario (Long usuario)
	{
		try 
		{
			Usuario usu = em.find(Usuario.class,usuario);
					em.remove(usu);
					em.flush();
		}catch(PersistenceException e) 
		{

			System.out.println ("No se pudo eliminar el usuario.");
		}
	}
	
	//Metodo para el login de usuario
    public List<Usuario> Login (String usuario, String pass){
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.USUARIO LIKE :nombre AND u.PASS LIKE :pass",Usuario.class)
					.setParameter("nombre", usuario)
					.setParameter("pass",pass);
			return query.getResultList();
	    	
	    }
    
    //Metodo para obtener el tipo de usuario a partir de un id
    public TipoUsuario ObtenerTipoUsu (long id){
	    	TypedQuery<TipoUsuario> query = em.createQuery("SELECT u FROM TIPOSUSUARIOS u.id_tipo like :id", TipoUsuario.class)
	    			.setParameter("id",id);
			return query.getResultList().get(0);

	    }
	        
    //Metodo para listar todos los usuarios
	public List<Usuario> obtenerusuarios()
	    {
	    	TypedQuery<Usuario> query = em.createQuery("SELECT U FROM USUARIO U",Usuario.class);
	    	
	    	return query.getResultList();
	    }
	
    //Metodo para determinar id a partir de un numero de documento o un usuario
    public Long NumeroDocUsuario(String usu) {
    	
    	Usuario u1 = new Usuario();
    	
		 TypedQuery<Usuario> query = em.createQuery("SELECT U FROM USUARIO U WHERE U.USUARIO LIKE : usu OR U.NUMERODOC LIKE : usu",Usuario.class);
    	
		 u1 = query.getSingleResult();
		 
    	return u1.getId();

}
	
    //Metodo para listar todos los tipos de usuario
    public List<TipoUsuario> obtenerTodoslosTipos() {
			TypedQuery<TipoUsuario> query = this.em.createQuery("select T from TIPOSUSUARIOS T", TipoUsuario.class);
			return query.getResultList();
		}

    //Validar existencia de usuario por numero de cedula
	public boolean existeUsuario(String usu) {	
	boolean existe = true;
	
	 TypedQuery<Usuario> query = em.createQuery("SELECT U FROM USUARIO U WHERE U.USUARIO LIKE : usu",Usuario.class);
    	
	 if (query != null)
		 {
		 existe = true;
		 }
	 else {
		 existe = false;
	 }
		 
    	return existe;

}
	  
	
}

		

		
	
		
		
	


