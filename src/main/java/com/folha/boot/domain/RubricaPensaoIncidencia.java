package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_pensao_incidencia")
public class RubricaPensaoIncidencia extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idIncidenciaFk")
    private List<RubricaPensao> rubricaPensaoList;

    public RubricaPensaoIncidencia() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<RubricaPensao> getRubricaPensaoList() {
		return rubricaPensaoList;
	}

	public void setRubricaPensaoList(List<RubricaPensao> rubricaPensaoList) {
		this.rubricaPensaoList = rubricaPensaoList;
	}
    
    
	
}
