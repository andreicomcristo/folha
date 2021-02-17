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

@Entity(name="pessoa_documentos_rg")
public class PessoaDocumentosRg implements Serializable {

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
    @Column(name="rg_numero", nullable=false, length=100)
    private String rgNumero;
    @Column(name="rg_orgao_emissor", length=100)
    private String rgOrgaoEmissor;
    @Column(name="dt_emissao")
    private LocalDate dtEmissao;
    @Column(name="id_pessoa_fk", nullable=false)
    private long idPessoaFk;
    @ManyToOne
    @JoinColumn(name="id_uf_emissao")
    private Uf uf;

    /** Default constructor. */
    public PessoaDocumentosRg() {
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
     * Access method for rgNumero.
     *
     * @return the current value of rgNumero
     */
    public String getRgNumero() {
        return rgNumero;
    }

    /**
     * Setter method for rgNumero.
     *
     * @param aRgNumero the new value for rgNumero
     */
    public void setRgNumero(String aRgNumero) {
        rgNumero = aRgNumero;
    }

    /**
     * Access method for rgOrgaoEmissor.
     *
     * @return the current value of rgOrgaoEmissor
     */
    public String getRgOrgaoEmissor() {
        return rgOrgaoEmissor;
    }

    /**
     * Setter method for rgOrgaoEmissor.
     *
     * @param aRgOrgaoEmissor the new value for rgOrgaoEmissor
     */
    public void setRgOrgaoEmissor(String aRgOrgaoEmissor) {
        rgOrgaoEmissor = aRgOrgaoEmissor;
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
     * Access method for idPessoaFk.
     *
     * @return the current value of idPessoaFk
     */
    public long getIdPessoaFk() {
        return idPessoaFk;
    }

    /**
     * Setter method for idPessoaFk.
     *
     * @param aIdPessoaFk the new value for idPessoaFk
     */
    public void setIdPessoaFk(long aIdPessoaFk) {
        idPessoaFk = aIdPessoaFk;
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
     * Compares the key for this instance with another PessoaDocumentosRg.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaDocumentosRg and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaDocumentosRg)) {
            return false;
        }
        PessoaDocumentosRg that = (PessoaDocumentosRg) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaDocumentosRg.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaDocumentosRg)) return false;
        return this.equalKeys(other) && ((PessoaDocumentosRg)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaDocumentosRg |");
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
