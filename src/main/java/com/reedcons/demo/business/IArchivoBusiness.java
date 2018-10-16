package com.reedcons.demo.business;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.reedcons.demo.model.Archivo;
import com.reedcons.demo.model.exception.NotFoundException;

public interface IArchivoBusiness {
	
	//Bases de Datos
	public Archivo getOne(int id) throws BusinessException, NotFoundException;
	public Archivo add(Archivo archivo) throws BusinessException;
	public void delete(Archivo archivo) throws BusinessException, NotFoundException;
	public List<Archivo> getAll() throws BusinessException;
	public List<Archivo> getAll(String part) throws BusinessException;
	public List<Archivo> getAll(long desde, long hasta) throws BusinessException;
	
	
	
	//FileSystem
	
	public Archivo saveToFS(MultipartFile file ) throws BusinessException;
	public Resource loadFromFS(String nombreArchivo) throws BusinessException, NotFoundException;
	
	//Práctico 3/10/2018
	public void deleteFromFS(String nombreArchivo) throws BusinessException, NotFoundException;
	public List<Archivo> getAllFromFS() throws BusinessException;

}
