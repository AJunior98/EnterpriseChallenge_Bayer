package com.br.fiap.enterprisechallenge.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.br.fiap.enterprisechallenge.database.DB;
import com.br.fiap.enterprisechallenge.database.DbException;
import com.br.fiap.enterprisechallenge.model.dao.DoencaDao;
import com.br.fiap.enterprisechallenge.model.entites.Doenca;

public class DoencaDaoJDBC implements DoencaDao {

	private Connection conn;
	
	public DoencaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Doenca obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO T_MNT_DOENCA " 
					+ "(tp_doenca) "
					+ "VALUES "
					+ "(?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getNome());
			
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
	public void update(Doenca obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE T_MNT_DOENCA " 
					+ "SET tp_doenca = ? "
					+ "WHERE id = ?");
			
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getId());
			
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
			st = conn.prepareStatement("DELETE FROM T_MNT_DOENCA WHERE id = ?");
			
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
	public Doenca findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM T_MNT_DOENCA "
					+ "where id = ?");
					
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				Doenca dc = instantiateDoenca(rs);
				return dc;
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

	private Doenca instantiateDoenca(ResultSet rs) throws SQLException {
		Doenca dc = new Doenca();
		dc.setId(rs.getInt("id"));
		dc.setNome(rs.getString("tp_doenca"));
		return dc;
	}

	@Override
	public List<Doenca> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM T_MNT_DOENCA");
					
			rs = st.executeQuery();
			
			List<Doenca> list = new ArrayList<>();
			
			while (rs.next()) {
				Doenca obj = instantiateDoenca(rs);
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
