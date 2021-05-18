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
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<RubricaVencimento> rubricaVencimentoList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresGpf> faixasValoresGpfList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresGpfMedica> faixasValoresGpfMedicaList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresGpfMedicaDiferenciada> faixasValoresGpfMedicaDiferenciadaList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresGpfDiferenciada> faixasValoresGpfDiferenciadaList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresPss> faixasValoresPssList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresGpfMedicaDiferenciadaDiarista> faixasValoresGpfMedicaDiferenciadaDiaristaList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresFolhExt> faixasValoresFolhExtList;
    @OneToMany(mappedBy = "idTipoBrutoLiquidoFk")
    private List<FaixasValoresResidente> faixasValoresResidenteList;

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

	public List<RubricaVencimento> getRubricaVencimentoList() {
		return rubricaVencimentoList;
	}

	public void setRubricaVencimentoList(List<RubricaVencimento> rubricaVencimentoList) {
		this.rubricaVencimentoList = rubricaVencimentoList;
	}

	public List<FaixasValoresGpf> getFaixasValoresGpfList() {
		return faixasValoresGpfList;
	}

	public void setFaixasValoresGpfList(List<FaixasValoresGpf> faixasValoresGpfList) {
		this.faixasValoresGpfList = faixasValoresGpfList;
	}

	public List<FaixasValoresGpfMedica> getFaixasValoresGpfMedicaList() {
		return faixasValoresGpfMedicaList;
	}

	public void setFaixasValoresGpfMedicaList(List<FaixasValoresGpfMedica> faixasValoresGpfMedicaList) {
		this.faixasValoresGpfMedicaList = faixasValoresGpfMedicaList;
	}

	public List<FaixasValoresGpfMedicaDiferenciada> getFaixasValoresGpfMedicaDiferenciadaList() {
		return faixasValoresGpfMedicaDiferenciadaList;
	}

	public void setFaixasValoresGpfMedicaDiferenciadaList(
			List<FaixasValoresGpfMedicaDiferenciada> faixasValoresGpfMedicaDiferenciadaList) {
		this.faixasValoresGpfMedicaDiferenciadaList = faixasValoresGpfMedicaDiferenciadaList;
	}

	public List<FaixasValoresGpfDiferenciada> getFaixasValoresGpfDiferenciadaList() {
		return faixasValoresGpfDiferenciadaList;
	}

	public void setFaixasValoresGpfDiferenciadaList(List<FaixasValoresGpfDiferenciada> faixasValoresGpfDiferenciadaList) {
		this.faixasValoresGpfDiferenciadaList = faixasValoresGpfDiferenciadaList;
	}

	public List<FaixasValoresPss> getFaixasValoresPssList() {
		return faixasValoresPssList;
	}

	public void setFaixasValoresPssList(List<FaixasValoresPss> faixasValoresPssList) {
		this.faixasValoresPssList = faixasValoresPssList;
	}

	public List<FaixasValoresGpfMedicaDiferenciadaDiarista> getFaixasValoresGpfMedicaDiferenciadaDiaristaList() {
		return faixasValoresGpfMedicaDiferenciadaDiaristaList;
	}

	public void setFaixasValoresGpfMedicaDiferenciadaDiaristaList(
			List<FaixasValoresGpfMedicaDiferenciadaDiarista> faixasValoresGpfMedicaDiferenciadaDiaristaList) {
		this.faixasValoresGpfMedicaDiferenciadaDiaristaList = faixasValoresGpfMedicaDiferenciadaDiaristaList;
	}

	public List<FaixasValoresFolhExt> getFaixasValoresFolhExtList() {
		return faixasValoresFolhExtList;
	}

	public void setFaixasValoresFolhExtList(List<FaixasValoresFolhExt> faixasValoresFolhExtList) {
		this.faixasValoresFolhExtList = faixasValoresFolhExtList;
	}

	public List<FaixasValoresResidente> getFaixasValoresResidenteList() {
		return faixasValoresResidenteList;
	}

	public void setFaixasValoresResidenteList(List<FaixasValoresResidente> faixasValoresResidenteList) {
		this.faixasValoresResidenteList = faixasValoresResidenteList;
	}
    
    
      
}
