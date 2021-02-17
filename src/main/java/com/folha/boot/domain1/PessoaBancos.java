// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="pessoa_bancos")
public class PessoaBancos implements Serializable {

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
    @Column(name="operacao_variacao", length=20)
    private String operacaoVariacao;
    @Column(name="agencia_numero", nullable=false, length=20)
    private String agenciaNumero;
    @Column(name="agencia_dv", length=5)
    private String agenciaDv;
    @Column(name="conta_numero", nullable=false, length=20)
    private String contaNumero;
    @Column(name="conta_dv", nullable=false, length=5)
    private String contaDv;
    @Column(name="agencia_nome", length=300)
    private String agenciaNome;
    private String prioritario;
    @Column(name="dt_cadastro")
    private LocalDate dtCadastro;
    @Column(name="motivo_cadastro", length=300)
    private String motivoCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="motivo_cancelamento", length=300)
    private String motivoCancelamento;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_banco_fk", nullable=false)
    private Bancos bancos;
    @ManyToOne
    @JoinColumn(name="id_operador_cadastro_fk")
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_operador_cancelamento_fk")
    private PessoaOperadores pessoaOperadores2;

    /** Default constructor. */
    public PessoaBancos() {
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
     * Access method for operacaoVariacao.
     *
     * @return the current value of operacaoVariacao
     */
    public String getOperacaoVariacao() {
        return operacaoVariacao;
    }

    /**
     * Setter method for operacaoVariacao.
     *
     * @param aOperacaoVariacao the new value for operacaoVariacao
     */
    public void setOperacaoVariacao(String aOperacaoVariacao) {
        operacaoVariacao = aOperacaoVariacao;
    }

    /**
     * Access method for agenciaNumero.
     *
     * @return the current value of agenciaNumero
     */
    public String getAgenciaNumero() {
        return agenciaNumero;
    }

    /**
     * Setter method for agenciaNumero.
     *
     * @param aAgenciaNumero the new value for agenciaNumero
     */
    public void setAgenciaNumero(String aAgenciaNumero) {
        agenciaNumero = aAgenciaNumero;
    }

    /**
     * Access method for agenciaDv.
     *
     * @return the current value of agenciaDv
     */
    public String getAgenciaDv() {
        return agenciaDv;
    }

    /**
     * Setter method for agenciaDv.
     *
     * @param aAgenciaDv the new value for agenciaDv
     */
    public void setAgenciaDv(String aAgenciaDv) {
        agenciaDv = aAgenciaDv;
    }

    /**
     * Access method for contaNumero.
     *
     * @return the current value of contaNumero
     */
    public String getContaNumero() {
        return contaNumero;
    }

    /**
     * Setter method for contaNumero.
     *
     * @param aContaNumero the new value for contaNumero
     */
    public void setContaNumero(String aContaNumero) {
        contaNumero = aContaNumero;
    }

    /**
     * Access method for contaDv.
     *
     * @return the current value of contaDv
     */
    public String getContaDv() {
        return contaDv;
    }

    /**
     * Setter method for contaDv.
     *
     * @param aContaDv the new value for contaDv
     */
    public void setContaDv(String aContaDv) {
        contaDv = aContaDv;
    }

    /**
     * Access method for agenciaNome.
     *
     * @return the current value of agenciaNome
     */
    public String getAgenciaNome() {
        return agenciaNome;
    }

    /**
     * Setter method for agenciaNome.
     *
     * @param aAgenciaNome the new value for agenciaNome
     */
    public void setAgenciaNome(String aAgenciaNome) {
        agenciaNome = aAgenciaNome;
    }

    /**
     * Access method for prioritario.
     *
     * @return the current value of prioritario
     */
    public String getPrioritario() {
        return prioritario;
    }

    /**
     * Setter method for prioritario.
     *
     * @param aPrioritario the new value for prioritario
     */
    public void setPrioritario(String aPrioritario) {
        prioritario = aPrioritario;
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
     * Access method for bancos.
     *
     * @return the current value of bancos
     */
    public Bancos getBancos() {
        return bancos;
    }

    /**
     * Setter method for bancos.
     *
     * @param aBancos the new value for bancos
     */
    public void setBancos(Bancos aBancos) {
        bancos = aBancos;
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
     * Compares the key for this instance with another PessoaBancos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaBancos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaBancos)) {
            return false;
        }
        PessoaBancos that = (PessoaBancos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaBancos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaBancos)) return false;
        return this.equalKeys(other) && ((PessoaBancos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaBancos |");
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
