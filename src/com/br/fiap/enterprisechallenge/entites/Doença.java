package com.br.fiap.enterprisechallenge.entites;

import java.util.Objects;

public class Doença {

	private Integer id;
	private String regiao;
	private String nome;
	
	public Doença() {
	}

	public Doença(Integer id, String regiao, String nome) {
		this.id = id;
		this.regiao = regiao;
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
		Doença other = (Doença) obj;
		return Objects.equals(id, other.id);
	}

}
