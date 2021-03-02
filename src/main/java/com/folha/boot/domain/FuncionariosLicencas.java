package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_licencas")

public class FuncionariosLicencas extends AbstractEntity<Long> {

	private byte[] anexo;

	@Column(name="corte_folha_efetiva")
	private String corteFolhaEfetiva;

	@Column(name="corte_folha_extra")
	private String corteFolhaExtra;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_final")
	private Date dtFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_final_original")
	private Date dtFinalOriginal;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicial")
	private Date dtInicial;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicial_original")
	private Date dtInicialOriginal;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_previdencia")
	private Date dtPrevidencia;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_publicacao_diario_oficial")
	private Date dtPublicacaoDiarioOficial;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_ultima_alteracao")
	private Date dtUltimaAlteracao;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	private String observacoes;

	@Column(name="pendencia_exame_comprobatorio")
	private String pendenciaExameComprobatorio;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo_atual_fk")
	private Cargos cargos;

	//bi-directional many-to-one association to CargosEspecialidade
	@ManyToOne
	@JoinColumn(name="id_cargo_especialidade_atual_fk")
	private CargosEspecialidade cargosEspecialidade;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk")
	private PessoaFuncionarios pessoaFuncionarios;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadores1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadores2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_ultima_alteracao_fk")
	private PessoaOperadores pessoaOperadores3;

	//bi-directional many-to-one association to TiposDeLicenca
	@ManyToOne
	@JoinColumn(name="id_tipo_licenca_fk")
	private TiposDeLicenca tiposDeLicenca;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidade_atuacao_atual_fk")
	private Unidades unidades1;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidade_lotacao_atual_fk")
	private Unidades unidades2;

	//bi-directional many-to-one association to Vinculo
	@ManyToOne
	@JoinColumn(name="id_vinculo_atual_fk")
	private Vinculos vinculos;

	public FuncionariosLicencas() {
	}

	public byte[] getAnexo() {
		return anexo;
	}

	public void setAnexo(byte[] anexo) {
		this.anexo = anexo;
	}

	public String getCorteFolhaEfetiva() {
		return corteFolhaEfetiva;
	}

	public void setCorteFolhaEfetiva(String corteFolhaEfetiva) {
		this.corteFolhaEfetiva = corteFolhaEfetiva;
	}

	public String getCorteFolhaExtra() {
		return corteFolhaExtra;
	}

	public void setCorteFolhaExtra(String corteFolhaExtra) {
		this.corteFolhaExtra = corteFolhaExtra;
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

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public Date getDtFinalOriginal() {
		return dtFinalOriginal;
	}

	public void setDtFinalOriginal(Date dtFinalOriginal) {
		this.dtFinalOriginal = dtFinalOriginal;
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtInicialOriginal() {
		return dtInicialOriginal;
	}

	public void setDtInicialOriginal(Date dtInicialOriginal) {
		this.dtInicialOriginal = dtInicialOriginal;
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

	public Date getDtUltimaAlteracao() {
		return dtUltimaAlteracao;
	}

	public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
		this.dtUltimaAlteracao = dtUltimaAlteracao;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getPendenciaExameComprobatorio() {
		return pendenciaExameComprobatorio;
	}

	public void setPendenciaExameComprobatorio(String pendenciaExameComprobatorio) {
		this.pendenciaExameComprobatorio = pendenciaExameComprobatorio;
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

	public PessoaFuncionarios getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
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

	public PessoaOperadores getPessoaOperadores3() {
		return pessoaOperadores3;
	}

	public void setPessoaOperadores3(PessoaOperadores pessoaOperadores3) {
		this.pessoaOperadores3 = pessoaOperadores3;
	}

	public TiposDeLicenca getTiposDeLicenca() {
		return tiposDeLicenca;
	}

	public void setTiposDeLicenca(TiposDeLicenca tiposDeLicenca) {
		this.tiposDeLicenca = tiposDeLicenca;
	}

	public Unidades getUnidades1() {
		return unidades1;
	}

	public void setUnidades1(Unidades unidades1) {
		this.unidades1 = unidades1;
	}

	public Unidades getUnidades2() {
		return unidades2;
	}

	public void setUnidades2(Unidades unidades2) {
		this.unidades2 = unidades2;
	}

	public Vinculos getVinculos() {
		return vinculos;
	}

	public void setVinculos(Vinculos vinculos) {
		this.vinculos = vinculos;
	}

}