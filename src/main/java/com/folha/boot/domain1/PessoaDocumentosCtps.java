// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="pessoa_documentos_ctps")
public class PessoaDocumentosCtps implements Serializable {

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
    @Column(nullable=false, length=100)
    private String numero;
    @Column(length=100)
    private String serie;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;

    /** Default constructor. */
    public PessoaDocumentosCtps() {
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
     * Access method for numero.
     *
     * @return the current value of numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Setter method for numero.
     *
     * @param aNumero the new value for numero
     */
    public void setNumero(String aNumero) {
        numero = aNumero;
    }

    /**
     * Access method for serie.
     *
     * @return the current value of serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Setter method for serie.
     *
     * @param aSerie the new value for serie
     */
    public void setSerie(String aSerie) {
        serie = aSerie;
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
     * Compares the key for this instance with another PessoaDocumentosCtps.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaDocumentosCtps and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaDocumentosCtps)) {
            return false;
        }
        PessoaDocumentosCtps that = (PessoaDocumentosCtps) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaDocumentosCtps.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaDocumentosCtps)) return false;
        return this.equalKeys(other) && ((PessoaDocumentosCtps)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaDocumentosCtps |");
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
