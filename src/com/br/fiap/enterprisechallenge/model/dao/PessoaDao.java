package com.br.fiap.enterprisechallenge.model.dao;

import java.util.List;

import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public interface PessoaDao {

	void insert(Pessoa obj);
	void update(Pessoa obj);
	void deleteById(Integer id);
	Pessoa findById(Integer id);
	List<Pessoa> findAll();
	
}
