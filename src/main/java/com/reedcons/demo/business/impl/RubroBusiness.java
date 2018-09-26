package com.reedcons.demo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IRubroBusiness;
import com.reedcons.demo.model.Rubro;
import com.reedcons.demo.model.persistence.RubroRepository;

@Service
public class RubroBusiness implements IRubroBusiness {

	@Autowired
	private RubroRepository rubroDAO;

	@Override
	public List<Rubro> getAll() throws BusinessException {
		try {
			return rubroDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}



	@Override
	public Rubro add(Rubro rubro) throws BusinessException {
		try {
			return rubroDAO.save(rubro);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}


}
