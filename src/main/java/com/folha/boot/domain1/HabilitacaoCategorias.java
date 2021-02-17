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
@Table(name="habilitacao_categorias", indexes={@Index(name="habilitacao_categorias_nome_habilitacao_categoria_IX", columnList="nome_habilitacao_categoria", unique=true)})
public class HabilitacaoCategorias implements Serializable {

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
    @Column(name="nome_habilitacao_categoria", unique=true, nullable=false, length=30)
    private String nomeHabilitacaoCategoria;
    @Column(name="descricao_habilitacao_categoria", length=300)
    private String descricaoHabilitacaoCategoria;
    @OneToMany(mappedBy="habilitacaoCategorias")
    private Set<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacao;

    /** Default constructor. */
    public HabilitacaoCategorias() {
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
     * Access method for nomeHabilitacaoCategoria.
     *
     * @return the current value of nomeHabilitacaoCategoria
     */
    public String getNomeHabilitacaoCategoria() {
        return nomeHabilitacaoCategoria;
    }

    /**
     * Setter method for nomeHabilitacaoCategoria.
     *
     * @param aNomeHabilitacaoCategoria the new value for nomeHabilitacaoCategoria
     */
    public void setNomeHabilitacaoCategoria(String aNomeHabilitacaoCategoria) {
        nomeHabilitacaoCategoria = aNomeHabilitacaoCategoria;
    }

    /**
     * Access method for descricaoHabilitacaoCategoria.
     *
     * @return the current value of descricaoHabilitacaoCategoria
     */
    public String getDescricaoHabilitacaoCategoria() {
        return descricaoHabilitacaoCategoria;
    }

    /**
     * Setter method for descricaoHabilitacaoCategoria.
     *
     * @param aDescricaoHabilitacaoCategoria the new value for descricaoHabilitacaoCategoria
     */
    public void setDescricaoHabilitacaoCategoria(String aDescricaoHabilitacaoCategoria) {
        descricaoHabilitacaoCategoria = aDescricaoHabilitacaoCategoria;
    }

    /**
     * Access method for pessoaDocumentosHabilitacao.
     *
     * @return the current value of pessoaDocumentosHabilitacao
     */
    public Set<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacao() {
        return pessoaDocumentosHabilitacao;
    }

    /**
     * Setter method for pessoaDocumentosHabilitacao.
     *
     * @param aPessoaDocumentosHabilitacao the new value for pessoaDocumentosHabilitacao
     */
    public void setPessoaDocumentosHabilitacao(Set<PessoaDocumentosHabilitacao> aPessoaDocumentosHabilitacao) {
        pessoaDocumentosHabilitacao = aPessoaDocumentosHabilitacao;
    }

    /**
     * Compares the key for this instance with another HabilitacaoCategorias.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class HabilitacaoCategorias and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof HabilitacaoCategorias)) {
            return false;
        }
        HabilitacaoCategorias that = (HabilitacaoCategorias) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another HabilitacaoCategorias.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof HabilitacaoCategorias)) return false;
        return this.equalKeys(other) && ((HabilitacaoCategorias)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[HabilitacaoCategorias |");
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
