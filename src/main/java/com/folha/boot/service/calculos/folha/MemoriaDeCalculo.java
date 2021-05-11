package com.folha.boot.service.calculos.folha;

import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.Unidades;

public class MemoriaDeCalculo {

	private int id;	
	private Funcionario funcionario;
	private AnoMes anoMes;
	private String codigoDaRubrica;
	private String descricao;
	private Fonte fonte;
	private Unidades unidade;
	private Double vantegem;
	private Double desconto;
	private Double acumulado;
	private Double base;
	private Double bruto;
	private Double liquido;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public AnoMes getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}
	public String getCodigoDaRubrica() {
		return codigoDaRubrica;
	}
	public void setCodigoDaRubrica(String codigoDaRubrica) {
		this.codigoDaRubrica = codigoDaRubrica;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getVantegem() {
		return vantegem;
	}
	public void setVantegem(Double vantegem) {
		this.vantegem = vantegem;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getAcumulado() {
		return acumulado;
	}
	public void setAcumulado(Double acumulado) {
		this.acumulado = acumulado;
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
	public Double getBase() {
		return base;
	}
	public void setBase(Double base) {
		this.base = base;
	}
	public Double getBruto() {
		return bruto;
	}
	public void setBruto(Double bruto) {
		this.bruto = bruto;
	}
	public Double getLiquido() {
		return liquido;
	}
	public void setLiquido(Double liquido) {
		this.liquido = liquido;
	}
	
}
