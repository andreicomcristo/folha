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

@Entity(name="niveis_carreira")
public class NiveisCarreira implements Serializable {

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
    @Column(name="nome_nivel_carreira", nullable=false, length=300)
    private String nomeNivelCarreira;
    @Column(name="descricao_nivel_carreira", length=300)
    private String descricaoNivelCarreira;
    @OneToMany(mappedBy="niveisCarreira")
    private Set<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreira;

    /** Default constructor. */
    public NiveisCarreira() {
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
     * Access method for nomeNivelCarreira.
     *
     * @return the current value of nomeNivelCarreira
     */
    public String getNomeNivelCarreira() {
        return nomeNivelCarreira;
    }

    /**
     * Setter method for nomeNivelCarreira.
     *
     * @param aNomeNivelCarreira the new value for nomeNivelCarreira
     */
    public void setNomeNivelCarreira(String aNomeNivelCarreira) {
        nomeNivelCarreira = aNomeNivelCarreira;
    }

    /**
     * Access method for descricaoNivelCarreira.
     *
     * @return the current value of descricaoNivelCarreira
     */
    public String getDescricaoNivelCarreira() {
        return descricaoNivelCarreira;
    }

    /**
     * Setter method for descricaoNivelCarreira.
     *
     * @param aDescricaoNivelCarreira the new value for descricaoNivelCarreira
     */
    public void setDescricaoNivelCarreira(String aDescricaoNivelCarreira) {
        descricaoNivelCarreira = aDescricaoNivelCarreira;
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
     * Compares the key for this instance with another NiveisCarreira.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class NiveisCarreira and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof NiveisCarreira)) {
            return false;
        }
        NiveisCarreira that = (NiveisCarreira) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another NiveisCarreira.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof NiveisCarreira)) return false;
        return this.equalKeys(other) && ((NiveisCarreira)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[NiveisCarreira |");
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
