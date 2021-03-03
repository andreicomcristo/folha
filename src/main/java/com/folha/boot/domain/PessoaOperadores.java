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
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosClasse> histFuncionariosClasseList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosClasse> histFuncionariosClasseList1;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosCargos> histFuncionariosCargosList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosCargos> histFuncionariosCargosList1;

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<PessoaFilhos> pessoaFilhosList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<PessoaFilhos> pessoaFilhosList1;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	@JoinColumn(name = "seq_privilegio", referencedColumnName = "id")
	@ManyToOne
	private Privilegios seqPrivilegio;

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<Unidades> unidadesList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<Unidades> unidadesList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistUnidadesRegime> histUnidadesRegimeList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistUnidadesRegime> histUnidadesRegimeList1;

	@OneToMany(mappedBy = "seqOperadorCadastro")
	private List<Pessoa> pessoaList;

	@OneToMany(mappedBy = "seqOperadorCancelamento")
	private List<Pessoa> pessoaList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiraList1;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCriacaoFk")
	private List<Autorizacoes> autorizacoesList;

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<PessoaBancos> pessoaBancosList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<PessoaBancos> pessoaBancosList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosVinculos> histFuncionariosVinculosList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosVinculos> histFuncionariosVinculosList1;

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaOperadores")
	private List<HistUnidadesDiretor> histUnidadesDiretorList;*/

	/*@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistUnidadesDiretor> histUnidadesDiretorList1;*/

	@OneToMany(mappedBy = "idOperadorCadastroFk")
	private List<PessoaFuncionarios> pessoaFuncionariosList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<PessoaFuncionarios> pessoaFuncionariosList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorCadastroFk")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;

	@OneToMany(mappedBy = "idOperadorCancelamentoFk")
	private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList1;

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

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList() {
		return histFuncionariosAutorizacaoList;
	}

	public void setHistFuncionariosAutorizacaoList(
			List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList) {
		this.histFuncionariosAutorizacaoList = histFuncionariosAutorizacaoList;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList1() {
		return histFuncionariosAutorizacaoList1;
	}

	public void setHistFuncionariosAutorizacaoList1(
			List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList1) {
		this.histFuncionariosAutorizacaoList1 = histFuncionariosAutorizacaoList1;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseList() {
		return histFuncionariosClasseList;
	}

	public void setHistFuncionariosClasseList(List<HistFuncionariosClasse> histFuncionariosClasseList) {
		this.histFuncionariosClasseList = histFuncionariosClasseList;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseList1() {
		return histFuncionariosClasseList1;
	}

	public void setHistFuncionariosClasseList1(List<HistFuncionariosClasse> histFuncionariosClasseList1) {
		this.histFuncionariosClasseList1 = histFuncionariosClasseList1;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList() {
		return histFuncionariosCargaHorariaList;
	}

	public void setHistFuncionariosCargaHorariaList(
			List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList) {
		this.histFuncionariosCargaHorariaList = histFuncionariosCargaHorariaList;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList1() {
		return histFuncionariosCargaHorariaList1;
	}

	public void setHistFuncionariosCargaHorariaList1(
			List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList1) {
		this.histFuncionariosCargaHorariaList1 = histFuncionariosCargaHorariaList1;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosList() {
		return histFuncionariosCargosList;
	}

	public void setHistFuncionariosCargosList(List<HistFuncionariosCargos> histFuncionariosCargosList) {
		this.histFuncionariosCargosList = histFuncionariosCargosList;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosList1() {
		return histFuncionariosCargosList1;
	}

	public void setHistFuncionariosCargosList1(List<HistFuncionariosCargos> histFuncionariosCargosList1) {
		this.histFuncionariosCargosList1 = histFuncionariosCargosList1;
	}

	public List<PessoaFilhos> getPessoaFilhosList() {
		return pessoaFilhosList;
	}

	public void setPessoaFilhosList(List<PessoaFilhos> pessoaFilhosList) {
		this.pessoaFilhosList = pessoaFilhosList;
	}

	public List<PessoaFilhos> getPessoaFilhosList1() {
		return pessoaFilhosList1;
	}

	public void setPessoaFilhosList1(List<PessoaFilhos> pessoaFilhosList1) {
		this.pessoaFilhosList1 = pessoaFilhosList1;
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

	public List<Unidades> getUnidadesList() {
		return unidadesList;
	}

	public void setUnidadesList(List<Unidades> unidadesList) {
		this.unidadesList = unidadesList;
	}

	public List<Unidades> getUnidadesList1() {
		return unidadesList1;
	}

	public void setUnidadesList1(List<Unidades> unidadesList1) {
		this.unidadesList1 = unidadesList1;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaList() {
		return histUnidadesNaturezaJuridicaList;
	}

	public void setHistUnidadesNaturezaJuridicaList(
			List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList) {
		this.histUnidadesNaturezaJuridicaList = histUnidadesNaturezaJuridicaList;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaList1() {
		return histUnidadesNaturezaJuridicaList1;
	}

	public void setHistUnidadesNaturezaJuridicaList1(
			List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaList1) {
		this.histUnidadesNaturezaJuridicaList1 = histUnidadesNaturezaJuridicaList1;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeList() {
		return histUnidadesRegimeList;
	}

	public void setHistUnidadesRegimeList(List<HistUnidadesRegime> histUnidadesRegimeList) {
		this.histUnidadesRegimeList = histUnidadesRegimeList;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeList1() {
		return histUnidadesRegimeList1;
	}

	public void setHistUnidadesRegimeList1(List<HistUnidadesRegime> histUnidadesRegimeList1) {
		this.histUnidadesRegimeList1 = histUnidadesRegimeList1;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

	public List<Pessoa> getPessoaList1() {
		return pessoaList1;
	}

	public void setPessoaList1(List<Pessoa> pessoaList1) {
		this.pessoaList1 = pessoaList1;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList() {
		return histFuncionariosCarreiraList;
	}

	public void setHistFuncionariosCarreiraList(List<HistFuncionariosCarreira> histFuncionariosCarreiraList) {
		this.histFuncionariosCarreiraList = histFuncionariosCarreiraList;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList1() {
		return histFuncionariosCarreiraList1;
	}

	public void setHistFuncionariosCarreiraList1(List<HistFuncionariosCarreira> histFuncionariosCarreiraList1) {
		this.histFuncionariosCarreiraList1 = histFuncionariosCarreiraList1;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList() {
		return histFuncionariosSituacoesList;
	}

	public void setHistFuncionariosSituacoesList(
			List<HistFuncionariosSituacoes> histFuncionariosSituacoesList) {
		this.histFuncionariosSituacoesList = histFuncionariosSituacoesList;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesList1() {
		return histFuncionariosSituacoesList1;
	}

	public void setHistFuncionariosSituacoesList1(
			List<HistFuncionariosSituacoes> histFuncionariosSituacoesList1) {
		this.histFuncionariosSituacoesList1 = histFuncionariosSituacoesList1;
	}

	public List<Autorizacoes> getAutorizacoesList() {
		return autorizacoesList;
	}

	public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
		this.autorizacoesList = autorizacoesList;
	}

	public List<PessoaBancos> getPessoaBancosList() {
		return pessoaBancosList;
	}

	public void setPessoaBancosList(List<PessoaBancos> pessoaBancosList) {
		this.pessoaBancosList = pessoaBancosList;
	}

	public List<PessoaBancos> getPessoaBancosList1() {
		return pessoaBancosList1;
	}

	public void setPessoaBancosList1(List<PessoaBancos> pessoaBancosList1) {
		this.pessoaBancosList1 = pessoaBancosList1;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
		return histFuncionariosVinculosList;
	}

	public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
		this.histFuncionariosVinculosList = histFuncionariosVinculosList;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList1() {
		return histFuncionariosVinculosList1;
	}

	public void setHistFuncionariosVinculosList1(List<HistFuncionariosVinculos> histFuncionariosVinculosList1) {
		this.histFuncionariosVinculosList1 = histFuncionariosVinculosList1;
	}

	/*public List<HistUnidadesDiretor> getHistUnidadesDiretorList() {
		return histUnidadesDiretorList;
	}*/

	/*public void setHistUnidadesDiretorList(List<HistUnidadesDiretor> histUnidadesDiretorList) {
		this.histUnidadesDiretorList = histUnidadesDiretorList;
	}*/

	/*public List<HistUnidadesDiretor> getHistUnidadesDiretorList1() {
		return histUnidadesDiretorList1;
	}*/

	/*public void setHistUnidadesDiretorList1(List<HistUnidadesDiretor> histUnidadesDiretorList1) {
		this.histUnidadesDiretorList1 = histUnidadesDiretorList1;
	}*/

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList1() {
		return pessoaFuncionariosList1;
	}

	public void setPessoaFuncionariosList1(List<PessoaFuncionarios> pessoaFuncionariosList1) {
		this.pessoaFuncionariosList1 = pessoaFuncionariosList1;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList() {
		return histFuncionariosUnidadeLotacaoList;
	}

	public void setHistFuncionariosUnidadeLotacaoList(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList) {
		this.histFuncionariosUnidadeLotacaoList = histFuncionariosUnidadeLotacaoList;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList1() {
		return histFuncionariosUnidadeLotacaoList1;
	}

	public void setHistFuncionariosUnidadeLotacaoList1(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList1) {
		this.histFuncionariosUnidadeLotacaoList1 = histFuncionariosUnidadeLotacaoList1;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList() {
		return histFuncionariosUnidadeAtuacaoList;
	}

	public void setHistFuncionariosUnidadeAtuacaoList(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList) {
		this.histFuncionariosUnidadeAtuacaoList = histFuncionariosUnidadeAtuacaoList;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList1() {
		return histFuncionariosUnidadeAtuacaoList1;
	}

	public void setHistFuncionariosUnidadeAtuacaoList1(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList1) {
		this.histFuncionariosUnidadeAtuacaoList1 = histFuncionariosUnidadeAtuacaoList1;
	}

    
}