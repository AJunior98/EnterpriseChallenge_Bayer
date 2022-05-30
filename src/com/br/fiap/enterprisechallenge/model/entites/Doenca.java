package com.br.fiap.enterprisechallenge.model.entites;

import java.io.Serializable;
import java.util.Objects;

public class Doenca implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String regiao;
	private String mes;
	private String nome;
	
	public Doenca() {
	}

	public Doenca(Integer id, String regiao, String mes, String nome) {
		this.id = id;
		this.regiao = regiao;
		this.mes = mes;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doenca other = (Doenca) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Doença [id=" + id + ", regiao=" + regiao + ", mes=" + mes + ", nome=" + nome + "]";
	}

}
