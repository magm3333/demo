package com.reedcons.demo.model;

import java.util.Date;

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


	private int id;
	private String descripcion;
	private boolean enStock;
	private double precio;
	private Date vencimiento;
	
	
}
