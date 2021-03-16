package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "codigo_diferenciado")
public class CodigoDiferenciado extends AbstractEntity<Long> {

	@Column(name = "nome_codigo_diferenciado")
	private String nomeCodigoDiferenciado;
	
	@Column(name = "descricao_codigo_diferenciado")
	private String descricaoCodigoDiferenciado;
	
	@OneToMany(mappedBy = "idCodDiferenciadoFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;

	public String getNomeCodigoDiferenciado() {
		return nomeCodigoDiferenciado;
	}

	public void setNomeCodigoDiferenciado(String nomeCodigoDiferenciado) {
		this.nomeCodigoDiferenciado = nomeCodigoDiferenciado;
	}

	public String getDescricaoCodigoDiferenciado() {
		return descricaoCodigoDiferenciado;
	}

	public void setDescricaoCodigoDiferenciado(String descricaoCodigoDiferenciado) {
		this.descricaoCodigoDiferenciado = descricaoCodigoDiferenciado;
	}

	public List<FaixasValoresParametrosCalculoFolhasExtras> getFaixasValoresParametrosCalculoFolhasExtrasList() {
		return faixasValoresParametrosCalculoFolhasExtrasList;
	}

	public void setFaixasValoresParametrosCalculoFolhasExtrasList(
			List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList) {
		this.faixasValoresParametrosCalculoFolhasExtrasList = faixasValoresParametrosCalculoFolhasExtrasList;
	}

}
