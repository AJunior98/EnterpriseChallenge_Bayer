package com.br.fiap.enterprisechallenge.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.fiap.enterprisechallenge.database.DB;
import com.br.fiap.enterprisechallenge.database.DbException;
import com.br.fiap.enterprisechallenge.model.dao.DadosDao;
import com.br.fiap.enterprisechallenge.model.entites.Dados;

public class DadosDaoJDBC implements DadosDao {

	private Connection conn;

	public DadosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Dados> findByRegiao(String regiao) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select T_MNT_DOENCA.tp_doenca as doencaName, count(id_doenca), cast(count(*)/sum(count(*)) over() as decimal(10,2)) "
							+ "from T_MNT_PESSOA INNER JOIN T_MNT_DOENCA ON T_MNT_PESSOA.id_doenca = T_MNT_DOENCA.id where nm_regiao = ? group by id_doenca");

			st.setString(1, regiao);
			rs = st.executeQuery();
			List<Dados> list = new ArrayList<>();
			while (rs.next()) {
				Dados dado = instantiateDados(rs);
				list.add(dado);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Dados> findTotal() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select T_MNT_DOENCA.tp_doenca as doencaName, count(id_doenca), cast(count(*)/sum(count(*)) over() as decimal(10,2)) "
							+ "from T_MNT_PESSOA INNER JOIN T_MNT_DOENCA ON T_MNT_PESSOA.id_doenca = T_MNT_DOENCA.id group by id_doenca");

			rs = st.executeQuery();
			List<Dados> list = new ArrayList<>();
			while (rs.next()) {
				Dados dado = instantiateDados(rs);
				list.add(dado);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public Dados findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select count(id_doenca) from T_MNT_PESSOA");

			rs = st.executeQuery();
			if(rs.next()) {
				Dados dado = instantiateDados2(rs);
				return dado;
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
	public List<Dados> findByMonth(String mes) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select T_MNT_DOENCA.tp_doenca as doencaName, count(id_doenca), cast(count(*)/sum(count(*)) over() as decimal(10,2)) "
					+ "from T_MNT_PESSOA INNER JOIN T_MNT_DOENCA ON T_MNT_PESSOA.id_doenca = T_MNT_DOENCA.id where dt_mescontagio = ? group by id_doenca;");
			
			st.setString(1, mes);
			rs = st.executeQuery();
			List<Dados> list = new ArrayList<>();
			while (rs.next()) {
				Dados dado = instantiateDados(rs);
				list.add(dado);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private Dados instantiateDados(ResultSet rs) throws SQLException {
		Dados dado = new Dados();
		dado.setNomeDoenca(rs.getString("doencaName"));
		dado.setQuantidade(rs.getInt("count(id_doenca)"));
		dado.setPorcentagem(rs.getDouble("cast(count(*)/sum(count(*)) over() as decimal(10,2))"));
		return dado;
	}

	

	private Dados instantiateDados2(ResultSet rs) throws SQLException {
		Dados dado = new Dados();
		dado.setQuantidade(rs.getInt("count(id_doenca)"));
		return dado;
	}
	
}
