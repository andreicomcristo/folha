package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.seguranca.Perfil;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidades")
public class Unidades extends AbstractEntity<Long> {

	@Basic(optional = false)
    @Column(name = "nome_fantasia")
	private String nomeFantasia;
    @Column(name = "nome_empresarial")
    private String nomeEmpresarial;
    @Column(name = "cnes")
    private String cnes;
    @Column(name = "fone1")
    private String fone1;
    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;
    @Column(name = "endereco_numero")
    private String enderecoNumero;
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Column(name = "endereco_cep")
    private String enderecoCep;
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
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "leitos_cadastrados")
    private Integer leitosCadastrados;
    @Column(name = "leitos_ativos")
    private Integer leitosAtivos;
    @JoinColumn(name = "id_unidade_gestora_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadeGestora idUnidadeGestoraFk;
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idUnidadeLotacaoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList1;
    @JoinColumn(name = "id_endereco_cidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Cidades idEnderecoCidadeFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_tipo_logradouro_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposLogradouro idTipoLogradouroFk;
    @JoinColumn(name = "id_natureza_juridica_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesNaturezaJuridica idNaturezaJuridicaFk;
    @JoinColumn(name = "id_unidades_regime_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesRegime idUnidadesRegimeFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesRegime> histUnidadesRegimeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList;
    @OneToMany(mappedBy = "idUnidadeLancamentoFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresGpfDiferenciada> faixasValoresGpfDiferenciadaList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<Autorizacoes> autorizacoesList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresGpfMedicaDiferenciada> faixasValoresGpfMedicaDiferenciadaList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<LocalidadeEscala> localidadeEscalaList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresResidente> faixasValoresResidenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<CodigoDiferenciado> codigoDiferenciadoList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<RubricaVencimento> rubricaVencimentoList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresGpfMedica> faixasValoresGpfMedicaList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<Perfil> perfilList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresPss> faixasValoresPssList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresFolhExt> faixasValoresFolhExtList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<PessoaComplementoDePlantao> pessoaComplementoDePlantaoList;
    
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<AtividadeEscala> atividadeEscalaList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresGpfMedicaDiferenciadaDiarista> faixasValoresGpfMedicaDiferenciadaDiaristaList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<IncrementoDeRiscoUnidadeCargo> incrementoDeRiscoUnidadeCargoList;
    
    @OneToMany(mappedBy = "idUnidadeLotacaoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList1;
    
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<PessoaIncrementoDeRiscoSede> pessoaIncrementoDeRiscoSedeList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<PessoaComplementoDePlantaoSede> pessoaComplementoDePlantaoSedeList;
    
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<PessoaChDif> pessoaChDifList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<PessoaIncrementoDeRisco> pessoaIncrementoDeRiscoList;
    
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<FaixasValoresGpf> faixasValoresGpfList;
    
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<PessoaLimiteHoras> pessoaLimiteHorasList;
    
	public List<CodigoDiferenciado> getCodigoDiferenciadoList() {
		return codigoDiferenciadoList;
	}
	
	@OneToMany(mappedBy = "idUnidadeFk")
    private List<UnidadeAdmiteChDif> unidadeAdmiteChDifList;
	@OneToMany(mappedBy = "idUnidadeFk")
    private List<UnidadeAdmiteIncrementoDeRisco> unidadeAdmiteIncrementoDeRiscoList;
	@OneToMany(mappedBy = "idUnidadeFk")
    private List<UnidadeAdmiteComplementoPlantao> unidadeAdmiteComplementoPlantaoList;
	
	 @OneToMany(mappedBy = "idUnidadeFk")
	 private List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList;
	
	
	@OneToMany(mappedBy = "idUnidadeFk")
    private List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> limiteHorasAcrescimoPorUnidadeEEspecialidadeList;

	public void setCodigoDiferenciadoList(List<CodigoDiferenciado> codigoDiferenciadoList) {
		this.codigoDiferenciadoList = codigoDiferenciadoList;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}

	public UnidadesRegime getIdUnidadesRegimeFk() {
		return idUnidadesRegimeFk;
	}

	public void setIdUnidadesRegimeFk(UnidadesRegime idUnidadesRegimeFk) {
		this.idUnidadesRegimeFk = idUnidadesRegimeFk;
	}

	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencasList1() {
		return funcionariosLicencasList1;
	}

	public void setFuncionariosLicencasList1(List<FuncionariosLicencas> funcionariosLicencasList1) {
		this.funcionariosLicencasList1 = funcionariosLicencasList1;
	}

	public List<AcessoOperadoresUnidades> getAcessoOperadoresUnidadesList() {
		return acessoOperadoresUnidadesList;
	}

	public void setAcessoOperadoresUnidadesList(List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList) {
		this.acessoOperadoresUnidadesList = acessoOperadoresUnidadesList;
	}

	public List<FuncionariosFerias> getFuncionariosFeriasList() {
		return funcionariosFeriasList;
	}

	public void setFuncionariosFeriasList(List<FuncionariosFerias> funcionariosFeriasList) {
		this.funcionariosFeriasList = funcionariosFeriasList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeFantasia);
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEmpresarial);
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cnes);
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(fone1);
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoLogradouro);
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoNumero);
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoComplemento);
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoBairro);
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoCep);
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

	public Cidades getIdEnderecoCidadeFk() {
		return idEnderecoCidadeFk;
	}

	public void setIdEnderecoCidadeFk(Cidades idEnderecoCidadeFk) {
		this.idEnderecoCidadeFk = idEnderecoCidadeFk;
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

	public TiposLogradouro getIdTipoLogradouroFk() {
		return idTipoLogradouroFk;
	}

	public void setIdTipoLogradouroFk(TiposLogradouro idTipoLogradouroFk) {
		this.idTipoLogradouroFk = idTipoLogradouroFk;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeList() {
		return histUnidadesRegimeList;
	}

	public void setHistUnidadesRegimeList(List<HistUnidadesRegime> histUnidadesRegimeList) {
		this.histUnidadesRegimeList = histUnidadesRegimeList;
	}

	public List<Autorizacoes> getAutorizacoesList() {
		return autorizacoesList;
	}

	public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
		this.autorizacoesList = autorizacoesList;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList() {
		return histFuncionariosUnidadeLotacaoList;
	}

	public void setHistFuncionariosUnidadeLotacaoList(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList) {
		this.histFuncionariosUnidadeLotacaoList = histFuncionariosUnidadeLotacaoList;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList() {
		return histFuncionariosUnidadeAtuacaoList;
	}

	public void setHistFuncionariosUnidadeAtuacaoList(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList) {
		this.histFuncionariosUnidadeAtuacaoList = histFuncionariosUnidadeAtuacaoList;
	}

	public UnidadesNaturezaJuridica getIdNaturezaJuridicaFk() {
		return idNaturezaJuridicaFk;
	}

	public void setIdNaturezaJuridicaFk(UnidadesNaturezaJuridica idNaturezaJuridicaFk) {
		this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
	}

	public List<HistUnidadesDiretor> getHistUnidadesDiretorList() {
		return histUnidadesDiretorList;
	}

	public void setHistUnidadesDiretorList(List<HistUnidadesDiretor> histUnidadesDiretorList) {
		this.histUnidadesDiretorList = histUnidadesDiretorList;
	}

	public List<LocalidadeEscala> getLocalidadeEscalaList() {
		return localidadeEscalaList;
	}

	public void setLocalidadeEscalaList(List<LocalidadeEscala> localidadeEscalaList) {
		this.localidadeEscalaList = localidadeEscalaList;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

	public List<AtividadeEscala> getAtividadeEscalaList() {
		return atividadeEscalaList;
	}

	public void setAtividadeEscalaList(List<AtividadeEscala> atividadeEscalaList) {
		this.atividadeEscalaList = atividadeEscalaList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList1() {
		return pessoaFuncionariosList1;
	}

	public void setPessoaFuncionariosList1(List<PessoaFuncionarios> pessoaFuncionariosList1) {
		this.pessoaFuncionariosList1 = pessoaFuncionariosList1;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cnpj);
	}

	public UnidadeGestora getIdUnidadeGestoraFk() {
		return idUnidadeGestoraFk;
	}

	public void setIdUnidadeGestoraFk(UnidadeGestora idUnidadeGestoraFk) {
		this.idUnidadeGestoraFk = idUnidadeGestoraFk;
	}

	public List<UnidadeAdmiteChDif> getUnidadeAdmiteChDifList() {
		return unidadeAdmiteChDifList;
	}

	public void setUnidadeAdmiteChDifList(List<UnidadeAdmiteChDif> unidadeAdmiteChDifList) {
		this.unidadeAdmiteChDifList = unidadeAdmiteChDifList;
	}

	public List<UnidadeAdmiteIncrementoDeRisco> getUnidadeAdmiteIncrementoDeRiscoList() {
		return unidadeAdmiteIncrementoDeRiscoList;
	}

	public void setUnidadeAdmiteIncrementoDeRiscoList(
			List<UnidadeAdmiteIncrementoDeRisco> unidadeAdmiteIncrementoDeRiscoList) {
		this.unidadeAdmiteIncrementoDeRiscoList = unidadeAdmiteIncrementoDeRiscoList;
	}

	public List<PessoaChDif> getPessoaChDifList() {
		return pessoaChDifList;
	}

	public void setPessoaChDifList(List<PessoaChDif> pessoaChDifList) {
		this.pessoaChDifList = pessoaChDifList;
	}

	public List<PessoaIncrementoDeRisco> getPessoaIncrementoDeRiscoList() {
		return pessoaIncrementoDeRiscoList;
	}

	public void setPessoaIncrementoDeRiscoList(List<PessoaIncrementoDeRisco> pessoaIncrementoDeRiscoList) {
		this.pessoaIncrementoDeRiscoList = pessoaIncrementoDeRiscoList;
	}

	public List<PessoaLimiteHoras> getPessoaLimiteHorasList() {
		return pessoaLimiteHorasList;
	}

	public void setPessoaLimiteHorasList(List<PessoaLimiteHoras> pessoaLimiteHorasList) {
		this.pessoaLimiteHorasList = pessoaLimiteHorasList;
	}

	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> getLimiteHorasAcrescimoPorUnidadeEEspecialidadeList() {
		return limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	}

	public void setLimiteHorasAcrescimoPorUnidadeEEspecialidadeList(
			List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> limiteHorasAcrescimoPorUnidadeEEspecialidadeList) {
		this.limiteHorasAcrescimoPorUnidadeEEspecialidadeList = limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	}

	public List<UnidadeAdmiteComplementoPlantao> getUnidadeAdmiteComplementoPlantaoList() {
		return unidadeAdmiteComplementoPlantaoList;
	}

	public void setUnidadeAdmiteComplementoPlantaoList(
			List<UnidadeAdmiteComplementoPlantao> unidadeAdmiteComplementoPlantaoList) {
		this.unidadeAdmiteComplementoPlantaoList = unidadeAdmiteComplementoPlantaoList;
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

	public List<HorasFaltasFolhasVariaveis> getHorasFaltasFolhasVariaveisList() {
		return horasFaltasFolhasVariaveisList;
	}

	public void setHorasFaltasFolhasVariaveisList(List<HorasFaltasFolhasVariaveis> horasFaltasFolhasVariaveisList) {
		this.horasFaltasFolhasVariaveisList = horasFaltasFolhasVariaveisList;
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

	public Integer getLeitosCadastrados() {
		return leitosCadastrados;
	}

	public void setLeitosCadastrados(Integer leitosCadastrados) {
		this.leitosCadastrados = leitosCadastrados;
	}

	public Integer getLeitosAtivos() {
		return leitosAtivos;
	}

	public void setLeitosAtivos(Integer leitosAtivos) {
		this.leitosAtivos = leitosAtivos;
	}

	public List<PessoaComplementoDePlantao> getPessoaComplementoDePlantaoList() {
		return pessoaComplementoDePlantaoList;
	}

	public void setPessoaComplementoDePlantaoList(List<PessoaComplementoDePlantao> pessoaComplementoDePlantaoList) {
		this.pessoaComplementoDePlantaoList = pessoaComplementoDePlantaoList;
	}

	public List<PessoaIncrementoDeRiscoSede> getPessoaIncrementoDeRiscoSedeList() {
		return pessoaIncrementoDeRiscoSedeList;
	}

	public void setPessoaIncrementoDeRiscoSedeList(List<PessoaIncrementoDeRiscoSede> pessoaIncrementoDeRiscoSedeList) {
		this.pessoaIncrementoDeRiscoSedeList = pessoaIncrementoDeRiscoSedeList;
	}

	public List<PessoaComplementoDePlantaoSede> getPessoaComplementoDePlantaoSedeList() {
		return pessoaComplementoDePlantaoSedeList;
	}

	public void setPessoaComplementoDePlantaoSedeList(
			List<PessoaComplementoDePlantaoSede> pessoaComplementoDePlantaoSedeList) {
		this.pessoaComplementoDePlantaoSedeList = pessoaComplementoDePlantaoSedeList;
	}

	public List<IncrementoDeRiscoUnidadeCargo> getIncrementoDeRiscoUnidadeCargoList() {
		return incrementoDeRiscoUnidadeCargoList;
	}

	public void setIncrementoDeRiscoUnidadeCargoList(
			List<IncrementoDeRiscoUnidadeCargo> incrementoDeRiscoUnidadeCargoList) {
		this.incrementoDeRiscoUnidadeCargoList = incrementoDeRiscoUnidadeCargoList;
	}
	
	
	
	
}
