package com.folha.boot.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_valores_licenca_maternidade")
public class FaixasValoresLicencaMaternidade extends AbstractEntity<Long> {

	
	@Column(name = "dt_ultima_mudanca")
    @Temporal(TemporalType.DATE)
    private Date dtUltimaMudanca;
	@Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
    @Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_bruto_por_dia")
    private Double valorBrutoPorDia;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    
    @JoinColumn(name = "id_operador_ultima_mudanca_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorUltimaMudancaFk;
    
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

    public FaixasValoresLicencaMaternidade() {
    }

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
	}

	public Double getValorBrutoPorDia() {
		return valorBrutoPorDia;
	}

	public void setValorBrutoPorDia(Double valorBrutoPorDia) {
		this.valorBrutoPorDia = valorBrutoPorDia;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
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

	public PessoaOperadores getIdOperadorCadastroFk() {
		return idOperadorCadastroFk;
	}

	public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}

	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}

	public Date getDtUltimaMudanca() {
		return dtUltimaMudanca;
	}

	public void setDtUltimaMudanca(Date dtUltimaMudanca) {
		this.dtUltimaMudanca = dtUltimaMudanca;
	}

	public PessoaOperadores getIdOperadorUltimaMudancaFk() {
		return idOperadorUltimaMudancaFk;
	}

	public void setIdOperadorUltimaMudancaFk(PessoaOperadores idOperadorUltimaMudancaFk) {
		this.idOperadorUltimaMudancaFk = idOperadorUltimaMudancaFk;
	}

    
    
	
}
