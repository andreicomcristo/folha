package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_logradouro")
public class TiposLogradouro extends AbstractEntity<Long> {

	@Column(name = "nome_tipo_logradouro", nullable = false, length = 150)
	private String nomeTipoLogradouro;

	@Column(name = "descricao_tipo_logradouro", length = 300)
	private String descricaoTipoLogradouro;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLogradouroFk")
	private List<Enderecos> enderecosCollection;

	@OneToMany(mappedBy = "idTipoLogradouroFk")
	private List<Unidades> unidadesCollection;

	public String getNomeTipoLogradouro() {
		return nomeTipoLogradouro;
	}

	public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
		this.nomeTipoLogradouro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeTipoLogradouro);
	}

	public String getDescricaoTipoLogradouro() {
		return descricaoTipoLogradouro;
	}

	public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
		this.descricaoTipoLogradouro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoTipoLogradouro);
	}

	public List<Enderecos> getEnderecosCollection() {
		return enderecosCollection;
	}

	public void setEnderecosCollection(List<Enderecos> enderecosCollection) {
		this.enderecosCollection = enderecosCollection;
	}

	public List<Unidades> getUnidadesCollection() {
		return unidadesCollection;
	}

	public void setUnidadesCollection(List<Unidades> unidadesCollection) {
		this.unidadesCollection = unidadesCollection;
	}

}
