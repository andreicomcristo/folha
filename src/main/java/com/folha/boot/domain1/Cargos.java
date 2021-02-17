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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="cargos", indexes={@Index(name="cargos_nome_cargo_IX", columnList="nome_cargo", unique=true)})
public class Cargos implements Serializable {

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
    @Column(name="nome_cargo", unique=true, length=150)
    private String nomeCargo;
    @Column(name="descricao_cargo", length=300)
    private String descricaoCargo;
    @OneToMany(mappedBy="cargos")
    private Set<CargosEspecialidade> cargosEspecialidade;
    @OneToMany(mappedBy="cargos")
    private Set<HistFuncionariosCargos> histFuncionariosCargos;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_nivel_cargo_fk", nullable=false)
    private NiveisCargo niveisCargo;

    /** Default constructor. */
    public Cargos() {
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
     * Access method for nomeCargo.
     *
     * @return the current value of nomeCargo
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * Setter method for nomeCargo.
     *
     * @param aNomeCargo the new value for nomeCargo
     */
    public void setNomeCargo(String aNomeCargo) {
        nomeCargo = aNomeCargo;
    }

    /**
     * Access method for descricaoCargo.
     *
     * @return the current value of descricaoCargo
     */
    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    /**
     * Setter method for descricaoCargo.
     *
     * @param aDescricaoCargo the new value for descricaoCargo
     */
    public void setDescricaoCargo(String aDescricaoCargo) {
        descricaoCargo = aDescricaoCargo;
    }

    /**
     * Access method for cargosEspecialidade.
     *
     * @return the current value of cargosEspecialidade
     */
    public Set<CargosEspecialidade> getCargosEspecialidade() {
        return cargosEspecialidade;
    }

    /**
     * Setter method for cargosEspecialidade.
     *
     * @param aCargosEspecialidade the new value for cargosEspecialidade
     */
    public void setCargosEspecialidade(Set<CargosEspecialidade> aCargosEspecialidade) {
        cargosEspecialidade = aCargosEspecialidade;
    }

    /**
     * Access method for histFuncionariosCargos.
     *
     * @return the current value of histFuncionariosCargos
     */
    public Set<HistFuncionariosCargos> getHistFuncionariosCargos() {
        return histFuncionariosCargos;
    }

    /**
     * Setter method for histFuncionariosCargos.
     *
     * @param aHistFuncionariosCargos the new value for histFuncionariosCargos
     */
    public void setHistFuncionariosCargos(Set<HistFuncionariosCargos> aHistFuncionariosCargos) {
        histFuncionariosCargos = aHistFuncionariosCargos;
    }

    /**
     * Access method for niveisCargo.
     *
     * @return the current value of niveisCargo
     */
    public NiveisCargo getNiveisCargo() {
        return niveisCargo;
    }

    /**
     * Setter method for niveisCargo.
     *
     * @param aNiveisCargo the new value for niveisCargo
     */
    public void setNiveisCargo(NiveisCargo aNiveisCargo) {
        niveisCargo = aNiveisCargo;
    }

    /**
     * Compares the key for this instance with another Cargos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Cargos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Cargos)) {
            return false;
        }
        Cargos that = (Cargos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Cargos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cargos)) return false;
        return this.equalKeys(other) && ((Cargos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Cargos |");
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
