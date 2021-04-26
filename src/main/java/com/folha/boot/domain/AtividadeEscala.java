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
@Table(name = "atividade_escala")
public class AtividadeEscala extends AbstractEntity<Long> {

	@Column(name = "nome_atividade")
	private String nomeAtividade;
	
	@Column(name = "descricao_atividade")
	private String descricaoAtividade;
	
	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;
	
	
	@OneToMany(mappedBy = "idAtividadeFk")
	private List<CoordenacaoEscala> coordenacaoEscalaList;
	
	@JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeAtividade);
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoAtividade);
	}

	public List<CoordenacaoEscala> getCoordenacaoEscalaList() {
		return coordenacaoEscalaList;
	}

	public void setCoordenacaoEscalaList(List<CoordenacaoEscala> coordenacaoEscalaList) {
		this.coordenacaoEscalaList = coordenacaoEscalaList;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}

	

	
	
}
