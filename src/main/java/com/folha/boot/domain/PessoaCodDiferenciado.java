package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_cod_diferenciado")
public class PessoaCodDiferenciado extends AbstractEntity<Long> {

	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "observacao_cadastro")
    private String observacaoCadastro;
    @Column(name = "dt_confirmacao_sede")
    @Temporal(TemporalType.DATE)
    private Date dtConfirmacaoSede;
    @Column(name = "observacao_confirmacao")
    private String observacaoConfirmacao;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @JoinColumn(name = "id_cod_diferenciado_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodDiferenciadoFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_operador_confirmacao_sede_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorConfirmacaoSedeFk;
    
    @JoinColumn(name = "id_confirmacao_sede_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idConfirmacaoSedeSimNaoFk;
    
    
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getObservacaoCadastro() {
		return observacaoCadastro;
	}
	public void setObservacaoCadastro(String observacaoCadastro) {
		this.observacaoCadastro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacaoCadastro);
	}
	public Date getDtConfirmacaoSede() {
		return dtConfirmacaoSede;
	}
	public void setDtConfirmacaoSede(Date dtConfirmacaoSede) {
		this.dtConfirmacaoSede = dtConfirmacaoSede;
	}
	public String getObservacaoConfirmacao() {
		return observacaoConfirmacao;
	}
	public void setObservacaoConfirmacao(String observacaoConfirmacao) {
		this.observacaoConfirmacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacaoConfirmacao);
	}
	public Date getDtCancelamento() {
		return dtCancelamento;
	}
	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}
	public CodigoDiferenciado getIdCodDiferenciadoFk() {
		return idCodDiferenciadoFk;
	}
	public void setIdCodDiferenciadoFk(CodigoDiferenciado idCodDiferenciadoFk) {
		this.idCodDiferenciadoFk = idCodDiferenciadoFk;
	}
	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}
	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
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
	public PessoaOperadores getIdOperadorConfirmacaoSedeFk() {
		return idOperadorConfirmacaoSedeFk;
	}
	public void setIdOperadorConfirmacaoSedeFk(PessoaOperadores idOperadorConfirmacaoSedeFk) {
		this.idOperadorConfirmacaoSedeFk = idOperadorConfirmacaoSedeFk;
	}
	public SimNao getIdConfirmacaoSedeSimNaoFk() {
		return idConfirmacaoSedeSimNaoFk;
	}
	public void setIdConfirmacaoSedeSimNaoFk(SimNao idConfirmacaoSedeSimNaoFk) {
		this.idConfirmacaoSedeSimNaoFk = idConfirmacaoSedeSimNaoFk;
	}
	
    
    
}
