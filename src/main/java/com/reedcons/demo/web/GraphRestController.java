package com.reedcons.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reedcons.demo.business.IGraphBusiness;

@RestController
@RequestMapping(Constantes.URL_GRAPH)
public class GraphRestController {
	@Autowired
	private IGraphBusiness graphBusiness;

	@GetMapping(value = "/push")
	public void pushGraphData() {
		graphBusiness.pushGraphData();
	}

}
