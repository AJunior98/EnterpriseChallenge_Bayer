package com.br.fiap.enterprisechallenge.application;

import java.util.List;
import java.util.Scanner;

import com.br.fiap.enterprisechallenge.model.dao.DaoFactory;
import com.br.fiap.enterprisechallenge.model.dao.PessoaDao;
import com.br.fiap.enterprisechallenge.model.entites.Doenca;
import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n==== TEST 4: pessoa insert ====");
		Pessoa newPessoa = new Pessoa(null, "Janeiro", "Sul", "Feminino", 40, doenca);
		pessoaDao.insert(newPessoa);
		System.out.println("Inserted! New id = " + newPessoa.getId());
		
		System.out.println("\n==== TEST 5: pessoa update ====");
		pessoa = pessoaDao.findById(1);
		pessoa.setRegiao("Norte");
		pessoaDao.update(pessoa);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 6: pessoa delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		pessoaDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
