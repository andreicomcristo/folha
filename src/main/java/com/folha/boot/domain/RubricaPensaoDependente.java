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
@Table(name = "rubrica_pensao_dependente") 
public class RubricaPensaoDependente extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "certidao_nascimento")
    private String certidaoNascimento;
    @Column(name = "dt_certidao")
    @Temporal(TemporalType.DATE)
    private Date dtCertidao;
    @Column(name = "rg")
    private String rg;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_rubrica_pensao_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaPensao idRubricaPensaoFk;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCertidaoNascimento() {
		return certidaoNascimento;
	}
	public void setCertidaoNascimento(String certidaoNascimento) {
		this.certidaoNascimento = certidaoNascimento;
	}
	public Date getDtCertidao() {
		return dtCertidao;
	}
	public void setDtCertidao(Date dtCertidao) {
		this.dtCertidao = dtCertidao;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public RubricaPensao getIdRubricaPensaoFk() {
		return idRubricaPensaoFk;
	}
	public void setIdRubricaPensaoFk(RubricaPensao idRubricaPensaoFk) {
		this.idRubricaPensaoFk = idRubricaPensaoFk;
	}
    
}
