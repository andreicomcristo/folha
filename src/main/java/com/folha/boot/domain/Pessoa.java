package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractEntity<Long> {

	@Column(name = "cpf", nullable = false, length = 20)
	private String cpf;

	@Basic(optional = false)
	@Column(name = "nome", nullable = false, length = 300)
	private String nome;

	@Column(name = "fone1", length = 30)
	private String fone1;

	@Column(name = "fone2", length = 30)
	private String fone2;

	@Column(name = "fone3", length = 30)
	private String fone3;

	@Column(name = "email", length = 150)
	private String email;

	@Column(name = "email_saude", length = 150)
	private String emailSaude;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;

	@Column(name = "nome_pai", length = 300)
	private String nomePai;

	@Column(name = "nome_mae", length = 300)
	private String nomeMae;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;

	@Column(name = "moivo_cancelamento", length = 300)
	private String moivoCancelamento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaFilhos> pessoaFilhosCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosReservista> pessoaDocumentosReservistaCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaFotos> pessoaFotosCollection;

	@OneToMany(mappedBy = "idPessoaFk")
	private List<PessoaDocumentos> pessoaDocumentosCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaOperadores> pessoaOperadoresCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<Enderecos> enderecosCollection;

	@OneToMany(mappedBy = "idPessoaFk")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection;

	@JoinColumn(name = "seq_cidade_natal", referencedColumnName = "id")
	@ManyToOne
	private Cidades seqCidadeNatal;

	@JoinColumn(name = "seq_endereco", referencedColumnName = "id")
	@ManyToOne
	private Enderecos seqEndereco;

	@JoinColumn(name = "seq_escolaridade", referencedColumnName = "id")
	@ManyToOne
	private Escolaridades seqEscolaridade;

	@JoinColumn(name = "seq_estado_civil", referencedColumnName = "id")
	@ManyToOne
	private EstadosCivis seqEstadoCivil;

	@JoinColumn(name = "seq_operador_cadastro", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores seqOperadorCadastro;

	@JoinColumn(name = "seq_operador_cancelamento", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores seqOperadorCancelamento;

	@JoinColumn(name = "seq_sexo_declarado", referencedColumnName = "id")
	@ManyToOne
	private Sexos seqSexoDeclarado;

	@JoinColumn(name = "seq_sexo", referencedColumnName = "id")
	@ManyToOne
	private Sexos seqSexo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosCtps> pessoaDocumentosCtpsCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaBancos> pessoaBancosCollection;

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<HistUnidadesDiretor> histUnidadesDiretorCollection;*/

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaFuncionarios> pessoaFuncionariosCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf =UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(fone1);
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(fone2);
	}

	public String getFone3() {
		return fone3;
	}

	public void setFone3(String fone3) {
		this.fone3 = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(fone3);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(email);
	}

	public String getEmailSaude() {
		return emailSaude;
	}

	public void setEmailSaude(String emailSaude) {
		this.emailSaude = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(emailSaude);
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePai);
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeMae);
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

	public String getMoivoCancelamento() {
		return moivoCancelamento;
	}

	public void setMoivoCancelamento(String moivoCancelamento) {
		this.moivoCancelamento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(moivoCancelamento);
	}

	public List<PessoaFilhos> getPessoaFilhosCollection() {
		return pessoaFilhosCollection;
	}

	public void setPessoaFilhosCollection(List<PessoaFilhos> pessoaFilhosCollection) {
		this.pessoaFilhosCollection = pessoaFilhosCollection;
	}

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoCollection() {
		return pessoaDocumentosConselhoCollection;
	}

	public void setPessoaDocumentosConselhoCollection(List<PessoaDocumentosConselho> pessoaDocumentosConselhoCollection) {
		this.pessoaDocumentosConselhoCollection = pessoaDocumentosConselhoCollection;
	}

	public List<PessoaDocumentosReservista> getPessoaDocumentosReservistaCollection() {
		return pessoaDocumentosReservistaCollection;
	}

	public void setPessoaDocumentosReservistaCollection(
			List<PessoaDocumentosReservista> pessoaDocumentosReservistaCollection) {
		this.pessoaDocumentosReservistaCollection = pessoaDocumentosReservistaCollection;
	}

	public List<PessoaFotos> getPessoaFotosCollection() {
		return pessoaFotosCollection;
	}

	public void setPessoaFotosCollection(List<PessoaFotos> pessoaFotosCollection) {
		this.pessoaFotosCollection = pessoaFotosCollection;
	}

	public List<PessoaDocumentos> getPessoaDocumentosCollection() {
		return pessoaDocumentosCollection;
	}

	public void setPessoaDocumentosCollection(List<PessoaDocumentos> pessoaDocumentosCollection) {
		this.pessoaDocumentosCollection = pessoaDocumentosCollection;
	}

	public List<PessoaOperadores> getPessoaOperadoresCollection() {
		return pessoaOperadoresCollection;
	}

	public void setPessoaOperadoresCollection(List<PessoaOperadores> pessoaOperadoresCollection) {
		this.pessoaOperadoresCollection = pessoaOperadoresCollection;
	}

	public List<Enderecos> getEnderecosCollection() {
		return enderecosCollection;
	}

	public void setEnderecosCollection(List<Enderecos> enderecosCollection) {
		this.enderecosCollection = enderecosCollection;
	}

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoCollection() {
		return pessoaDocumentosHabilitacaoCollection;
	}

	public void setPessoaDocumentosHabilitacaoCollection(
			List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoCollection) {
		this.pessoaDocumentosHabilitacaoCollection = pessoaDocumentosHabilitacaoCollection;
	}

	public Cidades getSeqCidadeNatal() {
		return seqCidadeNatal;
	}

	public void setSeqCidadeNatal(Cidades seqCidadeNatal) {
		this.seqCidadeNatal = seqCidadeNatal;
	}

	public Enderecos getSeqEndereco() {
		return seqEndereco;
	}

	public void setSeqEndereco(Enderecos seqEndereco) {
		this.seqEndereco = seqEndereco;
	}

	public Escolaridades getSeqEscolaridade() {
		return seqEscolaridade;
	}

	public void setSeqEscolaridade(Escolaridades seqEscolaridade) {
		this.seqEscolaridade = seqEscolaridade;
	}

	public EstadosCivis getSeqEstadoCivil() {
		return seqEstadoCivil;
	}

	public void setSeqEstadoCivil(EstadosCivis seqEstadoCivil) {
		this.seqEstadoCivil = seqEstadoCivil;
	}

	public PessoaOperadores getSeqOperadorCadastro() {
		return seqOperadorCadastro;
	}

	public void setSeqOperadorCadastro(PessoaOperadores seqOperadorCadastro) {
		this.seqOperadorCadastro = seqOperadorCadastro;
	}

	public PessoaOperadores getSeqOperadorCancelamento() {
		return seqOperadorCancelamento;
	}

	public void setSeqOperadorCancelamento(PessoaOperadores seqOperadorCancelamento) {
		this.seqOperadorCancelamento = seqOperadorCancelamento;
	}

	public Sexos getSeqSexoDeclarado() {
		return seqSexoDeclarado;
	}

	public void setSeqSexoDeclarado(Sexos seqSexoDeclarado) {
		this.seqSexoDeclarado = seqSexoDeclarado;
	}

	public Sexos getSeqSexo() {
		return seqSexo;
	}

	public void setSeqSexo(Sexos seqSexo) {
		this.seqSexo = seqSexo;
	}

	public List<PessoaDocumentosCtps> getPessoaDocumentosCtpsCollection() {
		return pessoaDocumentosCtpsCollection;
	}

	public void setPessoaDocumentosCtpsCollection(List<PessoaDocumentosCtps> pessoaDocumentosCtpsCollection) {
		this.pessoaDocumentosCtpsCollection = pessoaDocumentosCtpsCollection;
	}

	public List<PessoaBancos> getPessoaBancosCollection() {
		return pessoaBancosCollection;
	}

	public void setPessoaBancosCollection(List<PessoaBancos> pessoaBancosCollection) {
		this.pessoaBancosCollection = pessoaBancosCollection;
	}

	/*public List<HistUnidadesDiretor> getHistUnidadesDiretorCollection() {
		return histUnidadesDiretorCollection;
	}*/

	/*public void setHistUnidadesDiretorCollection(List<HistUnidadesDiretor> histUnidadesDiretorCollection) {
		this.histUnidadesDiretorCollection = histUnidadesDiretorCollection;
	}*/

	public List<PessoaFuncionarios> getPessoaFuncionariosCollection() {
		return pessoaFuncionariosCollection;
	}

	public void setPessoaFuncionariosCollection(List<PessoaFuncionarios> pessoaFuncionariosCollection) {
		this.pessoaFuncionariosCollection = pessoaFuncionariosCollection;
	}

	public List<PessoaDocumentosTitulo> getPessoaDocumentosTituloCollection() {
		return pessoaDocumentosTituloCollection;
	}

	public void setPessoaDocumentosTituloCollection(List<PessoaDocumentosTitulo> pessoaDocumentosTituloCollection) {
		this.pessoaDocumentosTituloCollection = pessoaDocumentosTituloCollection;
	}

}
