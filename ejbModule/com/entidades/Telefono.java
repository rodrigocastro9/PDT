


package com.entidades;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Stateless
@LocalBean

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
    private Long id;
    @Column(name="NUMERO", length=20, nullable=true)
    private String numero;
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	public Telefono(Long id, String numero ) {
		super();
		this.id = id;
		this.numero = numero;
	
	}

}
