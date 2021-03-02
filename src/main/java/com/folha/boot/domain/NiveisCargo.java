package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "niveis_cargo")
public class NiveisCargo extends AbstractEntity<Long> {

	@Column(name="descricao_nivel_cargo")
	private String descricaoNivelCargo;

	@Column(name="nome_nivel_cargo")
	private String nomeNivelCargo;

	@Column(name="sigla_nivel_cargo")
	private String siglaNivelCargo;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="niveisCargo")
	private List<Cargos> cargos;

	public NiveisCargo() {
	}

	public String getDescricaoNivelCargo() {
		return this.descricaoNivelCargo;
	}

	public void setDescricaoNivelCargo(String descricaoNivelCargo) {
		this.descricaoNivelCargo = descricaoNivelCargo;
	}

	public String getNomeNivelCargo() {
		return this.nomeNivelCargo;
	}

	public void setNomeNivelCargo(String nomeNivelCargo) {
		this.nomeNivelCargo = nomeNivelCargo;
	}

	public String getSiglaNivelCargo() {
		return this.siglaNivelCargo;
	}

	public void setSiglaNivelCargo(String siglaNivelCargo) {
		this.siglaNivelCargo = siglaNivelCargo;
	}

	public List<Cargos> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargos> cargos) {
		this.cargos = cargos;
	}

	public Cargos addCargo(Cargos cargo) {
		getCargos().add(cargo);
		cargo.setNiveisCargo(this);

		return cargo;
	}

	public Cargos removeCargo(Cargos cargo) {
		getCargos().remove(cargo);
		cargo.setNiveisCargo(null);

		return cargo;
	}

}
