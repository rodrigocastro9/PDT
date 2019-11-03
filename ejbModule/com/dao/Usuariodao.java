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
	
		
	public void AgregarUsuario(Usuario usuario, TipoUsuario tipousuario) throws Exception 
		{
		try {
			Usuario usu = new Usuario();
			usu.setTipousuario(em.find(TipoUsuario.class,tipousuario));
			em.merge(usuario);
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
	    	TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.Usuario LIKE :nombre AND u.PASS LIKE :pass",Usuario.class)
					.setParameter("nombre", usuario)
					.setParameter("pass",pass);
			return query.getResultList();
	    	
	    }
    
    //Metodo para obtener el tipo de usuario a partir de un id
    public TipoUsuario ObtenerTipoUsu (long id){
	    	TypedQuery<TipoUsuario> query = em.createQuery("SELECT u FROM tiposusuarios u.id_tipo like :id_tipo", TipoUsuario.class)
	    			.setParameter("id_tipo",id);
			return query.getResultList().get(0);

	    }
	        
    //Metodo para listar todos los usuarios
	public List<Usuario> obtenerusuarios()
	    {
	    	TypedQuery<Usuario> query = em.createQuery("SELECT U FROM Usuario U",Usuario.class);
	    	
	    	return query.getResultList();
	    }
	
    //Metodo para determinar id a partir de un usuario
    public Long BuscarUsuario(String usu) {
    	
    	Usuario u1 = new Usuario();
    	
		 TypedQuery<Usuario> query = em.createQuery("SELECT U FROM Usuario U WHERE U.Usuario LIKE : usu", Usuario.class)
				 .setParameter("usu",usu);
    	 
		 u1 = query.getSingleResult();
		 
    	return u1.getId();

}
	
    //Metodo para listar todos los tipos de usuario
    /*public List<TipoUsuario> obtenerTodoslosTipos() {
			TypedQuery<TipoUsuario> query = this.em.createQuery("select T from TIPOSUSUARIOS T", TipoUsuario.class);

			return query.getResultList();
		}*/

    //Validar existencia de usuario por numero de cedula
	public Usuario existeUsuario(String usu) {	
	
		Usuario u = new Usuario();
	 TypedQuery<Usuario> query = em.createQuery("SELECT U FROM Usuario U WHERE U.usuario LIKE : Usuario",Usuario.class).setParameter("Usuario",usu);
    	
	 	u=(Usuario) query.getSingleResult();
	 	if (u!=null)
	 		return u;
	 	else {
    	return null;
	 	}
}
	  
	
}

		

		
	
		
		
	


