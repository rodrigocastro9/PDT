
package com.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;





@Entity
@Table(name = "FENOMENO")
public class Fenomeno implements Serializable{

    public Fenomeno() {
        
    }
    
    private static final long serialVersionUID = 1L;
 
    @Id
	@SequenceGenerator(name="secuenciafenomeno",sequenceName="SEQ_CODIGOFENOMENO", initialValue=1, allocationSize=100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuenciafenomeno")
	@Column(name="CODIGO_FEN")
    private long id;
    @Column(name="CODIGO",length=40, nullable=true)
    private String codigo;
    @Column(name="NOMBRE_FEN", length=40, nullable=true)
    private String nombreFen;
    @Column(name="DESCRIPCION", length=100, nullable=true)
    private String descripcion;  
    
    @ManyToOne (optional=false)
    @JoinColumn (name="ID_TEL")
    private Telefono telefonos;
    
    
 
    


	public Fenomeno(long id, String codigo, String nombreFen, String descripcion, Telefono telefonos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombreFen = nombreFen;
		this.descripcion = descripcion;
		this.telefonos = telefonos;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreFen() {
		return nombreFen;
	}
	public void setNombreFen(String nombreFen) {
		this.nombreFen = nombreFen;
	}


	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Telefono getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(Telefono telefonos) {
		this.telefonos = telefonos;
	}



}
