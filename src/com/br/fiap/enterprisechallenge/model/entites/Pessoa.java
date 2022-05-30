package com.br.fiap.enterprisechallenge.model.entites;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String regiao;
	private String mes;
	private String genero;
	private Integer idade;
	
	private Doenca doenca;
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String regiao, String mes, String genero, Integer idade, Doenca doenca) {
		this.id = id;
		this.regiao = regiao;
		this.mes = mes;
		this.genero = genero;
		this.idade = idade;
		this.doenca = doenca;
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

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", regiao=" + regiao + ", mes=" + mes + ", genero=" + genero + ", idade=" + idade
				+ ", doenca=" + doenca + "]";
	}

}
