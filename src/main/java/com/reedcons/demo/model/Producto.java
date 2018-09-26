package com.reedcons.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Producto {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEnStock() {
		return enStock;
	}
	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	public Producto() {
	}
	
	
	public Producto(int id, String descripcion, boolean enStock, double precio, Date vencimiento) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.enStock = enStock;
		this.precio = precio;
		this.vencimiento = vencimiento;
	}


	@Id
	@GeneratedValue
	private int id;
	
	private String descripcion;
	@Column(columnDefinition="TINYINT")
	private boolean enStock;
	private double precio;
	private Date vencimiento;
	private boolean enOferta;
	public boolean isEnOferta() {
		return enOferta;
	}
	public void setEnOferta(boolean enOferta) {
		this.enOferta = enOferta;
	}
	
	@ManyToOne
	@JoinColumn(name="idRubro",nullable=true)
	private Rubro rubro;
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	
}
