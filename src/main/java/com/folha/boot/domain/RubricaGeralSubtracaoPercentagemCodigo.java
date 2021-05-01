package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_geral_subtracao_percentagem_codigo")
public class RubricaGeralSubtracaoPercentagemCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSubtracaoPercentagemFuncionario> rubricaGeralSubtracaoPercentagemFuncionarioList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSubtracaoPercentagem> rubricaGeralSubtracaoPercentagemList;
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
	public List<RubricaGeralSubtracaoPercentagemFuncionario> getRubricaGeralSubtracaoPercentagemFuncionarioList() {
		return rubricaGeralSubtracaoPercentagemFuncionarioList;
	}
	public void setRubricaGeralSubtracaoPercentagemFuncionarioList(
			List<RubricaGeralSubtracaoPercentagemFuncionario> rubricaGeralSubtracaoPercentagemFuncionarioList) {
		this.rubricaGeralSubtracaoPercentagemFuncionarioList = rubricaGeralSubtracaoPercentagemFuncionarioList;
	}
	public List<RubricaGeralSubtracaoPercentagem> getRubricaGeralSubtracaoPercentagemList() {
		return rubricaGeralSubtracaoPercentagemList;
	}
	public void setRubricaGeralSubtracaoPercentagemList(
			List<RubricaGeralSubtracaoPercentagem> rubricaGeralSubtracaoPercentagemList) {
		this.rubricaGeralSubtracaoPercentagemList = rubricaGeralSubtracaoPercentagemList;
	}
    
    
    
    
	
}
