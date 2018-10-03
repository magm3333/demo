package com.reedcons.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IProductoBusiness;
import com.reedcons.demo.business.impl.ProductoBusinessOld;
import com.reedcons.demo.model.Producto;
import com.reedcons.demo.model.exception.NotFoundException;

@RestController
@RequestMapping(Constantes.URL_PRODUCTOS)
public class ProductoRestController {
	
	// IoC

	@Autowired
	private IProductoBusiness productoBusiness;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Producto>> all( 
			@RequestParam(required=false,value="q",defaultValue="*")  String q,
			@RequestParam(required=false,value="pd",defaultValue="-1")  double precioDesde,
			@RequestParam(required=false,value="ph",defaultValue="-1")  double precioHasta
			
			) {
		try {
			if (precioDesde!=-1 && precioHasta!=-1 && precioDesde<=precioHasta) {
				return new ResponseEntity(productoBusiness.search(precioDesde,precioHasta), HttpStatus.OK);

			} else if (q.equals("*") || q.trim().length() == 0) {
				return new ResponseEntity(productoBusiness.getAll(), HttpStatus.OK);
			} else {
				return new ResponseEntity(productoBusiness.search(q), HttpStatus.OK);
			}
		} catch (BusinessException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Producto> one(@PathVariable("id") int id) {
		try {
			return new ResponseEntity(productoBusiness.getOne(id), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}
	
	
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)	
	public ResponseEntity<Object> add(@RequestBody Producto producto) {
		try {
			Producto p=productoBusiness.add(producto);
			HttpHeaders headers=new HttpHeaders();
			headers.add("location", "/productos/"+p.getId());
			return new ResponseEntity(headers, HttpStatus.CREATED);
		} catch (BusinessException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} 

	}
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.PUT)	
	public ResponseEntity<Object> update(@RequestBody Producto producto) {
		try {
			productoBusiness.update(producto);
			return new ResponseEntity(HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Producto> delete(@PathVariable("id") int id) {
		try {
			Producto p=new Producto();
			p.setId(id);
			productoBusiness.delete(p);
			return new ResponseEntity( HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}
	
	
	// [GET] /productos 200, 500
	// [GET] /productos/1 200, 404, 500
	// [POST] /productos  --> status=201, 500 (location ==> /productos/16)
	// [PUT] /productos  --> 200, 404, 500
	// [DELETE] /productos/1 --> 200, 404, 500
	


}
