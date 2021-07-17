package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

/**
 * @author andre
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "estados_civis")
public class EstadosCivis extends AbstractEntity<Long> {

	@Column(name = "nome_estado_civil", nullable = false, length = 100)
	private String nomeEstadoCivil;

	@Column(name = "descricao_estado_civil", length = 300)
	private String descricaoEstadoCivil;

	@OneToMany(mappedBy = "idEstadoCivilFk")
	private List<Pessoa> pessoaList;

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

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}
	
}
