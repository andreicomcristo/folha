package com.folha.boot.domain;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_operadores")
public class PessoaOperadores extends AbstractEntity<Long> {

	@Column(name = "senha", nullable = false, length = 300)
	private String senha;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	@Column(name = "id_operador_cadastro_fk")
	private BigInteger idOperadorCadastroFk;

	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;

	@Column(name = "id_operador_cancelamento_fk")
	private BigInteger idOperadorCancelamentoFk;

	@Column(name = "motivo_cancelamento", length = 500)
	private String motivoCancelamento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosClasse> histFuncionariosClasseCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosClasse> histFuncionariosClasseCollection1;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosCargos> histFuncionariosCargosCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosCargos> histFuncionariosCargosCollection1;

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<PessoaFilhos> pessoaFilhosCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<PessoaFilhos> pessoaFilhosCollection1;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	@JoinColumn(name = "seq_privilegio", referencedColumnName = "id")
	@ManyToOne
	private Privilegios seqPrivilegio;

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<Unidades> unidadesCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<Unidades> unidadesCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistUnidadesRegime> histUnidadesRegimeCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistUnidadesRegime> histUnidadesRegimeCollection1;

	@OneToMany(mappedBy = "seqOperadorCadastro")
	private List<Pessoa> pessoaCollection;

	@OneToMany(mappedBy = "seqOperadorCancelamento")
	private List<Pessoa> pessoaCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCriacaoFk")
	private List<Autorizacoes> autorizacoesCollection;

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<PessoaBancos> pessoaBancosCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<PessoaBancos> pessoaBancosCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosVinculos> histFuncionariosVinculosCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosVinculos> histFuncionariosVinculosCollection1;

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaOperadores")
	private List<HistUnidadesDiretor> histUnidadesDiretorCollection;*/

	/*@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistUnidadesDiretor> histUnidadesDiretorCollection1;*/

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<PessoaFuncionarios> pessoaFuncionariosCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<PessoaFuncionarios> pessoaFuncionariosCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(senha);
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public BigInteger getIdOperadorCadastroFk() {
		return idOperadorCadastroFk;
	}

