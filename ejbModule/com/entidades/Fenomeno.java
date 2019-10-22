
package com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private long codigo;
    @Column(name="NOMBRE_FEN", length=40, nullable=true)
    private String nombreFen;
    @Column(name="DESCRIPCION", length=100, nullable=true)
    private String descripcion;  
    
	public long getCodigo() {
		return codigo;
	}

	
	public void setCodigo(long codigo) {
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

	public Fenomeno(long codigo, String nombreFen, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombreFen = nombreFen;
		this.descripcion = descripcion;	
	}
      
}
