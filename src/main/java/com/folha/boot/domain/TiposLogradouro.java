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
@Table(name = "tipos_logradouro")
public class TiposLogradouro extends AbstractEntity<Long> {

	@Column(name = "nome_tipo_logradouro", nullable = false, length = 150)
	private String nomeTipoLogradouro;

	@Column(name = "descricao_tipo_logradouro", length = 300)
	private String descricaoTipoLogradouro;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLogradouroFk")
	private List<Enderecos> enderecosList;

	@OneToMany(mappedBy = "idTipoLogradouroFk")
	private List<Unidades> unidadesList;

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

	public List<Enderecos> getEnderecosList() {
		return enderecosList;
	}

	public void setEnderecosList(List<Enderecos> enderecosList) {
		this.enderecosList = enderecosList;
	}

	public List<Unidades> getUnidadesList() {
		return unidadesList;
	}

	public void setUnidadesList(List<Unidades> unidadesList) {
		this.unidadesList = unidadesList;
	}


}
