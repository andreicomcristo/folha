package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "paises")
public class Paises extends AbstractEntity<Long> {

	@Column(name = "nome_pais", nullable = false, length = 300)
	private String nomePais;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaisFk")
    private List<Cidades> cidadesList;
	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePais);
	}

	public List<Cidades> getCidadesList() {
		return cidadesList;
	}

	public void setCidadesList(List<Cidades> cidadesList) {
		this.cidadesList = cidadesList;
	}

}
