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
	    @GeneratedValue( strategy = GenerationType.AUTO )
	    @Column(name="ID_CARACT")
	    private Long id_caract;
	    
	    
	   /* Nose como es esto hay que verificar  
	    @Id
	    @GeneratedValue( strategy = GenerationType.AUTO )
	    @Column(name="ID_OBSERVACION")
	    private Long id_obs;
	    */
	    
	    @Column(name="FECHORA", nullable=true)
	    private Date fecha;
	    
	    @Column(name="VALORNUM", length=10, nullable=true)
	    private int valorNum;
	    
	    @Column(name="VALORTEXTO", length=40, nullable=true)
	    private String valorText;

		public Long getId_caract() {
			return id_caract;
		}

		public void setId_caract(Long id_caract) {
			this.id_caract = id_caract;
		}

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

		
		public Detalle(Long id_caract, Date fecha, int valorNum, String valorText) {
			super();
			this.id_caract = id_caract;
			this.fecha = fecha;
			this.valorNum = valorNum;
			this.valorText = valorText;
		}
	    
	    
   
}
