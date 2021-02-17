// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="pessoa_operadores")
public class PessoaOperadores implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="last_update")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @Column(unique=true, nullable=false)
    private long id;
    @Column(nullable=false, length=300)
    private String senha;
    @Column(name="dt_cadastro")
    private LocalDate dtCadastro;
    @Column(name="id_operador_cadastro_fk")
    private long idOperadorCadastroFk;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="id_operador_cancelamento_fk")
    private long idOperadorCancelamentoFk;
    @Column(name="motivo_cancelamento", length=500)
    private String motivoCancelamento;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosCargaHoraria> histFuncionariosCargaHoraria2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosSituacoes> histFuncionariosSituacoes2;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<PessoaFuncionarios> pessoaFuncionarios;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosVinculos> histFuncionariosVinculos;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistUnidadesDiretor> histUnidadesDiretor;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridica;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistUnidadesRegime> histUnidadesRegime;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<Pessoa> pessoa2;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<PessoaBancos> pessoaBancos;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<PessoaFilhos> pessoaFilhos;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<Unidades> unidades;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosAutorizacao> histFuncionariosAutorizacao;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosCargaHoraria> histFuncionariosCargaHoraria;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosCargos> histFuncionariosCargos;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosCarreira> histFuncionariosCarreira;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosClasse> histFuncionariosClasse;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosSituacoes> histFuncionariosSituacoes;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacao;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacao;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<PessoaFuncionarios> pessoaFuncionarios2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridica2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistUnidadesRegime> histUnidadesRegime2;
    @OneToMany(mappedBy="pessoaOperadores3")
    private Set<Pessoa> pessoa3;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<PessoaBancos> pessoaBancos2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<PessoaFilhos> pessoaFilhos2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<Unidades> unidades2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosAutorizacao> histFuncionariosAutorizacao2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosCargos> histFuncionariosCargos2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosCarreira> histFuncionariosCarreira2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosClasse> histFuncionariosClasse2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacao2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacao2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosVinculos> histFuncionariosVinculos2;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistUnidadesDiretor> histUnidadesDiretor2;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<Autorizacoes> autorizacoes;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name="seq_privilegio")
    private Privilegios privilegios;
    @OneToMany(mappedBy="pessoaOperadores")
    private Set<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreira;
    @OneToMany(mappedBy="pessoaOperadores2")
    private Set<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreira2;

    /** Default constructor. */
    public PessoaOperadores() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(long aId) {
        id = aId;
    }

    /**
     * Access method for senha.
     *
     * @return the current value of senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Setter method for senha.
     *
     * @param aSenha the new value for senha
     */
    public void setSenha(String aSenha) {
        senha = aSenha;
    }

    /**
     * Access method for dtCadastro.
     *
     * @return the current value of dtCadastro
     */
    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Setter method for dtCadastro.
     *
     * @param aDtCadastro the new value for dtCadastro
     */
    public void setDtCadastro(LocalDate aDtCadastro) {
        dtCadastro = aDtCadastro;
    }

    /**
     * Access method for idOperadorCadastroFk.
     *
     * @return the current value of idOperadorCadastroFk
     */
    public long getIdOperadorCadastroFk() {
        return idOperadorCadastroFk;
    }

    /**
     * Setter method for idOperadorCadastroFk.
     *
     * @param aIdOperadorCadastroFk the new value for idOperadorCadastroFk
     */
    public void setIdOperadorCadastroFk(long aIdOperadorCadastroFk) {
        idOperadorCadastroFk = aIdOperadorCadastroFk;
    }

    /**
     * Access method for dtCancelamento.
     *
     * @return the current value of dtCancelamento
     */
    public LocalDate getDtCancelamento() {
        return dtCancelamento;
    }

    /**
     * Setter method for dtCancelamento.
     *
     * @param aDtCancelamento the new value for dtCancelamento
     */
    public void setDtCancelamento(LocalDate aDtCancelamento) {
        dtCancelamento = aDtCancelamento;
    }

    /**
     * Access method for idOperadorCancelamentoFk.
     *
     * @return the current value of idOperadorCancelamentoFk
     */
    public long getIdOperadorCancelamentoFk() {
        return idOperadorCancelamentoFk;
    }

    /**
     * Setter method for idOperadorCancelamentoFk.
     *
     * @param aIdOperadorCancelamentoFk the new value for idOperadorCancelamentoFk
     */
    public void setIdOperadorCancelamentoFk(long aIdOperadorCancelamentoFk) {
        idOperadorCancelamentoFk = aIdOperadorCancelamentoFk;
    }

    /**
     * Access method for motivoCancelamento.
     *
     * @return the current value of motivoCancelamento
     */
    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    /**
     * Setter method for motivoCancelamento.
     *
     * @param aMotivoCancelamento the new value for motivoCancelamento
     */
    public void setMotivoCancelamento(String aMotivoCancelamento) {
        motivoCancelamento = aMotivoCancelamento;
    }

    /**
     * Access method for histFuncionariosCargaHoraria2.
     *
     * @return the current value of histFuncionariosCargaHoraria2
     */
    public Set<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHoraria2() {
        return histFuncionariosCargaHoraria2;
    }

    /**
     * Setter method for histFuncionariosCargaHoraria2.
     *
     * @param aHistFuncionariosCargaHoraria2 the new value for histFuncionariosCargaHoraria2
     */
    public void setHistFuncionariosCargaHoraria2(Set<HistFuncionariosCargaHoraria> aHistFuncionariosCargaHoraria2) {
        histFuncionariosCargaHoraria2 = aHistFuncionariosCargaHoraria2;
    }

    /**
     * Access method for histFuncionariosSituacoes2.
     *
     * @return the current value of histFuncionariosSituacoes2
     */
    public Set<HistFuncionariosSituacoes> getHistFuncionariosSituacoes2() {
        return histFuncionariosSituacoes2;
    }

    /**
     * Setter method for histFuncionariosSituacoes2.
     *
     * @param aHistFuncionariosSituacoes2 the new value for histFuncionariosSituacoes2
     */
    public void setHistFuncionariosSituacoes2(Set<HistFuncionariosSituacoes> aHistFuncionariosSituacoes2) {
        histFuncionariosSituacoes2 = aHistFuncionariosSituacoes2;
    }

    /**
     * Access method for pessoaFuncionarios.
     *
     * @return the current value of pessoaFuncionarios
     */
    public Set<PessoaFuncionarios> getPessoaFuncionarios() {
        return pessoaFuncionarios;
    }

    /**
     * Setter method for pessoaFuncionarios.
     *
     * @param aPessoaFuncionarios the new value for pessoaFuncionarios
     */
    public void setPessoaFuncionarios(Set<PessoaFuncionarios> aPessoaFuncionarios) {
        pessoaFuncionarios = aPessoaFuncionarios;
    }

    /**
     * Access method for histFuncionariosVinculos.
     *
     * @return the current value of histFuncionariosVinculos
     */
    public Set<HistFuncionariosVinculos> getHistFuncionariosVinculos() {
        return histFuncionariosVinculos;
    }

    /**
     * Setter method for histFuncionariosVinculos.
     *
     * @param aHistFuncionariosVinculos the new value for histFuncionariosVinculos
     */
    public void setHistFuncionariosVinculos(Set<HistFuncionariosVinculos> aHistFuncionariosVinculos) {
        histFuncionariosVinculos = aHistFuncionariosVinculos;
    }

    /**
     * Access method for histUnidadesDiretor.
     *
     * @return the current value of histUnidadesDiretor
     */
    public Set<HistUnidadesDiretor> getHistUnidadesDiretor() {
        return histUnidadesDiretor;
    }

    /**
     * Setter method for histUnidadesDiretor.
     *
     * @param aHistUnidadesDiretor the new value for histUnidadesDiretor
     */
    public void setHistUnidadesDiretor(Set<HistUnidadesDiretor> aHistUnidadesDiretor) {
        histUnidadesDiretor = aHistUnidadesDiretor;
    }

    /**
     * Access method for histUnidadesNaturezaJuridica.
     *
     * @return the current value of histUnidadesNaturezaJuridica
     */
    public Set<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridica() {
        return histUnidadesNaturezaJuridica;
    }

    /**
     * Setter method for histUnidadesNaturezaJuridica.
     *
     * @param aHistUnidadesNaturezaJuridica the new value for histUnidadesNaturezaJuridica
     */
    public void setHistUnidadesNaturezaJuridica(Set<HistUnidadesNaturezaJuridica> aHistUnidadesNaturezaJuridica) {
        histUnidadesNaturezaJuridica = aHistUnidadesNaturezaJuridica;
    }

    /**
     * Access method for histUnidadesRegime.
     *
     * @return the current value of histUnidadesRegime
     */
    public Set<HistUnidadesRegime> getHistUnidadesRegime() {
        return histUnidadesRegime;
    }

    /**
     * Setter method for histUnidadesRegime.
     *
     * @param aHistUnidadesRegime the new value for histUnidadesRegime
     */
    public void setHistUnidadesRegime(Set<HistUnidadesRegime> aHistUnidadesRegime) {
        histUnidadesRegime = aHistUnidadesRegime;
    }

    /**
     * Access method for pessoa2.
     *
     * @return the current value of pessoa2
     */
    public Set<Pessoa> getPessoa2() {
        return pessoa2;
    }

    /**
     * Setter method for pessoa2.
     *
     * @param aPessoa2 the new value for pessoa2
     */
    public void setPessoa2(Set<Pessoa> aPessoa2) {
        pessoa2 = aPessoa2;
    }

    /**
     * Access method for pessoaBancos.
     *
     * @return the current value of pessoaBancos
     */
    public Set<PessoaBancos> getPessoaBancos() {
        return pessoaBancos;
    }

    /**
     * Setter method for pessoaBancos.
     *
     * @param aPessoaBancos the new value for pessoaBancos
     */
    public void setPessoaBancos(Set<PessoaBancos> aPessoaBancos) {
        pessoaBancos = aPessoaBancos;
    }

    /**
     * Access method for pessoaFilhos.
     *
     * @return the current value of pessoaFilhos
     */
    public Set<PessoaFilhos> getPessoaFilhos() {
        return pessoaFilhos;
    }

    /**
     * Setter method for pessoaFilhos.
     *
     * @param aPessoaFilhos the new value for pessoaFilhos
     */
    public void setPessoaFilhos(Set<PessoaFilhos> aPessoaFilhos) {
        pessoaFilhos = aPessoaFilhos;
    }

    /**
     * Access method for unidades.
     *
     * @return the current value of unidades
     */
    public Set<Unidades> getUnidades() {
        return unidades;
    }

    /**
     * Setter method for unidades.
     *
     * @param aUnidades the new value for unidades
     */
    public void setUnidades(Set<Unidades> aUnidades) {
        unidades = aUnidades;
    }

    /**
     * Access method for histFuncionariosAutorizacao.
     *
     * @return the current value of histFuncionariosAutorizacao
     */
    public Set<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacao() {
        return histFuncionariosAutorizacao;
    }

    /**
     * Setter method for histFuncionariosAutorizacao.
     *
     * @param aHistFuncionariosAutorizacao the new value for histFuncionariosAutorizacao
     */
    public void setHistFuncionariosAutorizacao(Set<HistFuncionariosAutorizacao> aHistFuncionariosAutorizacao) {
        histFuncionariosAutorizacao = aHistFuncionariosAutorizacao;
    }

    /**
     * Access method for histFuncionariosCargaHoraria.
     *
     * @return the current value of histFuncionariosCargaHoraria
     */
    public Set<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHoraria() {
        return histFuncionariosCargaHoraria;
    }

    /**
     * Setter method for histFuncionariosCargaHoraria.
     *
     * @param aHistFuncionariosCargaHoraria the new value for histFuncionariosCargaHoraria
     */
    public void setHistFuncionariosCargaHoraria(Set<HistFuncionariosCargaHoraria> aHistFuncionariosCargaHoraria) {
        histFuncionariosCargaHoraria = aHistFuncionariosCargaHoraria;
    }

    /**
     * Access method for histFuncionariosCargos.
     *
     * @return the current value of histFuncionariosCargos
     */
    public Set<HistFuncionariosCargos> getHistFuncionariosCargos() {
        return histFuncionariosCargos;
    }

    /**
     * Setter method for histFuncionariosCargos.
     *
     * @param aHistFuncionariosCargos the new value for histFuncionariosCargos
     */
    public void setHistFuncionariosCargos(Set<HistFuncionariosCargos> aHistFuncionariosCargos) {
        histFuncionariosCargos = aHistFuncionariosCargos;
    }

    /**
     * Access method for histFuncionariosCarreira.
     *
     * @return the current value of histFuncionariosCarreira
     */
    public Set<HistFuncionariosCarreira> getHistFuncionariosCarreira() {
        return histFuncionariosCarreira;
    }

    /**
     * Setter method for histFuncionariosCarreira.
     *
     * @param aHistFuncionariosCarreira the new value for histFuncionariosCarreira
     */
    public void setHistFuncionariosCarreira(Set<HistFuncionariosCarreira> aHistFuncionariosCarreira) {
        histFuncionariosCarreira = aHistFuncionariosCarreira;
    }

    /**
     * Access method for histFuncionariosClasse.
     *
     * @return the current value of histFuncionariosClasse
     */
    public Set<HistFuncionariosClasse> getHistFuncionariosClasse() {
        return histFuncionariosClasse;
    }

    /**
     * Setter method for histFuncionariosClasse.
     *
     * @param aHistFuncionariosClasse the new value for histFuncionariosClasse
     */
    public void setHistFuncionariosClasse(Set<HistFuncionariosClasse> aHistFuncionariosClasse) {
        histFuncionariosClasse = aHistFuncionariosClasse;
    }

    /**
     * Access method for histFuncionariosSituacoes.
     *
     * @return the current value of histFuncionariosSituacoes
     */
    public Set<HistFuncionariosSituacoes> getHistFuncionariosSituacoes() {
        return histFuncionariosSituacoes;
    }

    /**
     * Setter method for histFuncionariosSituacoes.
     *
     * @param aHistFuncionariosSituacoes the new value for histFuncionariosSituacoes
     */
    public void setHistFuncionariosSituacoes(Set<HistFuncionariosSituacoes> aHistFuncionariosSituacoes) {
        histFuncionariosSituacoes = aHistFuncionariosSituacoes;
    }

    /**
     * Access method for histFuncionariosUnidadeAtuacao.
     *
     * @return the current value of histFuncionariosUnidadeAtuacao
     */
    public Set<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacao() {
        return histFuncionariosUnidadeAtuacao;
    }

    /**
     * Setter method for histFuncionariosUnidadeAtuacao.
     *
     * @param aHistFuncionariosUnidadeAtuacao the new value for histFuncionariosUnidadeAtuacao
     */
    public void setHistFuncionariosUnidadeAtuacao(Set<HistFuncionariosUnidadeAtuacao> aHistFuncionariosUnidadeAtuacao) {
        histFuncionariosUnidadeAtuacao = aHistFuncionariosUnidadeAtuacao;
    }

    /**
     * Access method for histFuncionariosUnidadeLotacao.
     *
     * @return the current value of histFuncionariosUnidadeLotacao
     */
    public Set<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacao() {
        return histFuncionariosUnidadeLotacao;
    }

    /**
     * Setter method for histFuncionariosUnidadeLotacao.
     *
     * @param aHistFuncionariosUnidadeLotacao the new value for histFuncionariosUnidadeLotacao
     */
    public void setHistFuncionariosUnidadeLotacao(Set<HistFuncionariosUnidadeLotacao> aHistFuncionariosUnidadeLotacao) {
        histFuncionariosUnidadeLotacao = aHistFuncionariosUnidadeLotacao;
    }

    /**
     * Access method for pessoaFuncionarios2.
     *
     * @return the current value of pessoaFuncionarios2
     */
    public Set<PessoaFuncionarios> getPessoaFuncionarios2() {
        return pessoaFuncionarios2;
    }

    /**
     * Setter method for pessoaFuncionarios2.
     *
     * @param aPessoaFuncionarios2 the new value for pessoaFuncionarios2
     */
    public void setPessoaFuncionarios2(Set<PessoaFuncionarios> aPessoaFuncionarios2) {
        pessoaFuncionarios2 = aPessoaFuncionarios2;
    }

    /**
     * Access method for histUnidadesNaturezaJuridica2.
     *
     * @return the current value of histUnidadesNaturezaJuridica2
     */
    public Set<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridica2() {
        return histUnidadesNaturezaJuridica2;
    }

    /**
     * Setter method for histUnidadesNaturezaJuridica2.
     *
     * @param aHistUnidadesNaturezaJuridica2 the new value for histUnidadesNaturezaJuridica2
     */
    public void setHistUnidadesNaturezaJuridica2(Set<HistUnidadesNaturezaJuridica> aHistUnidadesNaturezaJuridica2) {
        histUnidadesNaturezaJuridica2 = aHistUnidadesNaturezaJuridica2;
    }

    /**
     * Access method for histUnidadesRegime2.
     *
     * @return the current value of histUnidadesRegime2
     */
    public Set<HistUnidadesRegime> getHistUnidadesRegime2() {
        return histUnidadesRegime2;
    }

    /**
     * Setter method for histUnidadesRegime2.
     *
     * @param aHistUnidadesRegime2 the new value for histUnidadesRegime2
     */
    public void setHistUnidadesRegime2(Set<HistUnidadesRegime> aHistUnidadesRegime2) {
        histUnidadesRegime2 = aHistUnidadesRegime2;
    }

    /**
     * Access method for pessoa3.
     *
     * @return the current value of pessoa3
     */
    public Set<Pessoa> getPessoa3() {
        return pessoa3;
    }

    /**
     * Setter method for pessoa3.
     *
     * @param aPessoa3 the new value for pessoa3
     */
    public void setPessoa3(Set<Pessoa> aPessoa3) {
        pessoa3 = aPessoa3;
    }

    /**
     * Access method for pessoaBancos2.
     *
     * @return the current value of pessoaBancos2
     */
    public Set<PessoaBancos> getPessoaBancos2() {
        return pessoaBancos2;
    }

    /**
     * Setter method for pessoaBancos2.
     *
     * @param aPessoaBancos2 the new value for pessoaBancos2
     */
    public void setPessoaBancos2(Set<PessoaBancos> aPessoaBancos2) {
        pessoaBancos2 = aPessoaBancos2;
    }

    /**
     * Access method for pessoaFilhos2.
     *
     * @return the current value of pessoaFilhos2
     */
    public Set<PessoaFilhos> getPessoaFilhos2() {
        return pessoaFilhos2;
    }

    /**
     * Setter method for pessoaFilhos2.
     *
     * @param aPessoaFilhos2 the new value for pessoaFilhos2
     */
    public void setPessoaFilhos2(Set<PessoaFilhos> aPessoaFilhos2) {
        pessoaFilhos2 = aPessoaFilhos2;
    }

    /**
     * Access method for unidades2.
     *
     * @return the current value of unidades2
     */
    public Set<Unidades> getUnidades2() {
        return unidades2;
    }

    /**
     * Setter method for unidades2.
     *
     * @param aUnidades2 the new value for unidades2
     */
    public void setUnidades2(Set<Unidades> aUnidades2) {
        unidades2 = aUnidades2;
    }

    /**
     * Access method for histFuncionariosAutorizacao2.
     *
     * @return the current value of histFuncionariosAutorizacao2
     */
    public Set<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacao2() {
        return histFuncionariosAutorizacao2;
    }

    /**
     * Setter method for histFuncionariosAutorizacao2.
     *
     * @param aHistFuncionariosAutorizacao2 the new value for histFuncionariosAutorizacao2
     */
    public void setHistFuncionariosAutorizacao2(Set<HistFuncionariosAutorizacao> aHistFuncionariosAutorizacao2) {
        histFuncionariosAutorizacao2 = aHistFuncionariosAutorizacao2;
    }

    /**
     * Access method for histFuncionariosCargos2.
     *
     * @return the current value of histFuncionariosCargos2
     */
    public Set<HistFuncionariosCargos> getHistFuncionariosCargos2() {
        return histFuncionariosCargos2;
    }

    /**
     * Setter method for histFuncionariosCargos2.
     *
     * @param aHistFuncionariosCargos2 the new value for histFuncionariosCargos2
     */
    public void setHistFuncionariosCargos2(Set<HistFuncionariosCargos> aHistFuncionariosCargos2) {
        histFuncionariosCargos2 = aHistFuncionariosCargos2;
    }

    /**
     * Access method for histFuncionariosCarreira2.
     *
     * @return the current value of histFuncionariosCarreira2
     */
    public Set<HistFuncionariosCarreira> getHistFuncionariosCarreira2() {
        return histFuncionariosCarreira2;
    }

    /**
     * Setter method for histFuncionariosCarreira2.
     *
     * @param aHistFuncionariosCarreira2 the new value for histFuncionariosCarreira2
     */
    public void setHistFuncionariosCarreira2(Set<HistFuncionariosCarreira> aHistFuncionariosCarreira2) {
        histFuncionariosCarreira2 = aHistFuncionariosCarreira2;
    }

    /**
     * Access method for histFuncionariosClasse2.
     *
     * @return the current value of histFuncionariosClasse2
     */
    public Set<HistFuncionariosClasse> getHistFuncionariosClasse2() {
        return histFuncionariosClasse2;
    }

    /**
     * Setter method for histFuncionariosClasse2.
     *
     * @param aHistFuncionariosClasse2 the new value for histFuncionariosClasse2
     */
    public void setHistFuncionariosClasse2(Set<HistFuncionariosClasse> aHistFuncionariosClasse2) {
        histFuncionariosClasse2 = aHistFuncionariosClasse2;
    }

    /**
     * Access method for histFuncionariosUnidadeAtuacao2.
     *
     * @return the current value of histFuncionariosUnidadeAtuacao2
     */
    public Set<HistFuncionariosUnidadeAtuacao> getHistFuncionariosUnidadeAtuacao2() {
        return histFuncionariosUnidadeAtuacao2;
    }

    /**
     * Setter method for histFuncionariosUnidadeAtuacao2.
     *
     * @param aHistFuncionariosUnidadeAtuacao2 the new value for histFuncionariosUnidadeAtuacao2
     */
    public void setHistFuncionariosUnidadeAtuacao2(Set<HistFuncionariosUnidadeAtuacao> aHistFuncionariosUnidadeAtuacao2) {
        histFuncionariosUnidadeAtuacao2 = aHistFuncionariosUnidadeAtuacao2;
    }

    /**
     * Access method for histFuncionariosUnidadeLotacao2.
     *
     * @return the current value of histFuncionariosUnidadeLotacao2
     */
    public Set<HistFuncionariosUnidadeLotacao> getHistFuncionariosUnidadeLotacao2() {
        return histFuncionariosUnidadeLotacao2;
    }

    /**
     * Setter method for histFuncionariosUnidadeLotacao2.
     *
     * @param aHistFuncionariosUnidadeLotacao2 the new value for histFuncionariosUnidadeLotacao2
     */
    public void setHistFuncionariosUnidadeLotacao2(Set<HistFuncionariosUnidadeLotacao> aHistFuncionariosUnidadeLotacao2) {
        histFuncionariosUnidadeLotacao2 = aHistFuncionariosUnidadeLotacao2;
    }

    /**
     * Access method for histFuncionariosVinculos2.
     *
     * @return the current value of histFuncionariosVinculos2
     */
    public Set<HistFuncionariosVinculos> getHistFuncionariosVinculos2() {
        return histFuncionariosVinculos2;
    }

    /**
     * Setter method for histFuncionariosVinculos2.
     *
     * @param aHistFuncionariosVinculos2 the new value for histFuncionariosVinculos2
     */
    public void setHistFuncionariosVinculos2(Set<HistFuncionariosVinculos> aHistFuncionariosVinculos2) {
        histFuncionariosVinculos2 = aHistFuncionariosVinculos2;
    }

    /**
     * Access method for histUnidadesDiretor2.
     *
     * @return the current value of histUnidadesDiretor2
     */
    public Set<HistUnidadesDiretor> getHistUnidadesDiretor2() {
        return histUnidadesDiretor2;
    }

    /**
     * Setter method for histUnidadesDiretor2.
     *
     * @param aHistUnidadesDiretor2 the new value for histUnidadesDiretor2
     */
    public void setHistUnidadesDiretor2(Set<HistUnidadesDiretor> aHistUnidadesDiretor2) {
        histUnidadesDiretor2 = aHistUnidadesDiretor2;
    }

    /**
     * Access method for autorizacoes.
     *
     * @return the current value of autorizacoes
     */
    public Set<Autorizacoes> getAutorizacoes() {
        return autorizacoes;
    }

    /**
     * Setter method for autorizacoes.
     *
     * @param aAutorizacoes the new value for autorizacoes
     */
    public void setAutorizacoes(Set<Autorizacoes> aAutorizacoes) {
        autorizacoes = aAutorizacoes;
    }

    /**
     * Access method for pessoa.
     *
     * @return the current value of pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Setter method for pessoa.
     *
     * @param aPessoa the new value for pessoa
     */
    public void setPessoa(Pessoa aPessoa) {
        pessoa = aPessoa;
    }

    /**
     * Access method for privilegios.
     *
     * @return the current value of privilegios
     */
    public Privilegios getPrivilegios() {
        return privilegios;
    }

    /**
     * Setter method for privilegios.
     *
     * @param aPrivilegios the new value for privilegios
     */
    public void setPrivilegios(Privilegios aPrivilegios) {
        privilegios = aPrivilegios;
    }

    /**
     * Access method for histFuncionariosNiveisCarreira.
     *
     * @return the current value of histFuncionariosNiveisCarreira
     */
    public Set<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreira() {
        return histFuncionariosNiveisCarreira;
    }

    /**
     * Setter method for histFuncionariosNiveisCarreira.
     *
     * @param aHistFuncionariosNiveisCarreira the new value for histFuncionariosNiveisCarreira
     */
    public void setHistFuncionariosNiveisCarreira(Set<HistFuncionariosNiveisCarreira> aHistFuncionariosNiveisCarreira) {
        histFuncionariosNiveisCarreira = aHistFuncionariosNiveisCarreira;
    }

    /**
     * Access method for histFuncionariosNiveisCarreira2.
     *
     * @return the current value of histFuncionariosNiveisCarreira2
     */
    public Set<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreira2() {
        return histFuncionariosNiveisCarreira2;
    }

    /**
     * Setter method for histFuncionariosNiveisCarreira2.
     *
     * @param aHistFuncionariosNiveisCarreira2 the new value for histFuncionariosNiveisCarreira2
     */
    public void setHistFuncionariosNiveisCarreira2(Set<HistFuncionariosNiveisCarreira> aHistFuncionariosNiveisCarreira2) {
        histFuncionariosNiveisCarreira2 = aHistFuncionariosNiveisCarreira2;
    }

    /**
     * Compares the key for this instance with another PessoaOperadores.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaOperadores and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaOperadores)) {
            return false;
        }
        PessoaOperadores that = (PessoaOperadores) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaOperadores.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaOperadores)) return false;
        return this.equalKeys(other) && ((PessoaOperadores)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getId() ^ (getId()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[PessoaOperadores |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Long.valueOf(getId()));
        return ret;
    }

}
