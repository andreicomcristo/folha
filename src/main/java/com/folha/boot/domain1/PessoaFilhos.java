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

@Entity(name="pessoa_filhos")
public class PessoaFilhos implements Serializable {

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
    @Column(name="nome_filho", nullable=false, length=300)
    private String nomeFilho;
    @Column(name="dt_nascimento")
    private LocalDate dtNascimento;
    @Column(name="cpf_filho", length=20)
    private String cpfFilho;
    @Column(name="rg_filho", length=30)
    private String rgFilho;
    @Column(name="rg_dt_emissao_filho")
    private LocalDate rgDtEmissaoFilho;
    @Column(name="rg_orgao_expedidor", length=150)
    private String rgOrgaoExpedidor;
    @Column(name="numero_certidao_nascimento", length=150)
    private String numeroCertidaoNascimento;
    @Column(name="dt_certidado_nascimento")
    private LocalDate dtCertidadoNascimento;
    @Column(name="cartorio_certidado_nascimento", length=150)
    private String cartorioCertidadoNascimento;
    @Column(name="livro_certidao_nascimento", length=150)
    private String livroCertidaoNascimento;
    @Column(name="folha_certidao_nascimento", length=150)
    private String folhaCertidaoNascimento;
    @Column(name="dt_cadastro")
    private LocalDate dtCadastro;
    @Column(name="motivo_cadastro", length=300)
    private String motivoCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="motivo_cancelamento", length=300)
    private String motivoCancelamento;
    @ManyToOne
    @JoinColumn(name="id_operador_cadastro_fk")
    private PessoaOperadores pessoaOperadores;
    @ManyToOne
    @JoinColumn(name="id_operador_cancelamento_fk")
    private PessoaOperadores pessoaOperadores2;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_pessoa_fk", nullable=false)
    private Pessoa pessoa;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_tipo_filiacao_fk", nullable=false)
    private TiposDeFiliacao tiposDeFiliacao;

    /** Default constructor. */
    public PessoaFilhos() {
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
     * Access method for nomeFilho.
     *
     * @return the current value of nomeFilho
     */
    public String getNomeFilho() {
        return nomeFilho;
    }

    /**
     * Setter method for nomeFilho.
     *
     * @param aNomeFilho the new value for nomeFilho
     */
    public void setNomeFilho(String aNomeFilho) {
        nomeFilho = aNomeFilho;
    }

    /**
     * Access method for dtNascimento.
     *
     * @return the current value of dtNascimento
     */
    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    /**
     * Setter method for dtNascimento.
     *
     * @param aDtNascimento the new value for dtNascimento
     */
    public void setDtNascimento(LocalDate aDtNascimento) {
        dtNascimento = aDtNascimento;
    }

    /**
     * Access method for cpfFilho.
     *
     * @return the current value of cpfFilho
     */
    public String getCpfFilho() {
        return cpfFilho;
    }

    /**
     * Setter method for cpfFilho.
     *
     * @param aCpfFilho the new value for cpfFilho
     */
    public void setCpfFilho(String aCpfFilho) {
        cpfFilho = aCpfFilho;
    }

    /**
     * Access method for rgFilho.
     *
     * @return the current value of rgFilho
     */
    public String getRgFilho() {
        return rgFilho;
    }

    /**
     * Setter method for rgFilho.
     *
     * @param aRgFilho the new value for rgFilho
     */
    public void setRgFilho(String aRgFilho) {
        rgFilho = aRgFilho;
    }

    /**
     * Access method for rgDtEmissaoFilho.
     *
     * @return the current value of rgDtEmissaoFilho
     */
    public LocalDate getRgDtEmissaoFilho() {
        return rgDtEmissaoFilho;
    }

    /**
     * Setter method for rgDtEmissaoFilho.
     *
     * @param aRgDtEmissaoFilho the new value for rgDtEmissaoFilho
     */
    public void setRgDtEmissaoFilho(LocalDate aRgDtEmissaoFilho) {
        rgDtEmissaoFilho = aRgDtEmissaoFilho;
    }

    /**
     * Access method for rgOrgaoExpedidor.
     *
     * @return the current value of rgOrgaoExpedidor
     */
    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    /**
     * Setter method for rgOrgaoExpedidor.
     *
     * @param aRgOrgaoExpedidor the new value for rgOrgaoExpedidor
     */
    public void setRgOrgaoExpedidor(String aRgOrgaoExpedidor) {
        rgOrgaoExpedidor = aRgOrgaoExpedidor;
    }

    /**
     * Access method for numeroCertidaoNascimento.
     *
     * @return the current value of numeroCertidaoNascimento
     */
    public String getNumeroCertidaoNascimento() {
        return numeroCertidaoNascimento;
    }

    /**
     * Setter method for numeroCertidaoNascimento.
     *
     * @param aNumeroCertidaoNascimento the new value for numeroCertidaoNascimento
     */
    public void setNumeroCertidaoNascimento(String aNumeroCertidaoNascimento) {
        numeroCertidaoNascimento = aNumeroCertidaoNascimento;
    }

    /**
     * Access method for dtCertidadoNascimento.
     *
     * @return the current value of dtCertidadoNascimento
     */
    public LocalDate getDtCertidadoNascimento() {
        return dtCertidadoNascimento;
    }

    /**
     * Setter method for dtCertidadoNascimento.
     *
     * @param aDtCertidadoNascimento the new value for dtCertidadoNascimento
     */
    public void setDtCertidadoNascimento(LocalDate aDtCertidadoNascimento) {
        dtCertidadoNascimento = aDtCertidadoNascimento;
    }

    /**
     * Access method for cartorioCertidadoNascimento.
     *
     * @return the current value of cartorioCertidadoNascimento
     */
    public String getCartorioCertidadoNascimento() {
        return cartorioCertidadoNascimento;
    }

    /**
     * Setter method for cartorioCertidadoNascimento.
     *
     * @param aCartorioCertidadoNascimento the new value for cartorioCertidadoNascimento
     */
    public void setCartorioCertidadoNascimento(String aCartorioCertidadoNascimento) {
        cartorioCertidadoNascimento = aCartorioCertidadoNascimento;
    }

    /**
     * Access method for livroCertidaoNascimento.
     *
     * @return the current value of livroCertidaoNascimento
     */
    public String getLivroCertidaoNascimento() {
        return livroCertidaoNascimento;
    }

    /**
     * Setter method for livroCertidaoNascimento.
     *
     * @param aLivroCertidaoNascimento the new value for livroCertidaoNascimento
     */
    public void setLivroCertidaoNascimento(String aLivroCertidaoNascimento) {
        livroCertidaoNascimento = aLivroCertidaoNascimento;
    }

    /**
     * Access method for folhaCertidaoNascimento.
     *
     * @return the current value of folhaCertidaoNascimento
     */
    public String getFolhaCertidaoNascimento() {
        return folhaCertidaoNascimento;
    }

    /**
     * Setter method for folhaCertidaoNascimento.
     *
     * @param aFolhaCertidaoNascimento the new value for folhaCertidaoNascimento
     */
    public void setFolhaCertidaoNascimento(String aFolhaCertidaoNascimento) {
        folhaCertidaoNascimento = aFolhaCertidaoNascimento;
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
     * Access method for tiposDeFiliacao.
     *
     * @return the current value of tiposDeFiliacao
     */
    public TiposDeFiliacao getTiposDeFiliacao() {
        return tiposDeFiliacao;
    }

    /**
     * Setter method for tiposDeFiliacao.
     *
     * @param aTiposDeFiliacao the new value for tiposDeFiliacao
     */
    public void setTiposDeFiliacao(TiposDeFiliacao aTiposDeFiliacao) {
        tiposDeFiliacao = aTiposDeFiliacao;
    }

    /**
     * Compares the key for this instance with another PessoaFilhos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PessoaFilhos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PessoaFilhos)) {
            return false;
        }
        PessoaFilhos that = (PessoaFilhos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PessoaFilhos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PessoaFilhos)) return false;
        return this.equalKeys(other) && ((PessoaFilhos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PessoaFilhos |");
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
