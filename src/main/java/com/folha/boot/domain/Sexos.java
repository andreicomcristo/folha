package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "sexos")
public class Sexos extends AbstractEntity<Long> {

	@Column(name = "nome_sexo", nullable = false, length = 100)
	private String nomeSexo;

	@Column(name = "descricao_sexo", length = 300)
	private String descricaoSexo;

	@OneToMany(mappedBy = "seqSexoDeclarado")
	private List<Pessoa> pessoaCollection;

	@OneToMany(mappedBy = "seqSexo")
	private List<Pessoa> pessoaCollection1;

	public String getNomeSexo() {
		return nomeSexo;
	}

	public void setNomeSexo(String nomeSexo) {
		this.nomeSexo = nomeSexo;
	}

	public String getDescricaoSexo() {
		return descricaoSexo;
	}

	public void setDescricaoSexo(String descricaoSexo) {
		this.descricaoSexo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoSexo);
	}

	public List<Pessoa> getPessoaCollection() {
		return pessoaCollection;
	}

	public void setPessoaCollection(List<Pessoa> pessoaCollection) {
		this.pessoaCollection = pessoaCollection;
	}

	public List<Pessoa> getPessoaCollection1() {
		return pessoaCollection1;
	}

	public void setPessoaCollection1(List<Pessoa> pessoaCollection1) {
		this.pessoaCollection1 = pessoaCollection1;
	}

}
