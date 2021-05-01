package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_geral_soma_codigo")
public class RubricaGeralSomaCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSomaFuncionario> rubricaGeralSomaFuncionarioList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSoma> rubricaGeralSomaList;
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
	public List<RubricaGeralSomaFuncionario> getRubricaGeralSomaFuncionarioList() {
		return rubricaGeralSomaFuncionarioList;
	}
	public void setRubricaGeralSomaFuncionarioList(List<RubricaGeralSomaFuncionario> rubricaGeralSomaFuncionarioList) {
		this.rubricaGeralSomaFuncionarioList = rubricaGeralSomaFuncionarioList;
	}
	public List<RubricaGeralSoma> getRubricaGeralSomaList() {
		return rubricaGeralSomaList;
	}
	public void setRubricaGeralSomaList(List<RubricaGeralSoma> rubricaGeralSomaList) {
		this.rubricaGeralSomaList = rubricaGeralSomaList;
	}
    
    
	
}
