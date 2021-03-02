package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidades")
public class Unidades extends AbstractEntity<Long> {
	
	private String cnes;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="endereco_bairro")
	private String enderecoBairro;

	@Column(name="endereco_cep")
	private String enderecoCep;

	@Column(name="endereco_complemento")
	private String enderecoComplemento;

	@Column(name="endereco_logradouro")
	private String enderecoLogradouro;

	@Column(name="endereco_numero")
	private String enderecoNumero;

	private String fone1;

	@Column(name="id_endereco_unidade_fk")
	private Long idEnderecoUnidadeFk;

	@Column(name="id_natureza_juridica_fk")
	private Long idNaturezaJuridicaFk;

	@Column(name="motivo_cadastro")
	private String motivoCadastro;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	@Column(name="nome_empresarial")
	private String nomeEmpresarial;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	//bi-directional many-to-one association to Autorizacoe
	@OneToMany(mappedBy="unidade")
	private List<Autorizacoes> autorizacoes;

	//bi-directional many-to-one association to HistFuncionariosUnidadeAtuacao
	@OneToMany(mappedBy="unidade")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos;

	//bi-directional many-to-one association to HistFuncionariosUnidadeLotacao
	@OneToMany(mappedBy="unidade")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaos;

	//bi-directional many-to-one association to HistUnidadesDiretor
	@OneToMany(mappedBy="unidade")
	private List<HistUnidadesDiretor> histUnidadesDiretors;

	//bi-directional many-to-one association to HistUnidadesRegime
	@OneToMany(mappedBy="unidade")
	private List<HistUnidadesRegime> histUnidadesRegimes;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="unidade")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_endereco_cidade_fk")
	private Cidades cidade;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to TiposLogradouro
	@ManyToOne
	@JoinColumn(name="id_tipo_logradouro_fk")
	private TiposLogradouro tiposLogradouro;

	//bi-directional many-to-one association to AcessoOperadoresUnidade
	@OneToMany(mappedBy="unidade")
	private List<AcessoOperadoresUnidade> acessoOperadoresUnidades;

	//bi-directional many-to-one association to FuncionariosFeria
	@OneToMany(mappedBy="unidade")
	private List<FuncionariosFerias> funcionariosFerias;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="unidade1")
	private List<FuncionariosLicencas> funcionariosLicencas1;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="unidade2")
	private List<FuncionariosLicencas> funcionariosLicencas2;

	public Unidades() {
	}
	
	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
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

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public Long getIdEnderecoUnidadeFk() {
		return idEnderecoUnidadeFk;
	}

	public void setIdEnderecoUnidadeFk(Long idEnderecoUnidadeFk) {
		this.idEnderecoUnidadeFk = idEnderecoUnidadeFk;
	}

	public Long getIdNaturezaJuridicaFk() {
		return idNaturezaJuridicaFk;
	}

	public void setIdNaturezaJuridicaFk(Long idNaturezaJuridicaFk) {
		this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
	}

	public String getMotivoCadastro() {
		return motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = motivoCadastro;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<Autorizacoes> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacoes> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadore1) {
		this.pessoaOperadore1 = pessoaOperadore1;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadore2) {
		this.pessoaOperadore2 = pessoaOperadore2;
	}

	
	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaos() {
		return histFuncionariosUnidadeAtuacaos;
	}

	public void setHistFuncionariosUnidadeAtuacaos(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos) {
		this.histFuncionariosUnidadeAtuacaos = histFuncionariosUnidadeAtuacaos;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaos() {
		return histFuncionariosUnidadeLotacaos;
	}

	public void setHistFuncionariosUnidadeLotacaos(List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaos) {
		this.histFuncionariosUnidadeLotacaos = histFuncionariosUnidadeLotacaos;
	}

	public List<HistUnidadesDiretor> getHistUnidadesDiretors() {
		return histUnidadesDiretors;
	}

	public void setHistUnidadesDiretors(List<HistUnidadesDiretor> histUnidadesDiretors) {
		this.histUnidadesDiretors = histUnidadesDiretors;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimes() {
		return histUnidadesRegimes;
	}

	public void setHistUnidadesRegimes(List<HistUnidadesRegime> histUnidadesRegimes) {
		this.histUnidadesRegimes = histUnidadesRegimes;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public TiposLogradouro getTiposLogradouro() {
		return tiposLogradouro;
	}

	public void setTiposLogradouro(TiposLogradouro tiposLogradouro) {
		this.tiposLogradouro = tiposLogradouro;
	}

	public List<AcessoOperadoresUnidade> getAcessoOperadoresUnidades() {
		return acessoOperadoresUnidades;
	}

	public void setAcessoOperadoresUnidades(List<AcessoOperadoresUnidade> acessoOperadoresUnidades) {
		this.acessoOperadoresUnidades = acessoOperadoresUnidades;
	}

	public List<FuncionariosFerias> getFuncionariosFerias() {
		return funcionariosFerias;
	}

	public void setFuncionariosFerias(List<FuncionariosFerias> funcionariosFerias) {
		this.funcionariosFerias = funcionariosFerias;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas1() {
		return funcionariosLicencas1;
	}

	public void setFuncionariosLicencas1(List<FuncionariosLicencas> funcionariosLicencas1) {
		this.funcionariosLicencas1 = funcionariosLicencas1;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas2() {
		return funcionariosLicencas2;
	}

	public void setFuncionariosLicencas2(List<FuncionariosLicencas> funcionariosLicencas2) {
		this.funcionariosLicencas2 = funcionariosLicencas2;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return pessoaOperadore1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return pessoaOperadore2;
	}

	public Autorizacoes addAutorizacoe(Autorizacoes autorizacoes) {
		getAutorizacoes().add(autorizacoes);
		autorizacoes.setUnidades(this);

		return autorizacoes;
	}

	public Autorizacoes removeAutorizacoe(Autorizacoes autorizacoes) {
		getAutorizacoes().remove(autorizacoes);
		autorizacoes.setUnidades(null);

		return autorizacoes;
	}

	public HistFuncionariosUnidadeAtuacao addHistFuncionariosUnidadeAtuacao(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		getHistFuncionariosUnidadeAtuacaos().add(histFuncionariosUnidadeAtuacao);
		histFuncionariosUnidadeAtuacao.setUnidades(this);

		return histFuncionariosUnidadeAtuacao;
	}

	public HistFuncionariosUnidadeAtuacao removeHistFuncionariosUnidadeAtuacao(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		getHistFuncionariosUnidadeAtuacaos().remove(histFuncionariosUnidadeAtuacao);
		histFuncionariosUnidadeAtuacao.setUnidades(null);

		return histFuncionariosUnidadeAtuacao;
	}

	public HistFuncionariosUnidadeLotacao addHistFuncionariosUnidadeLotacao(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
		getHistFuncionariosUnidadeLotacaos().add(histFuncionariosUnidadeLotacao);
		histFuncionariosUnidadeLotacao.setUnidades(this);

		return histFuncionariosUnidadeLotacao;
	}

	public HistFuncionariosUnidadeLotacao removeHistFuncionariosUnidadeLotacao(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
		getHistFuncionariosUnidadeLotacaos().remove(histFuncionariosUnidadeLotacao);
		histFuncionariosUnidadeLotacao.setUnidades(null);

		return histFuncionariosUnidadeLotacao;
	}

	public HistUnidadesDiretor addHistUnidadesDiretor(HistUnidadesDiretor histUnidadesDiretor) {
		getHistUnidadesDiretors().add(histUnidadesDiretor);
		histUnidadesDiretor.setUnidades(this);

		return histUnidadesDiretor;
	}

	public HistUnidadesDiretor removeHistUnidadesDiretor(HistUnidadesDiretor histUnidadesDiretor) {
		getHistUnidadesDiretors().remove(histUnidadesDiretor);
		histUnidadesDiretor.setUnidades(null);

		return histUnidadesDiretor;
	}

	public HistUnidadesRegime addHistUnidadesRegime(HistUnidadesRegime histUnidadesRegime) {
		getHistUnidadesRegimes().add(histUnidadesRegime);
		histUnidadesRegime.setUnidades(this);

		return histUnidadesRegime;
	}

	public HistUnidadesRegime removeHistUnidadesRegime(HistUnidadesRegime histUnidadesRegime) {
		getHistUnidadesRegimes().remove(histUnidadesRegime);
		histUnidadesRegime.setUnidades(null);

		return histUnidadesRegime;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		getPessoaFuncionarios().add(pessoaFuncionarios);
		pessoaFuncionarios.setUnidades(this);

		return pessoaFuncionarios;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setUnidades(null);

		return pessoaFuncionario;
	}

	public AcessoOperadoresUnidade addAcessoOperadoresUnidade(AcessoOperadoresUnidade acessoOperadoresUnidade) {
		getAcessoOperadoresUnidades().add(acessoOperadoresUnidade);
		acessoOperadoresUnidade.setUnidades(this);

		return acessoOperadoresUnidade;
	}

	public AcessoOperadoresUnidade removeAcessoOperadoresUnidade(AcessoOperadoresUnidade acessoOperadoresUnidade) {
		getAcessoOperadoresUnidades().remove(acessoOperadoresUnidade);
		acessoOperadoresUnidade.setUnidades(null);

		return acessoOperadoresUnidade;
	}

	public FuncionariosFerias addFuncionariosFeria(FuncionariosFerias funcionariosFeria) {
		getFuncionariosFerias().add(funcionariosFeria);
		funcionariosFeria.setUnidade(this);

		return funcionariosFeria;
	}

	public FuncionariosFerias removeFuncionariosFeria(FuncionariosFerias funcionariosFeria) {
		getFuncionariosFerias().remove(funcionariosFeria);
		funcionariosFeria.setUnidade(null);

		return funcionariosFeria;
	}

	public FuncionariosLicencas addFuncionariosLicencas1(FuncionariosLicencas funcionariosLicencas1) {
		getFuncionariosLicencas1().add(funcionariosLicencas1);
		funcionariosLicencas1.setUnidades1(this);

		return funcionariosLicencas1;
	}

	public FuncionariosLicencas removeFuncionariosLicencas1(FuncionariosLicencas funcionariosLicencas1) {
		getFuncionariosLicencas1().remove(funcionariosLicencas1);
		funcionariosLicencas1.setUnidades1(null);

		return funcionariosLicencas1;
	}

	public FuncionariosLicencas addFuncionariosLicencas2(FuncionariosLicencas funcionariosLicencas2) {
		getFuncionariosLicencas2().add(funcionariosLicencas2);
		funcionariosLicencas2.setUnidades2(this);

		return funcionariosLicencas2;
	}

	public FuncionariosLicencas removeFuncionariosLicencas2(FuncionariosLicencas funcionariosLicencas2) {
		getFuncionariosLicencas2().remove(funcionariosLicencas2);
		funcionariosLicencas2.setUnidades2(null);

		return funcionariosLicencas2;
	}	
	
}
