package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

import java.util.List;


@SuppressWarnings("serial")
@Entity
@Table(name="tipos_de_licenca")

public class TiposDeLicenca extends AbstractEntity<Long>  {

	@Column(name = "descricao_tipo_licenca")
    private String descricaoTipoLicenca;
	
	@Column(name = "limite_dias")
    private Integer limiteDias;
    
	@OneToMany(mappedBy = "idTipoLicencaFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
	
    public String getDescricaoTipoLicenca() {
		return descricaoTipoLicenca;
	}
    
	public void setDescricaoTipoLicenca(String descricaoTipoLicenca) {
		this.descricaoTipoLicenca = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoTipoLicenca);
	}
	
	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}
	
	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public Integer getLimiteDias() {
		return limiteDias;
	}

	public void setLimiteDias(Integer limiteDias) {
		this.limiteDias = limiteDias;
	}
    
}