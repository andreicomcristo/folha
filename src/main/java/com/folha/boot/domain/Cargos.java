package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos")
public class Cargos extends AbstractEntity<Long> {

    @Column(name = "nome_cargo")
    private String nomeCargo;
    @Column(name = "descricao_cargo")
    private String descricaoCargo;
    @OneToMany(mappedBy = "idCargoFk")
    private List<CargosEspecialidade> cargosEspecialidadeList;
    @OneToMany(mappedBy = "idCargoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargoFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList;
    @JoinColumn(name = "id_nivel_cargo_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NiveisCargo idNivelCargoFk;
    @OneToMany(mappedBy = "idCargoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(mappedBy = "idCargoFk")
    private List<IncrementoDeRiscoUnidadeCargo> incrementoDeRiscoUnidadeCargoList;
    
    
	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}

	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosList() {
		return histFuncionariosCargosList;
	}

	public void setHistFuncionariosCargosList(List<HistFuncionariosCargos> histFuncionariosCargosList) {
		this.histFuncionariosCargosList = histFuncionariosCargosList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public List<CargosEspecialidade> getCargosEspecialidadeList() {
		return cargosEspecialidadeList;
	}

	public void setCargosEspecialidadeList(List<CargosEspecialidade> cargosEspecialidadeList) {
		this.cargosEspecialidadeList = cargosEspecialidadeList;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCargo);
	}

	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargo);;
	}

	public NiveisCargo getIdNivelCargoFk() {
		return idNivelCargoFk;
	}

	public void setIdNivelCargoFk(NiveisCargo idNivelCargoFk) {
		this.idNivelCargoFk = idNivelCargoFk;
	}

	public List<IncrementoDeRiscoUnidadeCargo> getIncrementoDeRiscoUnidadeCargoList() {
		return incrementoDeRiscoUnidadeCargoList;
	}

	public void setIncrementoDeRiscoUnidadeCargoList(
			List<IncrementoDeRiscoUnidadeCargo> incrementoDeRiscoUnidadeCargoList) {
		this.incrementoDeRiscoUnidadeCargoList = incrementoDeRiscoUnidadeCargoList;
	}
	
	
}
