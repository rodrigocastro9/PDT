
package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuenciafenomeno")// ver como funciona los trigger.
	@Column(name="CODIGO_FENOMENO")
    private long codigo;
    @Column(name="NOMBRE_FEN", length=40, nullable=true)
    private String nombreFen;
    @Column(name="DESCRIPCION", length=100, nullable=true)
    private String descripcion;  

    @OneToMany    // Si comentamos toda esta relacion el PDT.jar hace el deploy y funciona. si no.
    //@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "TELEFONOS")
    private ArrayList<Telefono> telefonos;

    
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

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Fenomeno(long codigo, String nombreFen, String descripcion, ArrayList<Telefono> telefonos) {
		super();
		this.codigo = codigo;
		this.nombreFen = nombreFen;
		this.descripcion = descripcion;
		this.telefonos = telefonos;
	}
      
}
