package com.br.fiap.enterprisechallenge.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO T_MNT_PESSOA " 
					+ "(dt_mescontagio, nr_cpf, nm_regiao, nm_genero, nr_idade, id_doenca) "
					+ "VALUES "
					+ "(?,?,?,?,?,?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getMes());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getRegiao());
			st.setString(4, obj.getGenero());
			st.setInt(5, obj.getIdade());
			st.setInt(6, obj.getDoenca().getId());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected.");
			}

		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Pessoa obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE T_MNT_PESSOA " 
					+ "SET dt_mescontagio = ?, nr_cpf = ?,nm_regiao = ?, nm_genero = ?, nr_idade = ?, id_doenca = ? "
					+ "WHERE Id = ?");
			
			st.setString(1, obj.getMes());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getRegiao());
			st.setString(4, obj.getGenero());
			st.setInt(5, obj.getIdade());
			st.setInt(6, obj.getDoenca().getId());
			st.setInt(7, obj.getId());
			
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM T_MNT_PESSOA WHERE id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Pessoa findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT T_MNT_PESSOA.*, T_MNT_DOENCA.tp_doenca as doencaName "
					+ "FROM T_MNT_PESSOA INNER JOIN T_MNT_DOENCA "
					+ "ON T_MNT_PESSOA.id_doenca = T_MNT_DOENCA.id "
					+ "where T_MNT_PESSOA.id = ?");
					
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Doenca dc = instantiateDoenca(rs);
				Pessoa obj = instantiatePessoa(rs, dc);
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

	private Pessoa instantiatePessoa(ResultSet rs, Doenca dc) throws SQLException {
		Pessoa obj = new Pessoa();
		obj.setId(rs.getInt("id"));
		obj.setCpf(rs.getString("nr_cpf"));
		obj.setRegiao(rs.getString("nm_regiao"));
		obj.setMes(rs.getString("dt_mescontagio"));
		obj.setGenero(rs.getString("nm_genero"));
		obj.setIdade(rs.getInt("nr_idade"));
		obj.setDoenca(dc);
		return obj;
	}

	private Doenca instantiateDoenca(ResultSet rs) throws SQLException {
		Doenca dc = new Doenca();
		dc.setId(rs.getInt("id_doenca"));
		dc.setNome(rs.getString("doencaName"));
		return dc;
	}

	@Override
	public List<Pessoa> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT T_MNT_PESSOA.*, T_MNT_DOENCA.tp_doenca as doencaName "
					+ "FROM T_MNT_PESSOA INNER JOIN T_MNT_DOENCA "
					+ "ON T_MNT_PESSOA.id_doenca = T_MNT_DOENCA.id "
					+ "ORDER BY id");
					
			rs = st.executeQuery();
			
			List<Pessoa> list = new ArrayList<>();
			Map<Integer, Doenca> map = new HashMap<>();
			
			while (rs.next()) {
				
				Doenca dc = map.get(rs.getInt("id_doenca"));
				
				if (dc == null) {
					dc = instantiateDoenca(rs);
					map.put(rs.getInt("id_doenca"), dc);
				}
				
				Pessoa obj = instantiatePessoa(rs, dc);
				list.add(obj);
			}
			return list;
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
	public List<Pessoa> findByDoenca(Doenca doenca) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT T_MNT_PESSOA.*, T_MNT_DOENCA.tp_doenca as doencaName "
					+ "FROM T_MNT_PESSOA INNER JOIN T_MNT_DOENCA "
					+ "ON T_MNT_PESSOA.id_doenca = T_MNT_DOENCA.Id WHERE id_doenca = ? "
					+ "ORDER BY id");
					
			st.setInt(1, doenca.getId());
			rs = st.executeQuery();
			
			List<Pessoa> list = new ArrayList<>();
			Map<Integer, Doenca> map = new HashMap<>();
			
			while (rs.next()) {
				
				Doenca dc = map.get(rs.getInt("id_doenca"));
				
				if (dc == null) {
					dc = instantiateDoenca(rs);
					map.put(rs.getInt("id_doenca"), dc);
				}
				
				Pessoa obj = instantiatePessoa(rs, dc);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
