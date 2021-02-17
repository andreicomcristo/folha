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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="pessoa", indexes={@Index(name="pessoa_cpf_IX", columnList="cpf", unique=true)})
public class Pessoa implements Serializable {

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
    @Column(unique=true, nullable=false, length=20)
    private String cpf;
    @Column(nullable=false, length=300)
    private String nome;
    @Column(length=30)
    private String fone1;
    @Column(length=30)
    private String fone2;
    @Column(length=30)
    private String fone3;
    @Column(length=150)
    private String email;
    @Column(name="email_saude", length=150)
    private String emailSaude;
    @Column(name="dt_nascimento")
    private LocalDate dtNascimento;
    @Column(name="nome_pai", length=300)
    private String nomePai;
    @Column(name="nome_mae", length=300)
    private String nomeMae;
    @Column(name="dt_cadastro")
    private LocalDate dtCadastro;
    @Column(name="dt_cancelamento")
    private LocalDate dtCancelamento;
    @Column(name="moivo_cancelamento", length=300)
    private String moivoCancelamento;
    @ManyToOne
    @JoinColumn(name="seq_escolaridade")
    private Escolaridades escolaridades;
    @ManyToOne
    @JoinColumn(name="seq_estado_civil")
    private EstadosCivis estadosCivis;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaBancos> pessoaBancos;
    @ManyToOne
    @JoinColumn(name="seq_cidade_natal")
    private Cidades cidades;
    @ManyToOne
    @JoinColumn(name="seq_endereco")
    private Enderecos enderecos2;
    @ManyToOne
    @JoinColumn(name="seq_operador_cadastro")
    private PessoaOperadores pessoaOperadores2;
    @ManyToOne
    @JoinColumn(name="seq_operador_cancelamento")
    private PessoaOperadores pessoaOperadores3;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaFuncionarios> pessoaFuncionarios;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaOperadores> pessoaOperadores;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaFilhos> pessoaFilhos;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaFotos> pessoaFotos;
    @ManyToOne
    @JoinColumn(name="seq_sexo_declarado")
    private Sexos sexos2;
    @ManyToOne
    @JoinColumn(name="seq_sexo")
    private Sexos sexos;
    @OneToMany(mappedBy="pessoa")
    private Set<Enderecos> enderecos;
    @OneToMany(mappedBy="pessoa")
    private Set<HistUnidadesDiretor> histUnidadesDiretor;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaDocumentos> pessoaDocumentos;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaDocumentosConselho> pessoaDocumentosConselho;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaDocumentosCtps> pessoaDocumentosCtps;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaDocumentosHabilitacao> pessoaDocumentosHabilitacao;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaDocumentosReservista> pessoaDocumentosReservista;
    @OneToMany(mappedBy="pessoa")
    private Set<PessoaDocumentosTitulo> pessoaDocumentosTitulo;

