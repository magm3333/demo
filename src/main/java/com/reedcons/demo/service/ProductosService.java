package com.reedcons.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reedcons.demo.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductosService {

	// GET /productos
	@RequestMapping(value= {"","/"},method=RequestMethod.GET,produces="application/json")
	public List<Producto> all() {
		List<Producto> r = new ArrayList<Producto>();
		r.add(new Producto(1, "Arroz", true, 43, null));
		r.add(new Producto(2, "Leche", true, 33, new Date()));
		r.add(new Producto(3, "Cerveza", true, 48, new Date()));
		r.add(new Producto(4, "Chupetín", true, 4, null));
		return r;
	}

	// GET /productos/{id}
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces="application/json")
	public Producto one(@PathVariable("id") int id) {
		List<Producto> l=all();
		for(Producto p: l) {
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}
}
