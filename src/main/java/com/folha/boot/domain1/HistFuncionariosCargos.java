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

@Entity(name="hist_funcionarios_cargos")
public class HistFuncionariosCargos implements Serializable {

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
    @Column(name="dt_cadastro", nullable=false)
    private LocalDate dtCadastro;
    @Column(name="motivo_cadastro", length=300)
    private String motivoCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="motivo_cancelamento", length=300)
    private String motivoCancelamento;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_cargo_fk", nullable=false)
    private Cargos cargos;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_funcionario_fk", nullable=false)
    private PessoaFuncionarios pessoaFuncionarios;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_operador_cadastro_fk", nullable=false)
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_operador_cancelamento_fk")
    private PessoaOperadores pessoaOperadores2;

    /** Default constructor. */
    public HistFuncionariosCargos() {
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
     * Access method for cargos.
     *
     * @return the current value of cargos
     */
    public Cargos getCargos() {
        return cargos;
    }

    /**
     * Setter method for cargos.
     *
     * @param aCargos the new value for cargos
     */
    public void setCargos(Cargos aCargos) {
        cargos = aCargos;
    }

    /**
     * Access method for pessoaFuncionarios.
     *
     * @return the current value of pessoaFuncionarios
     */
    public PessoaFuncionarios getPessoaFuncionarios() {
        return pessoaFuncionarios;
    }

    /**
     * Setter method for pessoaFuncionarios.
     *
     * @param aPessoaFuncionarios the new value for pessoaFuncionarios
     */
    public void setPessoaFuncionarios(PessoaFuncionarios aPessoaFuncionarios) {
        pessoaFuncionarios = aPessoaFuncionarios;
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
     * Compares the key for this instance with another HistFuncionariosCargos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class HistFuncionariosCargos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof HistFuncionariosCargos)) {
            return false;
        }
        HistFuncionariosCargos that = (HistFuncionariosCargos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another HistFuncionariosCargos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof HistFuncionariosCargos)) return false;
        return this.equalKeys(other) && ((HistFuncionariosCargos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[HistFuncionariosCargos |");
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
