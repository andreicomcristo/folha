package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidades")
public class Unidades extends AbstractEntity<Long> {

	@Basic(optional = false)
    @Column(name = "nome_fantasia")
	private String nomeFantasia;
    @Column(name = "nome_empresarial")
    private String nomeEmpresarial;
    @Column(name = "cnes")
    private String cnes;
    @Column(name = "fone1")
    private String fone1;
    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;
    @Column(name = "endereco_numero")
    private String enderecoNumero;
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Column(name = "endereco_cep")
    private String enderecoCep;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "motivo_cadastro")
    private String motivoCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idUnidadeLotacaoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList1;
    @JoinColumn(name = "id_endereco_cidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Cidades idEnderecoCidadeFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_tipo_logradouro_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposLogradouro idTipoLogradouroFk;
    @JoinColumn(name = "id_natureza_juridica_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesNaturezaJuridica idNaturezaJuridicaFk;
    @JoinColumn(name = "id_unidades_regime_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesRegime idUnidadesRegimeFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesRegime> histUnidadesRegimeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList;
    @OneToMany(mappedBy = "idUnidadeLancamentoFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<Autorizacoes> autorizacoesList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<LocalidadeEscala> localidadeEscalaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList;
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<CodigoDiferenciado> codigoDiferenciadoList;

    @OneToMany(mappedBy = "idUnidadeFk")
    private List<Perfil> perfilList;
    
    @OneToMany(mappedBy = "idUnidadeFk")
    private List<AtividadeEscala> atividadeEscalaList;
    
    @OneToMany(mappedBy = "idUnidadeLotacaoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList1;
    
	public List<CodigoDiferenciado> getCodigoDiferenciadoList() {
		return codigoDiferenciadoList;
	}

	public void setCodigoDiferenciadoList(List<CodigoDiferenciado> codigoDiferenciadoList) {
		this.codigoDiferenciadoList = codigoDiferenciadoList;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}

	public UnidadesRegime getIdUnidadesRegimeFk() {
		return idUnidadesRegimeFk;
	}

	public void setIdUnidadesRegimeFk(UnidadesRegime idUnidadesRegimeFk) {
		this.idUnidadesRegimeFk = idUnidadesRegimeFk;
	}

	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencasList1() {
		return funcionariosLicencasList1;
	}

	public void setFuncionariosLicencasList1(List<FuncionariosLicencas> funcionariosLicencasList1) {
		this.funcionariosLicencasList1 = funcionariosLicencasList1;
	}

	public List<AcessoOperadoresUnidades> getAcessoOperadoresUnidadesList() {
		return acessoOperadoresUnidadesList;
	}

	public void setAcessoOperadoresUnidadesList(List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList) {
		this.acessoOperadoresUnidadesList = acessoOperadoresUnidadesList;
	}

	public List<FuncionariosFerias> getFuncionariosFeriasList() {
		return funcionariosFeriasList;
	}

	public void setFuncionariosFeriasList(List<FuncionariosFerias> funcionariosFeriasList) {
		this.funcionariosFeriasList = funcionariosFeriasList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeFantasia);
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEmpresarial);
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cnes);
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(fone1);
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoLogradouro);
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoNumero);
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoComplemento);
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoBairro);
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoCep);
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getMotivoCadastro() {
		return motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCadastro);
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
		this.motivoCancelamento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCancelamento);
	}

	public Cidades getIdEnderecoCidadeFk() {
		return idEnderecoCidadeFk;
	}

	public void setIdEnderecoCidadeFk(Cidades idEnderecoCidadeFk) {
		this.idEnderecoCidadeFk = idEnderecoCidadeFk;
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

	public TiposLogradouro getIdTipoLogradouroFk() {
		return idTipoLogradouroFk;
	}

	public void setIdTipoLogradouroFk(TiposLogradouro idTipoLogradouroFk) {
		this.idTipoLogradouroFk = idTipoLogradouroFk;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeList() {
		return histUnidadesRegimeList;
	}

	public void setHistUnidadesRegimeList(List<HistUnidadesRegime> histUnidadesRegimeList) {
		this.histUnidadesRegimeList = histUnidadesRegimeList;
	}

	public List<Autorizacoes> getAutorizacoesList() {
		return autorizacoesList;
	}

	public void setAutorizacoesList(List<Autorizacoes> autorizacoesList) {
		this.autorizacoesList = autorizacoesList;
	}

	public List<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacaoList() {
		return histFuncionariosUnidadeLotacaoList;
	}

	public void setHistFuncionariosUnidadeLotacaoList(
			List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList) {
		this.histFuncionariosUnidadeLotacaoList = histFuncionariosUnidadeLotacaoList;
	}

	public List<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacaoList() {
		return histFuncionariosUnidadeAtuacaoList;
	}

	public void setHistFuncionariosUnidadeAtuacaoList(
			List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList) {
		this.histFuncionariosUnidadeAtuacaoList = histFuncionariosUnidadeAtuacaoList;
	}

	public UnidadesNaturezaJuridica getIdNaturezaJuridicaFk() {
		return idNaturezaJuridicaFk;
	}

	public void setIdNaturezaJuridicaFk(UnidadesNaturezaJuridica idNaturezaJuridicaFk) {
		this.idNaturezaJuridicaFk = idNaturezaJuridicaFk;
	}

	public List<HistUnidadesDiretor> getHistUnidadesDiretorList() {
		return histUnidadesDiretorList;
	}

	public void setHistUnidadesDiretorList(List<HistUnidadesDiretor> histUnidadesDiretorList) {
		this.histUnidadesDiretorList = histUnidadesDiretorList;
	}

	public List<LocalidadeEscala> getLocalidadeEscalaList() {
		return localidadeEscalaList;
	}

	public void setLocalidadeEscalaList(List<LocalidadeEscala> localidadeEscalaList) {
		this.localidadeEscalaList = localidadeEscalaList;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}

	public List<AtividadeEscala> getAtividadeEscalaList() {
		return atividadeEscalaList;
	}

	public void setAtividadeEscalaList(List<AtividadeEscala> atividadeEscalaList) {
		this.atividadeEscalaList = atividadeEscalaList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList1() {
		return pessoaFuncionariosList1;
	}

	public void setPessoaFuncionariosList1(List<PessoaFuncionarios> pessoaFuncionariosList1) {
		this.pessoaFuncionariosList1 = pessoaFuncionariosList1;
	}

	
	
}
