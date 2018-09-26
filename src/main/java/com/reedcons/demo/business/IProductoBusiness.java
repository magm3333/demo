package com.reedcons.demo.business;

import java.util.List;

import com.reedcons.demo.model.Producto;
import com.reedcons.demo.model.exception.NotFoundException;

public interface IProductoBusiness {
	
	public List<Producto> getAll() throws BusinessException;
	public List<Producto> search(String parte) throws BusinessException;
	public List<Producto> search(double precioDesde, double precioHasta) throws BusinessException;
	public Producto getOne(int id) throws BusinessException, NotFoundException;
	public Producto add(Producto producto) throws BusinessException;
	public Producto update(Producto producto) throws BusinessException, NotFoundException;
	public void delete(Producto producto) throws BusinessException, NotFoundException;
	
	

}
