package com.entidades;

import java.io.Serializable;

public class PK_Detalle implements Serializable{

    private static final long serialVersionUID = 1L;

	private Caracteristica caracteristica;
	private Observacion observacion;
	
	
	public Caracteristica getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}
	public Observacion getObservacion() {
		return observacion;
	}
	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}
	
	public PK_Detalle(Caracteristica caracteristica, Observacion observacion) {
		super();
		this.caracteristica = caracteristica;
		this.observacion = observacion;
	}
	
	
}
