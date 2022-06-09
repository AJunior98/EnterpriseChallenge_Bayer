package com.br.fiap.enterprisechallenge.model.dao;

import java.util.List;

import com.br.fiap.enterprisechallenge.model.entites.Dados;

public interface DadosDao {

	List<Dados> findByRegiao(String regiao);
	List<Dados> findTotal();
	Dados findAll();
	List<Dados> findByMonth(String mes);

	
}
