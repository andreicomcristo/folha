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
@Table(name="classes", indexes={@Index(name="classes_sigla_classe_IX", columnList="sigla_classe", unique=true)})
public class Classes implements Serializable {

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
    @Column(name="sigla_classe", unique=true, nullable=false, length=10)
    private String siglaClasse;
    @Column(name="nome_classe", nullable=false, length=150)
    private String nomeClasse;
    @Column(name="descricao_classe", length=300)
    private String descricaoClasse;
    @OneToMany(mappedBy="classes")
    private Set<HistFuncionariosClasse> histFuncionariosClasse;

    /** Default constructor. */
    public Classes() {
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
     * Access method for siglaClasse.
     *
     * @return the current value of siglaClasse
     */
    public String getSiglaClasse() {
        return siglaClasse;
    }

    /**
     * Setter method for siglaClasse.
     *
     * @param aSiglaClasse the new value for siglaClasse
     */
    public void setSiglaClasse(String aSiglaClasse) {
        siglaClasse = aSiglaClasse;
    }

    /**
     * Access method for nomeClasse.
     *
     * @return the current value of nomeClasse
     */
    public String getNomeClasse() {
        return nomeClasse;
    }

    /**
     * Setter method for nomeClasse.
     *
     * @param aNomeClasse the new value for nomeClasse
     */
    public void setNomeClasse(String aNomeClasse) {
        nomeClasse = aNomeClasse;
    }

    /**
     * Access method for descricaoClasse.
     *
     * @return the current value of descricaoClasse
     */
    public String getDescricaoClasse() {
        return descricaoClasse;
    }

    /**
     * Setter method for descricaoClasse.
     *
     * @param aDescricaoClasse the new value for descricaoClasse
     */
    public void setDescricaoClasse(String aDescricaoClasse) {
        descricaoClasse = aDescricaoClasse;
    }

    /**
     * Access method for histFuncionariosClasse.
     *
     * @return the current value of histFuncionariosClasse
     */
    public Set<HistFuncionariosClasse> getHistFuncionariosClasse() {
        return histFuncionariosClasse;
    }

    /**
     * Setter method for histFuncionariosClasse.
     *
     * @param aHistFuncionariosClasse the new value for histFuncionariosClasse
     */
    public void setHistFuncionariosClasse(Set<HistFuncionariosClasse> aHistFuncionariosClasse) {
        histFuncionariosClasse = aHistFuncionariosClasse;
    }

    /**
     * Compares the key for this instance with another Classes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Classes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Classes)) {
            return false;
        }
        Classes that = (Classes) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Classes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Classes)) return false;
        return this.equalKeys(other) && ((Classes)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Classes |");
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
