package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_soma_irf_codigo")
public class RubricaSomaIrfCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaSomaIrf> rubricaSomaIrfList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaSomaIrfFuncionario> rubricaSomaIrfFuncionarioList;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<RubricaSomaIrf> getRubricaSomaIrfList() {
		return rubricaSomaIrfList;
	}
	public void setRubricaSomaIrfList(List<RubricaSomaIrf> rubricaSomaIrfList) {
		this.rubricaSomaIrfList = rubricaSomaIrfList;
	}
	public List<RubricaSomaIrfFuncionario> getRubricaSomaIrfFuncionarioList() {
		return rubricaSomaIrfFuncionarioList;
	}
	public void setRubricaSomaIrfFuncionarioList(List<RubricaSomaIrfFuncionario> rubricaSomaIrfFuncionarioList) {
		this.rubricaSomaIrfFuncionarioList = rubricaSomaIrfFuncionarioList;
	}
    
    
    
	
}
