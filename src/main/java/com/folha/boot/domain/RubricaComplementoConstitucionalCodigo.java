package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_complemento_constitucional_codigo")
public class RubricaComplementoConstitucionalCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaComplementoConstitucional> rubricaComplementoConstitucionalList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaComplementoConstitucionalFuncionario> rubricaComplementoConstitucionalFuncionarioList;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(codigo);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}
	public List<RubricaComplementoConstitucional> getRubricaComplementoConstitucionalList() {
		return rubricaComplementoConstitucionalList;
	}
	public void setRubricaComplementoConstitucionalList(
			List<RubricaComplementoConstitucional> rubricaComplementoConstitucionalList) {
		this.rubricaComplementoConstitucionalList = rubricaComplementoConstitucionalList;
	}
	public List<RubricaComplementoConstitucionalFuncionario> getRubricaComplementoConstitucionalFuncionarioList() {
		return rubricaComplementoConstitucionalFuncionarioList;
	}
	public void setRubricaComplementoConstitucionalFuncionarioList(
			List<RubricaComplementoConstitucionalFuncionario> rubricaComplementoConstitucionalFuncionarioList) {
		this.rubricaComplementoConstitucionalFuncionarioList = rubricaComplementoConstitucionalFuncionarioList;
	}
    
    
	
}
