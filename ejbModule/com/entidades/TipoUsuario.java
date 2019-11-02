package com.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name = "TIPOSUSUARIOS")

public class TipoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TipoUsuario() {
		super();
	}
	
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_TIPO")
    private long idtipousu;
    @Column(name="NOMBRE", length=50, nullable=true)
    private String nombre;

    
	@OneToMany(mappedBy="tipousuario")
	private List<Usuario> usuarios;
    
    
	public long getId() {
		return idtipousu;
	}
	public void setId(long id) {
		this.idtipousu = idtipousu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public TipoUsuario(long id, String nombre) {
		super();
		this.idtipousu = idtipousu;
		this.nombre = nombre;
	}

    
   
}
