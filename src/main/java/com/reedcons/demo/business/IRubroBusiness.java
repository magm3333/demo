package com.reedcons.demo.business;

import java.util.List;

import com.reedcons.demo.model.Producto;
import com.reedcons.demo.model.Rubro;

public interface IRubroBusiness {
	
	public List<Rubro> getAll() throws BusinessException;
	public Rubro add(Rubro rubro) throws BusinessException;
	
	

}
