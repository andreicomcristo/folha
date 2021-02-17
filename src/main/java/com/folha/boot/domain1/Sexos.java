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
@Table(name="sexos", indexes={@Index(name="sexos_nome_sexo_IX", columnList="nome_sexo", unique=true)})
public class Sexos implements Serializable {

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
    @Column(name="nome_sexo", unique=true, nullable=false, length=100)
    private String nomeSexo;
    @Column(name="descricao_sexo", length=300)
    private String descricaoSexo;
    @OneToMany(mappedBy="sexos2")
    private Set<Pessoa> pessoa2;
    @OneToMany(mappedBy="sexos")
    private Set<Pessoa> pessoa;

    /** Default constructor. */
    public Sexos() {
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
     * Access method for nomeSexo.
     *
     * @return the current value of nomeSexo
     */
    public String getNomeSexo() {
        return nomeSexo;
    }

    /**
     * Setter method for nomeSexo.
     *
     * @param aNomeSexo the new value for nomeSexo
     */
    public void setNomeSexo(String aNomeSexo) {
        nomeSexo = aNomeSexo;
    }

    /**
     * Access method for descricaoSexo.
     *
     * @return the current value of descricaoSexo
     */
    public String getDescricaoSexo() {
        return descricaoSexo;
    }

    /**
     * Setter method for descricaoSexo.
     *
     * @param aDescricaoSexo the new value for descricaoSexo
     */
    public void setDescricaoSexo(String aDescricaoSexo) {
        descricaoSexo = aDescricaoSexo;
    }

    /**
     * Access method for pessoa2.
     *
     * @return the current value of pessoa2
     */
    public Set<Pessoa> getPessoa2() {
        return pessoa2;
    }

    /**
     * Setter method for pessoa2.
     *
     * @param aPessoa2 the new value for pessoa2
     */
    public void setPessoa2(Set<Pessoa> aPessoa2) {
        pessoa2 = aPessoa2;
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
     * Compares the key for this instance with another Sexos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Sexos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Sexos)) {
            return false;
        }
        Sexos that = (Sexos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Sexos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Sexos)) return false;
        return this.equalKeys(other) && ((Sexos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Sexos |");
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
