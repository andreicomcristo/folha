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

@Entity(name="unidades_natureza_juridica")
public class UnidadesNaturezaJuridica implements Serializable {

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
    @Column(name="nome_natureza_juridica", nullable=false, length=150)
    private String nomeNaturezaJuridica;
    @Column(name="descricao_natureza_juridica", length=300)
    private String descricaoNaturezaJuridica;
    @OneToMany(mappedBy="unidadesNaturezaJuridica")
    private Set<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridica;

    /** Default constructor. */
    public UnidadesNaturezaJuridica() {
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
     * Access method for nomeNaturezaJuridica.
     *
     * @return the current value of nomeNaturezaJuridica
     */
    public String getNomeNaturezaJuridica() {
        return nomeNaturezaJuridica;
    }

    /**
     * Setter method for nomeNaturezaJuridica.
     *
     * @param aNomeNaturezaJuridica the new value for nomeNaturezaJuridica
     */
    public void setNomeNaturezaJuridica(String aNomeNaturezaJuridica) {
        nomeNaturezaJuridica = aNomeNaturezaJuridica;
    }

    /**
     * Access method for descricaoNaturezaJuridica.
     *
     * @return the current value of descricaoNaturezaJuridica
     */
    public String getDescricaoNaturezaJuridica() {
        return descricaoNaturezaJuridica;
    }

    /**
     * Setter method for descricaoNaturezaJuridica.
     *
     * @param aDescricaoNaturezaJuridica the new value for descricaoNaturezaJuridica
     */
    public void setDescricaoNaturezaJuridica(String aDescricaoNaturezaJuridica) {
        descricaoNaturezaJuridica = aDescricaoNaturezaJuridica;
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
     * Compares the key for this instance with another UnidadesNaturezaJuridica.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UnidadesNaturezaJuridica and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UnidadesNaturezaJuridica)) {
            return false;
        }
        UnidadesNaturezaJuridica that = (UnidadesNaturezaJuridica) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UnidadesNaturezaJuridica.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UnidadesNaturezaJuridica)) return false;
        return this.equalKeys(other) && ((UnidadesNaturezaJuridica)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[UnidadesNaturezaJuridica |");
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
