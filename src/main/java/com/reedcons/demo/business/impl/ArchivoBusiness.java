package com.reedcons.demo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IArchivoBusiness;
import com.reedcons.demo.business.impl.util.fs.ArchivoFSException;
import com.reedcons.demo.business.impl.util.fs.ArchivoFSNotFoundException;
import com.reedcons.demo.business.impl.util.fs.ArchivoFSService;
import com.reedcons.demo.model.Archivo;
import com.reedcons.demo.model.exception.NotFoundException;

@Service
public class ArchivoBusiness implements IArchivoBusiness {

	@Override
	public Archivo getOne(int id) throws BusinessException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Archivo add(Archivo archivo) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Archivo archivo) throws BusinessException, NotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Archivo> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private ArchivoFSService archivoFSService;

	@Override
	public Archivo saveToFS(MultipartFile file) throws BusinessException {
		Archivo r=new Archivo();
		try {
			String nombre= archivoFSService.almacenarArchivo(file);
			r.setNombre(nombre);
			r.setLength(file.getSize());
			r.setMime(file.getContentType());
			return r;
		} catch (ArchivoFSException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Resource loadFromFS(String nombreArchivo) throws BusinessException, NotFoundException {
		try {
			return archivoFSService.cargarArchivo(nombreArchivo);
		} catch (ArchivoFSNotFoundException e) {
			throw new NotFoundException(e);
		} catch(Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteFromFS(String nombreArchivo) throws BusinessException, NotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Archivo> getAllFromFS() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
