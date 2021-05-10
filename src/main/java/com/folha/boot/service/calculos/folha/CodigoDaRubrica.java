package com.folha.boot.service.calculos.folha;

public class CodigoDaRubrica {

	private int id;
	private String codigo;
	private String variacao;
	private String descricao;
	private Natureza natureza;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getVariacao() {
		return variacao;
	}
	public void setVariacao(String variacao) {
		this.variacao = variacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Natureza getNatureza() {
		return natureza;
	}
	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}
	
}

