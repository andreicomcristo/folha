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
@Table(name="escolaridades", indexes={@Index(name="escolaridades_nome_escolaridade_IX", columnList="nome_escolaridade", unique=true)})
public class Escolaridades implements Serializable {

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
    @Column(name="nome_escolaridade", unique=true, nullable=false, length=100)
    private String nomeEscolaridade;
    @Column(name="descricao_escolaridade", length=300)
    private String descricaoEscolaridade;
    @OneToMany(mappedBy="escolaridades")
    private Set<Pessoa> pessoa;

    /** Default constructor. */
    public Escolaridades() {
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
     * Access method for nomeEscolaridade.
     *
     * @return the current value of nomeEscolaridade
     */
    public String getNomeEscolaridade() {
        return nomeEscolaridade;
    }

    /**
     * Setter method for nomeEscolaridade.
     *
     * @param aNomeEscolaridade the new value for nomeEscolaridade
     */
    public void setNomeEscolaridade(String aNomeEscolaridade) {
        nomeEscolaridade = aNomeEscolaridade;
    }

    /**
     * Access method for descricaoEscolaridade.
     *
     * @return the current value of descricaoEscolaridade
     */
    public String getDescricaoEscolaridade() {
        return descricaoEscolaridade;
    }

    /**
     * Setter method for descricaoEscolaridade.
     *
     * @param aDescricaoEscolaridade the new value for descricaoEscolaridade
     */
    public void setDescricaoEscolaridade(String aDescricaoEscolaridade) {
        descricaoEscolaridade = aDescricaoEscolaridade;
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
     * Compares the key for this instance with another Escolaridades.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Escolaridades and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Escolaridades)) {
            return false;
        }
        Escolaridades that = (Escolaridades) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Escolaridades.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Escolaridades)) return false;
        return this.equalKeys(other) && ((Escolaridades)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Escolaridades |");
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
