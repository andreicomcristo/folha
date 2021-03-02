package com.folha.boot.domain;

import javax.persistence.*;
import java.util.List;


@SuppressWarnings("serial")
@Entity
@Table(name="tipos_de_licenca")

public class TiposDeLicenca extends AbstractEntity<Long>  {

	@Column(name="descricao_tipo_licenca")
	private String descricaoTipoLicenca;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="tiposDeLicenca")
	private List<FuncionariosLicencas> funcionariosLicencas;

	public TiposDeLicenca() {
	}

	public String getDescricaoTipoLicenca() {
		return this.descricaoTipoLicenca;
	}

	public void setDescricaoTipoLicenca(String descricaoTipoLicenca) {
		this.descricaoTipoLicenca = descricaoTipoLicenca;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas() {
		return this.funcionariosLicencas;
	}

	public void setFuncionariosLicencas(List<FuncionariosLicencas> funcionariosLicencas) {
		this.funcionariosLicencas = funcionariosLicencas;
	}

	public FuncionariosLicencas addFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().add(funcionariosLicenca);
		funcionariosLicenca.setTiposDeLicenca(this);

		return funcionariosLicenca;
	}

	public FuncionariosLicencas removeFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().remove(funcionariosLicenca);
		funcionariosLicenca.setTiposDeLicenca(null);

		return funcionariosLicenca;
	}

}