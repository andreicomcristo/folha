package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos")
public class Cargos extends AbstractEntity<Long> {

	@Column(name = "nome_cargo", length = 150)
	private String nomeCargo;

	@Column(name = "descricao_cargo", length = 300)
	private String descricaoCargo;

	@OneToMany(mappedBy = "idCargoFk")
	private List<CargosEspecialidade> cargosEspecialidadeCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargoFk")
	private List<HistFuncionariosCargos> histFuncionariosCargosCollection;

	@JoinColumn(name = "id_nivel_cargo_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private NiveisCargo idNivelCargoFk;

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	public List<CargosEspecialidade> getCargosEspecialidadeCollection() {
		return cargosEspecialidadeCollection;
	}

	public void setCargosEspecialidadeCollection(List<CargosEspecialidade> cargosEspecialidadeCollection) {
		this.cargosEspecialidadeCollection = cargosEspecialidadeCollection;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosCollection() {
		return histFuncionariosCargosCollection;
	}

	public void setHistFuncionariosCargosCollection(List<HistFuncionariosCargos> histFuncionariosCargosCollection) {
		this.histFuncionariosCargosCollection = histFuncionariosCargosCollection;
	}

	public NiveisCargo getIdNivelCargoFk() {
		return idNivelCargoFk;
	}

	public void setIdNivelCargoFk(NiveisCargo idNivelCargoFk) {
		this.idNivelCargoFk = idNivelCargoFk;
	}

}
