package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_operadores")
public class PessoaOperadores extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private Long idOperadorCadastroFk;

	@Column(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private Long idOperadorCancelamentoFk;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	private String senha;

	//bi-directional many-to-one association to Autorizacoe
	@OneToMany(mappedBy="pessoaOperadore")
	private List<Autorizacoes> autorizacoes;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos1;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos2;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="pessoaOperadore3")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos3;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="pessoaOperadore4")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos4;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias1;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias2;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="pessoaOperadore3")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias3;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="pessoaOperadore4")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias4;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosCargos> histFuncionariosCargos1;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosCargos> histFuncionariosCargos2;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="pessoaOperadore3")
	private List<HistFuncionariosCargos> histFuncionariosCargos3;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="pessoaOperadore4")
	private List<HistFuncionariosCargos> histFuncionariosCargos4;

	//bi-directional many-to-one association to HistFuncionariosCarreira
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiras1;

	//bi-directional many-to-one association to HistFuncionariosCarreira
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiras2;

	//bi-directional many-to-one association to HistFuncionariosCarreira
	@OneToMany(mappedBy="pessoaOperadore3")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiras3;

	//bi-directional many-to-one association to HistFuncionariosCarreira
	@OneToMany(mappedBy="pessoaOperadore4")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiras4;

	//bi-directional many-to-one association to HistFuncionariosClasse
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosClasse> histFuncionariosClasses1;

	//bi-directional many-to-one association to HistFuncionariosClasse
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosClasse> histFuncionariosClasses2;

	//bi-directional many-to-one association to HistFuncionariosSituacoe
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoes1;

	//bi-directional many-to-one association to HistFuncionariosSituacoe
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoes2;

	//bi-directional many-to-one association to HistFuncionariosUnidadeAtuacao
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos1;

	//bi-directional many-to-one association to HistFuncionariosUnidadeAtuacao
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos2;

	//bi-directional many-to-one association to HistFuncionariosUnidadeLotacao
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaos1;

	//bi-directional many-to-one association to HistFuncionariosUnidadeLotacao
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaos2;

	//bi-directional many-to-one association to HistFuncionariosVinculo
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosVinculos> histFuncionariosVinculos1;

	//bi-directional many-to-one association to HistFuncionariosVinculo
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosVinculos> histFuncionariosVinculos2;

	//bi-directional many-to-one association to HistUnidadesDiretor
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistUnidadesDiretor> histUnidadesDiretors1;

	//bi-directional many-to-one association to HistUnidadesDiretor
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistUnidadesDiretor> histUnidadesDiretors2;

	//bi-directional many-to-one association to HistUnidadesNaturezaJuridica
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicas1;

	//bi-directional many-to-one association to HistUnidadesNaturezaJuridica
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicas2;

	//bi-directional many-to-one association to HistUnidadesRegime
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistUnidadesRegime> histUnidadesRegimes1;

	//bi-directional many-to-one association to HistUnidadesRegime
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistUnidadesRegime> histUnidadesRegimes2;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<Pessoa> pessoas1;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<Pessoa> pessoas2;

	//bi-directional many-to-one association to PessoaBanco
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<PessoaBancos> pessoaBancos1;

	//bi-directional many-to-one association to PessoaBanco
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<PessoaBancos> pessoaBancos2;

	//bi-directional many-to-one association to PessoaFilho
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<PessoaFilhos> pessoaFilhos1;

	//bi-directional many-to-one association to PessoaFilho
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<PessoaFilhos> pessoaFilhos2;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<PessoaFuncionarios> pessoaFuncionarios1;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<PessoaFuncionarios> pessoaFuncionarios2;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to Privilegio
	@ManyToOne
	@JoinColumn(name="seq_privilegio")
	private Privilegios privilegio;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<Unidades> unidades1;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<Unidades> unidades2;

	//bi-directional many-to-one association to AcessoOperadoresUnidade
	@OneToMany(mappedBy="pessoaOperadore")
	private List<AcessoOperadoresUnidade> acessoOperadoresUnidades;

	//bi-directional many-to-one association to FuncionariosAnexo
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<FuncionariosAnexos> funcionariosAnexos1;

	//bi-directional many-to-one association to FuncionariosAnexo
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<FuncionariosAnexos> funcionariosAnexos2;

	//bi-directional many-to-one association to FuncionariosCapacitacoe
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<FuncionariosCapacitacoes> funcionariosCapacitacoes1;

	//bi-directional many-to-one association to FuncionariosCapacitacoe
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<FuncionariosCapacitacoes> funcionariosCapacitacoes2;

	//bi-directional many-to-one association to FuncionariosFeria
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<FuncionariosFerias> funcionariosFerias1;

	//bi-directional many-to-one association to FuncionariosFeria
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<FuncionariosFerias> funcionariosFerias2;

	//bi-directional many-to-one association to FuncionariosFeriasPeriodo
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodos1;

	//bi-directional many-to-one association to FuncionariosFeriasPeriodo
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodos2;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<FuncionariosLicencas> funcionariosLicencas1;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<FuncionariosLicencas> funcionariosLicencas2;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="pessoaOperadore3")
	private List<FuncionariosLicencas> funcionariosLicencas3;

	//bi-directional many-to-one association to HistFuncionariosNiveisCarreira
	@OneToMany(mappedBy="pessoaOperadore1")
	private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras1;

	//bi-directional many-to-one association to HistFuncionariosNiveisCarreira
	@OneToMany(mappedBy="pessoaOperadore2")
	private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras2;

	//bi-directional one-to-one association to UsersOperador
	/*@OneToOne(mappedBy="pessoaOperadore")
	private UsersOperador usersOperador;
*/
	public PessoaOperadores() {
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

	public Long getIdOperadorCadastroFk() {
		return this.idOperadorCadastroFk;
	}

	public void setIdOperadorCadastroFk(Long idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}

	public Long getIdOperadorCancelamentoFk() {
		return this.idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(Long idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

	public String getMotivoCancelamento() {
		return this.motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Autorizacoes> getAutorizacoes() {
		return this.autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacoes> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public Autorizacoes addAutorizacoe(Autorizacoes autorizacoe) {
		getAutorizacoes().add(autorizacoe);
		autorizacoe.setPessoaOperadores(this);

		return autorizacoe;
	}

	public Autorizacoes removeAutorizacoe(Autorizacoes autorizacoe) {
		getAutorizacoes().remove(autorizacoe);
		autorizacoe.setPessoaOperadores(null);

		return autorizacoe;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaos1() {
		return this.histFuncionariosAutorizacaos1;
	}

	public void setHistFuncionariosAutorizacaos1(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos1) {
		this.histFuncionariosAutorizacaos1 = histFuncionariosAutorizacaos1;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacaos1(HistFuncionariosAutorizacao histFuncionariosAutorizacaos1) {
		getHistFuncionariosAutorizacaos1().add(histFuncionariosAutorizacaos1);
		histFuncionariosAutorizacaos1.setPessoaOperadore1(this);

		return histFuncionariosAutorizacaos1;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacaos1(HistFuncionariosAutorizacao histFuncionariosAutorizacaos1) {
		getHistFuncionariosAutorizacaos1().remove(histFuncionariosAutorizacaos1);
		histFuncionariosAutorizacaos1.setPessoaOperadore1(null);

		return histFuncionariosAutorizacaos1;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaos2() {
		return this.histFuncionariosAutorizacaos2;
	}

	public void setHistFuncionariosAutorizacaos2(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos2) {
		this.histFuncionariosAutorizacaos2 = histFuncionariosAutorizacaos2;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacaos2(HistFuncionariosAutorizacao histFuncionariosAutorizacaos2) {
		getHistFuncionariosAutorizacaos2().add(histFuncionariosAutorizacaos2);
		histFuncionariosAutorizacaos2.setPessoaOperadore2(this);

		return histFuncionariosAutorizacaos2;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacaos2(HistFuncionariosAutorizacao histFuncionariosAutorizacaos2) {
		getHistFuncionariosAutorizacaos2().remove(histFuncionariosAutorizacaos2);
		histFuncionariosAutorizacaos2.setPessoaOperadore2(null);

		return histFuncionariosAutorizacaos2;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaos3() {
		return this.histFuncionariosAutorizacaos3;
	}

	public void setHistFuncionariosAutorizacaos3(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos3) {
		this.histFuncionariosAutorizacaos3 = histFuncionariosAutorizacaos3;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacaos3(HistFuncionariosAutorizacao histFuncionariosAutorizacaos3) {
		getHistFuncionariosAutorizacaos3().add(histFuncionariosAutorizacaos3);
		histFuncionariosAutorizacaos3.setPessoaOperadore3(this);

		return histFuncionariosAutorizacaos3;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacaos3(HistFuncionariosAutorizacao histFuncionariosAutorizacaos3) {
		getHistFuncionariosAutorizacaos3().remove(histFuncionariosAutorizacaos3);
		histFuncionariosAutorizacaos3.setPessoaOperadore3(null);

		return histFuncionariosAutorizacaos3;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaos4() {
		return this.histFuncionariosAutorizacaos4;
	}

	public void setHistFuncionariosAutorizacaos4(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos4) {
		this.histFuncionariosAutorizacaos4 = histFuncionariosAutorizacaos4;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacaos4(HistFuncionariosAutorizacao histFuncionariosAutorizacaos4) {
		getHistFuncionariosAutorizacaos4().add(histFuncionariosAutorizacaos4);
		histFuncionariosAutorizacaos4.setPessoaOperadore4(this);

		return histFuncionariosAutorizacaos4;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacaos4(HistFuncionariosAutorizacao histFuncionariosAutorizacaos4) {
		getHistFuncionariosAutorizacaos4().remove(histFuncionariosAutorizacaos4);
		histFuncionariosAutorizacaos4.setPessoaOperadore4(null);

		return histFuncionariosAutorizacaos4;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias1() {
		return this.histFuncionariosCargaHorarias1;
	}

	public void setHistFuncionariosCargaHorarias1(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias1) {
		this.histFuncionariosCargaHorarias1 = histFuncionariosCargaHorarias1;
	}

	public HistFuncionariosCargaHoraria addHistFuncionariosCargaHorarias1(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias1) {
		getHistFuncionariosCargaHorarias1().add(histFuncionariosCargaHorarias1);
		histFuncionariosCargaHorarias1.setPessoaOperadore1(this);

		return histFuncionariosCargaHorarias1;
	}

	public HistFuncionariosCargaHoraria removeHistFuncionariosCargaHorarias1(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias1) {
		getHistFuncionariosCargaHorarias1().remove(histFuncionariosCargaHorarias1);
		histFuncionariosCargaHorarias1.setPessoaOperadore1(null);

		return histFuncionariosCargaHorarias1;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias2() {
		return this.histFuncionariosCargaHorarias2;
	}

	public void setHistFuncionariosCargaHorarias2(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias2) {
		this.histFuncionariosCargaHorarias2 = histFuncionariosCargaHorarias2;
	}

	public HistFuncionariosCargaHoraria addHistFuncionariosCargaHorarias2(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias2) {
		getHistFuncionariosCargaHorarias2().add(histFuncionariosCargaHorarias2);
		histFuncionariosCargaHorarias2.setPessoaOperadore2(this);

		return histFuncionariosCargaHorarias2;
	}

	public HistFuncionariosCargaHoraria removeHistFuncionariosCargaHorarias2(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias2) {
		getHistFuncionariosCargaHorarias2().remove(histFuncionariosCargaHorarias2);
		histFuncionariosCargaHorarias2.setPessoaOperadore2(null);

		return histFuncionariosCargaHorarias2;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias3() {
		return this.histFuncionariosCargaHorarias3;
	}

	public void setHistFuncionariosCargaHorarias3(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias3) {
		this.histFuncionariosCargaHorarias3 = histFuncionariosCargaHorarias3;
	}

	public HistFuncionariosCargaHoraria addHistFuncionariosCargaHorarias3(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias3) {
		getHistFuncionariosCargaHorarias3().add(histFuncionariosCargaHorarias3);
		histFuncionariosCargaHorarias3.setPessoaOperadore3(this);

		return histFuncionariosCargaHorarias3;
	}

	public HistFuncionariosCargaHoraria removeHistFuncionariosCargaHorarias3(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias3) {
		getHistFuncionariosCargaHorarias3().remove(histFuncionariosCargaHorarias3);
		histFuncionariosCargaHorarias3.setPessoaOperadore3(null);

		return histFuncionariosCargaHorarias3;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias4() {
		return this.histFuncionariosCargaHorarias4;
	}

	public void setHistFuncionariosCargaHorarias4(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias4) {
		this.histFuncionariosCargaHorarias4 = histFuncionariosCargaHorarias4;
	}

	public HistFuncionariosCargaHoraria addHistFuncionariosCargaHorarias4(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias4) {
		getHistFuncionariosCargaHorarias4().add(histFuncionariosCargaHorarias4);
		histFuncionariosCargaHorarias4.setPessoaOperadore4(this);

		return histFuncionariosCargaHorarias4;
	}

	public HistFuncionariosCargaHoraria removeHistFuncionariosCargaHorarias4(HistFuncionariosCargaHoraria histFuncionariosCargaHorarias4) {
		getHistFuncionariosCargaHorarias4().remove(histFuncionariosCargaHorarias4);
		histFuncionariosCargaHorarias4.setPessoaOperadore4(null);

		return histFuncionariosCargaHorarias4;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos1() {
		return this.histFuncionariosCargos1;
	}

	public void setHistFuncionariosCargos1(List<HistFuncionariosCargos> histFuncionariosCargos1) {
		this.histFuncionariosCargos1 = histFuncionariosCargos1;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos1(HistFuncionariosCargos histFuncionariosCargos1) {
		getHistFuncionariosCargos1().add(histFuncionariosCargos1);
		histFuncionariosCargos1.setPessoaOperadore1(this);

		return histFuncionariosCargos1;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos1(HistFuncionariosCargos histFuncionariosCargos1) {
		getHistFuncionariosCargos1().remove(histFuncionariosCargos1);
		histFuncionariosCargos1.setPessoaOperadore1(null);

		return histFuncionariosCargos1;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos2() {
		return this.histFuncionariosCargos2;
	}

	public void setHistFuncionariosCargos2(List<HistFuncionariosCargos> histFuncionariosCargos2) {
		this.histFuncionariosCargos2 = histFuncionariosCargos2;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos2(HistFuncionariosCargos histFuncionariosCargos2) {
		getHistFuncionariosCargos2().add(histFuncionariosCargos2);
		histFuncionariosCargos2.setPessoaOperadore2(this);

		return histFuncionariosCargos2;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos2(HistFuncionariosCargos histFuncionariosCargos2) {
		getHistFuncionariosCargos2().remove(histFuncionariosCargos2);
		histFuncionariosCargos2.setPessoaOperadore2(null);

		return histFuncionariosCargos2;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos3() {
		return this.histFuncionariosCargos3;
	}

	public void setHistFuncionariosCargos3(List<HistFuncionariosCargos> histFuncionariosCargos3) {
		this.histFuncionariosCargos3 = histFuncionariosCargos3;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos3(HistFuncionariosCargos histFuncionariosCargos3) {
		getHistFuncionariosCargos3().add(histFuncionariosCargos3);
		histFuncionariosCargos3.setPessoaOperadore3(this);

		return histFuncionariosCargos3;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos3(HistFuncionariosCargos histFuncionariosCargos3) {
		getHistFuncionariosCargos3().remove(histFuncionariosCargos3);
		histFuncionariosCargos3.setPessoaOperadore3(null);

		return histFuncionariosCargos3;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos4() {
		return this.histFuncionariosCargos4;
	}

	public void setHistFuncionariosCargos4(List<HistFuncionariosCargos> histFuncionariosCargos4) {
		this.histFuncionariosCargos4 = histFuncionariosCargos4;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos4(HistFuncionariosCargos histFuncionariosCargos4) {
		getHistFuncionariosCargos4().add(histFuncionariosCargos4);
		histFuncionariosCargos4.setPessoaOperadore4(this);

		return histFuncionariosCargos4;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos4(HistFuncionariosCargos histFuncionariosCargos4) {
		getHistFuncionariosCargos4().remove(histFuncionariosCargos4);
		histFuncionariosCargos4.setPessoaOperadore4(null);

		return histFuncionariosCargos4;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiras1() {
		return this.histFuncionariosCarreiras1;
	}

	public void setHistFuncionariosCarreiras1(List<HistFuncionariosCarreira> histFuncionariosCarreiras1) {
		this.histFuncionariosCarreiras1 = histFuncionariosCarreiras1;
	}

	public HistFuncionariosCarreira addHistFuncionariosCarreiras1(HistFuncionariosCarreira histFuncionariosCarreiras1) {
		getHistFuncionariosCarreiras1().add(histFuncionariosCarreiras1);
		histFuncionariosCarreiras1.setPessoaOperadore1(this);

		return histFuncionariosCarreiras1;
	}

	public HistFuncionariosCarreira removeHistFuncionariosCarreiras1(HistFuncionariosCarreira histFuncionariosCarreiras1) {
		getHistFuncionariosCarreiras1().remove(histFuncionariosCarreiras1);
		histFuncionariosCarreiras1.setPessoaOperadore1(null);

		return histFuncionariosCarreiras1;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiras2() {
		return this.histFuncionariosCarreiras2;
	}

	public void setHistFuncionariosCarreiras2(List<HistFuncionariosCarreira> histFuncionariosCarreiras2) {
		this.histFuncionariosCarreiras2 = histFuncionariosCarreiras2;
	}

	public HistFuncionariosCarreira addHistFuncionariosCarreiras2(HistFuncionariosCarreira histFuncionariosCarreiras2) {
		getHistFuncionariosCarreiras2().add(histFuncionariosCarreiras2);
		histFuncionariosCarreiras2.setPessoaOperadore2(this);

		return histFuncionariosCarreiras2;
	}

	public HistFuncionariosCarreira removeHistFuncionariosCarreiras2(HistFuncionariosCarreira histFuncionariosCarreiras2) {
		getHistFuncionariosCarreiras2().remove(histFuncionariosCarreiras2);
		histFuncionariosCarreiras2.setPessoaOperadore2(null);

		return histFuncionariosCarreiras2;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiras3() {
		return this.histFuncionariosCarreiras3;
	}

	public void setHistFuncionariosCarreiras3(List<HistFuncionariosCarreira> histFuncionariosCarreiras3) {
		this.histFuncionariosCarreiras3 = histFuncionariosCarreiras3;
	}

	public HistFuncionariosCarreira addHistFuncionariosCarreiras3(HistFuncionariosCarreira histFuncionariosCarreiras3) {
		getHistFuncionariosCarreiras3().add(histFuncionariosCarreiras3);
		histFuncionariosCarreiras3.setPessoaOperadore3(this);

		return histFuncionariosCarreiras3;
	}

	public HistFuncionariosCarreira removeHistFuncionariosCarreiras3(HistFuncionariosCarreira histFuncionariosCarreiras3) {
		getHistFuncionariosCarreiras3().remove(histFuncionariosCarreiras3);
		histFuncionariosCarreiras3.setPessoaOperadore3(null);

		return histFuncionariosCarreiras3;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiras4() {
		return this.histFuncionariosCarreiras4;
	}

	public void setHistFuncionariosCarreiras4(List<HistFuncionariosCarreira> histFuncionariosCarreiras4) {
		this.histFuncionariosCarreiras4 = histFuncionariosCarreiras4;
	}

	public HistFuncionariosCarreira addHistFuncionariosCarreiras4(HistFuncionariosCarreira histFuncionariosCarreiras4) {
		getHistFuncionariosCarreiras4().add(histFuncionariosCarreiras4);
		histFuncionariosCarreiras4.setPessoaOperadore4(this);

		return histFuncionariosCarreiras4;
	}

	public HistFuncionariosCarreira removeHistFuncionariosCarreiras4(HistFuncionariosCarreira histFuncionariosCarreiras4) {
		getHistFuncionariosCarreiras4().remove(histFuncionariosCarreiras4);
		histFuncionariosCarreiras4.setPessoaOperadore4(null);

		return histFuncionariosCarreiras4;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasses1() {
		return this.histFuncionariosClasses1;
	}

	public void setHistFuncionariosClasses1(List<HistFuncionariosClasse> histFuncionariosClasses1) {
		this.histFuncionariosClasses1 = histFuncionariosClasses1;
	}

	public HistFuncionariosClasse addHistFuncionariosClasses1(HistFuncionariosClasse histFuncionariosClasses1) {
		getHistFuncionariosClasses1().add(histFuncionariosClasses1);
		histFuncionariosClasses1.setPessoaOperadore1(this);

		return histFuncionariosClasses1;
	}

	public HistFuncionariosClasse removeHistFuncionariosClasses1(HistFuncionariosClasse histFuncionariosClasses1) {
		getHistFuncionariosClasses1().remove(histFuncionariosClasses1);
		histFuncionariosClasses1.setPessoaOperadore1(null);

		return histFuncionariosClasses1;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasses2() {
		return this.histFuncionariosClasses2;
	}

	public void setHistFuncionariosClasses2(List<HistFuncionariosClasse> histFuncionariosClasses2) {
		this.histFuncionariosClasses2 = histFuncionariosClasses2;
	}

	public HistFuncionariosClasse addHistFuncionariosClasses2(HistFuncionariosClasse histFuncionariosClasses2) {
		getHistFuncionariosClasses2().add(histFuncionariosClasses2);
		histFuncionariosClasses2.setPessoaOperadore2(this);

		return histFuncionariosClasses2;
	}

	public HistFuncionariosClasse removeHistFuncionariosClasses2(HistFuncionariosClasse histFuncionariosClasses2) {
		getHistFuncionariosClasses2().remove(histFuncionariosClasses2);
		histFuncionariosClasses2.setPessoaOperadore2(null);

		return histFuncionariosClasses2;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoes1() {
		return this.histFuncionariosSituacoes1;
	}

	public void setHistFuncionariosSituacoes1(List<HistFuncionariosSituacoes> histFuncionariosSituacoes1) {
		this.histFuncionariosSituacoes1 = histFuncionariosSituacoes1;
	}

	public HistFuncionariosSituacoes addHistFuncionariosSituacoes1(HistFuncionariosSituacoes histFuncionariosSituacoes1) {
		getHistFuncionariosSituacoes1().add(histFuncionariosSituacoes1);
		histFuncionariosSituacoes1.setPessoaOperadore1(this);

		return histFuncionariosSituacoes1;
	}

	public HistFuncionariosSituacoes removeHistFuncionariosSituacoes1(HistFuncionariosSituacoes histFuncionariosSituacoes1) {
		getHistFuncionariosSituacoes1().remove(histFuncionariosSituacoes1);
		histFuncionariosSituacoes1.setPessoaOperadore1(null);

		return histFuncionariosSituacoes1;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoes2() {
		return this.histFuncionariosSituacoes2;
	}

	public void setHistFuncionariosSituacoes2(List<HistFuncionariosSituacoes> histFuncionariosSituacoes2) {
		this.histFuncionariosSituacoes2 = histFuncionariosSituacoes2;
	}

	public HistFuncionariosSituacoes addHistFuncionariosSituacoes2(HistFuncionariosSituacoes histFuncionariosSituacoes2) {
		getHistFuncionariosSituacoes2().add(histFuncionariosSituacoes2);
		histFuncionariosSituacoes2.setPessoaOperadore2(this);

		return histFuncionariosSituacoes2;
	}

	public HistFuncionariosSituacoes removeHistFuncionariosSituacoes2(HistFuncionariosSituacoes histFuncionariosSituacoes2) {
		getHistFuncionariosSituacoes2().remove(histFuncionariosSituacoes2);
		histFuncionariosSituacoes2.setPessoaOperadore2(null);

		return histFuncionariosSituacoes2;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaos1() {
		return this.histFuncionariosUnidadeAtuacaos1;
	}

	public void setHistFuncionariosUnidadeAtuacaos1(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos1) {
		this.histFuncionariosUnidadeAtuacaos1 = histFuncionariosUnidadeAtuacaos1;
	}

	public HistFuncionariosUnidadeAtuacao addHistFuncionariosUnidadeAtuacaos1(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaos1) {
		getHistFuncionariosUnidadeAtuacaos1().add(histFuncionariosUnidadeAtuacaos1);
		histFuncionariosUnidadeAtuacaos1.setPessoaOperadore1(this);

		return histFuncionariosUnidadeAtuacaos1;
	}

	public HistFuncionariosUnidadeAtuacao removeHistFuncionariosUnidadeAtuacaos1(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaos1) {
		getHistFuncionariosUnidadeAtuacaos1().remove(histFuncionariosUnidadeAtuacaos1);
		histFuncionariosUnidadeAtuacaos1.setPessoaOperadore1(null);

		return histFuncionariosUnidadeAtuacaos1;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaos2() {
		return this.histFuncionariosUnidadeAtuacaos2;
	}

	public void setHistFuncionariosUnidadeAtuacaos2(List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaos2) {
		this.histFuncionariosUnidadeAtuacaos2 = histFuncionariosUnidadeAtuacaos2;
	}

	public HistFuncionariosUnidadeAtuacao addHistFuncionariosUnidadeAtuacaos2(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaos2) {
		getHistFuncionariosUnidadeAtuacaos2().add(histFuncionariosUnidadeAtuacaos2);
		histFuncionariosUnidadeAtuacaos2.setPessoaOperadore2(this);

		return histFuncionariosUnidadeAtuacaos2;
	}

	public HistFuncionariosUnidadeAtuacao removeHistFuncionariosUnidadeAtuacaos2(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacaos2) {
		getHistFuncionariosUnidadeAtuacaos2().remove(histFuncionariosUnidadeAtuacaos2);
		histFuncionariosUnidadeAtuacaos2.setPessoaOperadore2(null);

		return histFuncionariosUnidadeAtuacaos2;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaos1() {
		return this.histFuncionariosUnidadeLotacaos1;
	}

	public void setHistFuncionariosUnidadeLotacaos1(List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaos1) {
		this.histFuncionariosUnidadeLotacaos1 = histFuncionariosUnidadeLotacaos1;
	}

	public HistFuncionariosUnidadeLotacao addHistFuncionariosUnidadeLotacaos1(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaos1) {
		getHistFuncionariosUnidadeLotacaos1().add(histFuncionariosUnidadeLotacaos1);
		histFuncionariosUnidadeLotacaos1.setPessoaOperadores1(this);

		return histFuncionariosUnidadeLotacaos1;
	}

	public HistFuncionariosUnidadeLotacao removeHistFuncionariosUnidadeLotacaos1(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaos1) {
		getHistFuncionariosUnidadeLotacaos1().remove(histFuncionariosUnidadeLotacaos1);
		histFuncionariosUnidadeLotacaos1.setPessoaOperadores1(null);

		return histFuncionariosUnidadeLotacaos1;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaos2() {
		return this.histFuncionariosUnidadeLotacaos2;
	}

	public void setHistFuncionariosUnidadeLotacaos2(List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaos2) {
		this.histFuncionariosUnidadeLotacaos2 = histFuncionariosUnidadeLotacaos2;
	}

	public HistFuncionariosUnidadeLotacao addHistFuncionariosUnidadeLotacaos2(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaos2) {
		getHistFuncionariosUnidadeLotacaos2().add(histFuncionariosUnidadeLotacaos2);
		histFuncionariosUnidadeLotacaos2.setPessoaOperadores2(this);

		return histFuncionariosUnidadeLotacaos2;
	}

	public HistFuncionariosUnidadeLotacao removeHistFuncionariosUnidadeLotacaos2(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacaos2) {
		getHistFuncionariosUnidadeLotacaos2().remove(histFuncionariosUnidadeLotacaos2);
		histFuncionariosUnidadeLotacaos2.setPessoaOperadores2(null);

		return histFuncionariosUnidadeLotacaos2;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculos1() {
		return this.histFuncionariosVinculos1;
	}

	public void setHistFuncionariosVinculos1(List<HistFuncionariosVinculos> histFuncionariosVinculos1) {
		this.histFuncionariosVinculos1 = histFuncionariosVinculos1;
	}

	public HistFuncionariosVinculos addHistFuncionariosVinculos1(HistFuncionariosVinculos histFuncionariosVinculos1) {
		getHistFuncionariosVinculos1().add(histFuncionariosVinculos1);
		histFuncionariosVinculos1.setPessoaOperadore1(this);

		return histFuncionariosVinculos1;
	}

	public HistFuncionariosVinculos removeHistFuncionariosVinculos1(HistFuncionariosVinculos histFuncionariosVinculos1) {
		getHistFuncionariosVinculos1().remove(histFuncionariosVinculos1);
		histFuncionariosVinculos1.setPessoaOperadore1(null);

		return histFuncionariosVinculos1;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculos2() {
		return this.histFuncionariosVinculos2;
	}

	public void setHistFuncionariosVinculos2(List<HistFuncionariosVinculos> histFuncionariosVinculos2) {
		this.histFuncionariosVinculos2 = histFuncionariosVinculos2;
	}

	public HistFuncionariosVinculos addHistFuncionariosVinculos2(HistFuncionariosVinculos histFuncionariosVinculos2) {
		getHistFuncionariosVinculos2().add(histFuncionariosVinculos2);
		histFuncionariosVinculos2.setPessoaOperadore2(this);

		return histFuncionariosVinculos2;
	}

	public HistFuncionariosVinculos removeHistFuncionariosVinculos2(HistFuncionariosVinculos histFuncionariosVinculos2) {
		getHistFuncionariosVinculos2().remove(histFuncionariosVinculos2);
		histFuncionariosVinculos2.setPessoaOperadore2(null);

		return histFuncionariosVinculos2;
	}

	public List<HistUnidadesDiretor> getHistUnidadesDiretors1() {
		return this.histUnidadesDiretors1;
	}

	public void setHistUnidadesDiretors1(List<HistUnidadesDiretor> histUnidadesDiretors1) {
		this.histUnidadesDiretors1 = histUnidadesDiretors1;
	}

	public HistUnidadesDiretor addHistUnidadesDiretors1(HistUnidadesDiretor histUnidadesDiretors1) {
		getHistUnidadesDiretors1().add(histUnidadesDiretors1);
		histUnidadesDiretors1.setPessoaOperadores1(this);

		return histUnidadesDiretors1;
	}

	public HistUnidadesDiretor removeHistUnidadesDiretors1(HistUnidadesDiretor histUnidadesDiretors1) {
		getHistUnidadesDiretors1().remove(histUnidadesDiretors1);
		histUnidadesDiretors1.setPessoaOperadores1(null);

		return histUnidadesDiretors1;
	}

	public List<HistUnidadesDiretor> getHistUnidadesDiretors2() {
		return this.histUnidadesDiretors2;
	}

	public void setHistUnidadesDiretors2(List<HistUnidadesDiretor> histUnidadesDiretors2) {
		this.histUnidadesDiretors2 = histUnidadesDiretors2;
	}

	public HistUnidadesDiretor addHistUnidadesDiretors2(HistUnidadesDiretor histUnidadesDiretors2) {
		getHistUnidadesDiretors2().add(histUnidadesDiretors2);
		histUnidadesDiretors2.setPessoaOperadores2(this);

		return histUnidadesDiretors2;
	}

	public HistUnidadesDiretor removeHistUnidadesDiretors2(HistUnidadesDiretor histUnidadesDiretors2) {
		getHistUnidadesDiretors2().remove(histUnidadesDiretors2);
		histUnidadesDiretors2.setPessoaOperadores2(null);

		return histUnidadesDiretors2;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicas1() {
		return this.histUnidadesNaturezaJuridicas1;
	}

	public void setHistUnidadesNaturezaJuridicas1(List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicas1) {
		this.histUnidadesNaturezaJuridicas1 = histUnidadesNaturezaJuridicas1;
	}

	public HistUnidadesNaturezaJuridica addHistUnidadesNaturezaJuridicas1(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicas1) {
		getHistUnidadesNaturezaJuridicas1().add(histUnidadesNaturezaJuridicas1);
		histUnidadesNaturezaJuridicas1.setPessoaOperadore1(this);

		return histUnidadesNaturezaJuridicas1;
	}

	public HistUnidadesNaturezaJuridica removeHistUnidadesNaturezaJuridicas1(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicas1) {
		getHistUnidadesNaturezaJuridicas1().remove(histUnidadesNaturezaJuridicas1);
		histUnidadesNaturezaJuridicas1.setPessoaOperadore1(null);

		return histUnidadesNaturezaJuridicas1;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicas2() {
		return this.histUnidadesNaturezaJuridicas2;
	}

	public void setHistUnidadesNaturezaJuridicas2(List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicas2) {
		this.histUnidadesNaturezaJuridicas2 = histUnidadesNaturezaJuridicas2;
	}

	public HistUnidadesNaturezaJuridica addHistUnidadesNaturezaJuridicas2(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicas2) {
		getHistUnidadesNaturezaJuridicas2().add(histUnidadesNaturezaJuridicas2);
		histUnidadesNaturezaJuridicas2.setPessoaOperadore2(this);

		return histUnidadesNaturezaJuridicas2;
	}

	public HistUnidadesNaturezaJuridica removeHistUnidadesNaturezaJuridicas2(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridicas2) {
		getHistUnidadesNaturezaJuridicas2().remove(histUnidadesNaturezaJuridicas2);
		histUnidadesNaturezaJuridicas2.setPessoaOperadore2(null);

		return histUnidadesNaturezaJuridicas2;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimes1() {
		return this.histUnidadesRegimes1;
	}

	public void setHistUnidadesRegimes1(List<HistUnidadesRegime> histUnidadesRegimes1) {
		this.histUnidadesRegimes1 = histUnidadesRegimes1;
	}

	public HistUnidadesRegime addHistUnidadesRegimes1(HistUnidadesRegime histUnidadesRegimes1) {
		getHistUnidadesRegimes1().add(histUnidadesRegimes1);
		histUnidadesRegimes1.setPessoaOperadores1(this);

		return histUnidadesRegimes1;
	}

	public HistUnidadesRegime removeHistUnidadesRegimes1(HistUnidadesRegime histUnidadesRegimes1) {
		getHistUnidadesRegimes1().remove(histUnidadesRegimes1);
		histUnidadesRegimes1.setPessoaOperadores1(null);

		return histUnidadesRegimes1;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimes2() {
		return this.histUnidadesRegimes2;
	}

	public void setHistUnidadesRegimes2(List<HistUnidadesRegime> histUnidadesRegimes2) {
		this.histUnidadesRegimes2 = histUnidadesRegimes2;
	}

	public HistUnidadesRegime addHistUnidadesRegimes2(HistUnidadesRegime histUnidadesRegimes2) {
		getHistUnidadesRegimes2().add(histUnidadesRegimes2);
		histUnidadesRegimes2.setPessoaOperadores2(this);

		return histUnidadesRegimes2;
	}

	public HistUnidadesRegime removeHistUnidadesRegimes2(HistUnidadesRegime histUnidadesRegimes2) {
		getHistUnidadesRegimes2().remove(histUnidadesRegimes2);
		histUnidadesRegimes2.setPessoaOperadores2(null);

		return histUnidadesRegimes2;
	}

	public List<Pessoa> getPessoas1() {
		return this.pessoas1;
	}

	public void setPessoas1(List<Pessoa> pessoas1) {
		this.pessoas1 = pessoas1;
	}

	public Pessoa addPessoas1(Pessoa pessoas1) {
		getPessoas1().add(pessoas1);
		pessoas1.setPessoaOperadore1(this);

		return pessoas1;
	}

	public Pessoa removePessoas1(Pessoa pessoas1) {
		getPessoas1().remove(pessoas1);
		pessoas1.setPessoaOperadore1(null);

		return pessoas1;
	}

	public List<Pessoa> getPessoas2() {
		return this.pessoas2;
	}

	public void setPessoas2(List<Pessoa> pessoas2) {
		this.pessoas2 = pessoas2;
	}

	public Pessoa addPessoas2(Pessoa pessoas2) {
		getPessoas2().add(pessoas2);
		pessoas2.setPessoaOperadore2(this);

		return pessoas2;
	}

	public Pessoa removePessoas2(Pessoa pessoas2) {
		getPessoas2().remove(pessoas2);
		pessoas2.setPessoaOperadore2(null);

		return pessoas2;
	}

	public List<PessoaBancos> getPessoaBancos1() {
		return this.pessoaBancos1;
	}

	public void setPessoaBancos1(List<PessoaBancos> pessoaBancos1) {
		this.pessoaBancos1 = pessoaBancos1;
	}

	public PessoaBancos addPessoaBancos1(PessoaBancos pessoaBancos1) {
		getPessoaBancos1().add(pessoaBancos1);
		pessoaBancos1.setPessoaOperadore1(this);

		return pessoaBancos1;
	}

	public PessoaBancos removePessoaBancos1(PessoaBancos pessoaBancos1) {
		getPessoaBancos1().remove(pessoaBancos1);
		pessoaBancos1.setPessoaOperadore1(null);

		return pessoaBancos1;
	}

	public List<PessoaBancos> getPessoaBancos2() {
		return this.pessoaBancos2;
	}

	public void setPessoaBancos2(List<PessoaBancos> pessoaBancos2) {
		this.pessoaBancos2 = pessoaBancos2;
	}

	public PessoaBancos addPessoaBancos2(PessoaBancos pessoaBancos2) {
		getPessoaBancos2().add(pessoaBancos2);
		pessoaBancos2.setPessoaOperadore2(this);

		return pessoaBancos2;
	}

	public PessoaBancos removePessoaBancos2(PessoaBancos pessoaBancos2) {
		getPessoaBancos2().remove(pessoaBancos2);
		pessoaBancos2.setPessoaOperadore2(null);

		return pessoaBancos2;
	}

	public List<PessoaFilhos> getPessoaFilhos1() {
		return this.pessoaFilhos1;
	}

	public void setPessoaFilhos1(List<PessoaFilhos> pessoaFilhos1) {
		this.pessoaFilhos1 = pessoaFilhos1;
	}

	public PessoaFilhos addPessoaFilhos1(PessoaFilhos pessoaFilhos1) {
		getPessoaFilhos1().add(pessoaFilhos1);
		pessoaFilhos1.setPessoaOperadore1(this);

		return pessoaFilhos1;
	}

	public PessoaFilhos removePessoaFilhos1(PessoaFilhos pessoaFilhos1) {
		getPessoaFilhos1().remove(pessoaFilhos1);
		pessoaFilhos1.setPessoaOperadore1(null);

		return pessoaFilhos1;
	}

	public List<PessoaFilhos> getPessoaFilhos2() {
		return this.pessoaFilhos2;
	}

	public void setPessoaFilhos2(List<PessoaFilhos> pessoaFilhos2) {
		this.pessoaFilhos2 = pessoaFilhos2;
	}

	public PessoaFilhos addPessoaFilhos2(PessoaFilhos pessoaFilhos2) {
		getPessoaFilhos2().add(pessoaFilhos2);
		pessoaFilhos2.setPessoaOperadore2(this);

		return pessoaFilhos2;
	}

	public PessoaFilhos removePessoaFilhos2(PessoaFilhos pessoaFilhos2) {
		getPessoaFilhos2().remove(pessoaFilhos2);
		pessoaFilhos2.setPessoaOperadore2(null);

		return pessoaFilhos2;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios1() {
		return this.pessoaFuncionarios1;
	}

	public void setPessoaFuncionarios1(List<PessoaFuncionarios> pessoaFuncionarios1) {
		this.pessoaFuncionarios1 = pessoaFuncionarios1;
	}

	public PessoaFuncionarios addPessoaFuncionarios1(PessoaFuncionarios pessoaFuncionarios1) {
		getPessoaFuncionarios1().add(pessoaFuncionarios1);
		pessoaFuncionarios1.setPessoaOperadore1(this);

		return pessoaFuncionarios1;
	}

	public PessoaFuncionarios removePessoaFuncionarios1(PessoaFuncionarios pessoaFuncionarios1) {
		getPessoaFuncionarios1().remove(pessoaFuncionarios1);
		pessoaFuncionarios1.setPessoaOperadore1(null);

		return pessoaFuncionarios1;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios2() {
		return this.pessoaFuncionarios2;
	}

	public void setPessoaFuncionarios2(List<PessoaFuncionarios> pessoaFuncionarios2) {
		this.pessoaFuncionarios2 = pessoaFuncionarios2;
	}

	public PessoaFuncionarios addPessoaFuncionarios2(PessoaFuncionarios pessoaFuncionarios2) {
		getPessoaFuncionarios2().add(pessoaFuncionarios2);
		pessoaFuncionarios2.setPessoaOperadore2(this);

		return pessoaFuncionarios2;
	}

	public PessoaFuncionarios removePessoaFuncionarios2(PessoaFuncionarios pessoaFuncionarios2) {
		getPessoaFuncionarios2().remove(pessoaFuncionarios2);
		pessoaFuncionarios2.setPessoaOperadore2(null);

		return pessoaFuncionarios2;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Privilegios getPrivilegio() {
		return this.privilegio;
	}

	public void setPrivilegio(Privilegios privilegio) {
		this.privilegio = privilegio;
	}

	public List<Unidades> getUnidades1() {
		return this.unidades1;
	}

	public void setUnidades1(List<Unidades> unidades1) {
		this.unidades1 = unidades1;
	}

	public Unidades addUnidades1(Unidades unidades1) {
		getUnidades1().add(unidades1);
		unidades1.setPessoaOperadore1(this);

		return unidades1;
	}

	public Unidades removeUnidades1(Unidades unidades1) {
		getUnidades1().remove(unidades1);
		unidades1.setPessoaOperadore1(null);

		return unidades1;
	}

	public List<Unidades> getUnidades2() {
		return this.unidades2;
	}

	public void setUnidades2(List<Unidades> unidades2) {
		this.unidades2 = unidades2;
	}

	public Unidades addUnidades2(Unidades unidades2) {
		getUnidades2().add(unidades2);
		unidades2.setPessoaOperadore2(this);

		return unidades2;
	}

	public Unidades removeUnidades2(Unidades unidades2) {
		getUnidades2().remove(unidades2);
		unidades2.setPessoaOperadore2(null);

		return unidades2;
	}

	public List<AcessoOperadoresUnidade> getAcessoOperadoresUnidades() {
		return this.acessoOperadoresUnidades;
	}

	public void setAcessoOperadoresUnidades(List<AcessoOperadoresUnidade> acessoOperadoresUnidades) {
		this.acessoOperadoresUnidades = acessoOperadoresUnidades;
	}

	public AcessoOperadoresUnidade addAcessoOperadoresUnidade(AcessoOperadoresUnidade acessoOperadoresUnidade) {
		getAcessoOperadoresUnidades().add(acessoOperadoresUnidade);
		acessoOperadoresUnidade.setPessoaOperadore(this);

		return acessoOperadoresUnidade;
	}

	public AcessoOperadoresUnidade removeAcessoOperadoresUnidade(AcessoOperadoresUnidade acessoOperadoresUnidade) {
		getAcessoOperadoresUnidades().remove(acessoOperadoresUnidade);
		acessoOperadoresUnidade.setPessoaOperadore(null);

		return acessoOperadoresUnidade;
	}

	public List<FuncionariosAnexos> getFuncionariosAnexos1() {
		return this.funcionariosAnexos1;
	}

	public void setFuncionariosAnexos1(List<FuncionariosAnexos> funcionariosAnexos1) {
		this.funcionariosAnexos1 = funcionariosAnexos1;
	}

	public FuncionariosAnexos addFuncionariosAnexos1(FuncionariosAnexos funcionariosAnexos1) {
		getFuncionariosAnexos1().add(funcionariosAnexos1);
		funcionariosAnexos1.setPessoaOperadore1(this);

		return funcionariosAnexos1;
	}

	public FuncionariosAnexos removeFuncionariosAnexos1(FuncionariosAnexos funcionariosAnexos1) {
		getFuncionariosAnexos1().remove(funcionariosAnexos1);
		funcionariosAnexos1.setPessoaOperadore1(null);

		return funcionariosAnexos1;
	}

	public List<FuncionariosAnexos> getFuncionariosAnexos2() {
		return this.funcionariosAnexos2;
	}

	public void setFuncionariosAnexos2(List<FuncionariosAnexos> funcionariosAnexos2) {
		this.funcionariosAnexos2 = funcionariosAnexos2;
	}

	public FuncionariosAnexos addFuncionariosAnexos2(FuncionariosAnexos funcionariosAnexos2) {
		getFuncionariosAnexos2().add(funcionariosAnexos2);
		funcionariosAnexos2.setPessoaOperadore2(this);

		return funcionariosAnexos2;
	}

	public FuncionariosAnexos removeFuncionariosAnexos2(FuncionariosAnexos funcionariosAnexos2) {
		getFuncionariosAnexos2().remove(funcionariosAnexos2);
		funcionariosAnexos2.setPessoaOperadore2(null);

		return funcionariosAnexos2;
	}

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoes1() {
		return this.funcionariosCapacitacoes1;
	}

	public void setFuncionariosCapacitacoes1(List<FuncionariosCapacitacoes> funcionariosCapacitacoes1) {
		this.funcionariosCapacitacoes1 = funcionariosCapacitacoes1;
	}

	public FuncionariosCapacitacoes addFuncionariosCapacitacoes1(FuncionariosCapacitacoes funcionariosCapacitacoes1) {
		getFuncionariosCapacitacoes1().add(funcionariosCapacitacoes1);
		funcionariosCapacitacoes1.setPessoaOperadore1(this);

		return funcionariosCapacitacoes1;
	}

	public FuncionariosCapacitacoes removeFuncionariosCapacitacoes1(FuncionariosCapacitacoes funcionariosCapacitacoes1) {
		getFuncionariosCapacitacoes1().remove(funcionariosCapacitacoes1);
		funcionariosCapacitacoes1.setPessoaOperadore1(null);

		return funcionariosCapacitacoes1;
	}

	public List<FuncionariosCapacitacoes> getFuncionariosCapacitacoes2() {
		return this.funcionariosCapacitacoes2;
	}

	public void setFuncionariosCapacitacoes2(List<FuncionariosCapacitacoes> funcionariosCapacitacoes2) {
		this.funcionariosCapacitacoes2 = funcionariosCapacitacoes2;
	}

	public FuncionariosCapacitacoes addFuncionariosCapacitacoes2(FuncionariosCapacitacoes funcionariosCapacitacoes2) {
		getFuncionariosCapacitacoes2().add(funcionariosCapacitacoes2);
		funcionariosCapacitacoes2.setPessoaOperadore2(this);

		return funcionariosCapacitacoes2;
	}

	public FuncionariosCapacitacoes removeFuncionariosCapacitacoes2(FuncionariosCapacitacoes funcionariosCapacitacoes2) {
		getFuncionariosCapacitacoes2().remove(funcionariosCapacitacoes2);
		funcionariosCapacitacoes2.setPessoaOperadore2(null);

		return funcionariosCapacitacoes2;
	}

	public List<FuncionariosFerias> getFuncionariosFerias1() {
		return this.funcionariosFerias1;
	}

	public void setFuncionariosFerias1(List<FuncionariosFerias> funcionariosFerias1) {
		this.funcionariosFerias1 = funcionariosFerias1;
	}

	public FuncionariosFerias addFuncionariosFerias1(FuncionariosFerias funcionariosFerias1) {
		getFuncionariosFerias1().add(funcionariosFerias1);
		funcionariosFerias1.setPessoaOperadore1(this);

		return funcionariosFerias1;
	}

	public FuncionariosFerias removeFuncionariosFerias1(FuncionariosFerias funcionariosFerias1) {
		getFuncionariosFerias1().remove(funcionariosFerias1);
		funcionariosFerias1.setPessoaOperadore1(null);

		return funcionariosFerias1;
	}

	public List<FuncionariosFerias> getFuncionariosFerias2() {
		return this.funcionariosFerias2;
	}

	public void setFuncionariosFerias2(List<FuncionariosFerias> funcionariosFerias2) {
		this.funcionariosFerias2 = funcionariosFerias2;
	}

	public FuncionariosFerias addFuncionariosFerias2(FuncionariosFerias funcionariosFerias2) {
		getFuncionariosFerias2().add(funcionariosFerias2);
		funcionariosFerias2.setPessoaOperadore2(this);

		return funcionariosFerias2;
	}

	public FuncionariosFerias removeFuncionariosFerias2(FuncionariosFerias funcionariosFerias2) {
		getFuncionariosFerias2().remove(funcionariosFerias2);
		funcionariosFerias2.setPessoaOperadore2(null);

		return funcionariosFerias2;
	}

	public List<FuncionariosFeriasPeriodos> getFuncionariosFeriasPeriodos1() {
		return this.funcionariosFeriasPeriodos1;
	}

	public void setFuncionariosFeriasPeriodos1(List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodos1) {
		this.funcionariosFeriasPeriodos1 = funcionariosFeriasPeriodos1;
	}

	public FuncionariosFeriasPeriodos addFuncionariosFeriasPeriodos1(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos1) {
		getFuncionariosFeriasPeriodos1().add(funcionariosFeriasPeriodos1);
		funcionariosFeriasPeriodos1.setPessoaOperadores1(this);

		return funcionariosFeriasPeriodos1;
	}

	public FuncionariosFeriasPeriodos removeFuncionariosFeriasPeriodos1(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos1) {
		getFuncionariosFeriasPeriodos1().remove(funcionariosFeriasPeriodos1);
		funcionariosFeriasPeriodos1.setPessoaOperadores1(null);

		return funcionariosFeriasPeriodos1;
	}

	public List<FuncionariosFeriasPeriodos> getFuncionariosFeriasPeriodos2() {
		return this.funcionariosFeriasPeriodos2;
	}

	public void setFuncionariosFeriasPeriodos2(List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodos2) {
		this.funcionariosFeriasPeriodos2 = funcionariosFeriasPeriodos2;
	}

	public FuncionariosFeriasPeriodos addFuncionariosFeriasPeriodos2(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos2) {
		getFuncionariosFeriasPeriodos2().add(funcionariosFeriasPeriodos2);
		funcionariosFeriasPeriodos2.setPessoaOperadores2(this);

		return funcionariosFeriasPeriodos2;
	}

	public FuncionariosFeriasPeriodos removeFuncionariosFeriasPeriodos2(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos2) {
		getFuncionariosFeriasPeriodos2().remove(funcionariosFeriasPeriodos2);
		funcionariosFeriasPeriodos2.setPessoaOperadores2(null);

		return funcionariosFeriasPeriodos2;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas1() {
		return this.funcionariosLicencas1;
	}

	public void setFuncionariosLicencas1(List<FuncionariosLicencas> funcionariosLicencas1) {
		this.funcionariosLicencas1 = funcionariosLicencas1;
	}

	public FuncionariosLicencas addFuncionariosLicencas1(FuncionariosLicencas funcionariosLicencas1) {
		getFuncionariosLicencas1().add(funcionariosLicencas1);
		funcionariosLicencas1.setPessoaOperadores1(this);

		return funcionariosLicencas1;
	}

	public FuncionariosLicencas removeFuncionariosLicencas1(FuncionariosLicencas funcionariosLicencas1) {
		getFuncionariosLicencas1().remove(funcionariosLicencas1);
		funcionariosLicencas1.setPessoaOperadores1(null);

		return funcionariosLicencas1;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas2() {
		return this.funcionariosLicencas2;
	}

	public void setFuncionariosLicencas2(List<FuncionariosLicencas> funcionariosLicencas2) {
		this.funcionariosLicencas2 = funcionariosLicencas2;
	}

	public FuncionariosLicencas addFuncionariosLicencas2(FuncionariosLicencas funcionariosLicencas2) {
		getFuncionariosLicencas2().add(funcionariosLicencas2);
		funcionariosLicencas2.setPessoaOperadores2(this);

		return funcionariosLicencas2;
	}

	public FuncionariosLicencas removeFuncionariosLicencas2(FuncionariosLicencas funcionariosLicencas2) {
		getFuncionariosLicencas2().remove(funcionariosLicencas2);
		funcionariosLicencas2.setPessoaOperadores2(null);

		return funcionariosLicencas2;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas3() {
		return this.funcionariosLicencas3;
	}

	public void setFuncionariosLicencas3(List<FuncionariosLicencas> funcionariosLicencas3) {
		this.funcionariosLicencas3 = funcionariosLicencas3;
	}

	public FuncionariosLicencas addFuncionariosLicencas3(FuncionariosLicencas funcionariosLicencas3) {
		getFuncionariosLicencas3().add(funcionariosLicencas3);
		funcionariosLicencas3.setPessoaOperadores3(this);

		return funcionariosLicencas3;
	}

	public FuncionariosLicencas removeFuncionariosLicencas3(FuncionariosLicencas funcionariosLicencas3) {
		getFuncionariosLicencas3().remove(funcionariosLicencas3);
		funcionariosLicencas3.setPessoaOperadores3(null);

		return funcionariosLicencas3;
	}

	public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiras1() {
		return this.histFuncionariosNiveisCarreiras1;
	}

	public void setHistFuncionariosNiveisCarreiras1(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras1) {
		this.histFuncionariosNiveisCarreiras1 = histFuncionariosNiveisCarreiras1;
	}

	public HistFuncionariosNiveisCarreira addHistFuncionariosNiveisCarreiras1(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreiras1) {
		getHistFuncionariosNiveisCarreiras1().add(histFuncionariosNiveisCarreiras1);
		histFuncionariosNiveisCarreiras1.setPessoaOperadores1(this);

		return histFuncionariosNiveisCarreiras1;
	}

	public HistFuncionariosNiveisCarreira removeHistFuncionariosNiveisCarreiras1(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreiras1) {
		getHistFuncionariosNiveisCarreiras1().remove(histFuncionariosNiveisCarreiras1);
		histFuncionariosNiveisCarreiras1.setPessoaOperadores1(null);

		return histFuncionariosNiveisCarreiras1;
	}

	public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiras2() {
		return this.histFuncionariosNiveisCarreiras2;
	}

	public void setHistFuncionariosNiveisCarreiras2(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras2) {
		this.histFuncionariosNiveisCarreiras2 = histFuncionariosNiveisCarreiras2;
	}

	public HistFuncionariosNiveisCarreira addHistFuncionariosNiveisCarreiras2(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreiras2) {
		getHistFuncionariosNiveisCarreiras2().add(histFuncionariosNiveisCarreiras2);
		histFuncionariosNiveisCarreiras2.setPessoaOperadores2(this);

		return histFuncionariosNiveisCarreiras2;
	}

	public HistFuncionariosNiveisCarreira removeHistFuncionariosNiveisCarreiras2(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreiras2) {
		getHistFuncionariosNiveisCarreiras2().remove(histFuncionariosNiveisCarreiras2);
		histFuncionariosNiveisCarreiras2.setPessoaOperadores2(null);

		return histFuncionariosNiveisCarreiras2;
	}

	/*public UsersOperador getUsersOperador() {
		return this.usersOperador;
	}

	public void setUsersOperador(UsersOperador usersOperador) {
		this.usersOperador = usersOperador;
	}*/
}