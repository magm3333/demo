package com.reedcons.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IRubroBusiness;
import com.reedcons.demo.model.Rubro;

@RestController
@RequestMapping(Constantes.URL_RUBROS)
public class RubroRestController {

	@Autowired
	private IRubroBusiness rubroBusiness;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Rubro>> all() {
		try {
			return new ResponseEntity(rubroBusiness.getAll(), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public ResponseEntity<Object> add(@RequestBody Rubro rubro) {
		try {
			Rubro p = rubroBusiness.add(rubro);
			HttpHeaders headers = new HttpHeaders();
			headers.add("location", "/rubros/" + p.getId());
			return new ResponseEntity(headers, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
