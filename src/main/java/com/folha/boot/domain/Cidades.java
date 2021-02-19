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
	private List<Enderecos> enderecosCollection;

	@OneToMany(mappedBy = "idEnderecoCidadeFk")
	private List<Unidades> unidadesCollection;

	@OneToMany(mappedBy = "seqCidadeNatal")
	private List<Pessoa> pessoaCollection;

	@OneToMany(mappedBy = "idCidadeFk")
	private List<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection;

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

	public List<Pessoa> getPessoaCollection() {
		return pessoaCollection;
	}

	public void setPessoaCollection(List<Pessoa> pessoaCollection) {
		this.pessoaCollection = pessoaCollection;
	}

	public List<PessoaDocumentosTitulo> getPessoaDocumentosTituloCollection() {
		return pessoaDocumentosTituloCollection;
	}

	public void setPessoaDocumentosTituloCollection(List<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection) {
		this.pessoaDocumentosTituloCollection = pessoaDocumentosTituloCollection;
	}

}
