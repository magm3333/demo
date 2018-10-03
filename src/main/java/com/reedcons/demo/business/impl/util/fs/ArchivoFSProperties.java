package com.reedcons.demo.business.impl.util.fs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="archivo")
public class ArchivoFSProperties {

	//archivo.directorio-almacenamiento
	
	private String directorioAlmacenamiento;

	public String getDirectorioAlmacenamiento() {
		return directorioAlmacenamiento;
	}

	public void setDirectorioAlmacenamiento(String directorioAlmacenamiento) {
		this.directorioAlmacenamiento = directorioAlmacenamiento;
	}
	
}
