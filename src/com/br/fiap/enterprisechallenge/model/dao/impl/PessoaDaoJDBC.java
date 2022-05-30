package com.br.fiap.enterprisechallenge.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.br.fiap.enterprisechallenge.database.DB;
import com.br.fiap.enterprisechallenge.database.DbException;
import com.br.fiap.enterprisechallenge.model.dao.PessoaDao;
import com.br.fiap.enterprisechallenge.model.entites.Doenca;
import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public class PessoaDaoJDBC implements PessoaDao {

	private Connection conn;
	
	public PessoaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Pessoa obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pessoa obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT tb_pessoa.*, tb_doenca.Tipo as doencaName "
					+ "FROM tb_pessoa INNER JOIN tb_doenca "
					+ "ON tb_pessoa.DoencaId = tb_doenca.Id "
					+ "where tb_pessoa.Id = ?");
					
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Doenca dc = new Doenca();
				dc.setId(rs.getInt("DoencaId"));
				dc.setNome(rs.getString("doencaName"));
				Pessoa obj = new Pessoa();
				obj.setId(rs.getInt("Id"));
				obj.setRegiao(rs.getString("Regiao"));
				obj.setMes(rs.getString("Mes"));
				obj.setGenero(rs.getString("Genero"));
				obj.setIdade(rs.getInt("Idade"));
				obj.setDoenca(dc);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
