package com.br.fiap.enterprisechallenge.model.dao;

import java.util.List;

import com.br.fiap.enterprisechallenge.model.entites.Doenca;

public interface DoencaDao {

	void insert(Doenca obj);
	void update(Doenca obj);
	void deleteById(Integer id);
	Doenca findById(Integer id);
	List<Doenca> findAll();
	
}
