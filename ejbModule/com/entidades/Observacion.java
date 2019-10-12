package com.entidades;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Observacion
 *
 */
@Entity
@Table(name = "OBSERVACIONES")
public class Observacion implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public Observacion() {
		super();
	}
	
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_OBSERVACION")
    private long id;
    @ManyToOne (optional=false)
	private Usuario usuario; 
    @ManyToOne (optional=false)
	private Fenomeno fenomeno; 
    @ManyToOne (optional=false)
	private Localidad localidad; 
    @Column(name="DESCRIPCION", length=(50), nullable=false)
	private String descripcion;
    @Column(name="IMAGEN")
	private File imagen;
    @Column(name="LATITUD",length=(50),nullable=false)
	private float latitud;
	@Column(name="LONGITUD",length=(50),nullable=false)
	private float longitud;
	@Column(name="ALTITUD",length=(50),nullable=false)
	private String altitud;
	@ManyToOne (optional=false)
	private Estado estado;
    @Column(name="FECHAHORA", nullable=true)
    private Date fecha;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Fenomeno getFenomeno() {
		return fenomeno;
	}
	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public File getImagen() {
		return imagen;
	}
	public void setImagen(File imagen) {
		this.imagen = imagen;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Observacion(long id, Usuario usuario, Fenomeno fenomeno, Localidad localidad, String descripcion,
			File imagen, float latitud, float longitud, String altitud, Estado estado, Date fecha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fenomeno = fenomeno;
		this.localidad = localidad;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.estado = estado;
		this.fecha = fecha;
	}
    
    
}
