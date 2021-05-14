package com.folha.boot.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_funcionarios")
public class PessoaFuncionarios extends AbstractEntity<Long> {
    
    @Column(name = "matricula")
    private String matricula;
   
    @Column(name = "dt_nomeacao")
    @Temporal(TemporalType.DATE)
    private Date dtNomeacao;
    
    @Column(name = "dt_posse")
    @Temporal(TemporalType.DATE)
    private Date dtPosse;
    
    @Column(name = "numero_de_ordem")
    private String numeroDeOrdem;
    
    @Column(name = "numero_de_ponto")
    private String numeroDePonto;
    
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
    
    @JoinColumn(name = "id_especialidade_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private CargosEspecialidade idEspecialidadeAtualFk;
    
    @JoinColumn(name = "id_carga_horaria_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private CargaHorariaSemanal idCargaHorariaAtualFk;
    
    @JoinColumn(name = "id_cargo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoAtualFk;
    
    @JoinColumn(name = "id_vinculo_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Vinculos idVinculoAtualFk;
    
    @JoinColumn(name = "id_carreira_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Carreiras idCarreiraAtualFk;
    
    @JoinColumn(name = "id_classe_carreira_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private ClassesCarreira idClasseCarreiraAtualFk;
    
    @JoinColumn(name = "id_nivel_carreira_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCarreira idNivelCarreiraAtualFk;
    
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    
    @JoinColumn(name = "id_situacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Situacoes idSituacaoAtualFk;
    
    @JoinColumn(name = "id_unidade_atuacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeAtuacaoAtualFk;
    
    @JoinColumn(name = "id_situacao_variacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private SituacaoVariacao idSituacaoVariacaoAtualFk;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<FuncionariosCapacitacoes> funcionariosCapacitacoesList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<NaoDescontaInss> naoDescontaInssList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFuncionarioFk")
    private List<FuncionariosAnexos> funcionariosAnexosList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<Autorizacoes> autorizacoesList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<Escala> escalaList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
    
    @JoinColumn(name = "id_unidade_lotacao_atual_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeLotacaoAtualFk;

    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<VencimentosFuncionario> rubricaFuncionarioList;
    
    @OneToMany(mappedBy = "idFuncionarioFk")
    private List<RubricaVencimento> rubricaVencimentoList;
	

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoesList() {
		return funcionariosCapacitacoesList;
	}

	public void setFuncionariosCapacitacoesList(List<FuncionariosCapacitacoes> funcionariosCapacitacoesList) {
		this.funcionariosCapacitacoesList = funcionariosCapacitacoesList;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}

	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraList() {
		return histFuncionariosNiveisCarreiraList;
	}

	public void setHistFuncionariosNiveisCarreiraList(
			List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList) {
		this.histFuncionariosNiveisCarreiraList = histFuncionariosNiveisCarreiraList;
	}

	public List<FuncionariosAnexos> getFuncionariosAnexosList() {
		return funcionariosAnexosList;
	}

	public void setFuncionariosAnexosList(List<FuncionariosAnexos> funcionariosAnexosList) {
		this.funcionariosAnexosList = funcionariosAnexosList;
	}

	public List<FuncionariosFerias> getFuncionariosFeriasList() {
		return funcionariosFeriasList;
	}

	public void setFuncionariosFeriasList(List<FuncionariosFerias> funcionariosFeriasList) {
		this.funcionariosFeriasList = funcionariosFeriasList;
	}

	public CargosEspecialidade getIdEspecialidadeAtualFk() {
		return idEspecialidadeAtualFk;
	}

	public void setIdEspecialidadeAtualFk(CargosEspecialidade idEspecialidadeAtualFk) {
		this.idEspecialidadeAtualFk = idEspecialidadeAtualFk;
	}

	public CargaHorariaSemanal getIdCargaHorariaAtualFk() {
		return idCargaHorariaAtualFk;
	}

	public void setIdCargaHorariaAtualFk(CargaHorariaSemanal idCargaHorariaAtualFk) {
		this.idCargaHorariaAtualFk = idCargaHorariaAtualFk;
	}

	public Cargos getIdCargoAtualFk() {
		return idCargoAtualFk;
	}

	public void setIdCargoAtualFk(Cargos idCargoAtualFk) {
		this.idCargoAtualFk = idCargoAtualFk;
	}

	public Carreiras getIdCarreiraAtualFk() {
		return idCarreiraAtualFk;
	}

	public void setIdCarreiraAtualFk(Carreiras idCarreiraAtualFk) {
		this.idCarreiraAtualFk = idCarreiraAtualFk;
	}

	public Vinculos getIdVinculoAtualFk() {
		return idVinculoAtualFk;
	}

	public void setIdVinculoAtualFk(Vinculos idVinculoAtualFk) {
		this.idVinculoAtualFk = idVinculoAtualFk;
	}

	public Situacoes getIdSituacaoAtualFk() {
		return idSituacaoAtualFk;
	}

	public void setIdSituacaoAtualFk(Situacoes idSituacaoAtualFk) {
		this.idSituacaoAtualFk = idSituacaoAtualFk;
	}

	public NiveisCarreira getIdNivelCarreiraAtualFk() {
		return idNivelCarreiraAtualFk;
	}
 
	public ClassesCarreira getIdClasseCarreiraAtualFk() {
		return idClasseCarreiraAtualFk;
	}


	public void setIdClasseCarreiraAtualFk(ClassesCarreira idClasseCarreiraAtualFk) {
		this.idClasseCarreiraAtualFk = idClasseCarreiraAtualFk;
	}


	public void setIdNivelCarreiraAtualFk(NiveisCarreira idNivelCarreiraAtualFk) {
		this.idNivelCarreiraAtualFk = idNivelCarreiraAtualFk;
	}

	public Unidades getIdUnidadeAtuacaoAtualFk() {
		return idUnidadeAtuacaoAtualFk;
	}

	public void setIdUnidadeAtuacaoAtualFk(Unidades idUnidadeAtuacaoAtualFk) {
		this.idUnidadeAtuacaoAtualFk = idUnidadeAtuacaoAtualFk;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula =  UtilidadesDeTexto.limpaPontosETracosCpf( UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(matricula));
	}

	public Date getDtNomeacao() {
		return dtNomeacao;
	}

	public void setDtNomeacao(Date dtNomeacao) {
		this.dtNomeacao = dtNomeacao;
	}

	public Date getDtPosse() {
		return dtPosse;
	}

	public void setDtPosse(Date dtPosse) {
		this.dtPosse = dtPosse;
	}

	public String getNumeroDeOrdem() {
		return numeroDeOrdem;
	}

	public void setNumeroDeOrdem(String numeroDeOrdem) {
		this.numeroDeOrdem = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroDeOrdem);
	}

	public String getNumeroDePonto() {
		return numeroDePonto;
	}

	public void setNumeroDePonto(String numeroDePonto) {
		this.numeroDePonto = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(numeroDePonto);
	}

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

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList() {
		return histFuncionariosAutorizacaoList;
	}

	public void setHistFuncionariosAutorizacaoList(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList) {
		this.histFuncionariosAutorizacaoList = histFuncionariosAutorizacaoList;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseList() {
		return histFuncionariosClasseList;
	}

	public void setHistFuncionariosClasseList(List<HistFuncionariosClasse> histFuncionariosClasseList) {
		this.histFuncionariosClasseList = histFuncionariosClasseList;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList() {
		return histFuncionariosCargaHorariaList;
	}

	public void setHistFuncionariosCargaHorariaList(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList) {
		this.histFuncionariosCargaHorariaList = histFuncionariosCargaHorariaList;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosList() {
		return histFuncionariosCargosList;
	}

	public void setHistFuncionariosCargosList(List<HistFuncionariosCargos> histFuncionariosCargosList) {
		this.histFuncionariosCargosList = histFuncionariosCargosList;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList() {
		return histFuncionariosCarreiraList;
	}

	public void setHistFuncionariosCarreiraList(List<HistFuncionariosCarreira> histFuncionariosCarreiraList) {
		this.histFuncionariosCarreiraList = histFuncionariosCarreiraList;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList() {
		return histFuncionariosSituacoesList;
	}

	public void setHistFuncionariosSituacoesList(List<HistFuncionariosSituacoes> histFuncionariosSituacoesList) {
		this.histFuncionariosSituacoesList = histFuncionariosSituacoesList;
	}

	public List<Autorizacoes> getAutorizacoesList() {
		return autorizacoesList;
	}

	public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
		this.autorizacoesList = autorizacoesList;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
		return histFuncionariosVinculosList;
	}

	public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
		this.histFuncionariosVinculosList = histFuncionariosVinculosList;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList() {
		return histFuncionariosUnidadeAtuacaoList;
	}

	public void setHistFuncionariosUnidadeAtuacaoList(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList) {
		this.histFuncionariosUnidadeAtuacaoList = histFuncionariosUnidadeAtuacaoList;
	}

	public List<Escala> getEscalaList() {
		return escalaList;
	}

	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}

	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}

	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}

	public List<EscalaAlteracoes> getEscalaAlteracoesList() {
		return escalaAlteracoesList;
	}

	public void setEscalaAlteracoesList(List<EscalaAlteracoes> escalaAlteracoesList) {
		this.escalaAlteracoesList = escalaAlteracoesList;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList() {
		return histFuncionariosUnidadeLotacaoList;
	}

	public void setHistFuncionariosUnidadeLotacaoList(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList) {
		this.histFuncionariosUnidadeLotacaoList = histFuncionariosUnidadeLotacaoList;
	}

	public Unidades getIdUnidadeLotacaoAtualFk() {
		return idUnidadeLotacaoAtualFk;
	}

	public void setIdUnidadeLotacaoAtualFk(Unidades idUnidadeLotacaoAtualFk) {
		this.idUnidadeLotacaoAtualFk = idUnidadeLotacaoAtualFk;
	}

	public List<VencimentosFuncionario> getRubricaFuncionarioList() {
		return rubricaFuncionarioList;
	}

	public void setRubricaFuncionarioList(List<VencimentosFuncionario> rubricaFuncionarioList) {
		this.rubricaFuncionarioList = rubricaFuncionarioList;
	}

	public SituacaoVariacao getIdSituacaoVariacaoAtualFk() {
		return idSituacaoVariacaoAtualFk;
	}

	public void setIdSituacaoVariacaoAtualFk(SituacaoVariacao idSituacaoVariacaoAtualFk) {
		this.idSituacaoVariacaoAtualFk = idSituacaoVariacaoAtualFk;
	}

	public List<RubricaVencimento> getRubricaVencimentoList() {
		return rubricaVencimentoList;
	}

	public void setRubricaVencimentoList(List<RubricaVencimento> rubricaVencimentoList) {
		this.rubricaVencimentoList = rubricaVencimentoList;
	}

	public List<NaoDescontaInss> getNaoDescontaInssList() {
		return naoDescontaInssList;
	}

	public void setNaoDescontaInssList(List<NaoDescontaInss> naoDescontaInssList) {
		this.naoDescontaInssList = naoDescontaInssList;
	}

	public List<HorasFaltasFolhasVariaveis> getHorasFaltasFolhasVariaveisList() {
		return horasFaltasFolhasVariaveisList;
	}

	public void setHorasFaltasFolhasVariaveisList(List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList) {
		this.horasFaltasFolhasVariaveisList = horasFaltasFolhasVariaveisList;
	}
	
	

	
	
	
}
