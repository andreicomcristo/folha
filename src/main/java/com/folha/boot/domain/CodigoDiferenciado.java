package com.folha.boot.domain;

import java.util.Date;
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
	
	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
	
	@JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
	
	@JoinColumn(name = "id_necessita_atribuicao_rh_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idNecessitaAtribuicaoRhFk;
    @JoinColumn(name = "id_necessita_atribuicao_sede_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idNecessitaAtribuicaoSedeFk;
	
	@OneToMany(mappedBy = "idCodigoDiferenciadoFk")
	private List<Escala> escalaList;
	
	@OneToMany(mappedBy = "idCodigoDiferenciadoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
	
	@OneToMany(mappedBy = "idCodDiferenciadoFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
	
	@OneToMany(mappedBy = "idCodigoDiferenciadoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
	
	
	

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

	public List<EscalaAlteracoes> getEscalaAlteracoesList() {
		return escalaAlteracoesList;
	}

	public void setEscalaAlteracoesList(List<EscalaAlteracoes> escalaAlteracoesList) {
		this.escalaAlteracoesList = escalaAlteracoesList;
	}

	public SimNao getIdNecessitaAtribuicaoRhFk() {
		return idNecessitaAtribuicaoRhFk;
	}

	public void setIdNecessitaAtribuicaoRhFk(SimNao idNecessitaAtribuicaoRhFk) {
		this.idNecessitaAtribuicaoRhFk = idNecessitaAtribuicaoRhFk;
	}

	public SimNao getIdNecessitaAtribuicaoSedeFk() {
		return idNecessitaAtribuicaoSedeFk;
	}

	public void setIdNecessitaAtribuicaoSedeFk(SimNao idNecessitaAtribuicaoSedeFk) {
		this.idNecessitaAtribuicaoSedeFk = idNecessitaAtribuicaoSedeFk;
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
