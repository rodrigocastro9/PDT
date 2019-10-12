//usuario
package com.entidades;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Session Bean implementation class Usuario
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	
	@SequenceGenerator(name="SEQ_USUARIOID", initialValue=1, allocationSize=100)
	private static final long serialVersionUID = 1L;
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIOID"  )// ver como funciona los trigger.
    @Column(name="ID_USUARIO")
    private Long id;
    @Column(name="PASS", length=30, nullable=true)
    private String pass;
    @Column(name="USUARIO", length=80, nullable=true)
    private String usuario;
    @Column(name="NOMBRE", length=50, nullable=true)
    private String nombre;
    @Column(name="APELLIDO", length=50, nullable=true)
    private String apellido;
    @Column(name="ESTADO", length=50, nullable=true)
    private String estado;
    @Column(name="TIPODOC", length=50, nullable=true)
    private String tipodoc;
    @Column(name="NUMERODOC", length=50, nullable=true)
    private String numerodoc;
    @Column(name="DIRECCION", length=50, nullable=true)
    private String direccion;
    @Column(name="MAIL", length=50, nullable=true)
    private String mail;
    
    //TEngo que crear la relacuon con tipo de usuario-
    
    @ManyToOne (optional=false)
    private TipoUsuario tipousuario;
    
        
    
    
    
    
    

	public Usuario(Long id, String pass, String usuario, String nombre, String apellido, String estado, String tipodoc,
			String numerodoc, String direccion, String mail) {
		super();
		this.id = id;
		this.pass = pass;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
		this.tipodoc = tipodoc;
		this.numerodoc = numerodoc;
		this.direccion = direccion;
		this.mail = mail;
	}
    
	public TipoUsuario getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}
	public String getNumerodoc() {
		return numerodoc;
	}
	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", pass=" + pass + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido="
				+ apellido + ", estado=" + estado + ", tipodoc=" + tipodoc + ", numerodoc=" + numerodoc + ", direccion="
				+ direccion + ", mail=" + mail + "]";
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
