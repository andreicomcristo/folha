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

@Entity(name="tipos_de_documento")
public class TiposDeDocumento implements Serializable {

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
    @Column(name="sigla_documento", length=300)
    private String siglaDocumento;
    @Column(name="nome_documento", length=300)
    private String nomeDocumento;
    @OneToMany(mappedBy="tiposDeDocumento")
    private Set<PessoaDocumentos> pessoaDocumentos;

    /** Default constructor. */
    public TiposDeDocumento() {
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
     * Access method for siglaDocumento.
     *
     * @return the current value of siglaDocumento
     */
    public String getSiglaDocumento() {
        return siglaDocumento;
    }

    /**
     * Setter method for siglaDocumento.
     *
     * @param aSiglaDocumento the new value for siglaDocumento
     */
    public void setSiglaDocumento(String aSiglaDocumento) {
        siglaDocumento = aSiglaDocumento;
    }

    /**
     * Access method for nomeDocumento.
     *
     * @return the current value of nomeDocumento
     */
    public String getNomeDocumento() {
        return nomeDocumento;
    }

    /**
     * Setter method for nomeDocumento.
     *
     * @param aNomeDocumento the new value for nomeDocumento
     */
    public void setNomeDocumento(String aNomeDocumento) {
        nomeDocumento = aNomeDocumento;
    }

    /**
     * Access method for pessoaDocumentos.
     *
     * @return the current value of pessoaDocumentos
     */
    public Set<PessoaDocumentos> getPessoaDocumentos() {
        return pessoaDocumentos;
    }

    /**
     * Setter method for pessoaDocumentos.
     *
     * @param aPessoaDocumentos the new value for pessoaDocumentos
     */
    public void setPessoaDocumentos(Set<PessoaDocumentos> aPessoaDocumentos) {
        pessoaDocumentos = aPessoaDocumentos;
    }

    /**
     * Compares the key for this instance with another TiposDeDocumento.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposDeDocumento and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposDeDocumento)) {
            return false;
        }
        TiposDeDocumento that = (TiposDeDocumento) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposDeDocumento.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposDeDocumento)) return false;
        return this.equalKeys(other) && ((TiposDeDocumento)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[TiposDeDocumento |");
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
