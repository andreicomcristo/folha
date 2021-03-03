package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios_ferias")
public class FuncionariosFerias extends AbstractEntity<Long> {

	@Column(name = "ano_referencia")
    private String anoReferencia;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFeriasFk")
    private List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodosList;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_unidade_lancamento_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeLancamentoFk;
	public String getAnoReferencia() {
		return anoReferencia;
	}
	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
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
	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}
	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}
	public List<FuncionariosFeriasPeriodos> getFuncionariosFeriasPeriodosList() {
		return funcionariosFeriasPeriodosList;
	}
	public void setFuncionariosFeriasPeriodosList(List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodosList) {
		this.funcionariosFeriasPeriodosList = funcionariosFeriasPeriodosList;
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
	public Unidades getIdUnidadeLancamentoFk() {
		return idUnidadeLancamentoFk;
	}
	public void setIdUnidadeLancamentoFk(Unidades idUnidadeLancamentoFk) {
		this.idUnidadeLancamentoFk = idUnidadeLancamentoFk;
	}

}