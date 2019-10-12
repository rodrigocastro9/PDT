package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Session Bean implementation class ZONA
 */
@Entity
@Table(name = "ZONA")
public class Zona implements Serializable {
	@Id
	@Column(name="id_zona", length=(50))
	private long id_zona;
	
	@Column(name="nombre_zona",length=(40),nullable=false)
	private String nombre_zona;
	
	public Zona() {

	}
	public Zona(long id_zona, String nombre_zona){
			this.id_zona = id_zona;
			this.nombre_zona = nombre_zona;
	}
	public long getId_zona() {
		return id_zona;
	}
	public void setId_zona(long id_zona) {
		this.id_zona = id_zona;
	}
	public String getNombre_zona() {
		return nombre_zona;
	}
	public void setNombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}

}
