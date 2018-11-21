package com.reedcons.demo.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reedcons.demo.model.Archivo;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Integer>{
    //JPA  --> HIBERNATE
	//JPQL --> HQL
	
	@Query("SELECT new com.reedcons.demo.model.Archivo(a.id, a.nombre, a.length, a.mime) FROM Archivo a")
	public List<Archivo> findAllFiles();
	
	@Query("SELECT new com.reedcons.demo.model.Archivo(a.id, a.nombre, a.length, a.mime) FROM Archivo a WHERE a.nombre LIKE :part")
	public List<Archivo> findAllFiles(@Param("part") String part);
	
	@Query("SELECT new com.reedcons.demo.model.Archivo(a.id, a.nombre, a.length, a.mime) FROM Archivo a WHERE a.length BETWEEN :desde AND :hasta")
	public List<Archivo> findAllFiles(@Param("desde") long desde, @Param("hasta") long hasta);
	

}
