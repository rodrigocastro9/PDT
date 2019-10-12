


package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Stateless
@LocalBean


@Entity
@Table(name = "FENOMENO")
public class Fenomeno implements Serializable{

    public Fenomeno() {
        // TODO Auto-generated constructor stub
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="CODIGO_FEN")
    private Long codigo;
    @Column(name="NOMBRE_FEN", length=40, nullable=true)
    private String nombreFen;
    @Column(name="DESCRIPCION", length=100, nullable=true)
    private String descripcion;  

    @OneToMany
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "TELEFONOS")
    private ArrayList<Telefono> telefonos;

    @OneToMany
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "OBSERVACIONES")
    private List<Observacion> observaciones = new ArrayList<>(); 
    
    @OneToMany
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "CARACTERISTICAS")
    private List<Caracteristica> caracteristicas = new ArrayList<>(); 
    
	public Long getCodigo() {
		return codigo;
	}

	public List<Observacion> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<Observacion> observaciones) {
		this.observaciones = observaciones;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombreFen() {
		return nombreFen;
	}

	public void setNombreFen(String nombreFen) {
		this.nombreFen = nombreFen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Fenomeno(Long codigo, String nombreFen, String descripcion, ArrayList<Telefono> telefonos) {
		super();
		this.codigo = codigo;
		this.nombreFen = nombreFen;
		this.descripcion = descripcion;
		this.telefonos = telefonos;
	}
    
    
    
    
}
