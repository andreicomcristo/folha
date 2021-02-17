// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.time.LocalDate;
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

@Entity(name="autorizacoes")
public class Autorizacoes implements Serializable {

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
    @Column(name="dt_inicio")
    private LocalDate dtInicio;
    @Column(name="dt_fim")
    private LocalDate dtFim;
    @Column(name="id_carga_horaria_semanal_fk", nullable=false)
    private long idCargaHorariaSemanalFk;
    @Column(name="dt_criacao", nullable=false)
    private LocalDate dtCriacao;
    @OneToMany(mappedBy="autorizacoes")
    private Set<HistFuncionariosAutorizacao> histFuncionariosAutorizacao;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_funcionario_fk", nullable=false)
    private PessoaFuncionarios pessoaFuncionarios;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_operador_criacao_fk", nullable=false)
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_unidade_de_saude_fk")
    private Unidades unidades;

    /** Default constructor. */
    public Autorizacoes() {
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
     * Access method for dtInicio.
     *
     * @return the current value of dtInicio
     */
    public LocalDate getDtInicio() {
        return dtInicio;
    }

    /**
     * Setter method for dtInicio.
     *
     * @param aDtInicio the new value for dtInicio
     */
    public void setDtInicio(LocalDate aDtInicio) {
        dtInicio = aDtInicio;
    }

    /**
     * Access method for dtFim.
     *
     * @return the current value of dtFim
     */
    public LocalDate getDtFim() {
        return dtFim;
    }

    /**
     * Setter method for dtFim.
     *
     * @param aDtFim the new value for dtFim
     */
    public void setDtFim(LocalDate aDtFim) {
        dtFim = aDtFim;
    }

    /**
     * Access method for idCargaHorariaSemanalFk.
     *
     * @return the current value of idCargaHorariaSemanalFk
     */
    public long getIdCargaHorariaSemanalFk() {
        return idCargaHorariaSemanalFk;
    }

    /**
     * Setter method for idCargaHorariaSemanalFk.
     *
     * @param aIdCargaHorariaSemanalFk the new value for idCargaHorariaSemanalFk
     */
    public void setIdCargaHorariaSemanalFk(long aIdCargaHorariaSemanalFk) {
        idCargaHorariaSemanalFk = aIdCargaHorariaSemanalFk;
    }

    /**
     * Access method for dtCriacao.
     *
     * @return the current value of dtCriacao
     */
    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    /**
     * Setter method for dtCriacao.
     *
     * @param aDtCriacao the new value for dtCriacao
     */
    public void setDtCriacao(LocalDate aDtCriacao) {
        dtCriacao = aDtCriacao;
    }

    /**
     * Access method for histFuncionariosAutorizacao.
     *
     * @return the current value of histFuncionariosAutorizacao
     */
    public Set<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacao() {
        return histFuncionariosAutorizacao;
    }

    /**
     * Setter method for histFuncionariosAutorizacao.
     *
     * @param aHistFuncionariosAutorizacao the new value for histFuncionariosAutorizacao
     */
    public void setHistFuncionariosAutorizacao(Set<HistFuncionariosAutorizacao> aHistFuncionariosAutorizacao) {
        histFuncionariosAutorizacao = aHistFuncionariosAutorizacao;
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
     * Compares the key for this instance with another Autorizacoes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Autorizacoes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Autorizacoes)) {
            return false;
        }
        Autorizacoes that = (Autorizacoes) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Autorizacoes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Autorizacoes)) return false;
        return this.equalKeys(other) && ((Autorizacoes)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Autorizacoes |");
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
