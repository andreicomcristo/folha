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
    private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosClasse> histFuncionariosClasseCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCargos> histFuncionariosCargosCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<Autorizacoes> autorizacoesCollection;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioFk")
    private List<HistFuncionariosVinculos> histFuncionariosVinculosCollection;
    
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
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection;

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

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoCollection() {
		return histFuncionariosAutorizacaoCollection;
	}

	public void setHistFuncionariosAutorizacaoCollection(
			List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoCollection) {
		this.histFuncionariosAutorizacaoCollection = histFuncionariosAutorizacaoCollection;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseCollection() {
		return histFuncionariosClasseCollection;
	}

	public void setHistFuncionariosClasseCollection(List<HistFuncionariosClasse> histFuncionariosClasseCollection) {
		this.histFuncionariosClasseCollection = histFuncionariosClasseCollection;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection() {
		return histFuncionariosCargaHorariaCollection;
	}

	public void setHistFuncionariosCargaHorariaCollection(
			List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection) {
		this.histFuncionariosCargaHorariaCollection = histFuncionariosCargaHorariaCollection;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargosCollection() {
		return histFuncionariosCargosCollection;
	}

	public void setHistFuncionariosCargosCollection(List<HistFuncionariosCargos> histFuncionariosCargosCollection) {
		this.histFuncionariosCargosCollection = histFuncionariosCargosCollection;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection() {
		return histFuncionariosCarreiraCollection;
	}

	public void setHistFuncionariosCarreiraCollection(List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection) {
		this.histFuncionariosCarreiraCollection = histFuncionariosCarreiraCollection;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoesCollection() {
		return histFuncionariosSituacoesCollection;
	}

	public void setHistFuncionariosSituacoesCollection(
			List<HistFuncionariosSituacoes> histFuncionariosSituacoesCollection) {
		this.histFuncionariosSituacoesCollection = histFuncionariosSituacoesCollection;
	}

	public List<Autorizacoes> getAutorizacoesCollection() {
		return autorizacoesCollection;
	}

	public void setAutorizacoesCollection(List<Autorizacoes> autorizacoesCollection) {
		this.autorizacoesCollection = autorizacoesCollection;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosCollection() {
		return histFuncionariosVinculosCollection;
	}

	public void setHistFuncionariosVinculosCollection(List<HistFuncionariosVinculos> histFuncionariosVinculosCollection) {
		this.histFuncionariosVinculosCollection = histFuncionariosVinculosCollection;
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

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoCollection() {
		return histFuncionariosUnidadeAtuacaoCollection;
	}

	public void setHistFuncionariosUnidadeAtuacaoCollection(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoCollection) {
		this.histFuncionariosUnidadeAtuacaoCollection = histFuncionariosUnidadeAtuacaoCollection;
	}

}
