package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "niveis_carreira")
public class NiveisCarreira extends AbstractEntity<Long> {

	@Column(name = "nome_nivel_carreira", nullable = false, length = 300)
	private String nomeNivelCarreira;

	@Column(name = "descricao_nivel_carreira", length = 300)
	private String descricaoNivelCarreira;

	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelCareiraFk")
	private List<PessoaFuncionarios> pessoaFuncionariosCollection;
	*/
	
	public String getNomeNivelCarreira() {
		return nomeNivelCarreira;
	}

	public void setNomeNivelCarreira(String nomeNivelCarreira) {
		this.nomeNivelCarreira = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNivelCarreira);
	}

	public String getDescricaoNivelCarreira() {
		return descricaoNivelCarreira;
	}

	public void setDescricaoNivelCarreira(String descricaoNivelCarreira) {
		this.descricaoNivelCarreira = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNivelCarreira);
	}

	/*
	public List<PessoaFuncionarios> getPessoaFuncionariosCollection() {
		return pessoaFuncionariosCollection;
	}

	public void setPessoaFuncionariosCollection(List<PessoaFuncionarios> pessoaFuncionariosCollection) {
		this.pessoaFuncionariosCollection = pessoaFuncionariosCollection;
	}
*/

}
