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
 * Session Bean implementation class Departamento
 */
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {
	
	@Id
	@Column(name="id_localidad")
	private long id_localidad;
	
	@Column(name="nombre_dep")
	private String nombre_dep;
	
	@OneToMany 
	private private List<Zona> zona = new ArrayList<>(); //Crear una nueva clase llamada Zona con los atributos de zona....
	
	public Departamento() {

	}
	public Departamento(long id_localidad, String nombre_dep,List<Zona>zona){
			this.id_localidad = id_localidad;
			this.nombre_dep = nombre_dep;
			this.zona = zona;	
    }
	public long getId_localidad() {
		return id_localidad;
	}
	public void setId_localidad(long id_localidad) {
		this.id_localidad = id_localidad;
	}
	public String getNombre_dep() {
		return nombre_dep;
	}
	public void setNombre_dep(String nombre_dep) {
		this.nombre_dep = nombre_dep;
	}
	public List<Zona> getzona() {
		return zona;
	}
	public void setzona(List<Zona> zona) {
		this.zona= zona;
	}


}
