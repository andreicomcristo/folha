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
@Table(name = "rubrica_tipo")
public class RubricaTipo extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "sequencia")
    private Integer sequencia;
    @OneToMany(mappedBy = "idTipoFk")
    private List<RubricaCodigo> rubricaCodigoList;

    public RubricaTipo() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public List<RubricaCodigo> getRubricaCodigoList() {
		return rubricaCodigoList;
	}

	public void setRubricaCodigoList(List<RubricaCodigo> rubricaCodigoList) {
		this.rubricaCodigoList = rubricaCodigoList;
	}
    
    

    
	
    
	
	
	
}
