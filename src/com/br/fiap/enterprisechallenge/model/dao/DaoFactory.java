package com.br.fiap.enterprisechallenge.model.dao;

import com.br.fiap.enterprisechallenge.database.DB;
import com.br.fiap.enterprisechallenge.model.dao.impl.PessoaDaoJDBC;

public class DaoFactory {
	
	public static PessoaDao createPessoaDao() {
		return new PessoaDaoJDBC(DB.getConnection());
	}
	
}
