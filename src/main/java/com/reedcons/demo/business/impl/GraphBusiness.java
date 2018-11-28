package com.reedcons.demo.business.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.reedcons.demo.business.IGraphBusiness;
import com.reedcons.demo.model.util.LabelValue;

@Service
public class GraphBusiness implements IGraphBusiness {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public void pushGraphData() {
		String[] meses = "Enero,Febrero,Marzo,Abril,Mayo,Junio,Julio,Agosto,Septiembre,Octubre,Noviembre,Diciembre"
				.split(",");
		List<LabelValue> valores = Arrays.stream(meses).map(mes -> {
			LabelValue lv=new LabelValue(mes, ((int) (Math.random() * 100)));
			log.info(lv.toString());
			return lv;
		}).collect(Collectors.toList());


	}

}
