package com.entidades;

import java.io.Serializable;
import java.util.Date;

public class PK_ExRevisaObs  implements Serializable{
	
    private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private Observacion observacion;
	
	private Date fecha;

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public PK_ExRevisaObs(Usuario usuario, Observacion observacion, Date fecha) {
		super();
		this.usuario = usuario;
		this.observacion = observacion;
		this.fecha = fecha;
	}
	
	
	

}
