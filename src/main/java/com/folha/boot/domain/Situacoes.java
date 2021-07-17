package com.folha.boot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "situacoes")
public class Situacoes extends AbstractEntity<Long> {

	@Column(name = "nome_situacao", nullable = false, length = 300)
	private String nomeSituacao;

	@Column(name = "descricao_situacao", length = 300)
	private String descricaoSituacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacaoFk")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacaoFk")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList;

	@OneToMany(mappedBy = "idSituacaoAtualFk")
	private List<PessoaFuncionarios> pessoaFuncionariosList;

	
	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList() {
		return histFuncionariosSituacoesList;
	}

	public void setHistFuncionariosSituacoesList(List<HistFuncionariosSituacoes> histFuncionariosSituacoesList) {
		this.histFuncionariosSituacoesList = histFuncionariosSituacoesList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeSituacao() {
		return nomeSituacao;
	}

	public void setNomeSituacao(String nomeSituacao) {
		this.nomeSituacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeSituacao);
	}

	public String getDescricaoSituacao() {
		return descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoSituacao);
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection() {
		return histFuncionariosSituacoesCollection;
	}

	public void setHistFuncionariosSituacoesCollection(
			List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection) {
		this.histFuncionariosSituacoesCollection = histFuncionariosSituacoesCollection;
	}

}
