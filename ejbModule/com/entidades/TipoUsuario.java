package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoUsuario
 *
 */
@Entity

public class TipoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TipoUsuario() {
		super();
	}
	
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_TIPO")
    private Long id;
    @Column(name="NOMBRE", length=50, nullable=true)
    private String nombre;

    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public TipoUsuario(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

    
   
}
