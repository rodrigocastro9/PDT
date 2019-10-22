package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "DETALLE")
@IdClass(PK_Detalle.class)
public class Detalle implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Detalle() {
		super();
	}
    
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_CARACT")
	private Caracteristica caracteristica;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_OBSERVACION")
	private Observacion observacion;
	
	    @Column(name="FECHORA", nullable=true)
	    private Date fecha;
	    
	    @Column(name="VALORNUM", length=10, nullable=true)
	    private int valorNum;
	    
	    @Column(name="VALORTEXTO", length=40, nullable=true)
	    private String valorText;

		

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public int getValorNum() {
			return valorNum;
		}

		public void setValorNum(int valorNum) {
			this.valorNum = valorNum;
		}

		public String getValorText() {
			return valorText;
		}

		public void setValorText(String valorText) {
			this.valorText = valorText;
		}
		
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

		
		public Detalle(Date fecha, int valorNum, String valorText) {
			super();
			this.fecha = fecha;
			this.valorNum = valorNum;
			this.valorText = valorText;
		}
	
}
