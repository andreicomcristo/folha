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
@Table(name="paises", indexes={@Index(name="paises_nome_pais_IX", columnList="nome_pais", unique=true)})
public class Paises implements Serializable {

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
    @Column(name="nome_pais", unique=true, nullable=false, length=300)
    private String nomePais;
    @OneToMany(mappedBy="paises")
    private Set<Cidades> cidades;

    /** Default constructor. */
    public Paises() {
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
     * Access method for nomePais.
     *
     * @return the current value of nomePais
     */
    public String getNomePais() {
        return nomePais;
    }

    /**
     * Setter method for nomePais.
     *
     * @param aNomePais the new value for nomePais
     */
    public void setNomePais(String aNomePais) {
        nomePais = aNomePais;
    }

    /**
     * Access method for cidades.
     *
     * @return the current value of cidades
     */
    public Set<Cidades> getCidades() {
        return cidades;
    }

    /**
     * Setter method for cidades.
     *
     * @param aCidades the new value for cidades
     */
    public void setCidades(Set<Cidades> aCidades) {
        cidades = aCidades;
    }

    /**
     * Compares the key for this instance with another Paises.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Paises and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Paises)) {
            return false;
        }
        Paises that = (Paises) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Paises.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Paises)) return false;
        return this.equalKeys(other) && ((Paises)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Paises |");
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
