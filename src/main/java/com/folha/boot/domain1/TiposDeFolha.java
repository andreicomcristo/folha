// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="tipos_de_folha")
public class TiposDeFolha implements Serializable {

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
    @Column(name="nome_tipo_folha", nullable=false, length=300)
    private String nomeTipoFolha;
    @Column(name="descricao_tipo_folha", length=300)
    private String descricaoTipoFolha;
    @Column(name="nome_tipo_filha", nullable=false, length=300)
    private String nomeTipoFilha;

    /** Default constructor. */
    public TiposDeFolha() {
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
     * Access method for nomeTipoFolha.
     *
     * @return the current value of nomeTipoFolha
     */
    public String getNomeTipoFolha() {
        return nomeTipoFolha;
    }

    /**
     * Setter method for nomeTipoFolha.
     *
     * @param aNomeTipoFolha the new value for nomeTipoFolha
     */
    public void setNomeTipoFolha(String aNomeTipoFolha) {
        nomeTipoFolha = aNomeTipoFolha;
    }

    /**
     * Access method for descricaoTipoFolha.
     *
     * @return the current value of descricaoTipoFolha
     */
    public String getDescricaoTipoFolha() {
        return descricaoTipoFolha;
    }

    /**
     * Setter method for descricaoTipoFolha.
     *
     * @param aDescricaoTipoFolha the new value for descricaoTipoFolha
     */
    public void setDescricaoTipoFolha(String aDescricaoTipoFolha) {
        descricaoTipoFolha = aDescricaoTipoFolha;
    }

    /**
     * Access method for nomeTipoFilha.
     *
     * @return the current value of nomeTipoFilha
     */
    public String getNomeTipoFilha() {
        return nomeTipoFilha;
    }

    /**
     * Setter method for nomeTipoFilha.
     *
     * @param aNomeTipoFilha the new value for nomeTipoFilha
     */
    public void setNomeTipoFilha(String aNomeTipoFilha) {
        nomeTipoFilha = aNomeTipoFilha;
    }

    /**
     * Compares the key for this instance with another TiposDeFolha.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposDeFolha and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposDeFolha)) {
            return false;
        }
        TiposDeFolha that = (TiposDeFolha) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposDeFolha.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposDeFolha)) return false;
        return this.equalKeys(other) && ((TiposDeFolha)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[TiposDeFolha |");
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
