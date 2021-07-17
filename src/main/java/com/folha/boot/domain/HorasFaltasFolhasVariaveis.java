package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "horas_faltas_folhas_variaveis")
public class HorasFaltasFolhasVariaveis extends AbstractEntity<Long> {

	@Column(name = "horas_dia")
    private Integer horasDia;
    @Column(name = "horas_noite")
    private Integer horasNoite;
    @Column(name = "horas_dia_descontadas")
    private Integer horasDiaDescontadas;
    @Column(name = "horas_noite_descontadas")
    private Integer horasNoiteDescontadas;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "observacao_sistema")
    private String observacaoSistema;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "horas_a_descontar")
    private Integer horasADescontar;
    @Column(name = "horas_descontadas")
    private Integer horasDescontadas;
    @Column(name = "horas_restantes")
    private Integer horasRestantes;
    @Column(name = "horas_semana")
    private Integer horasSemana;
    @Column(name = "horas_fim_semana")
    private Integer horasFimSemana;
    @Column(name = "horas_semana_descontadas")
    private Integer horasSemanaDescontadas;
    @Column(name = "horas_fim_semana_descontadas")
    private Integer horasFimSemanaDescontadas;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_ano_mes_lancamento_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesLancamentoFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

    public HorasFaltasFolhasVariaveis() {
    }

	public Integer getHorasDia() {
		return horasDia;
	}

	public void setHorasDia(Integer horasDia) {
		this.horasDia = horasDia;
	}

	public Integer getHorasNoite() {
		return horasNoite;
	}

	public void setHorasNoite(Integer horasNoite) {
		this.horasNoite = horasNoite;
	}

	public Integer getHorasDiaDescontadas() {
		return horasDiaDescontadas;
	}

	public void setHorasDiaDescontadas(Integer horasDiaDescontadas) {
		this.horasDiaDescontadas = horasDiaDescontadas;
	}

	public Integer getHorasNoiteDescontadas() {
		return horasNoiteDescontadas;
	}

	public void setHorasNoiteDescontadas(Integer horasNoiteDescontadas) {
		this.horasNoiteDescontadas = horasNoiteDescontadas;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
	}

	public String getObservacaoSistema() {
		return observacaoSistema;
	}

	public void setObservacaoSistema(String observacaoSistema) {
		this.observacaoSistema = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacaoSistema);
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public Integer getHorasADescontar() {
		return horasADescontar;
	}

	public void setHorasADescontar(Integer horasADescontar) {
		this.horasADescontar = horasADescontar;
	}

	public Integer getHorasDescontadas() {
		return horasDescontadas;
	}

	public void setHorasDescontadas(Integer horasDescontadas) {
		this.horasDescontadas = horasDescontadas;
	}

	public Integer getHorasRestantes() {
		return horasRestantes;
	}

	public void setHorasRestantes(Integer horasRestantes) {
		this.horasRestantes = horasRestantes;
	}

	public Integer getHorasSemana() {
		return horasSemana;
	}

	public void setHorasSemana(Integer horasSemana) {
		this.horasSemana = horasSemana;
	}

	public Integer getHorasFimSemana() {
		return horasFimSemana;
	}

	public void setHorasFimSemana(Integer horasFimSemana) {
		this.horasFimSemana = horasFimSemana;
	}

	public Integer getHorasSemanaDescontadas() {
		return horasSemanaDescontadas;
	}

	public void setHorasSemanaDescontadas(Integer horasSemanaDescontadas) {
		this.horasSemanaDescontadas = horasSemanaDescontadas;
	}

	public Integer getHorasFimSemanaDescontadas() {
		return horasFimSemanaDescontadas;
	}

	public void setHorasFimSemanaDescontadas(Integer horasFimSemanaDescontadas) {
		this.horasFimSemanaDescontadas = horasFimSemanaDescontadas;
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public AnoMes getIdAnoMesLancamentoFk() {
		return idAnoMesLancamentoFk;
	}

	public void setIdAnoMesLancamentoFk(AnoMes idAnoMesLancamentoFk) {
		this.idAnoMesLancamentoFk = idAnoMesLancamentoFk;
	}

	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}

	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}

	public PessoaOperadores getIdOperadorCadastroFk() {
		return idOperadorCadastroFk;
	}

	public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}

	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}

    
    
    
    
	
	
}
