package com.br.fiap.enterprisechallenge.model.entites;

public class Dados {
	private static final long serialVersionUID = 1L;
	
	private String regiao;
	private String nomeDoenca;
	private Integer quantidade;
	private Double porcentagem;
	private String mes;

	public Dados() {
	}
	
	public Dados(String regiao, Integer dado, Double porcentagem, String nomeDoenca) {
		this.regiao = regiao;
		this.quantidade = dado;
		this.porcentagem = porcentagem;
		this.nomeDoenca = nomeDoenca;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Double porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	public String getNomeDoenca() {
		return nomeDoenca;
	}

	public void setNomeDoenca(String nomeDoenca) {
		this.nomeDoenca = nomeDoenca;
	}
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Dados [regiao=" + regiao + ", quantidade=" + quantidade + ", porcentagem=" + porcentagem*100 + "%]";
	}
	
}
