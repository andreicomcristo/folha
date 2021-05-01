package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_geral_soma_percentagem_codigo")
public class RubricaGeralSomaPercentagemCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSomaPercentagemFuncionario> rubricaGeralSomaPercentagemFuncionarioList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSomaPercentagem> rubricaGeralSomaPercentagemList;
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
	public List<RubricaGeralSomaPercentagemFuncionario> getRubricaGeralSomaPercentagemFuncionarioList() {
		return rubricaGeralSomaPercentagemFuncionarioList;
	}
	public void setRubricaGeralSomaPercentagemFuncionarioList(
			List<RubricaGeralSomaPercentagemFuncionario> rubricaGeralSomaPercentagemFuncionarioList) {
		this.rubricaGeralSomaPercentagemFuncionarioList = rubricaGeralSomaPercentagemFuncionarioList;
	}
	public List<RubricaGeralSomaPercentagem> getRubricaGeralSomaPercentagemList() {
		return rubricaGeralSomaPercentagemList;
	}
	public void setRubricaGeralSomaPercentagemList(List<RubricaGeralSomaPercentagem> rubricaGeralSomaPercentagemList) {
		this.rubricaGeralSomaPercentagemList = rubricaGeralSomaPercentagemList;
	}
    
    
    
	
}
