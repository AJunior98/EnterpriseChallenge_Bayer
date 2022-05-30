package com.br.fiap.enterprisechallenge.application;

import com.br.fiap.enterprisechallenge.entites.Doenca;

public class Program {

	public static void main(String[] args) {
		
//		Connection conn = DB.getConnection();
//		DB.closeConnection();
		
		Doenca dc = new Doenca(1, "sudeste","fevereiro", "zika");
		
		System.out.println(dc);
		
	}
}
