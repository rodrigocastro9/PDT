package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Localidad
 *
 */
@Entity
@Table(name = "LOCALIDAD")
public class Localidad implements Serializable {


	public Localidad() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="secuencialoc",sequenceName="SEQ_IDLOCALIDAD", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuencialoc")// ver como funciona los trigger.
	@Column(name="ID_LOCALIDAD")
	private long id;
	@ManyToOne (optional=false)
    @JoinColumn (name="ID_DEPARTAMENTO")
	private Departamento departamento; 
	@Column(name="NOMBRE_LOC",length=(40),nullable=false)
	private String nombreLoc;
	@Column(name="LATITUD",length=(50),nullable=false)
	private float latitud;
	@Column(name="LONGITUD",length=(50),nullable=false)
	private float longitud;
	@Column(name="ALTITUD",length=(50),nullable=false)
	private String altitud;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getNombreLoc() {
		return nombreLoc;
	}
	public void setNombreLoc(String nombreLoc) {
		this.nombreLoc = nombreLoc;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public String getAltitud() {
		return altitud;
	}
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	public Localidad(long id, Departamento departamento, String nombreLoc, float latitud, float longitud,
			String altitud) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.nombreLoc = nombreLoc;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
	}

}


