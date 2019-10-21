


package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TELEFONO")
public class Telefono implements Serializable{

    public Telefono() {
        // TODO Auto-generated constructor stub
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="ID_TEL")
    private long id;
    @Column(name="NUMERO", length=20, nullable=true)
    private String numero;
    @ManyToOne (optional=false)
    @JoinColumn (name="CODIGO_FEN")
    private Fenomeno fenomeno;
   
	public Fenomeno getFenomeno() {
		return fenomeno;
	}
	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	public Telefono(long id, String numero, Fenomeno fenomeno ) {
		super();
		this.id = id;
		this.numero = numero;
		this.fenomeno = fenomeno;
	
	}

}
