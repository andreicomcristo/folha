package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_insalubridade_codigo")
public class RubricaInsalubridadeCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaInsalubridadeFuncionario> rubricaInsalubridadeFuncionarioList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaInsalubridade> rubricaInsalubridadeList;
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
	public List<RubricaInsalubridadeFuncionario> getRubricaInsalubridadeFuncionarioList() {
		return rubricaInsalubridadeFuncionarioList;
	}
	public void setRubricaInsalubridadeFuncionarioList(
			List<RubricaInsalubridadeFuncionario> rubricaInsalubridadeFuncionarioList) {
		this.rubricaInsalubridadeFuncionarioList = rubricaInsalubridadeFuncionarioList;
	}
	public List<RubricaInsalubridade> getRubricaInsalubridadeList() {
		return rubricaInsalubridadeList;
	}
	public void setRubricaInsalubridadeList(List<RubricaInsalubridade> rubricaInsalubridadeList) {
		this.rubricaInsalubridadeList = rubricaInsalubridadeList;
	}
    
    
    
    
    
	
}
