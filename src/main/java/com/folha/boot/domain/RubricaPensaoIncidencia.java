package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_pensao_incidencia")
public class RubricaPensaoIncidencia extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
	@Column(name = "sigla")
    private String sigla;
    @OneToMany(mappedBy = "idIncidenciaFk")
    private List<RubricaPensao> rubricaPensaoList;

    public RubricaPensaoIncidencia() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}

	public List<RubricaPensao> getRubricaPensaoList() {
		return rubricaPensaoList;
	}

	public void setRubricaPensaoList(List<RubricaPensao> rubricaPensaoList) {
		this.rubricaPensaoList = rubricaPensaoList;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(sigla);
	}
    
    
	
}
