package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity 

@Table(name="funcionarios_licencas_cid")
public class FuncionariosLicencasCid extends AbstractEntity<Long> {
	
	@JoinColumn(name = "id_cid_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cids idCidFk;
    @JoinColumn(name = "id_funcionarios_licencas_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FuncionariosLicencas idFuncionariosLicencasFk;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    
	public Cids getIdCidFk() {
		return idCidFk;
	}
	public void setIdCidFk(Cids idCidFk) {
		this.idCidFk = idCidFk;
	}
	public FuncionariosLicencas getIdFuncionariosLicencasFk() {
		return idFuncionariosLicencasFk;
	}
	public void setIdFuncionariosLicencasFk(FuncionariosLicencas idFuncionariosLicencasFk) {
		this.idFuncionariosLicencasFk = idFuncionariosLicencasFk;
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
    
    
    
}