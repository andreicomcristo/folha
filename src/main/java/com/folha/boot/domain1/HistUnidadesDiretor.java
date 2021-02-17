// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="hist_unidades_diretor")
@IdClass(HistUnidadesDiretor.HistUnidadesDiretorId.class)
public class HistUnidadesDiretor implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class HistUnidadesDiretorId implements Serializable {
        long id;
        Unidades unidades;
        Pessoa pessoa;
        PessoaOperadores pessoaOperadores;
        java.time.LocalDate dtCadastro;
    }

    /** Primary key. */
    protected static final String PK = "HistUnidadesDiretorHistUnidadesDeSaudeDiretorPkey";

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
    @Column(nullable=false)
    private long id;
    @Id
    @Column(name="dt_cadastro", nullable=false)
    private LocalDate dtCadastro;
    @Column(name="motivo_cadastro", length=300)
    private String motivoCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="motivo_cancelamento", length=300)
    private String motivoCancelamento;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="id_operador_cadastro_fk", nullable=false)
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_operador_cancelamento_fk")
    private PessoaOperadores pessoaOperadores2;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="id_unidade_de_saude_fk", nullable=false)
    private Unidades unidades;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;

    /** Default constructor. */
    public HistUnidadesDiretor() {
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
     * Access method for dtCadastro.
     *
     * @return the current value of dtCadastro
     */
    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Setter method for dtCadastro.
     *
     * @param aDtCadastro the new value for dtCadastro
     */
    public void setDtCadastro(LocalDate aDtCadastro) {
        dtCadastro = aDtCadastro;
    }

    /**
     * Access method for motivoCadastro.
     *
     * @return the current value of motivoCadastro
     */
    public String getMotivoCadastro() {
        return motivoCadastro;
    }

    /**
     * Setter method for motivoCadastro.
     *
     * @param aMotivoCadastro the new value for motivoCadastro
     */
    public void setMotivoCadastro(String aMotivoCadastro) {
        motivoCadastro = aMotivoCadastro;
    }

    /**
     * Access method for dtCancelamento.
     *
     * @return the current value of dtCancelamento
     */
    public LocalDate getDtCancelamento() {
        return dtCancelamento;
    }

    /**
     * Setter method for dtCancelamento.
     *
     * @param aDtCancelamento the new value for dtCancelamento
     */
    public void setDtCancelamento(LocalDate aDtCancelamento) {
        dtCancelamento = aDtCancelamento;
    }

    /**
     * Access method for motivoCancelamento.
     *
     * @return the current value of motivoCancelamento
     */
    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    /**
     * Setter method for motivoCancelamento.
     *
     * @param aMotivoCancelamento the new value for motivoCancelamento
     */
    public void setMotivoCancelamento(String aMotivoCancelamento) {
        motivoCancelamento = aMotivoCancelamento;
    }

    /**
     * Access method for pessoaOperadores.
     *
     * @return the current value of pessoaOperadores
     */
    public PessoaOperadores getPessoaOperadores() {
        return pessoaOperadores;
    }

    /**
     * Setter method for pessoaOperadores.
     *
     * @param aPessoaOperadores the new value for pessoaOperadores
     */
    public void setPessoaOperadores(PessoaOperadores aPessoaOperadores) {
        pessoaOperadores = aPessoaOperadores;
    }

    /**
     * Access method for pessoaOperadores2.
     *
     * @return the current value of pessoaOperadores2
     */
    public PessoaOperadores getPessoaOperadores2() {
        return pessoaOperadores2;
    }

    /**
     * Setter method for pessoaOperadores2.
     *
     * @param aPessoaOperadores2 the new value for pessoaOperadores2
     */
    public void setPessoaOperadores2(PessoaOperadores aPessoaOperadores2) {
        pessoaOperadores2 = aPessoaOperadores2;
    }

    /**
     * Access method for unidades.
     *
     * @return the current value of unidades
     */
    public Unidades getUnidades() {
        return unidades;
    }

    /**
     * Setter method for unidades.
     *
     * @param aUnidades the new value for unidades
     */
    public void setUnidades(Unidades aUnidades) {
        unidades = aUnidades;
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

    /** Temporary value holder for group key fragment unidadesId */
    private transient long tempUnidadesId;

    /**
     * Gets the key fragment id for member unidades.
     * If this.unidades is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setUnidadesId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Unidades
     */
    public long getUnidadesId() {
        return (getUnidades() == null ? tempUnidadesId : getUnidades().getId());
    }

    /**
     * Sets the key fragment id from member unidades.
     * If this.unidades is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getUnidadesId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Unidades
     */
    public void setUnidadesId(long aId) {
        if (getUnidades() == null) {
            tempUnidadesId = aId;
        } else {
            getUnidades().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment pessoaId */
    private transient long tempPessoaId;

    /**
     * Gets the key fragment id for member pessoa.
     * If this.pessoa is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPessoaId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Pessoa
     */
    public long getPessoaId() {
        return (getPessoa() == null ? tempPessoaId : getPessoa().getId());
    }

    /**
     * Sets the key fragment id from member pessoa.
     * If this.pessoa is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPessoaId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Pessoa
     */
    public void setPessoaId(long aId) {
        if (getPessoa() == null) {
            tempPessoaId = aId;
        } else {
            getPessoa().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment pessoaOperadoresId */
    private transient long tempPessoaOperadoresId;

    /**
     * Gets the key fragment id for member pessoaOperadores.
     * If this.pessoaOperadores is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPessoaOperadoresId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see PessoaOperadores
     */
    public long getPessoaOperadoresId() {
        return (getPessoaOperadores() == null ? tempPessoaOperadoresId : getPessoaOperadores().getId());
    }

    /**
     * Sets the key fragment id from member pessoaOperadores.
     * If this.pessoaOperadores is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPessoaOperadoresId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see PessoaOperadores
     */
    public void setPessoaOperadoresId(long aId) {
        if (getPessoaOperadores() == null) {
            tempPessoaOperadoresId = aId;
        } else {
            getPessoaOperadores().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another HistUnidadesDiretor.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class HistUnidadesDiretor and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof HistUnidadesDiretor)) {
            return false;
        }
        HistUnidadesDiretor that = (HistUnidadesDiretor) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        if (this.getUnidadesId() != that.getUnidadesId()) {
            return false;
        }
        if (this.getPessoaId() != that.getPessoaId()) {
            return false;
        }
        if (this.getPessoaOperadoresId() != that.getPessoaOperadoresId()) {
            return false;
        }
        Object myDtCadastro = this.getDtCadastro();
        Object yourDtCadastro = that.getDtCadastro();
        if (myDtCadastro==null ? yourDtCadastro!=null : !myDtCadastro.equals(yourDtCadastro)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another HistUnidadesDiretor.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof HistUnidadesDiretor)) return false;
        return this.equalKeys(other) && ((HistUnidadesDiretor)other).equalKeys(this);
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
        i = (int)(getUnidadesId() ^ (getUnidadesId()>>>32));
        result = 37*result + i;
        i = (int)(getPessoaId() ^ (getPessoaId()>>>32));
        result = 37*result + i;
        i = (int)(getPessoaOperadoresId() ^ (getPessoaOperadoresId()>>>32));
        result = 37*result + i;
        if (getDtCadastro() == null) {
            i = 0;
        } else {
            i = getDtCadastro().hashCode();
        }
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
        StringBuffer sb = new StringBuffer("[HistUnidadesDiretor |");
        sb.append(" id=").append(getId());
        sb.append(" unidadesId=").append(getUnidadesId());
        sb.append(" pessoaId=").append(getPessoaId());
        sb.append(" pessoaOperadoresId=").append(getPessoaOperadoresId());
        sb.append(" dtCadastro=").append(getDtCadastro());
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
        ret.put("unidadesId", Long.valueOf(getUnidadesId()));
        ret.put("pessoaId", Long.valueOf(getPessoaId()));
        ret.put("pessoaOperadoresId", Long.valueOf(getPessoaOperadoresId()));
        ret.put("dtCadastro", getDtCadastro());
        return ret;
    }

}
