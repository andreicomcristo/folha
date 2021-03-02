package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractEntity<Long> {

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	private String email;

	@Column(name="email_saude")
	private String emailSaude;

	private String fone1;

	private String fone2;

	private String fone3;

	@Column(name="moivo_cancelamento")
	private String moivoCancelamento;

	private String nome;

	@Column(name="nome_mae")
	private String nomeMae;

	@Column(name="nome_pai")
	private String nomePai;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="pessoa")
	private List<Enderecos> enderecos;

	//bi-directional many-to-one association to HistUnidadesDiretor
	@OneToMany(mappedBy="pessoa")
	private List<HistUnidadesDiretor> histUnidadesDiretors;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="seq_cidade_natal")
	private Cidades cidade;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="seq_endereco")
	private Enderecos endereco;

	//bi-directional many-to-one association to Escolaridade
	@ManyToOne
	@JoinColumn(name="seq_escolaridade")
	private Escolaridades escolaridade;

	//bi-directional many-to-one association to EstadosCivi
	@ManyToOne
	@JoinColumn(name="seq_estado_civil")
	private EstadosCivis estadosCivi;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="seq_operador_cadastro")
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="seq_operador_cancelamento")
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to Sexo
	@ManyToOne
	@JoinColumn(name="seq_sexo_declarado")
	private Sexos sexo1;

	//bi-directional many-to-one association to Sexo
	@ManyToOne
	@JoinColumn(name="seq_sexo")
	private Sexos sexo2;

	//bi-directional many-to-one association to PessoaBanco
	@OneToMany(mappedBy="pessoa")
	private List<PessoaBancos> pessoaBancos;

	//bi-directional many-to-one association to PessoaDocumento
	@OneToMany(mappedBy="pessoa1")
	private List<PessoaDocumentos> pessoaDocumentos1;

	//bi-directional many-to-one association to PessoaDocumento
	@OneToMany(mappedBy="pessoa2")
	private List<PessoaDocumentos> pessoaDocumentos2;

	//bi-directional many-to-one association to PessoaDocumentosConselho
	@OneToMany(mappedBy="pessoa")
	private List<PessoaDocumentosConselho> pessoaDocumentosConselhos;

	//bi-directional many-to-one association to PessoaDocumentosCtp
	@OneToMany(mappedBy="pessoa")
	private List<PessoaDocumentosCtps> pessoaDocumentosCtps;

	//bi-directional many-to-one association to PessoaDocumentosHabilitacao
	@OneToMany(mappedBy="pessoa")
	private List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaos;

	//bi-directional many-to-one association to PessoaDocumentosReservista
	@OneToMany(mappedBy="pessoa")
	private List<PessoaDocumentosReservista> pessoaDocumentosReservistas;

	//bi-directional many-to-one association to PessoaDocumentosTitulo
	@OneToMany(mappedBy="pessoa")
	private List<PessoaDocumentosTitulo> pessoaDocumentosTitulos;

	//bi-directional many-to-one association to PessoaFilho
	@OneToMany(mappedBy="pessoa")
	private List<PessoaFilhos> pessoaFilhos;

	//bi-directional many-to-one association to PessoaFoto
	@OneToMany(mappedBy="pessoa")
	private List<PessoaFotos> pessoaFotos;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="pessoa")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	//bi-directional many-to-one association to PessoaOperadore
	@OneToMany(mappedBy="pessoa")
	private List<PessoaOperadores> pessoaOperadores;

	public Pessoa() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
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

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getFone3() {
		return fone3;
	}

	public void setFone3(String fone3) {
		this.fone3 = fone3;
	}

	public String getMoivoCancelamento() {
		return moivoCancelamento;
	}

	public void setMoivoCancelamento(String moivoCancelamento) {
		this.moivoCancelamento = moivoCancelamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}

	public List<HistUnidadesDiretor> getHistUnidadesDiretors() {
		return histUnidadesDiretors;
	}

	public void setHistUnidadesDiretors(List<HistUnidadesDiretor> histUnidadesDiretors) {
		this.histUnidadesDiretors = histUnidadesDiretors;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	public Escolaridades getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridades escolaridade) {
		this.escolaridade = escolaridade;
	}

	public EstadosCivis getEstadosCivi() {
		return estadosCivi;
	}

	public void setEstadosCivi(EstadosCivis estadosCivi) {
		this.estadosCivi = estadosCivi;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return pessoaOperadore1;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadore1) {
		this.pessoaOperadore1 = pessoaOperadore1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return pessoaOperadore2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadore2) {
		this.pessoaOperadore2 = pessoaOperadore2;
	}

	public Sexos getSexo1() {
		return sexo1;
	}

	public void setSexo1(Sexos sexo1) {
		this.sexo1 = sexo1;
	}

	public Sexos getSexo2() {
		return sexo2;
	}

	public void setSexo2(Sexos sexo2) {
		this.sexo2 = sexo2;
	}

	public List<PessoaBancos> getPessoaBancos() {
		return pessoaBancos;
	}

	public void setPessoaBancos(List<PessoaBancos> pessoaBancos) {
		this.pessoaBancos = pessoaBancos;
	}

	public List<PessoaDocumentos> getPessoaDocumentos1() {
		return pessoaDocumentos1;
	}

	public void setPessoaDocumentos1(List<PessoaDocumentos> pessoaDocumentos1) {
		this.pessoaDocumentos1 = pessoaDocumentos1;
	}

	public List<PessoaDocumentos> getPessoaDocumentos2() {
		return pessoaDocumentos2;
	}

	public void setPessoaDocumentos2(List<PessoaDocumentos> pessoaDocumentos2) {
		this.pessoaDocumentos2 = pessoaDocumentos2;
	}

	public List<PessoaDocumentosConselho> getPessoaDocumentosConselhos() {
		return pessoaDocumentosConselhos;
	}

	public void setPessoaDocumentosConselhos(List<PessoaDocumentosConselho> pessoaDocumentosConselhos) {
		this.pessoaDocumentosConselhos = pessoaDocumentosConselhos;
	}

	public List<PessoaDocumentosCtps> getPessoaDocumentosCtps() {
		return pessoaDocumentosCtps;
	}

	public void setPessoaDocumentosCtps(List<PessoaDocumentosCtps> pessoaDocumentosCtps) {
		this.pessoaDocumentosCtps = pessoaDocumentosCtps;
	}

	public List<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacaos() {
		return pessoaDocumentosHabilitacaos;
	}

	public void setPessoaDocumentosHabilitacaos(List<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacaos) {
		this.pessoaDocumentosHabilitacaos = pessoaDocumentosHabilitacaos;
	}

	public List<PessoaDocumentosReservista> getPessoaDocumentosReservistas() {
		return pessoaDocumentosReservistas;
	}

	public void setPessoaDocumentosReservistas(List<PessoaDocumentosReservista> pessoaDocumentosReservistas) {
		this.pessoaDocumentosReservistas = pessoaDocumentosReservistas;
	}

	public List<PessoaDocumentosTitulo> getPessoaDocumentosTitulos() {
		return pessoaDocumentosTitulos;
	}

	public void setPessoaDocumentosTitulos(List<PessoaDocumentosTitulo> pessoaDocumentosTitulos) {
		this.pessoaDocumentosTitulos = pessoaDocumentosTitulos;
	}

	public List<PessoaFilhos> getPessoaFilhos() {
		return pessoaFilhos;
	}

	public void setPessoaFilhos(List<PessoaFilhos> pessoaFilhos) {
		this.pessoaFilhos = pessoaFilhos;
	}

	public List<PessoaFotos> getPessoaFotos() {
		return pessoaFotos;
	}

	public void setPessoaFotos(List<PessoaFotos> pessoaFotos) {
		this.pessoaFotos = pessoaFotos;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public List<PessoaOperadores> getPessoaOperadores() {
		return pessoaOperadores;
	}

	public void setPessoaOperadores(List<PessoaOperadores> pessoaOperadores) {
		this.pessoaOperadores = pessoaOperadores;
	}

	public Enderecos addEndereco(Enderecos endereco) {
		getEnderecos().add(endereco);
		endereco.setPessoa(this);

		return endereco;
	}

	public Enderecos removeEndereco(Enderecos endereco) {
		getEnderecos().remove(endereco);
		endereco.setPessoa(null);

		return endereco;
	}

	public HistUnidadesDiretor addHistUnidadesDiretor(HistUnidadesDiretor histUnidadesDiretor) {
		getHistUnidadesDiretors().add(histUnidadesDiretor);
		histUnidadesDiretor.setPessoa(this);

		return histUnidadesDiretor;
	}

	public HistUnidadesDiretor removeHistUnidadesDiretor(HistUnidadesDiretor histUnidadesDiretor) {
		getHistUnidadesDiretors().remove(histUnidadesDiretor);
		histUnidadesDiretor.setPessoa(null);

		return histUnidadesDiretor;
	}

	public PessoaBancos addPessoaBanco(PessoaBancos pessoaBanco) {
		getPessoaBancos().add(pessoaBanco);
		pessoaBanco.setPessoa(this);

		return pessoaBanco;
	}

	public PessoaBancos removePessoaBanco(PessoaBancos pessoaBanco) {
		getPessoaBancos().remove(pessoaBanco);
		pessoaBanco.setPessoa(null);

		return pessoaBanco;
	}

	public PessoaDocumentos addPessoaDocumentos1(PessoaDocumentos pessoaDocumentos1) {
		getPessoaDocumentos1().add(pessoaDocumentos1);
		pessoaDocumentos1.setPessoa1(this);

		return pessoaDocumentos1;
	}

	public PessoaDocumentos removePessoaDocumentos1(PessoaDocumentos pessoaDocumentos1) {
		getPessoaDocumentos1().remove(pessoaDocumentos1);
		pessoaDocumentos1.setPessoa1(null);

		return pessoaDocumentos1;
	}

	public PessoaDocumentos addPessoaDocumentos2(PessoaDocumentos pessoaDocumentos2) {
		getPessoaDocumentos2().add(pessoaDocumentos2);
		pessoaDocumentos2.setPessoa2(this);

		return pessoaDocumentos2;
	}

	public PessoaDocumentos removePessoaDocumentos2(PessoaDocumentos pessoaDocumentos2) {
		getPessoaDocumentos2().remove(pessoaDocumentos2);
		pessoaDocumentos2.setPessoa2(null);

		return pessoaDocumentos2;
	}

	public PessoaDocumentosConselho addPessoaDocumentosConselho(PessoaDocumentosConselho pessoaDocumentosConselho) {
		getPessoaDocumentosConselhos().add(pessoaDocumentosConselho);
		pessoaDocumentosConselho.setPessoa(this);

		return pessoaDocumentosConselho;
	}

	public PessoaDocumentosConselho removePessoaDocumentosConselho(PessoaDocumentosConselho pessoaDocumentosConselho) {
		getPessoaDocumentosConselhos().remove(pessoaDocumentosConselho);
		pessoaDocumentosConselho.setPessoa(null);

		return pessoaDocumentosConselho;
	}

	public PessoaDocumentosCtps addPessoaDocumentosCtp(PessoaDocumentosCtps pessoaDocumentosCtp) {
		getPessoaDocumentosCtps().add(pessoaDocumentosCtp);
		pessoaDocumentosCtp.setPessoa(this);

		return pessoaDocumentosCtp;
	}

	public PessoaDocumentosCtps removePessoaDocumentosCtp(PessoaDocumentosCtps pessoaDocumentosCtp) {
		getPessoaDocumentosCtps().remove(pessoaDocumentosCtp);
		pessoaDocumentosCtp.setPessoa(null);

		return pessoaDocumentosCtp;
	}

	public PessoaDocumentosHabilitacao addPessoaDocumentosHabilitacao(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		getPessoaDocumentosHabilitacaos().add(pessoaDocumentosHabilitacao);
		pessoaDocumentosHabilitacao.setPessoa(this);

		return pessoaDocumentosHabilitacao;
	}

	public PessoaDocumentosHabilitacao removePessoaDocumentosHabilitacao(PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao) {
		getPessoaDocumentosHabilitacaos().remove(pessoaDocumentosHabilitacao);
		pessoaDocumentosHabilitacao.setPessoa(null);

		return pessoaDocumentosHabilitacao;
	}

	public PessoaDocumentosReservista addPessoaDocumentosReservista(PessoaDocumentosReservista pessoaDocumentosReservista) {
		getPessoaDocumentosReservistas().add(pessoaDocumentosReservista);
		pessoaDocumentosReservista.setPessoa(this);

		return pessoaDocumentosReservista;
	}

	public PessoaDocumentosReservista removePessoaDocumentosReservista(PessoaDocumentosReservista pessoaDocumentosReservista) {
		getPessoaDocumentosReservistas().remove(pessoaDocumentosReservista);
		pessoaDocumentosReservista.setPessoa(null);

		return pessoaDocumentosReservista;
	}

	public PessoaDocumentosTitulo addPessoaDocumentosTitulo(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		getPessoaDocumentosTitulos().add(pessoaDocumentosTitulo);
		pessoaDocumentosTitulo.setPessoa(this);

		return pessoaDocumentosTitulo;
	}

	public PessoaDocumentosTitulo removePessoaDocumentosTitulo(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		getPessoaDocumentosTitulos().remove(pessoaDocumentosTitulo);
		pessoaDocumentosTitulo.setPessoa(null);

		return pessoaDocumentosTitulo;
	}

	public PessoaFilhos addPessoaFilho(PessoaFilhos pessoaFilho) {
		getPessoaFilhos().add(pessoaFilho);
		pessoaFilho.setPessoa(this);

		return pessoaFilho;
	}

	public PessoaFilhos removePessoaFilho(PessoaFilhos pessoaFilho) {
		getPessoaFilhos().remove(pessoaFilho);
		pessoaFilho.setPessoa(null);

		return pessoaFilho;
	}

	public PessoaFotos addPessoaFoto(PessoaFotos pessoaFoto) {
		getPessoaFotos().add(pessoaFoto);
		pessoaFoto.setPessoa(this);

		return pessoaFoto;
	}

	public PessoaFotos removePessoaFoto(PessoaFotos pessoaFoto) {
		getPessoaFotos().remove(pessoaFoto);
		pessoaFoto.setPessoa(null);

		return pessoaFoto;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setPessoa(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setPessoa(null);

		return pessoaFuncionario;
	}

	public PessoaOperadores addPessoaOperadore(PessoaOperadores pessoaOperadore) {
		getPessoaOperadores().add(pessoaOperadore);
		pessoaOperadore.setPessoa(this);

		return pessoaOperadore;
	}

	public PessoaOperadores removePessoaOperadore(PessoaOperadores pessoaOperadore) {
		getPessoaOperadores().remove(pessoaOperadore);
		pessoaOperadore.setPessoa(null);

		return pessoaOperadore;
	}

}
