package com.reedcons.demo.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reedcons.demo.model.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Integer>{

}
