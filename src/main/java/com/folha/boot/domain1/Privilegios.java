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

@Entity(name="privilegios")
public class Privilegios implements Serializable {

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
    @Column(name="nome_privilegio", nullable=false, length=300)
    private String nomePrivilegio;
    @Column(name="descricao_privilegio", nullable=false, length=3000)
    private String descricaoPrivilegio;
    @OneToMany(mappedBy="privilegios")
    private Set<PessoaOperadores> pessoaOperadores;

    /** Default constructor. */
    public Privilegios() {
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
     * Access method for nomePrivilegio.
     *
     * @return the current value of nomePrivilegio
     */
    public String getNomePrivilegio() {
        return nomePrivilegio;
    }

    /**
     * Setter method for nomePrivilegio.
     *
     * @param aNomePrivilegio the new value for nomePrivilegio
     */
    public void setNomePrivilegio(String aNomePrivilegio) {
        nomePrivilegio = aNomePrivilegio;
    }

    /**
     * Access method for descricaoPrivilegio.
     *
     * @return the current value of descricaoPrivilegio
     */
    public String getDescricaoPrivilegio() {
        return descricaoPrivilegio;
    }

    /**
     * Setter method for descricaoPrivilegio.
     *
     * @param aDescricaoPrivilegio the new value for descricaoPrivilegio
     */
    public void setDescricaoPrivilegio(String aDescricaoPrivilegio) {
        descricaoPrivilegio = aDescricaoPrivilegio;
    }

    /**
     * Access method for pessoaOperadores.
     *
     * @return the current value of pessoaOperadores
     */
    public Set<PessoaOperadores> getPessoaOperadores() {
        return pessoaOperadores;
    }

    /**
     * Setter method for pessoaOperadores.
     *
     * @param aPessoaOperadores the new value for pessoaOperadores
     */
    public void setPessoaOperadores(Set<PessoaOperadores> aPessoaOperadores) {
        pessoaOperadores = aPessoaOperadores;
    }

    /**
     * Compares the key for this instance with another Privilegios.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Privilegios and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Privilegios)) {
            return false;
        }
        Privilegios that = (Privilegios) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Privilegios.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Privilegios)) return false;
        return this.equalKeys(other) && ((Privilegios)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Privilegios |");
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
