package com.reedcons.demo.business.impl.util.fs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivoFSService {
	
	private final Path localizacionAlmacenamiento;
	
	@Autowired
	public ArchivoFSService(ArchivoFSProperties archivoFSProperties) {
		this.localizacionAlmacenamiento=Paths.get(archivoFSProperties.getDirectorioAlmacenamiento()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.localizacionAlmacenamiento);
		} catch (IOException e) {
			throw new ArchivoFSException("No se ha podido crear la carpeta de descarga de archivos en: "+this.localizacionAlmacenamiento);
		}
	}
	

	public String almacenarArchivo(MultipartFile file) throws ArchivoFSException {
		String nombreArchivo =StringUtils.cleanPath(file.getOriginalFilename());
		if(nombreArchivo.contains("..")) {
			throw new ArchivoFSException("El nombre del archivo contiene caracteres incorrectos");
		}
		// /home/mariano/workspace-reedcons/demo/subidos/pepe.jpg
		Path destino=this.localizacionAlmacenamiento.resolve(nombreArchivo);
		try {
			Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
			return nombreArchivo;
		} catch (IOException e) {
			throw new ArchivoFSException("No se ha podido copiar el archivo al destino: "+destino.toString());
		}
	}
	
	public Resource cargarArchivo(String nombreArchivo) {
		Path path=this.localizacionAlmacenamiento.resolve(nombreArchivo).normalize();
		try {
			Resource resource=new UrlResource(path.toUri());
			if(resource.exists())
				return resource;
			else
				throw new ArchivoFSNotFoundException("No se encontró el archivo: "+path.toString());
		} catch (MalformedURLException e) {
			throw new ArchivoFSNotFoundException("No se encontró el archivo: "+path.toString());
		}
	}
	
}