    /** Default constructor. */
    public Pessoa() {
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
     * Access method for cpf.
     *
     * @return the current value of cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Setter method for cpf.
     *
     * @param aCpf the new value for cpf
     */
    public void setCpf(String aCpf) {
        cpf = aCpf;
    }

    /**
     * Access method for nome.
     *
     * @return the current value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter method for nome.
     *
     * @param aNome the new value for nome
     */
    public void setNome(String aNome) {
        nome = aNome;
    }

    /**
     * Access method for fone1.
     *
     * @return the current value of fone1
     */
    public String getFone1() {
        return fone1;
    }

    /**
     * Setter method for fone1.
     *
     * @param aFone1 the new value for fone1
     */
    public void setFone1(String aFone1) {
        fone1 = aFone1;
    }

    /**
     * Access method for fone2.
     *
     * @return the current value of fone2
     */
    public String getFone2() {
        return fone2;
    }

    /**
     * Setter method for fone2.
     *
     * @param aFone2 the new value for fone2
     */
    public void setFone2(String aFone2) {
        fone2 = aFone2;
    }

    /**
     * Access method for fone3.
     *
     * @return the current value of fone3
     */
    public String getFone3() {
        return fone3;
    }

    /**
     * Setter method for fone3.
     *
     * @param aFone3 the new value for fone3
     */
    public void setFone3(String aFone3) {
        fone3 = aFone3;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for emailSaude.
     *
     * @return the current value of emailSaude
     */
    public String getEmailSaude() {
        return emailSaude;
    }

    /**
     * Setter method for emailSaude.
     *
     * @param aEmailSaude the new value for emailSaude
     */
    public void setEmailSaude(String aEmailSaude) {
        emailSaude = aEmailSaude;
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
     * Access method for nomePai.
     *
     * @return the current value of nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Setter method for nomePai.
     *
     * @param aNomePai the new value for nomePai
     */
    public void setNomePai(String aNomePai) {
        nomePai = aNomePai;
    }

    /**
     * Access method for nomeMae.
     *
     * @return the current value of nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Setter method for nomeMae.
     *
     * @param aNomeMae the new value for nomeMae
     */
    public void setNomeMae(String aNomeMae) {
        nomeMae = aNomeMae;
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
     * Access method for moivoCancelamento.
     *
     * @return the current value of moivoCancelamento
     */
    public String getMoivoCancelamento() {
        return moivoCancelamento;
    }

    /**
     * Setter method for moivoCancelamento.
     *
     * @param aMoivoCancelamento the new value for moivoCancelamento
     */
    public void setMoivoCancelamento(String aMoivoCancelamento) {
        moivoCancelamento = aMoivoCancelamento;
    }

    /**
     * Access method for escolaridades.
     *
     * @return the current value of escolaridades
     */
    public Escolaridades getEscolaridades() {
        return escolaridades;
    }

    /**
     * Setter method for escolaridades.
     *
     * @param aEscolaridades the new value for escolaridades
     */
    public void setEscolaridades(Escolaridades aEscolaridades) {
        escolaridades = aEscolaridades;
    }

    /**
     * Access method for estadosCivis.
     *
     * @return the current value of estadosCivis
     */
    public EstadosCivis getEstadosCivis() {
        return estadosCivis;
    }

    /**
     * Setter method for estadosCivis.
     *
     * @param aEstadosCivis the new value for estadosCivis
     */
    public void setEstadosCivis(EstadosCivis aEstadosCivis) {
        estadosCivis = aEstadosCivis;
    }

    /**
     * Access method for pessoaBancos.
     *
     * @return the current value of pessoaBancos
     */
    public Set<PessoaBancos> getPessoaBancos() {
        return pessoaBancos;
    }

    /**
     * Setter method for pessoaBancos.
     *
     * @param aPessoaBancos the new value for pessoaBancos
     */
    public void setPessoaBancos(Set<PessoaBancos> aPessoaBancos) {
        pessoaBancos = aPessoaBancos;
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
     * Access method for enderecos2.
     *
     * @return the current value of enderecos2
     */
    public Enderecos getEnderecos2() {
        return enderecos2;
    }

    /**
     * Setter method for enderecos2.
     *
     * @param aEnderecos2 the new value for enderecos2
     */
    public void setEnderecos2(Enderecos aEnderecos2) {
        enderecos2 = aEnderecos2;
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
     * Access method for pessoaOperadores3.
     *
     * @return the current value of pessoaOperadores3
     */
    public PessoaOperadores getPessoaOperadores3() {
        return pessoaOperadores3;
    }

    /**
     * Setter method for pessoaOperadores3.
     *
     * @param aPessoaOperadores3 the new value for pessoaOperadores3
     */
    public void setPessoaOperadores3(PessoaOperadores aPessoaOperadores3) {
        pessoaOperadores3 = aPessoaOperadores3;
    }

    /**
     * Access method for pessoaFuncionarios.
     *
     * @return the current value of pessoaFuncionarios
     */
    public Set<PessoaFuncionarios> getPessoaFuncionarios() {
        return pessoaFuncionarios;
    }

    /**
     * Setter method for pessoaFuncionarios.
     *
     * @param aPessoaFuncionarios the new value for pessoaFuncionarios
     */
    public void setPessoaFuncionarios(Set<PessoaFuncionarios> aPessoaFuncionarios) {
        pessoaFuncionarios = aPessoaFuncionarios;
    }

    /**
     * Access method for pessoaOperadores.
     *
     * @return the current value of pessoaOperadores
     */
    public Set<PessoaOperadores> getPessoaOperadores() {
        return pessoaOperadores;
    }

    /**
     * Setter method for pessoaOperadores.
     *
     * @param aPessoaOperadores the new value for pessoaOperadores
     */
    public void setPessoaOperadores(Set<PessoaOperadores> aPessoaOperadores) {
        pessoaOperadores = aPessoaOperadores;
    }

    /**
     * Access method for pessoaFilhos.
     *
     * @return the current value of pessoaFilhos
     */
    public Set<PessoaFilhos> getPessoaFilhos() {
        return pessoaFilhos;
    }

    /**
     * Setter method for pessoaFilhos.
     *
     * @param aPessoaFilhos the new value for pessoaFilhos
     */
    public void setPessoaFilhos(Set<PessoaFilhos> aPessoaFilhos) {
        pessoaFilhos = aPessoaFilhos;
    }

    /**
     * Access method for pessoaFotos.
     *
     * @return the current value of pessoaFotos
     */
    public Set<PessoaFotos> getPessoaFotos() {
        return pessoaFotos;
    }

    /**
     * Setter method for pessoaFotos.
     *
     * @param aPessoaFotos the new value for pessoaFotos
     */
    public void setPessoaFotos(Set<PessoaFotos> aPessoaFotos) {
        pessoaFotos = aPessoaFotos;
    }

    /**
     * Access method for sexos2.
     *
     * @return the current value of sexos2
     */
    public Sexos getSexos2() {
        return sexos2;
    }

    /**
     * Setter method for sexos2.
     *
     * @param aSexos2 the new value for sexos2
     */
    public void setSexos2(Sexos aSexos2) {
        sexos2 = aSexos2;
    }

    /**
     * Access method for sexos.
     *
     * @return the current value of sexos
     */
    public Sexos getSexos() {
        return sexos;
    }

    /**
     * Setter method for sexos.
     *
     * @param aSexos the new value for sexos
     */
    public void setSexos(Sexos aSexos) {
        sexos = aSexos;
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
     * Access method for histUnidadesDiretor.
     *
     * @return the current value of histUnidadesDiretor
     */
    public Set<HistUnidadesDiretor> getHistUnidadesDiretor() {
        return histUnidadesDiretor;
    }

    /**
     * Setter method for histUnidadesDiretor.
     *
     * @param aHistUnidadesDiretor the new value for histUnidadesDiretor
     */
    public void setHistUnidadesDiretor(Set<HistUnidadesDiretor> aHistUnidadesDiretor) {
        histUnidadesDiretor = aHistUnidadesDiretor;
    }

    /**
     * Access method for pessoaDocumentos.
     *
     * @return the current value of pessoaDocumentos
     */
    public Set<PessoaDocumentos> getPessoaDocumentos() {
        return pessoaDocumentos;
    }

    /**
     * Setter method for pessoaDocumentos.
     *
     * @param aPessoaDocumentos the new value for pessoaDocumentos
     */
    public void setPessoaDocumentos(Set<PessoaDocumentos> aPessoaDocumentos) {
        pessoaDocumentos = aPessoaDocumentos;
    }

    /**
     * Access method for pessoaDocumentosConselho.
     *
     * @return the current value of pessoaDocumentosConselho
     */
    public Set<PessoaDocumentosConselho> getPessoaDocumentosConselho() {
        return pessoaDocumentosConselho;
    }

    /**
     * Setter method for pessoaDocumentosConselho.
     *
     * @param aPessoaDocumentosConselho the new value for pessoaDocumentosConselho
     */
    public void setPessoaDocumentosConselho(Set<PessoaDocumentosConselho> aPessoaDocumentosConselho) {
        pessoaDocumentosConselho = aPessoaDocumentosConselho;
    }

    /**
     * Access method for pessoaDocumentosCtps.
     *
     * @return the current value of pessoaDocumentosCtps
     */
    public Set<PessoaDocumentosCtps> getPessoaDocumentosCtps() {
        return pessoaDocumentosCtps;
    }

    /**
     * Setter method for pessoaDocumentosCtps.
     *
     * @param aPessoaDocumentosCtps the new value for pessoaDocumentosCtps
     */
    public void setPessoaDocumentosCtps(Set<PessoaDocumentosCtps> aPessoaDocumentosCtps) {
        pessoaDocumentosCtps = aPessoaDocumentosCtps;
    }

    /**
     * Access method for pessoaDocumentosHabilitacao.
     *
     * @return the current value of pessoaDocumentosHabilitacao
     */
    public Set<PessoaDocumentosHabilitacao> getPessoaDocumentosHabilitacao() {
        return pessoaDocumentosHabilitacao;
    }

    /**
     * Setter method for pessoaDocumentosHabilitacao.
     *
     * @param aPessoaDocumentosHabilitacao the new value for pessoaDocumentosHabilitacao
     */
    public void setPessoaDocumentosHabilitacao(Set<PessoaDocumentosHabilitacao> aPessoaDocumentosHabilitacao) {
        pessoaDocumentosHabilitacao = aPessoaDocumentosHabilitacao;
    }

    /**
     * Access method for pessoaDocumentosReservista.
     *
     * @return the current value of pessoaDocumentosReservista
     */
    public Set<PessoaDocumentosReservista> getPessoaDocumentosReservista() {
        return pessoaDocumentosReservista;
    }

    /**
     * Setter method for pessoaDocumentosReservista.
     *
     * @param aPessoaDocumentosReservista the new value for pessoaDocumentosReservista
     */
    public void setPessoaDocumentosReservista(Set<PessoaDocumentosReservista> aPessoaDocumentosReservista) {
        pessoaDocumentosReservista = aPessoaDocumentosReservista;
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
     * Compares the key for this instance with another Pessoa.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Pessoa and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Pessoa)) {
            return false;
        }
        Pessoa that = (Pessoa) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Pessoa.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pessoa)) return false;
        return this.equalKeys(other) && ((Pessoa)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Pessoa |");
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
