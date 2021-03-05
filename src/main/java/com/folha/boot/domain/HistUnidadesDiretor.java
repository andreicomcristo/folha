package com.folha.boot.domain;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "hist_unidades_diretor")
public class HistUnidadesDiretor extends AbstractEntity<Long> {

	@Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "nome_empresarial")
    private String nomeEmpresarial;
    @Column(name = "cnes")
    private String cnes;
    @Column(name = "id_natureza_juridica_fk")
    private BigInteger idNaturezaJuridicaFk;
    @Column(name = "id_endereco_unidade_fk")
    private BigInteger idEnderecoUnidadeFk;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesRegime> histUnidadesRegimeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<AcessoOperadoresUnidades> acessoOperadoresUnidadesList;
    @OneToMany(mappedBy = "idUnidadeLancamentoFk")
    private List<FuncionariosFerias> funcionariosFeriasList;
    @OneToMany(mappedBy = "idUnidadeDeSaudeFk")
    private List<Autorizacoes> autorizacoesList;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidades")
    private List<HistUnidadesDiretor> histUnidadesDiretorList;*/
    @OneToMany(mappedBy = "idUnidadeAtuacaoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeFk")
    private List<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacaoList; 

}
