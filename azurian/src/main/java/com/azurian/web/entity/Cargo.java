package com.azurian.web.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.azurian.web.entity.Persona;


@Entity
@Table(name = "cargo")
public class Cargo implements java.io.Serializable {

	private int id;
	private String descripcion;
	private Set<Persona> personas = new HashSet<Persona>(0);

	public Cargo() {
	}


	public Cargo(String descripcion, Set<Persona> personas) {
		this.descripcion = descripcion;
		this.personas = personas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name ="descripcion", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}


	@Override
	public String toString() {
		return "Cargo [id=" + id + ", descripcion=" + descripcion + ", personas=" + personas + "]";
	}
	
	
	

}
