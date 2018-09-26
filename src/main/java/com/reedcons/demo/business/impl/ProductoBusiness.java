package com.reedcons.demo.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IProductoBusiness;
import com.reedcons.demo.model.Producto;
import com.reedcons.demo.model.exception.NotFoundException;
import com.reedcons.demo.model.persistence.ProductoRepository;

@Service
public class ProductoBusiness implements IProductoBusiness {

	@Autowired
	private ProductoRepository productoDAO;

	@Override
	public List<Producto> getAll() throws BusinessException {
		try {
			return productoDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Producto> search(String parte) throws BusinessException {
		try {
			return productoDAO.findByDescripcionContaining(parte);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Producto getOne(int id) throws BusinessException, NotFoundException {
		Optional<Producto> p = null;

		try {
			p = productoDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		if (!p.isPresent())
			throw new NotFoundException();
		return p.get();

	}

	@Override
	public Producto add(Producto producto) throws BusinessException {
		try {
			return productoDAO.save(producto);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Producto update(Producto producto) throws BusinessException, NotFoundException {
		Optional<Producto> p = null;

		try {
			p = productoDAO.findById(producto.getId());
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		if (!p.isPresent())
			throw new NotFoundException();

		try {
			return productoDAO.save(producto);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void delete(Producto producto) throws BusinessException, NotFoundException {
		Optional<Producto> p = null;

		try {
			p = productoDAO.findById(producto.getId());
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		if (!p.isPresent())
			throw new NotFoundException();

		try {
			productoDAO.delete(producto);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<Producto> search(double precioDesde, double precioHasta) throws BusinessException {
		try {
			return productoDAO.findByPrecioBetween(precioDesde, precioHasta);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
