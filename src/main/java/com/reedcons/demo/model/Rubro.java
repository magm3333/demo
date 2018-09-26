package com.reedcons.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rubro {

	@Id
	@GeneratedValue
	private int id;
	private String rubro;
	
	@JsonIgnore
	@OneToMany(mappedBy="rubro")
	private List<Producto> productos;
	
	
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
}
