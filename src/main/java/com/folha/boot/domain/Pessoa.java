package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractEntity<Long> {

	@NotBlank(message="CPF obrigatório")
	@Column(name = "cpf", nullable = false, length = 20)
	private String cpf;

	@NotBlank(message="Nome obrigatório")
	@Basic(optional = false)
	@Column(name = "nome", nullable = false, length = 300)
	private String nome;
	
	@Column(name = "nome_social", length = 300)
	private String nomeSocial;

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

	@JoinColumn(name = "id_cidade_natal_fk", referencedColumnName = "id")
	@ManyToOne
	private Cidades idCidadeNatalFk;

	@JoinColumn(name = "id_escolaridade_fk", referencedColumnName = "id")
	@ManyToOne
	private Escolaridades idEscolaridadeFk;

	@JoinColumn(name = "id_estado_civil_fk", referencedColumnName = "id")
	@ManyToOne
	private EstadosCivis idEstadoCivilFk;

	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCadastroFk;

	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;

	@JoinColumn(name = "id_sexo_declarado_fk", referencedColumnName = "id")
	@ManyToOne
	private Sexos idSexoDeclaradoFk;

	@JoinColumn(name = "id_sexo_fk", referencedColumnName = "id")
	@ManyToOne
	private Sexos idSexoFk;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
    private List<PessoaFilhos> pessoaFilhosList;
      
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;*/
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaFilhos> pessoaFilhosCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhoList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosReservista> pessoaDocumentosReservistaList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosRg> pessoaDocumentosRgList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaFotos> pessoaFotosList;

	@OneToMany(mappedBy = "idPessoaFk")
	private List<PessoaDocumentos> pessoaDocumentosList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaOperadores> pessoaOperadoresList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<Enderecos> enderecosList;

	@OneToMany(mappedBy = "idPessoaFk")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosCtps> pessoaDocumentosCtpsList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaBancos> pessoaBancosList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaFuncionarios> pessoaFuncionariosList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoaFk")
	private List<PessoaDocumentosTitulo> pessoaDocumentosTituloList;
	
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
	
	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeSocial);
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
		this.email = email;
	}

	public String getEmailSaude() {
		return emailSaude;
	}

	public void setEmailSaude(String emailSaude) {
		this.emailSaude = emailSaude;
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

	public List<PessoaFilhos> getPessoaFilhosList() {
		return pessoaFilhosList;
	}

	public void setPessoaFilhosList(List<PessoaFilhos> pessoaFilhosList) {
		this.pessoaFilhosList = pessoaFilhosList;
	}

	public Cidades getIdCidadeNatalFk() {
		return idCidadeNatalFk;
	}

	public void setIdCidadeNatalFk(Cidades idCidadeNatalFk) {
		this.idCidadeNatalFk = idCidadeNatalFk;
	}
	
	public Escolaridades getIdEscolaridadeFk() {
		return idEscolaridadeFk;
	}

	public void setIdEscolaridadeFk(Escolaridades idEscolaridadeFk) {
		this.idEscolaridadeFk = idEscolaridadeFk;
	}

	public EstadosCivis getIdEstadoCivilFk() {
		return idEstadoCivilFk;
	}

	public void setIdEstadoCivilFk(EstadosCivis idEstadoCivilFk) {
		this.idEstadoCivilFk = idEstadoCivilFk;
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

	public Sexos getIdSexoDeclaradoFk() {
		return idSexoDeclaradoFk;
	}

	public void setIdSexoDeclaradoFk(Sexos idSexoDeclaradoFk) {
		this.idSexoDeclaradoFk = idSexoDeclaradoFk;
	}

	public Sexos getIdSexoFk() {
		return idSexoFk;
	}

	public void setIdSexoFk(Sexos idSexoFk) {
		this.idSexoFk = idSexoFk;
	}
	
	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhoList() {
		return pessoaDocumentosConselhoList;
	}

	public void setPessoaDocumentosConselhoList(List<PessoaDocumentosConselho> pessoaDocumentosConselhoList) {
		this.pessoaDocumentosConselhoList = pessoaDocumentosConselhoList;
	}

	public List<PessoaDocumentosReservista> getPessoaDocumentosReservistaList() {
		return pessoaDocumentosReservistaList;
	}

	public void setPessoaDocumentosReservistaList(List<PessoaDocumentosReservista> pessoaDocumentosReservistaList) {
		this.pessoaDocumentosReservistaList = pessoaDocumentosReservistaList;
	}
	
	public List<PessoaDocumentosRg> getPessoaDocumentosRgList() {
		return pessoaDocumentosRgList;
	}

	public void setPessoaDocumentosRgList(List<PessoaDocumentosRg> pessoaDocumentosRgList) {
		this.pessoaDocumentosRgList = pessoaDocumentosRgList;
	}

	public List<PessoaFotos> getPessoaFotosList() {
		return pessoaFotosList;
	}

	public void setPessoaFotosList(List<PessoaFotos> pessoaFotosList) {
		this.pessoaFotosList = pessoaFotosList;
	}

	public List<PessoaDocumentos> getPessoaDocumentosList() {
		return pessoaDocumentosList;
	}

	public void setPessoaDocumentosList(List<PessoaDocumentos> pessoaDocumentosList) {
		this.pessoaDocumentosList = pessoaDocumentosList;
	}

	public List<PessoaOperadores> getPessoaOperadoresList() {
		return pessoaOperadoresList;
	}

	public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
		this.pessoaOperadoresList = pessoaOperadoresList;
	}

	public List<Enderecos> getEnderecosList() {
		return enderecosList;
	}

	public void setEnderecosList(List<Enderecos> enderecosList) {
		this.enderecosList = enderecosList;
	}

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaoList() {
		return pessoaDocumentosHabilitacaoList;
	}

	public void setPessoaDocumentosHabilitacaoList(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaoList) {
		this.pessoaDocumentosHabilitacaoList = pessoaDocumentosHabilitacaoList;
	}

	public List<PessoaDocumentosCtps> getPessoaDocumentosCtpsList() {
		return pessoaDocumentosCtpsList;
	}

	public void setPessoaDocumentosCtpsList(List<PessoaDocumentosCtps> pessoaDocumentosCtpsList) {
		this.pessoaDocumentosCtpsList = pessoaDocumentosCtpsList;
	}

	public List<PessoaBancos> getPessoaBancosList() {
		return pessoaBancosList;
	}

	public void setPessoaBancosList(List<PessoaBancos> pessoaBancosList) {
		this.pessoaBancosList = pessoaBancosList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public List<PessoaDocumentosTitulo> getPessoaDocumentosTituloList() {
		return pessoaDocumentosTituloList;
	}

	public void setPessoaDocumentosTituloList(List<PessoaDocumentosTitulo> pessoaDocumentosTituloList) {
		this.pessoaDocumentosTituloList = pessoaDocumentosTituloList;
	}

}
