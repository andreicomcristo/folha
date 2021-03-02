package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_funcionarios")
public class PessoaFuncionarios extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nomeacao")
	private Date dtNomeacao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_posse")
	private Date dtPosse;

	@Column(name="id_unidade_lotacao_atual_fk")
	private Long idUnidadeLotacaoAtualFk;

	private String matricula;

	@Column(name="motivo_cadastro")
	private String motivoCadastro;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	@Column(name="numero_de_ordem")
	private String numeroDeOrdem;

	@Column(name="numero_de_ponto")
	private String numeroDePonto;

	//bi-directional many-to-one association to Autorizacoe
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<Autorizacoes> autorizacoes;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="pessoaFuncionario1")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias1;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="pessoaFuncionario2")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias2;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="pessoaFuncionario1")
	private List<HistFuncionariosCargos> histFuncionariosCargos1;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="pessoaFuncionario2")
	private List<HistFuncionariosCargos> histFuncionariosCargos2;

	//bi-directional many-to-one association to HistFuncionariosCarreira
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiras;

	//bi-directional many-to-one association to HistFuncionariosClasse
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosClasse> histFuncionariosClasses;

	//bi-directional many-to-one association to HistFuncionariosSituacoe
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoes;

	//bi-directional many-to-one association to HistFuncionariosUnidadeAtuacao
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos;

	//bi-directional many-to-one association to HistFuncionariosVinculo
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosVinculos> histFuncionariosVinculos;

	//bi-directional many-to-one association to CargaHorariaSemanal
	@ManyToOne
	@JoinColumn(name="id_carga_horaria_atual_fk")
	private CargaHorariaSemanal cargaHorariaSemanal;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo_atual_fk")
	private Cargos cargos;

	//bi-directional many-to-one association to CargosEspecialidade
	@ManyToOne
	@JoinColumn(name="id_especialidade_atual_fk")
	private CargosEspecialidade cargosEspecialidade;

	//bi-directional many-to-one association to Carreira
	@ManyToOne
	@JoinColumn(name="id_carreira_atual_fk")
	private Carreiras carreiras;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk")
	private Pessoa pessoa;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadores1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadores2;

	//bi-directional many-to-one association to Situacoe
	@ManyToOne
	@JoinColumn(name="id_situacao_atual_fk")
	private Situacoes situacoes;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidade_atuacao_atual_fk")
	private Unidades unidades;

	//bi-directional many-to-one association to Vinculo
	@ManyToOne
	@JoinColumn(name="id_vinculo_atual_fk")
	private Vinculos vinculos;

	//bi-directional many-to-one association to FuncionariosAnexo
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<FuncionariosAnexos> funcionariosAnexos;

	//bi-directional many-to-one association to FuncionariosCapacitacoe
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<FuncionariosCapacitacoes> funcionariosCapacitacoes;

	//bi-directional many-to-one association to FuncionariosFeria
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<FuncionariosFerias> funcionariosFerias;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<FuncionariosLicencas> funcionariosLicencas;

	//bi-directional many-to-one association to HistFuncionariosNiveisCarreira
	@OneToMany(mappedBy="pessoaFuncionario")
	private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras;

	//bi-directional many-to-one association to ClassesCarreira
	@ManyToOne
	@JoinColumn(name="id_classe_carreira_atual_fk")
	private ClassesCarreira classesCarreira;

	//bi-directional many-to-one association to NiveisCarreira
	@ManyToOne
	@JoinColumn(name="id_nivel_carreira_atual_fk")
	private NiveisCarreira niveisCarreira;

	public PessoaFuncionarios() {
	}

	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtCancelamento() {
		return this.dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public Date getDtNomeacao() {
		return this.dtNomeacao;
	}

	public void setDtNomeacao(Date dtNomeacao) {
		this.dtNomeacao = dtNomeacao;
	}

	public Date getDtPosse() {
		return this.dtPosse;
	}

	public void setDtPosse(Date dtPosse) {
		this.dtPosse = dtPosse;
	}

	public Long getIdUnidadeLotacaoAtualFk() {
		return this.idUnidadeLotacaoAtualFk;
	}

	public void setIdUnidadeLotacaoAtualFk(Long idUnidadeLotacaoAtualFk) {
		this.idUnidadeLotacaoAtualFk = idUnidadeLotacaoAtualFk;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMotivoCadastro() {
		return this.motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = motivoCadastro;
	}

	public String getMotivoCancelamento() {
		return this.motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getNumeroDeOrdem() {
		return this.numeroDeOrdem;
	}

	public void setNumeroDeOrdem(String numeroDeOrdem) {
		this.numeroDeOrdem = numeroDeOrdem;
	}

	public String getNumeroDePonto() {
		return this.numeroDePonto;
	}

	public void setNumeroDePonto(String numeroDePonto) {
		this.numeroDePonto = numeroDePonto;
	}

	public List<Autorizacoes> getAutorizacoes() {
		return this.autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacoes> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public Autorizacoes addAutorizacoe(Autorizacoes autorizacoes) {
		getAutorizacoes().add(autorizacoes);
		autorizacoes.setPessoaFuncionarios(this);

		return autorizacoes;
	}

	public Autorizacoes removeAutorizacoe(Autorizacoes autorizacoes) {
		getAutorizacoes().remove(autorizacoes);
		autorizacoes.setPessoaFuncionarios(null);

		return autorizacoes;
	}

	
	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaos() {
		return histFuncionariosAutorizacaos;
	}

	public void setHistFuncionariosAutorizacaos(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos) {
		this.histFuncionariosAutorizacaos = histFuncionariosAutorizacaos;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias1() {
		return histFuncionariosCargaHorarias1;
	}

	public void setHistFuncionariosCargaHorarias1(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias1) {
		this.histFuncionariosCargaHorarias1 = histFuncionariosCargaHorarias1;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias2() {
		return histFuncionariosCargaHorarias2;
	}

	public void setHistFuncionariosCargaHorarias2(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias2) {
		this.histFuncionariosCargaHorarias2 = histFuncionariosCargaHorarias2;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos1() {
		return histFuncionariosCargos1;
	}

	public void setHistFuncionariosCargos1(List<HistFuncionariosCargos> histFuncionariosCargos1) {
		this.histFuncionariosCargos1 = histFuncionariosCargos1;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos2() {
		return histFuncionariosCargos2;
	}

	public void setHistFuncionariosCargos2(List<HistFuncionariosCargos> histFuncionariosCargos2) {
		this.histFuncionariosCargos2 = histFuncionariosCargos2;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiras() {
		return histFuncionariosCarreiras;
	}

	public void setHistFuncionariosCarreiras(List<HistFuncionariosCarreira> histFuncionariosCarreiras) {
		this.histFuncionariosCarreiras = histFuncionariosCarreiras;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasses() {
		return histFuncionariosClasses;
	}

	public void setHistFuncionariosClasses(List<HistFuncionariosClasse> histFuncionariosClasses) {
		this.histFuncionariosClasses = histFuncionariosClasses;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoes() {
		return histFuncionariosSituacoes;
	}

	public void setHistFuncionariosSituacoes(List<HistFuncionariosSituacoes> histFuncionariosSituacoes) {
		this.histFuncionariosSituacoes = histFuncionariosSituacoes;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaos() {
		return histFuncionariosUnidadeAtuacaos;
	}

	public void setHistFuncionariosUnidadeAtuacaos(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos) {
		this.histFuncionariosUnidadeAtuacaos = histFuncionariosUnidadeAtuacaos;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculos() {
		return histFuncionariosVinculos;
	}

	public void setHistFuncionariosVinculos(List<HistFuncionariosVinculos> histFuncionariosVinculos) {
		this.histFuncionariosVinculos = histFuncionariosVinculos;
	}

	public CargaHorariaSemanal getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public void setCargaHorariaSemanal(CargaHorariaSemanal cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	public Cargos getCargos() {
		return cargos;
	}

	public void setCargos(Cargos cargos) {
		this.cargos = cargos;
	}

	public CargosEspecialidade getCargosEspecialidade() {
		return cargosEspecialidade;
	}

	public void setCargosEspecialidade(CargosEspecialidade cargosEspecialidade) {
		this.cargosEspecialidade = cargosEspecialidade;
	}

	public Carreiras getCarreiras() {
		return carreiras;
	}

	public void setCarreiras(Carreiras carreiras) {
		this.carreiras = carreiras;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaOperadores getPessoaOperadores1() {
		return pessoaOperadores1;
	}

	public void setPessoaOperadores1(PessoaOperadores pessoaOperadores1) {
		this.pessoaOperadores1 = pessoaOperadores1;
	}

	public PessoaOperadores getPessoaOperadores2() {
		return pessoaOperadores2;
	}

	public void setPessoaOperadores2(PessoaOperadores pessoaOperadores2) {
		this.pessoaOperadores2 = pessoaOperadores2;
	}

	public Situacoes getSituacoes() {
		return situacoes;
	}

	public void setSituacoes(Situacoes situacoes) {
		this.situacoes = situacoes;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}

	public Vinculos getVinculos() {
		return vinculos;
	}

	public void setVinculos(Vinculos vinculos) {
		this.vinculos = vinculos;
	}

	public List<FuncionariosAnexos> getFuncionariosAnexos() {
		return funcionariosAnexos;
	}

	public void setFuncionariosAnexos(List<FuncionariosAnexos> funcionariosAnexos) {
		this.funcionariosAnexos = funcionariosAnexos;
	}

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoes() {
		return funcionariosCapacitacoes;
	}

	public void setFuncionariosCapacitacoes(List<FuncionariosCapacitacoes> funcionariosCapacitacoes) {
		this.funcionariosCapacitacoes = funcionariosCapacitacoes;
	}

	public List<FuncionariosFerias> getFuncionariosFerias() {
		return funcionariosFerias;
	}

	public void setFuncionariosFerias(List<FuncionariosFerias> funcionariosFerias) {
		this.funcionariosFerias = funcionariosFerias;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas() {
		return funcionariosLicencas;
	}

	public void setFuncionariosLicencas(List<FuncionariosLicencas> funcionariosLicencas) {
		this.funcionariosLicencas = funcionariosLicencas;
	}

	public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiras() {
		return histFuncionariosNiveisCarreiras;
	}

	public void setHistFuncionariosNiveisCarreiras(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras) {
		this.histFuncionariosNiveisCarreiras = histFuncionariosNiveisCarreiras;
	}

	public ClassesCarreira getClassesCarreira() {
		return classesCarreira;
	}

	public void setClassesCarreira(ClassesCarreira classesCarreira) {
		this.classesCarreira = classesCarreira;
	}

	public NiveisCarreira getNiveisCarreira() {
		return niveisCarreira;
	}

	public void setNiveisCarreira(NiveisCarreira niveisCarreira) {
		this.niveisCarreira = niveisCarreira;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacao(HistFuncionariosAutorizacao histFuncionariosAutorizacao) {
		getHistFuncionariosAutorizacaos().add(histFuncionariosAutorizacao);
		histFuncionariosAutorizacao.setPessoaFuncionario(this);

		return histFuncionariosAutorizacao;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacao(HistFuncionariosAutorizacao histFuncionariosAutorizacao) {
		getHistFuncionariosAutorizacaos().remove(histFuncionariosAutorizacao);
		histFuncionariosAutorizacao.setPessoaFuncionario(null);

		return histFuncionariosAutorizacao;
	}

	public HistFuncionariosCargaHoraria addHistFuncionariosCargaHorarias1(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias1) {
		getHistFuncionariosCargaHorarias1().add(histFuncionariosCargaHorarias1);
		histFuncionariosCargaHorarias1.setPessoaFuncionarios1(this);

		return histFuncionariosCargaHorarias1;
	}

	public HistFuncionariosCargaHoraria removeHistFuncionariosCargaHorarias1(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias1) {
		getHistFuncionariosCargaHorarias1().remove(histFuncionariosCargaHorarias1);
		histFuncionariosCargaHorarias1.setPessoaFuncionarios1(null);

		return histFuncionariosCargaHorarias1;
	}


	public HistFuncionariosCargaHoraria addHistFuncionariosCargaHorarias2(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias2) {
		getHistFuncionariosCargaHorarias2().add(histFuncionariosCargaHorarias2);
		histFuncionariosCargaHorarias2.setPessoaFuncionarios2(this);

		return histFuncionariosCargaHorarias2;
	}

	public HistFuncionariosCargaHoraria removeHistFuncionariosCargaHorarias2(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias2) {
		getHistFuncionariosCargaHorarias2().remove(histFuncionariosCargaHorarias2);
		histFuncionariosCargaHorarias2.setPessoaFuncionarios2(null);

		return histFuncionariosCargaHorarias2;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos1(HistFuncionariosCargos histFuncionariosCargos1) {
		getHistFuncionariosCargos1().add(histFuncionariosCargos1);
		histFuncionariosCargos1.setPessoaFuncionario1(this);

		return histFuncionariosCargos1;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos1(HistFuncionariosCargos histFuncionariosCargos1) {
		getHistFuncionariosCargos1().remove(histFuncionariosCargos1);
		histFuncionariosCargos1.setPessoaFuncionario1(null);

		return histFuncionariosCargos1;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos2(HistFuncionariosCargos histFuncionariosCargos2) {
		getHistFuncionariosCargos2().add(histFuncionariosCargos2);
		histFuncionariosCargos2.setPessoaFuncionario2(this);

		return histFuncionariosCargos2;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos2(HistFuncionariosCargos histFuncionariosCargos2) {
		getHistFuncionariosCargos2().remove(histFuncionariosCargos2);
		histFuncionariosCargos2.setPessoaFuncionario2(null);

		return histFuncionariosCargos2;
	}

	public HistFuncionariosCarreira addHistFuncionariosCarreira(HistFuncionariosCarreira histFuncionariosCarreira) {
		getHistFuncionariosCarreiras().add(histFuncionariosCarreira);
		histFuncionariosCarreira.setPessoaFuncionario(this);

		return histFuncionariosCarreira;
	}

	public HistFuncionariosCarreira removeHistFuncionariosCarreira(HistFuncionariosCarreira histFuncionariosCarreira) {
		getHistFuncionariosCarreiras().remove(histFuncionariosCarreira);
		histFuncionariosCarreira.setPessoaFuncionario(null);

		return histFuncionariosCarreira;
	}

	public HistFuncionariosClasse addHistFuncionariosClass(HistFuncionariosClasse histFuncionariosClass) {
		getHistFuncionariosClasses().add(histFuncionariosClass);
		histFuncionariosClass.setPessoaFuncionario(this);

		return histFuncionariosClass;
	}

	public HistFuncionariosClasse removeHistFuncionariosClass(HistFuncionariosClasse histFuncionariosClass) {
		getHistFuncionariosClasses().remove(histFuncionariosClass);
		histFuncionariosClass.setPessoaFuncionario(null);

		return histFuncionariosClass;
	}

	public HistFuncionariosSituacoes addHistFuncionariosSituacoe(HistFuncionariosSituacoes histFuncionariosSituacoe) {
		getHistFuncionariosSituacoes().add(histFuncionariosSituacoe);
		histFuncionariosSituacoe.setPessoaFuncionario(this);

		return histFuncionariosSituacoe;
	}

	public HistFuncionariosSituacoes removeHistFuncionariosSituacoe(HistFuncionariosSituacoes histFuncionariosSituacoe) {
		getHistFuncionariosSituacoes().remove(histFuncionariosSituacoe);
		histFuncionariosSituacoe.setPessoaFuncionario(null);

		return histFuncionariosSituacoe;
	}

	public HistFuncionariosUnidadeAtuacao addHistFuncionariosUnidadeAtuacao(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		getHistFuncionariosUnidadeAtuacaos().add(histFuncionariosUnidadeAtuacao);
		histFuncionariosUnidadeAtuacao.setPessoaFuncionarios(this);

		return histFuncionariosUnidadeAtuacao;
	}

	public HistFuncionariosUnidadeAtuacao removeHistFuncionariosUnidadeAtuacao(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		getHistFuncionariosUnidadeAtuacaos().remove(histFuncionariosUnidadeAtuacao);
		histFuncionariosUnidadeAtuacao.setPessoaFuncionarios(null);

		return histFuncionariosUnidadeAtuacao;
	}

	public HistFuncionariosVinculos addHistFuncionariosVinculo(HistFuncionariosVinculos histFuncionariosVinculo) {
		getHistFuncionariosVinculos().add(histFuncionariosVinculo);
		histFuncionariosVinculo.setPessoaFuncionario(this);

		return histFuncionariosVinculo;
	}

	public HistFuncionariosVinculos removeHistFuncionariosVinculo(HistFuncionariosVinculos histFuncionariosVinculo) {
		getHistFuncionariosVinculos().remove(histFuncionariosVinculo);
		histFuncionariosVinculo.setPessoaFuncionario(null);

		return histFuncionariosVinculo;
	}

	public FuncionariosAnexos addFuncionariosAnexo(FuncionariosAnexos funcionariosAnexo) {
		getFuncionariosAnexos().add(funcionariosAnexo);
		funcionariosAnexo.setPessoaFuncionarios(this);

		return funcionariosAnexo;
	}

	public FuncionariosAnexos removeFuncionariosAnexo(FuncionariosAnexos funcionariosAnexo) {
		getFuncionariosAnexos().remove(funcionariosAnexo);
		funcionariosAnexo.setPessoaFuncionarios(null);

		return funcionariosAnexo;
	}

	public FuncionariosCapacitacoes addFuncionariosCapacitacoe(FuncionariosCapacitacoes funcionariosCapacitacoe) {
		getFuncionariosCapacitacoes().add(funcionariosCapacitacoe);
		funcionariosCapacitacoe.setPessoaFuncionarios(this);

		return funcionariosCapacitacoe;
	}

	public FuncionariosCapacitacoes removeFuncionariosCapacitacoe(FuncionariosCapacitacoes funcionariosCapacitacoe) {
		getFuncionariosCapacitacoes().remove(funcionariosCapacitacoe);
		funcionariosCapacitacoe.setPessoaFuncionarios(null);

		return funcionariosCapacitacoe;
	}

	public FuncionariosFerias addFuncionariosFeria(FuncionariosFerias funcionariosFeria) {
		getFuncionariosFerias().add(funcionariosFeria);
		funcionariosFeria.setPessoaFuncionario(this);

		return funcionariosFeria;
	}

	public FuncionariosFerias removeFuncionariosFeria(FuncionariosFerias funcionariosFeria) {
		getFuncionariosFerias().remove(funcionariosFeria);
		funcionariosFeria.setPessoaFuncionario(null);

		return funcionariosFeria;
	}

	public FuncionariosLicencas addFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().add(funcionariosLicenca);
		funcionariosLicenca.setPessoaFuncionarios(this);

		return funcionariosLicenca;
	}

	public FuncionariosLicencas removeFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().remove(funcionariosLicenca);
		funcionariosLicenca.setPessoaFuncionarios(null);

		return funcionariosLicenca;
	}

	public HistFuncionariosNiveisCarreira addHistFuncionariosNiveisCarreira(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		getHistFuncionariosNiveisCarreiras().add(histFuncionariosNiveisCarreira);
		histFuncionariosNiveisCarreira.setPessoaFuncionarios(this);

		return histFuncionariosNiveisCarreira;
	}

	public HistFuncionariosNiveisCarreira removeHistFuncionariosNiveisCarreira(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		getHistFuncionariosNiveisCarreiras().remove(histFuncionariosNiveisCarreira);
		histFuncionariosNiveisCarreira.setPessoaFuncionarios(null);

		return histFuncionariosNiveisCarreira;
	}

}
