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
@Table(name="tipos_logradouro", indexes={@Index(name="tipos_logradouro_nome_tipo_logradouro_IX", columnList="nome_tipo_logradouro", unique=true)})
public class TiposLogradouro implements Serializable {

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
    @Column(name="nome_tipo_logradouro", unique=true, nullable=false, length=150)
    private String nomeTipoLogradouro;
    @Column(name="descricao_tipo_logradouro", length=300)
    private String descricaoTipoLogradouro;
    @OneToMany(mappedBy="tiposLogradouro")
    private Set<Enderecos> enderecos;
    @OneToMany(mappedBy="tiposLogradouro")
    private Set<Unidades> unidades;

    /** Default constructor. */
    public TiposLogradouro() {
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
     * Access method for nomeTipoLogradouro.
     *
     * @return the current value of nomeTipoLogradouro
     */
    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    /**
     * Setter method for nomeTipoLogradouro.
     *
     * @param aNomeTipoLogradouro the new value for nomeTipoLogradouro
     */
    public void setNomeTipoLogradouro(String aNomeTipoLogradouro) {
        nomeTipoLogradouro = aNomeTipoLogradouro;
    }

    /**
     * Access method for descricaoTipoLogradouro.
     *
     * @return the current value of descricaoTipoLogradouro
     */
    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    /**
     * Setter method for descricaoTipoLogradouro.
     *
     * @param aDescricaoTipoLogradouro the new value for descricaoTipoLogradouro
     */
    public void setDescricaoTipoLogradouro(String aDescricaoTipoLogradouro) {
        descricaoTipoLogradouro = aDescricaoTipoLogradouro;
    }

    /**
     * Access method for enderecos.
     *
     * @return the current value of enderecos
     */
    public Set<Enderecos> getEnderecos() {
        return enderecos;
    }

    /**
     * Setter method for enderecos.
     *
     * @param aEnderecos the new value for enderecos
     */
    public void setEnderecos(Set<Enderecos> aEnderecos) {
        enderecos = aEnderecos;
    }

    /**
     * Access method for unidades.
     *
     * @return the current value of unidades
     */
    public Set<Unidades> getUnidades() {
        return unidades;
    }

    /**
     * Setter method for unidades.
     *
     * @param aUnidades the new value for unidades
     */
    public void setUnidades(Set<Unidades> aUnidades) {
        unidades = aUnidades;
    }

    /**
     * Compares the key for this instance with another TiposLogradouro.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposLogradouro and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposLogradouro)) {
            return false;
        }
        TiposLogradouro that = (TiposLogradouro) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposLogradouro.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposLogradouro)) return false;
        return this.equalKeys(other) && ((TiposLogradouro)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[TiposLogradouro |");
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
