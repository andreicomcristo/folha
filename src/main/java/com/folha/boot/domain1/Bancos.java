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
@Table(name="bancos", indexes={@Index(name="bancos_codigo_banco_IX", columnList="codigo_banco", unique=true)})
public class Bancos implements Serializable {

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
    @Column(name="codigo_banco", unique=true, nullable=false, length=50)
    private String codigoBanco;
    @Column(name="nome_banco", nullable=false, length=300)
    private String nomeBanco;
    @Column(name="sigla_banco", length=150)
    private String siglaBanco;
    @OneToMany(mappedBy="bancos")
    private Set<PessoaBancos> pessoaBancos;

    /** Default constructor. */
    public Bancos() {
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
     * Access method for codigoBanco.
     *
     * @return the current value of codigoBanco
     */
    public String getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * Setter method for codigoBanco.
     *
     * @param aCodigoBanco the new value for codigoBanco
     */
    public void setCodigoBanco(String aCodigoBanco) {
        codigoBanco = aCodigoBanco;
    }

    /**
     * Access method for nomeBanco.
     *
     * @return the current value of nomeBanco
     */
    public String getNomeBanco() {
        return nomeBanco;
    }

    /**
     * Setter method for nomeBanco.
     *
     * @param aNomeBanco the new value for nomeBanco
     */
    public void setNomeBanco(String aNomeBanco) {
        nomeBanco = aNomeBanco;
    }

    /**
     * Access method for siglaBanco.
     *
     * @return the current value of siglaBanco
     */
    public String getSiglaBanco() {
        return siglaBanco;
    }

    /**
     * Setter method for siglaBanco.
     *
     * @param aSiglaBanco the new value for siglaBanco
     */
    public void setSiglaBanco(String aSiglaBanco) {
        siglaBanco = aSiglaBanco;
    }

    /**
     * Access method for pessoaBancos.
     *
     * @return the current value of pessoaBancos
     */
    public Set<PessoaBancos> getPessoaBancos() {
        return pessoaBancos;
    }

    /**
     * Setter method for pessoaBancos.
     *
     * @param aPessoaBancos the new value for pessoaBancos
     */
    public void setPessoaBancos(Set<PessoaBancos> aPessoaBancos) {
        pessoaBancos = aPessoaBancos;
    }

    /**
     * Compares the key for this instance with another Bancos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Bancos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Bancos)) {
            return false;
        }
        Bancos that = (Bancos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Bancos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Bancos)) return false;
        return this.equalKeys(other) && ((Bancos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Bancos |");
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
