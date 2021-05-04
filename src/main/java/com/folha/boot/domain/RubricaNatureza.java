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
    private List<RubricaComplementoConstitucionalCodigo> rubricaComplementoConstitucionalCodigoList;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaGeralSubtracaoPercentagemCodigo> rubricaGeralSubtracaoPercentagemCodigoList;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaGeralSomaPercentagemCodigo> rubricaGeralSomaPercentagemCodigoList;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaGeralSubtracaoCodigo> rubricaGeralSubtracaoCodigoList;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaDescontoPensaoFuncionario> rubricaDescontoPensaoFuncionarioList;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaInsalubridadeCodigo> rubricaInsalubridadeCodigoList;
    @OneToMany(mappedBy = "idNaturezaFk")
    private List<RubricaSomaIrfCodigo> rubricaSomaIrfCodigoList;
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
	public List<RubricaComplementoConstitucionalCodigo> getRubricaComplementoConstitucionalCodigoList() {
		return rubricaComplementoConstitucionalCodigoList;
	}
	public void setRubricaComplementoConstitucionalCodigoList(
			List<RubricaComplementoConstitucionalCodigo> rubricaComplementoConstitucionalCodigoList) {
		this.rubricaComplementoConstitucionalCodigoList = rubricaComplementoConstitucionalCodigoList;
	}
	public List<RubricaGeralSubtracaoPercentagemCodigo> getRubricaGeralSubtracaoPercentagemCodigoList() {
		return rubricaGeralSubtracaoPercentagemCodigoList;
	}
	public void setRubricaGeralSubtracaoPercentagemCodigoList(
			List<RubricaGeralSubtracaoPercentagemCodigo> rubricaGeralSubtracaoPercentagemCodigoList) {
		this.rubricaGeralSubtracaoPercentagemCodigoList = rubricaGeralSubtracaoPercentagemCodigoList;
	}
	public List<RubricaGeralSomaPercentagemCodigo> getRubricaGeralSomaPercentagemCodigoList() {
		return rubricaGeralSomaPercentagemCodigoList;
	}
	public void setRubricaGeralSomaPercentagemCodigoList(
			List<RubricaGeralSomaPercentagemCodigo> rubricaGeralSomaPercentagemCodigoList) {
		this.rubricaGeralSomaPercentagemCodigoList = rubricaGeralSomaPercentagemCodigoList;
	}
	public List<RubricaGeralSubtracaoCodigo> getRubricaGeralSubtracaoCodigoList() {
		return rubricaGeralSubtracaoCodigoList;
	}
	public void setRubricaGeralSubtracaoCodigoList(List<RubricaGeralSubtracaoCodigo> rubricaGeralSubtracaoCodigoList) {
		this.rubricaGeralSubtracaoCodigoList = rubricaGeralSubtracaoCodigoList;
	}
	public List<RubricaDescontoPensaoFuncionario> getRubricaDescontoPensaoFuncionarioList() {
		return rubricaDescontoPensaoFuncionarioList;
	}
	public void setRubricaDescontoPensaoFuncionarioList(
			List<RubricaDescontoPensaoFuncionario> rubricaDescontoPensaoFuncionarioList) {
		this.rubricaDescontoPensaoFuncionarioList = rubricaDescontoPensaoFuncionarioList;
	}
	public List<RubricaInsalubridadeCodigo> getRubricaInsalubridadeCodigoList() {
		return rubricaInsalubridadeCodigoList;
	}
	public void setRubricaInsalubridadeCodigoList(List<RubricaInsalubridadeCodigo> rubricaInsalubridadeCodigoList) {
		this.rubricaInsalubridadeCodigoList = rubricaInsalubridadeCodigoList;
	}
	public List<RubricaSomaIrfCodigo> getRubricaSomaIrfCodigoList() {
		return rubricaSomaIrfCodigoList;
	}
	public void setRubricaSomaIrfCodigoList(List<RubricaSomaIrfCodigo> rubricaSomaIrfCodigoList) {
		this.rubricaSomaIrfCodigoList = rubricaSomaIrfCodigoList;
	}

    
    
	
	
	
}
