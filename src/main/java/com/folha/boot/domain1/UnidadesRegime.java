// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="unidades_regime", indexes={@Index(name="unidades_regime_sigla_regime_unid_lotacao_IX", columnList="sigla_regime_unid_lotacao", unique=true)})
public class UnidadesRegime implements Serializable {

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
    @Column(name="sigla_regime_unid_lotacao", unique=true, nullable=false, length=10)
    private String siglaRegimeUnidLotacao;
    @Column(name="nome_regime_unid_lotacao", nullable=false, length=150)
    private String nomeRegimeUnidLotacao;
    @Column(name="descricao_regime_unid_lotacao", length=300)
    private String descricaoRegimeUnidLotacao;
    @OneToMany(mappedBy="unidadesRegime")
    private Set<HistUnidadesRegime> histUnidadesRegime;

    /** Default constructor. */
    public UnidadesRegime() {
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
     * Access method for siglaRegimeUnidLotacao.
     *
     * @return the current value of siglaRegimeUnidLotacao
     */
    public String getSiglaRegimeUnidLotacao() {
        return siglaRegimeUnidLotacao;
    }

    /**
     * Setter method for siglaRegimeUnidLotacao.
     *
     * @param aSiglaRegimeUnidLotacao the new value for siglaRegimeUnidLotacao
     */
    public void setSiglaRegimeUnidLotacao(String aSiglaRegimeUnidLotacao) {
        siglaRegimeUnidLotacao = aSiglaRegimeUnidLotacao;
    }

    /**
     * Access method for nomeRegimeUnidLotacao.
     *
     * @return the current value of nomeRegimeUnidLotacao
     */
    public String getNomeRegimeUnidLotacao() {
        return nomeRegimeUnidLotacao;
    }

    /**
     * Setter method for nomeRegimeUnidLotacao.
     *
     * @param aNomeRegimeUnidLotacao the new value for nomeRegimeUnidLotacao
     */
    public void setNomeRegimeUnidLotacao(String aNomeRegimeUnidLotacao) {
        nomeRegimeUnidLotacao = aNomeRegimeUnidLotacao;
    }

    /**
     * Access method for descricaoRegimeUnidLotacao.
     *
     * @return the current value of descricaoRegimeUnidLotacao
     */
    public String getDescricaoRegimeUnidLotacao() {
        return descricaoRegimeUnidLotacao;
    }

    /**
     * Setter method for descricaoRegimeUnidLotacao.
     *
     * @param aDescricaoRegimeUnidLotacao the new value for descricaoRegimeUnidLotacao
     */
    public void setDescricaoRegimeUnidLotacao(String aDescricaoRegimeUnidLotacao) {
        descricaoRegimeUnidLotacao = aDescricaoRegimeUnidLotacao;
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
     * Compares the key for this instance with another UnidadesRegime.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UnidadesRegime and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UnidadesRegime)) {
            return false;
        }
        UnidadesRegime that = (UnidadesRegime) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UnidadesRegime.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UnidadesRegime)) return false;
        return this.equalKeys(other) && ((UnidadesRegime)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[UnidadesRegime |");
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
