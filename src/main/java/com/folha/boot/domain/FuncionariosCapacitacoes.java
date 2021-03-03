package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the funcionarios_capacitacoes database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios_capacitacoes")

public class FuncionariosCapacitacoes extends AbstractEntity<Long> {

	@Column(name = "descricao")
    private String descricao;
    
	@Column(name = "instituicao")
    private String instituicao;
    
	@Column(name = "carga_horaria")
    private Integer cargaHoraria;
    
	@Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    private Date dtInicial;
    
	@Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    private Date dtFinal;
    
	@Column(name = "observacoes")
    private String observacoes;
    
	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    
	@Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    
	@Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    
	@Lob
    @Column(name = "pdf_anexo")
    private byte[] pdfAnexo;
    
	@JoinColumn(name = "id_area_de_capacitacao_fk", referencedColumnName = "id")
    @ManyToOne
    private AreasDeCapacitacao idAreaDeCapacitacaoFk;
    
	@JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaFuncionarios idFuncionarioFk;
    
	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    
	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    
	@JoinColumn(name = "id_tipos_capacitacao_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposDeCapacitacao idTiposCapacitacaoFk;
	
	@Column(name = "nome_habilitacao_categoria", nullable = false, length = 30)
	private String nomeHabilitacaoCategoria;

	@Column(name = "descricao_habilitacao_categoria", length = 300)
	private String descricaoHabilitacaoCategoria;

	@OneToMany(mappedBy = "idHabilitacaoCategoriasFk")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList;

	public String getNomeHabilitacaoCategoria() {
		return nomeHabilitacaoCategoria;
	} 

	public void setNomeHabilitacaoCategoria(String nomeHabilitacaoCategoria) {
		this.nomeHabilitacaoCategoria = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeHabilitacaoCategoria);
	}

	public String getDescricaoHabilitacaoCategoria() {
		return descricaoHabilitacaoCategoria;
	}

	public void setDescricaoHabilitacaoCategoria(String descricaoHabilitacaoCategoria) {
		this.descricaoHabilitacaoCategoria = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoHabilitacaoCategoria);
	}

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoList() {
		return pessoaDocumentosHabilitacaoList;
	}

	public void setPessoaDocumentosHabilitacaoList(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList) {
		this.pessoaDocumentosHabilitacaoList = pessoaDocumentosHabilitacaoList;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public byte[] getPdfAnexo() {
		return pdfAnexo;
	}

	public void setPdfAnexo(byte[] pdfAnexo) {
		this.pdfAnexo = pdfAnexo;
	}

	public AreasDeCapacitacao getIdAreaDeCapacitacaoFk() {
		return idAreaDeCapacitacaoFk;
	}

	public void setIdAreaDeCapacitacaoFk(AreasDeCapacitacao idAreaDeCapacitacaoFk) {
		this.idAreaDeCapacitacaoFk = idAreaDeCapacitacaoFk;
	}

	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}

	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
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

	public TiposDeCapacitacao getIdTiposCapacitacaoFk() {
		return idTiposCapacitacaoFk;
	}

	public void setIdTiposCapacitacaoFk(TiposDeCapacitacao idTiposCapacitacaoFk) {
		this.idTiposCapacitacaoFk = idTiposCapacitacaoFk;
	}
	
}