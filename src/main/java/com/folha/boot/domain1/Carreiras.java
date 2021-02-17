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
@Table(name="carreiras", indexes={@Index(name="carreiras_sigla_carreira_IX", columnList="sigla_carreira", unique=true)})
public class Carreiras implements Serializable {

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
    @Column(name="sigla_carreira", unique=true, nullable=false, length=10)
    private String siglaCarreira;
    @Column(name="nome_carreira", nullable=false, length=150)
    private String nomeCarreira;
    @Column(name="descricao_carreira", length=300)
    private String descricaoCarreira;
    @OneToMany(mappedBy="carreiras")
    private Set<HistFuncionariosCarreira> histFuncionariosCarreira;

    /** Default constructor. */
    public Carreiras() {
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
     * Access method for siglaCarreira.
     *
     * @return the current value of siglaCarreira
     */
    public String getSiglaCarreira() {
        return siglaCarreira;
    }

    /**
     * Setter method for siglaCarreira.
     *
     * @param aSiglaCarreira the new value for siglaCarreira
     */
    public void setSiglaCarreira(String aSiglaCarreira) {
        siglaCarreira = aSiglaCarreira;
    }

    /**
     * Access method for nomeCarreira.
     *
     * @return the current value of nomeCarreira
     */
    public String getNomeCarreira() {
        return nomeCarreira;
    }

    /**
     * Setter method for nomeCarreira.
     *
     * @param aNomeCarreira the new value for nomeCarreira
     */
    public void setNomeCarreira(String aNomeCarreira) {
        nomeCarreira = aNomeCarreira;
    }

    /**
     * Access method for descricaoCarreira.
     *
     * @return the current value of descricaoCarreira
     */
    public String getDescricaoCarreira() {
        return descricaoCarreira;
    }

    /**
     * Setter method for descricaoCarreira.
     *
     * @param aDescricaoCarreira the new value for descricaoCarreira
     */
    public void setDescricaoCarreira(String aDescricaoCarreira) {
        descricaoCarreira = aDescricaoCarreira;
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
     * Compares the key for this instance with another Carreiras.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Carreiras and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Carreiras)) {
            return false;
        }
        Carreiras that = (Carreiras) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Carreiras.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Carreiras)) return false;
        return this.equalKeys(other) && ((Carreiras)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Carreiras |");
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
