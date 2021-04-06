package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "codigo_diferenciado")
public class CodigoDiferenciado extends AbstractEntity<Long> {

	@Column(name = "nome_codigo_diferenciado")
	private String nomeCodigoDiferenciado;
	
	@Column(name = "descricao_codigo_diferenciado")
	private String descricaoCodigoDiferenciado;
	
	@JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
	
	@OneToMany(mappedBy = "idCodigoDiferenciadoFk")
	private List<Escala> escalaList;
	
	@OneToMany(mappedBy = "idCodigoDiferenciadoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
	
	@OneToMany(mappedBy = "idCodDiferenciadoFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
	

	public String getNomeCodigoDiferenciado() {
		return nomeCodigoDiferenciado;
	}

	public void setNomeCodigoDiferenciado(String nomeCodigoDiferenciado) {
		this.nomeCodigoDiferenciado = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCodigoDiferenciado);
	}

	public String getDescricaoCodigoDiferenciado() {
		return descricaoCodigoDiferenciado;
	}

	public void setDescricaoCodigoDiferenciado(String descricaoCodigoDiferenciado) {
		this.descricaoCodigoDiferenciado = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCodigoDiferenciado);
	}

	public List<FaixasValoresParametrosCalculoFolhasExtras> getFaixasValoresParametrosCalculoFolhasExtrasList() {
		return faixasValoresParametrosCalculoFolhasExtrasList;
	}

	public void setFaixasValoresParametrosCalculoFolhasExtrasList(
			List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList) {
		this.faixasValoresParametrosCalculoFolhasExtrasList = faixasValoresParametrosCalculoFolhasExtrasList;
	}

	public List<Escala> getEscalaList() {
		return escalaList;
	}

	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}

	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}

	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}

	
}
