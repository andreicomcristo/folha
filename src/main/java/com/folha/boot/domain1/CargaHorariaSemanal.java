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
@Table(name="carga_horaria_semanal", indexes={@Index(name="carga_horaria_semanal_carga_horaria_IX", columnList="carga_horaria", unique=true)})
public class CargaHorariaSemanal implements Serializable {

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
    @Column(name="carga_horaria", unique=true, nullable=false)
    private int cargaHoraria;
    @Column(name="descricao_carga_horaria", length=300)
    private String descricaoCargaHoraria;
    @OneToMany(mappedBy="cargaHorariaSemanal")
    private Set<HistFuncionariosCargaHoraria> histFuncionariosCargaHoraria;

    /** Default constructor. */
    public CargaHorariaSemanal() {
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
     * Access method for cargaHoraria.
     *
     * @return the current value of cargaHoraria
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * Setter method for cargaHoraria.
     *
     * @param aCargaHoraria the new value for cargaHoraria
     */
    public void setCargaHoraria(int aCargaHoraria) {
        cargaHoraria = aCargaHoraria;
    }

    /**
     * Access method for descricaoCargaHoraria.
     *
     * @return the current value of descricaoCargaHoraria
     */
    public String getDescricaoCargaHoraria() {
        return descricaoCargaHoraria;
    }

    /**
     * Setter method for descricaoCargaHoraria.
     *
     * @param aDescricaoCargaHoraria the new value for descricaoCargaHoraria
     */
    public void setDescricaoCargaHoraria(String aDescricaoCargaHoraria) {
        descricaoCargaHoraria = aDescricaoCargaHoraria;
    }

    /**
     * Access method for histFuncionariosCargaHoraria.
     *
     * @return the current value of histFuncionariosCargaHoraria
     */
    public Set<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHoraria() {
        return histFuncionariosCargaHoraria;
    }

    /**
     * Setter method for histFuncionariosCargaHoraria.
     *
     * @param aHistFuncionariosCargaHoraria the new value for histFuncionariosCargaHoraria
     */
    public void setHistFuncionariosCargaHoraria(Set<HistFuncionariosCargaHoraria> aHistFuncionariosCargaHoraria) {
        histFuncionariosCargaHoraria = aHistFuncionariosCargaHoraria;
    }

    /**
     * Compares the key for this instance with another CargaHorariaSemanal.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CargaHorariaSemanal and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CargaHorariaSemanal)) {
            return false;
        }
        CargaHorariaSemanal that = (CargaHorariaSemanal) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CargaHorariaSemanal.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CargaHorariaSemanal)) return false;
        return this.equalKeys(other) && ((CargaHorariaSemanal)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[CargaHorariaSemanal |");
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
