package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_geral_subtracao_codigo")
public class RubricaGeralSubtracaoCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSubtracao> rubricaGeralSubtracaoList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralSubtracaoFuncionario> rubricaGeralSubtracaoFuncionarioList;
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
	public List<RubricaGeralSubtracao> getRubricaGeralSubtracaoList() {
		return rubricaGeralSubtracaoList;
	}
	public void setRubricaGeralSubtracaoList(List<RubricaGeralSubtracao> rubricaGeralSubtracaoList) {
		this.rubricaGeralSubtracaoList = rubricaGeralSubtracaoList;
	}
	public List<RubricaGeralSubtracaoFuncionario> getRubricaGeralSubtracaoFuncionarioList() {
		return rubricaGeralSubtracaoFuncionarioList;
	}
	public void setRubricaGeralSubtracaoFuncionarioList(
			List<RubricaGeralSubtracaoFuncionario> rubricaGeralSubtracaoFuncionarioList) {
		this.rubricaGeralSubtracaoFuncionarioList = rubricaGeralSubtracaoFuncionarioList;
	}
    
    
	
}
