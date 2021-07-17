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
@Table(name = "tipos_de_filiacao")
public class TiposDeFiliacao extends AbstractEntity<Long> {
	
	@Column(name = "nome_tipo_filiacao", nullable = false, length = 150)
	private String nomeTipoFiliacao;

	@Column(name = "descricao_tipo_filiacao", length = 300)
	private String descricaoTipoFiliacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFiliacaoFk")
	private List<PessoaFilhos> pessoaFilhosList;

	public String getNomeTipoFiliacao() {
		return nomeTipoFiliacao;
	}

	public void setNomeTipoFiliacao(String nomeTipoFiliacao) {
		this.nomeTipoFiliacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeTipoFiliacao);
	}

	public String getDescricaoTipoFiliacao() {
		return descricaoTipoFiliacao;
	}

	public void setDescricaoTipoFiliacao(String descricaoTipoFiliacao) {
		this.descricaoTipoFiliacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoTipoFiliacao);
	}

	public List<PessoaFilhos> getPessoaFilhosList() {
		return pessoaFilhosList;
	}

	public void setPessoaFilhosList(List<PessoaFilhos> pessoaFilhosList) {
		this.pessoaFilhosList = pessoaFilhosList;
	}
    
}
