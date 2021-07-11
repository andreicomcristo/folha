package com.folha.boot.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "dias_licenca_maternidade")
public class DiasLicencaMaternidade extends AbstractEntity<Long> {

	@Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
	
	@Column(name = "dias")
    private Integer dias;
	
	@OneToMany(mappedBy = "idDiasFk")
    private List<FaixasValoresLicencaMaternidade> faixasValoresLicencaMaternidadeList;


	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public List<FaixasValoresLicencaMaternidade> getFaixasValoresLicencaMaternidadeList() {
		return faixasValoresLicencaMaternidadeList;
	}

	public void setFaixasValoresLicencaMaternidadeList(
			List<FaixasValoresLicencaMaternidade> faixasValoresLicencaMaternidadeList) {
		this.faixasValoresLicencaMaternidadeList = faixasValoresLicencaMaternidadeList;
	}
	
		
	
	    
    
}
