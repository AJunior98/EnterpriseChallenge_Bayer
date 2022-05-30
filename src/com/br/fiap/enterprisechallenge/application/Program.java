package com.br.fiap.enterprisechallenge.application;

import com.br.fiap.enterprisechallenge.model.dao.DaoFactory;
import com.br.fiap.enterprisechallenge.model.dao.PessoaDao;
import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public class Program {

	public static void main(String[] args) {
		
	
		PessoaDao pessoaDao = DaoFactory.createPessoaDao();
		
		Pessoa pessoa = pessoaDao.findById(3);
		
		System.out.println(pessoa);
		
	}
}
