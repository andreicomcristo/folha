package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name = "escala_cod_diferenciado")
public class EscalaCodDiferenciado extends AbstractEntity<Long> {

	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @JoinColumn(name = "id_codigo_diferenciado_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodigoDiferenciadoFk;
    @JoinColumn(name = "id_escala_fk", referencedColumnName = "id")
    @ManyToOne
    private Escala idEscalaFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;

    public EscalaCodDiferenciado() {
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

	public CodigoDiferenciado getIdCodigoDiferenciadoFk() {
		return idCodigoDiferenciadoFk;
	}

	public void setIdCodigoDiferenciadoFk(CodigoDiferenciado idCodigoDiferenciadoFk) {
		this.idCodigoDiferenciadoFk = idCodigoDiferenciadoFk;
	}

	public Escala getIdEscalaFk() {
		return idEscalaFk;
	}

	public void setIdEscalaFk(Escala idEscalaFk) {
		this.idEscalaFk = idEscalaFk;
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
    
    
	
}
