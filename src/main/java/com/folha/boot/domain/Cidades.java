package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "cidades")
public class Cidades extends AbstractEntity<Long> {

	@Column(name = "nome_cidade", nullable = false, length = 150)
	private String nomeCidade;

	@JoinColumn(name = "id_pais_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Paises idPaisFk;

	@JoinColumn(name = "id_uf_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Uf idUfFk;

	@OneToMany(mappedBy = "idEnderecoCidadeFk")
	private List<Enderecos> enderecosList;

	@OneToMany(mappedBy = "idEnderecoCidadeFk")
	private List<Unidades> unidadesList;

	@OneToMany(mappedBy = "seqCidadeNatal")
	private List<Pessoa> pessoaList;

	@OneToMany(mappedBy = "idCidadeFk")
	private List<PessoaDocumentosTitulo> pessoaDocumentosTituloList;

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCidade);
	}

	public Paises getIdPaisFk() {
		return idPaisFk;
	}

	public void setIdPaisFk(Paises idPaisFk) {
		this.idPaisFk = idPaisFk;
	}

	public Uf getIdUfFk() {
		return idUfFk;
	}

	public void setIdUfFk(Uf idUfFk) {
		this.idUfFk = idUfFk;
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

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

	public List<PessoaDocumentosTitulo> getPessoaDocumentosTituloList() {
		return pessoaDocumentosTituloList;
	}

	public void setPessoaDocumentosTituloList(List<PessoaDocumentosTitulo> pessoaDocumentosTituloList) {
		this.pessoaDocumentosTituloList = pessoaDocumentosTituloList;
	}

}