	public void setIdOperadorCadastroFk(BigInteger idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public BigInteger getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(BigInteger idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCancelamento);
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoCollection() {
		return histFuncionariosAutorizacaoCollection;
	}

	public void setHistFuncionariosAutorizacaoCollection(
			List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection) {
		this.histFuncionariosAutorizacaoCollection = histFuncionariosAutorizacaoCollection;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoCollection1() {
		return histFuncionariosAutorizacaoCollection1;
	}

	public void setHistFuncionariosAutorizacaoCollection1(
			List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection1) {
		this.histFuncionariosAutorizacaoCollection1 = histFuncionariosAutorizacaoCollection1;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseCollection() {
		return histFuncionariosClasseCollection;
	}

	public void setHistFuncionariosClasseCollection(List<HistFuncionariosClasse> histFuncionariosClasseCollection) {
		this.histFuncionariosClasseCollection = histFuncionariosClasseCollection;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseCollection1() {
		return histFuncionariosClasseCollection1;
	}

	public void setHistFuncionariosClasseCollection1(List<HistFuncionariosClasse> histFuncionariosClasseCollection1) {
		this.histFuncionariosClasseCollection1 = histFuncionariosClasseCollection1;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection() {
		return histFuncionariosCargaHorariaCollection;
	}

	public void setHistFuncionariosCargaHorariaCollection(
			List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection) {
		this.histFuncionariosCargaHorariaCollection = histFuncionariosCargaHorariaCollection;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection1() {
		return histFuncionariosCargaHorariaCollection1;
	}

	public void setHistFuncionariosCargaHorariaCollection1(
			List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection1) {
		this.histFuncionariosCargaHorariaCollection1 = histFuncionariosCargaHorariaCollection1;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosCollection() {
		return histFuncionariosCargosCollection;
	}

	public void setHistFuncionariosCargosCollection(List<HistFuncionariosCargos> histFuncionariosCargosCollection) {
		this.histFuncionariosCargosCollection = histFuncionariosCargosCollection;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosCollection1() {
		return histFuncionariosCargosCollection1;
	}

	public void setHistFuncionariosCargosCollection1(List<HistFuncionariosCargos> histFuncionariosCargosCollection1) {
		this.histFuncionariosCargosCollection1 = histFuncionariosCargosCollection1;
	}

	public List<PessoaFilhos> getPessoaFilhosCollection() {
		return pessoaFilhosCollection;
	}

	public void setPessoaFilhosCollection(List<PessoaFilhos> pessoaFilhosCollection) {
		this.pessoaFilhosCollection = pessoaFilhosCollection;
	}

	public List<PessoaFilhos> getPessoaFilhosCollection1() {
		return pessoaFilhosCollection1;
	}

	public void setPessoaFilhosCollection1(List<PessoaFilhos> pessoaFilhosCollection1) {
		this.pessoaFilhosCollection1 = pessoaFilhosCollection1;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public Privilegios getSeqPrivilegio() {
		return seqPrivilegio;
	}

	public void setSeqPrivilegio(Privilegios seqPrivilegio) {
		this.seqPrivilegio = seqPrivilegio;
	}

	public List<Unidades> getUnidadesCollection() {
		return unidadesCollection;
	}

	public void setUnidadesCollection(List<Unidades> unidadesCollection) {
		this.unidadesCollection = unidadesCollection;
	}

	public List<Unidades> getUnidadesCollection1() {
		return unidadesCollection1;
	}

	public void setUnidadesCollection1(List<Unidades> unidadesCollection1) {
		this.unidadesCollection1 = unidadesCollection1;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaCollection() {
		return histUnidadesNaturezaJuridicaCollection;
	}

	public void setHistUnidadesNaturezaJuridicaCollection(
			List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection) {
		this.histUnidadesNaturezaJuridicaCollection = histUnidadesNaturezaJuridicaCollection;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaCollection1() {
		return histUnidadesNaturezaJuridicaCollection1;
	}

	public void setHistUnidadesNaturezaJuridicaCollection1(
			List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection1) {
		this.histUnidadesNaturezaJuridicaCollection1 = histUnidadesNaturezaJuridicaCollection1;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeCollection() {
		return histUnidadesRegimeCollection;
	}

	public void setHistUnidadesRegimeCollection(List<HistUnidadesRegime> histUnidadesRegimeCollection) {
		this.histUnidadesRegimeCollection = histUnidadesRegimeCollection;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeCollection1() {
		return histUnidadesRegimeCollection1;
	}

	public void setHistUnidadesRegimeCollection1(List<HistUnidadesRegime> histUnidadesRegimeCollection1) {
		this.histUnidadesRegimeCollection1 = histUnidadesRegimeCollection1;
	}

	public List<Pessoa> getPessoaCollection() {
		return pessoaCollection;
	}

	public void setPessoaCollection(List<Pessoa> pessoaCollection) {
		this.pessoaCollection = pessoaCollection;
	}

	public List<Pessoa> getPessoaCollection1() {
		return pessoaCollection1;
	}

	public void setPessoaCollection1(List<Pessoa> pessoaCollection1) {
		this.pessoaCollection1 = pessoaCollection1;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection() {
		return histFuncionariosCarreiraCollection;
	}

	public void setHistFuncionariosCarreiraCollection(List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection) {
		this.histFuncionariosCarreiraCollection = histFuncionariosCarreiraCollection;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection1() {
		return histFuncionariosCarreiraCollection1;
	}

	public void setHistFuncionariosCarreiraCollection1(List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection1) {
		this.histFuncionariosCarreiraCollection1 = histFuncionariosCarreiraCollection1;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection() {
		return histFuncionariosSituacoesCollection;
	}

	public void setHistFuncionariosSituacoesCollection(
			List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection) {
		this.histFuncionariosSituacoesCollection = histFuncionariosSituacoesCollection;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection1() {
		return histFuncionariosSituacoesCollection1;
	}

	public void setHistFuncionariosSituacoesCollection1(
			List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection1) {
		this.histFuncionariosSituacoesCollection1 = histFuncionariosSituacoesCollection1;
	}

	public List<Autorizacoes> getAutorizacoesCollection() {
		return autorizacoesCollection;
	}

	public void setAutorizacoesCollection(List<Autorizacoes> autorizacoesCollection) {
		this.autorizacoesCollection = autorizacoesCollection;
	}

	public List<PessoaBancos> getPessoaBancosCollection() {
		return pessoaBancosCollection;
	}

	public void setPessoaBancosCollection(List<PessoaBancos> pessoaBancosCollection) {
		this.pessoaBancosCollection = pessoaBancosCollection;
	}

	public List<PessoaBancos> getPessoaBancosCollection1() {
		return pessoaBancosCollection1;
	}

	public void setPessoaBancosCollection1(List<PessoaBancos> pessoaBancosCollection1) {
		this.pessoaBancosCollection1 = pessoaBancosCollection1;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection() {
		return histFuncionariosVinculosCollection;
	}

	public void setHistFuncionariosVinculosCollection(List<HistFuncionariosVinculos> histFuncionariosVinculosCollection) {
		this.histFuncionariosVinculosCollection = histFuncionariosVinculosCollection;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection1() {
		return histFuncionariosVinculosCollection1;
	}

	public void setHistFuncionariosVinculosCollection1(List<HistFuncionariosVinculos> histFuncionariosVinculosCollection1) {
		this.histFuncionariosVinculosCollection1 = histFuncionariosVinculosCollection1;
	}

	/*public List<HistUnidadesDiretor> getHistUnidadesDiretorCollection() {
		return histUnidadesDiretorCollection;
	}*/

	/*public void setHistUnidadesDiretorCollection(List<HistUnidadesDiretor> histUnidadesDiretorCollection) {
		this.histUnidadesDiretorCollection = histUnidadesDiretorCollection;
	}*/

	/*public List<HistUnidadesDiretor> getHistUnidadesDiretorCollection1() {
		return histUnidadesDiretorCollection1;
	}*/

	/*public void setHistUnidadesDiretorCollection1(List<HistUnidadesDiretor> histUnidadesDiretorCollection1) {
		this.histUnidadesDiretorCollection1 = histUnidadesDiretorCollection1;
	}*/

	public List<PessoaFuncionarios> getPessoaFuncionariosCollection() {
		return pessoaFuncionariosCollection;
	}

	public void setPessoaFuncionariosCollection(List<PessoaFuncionarios> pessoaFuncionariosCollection) {
		this.pessoaFuncionariosCollection = pessoaFuncionariosCollection;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosCollection1() {
		return pessoaFuncionariosCollection1;
	}

	public void setPessoaFuncionariosCollection1(List<PessoaFuncionarios> pessoaFuncionariosCollection1) {
		this.pessoaFuncionariosCollection1 = pessoaFuncionariosCollection1;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoCollection() {
		return histFuncionariosUnidadeLotacaoCollection;
	}

	public void setHistFuncionariosUnidadeLotacaoCollection(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection) {
		this.histFuncionariosUnidadeLotacaoCollection = histFuncionariosUnidadeLotacaoCollection;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoCollection1() {
		return histFuncionariosUnidadeLotacaoCollection1;
	}

	public void setHistFuncionariosUnidadeLotacaoCollection1(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoCollection1) {
		this.histFuncionariosUnidadeLotacaoCollection1 = histFuncionariosUnidadeLotacaoCollection1;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoCollection() {
		return histFuncionariosUnidadeAtuacaoCollection;
	}

	public void setHistFuncionariosUnidadeAtuacaoCollection(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection) {
		this.histFuncionariosUnidadeAtuacaoCollection = histFuncionariosUnidadeAtuacaoCollection;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoCollection1() {
		return histFuncionariosUnidadeAtuacaoCollection1;
	}

	public void setHistFuncionariosUnidadeAtuacaoCollection1(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection1) {
		this.histFuncionariosUnidadeAtuacaoCollection1 = histFuncionariosUnidadeAtuacaoCollection1;
	}

}
