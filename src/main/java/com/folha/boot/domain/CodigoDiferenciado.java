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
	
	@Column(name = "variacao")
    private String variacao;
	
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
    
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    
    @JoinColumn(name = "id_tipo_bruto_liquido_fk", referencedColumnName = "id")
    @ManyToOne
    private TipoBrutoLiquido idTipoBrutoLiquidoFk;
	
	
	@OneToMany(mappedBy = "idCodDiferenciadoFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
	
	@OneToMany(mappedBy = "idCodDiferenciadoFk")
    private List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	
	@OneToMany(mappedBy = "idCodDiferenciadoFk")
    private List<PessoaCodDiferenciado> pessoaCodDiferenciadoList;
	
	@OneToMany(mappedBy = "idCodigoDiferenciadoFk")
    private List<EscalaCodDiferenciado> escalaCodDiferenciadoList;

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

	

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
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

	public List<PessoaCodDiferenciado> getPessoaCodDiferenciadoList() {
		return pessoaCodDiferenciadoList;
	}

	public void setPessoaCodDiferenciadoList(List<PessoaCodDiferenciado> pessoaCodDiferenciadoList) {
		this.pessoaCodDiferenciadoList = pessoaCodDiferenciadoList;
	}

	public List<EscalaCodDiferenciado> getEscalaCodDiferenciadoList() {
		return escalaCodDiferenciadoList;
	}

	public void setEscalaCodDiferenciadoList(List<EscalaCodDiferenciado> escalaCodDiferenciadoList) {
		this.escalaCodDiferenciadoList = escalaCodDiferenciadoList;
	}

	public Fonte getIdFonteFk() {
		return idFonteFk;
	}

	public void setIdFonteFk(Fonte idFonteFk) {
		this.idFonteFk = idFonteFk;
	}

	public TipoBrutoLiquido getIdTipoBrutoLiquidoFk() {
		return idTipoBrutoLiquidoFk;
	}

	public void setIdTipoBrutoLiquidoFk(TipoBrutoLiquido idTipoBrutoLiquidoFk) {
		this.idTipoBrutoLiquidoFk = idTipoBrutoLiquidoFk;
	}

	public String getVariacao() {
		return variacao;
	}

	public void setVariacao(String variacao) {
		this.variacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(variacao);
	}

	public List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> getFaixasValoresParametrosCalculoFolhasExtrasIndividualList() {
		return faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	}

	public void setFaixasValoresParametrosCalculoFolhasExtrasIndividualList(
			List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> faixasValoresParametrosCalculoFolhasExtrasIndividualList) {
		this.faixasValoresParametrosCalculoFolhasExtrasIndividualList = faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	}
	
	
	
	
}
