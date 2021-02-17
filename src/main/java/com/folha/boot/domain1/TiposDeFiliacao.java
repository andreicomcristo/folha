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
@Table(name="tipos_de_filiacao", indexes={@Index(name="tipos_de_filiacao_nome_tipo_filiacao_IX", columnList="nome_tipo_filiacao", unique=true)})
public class TiposDeFiliacao implements Serializable {

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
    @Column(name="nome_tipo_filiacao", unique=true, nullable=false, length=150)
    private String nomeTipoFiliacao;
    @Column(name="descricao_tipo_filiacao", length=300)
    private String descricaoTipoFiliacao;
    @OneToMany(mappedBy="tiposDeFiliacao")
    private Set<PessoaFilhos> pessoaFilhos;

    /** Default constructor. */
    public TiposDeFiliacao() {
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
     * Access method for nomeTipoFiliacao.
     *
     * @return the current value of nomeTipoFiliacao
     */
    public String getNomeTipoFiliacao() {
        return nomeTipoFiliacao;
    }

    /**
     * Setter method for nomeTipoFiliacao.
     *
     * @param aNomeTipoFiliacao the new value for nomeTipoFiliacao
     */
    public void setNomeTipoFiliacao(String aNomeTipoFiliacao) {
        nomeTipoFiliacao = aNomeTipoFiliacao;
    }

    /**
     * Access method for descricaoTipoFiliacao.
     *
     * @return the current value of descricaoTipoFiliacao
     */
    public String getDescricaoTipoFiliacao() {
        return descricaoTipoFiliacao;
    }

    /**
     * Setter method for descricaoTipoFiliacao.
     *
     * @param aDescricaoTipoFiliacao the new value for descricaoTipoFiliacao
     */
    public void setDescricaoTipoFiliacao(String aDescricaoTipoFiliacao) {
        descricaoTipoFiliacao = aDescricaoTipoFiliacao;
    }

    /**
     * Access method for pessoaFilhos.
     *
     * @return the current value of pessoaFilhos
     */
    public Set<PessoaFilhos> getPessoaFilhos() {
        return pessoaFilhos;
    }

    /**
     * Setter method for pessoaFilhos.
     *
     * @param aPessoaFilhos the new value for pessoaFilhos
     */
    public void setPessoaFilhos(Set<PessoaFilhos> aPessoaFilhos) {
        pessoaFilhos = aPessoaFilhos;
    }

    /**
     * Compares the key for this instance with another TiposDeFiliacao.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposDeFiliacao and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposDeFiliacao)) {
            return false;
        }
        TiposDeFiliacao that = (TiposDeFiliacao) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposDeFiliacao.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposDeFiliacao)) return false;
        return this.equalKeys(other) && ((TiposDeFiliacao)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[TiposDeFiliacao |");
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
