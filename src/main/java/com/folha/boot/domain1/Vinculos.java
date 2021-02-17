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
@Table(name="vinculos", indexes={@Index(name="vinculos_nome_vinculo_IX", columnList="nome_vinculo", unique=true)})
public class Vinculos implements Serializable {

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
    @Column(name="nome_vinculo", unique=true, nullable=false, length=100)
    private String nomeVinculo;
    @Column(name="descricao_vinculo", length=300)
    private String descricaoVinculo;
    @OneToMany(mappedBy="vinculos")
    private Set<HistFuncionariosVinculos> histFuncionariosVinculos;

    /** Default constructor. */
    public Vinculos() {
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
     * Access method for nomeVinculo.
     *
     * @return the current value of nomeVinculo
     */
    public String getNomeVinculo() {
        return nomeVinculo;
    }

    /**
     * Setter method for nomeVinculo.
     *
     * @param aNomeVinculo the new value for nomeVinculo
     */
    public void setNomeVinculo(String aNomeVinculo) {
        nomeVinculo = aNomeVinculo;
    }

    /**
     * Access method for descricaoVinculo.
     *
     * @return the current value of descricaoVinculo
     */
    public String getDescricaoVinculo() {
        return descricaoVinculo;
    }

    /**
     * Setter method for descricaoVinculo.
     *
     * @param aDescricaoVinculo the new value for descricaoVinculo
     */
    public void setDescricaoVinculo(String aDescricaoVinculo) {
        descricaoVinculo = aDescricaoVinculo;
    }

    /**
     * Access method for histFuncionariosVinculos.
     *
     * @return the current value of histFuncionariosVinculos
     */
    public Set<HistFuncionariosVinculos> getHistFuncionariosVinculos() {
        return histFuncionariosVinculos;
    }

    /**
     * Setter method for histFuncionariosVinculos.
     *
     * @param aHistFuncionariosVinculos the new value for histFuncionariosVinculos
     */
    public void setHistFuncionariosVinculos(Set<HistFuncionariosVinculos> aHistFuncionariosVinculos) {
        histFuncionariosVinculos = aHistFuncionariosVinculos;
    }

    /**
     * Compares the key for this instance with another Vinculos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Vinculos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Vinculos)) {
            return false;
        }
        Vinculos that = (Vinculos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Vinculos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Vinculos)) return false;
        return this.equalKeys(other) && ((Vinculos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Vinculos |");
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
