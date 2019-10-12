package com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {
	
	
    private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="ID_DEPARTAMENTO")
	private long id;
	
	@Column(name="NOMBRE_DEP", length=(40), nullable=false)
	private String nombreDep;
	@ManyToOne (optional=false)
	private Zona zona; 
	
	
	public Departamento() {

	}
	
	public long getId_localidad() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreDep() {
		return nombreDep;
	}
	public void setNombreDep(String nombreDep) {
		this.nombreDep = nombreDep;
	}
	

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Departamento(long id, String nombreDep,Zona zona){
		this.id= id;
		this.nombreDep = nombreDep;
		this.zona = zona;	
}

}
