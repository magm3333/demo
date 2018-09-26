package com.reedcons.demo.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IProductoBusiness;
import com.reedcons.demo.model.Producto;
import com.reedcons.demo.model.exception.NotFoundException;

//@Service
public class ProductoBusinessOld implements IProductoBusiness {

	private List<Producto> baseDeDatos = new ArrayList<Producto>();

	public ProductoBusinessOld() {
		baseDeDatos.add(new Producto(1, "Arroz", true, 43, null));
		baseDeDatos.add(new Producto(2, "Leche", true, 33, new Date()));
		baseDeDatos.add(new Producto(3, "Cerveza", true, 48, new Date()));
		baseDeDatos.add(new Producto(4, "Chupetín", true, 4, null));
	}

	@Override
	public List<Producto> getAll() throws BusinessException {

		return baseDeDatos;
	}

	@Override
	public List<Producto> search(String parte) throws BusinessException {
		List<Producto> r = new ArrayList<Producto>();
		for (Producto p : baseDeDatos) {
			if (p.getDescripcion().toLowerCase().indexOf(parte.toLowerCase()) != -1) {
				r.add(p);
			}
		}
		return r;
	}

	@Override
	public Producto getOne(int id) throws BusinessException, NotFoundException {
		for (Producto p : baseDeDatos) {
			if (p.getId() == id) {
				return p;
			}
		}
		throw new NotFoundException();
	}

	@Override
	public Producto add(Producto producto) throws BusinessException {
		baseDeDatos.add(producto);
		return producto;
	}

	@Override
	public Producto update(Producto producto) throws BusinessException, NotFoundException {
		for (int t = 0; t < baseDeDatos.size(); t++) {
			if (baseDeDatos.get(t).getId() == producto.getId()) {
				baseDeDatos.set(t, producto);
				return producto;
			}
		}
		throw new NotFoundException();
	}

	@Override
	public void delete(Producto producto) throws BusinessException, NotFoundException {
		for (int t = 0; t < baseDeDatos.size(); t++) {
			if (baseDeDatos.get(t).getId() == producto.getId()) {
				baseDeDatos.remove(t);
				return;
			}
		}
		throw new NotFoundException();

	}

	@Override
	public List<Producto> search(double precioDesde, double precioHasta) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
