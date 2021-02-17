// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="cargos_especialidade", indexes={@Index(name="cargos_especialidade_nome_especialidade_cargo_IX", columnList="nome_especialidade_cargo", unique=true)})
public class CargosEspecialidade implements Serializable {

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
    @Column(name="nome_especialidade_cargo", unique=true, nullable=false, length=100)
    private String nomeEspecialidadeCargo;
    @Column(name="descricao_especialidade_cargo", length=300)
    private String descricaoEspecialidadeCargo;
    @ManyToOne
    @JoinColumn(name="id_cargo_fk")
    private Cargos cargos;

    /** Default constructor. */
    public CargosEspecialidade() {
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
     * Access method for nomeEspecialidadeCargo.
     *
     * @return the current value of nomeEspecialidadeCargo
     */
    public String getNomeEspecialidadeCargo() {
        return nomeEspecialidadeCargo;
    }

    /**
     * Setter method for nomeEspecialidadeCargo.
     *
     * @param aNomeEspecialidadeCargo the new value for nomeEspecialidadeCargo
     */
    public void setNomeEspecialidadeCargo(String aNomeEspecialidadeCargo) {
        nomeEspecialidadeCargo = aNomeEspecialidadeCargo;
    }

    /**
     * Access method for descricaoEspecialidadeCargo.
     *
     * @return the current value of descricaoEspecialidadeCargo
     */
    public String getDescricaoEspecialidadeCargo() {
        return descricaoEspecialidadeCargo;
    }

    /**
     * Setter method for descricaoEspecialidadeCargo.
     *
     * @param aDescricaoEspecialidadeCargo the new value for descricaoEspecialidadeCargo
     */
    public void setDescricaoEspecialidadeCargo(String aDescricaoEspecialidadeCargo) {
        descricaoEspecialidadeCargo = aDescricaoEspecialidadeCargo;
    }

    /**
     * Access method for cargos.
     *
     * @return the current value of cargos
     */
    public Cargos getCargos() {
        return cargos;
    }

    /**
     * Setter method for cargos.
     *
     * @param aCargos the new value for cargos
     */
    public void setCargos(Cargos aCargos) {
        cargos = aCargos;
    }

    /**
     * Compares the key for this instance with another CargosEspecialidade.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CargosEspecialidade and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CargosEspecialidade)) {
            return false;
        }
        CargosEspecialidade that = (CargosEspecialidade) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CargosEspecialidade.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CargosEspecialidade)) return false;
        return this.equalKeys(other) && ((CargosEspecialidade)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[CargosEspecialidade |");
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
