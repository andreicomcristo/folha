package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "niveis_cargo")
public class NiveisCargo extends AbstractEntity<Long> {

	/*@Column(name = "id", nullable = false)
	private Long id;*/

	@Column(name = "sigla_nivel_cargo", nullable = false, length = 10)
	private String siglaNivelCargo;

	@Column(name = "nome_nivel_cargo", nullable = false, length = 150)
	private String nomeNivelCargo;

	@Column(name = "descricao_nivel_cargo", length = 300)
	private String descricaoNivelCargo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelCargoFk")
	private List<Cargos> cargosCollection;

	public String getSiglaNivelCargo() {
		return siglaNivelCargo;
	}

	public void setSiglaNivelCargo(String siglaNivelCargo) {
		this.siglaNivelCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaNivelCargo);
	}

	public String getNomeNivelCargo() {
		return nomeNivelCargo;
	}

	public void setNomeNivelCargo(String nomeNivelCargo) {
		this.nomeNivelCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNivelCargo);
	}

	public String getDescricaoNivelCargo() {
		return descricaoNivelCargo;
	}

	public void setDescricaoNivelCargo(String descricaoNivelCargo) {
		this.descricaoNivelCargo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNivelCargo);
	}

	public List<Cargos> getCargosCollection() {
		return cargosCollection;
	}

	public void setCargosCollection(List<Cargos> cargosCollection) {
		this.cargosCollection = cargosCollection;
	}

}
