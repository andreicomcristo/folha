package com.folha.boot.domain.models.calculos;


import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaNatureza;
import com.folha.boot.domain.TipoBrutoLiquido;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.util.UtilidadesDeTexto;

public class RubricasVencimento {
	
	String codigo;
	String variacao;
	String descricao;
	int sequencia;
	RubricaNatureza natureza;
	TipoBrutoLiquido tipoBrutoLiquido;
	Fonte fonte;
	Unidades unidade;
	PessoaFuncionarios pessoaFuncionarios;
	AnoMes anoMes;
	Double valorBruto;
	Double valorLiquido;
	Double valorIr;
	Double valorPrevidencia;
	Double valorPatronal;
	Double percentagem;
	
	
	
	public RubricasVencimento() {
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(codigo);
	}
	public String getVariacao() {
		return variacao;
	}
	public void setVariacao(String variacao) {
		this.variacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(variacao);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}
	
	public RubricaNatureza getNatureza() {
		return natureza;
	}
	public void setNatureza(RubricaNatureza natureza) {
		this.natureza = natureza;
	}
	public TipoBrutoLiquido getTipoBrutoLiquido() {
		return tipoBrutoLiquido;
	}
	public void setTipoBrutoLiquido(TipoBrutoLiquido tipoBrutoLiquido) {
		this.tipoBrutoLiquido = tipoBrutoLiquido;
	}
	public Fonte getFonte() {
		return fonte;
	}
	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}
	public Unidades getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}
	public PessoaFuncionarios getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}
	public void setPessoaFuncionarios(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}
	public AnoMes getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}
	public Double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}
	public Double getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public Double getPercentagem() {
		return percentagem;
	}
	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}
	public int getSequencia() {
		return sequencia;
	}
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

	public Double getValorIr() {
		return valorIr;
	}

	public void setValorIr(Double valorIr) {
		this.valorIr = valorIr;
	}

	public Double getValorPrevidencia() {
		return valorPrevidencia;
	}

	public void setValorPrevidencia(Double valorPrevidencia) {
		this.valorPrevidencia = valorPrevidencia;
	}

	public Double getValorPatronal() {
		return valorPatronal;
	}

	public void setValorPatronal(Double valorPatronal) {
		this.valorPatronal = valorPatronal;
	}
	
	
	
}
