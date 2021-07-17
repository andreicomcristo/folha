package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")

@Entity
@Table(name = "rubrica_pensao")
public class RubricaPensao extends AbstractEntity<Long> {
	
	
	@Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
	@Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
	
	@Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
	@Column(name = "valor")
    private Double valor;
    @Column(name = "percentagem")
    private Double percentagem;
    @Column(name = "nome_beneficiario")
    private String nomeBeneficiario;
    @Column(name = "cpf_beneficiario")
    private String cpfBeneficiario;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "dv_agencia")
    private String dvAgencia;
    @Column(name = "conta")
    private String conta;
    @Column(name = "dv_conta")
    private String dvConta;
    @Column(name = "operacao_variacao")
    private String operacaoVariacao;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_banco_fk", referencedColumnName = "id")
    @ManyToOne
    private Bancos idBancoFk;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoaFk;
    @OneToMany(mappedBy = "idRubricaPensaoFk")
    private List<RubricaPensaoObs> rubricaPensaoObsList;
    @OneToMany(mappedBy = "idRubricaPensaoFk")
    private List<RubricaPensaoDependente> rubricaPensaoDependenteList;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    
    @JoinColumn(name = "id_incidencia_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaPensaoIncidencia idIncidenciaFk;
    @JoinColumn(name = "id_efetuar_calculo_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idEfetuarCalculoSimNaoFk;
    
    public RubricaPensao() {
    }

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}

	
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeBeneficiario);
	}

	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}

	public void setCpfBeneficiario(String cpfBeneficiario) {
		this.cpfBeneficiario = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cpfBeneficiario);
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(agencia);
	}

	public String getDvAgencia() {
		return dvAgencia;
	}

	public void setDvAgencia(String dvAgencia) {
		this.dvAgencia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dvAgencia);
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(conta);
	}

	public String getDvConta() {
		return dvConta;
	}

	public void setDvConta(String dvConta) {
		this.dvConta = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(dvConta);
	}

	public String getOperacaoVariacao() {
		return operacaoVariacao;
	}

	public void setOperacaoVariacao(String operacaoVariacao) {
		this.operacaoVariacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(operacaoVariacao);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
	}

	public Bancos getIdBancoFk() {
		return idBancoFk;
	}

	public void setIdBancoFk(Bancos idBancoFk) {
		this.idBancoFk = idBancoFk;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public List<RubricaPensaoObs> getRubricaPensaoObsList() {
		return rubricaPensaoObsList;
	}

	public void setRubricaPensaoObsList(List<RubricaPensaoObs> rubricaPensaoObsList) {
		this.rubricaPensaoObsList = rubricaPensaoObsList;
	}

	
	public List<RubricaPensaoDependente> getRubricaPensaoDependenteList() {
		return rubricaPensaoDependenteList;
	}

	public void setRubricaPensaoDependenteList(List<RubricaPensaoDependente> rubricaPensaoDependenteList) {
		this.rubricaPensaoDependenteList = rubricaPensaoDependenteList;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

	public RubricaPensaoIncidencia getIdIncidenciaFk() {
		return idIncidenciaFk;
	}

	public void setIdIncidenciaFk(RubricaPensaoIncidencia idIncidenciaFk) {
		this.idIncidenciaFk = idIncidenciaFk;
	}

	public SimNao getIdEfetuarCalculoSimNaoFk() {
		return idEfetuarCalculoSimNaoFk;
	}

	public void setIdEfetuarCalculoSimNaoFk(SimNao idEfetuarCalculoSimNaoFk) {
		this.idEfetuarCalculoSimNaoFk = idEfetuarCalculoSimNaoFk;
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}
	
	
}
