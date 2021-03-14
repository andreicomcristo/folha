package com.folha.boot.domain;

import javax.persistence.*;
import java.util.List;


@SuppressWarnings("serial")
@Entity
@Table(name="tipos_de_licenca")

public class TiposDeLicenca extends AbstractEntity<Long>  {

	@Column(name = "descricao_tipo_licenca")
    private String descricaoTipoLicenca;
    
	@OneToMany(mappedBy = "idTipoLicencaFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
	
    public String getDescricaoTipoLicenca() {
		return descricaoTipoLicenca;
	}
    
	public void setDescricaoTipoLicenca(String descricaoTipoLicenca) {
		this.descricaoTipoLicenca = descricaoTipoLicenca;
	}
	
	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}
	
	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}
    
}