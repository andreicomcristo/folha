package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "bancos")
public class Bancos extends AbstractEntity<Long> {

	@Column(name="codigo_banco")
	private String codigoBanco;

	@Column(name="nome_banco")
	private String nomeBanco;

	@Column(name="sigla_banco")
	private String siglaBanco;

	//bi-directional many-to-one association to PessoaBanco
	@OneToMany(mappedBy="banco")
	private List<PessoaBancos> pessoaBancos;

	public Bancos() {
	}

	public String getCodigoBanco() {
		return this.codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNomeBanco() {
		return this.nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getSiglaBanco() {
		return this.siglaBanco;
	}

	public void setSiglaBanco(String siglaBanco) {
		this.siglaBanco = siglaBanco;
	}

	public List<PessoaBancos> getPessoaBancos() {
		return this.pessoaBancos;
	}

	public void setPessoaBancos(List<PessoaBancos> pessoaBancos) {
		this.pessoaBancos = pessoaBancos;
	}

	public PessoaBancos addPessoaBanco(PessoaBancos pessoaBanco) {
		getPessoaBancos().add(pessoaBanco);
		pessoaBanco.setBanco(this);

		return pessoaBanco;
	}

	public PessoaBancos removePessoaBanco(PessoaBancos pessoaBanco) {
		getPessoaBancos().remove(pessoaBanco);
		pessoaBanco.setBanco(null);

		return pessoaBanco;
	}

}
