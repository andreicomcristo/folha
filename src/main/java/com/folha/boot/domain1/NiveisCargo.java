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
@Table(name="niveis_cargo", indexes={@Index(name="niveis_cargo_sigla_nivel_cargo_IX", columnList="sigla_nivel_cargo", unique=true)})
public class NiveisCargo implements Serializable {

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
    @Column(name="sigla_nivel_cargo", unique=true, nullable=false, length=10)
    private String siglaNivelCargo;
    @Column(name="nome_nivel_cargo", nullable=false, length=150)
    private String nomeNivelCargo;
    @Column(name="descricao_nivel_cargo", length=300)
    private String descricaoNivelCargo;
    @OneToMany(mappedBy="niveisCargo")
    private Set<Cargos> cargos;

    /** Default constructor. */
    public NiveisCargo() {
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
     * Access method for siglaNivelCargo.
     *
     * @return the current value of siglaNivelCargo
     */
    public String getSiglaNivelCargo() {
        return siglaNivelCargo;
    }

    /**
     * Setter method for siglaNivelCargo.
     *
     * @param aSiglaNivelCargo the new value for siglaNivelCargo
     */
    public void setSiglaNivelCargo(String aSiglaNivelCargo) {
        siglaNivelCargo = aSiglaNivelCargo;
    }

    /**
     * Access method for nomeNivelCargo.
     *
     * @return the current value of nomeNivelCargo
     */
    public String getNomeNivelCargo() {
        return nomeNivelCargo;
    }

    /**
     * Setter method for nomeNivelCargo.
     *
     * @param aNomeNivelCargo the new value for nomeNivelCargo
     */
    public void setNomeNivelCargo(String aNomeNivelCargo) {
        nomeNivelCargo = aNomeNivelCargo;
    }

    /**
     * Access method for descricaoNivelCargo.
     *
     * @return the current value of descricaoNivelCargo
     */
    public String getDescricaoNivelCargo() {
        return descricaoNivelCargo;
    }

    /**
     * Setter method for descricaoNivelCargo.
     *
     * @param aDescricaoNivelCargo the new value for descricaoNivelCargo
     */
    public void setDescricaoNivelCargo(String aDescricaoNivelCargo) {
        descricaoNivelCargo = aDescricaoNivelCargo;
    }

    /**
     * Access method for cargos.
     *
     * @return the current value of cargos
     */
    public Set<Cargos> getCargos() {
        return cargos;
    }

    /**
     * Setter method for cargos.
     *
     * @param aCargos the new value for cargos
     */
    public void setCargos(Set<Cargos> aCargos) {
        cargos = aCargos;
    }

    /**
     * Compares the key for this instance with another NiveisCargo.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class NiveisCargo and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof NiveisCargo)) {
            return false;
        }
        NiveisCargo that = (NiveisCargo) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another NiveisCargo.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof NiveisCargo)) return false;
        return this.equalKeys(other) && ((NiveisCargo)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[NiveisCargo |");
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
