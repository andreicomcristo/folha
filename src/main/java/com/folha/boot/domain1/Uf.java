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

@Entity(name="uf")
public class Uf implements Serializable {

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
    @Column(name="sigla_uf", nullable=false, length=300)
    private String siglaUf;
    @Column(name="nome_uf", nullable=false, length=300)
    private String nomeUf;
    @OneToMany(mappedBy="uf")
    private Set<Cidades> cidades;
    @OneToMany(mappedBy="uf")
    private Set<PessoaDocumentosConselho> pessoaDocumentosConselho;
    @OneToMany(mappedBy="uf")
    private Set<PessoaDocumentosRg> pessoaDocumentosRg;

    /** Default constructor. */
    public Uf() {
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
     * Access method for siglaUf.
     *
     * @return the current value of siglaUf
     */
    public String getSiglaUf() {
        return siglaUf;
    }

    /**
     * Setter method for siglaUf.
     *
     * @param aSiglaUf the new value for siglaUf
     */
    public void setSiglaUf(String aSiglaUf) {
        siglaUf = aSiglaUf;
    }

    /**
     * Access method for nomeUf.
     *
     * @return the current value of nomeUf
     */
    public String getNomeUf() {
        return nomeUf;
    }

    /**
     * Setter method for nomeUf.
     *
     * @param aNomeUf the new value for nomeUf
     */
    public void setNomeUf(String aNomeUf) {
        nomeUf = aNomeUf;
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
     * Access method for pessoaDocumentosRg.
     *
     * @return the current value of pessoaDocumentosRg
     */
    public Set<PessoaDocumentosRg> getPessoaDocumentosRg() {
        return pessoaDocumentosRg;
    }

    /**
     * Setter method for pessoaDocumentosRg.
     *
     * @param aPessoaDocumentosRg the new value for pessoaDocumentosRg
     */
    public void setPessoaDocumentosRg(Set<PessoaDocumentosRg> aPessoaDocumentosRg) {
        pessoaDocumentosRg = aPessoaDocumentosRg;
    }

    /**
     * Compares the key for this instance with another Uf.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Uf and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Uf)) {
            return false;
        }
        Uf that = (Uf) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Uf.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Uf)) return false;
        return this.equalKeys(other) && ((Uf)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Uf |");
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
