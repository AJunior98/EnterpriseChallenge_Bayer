package com.br.fiap.enterprisechallenge.application;

import java.util.List;
import java.util.Scanner;

import com.br.fiap.enterprisechallenge.model.dao.DaoFactory;
import com.br.fiap.enterprisechallenge.model.dao.DoencaDao;
import com.br.fiap.enterprisechallenge.model.entites.Doenca;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DoencaDao doencaDao = DaoFactory.createDoencaDao();
		
		System.out.println("==== TEST 1: pessoa findByID ====");
		Doenca doenca = doencaDao.findById(2);
		
		System.out.println(doenca);
		
		System.out.println("\n==== TEST 2: pessoa findAll ====");
		List<Doenca> list = doencaDao.findAll();
		for(Doenca obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 3: pessoa insert ====");
		Doenca newDoenca = new Doenca(null, "Covid");
		doencaDao.insert(newDoenca);
		System.out.println("Inserted! New id = " + newDoenca.getId());
		
		System.out.println("\n==== TEST 4: pessoa update ====");
		doenca = doencaDao.findById(2);
		doenca.setNome("Gripe");
		doencaDao.update(doenca);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 5: pessoa delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		doencaDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
