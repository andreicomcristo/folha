package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "estados_civis")
public class EstadosCivis extends AbstractEntity<Long> {

	@Column(name = "nome_estado_civil", nullable = false, length = 100)
	private String nomeEstadoCivil;

	@Column(name = "descricao_estado_civil", length = 300)
	private String descricaoEstadoCivil;

	@OneToMany(mappedBy = "seqEstadoCivil")
	private List<Pessoa> pessoaCollection;

	public String getNomeEstadoCivil() {
		return nomeEstadoCivil;
	}

	public void setNomeEstadoCivil(String nomeEstadoCivil) {
		this.nomeEstadoCivil = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEstadoCivil);
	}

	public String getDescricaoEstadoCivil() {
		return descricaoEstadoCivil;
	}

	public void setDescricaoEstadoCivil(String descricaoEstadoCivil) {
		this.descricaoEstadoCivil = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEstadoCivil);
	}

	public List<Pessoa> getPessoaCollection() {
		return pessoaCollection;
	}

	public void setPessoaCollection(List<Pessoa> pessoaCollection) {
		this.pessoaCollection = pessoaCollection;
	}
	
}
