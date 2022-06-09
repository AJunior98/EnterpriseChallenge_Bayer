package com.br.fiap.enterprisechallenge.model.dao;

import java.util.List;

import com.br.fiap.enterprisechallenge.model.entites.Doenca;
import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public interface PessoaDao {

	void insert(Pessoa obj);
	void update(Pessoa obj);
	void deleteByCpf(String id);
	Pessoa findByCpf(String cpf);
	List<Pessoa> findAll();
	List<Pessoa> findByDoenca(Doenca doenca);
	
}
