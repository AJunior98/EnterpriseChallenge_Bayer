package com.br.fiap.enterprisechallenge.application;

import java.sql.Connection;

import com.br.fiap.enterprisechallenge.database.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		DB.closeConnection();
		
	}
}
