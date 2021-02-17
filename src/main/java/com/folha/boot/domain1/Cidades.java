// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="cidades")
public class Cidades implements Serializable {

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
    @Column(name="nome_cidade", nullable=false, length=150)
    private String nomeCidade;
    @OneToMany(mappedBy="cidades")
    private Set<Pessoa> pessoa;
    @OneToMany(mappedBy="cidades")
    private Set<Enderecos> enderecos;
    @OneToMany(mappedBy="cidades")
    private Set<Unidades> unidades;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pais_fk", nullable=false)
    private Paises paises;
    @OneToMany(mappedBy="cidades")
    private Set<PessoaDocumentosTitulo> pessoaDocumentosTitulo;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_uf_fk", nullable=false)
    private Uf uf;

    /** Default constructor. */
    public Cidades() {
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
     * Access method for nomeCidade.
     *
     * @return the current value of nomeCidade
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * Setter method for nomeCidade.
     *
     * @param aNomeCidade the new value for nomeCidade
     */
    public void setNomeCidade(String aNomeCidade) {
        nomeCidade = aNomeCidade;
    }

    /**
     * Access method for pessoa.
     *
     * @return the current value of pessoa
     */
    public Set<Pessoa> getPessoa() {
        return pessoa;
    }

    /**
     * Setter method for pessoa.
     *
     * @param aPessoa the new value for pessoa
     */
    public void setPessoa(Set<Pessoa> aPessoa) {
        pessoa = aPessoa;
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
     * Access method for paises.
     *
     * @return the current value of paises
     */
    public Paises getPaises() {
        return paises;
    }

    /**
     * Setter method for paises.
     *
     * @param aPaises the new value for paises
     */
    public void setPaises(Paises aPaises) {
        paises = aPaises;
    }

    /**
     * Access method for pessoaDocumentosTitulo.
     *
     * @return the current value of pessoaDocumentosTitulo
     */
    public Set<PessoaDocumentosTitulo> getPessoaDocumentosTitulo() {
        return pessoaDocumentosTitulo;
    }

    /**
     * Setter method for pessoaDocumentosTitulo.
     *
     * @param aPessoaDocumentosTitulo the new value for pessoaDocumentosTitulo
     */
    public void setPessoaDocumentosTitulo(Set<PessoaDocumentosTitulo> aPessoaDocumentosTitulo) {
        pessoaDocumentosTitulo = aPessoaDocumentosTitulo;
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
     * Compares the key for this instance with another Cidades.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Cidades and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Cidades)) {
            return false;
        }
        Cidades that = (Cidades) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Cidades.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cidades)) return false;
        return this.equalKeys(other) && ((Cidades)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Cidades |");
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
