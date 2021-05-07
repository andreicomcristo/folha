package com.folha.boot.domain.models.outros;



import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaCodigo;

public class VencimentosFuncionarioComValores {

	private Long id;
	private AnoMes idAnoMesFk;
    private PessoaFuncionarios idFuncionarioFk;
    private RubricaCodigo idCodigoFk;
    private Double valor;
    private Double percentagem;
    private Integer quantidade;
	
	
	public VencimentosFuncionarioComValores() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}


	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}


	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}


	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}


	public RubricaCodigo getIdCodigoFk() {
		return idCodigoFk;
	}


	public void setIdCodigoFk(RubricaCodigo idCodigoFk) {
		this.idCodigoFk = idCodigoFk;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Double getPercentagem() {
		return percentagem;
	}


	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	
		
	
}
