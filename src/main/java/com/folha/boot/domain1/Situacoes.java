// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="situacoes")
public class Situacoes implements Serializable {

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
    @Column(name="nome_situacao", nullable=false, length=300)
    private String nomeSituacao;
    @Column(name="descricao_situacao", length=300)
    private String descricaoSituacao;
    @OneToMany(mappedBy="situacoes")
    private Set<HistFuncionariosSituacoes> histFuncionariosSituacoes;

    /** Default constructor. */
    public Situacoes() {
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
     * Access method for nomeSituacao.
     *
     * @return the current value of nomeSituacao
     */
    public String getNomeSituacao() {
        return nomeSituacao;
    }

    /**
     * Setter method for nomeSituacao.
     *
     * @param aNomeSituacao the new value for nomeSituacao
     */
    public void setNomeSituacao(String aNomeSituacao) {
        nomeSituacao = aNomeSituacao;
    }

    /**
     * Access method for descricaoSituacao.
     *
     * @return the current value of descricaoSituacao
     */
    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }

    /**
     * Setter method for descricaoSituacao.
     *
     * @param aDescricaoSituacao the new value for descricaoSituacao
     */
    public void setDescricaoSituacao(String aDescricaoSituacao) {
        descricaoSituacao = aDescricaoSituacao;
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
     * Compares the key for this instance with another Situacoes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Situacoes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Situacoes)) {
            return false;
        }
        Situacoes that = (Situacoes) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Situacoes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Situacoes)) return false;
        return this.equalKeys(other) && ((Situacoes)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Situacoes |");
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
