package com.azurian.web.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona implements java.io.Serializable {

	private int ids;
	private Cargo cargo;
	private String rut;
	private String nombre;
	private int edad;

	public Persona() {
	}

	
	
	
	
	
	public Persona(int ids, Cargo cargo, String rut, String nombre, int edad) {
		super();
		this.ids = ids;
		this.cargo = cargo;
		this.rut = rut;
		this.nombre = nombre;
		this.edad = edad;
	}


	public Persona(Cargo cargo, String rut, String nombre, int edad) {
		super();
		this.ids = this.getIds();
		this.cargo = cargo;
		this.rut = rut;
		this.nombre = nombre;
		this.edad = edad;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getIds() {
		return this.ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cargo")
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Column(name = "rut", unique = true, length = 30, nullable = false)
	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Column(name = "nombre", length = 100, nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "edad", nullable = false)
	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
