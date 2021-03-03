package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_filiacao")
public class TiposDeFiliacao extends AbstractEntity<Long> {

	@Column(name="descricao_tipo_filiacao")
	private String descricaoTipoFiliacao;

	@Column(name="nome_tipo_filiacao")
	private String nomeTipoFiliacao;

	//bi-directional many-to-one association to PessoaFilho
	@OneToMany(mappedBy="tiposDeFiliacao")
	private List<PessoaFilhos> pessoaFilhos;

	public TiposDeFiliacao() {
	}

	public String getDescricaoTipoFiliacao() {
		return this.descricaoTipoFiliacao;
	}

	public void setDescricaoTipoFiliacao(String descricaoTipoFiliacao) {
		this.descricaoTipoFiliacao = descricaoTipoFiliacao;
	}

	public String getNomeTipoFiliacao() {
		return this.nomeTipoFiliacao;
	}

	public void setNomeTipoFiliacao(String nomeTipoFiliacao) {
		this.nomeTipoFiliacao = nomeTipoFiliacao;
	}

	public List<PessoaFilhos> getPessoaFilhos() {
		return this.pessoaFilhos;
	}

	public void setPessoaFilhos(List<PessoaFilhos> pessoaFilhos) {
		this.pessoaFilhos = pessoaFilhos;
	}

	public PessoaFilhos addPessoaFilho(PessoaFilhos pessoaFilho) {
		getPessoaFilhos().add(pessoaFilho);
		pessoaFilho.setTiposDeFiliacao(this);

		return pessoaFilho;
	}

	public PessoaFilhos removePessoaFilho(PessoaFilhos pessoaFilho) {
		getPessoaFilhos().remove(pessoaFilho);
		pessoaFilho.setTiposDeFiliacao(null);

		return pessoaFilho;
	}

}
