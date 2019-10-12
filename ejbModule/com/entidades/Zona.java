package com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ZONA")
public class Zona implements Serializable {
	
	public Zona() {

	}
	
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="ID_ZONA")
	private long id;
	@Column(name="NOMBRE_ZONA",length=(40),nullable=false)
	private String nombre_zona;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_zona() {
		return nombre_zona;
	}
	public void setNombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}
	
	public Zona(long id, String nombre_zona){
		this.id = id;
		this.nombre_zona = nombre_zona;
}

	

}
