package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_funcionarios")
public class PessoaFuncionarios extends AbstractEntity<Long> {

	@Column(name = "matricula", length = 30)
    private String matricula;
    
	@Column(name = "dt_nomeacao")
    @Temporal(TemporalType.DATE)
	private Date dtNomeacao;
    
	@Column(name = "dt_posse")
    @Temporal(TemporalType.DATE)
    private Date dtPosse;
    
	@Column(name = "numero_de_ordem", length = 150)
    private String numeroDeOrdem;
    
	@Column(name = "numero_de_ponto", length = 150)
    private String numeroDePonto;
    
	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    
	@Column(name = "motivo_cadastro", length = 300)
    private String motivoCadastro;
    
	@Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    
	@Column(name = "motivo_cancelamento", length = 300)
    private String motivoCancelamento;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosSituacoes> histFuncionariosSituacoesList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<Autorizacoes> autorizacoesList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosList;
    
	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa idPessoaFk;
    
	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    
	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(matricula);
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

}
