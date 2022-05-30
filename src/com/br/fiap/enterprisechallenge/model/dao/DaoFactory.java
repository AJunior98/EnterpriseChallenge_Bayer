package com.br.fiap.enterprisechallenge.model.dao;

import com.br.fiap.enterprisechallenge.model.dao.impl.DoencaDaoJDBC;

public class DaoFactory {
	
	public static DoencaDao createDoencaDao() {
		return new DoencaDaoJDBC();
	}
	
}
