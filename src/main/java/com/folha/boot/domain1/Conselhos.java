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

@Entity(name="conselhos")
public class Conselhos implements Serializable {

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
    @Column(name="nome_conselho", nullable=false, length=100)
    private String nomeConselho;
    @Column(name="descricao_conselho", length=300)
    private String descricaoConselho;
    @OneToMany(mappedBy="conselhos")
    private Set<PessoaDocumentosConselho> pessoaDocumentosConselho;

    /** Default constructor. */
    public Conselhos() {
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
     * Access method for nomeConselho.
     *
     * @return the current value of nomeConselho
     */
    public String getNomeConselho() {
        return nomeConselho;
    }

    /**
     * Setter method for nomeConselho.
     *
     * @param aNomeConselho the new value for nomeConselho
     */
    public void setNomeConselho(String aNomeConselho) {
        nomeConselho = aNomeConselho;
    }

    /**
     * Access method for descricaoConselho.
     *
     * @return the current value of descricaoConselho
     */
    public String getDescricaoConselho() {
        return descricaoConselho;
    }

    /**
     * Setter method for descricaoConselho.
     *
     * @param aDescricaoConselho the new value for descricaoConselho
     */
    public void setDescricaoConselho(String aDescricaoConselho) {
        descricaoConselho = aDescricaoConselho;
    }

    /**
     * Access method for pessoaDocumentosConselho.
     *
     * @return the current value of pessoaDocumentosConselho
     */
    public Set<PessoaDocumentosConselho> getPessoaDocumentosConselho() {
        return pessoaDocumentosConselho;
    }

    /**
     * Setter method for pessoaDocumentosConselho.
     *
     * @param aPessoaDocumentosConselho the new value for pessoaDocumentosConselho
     */
    public void setPessoaDocumentosConselho(Set<PessoaDocumentosConselho> aPessoaDocumentosConselho) {
        pessoaDocumentosConselho = aPessoaDocumentosConselho;
    }

    /**
     * Compares the key for this instance with another Conselhos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Conselhos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Conselhos)) {
            return false;
        }
        Conselhos that = (Conselhos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Conselhos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Conselhos)) return false;
        return this.equalKeys(other) && ((Conselhos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Conselhos |");
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
