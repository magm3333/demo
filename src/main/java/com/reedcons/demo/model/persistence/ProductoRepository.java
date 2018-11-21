package com.reedcons.demo.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	//https://docs.spring.io/spring-data/jpa/docs/2.0.4.RELEASE/reference/html/#repositories.query-methods.details
	
	public List<Producto> findByDescripcionContaining(String q) throws BusinessException;
	public List<Producto> findByPrecioBetween(double precioDesde, double precioHasta) throws BusinessException;

}
