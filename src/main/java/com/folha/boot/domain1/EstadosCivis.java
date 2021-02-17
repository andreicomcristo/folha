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
@Table(name="estados_civis", indexes={@Index(name="estados_civis_nome_estado_civil_IX", columnList="nome_estado_civil", unique=true)})
public class EstadosCivis implements Serializable {

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
    @Column(name="nome_estado_civil", unique=true, nullable=false, length=100)
    private String nomeEstadoCivil;
    @Column(name="descricao_estado_civil", length=300)
    private String descricaoEstadoCivil;
    @OneToMany(mappedBy="estadosCivis")
    private Set<Pessoa> pessoa;

    /** Default constructor. */
    public EstadosCivis() {
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
     * Access method for nomeEstadoCivil.
     *
     * @return the current value of nomeEstadoCivil
     */
    public String getNomeEstadoCivil() {
        return nomeEstadoCivil;
    }

    /**
     * Setter method for nomeEstadoCivil.
     *
     * @param aNomeEstadoCivil the new value for nomeEstadoCivil
     */
    public void setNomeEstadoCivil(String aNomeEstadoCivil) {
        nomeEstadoCivil = aNomeEstadoCivil;
    }

    /**
     * Access method for descricaoEstadoCivil.
     *
     * @return the current value of descricaoEstadoCivil
     */
    public String getDescricaoEstadoCivil() {
        return descricaoEstadoCivil;
    }

    /**
     * Setter method for descricaoEstadoCivil.
     *
     * @param aDescricaoEstadoCivil the new value for descricaoEstadoCivil
     */
    public void setDescricaoEstadoCivil(String aDescricaoEstadoCivil) {
        descricaoEstadoCivil = aDescricaoEstadoCivil;
    }

    /**
     * Access method for pessoa.
     *
     * @return the current value of pessoa
     */
    public Set<Pessoa> getPessoa() {
        return pessoa;
    }

    /**
     * Setter method for pessoa.
     *
     * @param aPessoa the new value for pessoa
     */
    public void setPessoa(Set<Pessoa> aPessoa) {
        pessoa = aPessoa;
    }

    /**
     * Compares the key for this instance with another EstadosCivis.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class EstadosCivis and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EstadosCivis)) {
            return false;
        }
        EstadosCivis that = (EstadosCivis) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another EstadosCivis.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EstadosCivis)) return false;
        return this.equalKeys(other) && ((EstadosCivis)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[EstadosCivis |");
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
