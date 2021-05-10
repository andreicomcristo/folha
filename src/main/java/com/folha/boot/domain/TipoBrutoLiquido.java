package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipo_bruto_liquido")
public class TipoBrutoLiquido extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<RubricaCodigo> rubricaCodigoList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<CodigoDiferenciado> codigoDiferenciadoList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresIncentivoDeRisco> faixasValoresIncentivoDeRiscoList;


    public TipoBrutoLiquido() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}

	public List<RubricaCodigo> getRubricaCodigoList() {
		return rubricaCodigoList;
	}

	public void setRubricaCodigoList(List<RubricaCodigo> rubricaCodigoList) {
		this.rubricaCodigoList = rubricaCodigoList;
	}

	public List<CodigoDiferenciado> getCodigoDiferenciadoList() {
		return codigoDiferenciadoList;
	}

	public void setCodigoDiferenciadoList(List<CodigoDiferenciado> codigoDiferenciadoList) {
		this.codigoDiferenciadoList = codigoDiferenciadoList;
	}

	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}

	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}

	public List<FaixasValoresIncentivoDeRisco> getFaixasValoresIncentivoDeRiscoList() {
		return faixasValoresIncentivoDeRiscoList;
	}

	public void setFaixasValoresIncentivoDeRiscoList(
			List<FaixasValoresIncentivoDeRisco> faixasValoresIncentivoDeRiscoList) {
		this.faixasValoresIncentivoDeRiscoList = faixasValoresIncentivoDeRiscoList;
	}
    
    
      
}
