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

@Entity(name="enderecos")
public class Enderecos implements Serializable {

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
    @Column(name="endereco_logradouro", nullable=false, length=300)
    private String enderecoLogradouro;
    @Column(name="endereco_numero", length=20)
    private String enderecoNumero;
    @Column(name="endereco_complemento", length=300)
    private String enderecoComplemento;
    @Column(name="endereco_bairro", length=300)
    private String enderecoBairro;
    @Column(name="endereco_cep", length=20)
    private String enderecoCep;
    @OneToMany(mappedBy="enderecos2")
    private Set<Pessoa> pessoa2;
    @ManyToOne
    @JoinColumn(name="id_endereco_cidade_fk")
    private Cidades cidades;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_tipo_logradouro_fk", nullable=false)
    private TiposLogradouro tiposLogradouro;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;

    /** Default constructor. */
    public Enderecos() {
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
     * Access method for enderecoLogradouro.
     *
     * @return the current value of enderecoLogradouro
     */
    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    /**
     * Setter method for enderecoLogradouro.
     *
     * @param aEnderecoLogradouro the new value for enderecoLogradouro
     */
    public void setEnderecoLogradouro(String aEnderecoLogradouro) {
        enderecoLogradouro = aEnderecoLogradouro;
    }

    /**
     * Access method for enderecoNumero.
     *
     * @return the current value of enderecoNumero
     */
    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    /**
     * Setter method for enderecoNumero.
     *
     * @param aEnderecoNumero the new value for enderecoNumero
     */
    public void setEnderecoNumero(String aEnderecoNumero) {
        enderecoNumero = aEnderecoNumero;
    }

    /**
     * Access method for enderecoComplemento.
     *
     * @return the current value of enderecoComplemento
     */
    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    /**
     * Setter method for enderecoComplemento.
     *
     * @param aEnderecoComplemento the new value for enderecoComplemento
     */
    public void setEnderecoComplemento(String aEnderecoComplemento) {
        enderecoComplemento = aEnderecoComplemento;
    }

    /**
     * Access method for enderecoBairro.
     *
     * @return the current value of enderecoBairro
     */
    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    /**
     * Setter method for enderecoBairro.
     *
     * @param aEnderecoBairro the new value for enderecoBairro
     */
    public void setEnderecoBairro(String aEnderecoBairro) {
        enderecoBairro = aEnderecoBairro;
    }

    /**
     * Access method for enderecoCep.
     *
     * @return the current value of enderecoCep
     */
    public String getEnderecoCep() {
        return enderecoCep;
    }

    /**
     * Setter method for enderecoCep.
     *
     * @param aEnderecoCep the new value for enderecoCep
     */
    public void setEnderecoCep(String aEnderecoCep) {
        enderecoCep = aEnderecoCep;
    }

    /**
     * Access method for pessoa2.
     *
     * @return the current value of pessoa2
     */
    public Set<Pessoa> getPessoa2() {
        return pessoa2;
    }

    /**
     * Setter method for pessoa2.
     *
     * @param aPessoa2 the new value for pessoa2
     */
    public void setPessoa2(Set<Pessoa> aPessoa2) {
        pessoa2 = aPessoa2;
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
     * Access method for tiposLogradouro.
     *
     * @return the current value of tiposLogradouro
     */
    public TiposLogradouro getTiposLogradouro() {
        return tiposLogradouro;
    }

    /**
     * Setter method for tiposLogradouro.
     *
     * @param aTiposLogradouro the new value for tiposLogradouro
     */
    public void setTiposLogradouro(TiposLogradouro aTiposLogradouro) {
        tiposLogradouro = aTiposLogradouro;
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
     * Compares the key for this instance with another Enderecos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Enderecos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Enderecos)) {
            return false;
        }
        Enderecos that = (Enderecos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Enderecos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Enderecos)) return false;
        return this.equalKeys(other) && ((Enderecos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Enderecos |");
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
