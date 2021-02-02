package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "classes")
public class Classes extends AbstractEntity<Long> {

	@Column(name = "sigla_classe", nullable = false, length = 10)
	private String siglaClasse;

	@Column(name = "nome_classe", nullable = false, length = 150)
	private String nomeClasse;

	@Column(name = "descricao_classe", length = 300)
	private String descricaoClasse;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasseFk")
	private List<HistFuncionariosClasse> histFuncionariosClasseCollection;

	public String getSiglaClasse() {
		return siglaClasse;
	}

	public void setSiglaClasse(String siglaClasse) {
		this.siglaClasse = siglaClasse;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	public String getDescricaoClasse() {
		return descricaoClasse;
	}

	public void setDescricaoClasse(String descricaoClasse) {
		this.descricaoClasse = descricaoClasse;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseCollection() {
		return histFuncionariosClasseCollection;
	}

	public void setHistFuncionariosClasseCollection(List<HistFuncionariosClasse> histFuncionariosClasseCollection) {
		this.histFuncionariosClasseCollection = histFuncionariosClasseCollection;
	}

}
