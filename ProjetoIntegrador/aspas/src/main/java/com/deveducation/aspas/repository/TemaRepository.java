package com.deveducation.aspas.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.deveducation.aspas.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {
	public List<TemaModel> findByMateriaAndSubmateriaContainingIgnoreCase(String materia, String submateria);
	
	public List<TemaModel> findAllByMateriaContainingIgnoreCase(String materia);
}
