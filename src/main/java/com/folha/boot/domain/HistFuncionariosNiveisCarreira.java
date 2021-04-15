package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

import java.util.Date;

/**
 * The persistent class for the hist_funcionarios_niveis_carreira database
 * table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hist_funcionarios_niveis_carreira")
public class HistFuncionariosNiveisCarreira extends AbstractEntity<Long> {

	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "motivo_cadastro")
    private String motivoCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @JoinColumn(name = "id_nivel_carreira_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCarreira idNivelCarreiraFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getMotivoCadastro() {
		return motivoCadastro;
	}
	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCadastro);
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
		this.motivoCancelamento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCancelamento);
	}
	public NiveisCarreira getIdNivelCarreiraFk() {
		return idNivelCarreiraFk;
	}
	public void setIdNivelCarreiraFk(NiveisCarreira idNivelCarreiraFk) {
		this.idNivelCarreiraFk = idNivelCarreiraFk;
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
    
}