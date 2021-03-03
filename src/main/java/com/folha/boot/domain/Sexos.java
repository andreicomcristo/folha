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
	private List<Pessoa> pessoaList;

	@OneToMany(mappedBy = "seqSexo")
	private List<Pessoa> pessoaList1;

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

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

	public List<Pessoa> getPessoaList1() {
		return pessoaList1;
	}

	public void setPessoaList1(List<Pessoa> pessoaList1) {
		this.pessoaList1 = pessoaList1;
	}
}
