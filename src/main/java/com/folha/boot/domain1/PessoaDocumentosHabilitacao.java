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

@Entity(name="pessoa_documentos_habilitacao")
public class PessoaDocumentosHabilitacao implements Serializable {

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
    @Column(name="numero_registro", nullable=false, length=100)
    private String numeroRegistro;
    @Column(name="dt_emissao")
    private LocalDate dtEmissao;
    @Column(name="dt_validade")
    private LocalDate dtValidade;
    @Column(name="dt_primeira_habilitacao")
    private LocalDate dtPrimeiraHabilitacao;
    @ManyToOne
    @JoinColumn(name="id_habilitacao_categorias_fk")
    private HabilitacaoCategorias habilitacaoCategorias;
    @ManyToOne
    @JoinColumn(name="id_pessoa_fk")
    private Pessoa pessoa;

    /** Default constructor. */
    public PessoaDocumentosHabilitacao() {
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
     * Access method for numeroRegistro.
     *
     * @return the current value of numeroRegistro
     */
    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    /**
     * Setter method for numeroRegistro.
     *
     * @param aNumeroRegistro the new value for numeroRegistro
     */
    public void setNumeroRegistro(String aNumeroRegistro) {
        numeroRegistro = aNumeroRegistro;
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
     * Access method for dtPrimeiraHabilitacao.
     *
     * @return the current value of dtPrimeiraHabilitacao
     */
    public LocalDate getDtPrimeiraHabilitacao() {
        return dtPrimeiraHabilitacao;
    }

    /**
     * Setter method for dtPrimeiraHabilitacao.
     *
     * @param aDtPrimeiraHabilitacao the new value for dtPrimeiraHabilitacao
     */
    public void setDtPrimeiraHabilitacao(LocalDate aDtPrimeiraHabilitacao) {
        dtPrimeiraHabilitacao = aDtPrimeiraHabilitacao;
    }

    /**
     * Access method for habilitacaoCategorias.
     *
     * @return the current value of habilitacaoCategorias
     */
    public HabilitacaoCategorias getHabilitacaoCategorias() {
        return habilitacaoCategorias;
    }

    /**
     * Setter method for habilitacaoCategorias.
     *
     * @param aHabilitacaoCategorias the new value for habilitacaoCategorias
     */
    public void setHabilitacaoCategorias(HabilitacaoCategorias aHabilitacaoCategorias) {
        habilitacaoCategorias = aHabilitacaoCategorias;
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
     * Compares the key for this instance with another PessoaDocumentosHabilitacao.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaDocumentosHabilitacao and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaDocumentosHabilitacao)) {
            return false;
        }
        PessoaDocumentosHabilitacao that = (PessoaDocumentosHabilitacao) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaDocumentosHabilitacao.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaDocumentosHabilitacao)) return false;
        return this.equalKeys(other) && ((PessoaDocumentosHabilitacao)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaDocumentosHabilitacao |");
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
