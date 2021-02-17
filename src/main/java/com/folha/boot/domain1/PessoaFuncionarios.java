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

@Entity(name="pessoa_funcionarios")
public class PessoaFuncionarios implements Serializable {

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
    @Column(length=30)
    private String matricula;
    @Column(name="dt_nomeacao")
    private LocalDate dtNomeacao;
    @Column(name="dt_posse")
    private LocalDate dtPosse;
    @Column(name="numero_de_ordem", length=150)
    private String numeroDeOrdem;
    @Column(name="numero_de_ponto", length=150)
    private String numeroDePonto;
    @Column(name="dt_cadastro")
    private LocalDate dtCadastro;
    @Column(name="motivo_cadastro", length=300)
    private String motivoCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="motivo_cancelamento", length=300)
    private String motivoCancelamento;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosCarreira> histFuncionariosCarreira;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacao;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<Autorizacoes> autorizacoes;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosAutorizacao> histFuncionariosAutorizacao;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosCargaHoraria> histFuncionariosCargaHoraria;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosCargos> histFuncionariosCargos;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosClasse> histFuncionariosClasse;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosSituacoes> histFuncionariosSituacoes;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosVinculos> histFuncionariosVinculos;
    @ManyToOne
    @JoinColumn(name="id_operador_cadastro_fk")
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_operador_cancelamento_fk")
    private PessoaOperadores pessoaOperadores2;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;
    @OneToMany(mappedBy="pessoaFuncionarios")
    private Set<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreira;

    /** Default constructor. */
    public PessoaFuncionarios() {
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
     * Access method for matricula.
     *
     * @return the current value of matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter method for matricula.
     *
     * @param aMatricula the new value for matricula
     */
    public void setMatricula(String aMatricula) {
        matricula = aMatricula;
    }

    /**
     * Access method for dtNomeacao.
     *
     * @return the current value of dtNomeacao
     */
    public LocalDate getDtNomeacao() {
        return dtNomeacao;
    }

    /**
     * Setter method for dtNomeacao.
     *
     * @param aDtNomeacao the new value for dtNomeacao
     */
    public void setDtNomeacao(LocalDate aDtNomeacao) {
        dtNomeacao = aDtNomeacao;
    }

    /**
     * Access method for dtPosse.
     *
     * @return the current value of dtPosse
     */
    public LocalDate getDtPosse() {
        return dtPosse;
    }

    /**
     * Setter method for dtPosse.
     *
     * @param aDtPosse the new value for dtPosse
     */
    public void setDtPosse(LocalDate aDtPosse) {
        dtPosse = aDtPosse;
    }

    /**
     * Access method for numeroDeOrdem.
     *
     * @return the current value of numeroDeOrdem
     */
    public String getNumeroDeOrdem() {
        return numeroDeOrdem;
    }

    /**
     * Setter method for numeroDeOrdem.
     *
     * @param aNumeroDeOrdem the new value for numeroDeOrdem
     */
    public void setNumeroDeOrdem(String aNumeroDeOrdem) {
        numeroDeOrdem = aNumeroDeOrdem;
    }

    /**
     * Access method for numeroDePonto.
     *
     * @return the current value of numeroDePonto
     */
    public String getNumeroDePonto() {
        return numeroDePonto;
    }

    /**
     * Setter method for numeroDePonto.
     *
     * @param aNumeroDePonto the new value for numeroDePonto
     */
    public void setNumeroDePonto(String aNumeroDePonto) {
        numeroDePonto = aNumeroDePonto;
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
     * Access method for motivoCadastro.
     *
     * @return the current value of motivoCadastro
     */
    public String getMotivoCadastro() {
        return motivoCadastro;
    }

    /**
     * Setter method for motivoCadastro.
     *
     * @param aMotivoCadastro the new value for motivoCadastro
     */
    public void setMotivoCadastro(String aMotivoCadastro) {
        motivoCadastro = aMotivoCadastro;
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
     * Access method for pessoaOperadores.
     *
     * @return the current value of pessoaOperadores
     */
    public PessoaOperadores getPessoaOperadores() {
        return pessoaOperadores;
    }

    /**
     * Setter method for pessoaOperadores.
     *
     * @param aPessoaOperadores the new value for pessoaOperadores
     */
    public void setPessoaOperadores(PessoaOperadores aPessoaOperadores) {
        pessoaOperadores = aPessoaOperadores;
    }

    /**
     * Access method for pessoaOperadores2.
     *
     * @return the current value of pessoaOperadores2
     */
    public PessoaOperadores getPessoaOperadores2() {
        return pessoaOperadores2;
    }

    /**
     * Setter method for pessoaOperadores2.
     *
     * @param aPessoaOperadores2 the new value for pessoaOperadores2
     */
    public void setPessoaOperadores2(PessoaOperadores aPessoaOperadores2) {
        pessoaOperadores2 = aPessoaOperadores2;
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
     * Compares the key for this instance with another PessoaFuncionarios.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaFuncionarios and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaFuncionarios)) {
            return false;
        }
        PessoaFuncionarios that = (PessoaFuncionarios) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaFuncionarios.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaFuncionarios)) return false;
        return this.equalKeys(other) && ((PessoaFuncionarios)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaFuncionarios |");
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
