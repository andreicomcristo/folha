// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="pessoa_documentos_conselho")
public class PessoaDocumentosConselho implements Serializable {

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
    @Column(name="numero_conselho", nullable=false, length=100)
    private String numeroConselho;
    @Column(name="dt_emissao")
    private LocalDate dtEmissao;
    @Column(name="dt_validade")
    private LocalDate dtValidade;
    @ManyToOne
    @JoinColumn(name="id_conselhos_fk")
    private Conselhos conselhos;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name="id_uf_fk")
    private Uf uf;

    /** Default constructor. */
    public PessoaDocumentosConselho() {
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
     * Access method for numeroConselho.
     *
     * @return the current value of numeroConselho
     */
    public String getNumeroConselho() {
        return numeroConselho;
    }

    /**
     * Setter method for numeroConselho.
     *
     * @param aNumeroConselho the new value for numeroConselho
     */
    public void setNumeroConselho(String aNumeroConselho) {
        numeroConselho = aNumeroConselho;
    }

    /**
     * Access method for dtEmissao.
     *
     * @return the current value of dtEmissao
     */
    public LocalDate getDtEmissao() {
        return dtEmissao;
    }

    /**
     * Setter method for dtEmissao.
     *
     * @param aDtEmissao the new value for dtEmissao
     */
    public void setDtEmissao(LocalDate aDtEmissao) {
        dtEmissao = aDtEmissao;
    }

    /**
     * Access method for dtValidade.
     *
     * @return the current value of dtValidade
     */
    public LocalDate getDtValidade() {
        return dtValidade;
    }

    /**
     * Setter method for dtValidade.
     *
     * @param aDtValidade the new value for dtValidade
     */
    public void setDtValidade(LocalDate aDtValidade) {
        dtValidade = aDtValidade;
    }

    /**
     * Access method for conselhos.
     *
     * @return the current value of conselhos
     */
    public Conselhos getConselhos() {
        return conselhos;
    }

    /**
     * Setter method for conselhos.
     *
     * @param aConselhos the new value for conselhos
     */
    public void setConselhos(Conselhos aConselhos) {
        conselhos = aConselhos;
    }

    /**
     * Access method for pessoa.
     *
     * @return the current value of pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Setter method for pessoa.
     *
     * @param aPessoa the new value for pessoa
     */
    public void setPessoa(Pessoa aPessoa) {
        pessoa = aPessoa;
    }

    /**
     * Access method for uf.
     *
     * @return the current value of uf
     */
    public Uf getUf() {
        return uf;
    }

    /**
     * Setter method for uf.
     *
     * @param aUf the new value for uf
     */
    public void setUf(Uf aUf) {
        uf = aUf;
    }

    /**
     * Compares the key for this instance with another PessoaDocumentosConselho.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaDocumentosConselho and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaDocumentosConselho)) {
            return false;
        }
        PessoaDocumentosConselho that = (PessoaDocumentosConselho) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaDocumentosConselho.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaDocumentosConselho)) return false;
        return this.equalKeys(other) && ((PessoaDocumentosConselho)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaDocumentosConselho |");
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
