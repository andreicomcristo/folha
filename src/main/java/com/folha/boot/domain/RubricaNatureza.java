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
@Table(name = "rubrica_natureza")
public class RubricaNatureza extends AbstractEntity<Long> {

	@Column(name = "sigla")
    private String sigla;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaGeralCodigo> rubricaGeralCodigoList;
    @OneToMany(mappedBy = "idNaturezaFk")
    
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<RubricaGeralCodigo> getRubricaGeralCodigoList() {
		return rubricaGeralCodigoList;
	}
	public void setRubricaGeralCodigoList(List<RubricaGeralCodigo> rubricaGeralCodigoList) {
		this.rubricaGeralCodigoList = rubricaGeralCodigoList;
	}
	
	
    
	
	
	
}
