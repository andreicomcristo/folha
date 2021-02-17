// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="pessoa_documentos_titulo")
public class PessoaDocumentosTitulo implements Serializable {

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
    @Column(name="numero_titulo", nullable=false, length=100)
    private String numeroTitulo;
    @Column(length=100)
    private String zona;
    @Column(length=100)
    private String secao;
    @ManyToOne
    @JoinColumn(name="id_cidade_fk")
    private Cidades cidades;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;

    /** Default constructor. */
    public PessoaDocumentosTitulo() {
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
     * Access method for numeroTitulo.
     *
     * @return the current value of numeroTitulo
     */
    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    /**
     * Setter method for numeroTitulo.
     *
     * @param aNumeroTitulo the new value for numeroTitulo
     */
    public void setNumeroTitulo(String aNumeroTitulo) {
        numeroTitulo = aNumeroTitulo;
    }

    /**
     * Access method for zona.
     *
     * @return the current value of zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * Setter method for zona.
     *
     * @param aZona the new value for zona
     */
    public void setZona(String aZona) {
        zona = aZona;
    }

    /**
     * Access method for secao.
     *
     * @return the current value of secao
     */
    public String getSecao() {
        return secao;
    }

    /**
     * Setter method for secao.
     *
     * @param aSecao the new value for secao
     */
    public void setSecao(String aSecao) {
        secao = aSecao;
    }

    /**
     * Access method for cidades.
     *
     * @return the current value of cidades
     */
    public Cidades getCidades() {
        return cidades;
    }

    /**
     * Setter method for cidades.
     *
     * @param aCidades the new value for cidades
     */
    public void setCidades(Cidades aCidades) {
        cidades = aCidades;
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
     * Compares the key for this instance with another PessoaDocumentosTitulo.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaDocumentosTitulo and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaDocumentosTitulo)) {
            return false;
        }
        PessoaDocumentosTitulo that = (PessoaDocumentosTitulo) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaDocumentosTitulo.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaDocumentosTitulo)) return false;
        return this.equalKeys(other) && ((PessoaDocumentosTitulo)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaDocumentosTitulo |");
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
