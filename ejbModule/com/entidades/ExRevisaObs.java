package com.entidades;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "REVISA")
public class ExRevisaObs implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public ExRevisaObs() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FECHA")
	private Long id;
	
	@Column(name="FIABILIDAD", nullable=true)
	private String Fiabilidad;
	
	@Column(name="COMENTARIOS")
	private String Comentarios;
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario caracteristica;
	
	@ManyToOne
	@JoinColumn(name = "ID_OBSERVACION")
	private Observacion observacion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Usuario caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}
	
}
