package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "escala_horas_pagas")
public class EscalaHorasPagas extends AbstractEntity<Long> {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "plantoes")
    private Double plantoes;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "horas_a")
    private Integer horasA;
    @Column(name = "horas_b")
    private Integer horasB;
    @Column(name = "horas_c")
    private Integer horasC;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_coordenacao_fk", referencedColumnName = "id")
    @ManyToOne
    private CoordenacaoEscala idCoordenacaoFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_regime_fk", referencedColumnName = "id")
    @ManyToOne
    private RegimesDeTrabalho idRegimeFk;
    @JoinColumn(name = "id_tipo_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idTipoFolhaFk;

    public EscalaHorasPagas() {
    }

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

	public Double getPlantoes() {
		return plantoes;
	}

	public void setPlantoes(Double plantoes) {
		this.plantoes = plantoes;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getHorasA() {
		return horasA;
	}

	public void setHorasA(Integer horasA) {
		this.horasA = horasA;
	}

	public Integer getHorasB() {
		return horasB;
	}

	public void setHorasB(Integer horasB) {
		this.horasB = horasB;
	}

	public Integer getHorasC() {
		return horasC;
	}

	public void setHorasC(Integer horasC) {
		this.horasC = horasC;
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
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

	public RegimesDeTrabalho getIdRegimeFk() {
		return idRegimeFk;
	}

	public void setIdRegimeFk(RegimesDeTrabalho idRegimeFk) {
		this.idRegimeFk = idRegimeFk;
	}

	public TiposDeFolha getIdTipoFolhaFk() {
		return idTipoFolhaFk;
	}

	public void setIdTipoFolhaFk(TiposDeFolha idTipoFolhaFk) {
		this.idTipoFolhaFk = idTipoFolhaFk;
	}
    

}
