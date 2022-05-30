package com.br.fiap.enterprisechallenge.application;

import java.util.List;

import com.br.fiap.enterprisechallenge.model.dao.DaoFactory;
import com.br.fiap.enterprisechallenge.model.dao.PessoaDao;
import com.br.fiap.enterprisechallenge.model.entites.Doenca;
import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		PessoaDao pessoaDao = DaoFactory.createPessoaDao();
		
		System.out.println("==== TEST 1: pessoa findByID ====");
		Pessoa pessoa = pessoaDao.findById(3);
		
		System.out.println(pessoa);
		
		System.out.println("\n==== TEST 2: pessoa findByDoenca ====");
		Doenca doenca = new Doenca(2, null);
		List<Pessoa> list = pessoaDao.findByDoenca(doenca);
		for(Pessoa obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n==== TEST 3: pessoa findAll ====");
		list = pessoaDao.findAll();
		for(Pessoa obj : list) {
			System.out.println(obj);
		}
		
	}
}
