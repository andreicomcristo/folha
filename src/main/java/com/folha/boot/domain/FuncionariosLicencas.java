package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios_licencas")
@Transactional
public class FuncionariosLicencas extends AbstractEntity<Long> { 

	
	@Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
    @Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_ultima_alteracao")
    @Temporal(TemporalType.DATE)
    private Date dtUltimaAlteracao;
    @Column(name = "dt_previdencia")
    @Temporal(TemporalType.DATE)
    private Date dtPrevidencia;
    @Column(name = "dt_publicacao_diario_oficial")
    @Temporal(TemporalType.DATE)
    private Date dtPublicacaoDiarioOficial;
    @Column(name = "dt_inicial_original")
    @Temporal(TemporalType.DATE)
    private Date dtInicialOriginal;
    @Column(name = "dt_final_original")
    @Temporal(TemporalType.DATE)
    private Date dtFinalOriginal;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;  
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;

    @JoinColumn(name = "id_corte_folha_efetiva_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idCorteFolhaEfetivaSimNaoFk;
    @JoinColumn(name = "id_cargo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoAtualFk;
    @JoinColumn(name = "id_cargo_especialidade_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private CargosEspecialidade idCargoEspecialidadeAtualFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_vinculo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Vinculos idVinculoAtualFk;
    @JoinColumn(name = "id_operador_ultima_alteracao_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorUltimaAlteracaoFk;
    @JoinColumn(name = "id_corte_folha_extra_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idCorteFolhaExtraSimNaoFk;
    @JoinColumn(name = "id_corte_adicional_noturno_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idCorteAdicionalNoturnoSimNaoFk;
    @JoinColumn(name = "id_pendencia_exame_comprobatorio_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idPendenciaExameComprobatorioSimNaoFk;
    @JoinColumn(name = "id_tipo_licenca_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeLicenca idTipoLicencaFk;
    @JoinColumn(name = "id_unidade_atuacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeAtuacaoAtualFk;
    @JoinColumn(name = "id_unidade_lotacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeLotacaoAtualFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionariosLicencasFk")
    private List<FuncionariosLicencasCid> funcionariosLicencasCidList;
    
    
    
    @JoinColumn(name = "id_categoria_fk", referencedColumnName = "id")
    @ManyToOne
    private CategoriaDeLicenca idCategoriaFk;
    
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
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public Date getDtUltimaAlteracao() {
		return dtUltimaAlteracao;
	}
	public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
		this.dtUltimaAlteracao = dtUltimaAlteracao;
	}
	public Date getDtPrevidencia() {
		return dtPrevidencia;
	}
	public void setDtPrevidencia(Date dtPrevidencia) {
		this.dtPrevidencia = dtPrevidencia;
	}
	public Date getDtPublicacaoDiarioOficial() {
		return dtPublicacaoDiarioOficial;
	}
	public void setDtPublicacaoDiarioOficial(Date dtPublicacaoDiarioOficial) {
		this.dtPublicacaoDiarioOficial = dtPublicacaoDiarioOficial;
	}
	public Date getDtInicialOriginal() {
		return dtInicialOriginal;
	}
	public void setDtInicialOriginal(Date dtInicialOriginal) {
		this.dtInicialOriginal = dtInicialOriginal;
	}
	public Date getDtFinalOriginal() {
		return dtFinalOriginal;
	}
	public void setDtFinalOriginal(Date dtFinalOriginal) {
		this.dtFinalOriginal = dtFinalOriginal;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
	public SimNao getIdCorteFolhaEfetivaSimNaoFk() {
		return idCorteFolhaEfetivaSimNaoFk;
	}
	public void setIdCorteFolhaEfetivaSimNaoFk(SimNao idCorteFolhaEfetivaSimNaoFk) {
		this.idCorteFolhaEfetivaSimNaoFk = idCorteFolhaEfetivaSimNaoFk;
	}
	public Cargos getIdCargoAtualFk() {
		return idCargoAtualFk;
	}
	public void setIdCargoAtualFk(Cargos idCargoAtualFk) {
		this.idCargoAtualFk = idCargoAtualFk;
	}
	public CargosEspecialidade getIdCargoEspecialidadeAtualFk() {
		return idCargoEspecialidadeAtualFk;
	}
	public void setIdCargoEspecialidadeAtualFk(CargosEspecialidade idCargoEspecialidadeAtualFk) {
		this.idCargoEspecialidadeAtualFk = idCargoEspecialidadeAtualFk;
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
	public Vinculos getIdVinculoAtualFk() {
		return idVinculoAtualFk;
	}
	public void setIdVinculoAtualFk(Vinculos idVinculoAtualFk) {
		this.idVinculoAtualFk = idVinculoAtualFk;
	}
	public PessoaOperadores getIdOperadorUltimaAlteracaoFk() {
		return idOperadorUltimaAlteracaoFk;
	}
	public void setIdOperadorUltimaAlteracaoFk(PessoaOperadores idOperadorUltimaAlteracaoFk) {
		this.idOperadorUltimaAlteracaoFk = idOperadorUltimaAlteracaoFk;
	}
	public SimNao getIdCorteFolhaExtraSimNaoFk() {
		return idCorteFolhaExtraSimNaoFk;
	}
	public void setIdCorteFolhaExtraSimNaoFk(SimNao idCorteFolhaExtraSimNaoFk) {
		this.idCorteFolhaExtraSimNaoFk = idCorteFolhaExtraSimNaoFk;
	}
	public SimNao getIdPendenciaExameComprobatorioSimNaoFk() {
		return idPendenciaExameComprobatorioSimNaoFk;
	}
	public void setIdPendenciaExameComprobatorioSimNaoFk(SimNao idPendenciaExameComprobatorioSimNaoFk) {
		this.idPendenciaExameComprobatorioSimNaoFk = idPendenciaExameComprobatorioSimNaoFk;
	}
	public TiposDeLicenca getIdTipoLicencaFk() {
		return idTipoLicencaFk;
	}
	public void setIdTipoLicencaFk(TiposDeLicenca idTipoLicencaFk) {
		this.idTipoLicencaFk = idTipoLicencaFk;
	}
	public Unidades getIdUnidadeAtuacaoAtualFk() {
		return idUnidadeAtuacaoAtualFk;
	}
	public void setIdUnidadeAtuacaoAtualFk(Unidades idUnidadeAtuacaoAtualFk) {
		this.idUnidadeAtuacaoAtualFk = idUnidadeAtuacaoAtualFk;
	}
	public Unidades getIdUnidadeLotacaoAtualFk() {
		return idUnidadeLotacaoAtualFk;
	}
	public void setIdUnidadeLotacaoAtualFk(Unidades idUnidadeLotacaoAtualFk) {
		this.idUnidadeLotacaoAtualFk = idUnidadeLotacaoAtualFk;
	}
	public List<FuncionariosLicencasCid> getFuncionariosLicencasCidList() {
		return funcionariosLicencasCidList;
	}
	public void setFuncionariosLicencasCidList(List<FuncionariosLicencasCid> funcionariosLicencasCidList) {
		this.funcionariosLicencasCidList = funcionariosLicencasCidList;
	}
	public CategoriaDeLicenca getIdCategoriaFk() {
		return idCategoriaFk;
	}
	public void setIdCategoriaFk(CategoriaDeLicenca idCategoriaFk) {
		this.idCategoriaFk = idCategoriaFk;
	}
	public SimNao getIdCorteAdicionalNoturnoSimNaoFk() {
		return idCorteAdicionalNoturnoSimNaoFk;
	}
	public void setIdCorteAdicionalNoturnoSimNaoFk(SimNao idCorteAdicionalNoturnoSimNaoFk) {
		this.idCorteAdicionalNoturnoSimNaoFk = idCorteAdicionalNoturnoSimNaoFk;
	}
	
    
    
}