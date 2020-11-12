package com.deveducation.aspas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deveducation.aspas.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {
	
	public List<PostagemModel> findAllByTituloContainingIgnoreCase (String titulo);

}
