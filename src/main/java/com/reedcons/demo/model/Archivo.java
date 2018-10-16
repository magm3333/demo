package com.reedcons.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Archivo(int id, String nombre, long length, String mime) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.length = length;
		this.mime = mime;
	}

	private String nombre;
	private long length;
	@Column(length = 50)
	private String mime;
	@Transient
	private String downloadUri;
	@JsonIgnore
	@Lob
	private byte[] contenido;
	
	
	// SGBD    -->   BACKEND(REST)    --> FRONTEND
	
	public Archivo() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getDownloadUri() {
		return downloadUri;
	}

	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}

	public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}



}
