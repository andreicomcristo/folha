package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos_especialidade")
public class CargosEspecialidade extends AbstractEntity<Long> {

	@Column(name = "nome_especialidade_cargo", nullable = false, length = 100)
	private String nomeEspecialidadeCargo;

	@Column(name = "descricao_especialidade_cargo", length = 300)
	private String descricaoEspecialidadeCargo;

	@JoinColumn(name = "id_cargo_fk", referencedColumnName = "id")
	@ManyToOne
	private Cargos idCargoFk;

	public String getNomeEspecialidadeCargo() {
		return nomeEspecialidadeCargo;
	}

	public void setNomeEspecialidadeCargo(String nomeEspecialidadeCargo) {
		this.nomeEspecialidadeCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEspecialidadeCargo);
	}

	public String getDescricaoEspecialidadeCargo() {
		return descricaoEspecialidadeCargo;
	}

	public void setDescricaoEspecialidadeCargo(String descricaoEspecialidadeCargo) {
		this.descricaoEspecialidadeCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEspecialidadeCargo);
	}

	public Cargos getIdCargoFk() {
		return idCargoFk;
	}

	public void setIdCargoFk(Cargos idCargoFk) {
		this.idCargoFk = idCargoFk;
	}

	
}
