package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "REVISA")
@IdClass(PK_ExRevisaObs.class)
public class ExRevisaObs implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public ExRevisaObs() {
		super();
	}
	@Id
	@Column(name="FECHAYHORA")
	private Date fecha;
	
	@Column(name="FIABILIDAD", nullable=true)
	private String Fiabilidad;
	
	@Column(name="COMENTARIOS")
	private String Comentarios;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_OBSERVACION")
	private Observacion observacion;
	
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFiabilidad() {
		return Fiabilidad;
	}

	public void setFiabilidad(String fiabilidad) {
		Fiabilidad = fiabilidad;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

	public ExRevisaObs(Date fecha, String fiabilidad, String comentarios, Usuario usuario, Observacion observacion) {
		super();
		this.fecha = fecha;
		Fiabilidad = fiabilidad;
		Comentarios = comentarios;
		this.usuario = usuario;
		this.observacion = observacion;
	}
	
	
	
}
