package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;






@Entity
@Table(name = "DETALLE")
public class Detalle implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Detalle() {
		super();
	}
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CARACT")
	private Caracteristica caracteristica;
	
	
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
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		
		public Detalle(long id, Date fecha, int valorNum, String valorText) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.valorNum = valorNum;
			this.valorText = valorText;
		}
	    
	    
   
}
