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

@Entity(name="unidades")
public class Unidades implements Serializable {

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
    @Column(name="nome_fantasia", nullable=false, length=300)
    private String nomeFantasia;
    @Column(name="nome_empresarial", length=300)
    private String nomeEmpresarial;
    @Column(length=50)
    private String cnes;
    @Column(name="id_natureza_juridica_fk")
    private long idNaturezaJuridicaFk;
    @Column(name="id_endereco_unidade_fk")
    private long idEnderecoUnidadeFk;
    @Column(length=40)
    private String fone1;
    @Column(name="endereco_logradouro", length=300)
    private String enderecoLogradouro;
    @Column(name="endereco_numero", length=150)
    private String enderecoNumero;
    @Column(name="endereco_complemento", length=300)
    private String enderecoComplemento;
    @Column(name="endereco_bairro", length=300)
    private String enderecoBairro;
    @Column(name="endereco_cep", length=50)
    private String enderecoCep;
    @Column(name="dt_cadastro")
    private LocalDate dtCadastro;
    @Column(name="motivo_cadastro", length=300)
    private String motivoCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="motivo_cancelamento", length=300)
    private String motivoCancelamento;
    @ManyToOne
    @JoinColumn(name="id_endereco_cidade_fk")
    private Cidades cidades;
    @ManyToOne
    @JoinColumn(name="id_operador_cadastro_fk")
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_operador_cancelamento_fk")
    private PessoaOperadores pessoaOperadores2;
    @ManyToOne
    @JoinColumn(name="id_tipo_logradouro_fk")
    private TiposLogradouro tiposLogradouro;
    @OneToMany(mappedBy="unidades")
    private Set<HistFuncionariosUnidadeAtuacao> histFuncionariosUnidadeAtuacao;
    @OneToMany(mappedBy="unidades")
    private Set<HistFuncionariosUnidadeLotacao> histFuncionariosUnidadeLotacao;
    @OneToMany(mappedBy="unidades")
    private Set<Autorizacoes> autorizacoes;
    @OneToMany(mappedBy="unidades")
    private Set<HistUnidadesDiretor> histUnidadesDiretor;
    @OneToMany(mappedBy="unidades")
    private Set<HistUnidadesRegime> histUnidadesRegime;

    /** Default constructor. */
    public Unidades() {
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
     * Access method for nomeFantasia.
     *
     * @return the current value of nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Setter method for nomeFantasia.
     *
     * @param aNomeFantasia the new value for nomeFantasia
     */
    public void setNomeFantasia(String aNomeFantasia) {
        nomeFantasia = aNomeFantasia;
    }

    /**
     * Access method for nomeEmpresarial.
     *
     * @return the current value of nomeEmpresarial
     */
    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    /**
     * Setter method for nomeEmpresarial.
     *
     * @param aNomeEmpresarial the new value for nomeEmpresarial
     */
    public void setNomeEmpresarial(String aNomeEmpresarial) {
        nomeEmpresarial = aNomeEmpresarial;
    }

    /**
     * Access method for cnes.
     *
     * @return the current value of cnes
     */
    public String getCnes() {
        return cnes;
    }

    /**
     * Setter method for cnes.
     *
     * @param aCnes the new value for cnes
     */
    public void setCnes(String aCnes) {
        cnes = aCnes;
    }

    /**
     * Access method for idNaturezaJuridicaFk.
     *
     * @return the current value of idNaturezaJuridicaFk
     */
    public long getIdNaturezaJuridicaFk() {
        return idNaturezaJuridicaFk;
    }

    /**
     * Setter method for idNaturezaJuridicaFk.
     *
     * @param aIdNaturezaJuridicaFk the new value for idNaturezaJuridicaFk
     */
    public void setIdNaturezaJuridicaFk(long aIdNaturezaJuridicaFk) {
        idNaturezaJuridicaFk = aIdNaturezaJuridicaFk;
    }

    /**
     * Access method for idEnderecoUnidadeFk.
     *
     * @return the current value of idEnderecoUnidadeFk
     */
    public long getIdEnderecoUnidadeFk() {
        return idEnderecoUnidadeFk;
    }

    /**
     * Setter method for idEnderecoUnidadeFk.
     *
     * @param aIdEnderecoUnidadeFk the new value for idEnderecoUnidadeFk
     */
    public void setIdEnderecoUnidadeFk(long aIdEnderecoUnidadeFk) {
        idEnderecoUnidadeFk = aIdEnderecoUnidadeFk;
    }

    /**
     * Access method for fone1.
     *
     * @return the current value of fone1
     */
    public String getFone1() {
        return fone1;
    }

    /**
     * Setter method for fone1.
     *
     * @param aFone1 the new value for fone1
     */
    public void setFone1(String aFone1) {
        fone1 = aFone1;
    }

    /**
     * Access method for enderecoLogradouro.
     *
     * @return the current value of enderecoLogradouro
     */
    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    /**
     * Setter method for enderecoLogradouro.
     *
     * @param aEnderecoLogradouro the new value for enderecoLogradouro
     */
    public void setEnderecoLogradouro(String aEnderecoLogradouro) {
        enderecoLogradouro = aEnderecoLogradouro;
    }

    /**
     * Access method for enderecoNumero.
     *
     * @return the current value of enderecoNumero
     */
    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    /**
     * Setter method for enderecoNumero.
     *
     * @param aEnderecoNumero the new value for enderecoNumero
     */
    public void setEnderecoNumero(String aEnderecoNumero) {
        enderecoNumero = aEnderecoNumero;
    }

    /**
     * Access method for enderecoComplemento.
     *
     * @return the current value of enderecoComplemento
     */
    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    /**
     * Setter method for enderecoComplemento.
     *
     * @param aEnderecoComplemento the new value for enderecoComplemento
     */
    public void setEnderecoComplemento(String aEnderecoComplemento) {
        enderecoComplemento = aEnderecoComplemento;
    }

    /**
     * Access method for enderecoBairro.
     *
     * @return the current value of enderecoBairro
     */
    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    /**
     * Setter method for enderecoBairro.
     *
     * @param aEnderecoBairro the new value for enderecoBairro
     */
    public void setEnderecoBairro(String aEnderecoBairro) {
        enderecoBairro = aEnderecoBairro;
    }

    /**
     * Access method for enderecoCep.
     *
     * @return the current value of enderecoCep
     */
    public String getEnderecoCep() {
        return enderecoCep;
    }

    /**
     * Setter method for enderecoCep.
     *
     * @param aEnderecoCep the new value for enderecoCep
     */
    public void setEnderecoCep(String aEnderecoCep) {
        enderecoCep = aEnderecoCep;
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
     * Access method for cidades.
     *
     * @return the current value of cidades
     */
    public Cidades getCidades() {
        return cidades;
    }

    /**
     * Setter method for cidades.
     *
     * @param aCidades the new value for cidades
     */
    public void setCidades(Cidades aCidades) {
        cidades = aCidades;
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
     * Access method for tiposLogradouro.
     *
     * @return the current value of tiposLogradouro
     */
    public TiposLogradouro getTiposLogradouro() {
        return tiposLogradouro;
    }

    /**
     * Setter method for tiposLogradouro.
     *
     * @param aTiposLogradouro the new value for tiposLogradouro
     */
    public void setTiposLogradouro(TiposLogradouro aTiposLogradouro) {
        tiposLogradouro = aTiposLogradouro;
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
     * Compares the key for this instance with another Unidades.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Unidades and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Unidades)) {
            return false;
        }
        Unidades that = (Unidades) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Unidades.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Unidades)) return false;
        return this.equalKeys(other) && ((Unidades)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Unidades |");
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
