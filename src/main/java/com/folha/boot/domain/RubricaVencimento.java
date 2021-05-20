package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Transactional
@Table(name = "rubrica_vencimento")
public class RubricaVencimento extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "variacao")
    private String variacao;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "sequencia")
    private Integer sequencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_bruto")
    private Double valorBruto;
    @Column(name = "valor_liquido")
    private Double valorLiquido;
    @Column(name = "valor_ir")
    private Double valorIr;
    @Column(name = "valor_previdencia")
    private Double valorPrevidencia;
    @Column(name = "valor_patronal")
    private Double valorPatronal;
    @Column(name = "percentagem")
    private Double percentagem;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_natureza_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaNatureza idNaturezaFk;
    @JoinColumn(name = "id_tipo_bruto_liquido_fk", referencedColumnName = "id")
    @ManyToOne
    private TipoBrutoLiquido idTipoBrutoLiquidoFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
    @JoinColumn(name = "id_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idFolhaFk;
    @Column(name = "desconto_prop")
    private Double descontoProp;
    @Column(name = "pensao_prop")
    private Double pensaoProp;

    public RubricaVencimento() {
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getVariacao() {
		return variacao;
	}

	public void setVariacao(String variacao) {
		this.variacao = variacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
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

	public Double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public Fonte getIdFonteFk() {
		return idFonteFk;
	}

	public void setIdFonteFk(Fonte idFonteFk) {
		this.idFonteFk = idFonteFk;
	}

	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}

	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}

	public RubricaNatureza getIdNaturezaFk() {
		return idNaturezaFk;
	}

	public void setIdNaturezaFk(RubricaNatureza idNaturezaFk) {
		this.idNaturezaFk = idNaturezaFk;
	}

	public TipoBrutoLiquido getIdTipoBrutoLiquidoFk() {
		return idTipoBrutoLiquidoFk;
	}

	public void setIdTipoBrutoLiquidoFk(TipoBrutoLiquido idTipoBrutoLiquidoFk) {
		this.idTipoBrutoLiquidoFk = idTipoBrutoLiquidoFk;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}

	public TiposDeFolha getIdFolhaFk() {
		return idFolhaFk;
	}

	public void setIdFolhaFk(TiposDeFolha idFolhaFk) {
		this.idFolhaFk = idFolhaFk;
	}

	public Double getDescontoProp() {
		return descontoProp;
	}

	public void setDescontoProp(Double descontoProp) {
		this.descontoProp = descontoProp;
	}

	public Double getPensaoProp() {
		return pensaoProp;
	}

	public void setPensaoProp(Double pensaoProp) {
		this.pensaoProp = pensaoProp;
	}
    
    
      
}
