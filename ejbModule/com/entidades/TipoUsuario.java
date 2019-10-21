package com.entidades;

import java.io.Serializable;
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
    private long id;
    @Column(name="NOMBRE", length=50, nullable=true)
    private String nombre;

    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public TipoUsuario(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

    
   
}
