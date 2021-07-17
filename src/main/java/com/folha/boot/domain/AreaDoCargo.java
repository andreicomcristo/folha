package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "area_do_cargo")
public class AreaDoCargo extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idAreaDoCargoFk")
    private List<CargosEspecialidade> cargosEspecialidadeList;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<CargosEspecialidade> getCargosEspecialidadeList() {
		return cargosEspecialidadeList;
	}
	public void setCargosEspecialidadeList(List<CargosEspecialidade> cargosEspecialidadeList) {
		this.cargosEspecialidadeList = cargosEspecialidadeList;
	}
    	
    
}
