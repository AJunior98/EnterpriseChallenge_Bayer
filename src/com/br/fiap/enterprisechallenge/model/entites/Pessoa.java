package com.br.fiap.enterprisechallenge.model.entites;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String genero;
	private Integer idade;
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String genero, Integer idade) {
		this.id = id;
		this.genero = genero;
		this.idade = idade;
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
		return "Pessoa [id=" + id + ", genero=" + genero + ", idade=" + idade + "]";
	}
	
}
