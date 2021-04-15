package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "escala_pos_transparencia")
public class EscalaPosTransparencia extends AbstractEntity<Long> {

	@Column(name = "horas_totais")
    private Integer horasTotais;
    @Column(name = "horas_dia")
    private Integer horasDia;
    @Column(name = "horas_noite")
    private Integer horasNoite;
    @Column(name = "horas_semana")
    private Integer horasSemana;
    @Column(name = "horas_fim_semana")
    private Integer horasFimSemana;
    @Column(name = "dt_mudanca")
    @Temporal(TemporalType.DATE)
    private Date dtMudanca;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "plantoes")
    private Double plantoes;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_avaliacao_assiduidade_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAvaliacaoAssiduidadeFk;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_codigo_diferenciado_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodigoDiferenciadoFk;
    @JoinColumn(name = "dia14_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia14Fk;
    @JoinColumn(name = "id_tipo_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idTipoFolhaFk;
    @JoinColumn(name = "dia23_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia23Fk;
    @JoinColumn(name = "id_coordenacao_fk", referencedColumnName = "id")
    @ManyToOne
    private CoordenacaoEscala idCoordenacaoFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_ch_dif_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idChDifSimNaoFk;
    @JoinColumn(name = "dia29_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia29Fk;
    @JoinColumn(name = "dia18_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia18Fk;
    @JoinColumn(name = "dia22_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia22Fk;
    @JoinColumn(name = "dia03_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia03Fk;
    @JoinColumn(name = "dia09_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia09Fk;
    @JoinColumn(name = "dia27_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia27Fk;
    @JoinColumn(name = "dia24_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia24Fk;
    @JoinColumn(name = "dia25_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia25Fk;
    @JoinColumn(name = "dia13_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia13Fk;
    @JoinColumn(name = "dia17_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia17Fk;
    @JoinColumn(name = "dia10_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia10Fk;
    @JoinColumn(name = "dia28_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia28Fk;
    @JoinColumn(name = "dia30_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia30Fk;
    @JoinColumn(name = "dia12_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia12Fk;
    @JoinColumn(name = "dia11_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia11Fk;
    @JoinColumn(name = "dia08_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia08Fk;
    @JoinColumn(name = "dia19_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia19Fk;
    @JoinColumn(name = "dia06_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia06Fk;
    @JoinColumn(name = "id_liberacao_dobra_invertida_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idLiberacaoDobraInvertidaSimNaoFk;
    @JoinColumn(name = "dia01_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia01Fk;
    @JoinColumn(name = "dia05_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia05Fk;
    @JoinColumn(name = "id_operador_mudanca_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorMudancaFk;
    @JoinColumn(name = "id_regime_fk", referencedColumnName = "id")
    @ManyToOne
    private RegimesDeTrabalho idRegimeFk;
    @JoinColumn(name = "dia26_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia26Fk;
    @JoinColumn(name = "id_turma_fk", referencedColumnName = "id")
    @ManyToOne
    private Turmas idTurmaFk;
    @JoinColumn(name = "id_avaliacao_atividades_burocraticas_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAvaliacaoAtividadesBurocraticasFk;
    @JoinColumn(name = "dia02_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia02Fk;
    @JoinColumn(name = "dia15_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia15Fk;
    @JoinColumn(name = "id_avaliacao_formalizacao_ponto_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAvaliacaoFormalizacaoPontoFk;
    @JoinColumn(name = "id_incremento_de_risco_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idIncrementoDeRiscoSimNaoFk;
    @JoinColumn(name = "dia07_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia07Fk;
    @JoinColumn(name = "dia21_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia21Fk;
    @JoinColumn(name = "dia20_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia20Fk;
    @JoinColumn(name = "id_avaliacao_permanencia_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAvaliacaoPermanenciaFk;
    @JoinColumn(name = "id_presencial_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idPresencialSimNaoFk;
    @JoinColumn(name = "dia16_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia16Fk;
    @JoinColumn(name = "dia31_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia31Fk;
    @JoinColumn(name = "dia04_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos dia04Fk;
    @Column(name = "observacoes")
    private String observacoes; 
    
	public Integer getHorasTotais() {
		return horasTotais;
	}
	public void setHorasTotais(Integer horasTotais) {
		this.horasTotais = horasTotais;
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
	public Date getDtMudanca() {
		return dtMudanca;
	}
	public void setDtMudanca(Date dtMudanca) {
		this.dtMudanca = dtMudanca;
	}
	public Date getDtCancelamento() {
		return dtCancelamento;
	}
	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}
	public Double getPlantoes() {
		return plantoes;
	}
	public void setPlantoes(Double plantoes) {
		this.plantoes = plantoes;
	}
	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}
	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}
	public SimNao getIdAvaliacaoAssiduidadeFk() {
		return idAvaliacaoAssiduidadeFk;
	}
	public void setIdAvaliacaoAssiduidadeFk(SimNao idAvaliacaoAssiduidadeFk) {
		this.idAvaliacaoAssiduidadeFk = idAvaliacaoAssiduidadeFk;
	}
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
	public CodigoDiferenciado getIdCodigoDiferenciadoFk() {
		return idCodigoDiferenciadoFk;
	}
	public void setIdCodigoDiferenciadoFk(CodigoDiferenciado idCodigoDiferenciadoFk) {
		this.idCodigoDiferenciadoFk = idCodigoDiferenciadoFk;
	}
	public Turnos getDia14Fk() {
		return dia14Fk;
	}
	public void setDia14Fk(Turnos dia14Fk) {
		this.dia14Fk = dia14Fk;
	}
	public TiposDeFolha getIdTipoFolhaFk() {
		return idTipoFolhaFk;
	}
	public void setIdTipoFolhaFk(TiposDeFolha idTipoFolhaFk) {
		this.idTipoFolhaFk = idTipoFolhaFk;
	}
	public Turnos getDia23Fk() {
		return dia23Fk;
	}
	public void setDia23Fk(Turnos dia23Fk) {
		this.dia23Fk = dia23Fk;
	}
	public CoordenacaoEscala getIdCoordenacaoFk() {
		return idCoordenacaoFk;
	}
	public void setIdCoordenacaoFk(CoordenacaoEscala idCoordenacaoFk) {
		this.idCoordenacaoFk = idCoordenacaoFk;
	}
	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}
	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}
	public SimNao getIdChDifSimNaoFk() {
		return idChDifSimNaoFk;
	}
	public void setIdChDifSimNaoFk(SimNao idChDifSimNaoFk) {
		this.idChDifSimNaoFk = idChDifSimNaoFk;
	}
	public Turnos getDia29Fk() {
		return dia29Fk;
	}
	public void setDia29Fk(Turnos dia29Fk) {
		this.dia29Fk = dia29Fk;
	}
	public Turnos getDia18Fk() {
		return dia18Fk;
	}
	public void setDia18Fk(Turnos dia18Fk) {
		this.dia18Fk = dia18Fk;
	}
	public Turnos getDia22Fk() {
		return dia22Fk;
	}
	public void setDia22Fk(Turnos dia22Fk) {
		this.dia22Fk = dia22Fk;
	}
	public Turnos getDia03Fk() {
		return dia03Fk;
	}
	public void setDia03Fk(Turnos dia03Fk) {
		this.dia03Fk = dia03Fk;
	}
	public Turnos getDia09Fk() {
		return dia09Fk;
	}
	public void setDia09Fk(Turnos dia09Fk) {
		this.dia09Fk = dia09Fk;
	}
	public Turnos getDia27Fk() {
		return dia27Fk;
	}
	public void setDia27Fk(Turnos dia27Fk) {
		this.dia27Fk = dia27Fk;
	}
	public Turnos getDia24Fk() {
		return dia24Fk;
	}
	public void setDia24Fk(Turnos dia24Fk) {
		this.dia24Fk = dia24Fk;
	}
	public Turnos getDia25Fk() {
		return dia25Fk;
	}
	public void setDia25Fk(Turnos dia25Fk) {
		this.dia25Fk = dia25Fk;
	}
	public Turnos getDia13Fk() {
		return dia13Fk;
	}
	public void setDia13Fk(Turnos dia13Fk) {
		this.dia13Fk = dia13Fk;
	}
	public Turnos getDia17Fk() {
		return dia17Fk;
	}
	public void setDia17Fk(Turnos dia17Fk) {
		this.dia17Fk = dia17Fk;
	}
	public Turnos getDia10Fk() {
		return dia10Fk;
	}
	public void setDia10Fk(Turnos dia10Fk) {
		this.dia10Fk = dia10Fk;
	}
	public Turnos getDia28Fk() {
		return dia28Fk;
	}
	public void setDia28Fk(Turnos dia28Fk) {
		this.dia28Fk = dia28Fk;
	}
	public Turnos getDia30Fk() {
		return dia30Fk;
	}
	public void setDia30Fk(Turnos dia30Fk) {
		this.dia30Fk = dia30Fk;
	}
	public Turnos getDia12Fk() {
		return dia12Fk;
	}
	public void setDia12Fk(Turnos dia12Fk) {
		this.dia12Fk = dia12Fk;
	}
	public Turnos getDia11Fk() {
		return dia11Fk;
	}
	public void setDia11Fk(Turnos dia11Fk) {
		this.dia11Fk = dia11Fk;
	}
	public Turnos getDia08Fk() {
		return dia08Fk;
	}
	public void setDia08Fk(Turnos dia08Fk) {
		this.dia08Fk = dia08Fk;
	}
	public Turnos getDia19Fk() {
		return dia19Fk;
	}
	public void setDia19Fk(Turnos dia19Fk) {
		this.dia19Fk = dia19Fk;
	}
	public Turnos getDia06Fk() {
		return dia06Fk;
	}
	public void setDia06Fk(Turnos dia06Fk) {
		this.dia06Fk = dia06Fk;
	}
	public SimNao getIdLiberacaoDobraInvertidaSimNaoFk() {
		return idLiberacaoDobraInvertidaSimNaoFk;
	}
	public void setIdLiberacaoDobraInvertidaSimNaoFk(SimNao idLiberacaoDobraInvertidaSimNaoFk) {
		this.idLiberacaoDobraInvertidaSimNaoFk = idLiberacaoDobraInvertidaSimNaoFk;
	}
	public Turnos getDia01Fk() {
		return dia01Fk;
	}
	public void setDia01Fk(Turnos dia01Fk) {
		this.dia01Fk = dia01Fk;
	}
	public Turnos getDia05Fk() {
		return dia05Fk;
	}
	public void setDia05Fk(Turnos dia05Fk) {
		this.dia05Fk = dia05Fk;
	}
	public PessoaOperadores getIdOperadorMudancaFk() {
		return idOperadorMudancaFk;
	}
	public void setIdOperadorMudancaFk(PessoaOperadores idOperadorMudancaFk) {
		this.idOperadorMudancaFk = idOperadorMudancaFk;
	}
	public RegimesDeTrabalho getIdRegimeFk() {
		return idRegimeFk;
	}
	public void setIdRegimeFk(RegimesDeTrabalho idRegimeFk) {
		this.idRegimeFk = idRegimeFk;
	}
	public Turnos getDia26Fk() {
		return dia26Fk;
	}
	public void setDia26Fk(Turnos dia26Fk) {
		this.dia26Fk = dia26Fk;
	}
	public Turmas getIdTurmaFk() {
		return idTurmaFk;
	}
	public void setIdTurmaFk(Turmas idTurmaFk) {
		this.idTurmaFk = idTurmaFk;
	}
	public SimNao getIdAvaliacaoAtividadesBurocraticasFk() {
		return idAvaliacaoAtividadesBurocraticasFk;
	}
	public void setIdAvaliacaoAtividadesBurocraticasFk(SimNao idAvaliacaoAtividadesBurocraticasFk) {
		this.idAvaliacaoAtividadesBurocraticasFk = idAvaliacaoAtividadesBurocraticasFk;
	}
	public Turnos getDia02Fk() {
		return dia02Fk;
	}
	public void setDia02Fk(Turnos dia02Fk) {
		this.dia02Fk = dia02Fk;
	}
	public Turnos getDia15Fk() {
		return dia15Fk;
	}
	public void setDia15Fk(Turnos dia15Fk) {
		this.dia15Fk = dia15Fk;
	}
	public SimNao getIdAvaliacaoFormalizacaoPontoFk() {
		return idAvaliacaoFormalizacaoPontoFk;
	}
	public void setIdAvaliacaoFormalizacaoPontoFk(SimNao idAvaliacaoFormalizacaoPontoFk) {
		this.idAvaliacaoFormalizacaoPontoFk = idAvaliacaoFormalizacaoPontoFk;
	}
	public SimNao getIdIncrementoDeRiscoSimNaoFk() {
		return idIncrementoDeRiscoSimNaoFk;
	}
	public void setIdIncrementoDeRiscoSimNaoFk(SimNao idIncrementoDeRiscoSimNaoFk) {
		this.idIncrementoDeRiscoSimNaoFk = idIncrementoDeRiscoSimNaoFk;
	}
	public Turnos getDia07Fk() {
		return dia07Fk;
	}
	public void setDia07Fk(Turnos dia07Fk) {
		this.dia07Fk = dia07Fk;
	}
	public Turnos getDia21Fk() {
		return dia21Fk;
	}
	public void setDia21Fk(Turnos dia21Fk) {
		this.dia21Fk = dia21Fk;
	}
	public Turnos getDia20Fk() {
		return dia20Fk;
	}
	public void setDia20Fk(Turnos dia20Fk) {
		this.dia20Fk = dia20Fk;
	}
	public SimNao getIdAvaliacaoPermanenciaFk() {
		return idAvaliacaoPermanenciaFk;
	}
	public void setIdAvaliacaoPermanenciaFk(SimNao idAvaliacaoPermanenciaFk) {
		this.idAvaliacaoPermanenciaFk = idAvaliacaoPermanenciaFk;
	}
	public SimNao getIdPresencialSimNaoFk() {
		return idPresencialSimNaoFk;
	}
	public void setIdPresencialSimNaoFk(SimNao idPresencialSimNaoFk) {
		this.idPresencialSimNaoFk = idPresencialSimNaoFk;
	}
	public Turnos getDia16Fk() {
		return dia16Fk;
	}
	public void setDia16Fk(Turnos dia16Fk) {
		this.dia16Fk = dia16Fk;
	}
	public Turnos getDia31Fk() {
		return dia31Fk;
	}
	public void setDia31Fk(Turnos dia31Fk) {
		this.dia31Fk = dia31Fk;
	}
	public Turnos getDia04Fk() {
		return dia04Fk;
	}
	public void setDia04Fk(Turnos dia04Fk) {
		this.dia04Fk = dia04Fk;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacoes);
	}
    
    
	
	
}
