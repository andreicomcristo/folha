package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "turnos") 
public class Turnos extends AbstractEntity<Long>{

	@Column(name = "nome_turno")
    private String nomeTurno;
    @Column(name = "descricao_turno")
    private String descricaoTurno;
    @Column(name = "horas_manha")
    private Integer horasManha;
    @Column(name = "horas_tarde")
    private Integer horasTarde;
    @Column(name = "horas_noite")
    private Integer horasNoite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "plantoes")
    private Double plantoes;
    @OneToMany(mappedBy = "dia16Fk")
    private List<Escala> escalaList;
    @OneToMany(mappedBy = "dia30Fk")
    private List<Escala> escalaList1;
    @OneToMany(mappedBy = "dia24Fk")
    private List<Escala> escalaList2;
    @OneToMany(mappedBy = "dia06Fk")
    private List<Escala> escalaList3;
    @OneToMany(mappedBy = "dia09Fk")
    private List<Escala> escalaList4;
    @OneToMany(mappedBy = "dia03Fk")
    private List<Escala> escalaList5;
    @OneToMany(mappedBy = "dia22Fk")
    private List<Escala> escalaList6;
    @OneToMany(mappedBy = "dia27Fk")
    private List<Escala> escalaList7;
    @OneToMany(mappedBy = "dia14Fk")
    private List<Escala> escalaList8;
    @OneToMany(mappedBy = "dia08Fk")
    private List<Escala> escalaList9;
    @OneToMany(mappedBy = "dia12Fk")
    private List<Escala> escalaList10;
    @OneToMany(mappedBy = "dia25Fk")
    private List<Escala> escalaList11;
    @OneToMany(mappedBy = "dia11Fk")
    private List<Escala> escalaList12;
    @OneToMany(mappedBy = "dia05Fk")
    private List<Escala> escalaList13;
    @OneToMany(mappedBy = "dia10Fk")
    private List<Escala> escalaList14;
    @OneToMany(mappedBy = "dia18Fk")
    private List<Escala> escalaList15;
    @OneToMany(mappedBy = "dia04Fk")
    private List<Escala> escalaList16;
    @OneToMany(mappedBy = "dia26Fk")
    private List<Escala> escalaList17;
    @OneToMany(mappedBy = "dia21Fk")
    private List<Escala> escalaList18;
    @OneToMany(mappedBy = "dia31Fk")
    private List<Escala> escalaList19;
    @OneToMany(mappedBy = "dia13Fk")
    private List<Escala> escalaList20;
    @OneToMany(mappedBy = "dia20Fk")
    private List<Escala> escalaList21;
    @OneToMany(mappedBy = "dia29Fk")
    private List<Escala> escalaList22;
    @OneToMany(mappedBy = "dia28Fk")
    private List<Escala> escalaList23;
    @OneToMany(mappedBy = "dia01Fk")
    private List<Escala> escalaList24;
    @OneToMany(mappedBy = "dia07Fk")
    private List<Escala> escalaList25;
    @OneToMany(mappedBy = "dia15Fk")
    private List<Escala> escalaList26;
    @OneToMany(mappedBy = "dia02Fk")
    private List<Escala> escalaList27;
    @OneToMany(mappedBy = "dia23Fk")
    private List<Escala> escalaList28;
    @OneToMany(mappedBy = "dia17Fk")
    private List<Escala> escalaList29;
    @OneToMany(mappedBy = "dia19Fk")
    private List<Escala> escalaList30;
    
    @OneToMany(mappedBy = "dia14Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
    @OneToMany(mappedBy = "dia23Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList1;
    @OneToMany(mappedBy = "dia29Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList2;
    @OneToMany(mappedBy = "dia18Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList3;
    @OneToMany(mappedBy = "dia22Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList4;
    @OneToMany(mappedBy = "dia03Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList5;
    @OneToMany(mappedBy = "dia09Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList6;
    @OneToMany(mappedBy = "dia27Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList7;
    @OneToMany(mappedBy = "dia24Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList8;
    @OneToMany(mappedBy = "dia25Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList9;
    @OneToMany(mappedBy = "dia13Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList10;
    @OneToMany(mappedBy = "dia17Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList11;
    @OneToMany(mappedBy = "dia10Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList12;
    @OneToMany(mappedBy = "dia28Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList13;
    @OneToMany(mappedBy = "dia30Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList14;
    @OneToMany(mappedBy = "dia12Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList15;
    @OneToMany(mappedBy = "dia11Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList16;
    @OneToMany(mappedBy = "dia08Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList17;
    @OneToMany(mappedBy = "dia19Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList18;
    @OneToMany(mappedBy = "dia06Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList19;
    @OneToMany(mappedBy = "dia01Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList20;
    @OneToMany(mappedBy = "dia05Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList21;
    @OneToMany(mappedBy = "dia26Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList22;
    @OneToMany(mappedBy = "dia02Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList23;
    @OneToMany(mappedBy = "dia15Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList24;
    @OneToMany(mappedBy = "dia07Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList25;
    @OneToMany(mappedBy = "dia21Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList26;
    @OneToMany(mappedBy = "dia20Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList27;
    @OneToMany(mappedBy = "dia16Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList28;
    @OneToMany(mappedBy = "dia31Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList29;
    @OneToMany(mappedBy = "dia04Fk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList30;

    
	public String getNomeTurno() {
		return nomeTurno;
	}
	public void setNomeTurno(String nomeTurno) {
		this.nomeTurno = nomeTurno;
	}
	public String getDescricaoTurno() {
		return descricaoTurno;
	}
	public void setDescricaoTurno(String descricaoTurno) {
		this.descricaoTurno = descricaoTurno;
	}
	public Integer getHorasManha() {
		return horasManha;
	}
	public void setHorasManha(Integer horasManha) {
		this.horasManha = horasManha;
	}
	public Integer getHorasTarde() {
		return horasTarde;
	}
	public void setHorasTarde(Integer horasTarde) {
		this.horasTarde = horasTarde;
	}
	public Integer getHorasNoite() {
		return horasNoite;
	}
	public void setHorasNoite(Integer horasNoite) {
		this.horasNoite = horasNoite;
	}
	public Double getPlantoes() {
		return plantoes;
	}
	public void setPlantoes(Double plantoes) {
		this.plantoes = plantoes;
	}
	public List<Escala> getEscalaList() {
		return escalaList;
	}
	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}
	public List<Escala> getEscalaList1() {
		return escalaList1;
	}
	public void setEscalaList1(List<Escala> escalaList1) {
		this.escalaList1 = escalaList1;
	}
	public List<Escala> getEscalaList2() {
		return escalaList2;
	}
	public void setEscalaList2(List<Escala> escalaList2) {
		this.escalaList2 = escalaList2;
	}
	public List<Escala> getEscalaList3() {
		return escalaList3;
	}
	public void setEscalaList3(List<Escala> escalaList3) {
		this.escalaList3 = escalaList3;
	}
	public List<Escala> getEscalaList4() {
		return escalaList4;
	}
	public void setEscalaList4(List<Escala> escalaList4) {
		this.escalaList4 = escalaList4;
	}
	public List<Escala> getEscalaList5() {
		return escalaList5;
	}
	public void setEscalaList5(List<Escala> escalaList5) {
		this.escalaList5 = escalaList5;
	}
	public List<Escala> getEscalaList6() {
		return escalaList6;
	}
	public void setEscalaList6(List<Escala> escalaList6) {
		this.escalaList6 = escalaList6;
	}
	public List<Escala> getEscalaList7() {
		return escalaList7;
	}
	public void setEscalaList7(List<Escala> escalaList7) {
		this.escalaList7 = escalaList7;
	}
	public List<Escala> getEscalaList8() {
		return escalaList8;
	}
	public void setEscalaList8(List<Escala> escalaList8) {
		this.escalaList8 = escalaList8;
	}
	public List<Escala> getEscalaList9() {
		return escalaList9;
	}
	public void setEscalaList9(List<Escala> escalaList9) {
		this.escalaList9 = escalaList9;
	}
	public List<Escala> getEscalaList10() {
		return escalaList10;
	}
	public void setEscalaList10(List<Escala> escalaList10) {
		this.escalaList10 = escalaList10;
	}
	public List<Escala> getEscalaList11() {
		return escalaList11;
	}
	public void setEscalaList11(List<Escala> escalaList11) {
		this.escalaList11 = escalaList11;
	}
	public List<Escala> getEscalaList12() {
		return escalaList12;
	}
	public void setEscalaList12(List<Escala> escalaList12) {
		this.escalaList12 = escalaList12;
	}
	public List<Escala> getEscalaList13() {
		return escalaList13;
	}
	public void setEscalaList13(List<Escala> escalaList13) {
		this.escalaList13 = escalaList13;
	}
	public List<Escala> getEscalaList14() {
		return escalaList14;
	}
	public void setEscalaList14(List<Escala> escalaList14) {
		this.escalaList14 = escalaList14;
	}
	public List<Escala> getEscalaList15() {
		return escalaList15;
	}
	public void setEscalaList15(List<Escala> escalaList15) {
		this.escalaList15 = escalaList15;
	}
	public List<Escala> getEscalaList16() {
		return escalaList16;
	}
	public void setEscalaList16(List<Escala> escalaList16) {
		this.escalaList16 = escalaList16;
	}
	public List<Escala> getEscalaList17() {
		return escalaList17;
	}
	public void setEscalaList17(List<Escala> escalaList17) {
		this.escalaList17 = escalaList17;
	}
	public List<Escala> getEscalaList18() {
		return escalaList18;
	}
	public void setEscalaList18(List<Escala> escalaList18) {
		this.escalaList18 = escalaList18;
	}
	public List<Escala> getEscalaList19() {
		return escalaList19;
	}
	public void setEscalaList19(List<Escala> escalaList19) {
		this.escalaList19 = escalaList19;
	}
	public List<Escala> getEscalaList20() {
		return escalaList20;
	}
	public void setEscalaList20(List<Escala> escalaList20) {
		this.escalaList20 = escalaList20;
	}
	public List<Escala> getEscalaList21() {
		return escalaList21;
	}
	public void setEscalaList21(List<Escala> escalaList21) {
		this.escalaList21 = escalaList21;
	}
	public List<Escala> getEscalaList22() {
		return escalaList22;
	}
	public void setEscalaList22(List<Escala> escalaList22) {
		this.escalaList22 = escalaList22;
	}
	public List<Escala> getEscalaList23() {
		return escalaList23;
	}
	public void setEscalaList23(List<Escala> escalaList23) {
		this.escalaList23 = escalaList23;
	}
	public List<Escala> getEscalaList24() {
		return escalaList24;
	}
	public void setEscalaList24(List<Escala> escalaList24) {
		this.escalaList24 = escalaList24;
	}
	public List<Escala> getEscalaList25() {
		return escalaList25;
	}
	public void setEscalaList25(List<Escala> escalaList25) {
		this.escalaList25 = escalaList25;
	}
	public List<Escala> getEscalaList26() {
		return escalaList26;
	}
	public void setEscalaList26(List<Escala> escalaList26) {
		this.escalaList26 = escalaList26;
	}
	public List<Escala> getEscalaList27() {
		return escalaList27;
	}
	public void setEscalaList27(List<Escala> escalaList27) {
		this.escalaList27 = escalaList27;
	}
	public List<Escala> getEscalaList28() {
		return escalaList28;
	}
	public void setEscalaList28(List<Escala> escalaList28) {
		this.escalaList28 = escalaList28;
	}
	public List<Escala> getEscalaList29() {
		return escalaList29;
	}
	public void setEscalaList29(List<Escala> escalaList29) {
		this.escalaList29 = escalaList29;
	}
	public List<Escala> getEscalaList30() {
		return escalaList30;
	}
	public void setEscalaList30(List<Escala> escalaList30) {
		this.escalaList30 = escalaList30;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}
	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList1() {
		return escalaPosTransparenciaList1;
	}
	public void setEscalaPosTransparenciaList1(List<EscalaPosTransparencia> escalaPosTransparenciaList1) {
		this.escalaPosTransparenciaList1 = escalaPosTransparenciaList1;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList2() {
		return escalaPosTransparenciaList2;
	}
	public void setEscalaPosTransparenciaList2(List<EscalaPosTransparencia> escalaPosTransparenciaList2) {
		this.escalaPosTransparenciaList2 = escalaPosTransparenciaList2;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList3() {
		return escalaPosTransparenciaList3;
	}
	public void setEscalaPosTransparenciaList3(List<EscalaPosTransparencia> escalaPosTransparenciaList3) {
		this.escalaPosTransparenciaList3 = escalaPosTransparenciaList3;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList4() {
		return escalaPosTransparenciaList4;
	}
	public void setEscalaPosTransparenciaList4(List<EscalaPosTransparencia> escalaPosTransparenciaList4) {
		this.escalaPosTransparenciaList4 = escalaPosTransparenciaList4;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList5() {
		return escalaPosTransparenciaList5;
	}
	public void setEscalaPosTransparenciaList5(List<EscalaPosTransparencia> escalaPosTransparenciaList5) {
		this.escalaPosTransparenciaList5 = escalaPosTransparenciaList5;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList6() {
		return escalaPosTransparenciaList6;
	}
	public void setEscalaPosTransparenciaList6(List<EscalaPosTransparencia> escalaPosTransparenciaList6) {
		this.escalaPosTransparenciaList6 = escalaPosTransparenciaList6;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList7() {
		return escalaPosTransparenciaList7;
	}
	public void setEscalaPosTransparenciaList7(List<EscalaPosTransparencia> escalaPosTransparenciaList7) {
		this.escalaPosTransparenciaList7 = escalaPosTransparenciaList7;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList8() {
		return escalaPosTransparenciaList8;
	}
	public void setEscalaPosTransparenciaList8(List<EscalaPosTransparencia> escalaPosTransparenciaList8) {
		this.escalaPosTransparenciaList8 = escalaPosTransparenciaList8;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList9() {
		return escalaPosTransparenciaList9;
	}
	public void setEscalaPosTransparenciaList9(List<EscalaPosTransparencia> escalaPosTransparenciaList9) {
		this.escalaPosTransparenciaList9 = escalaPosTransparenciaList9;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList10() {
		return escalaPosTransparenciaList10;
	}
	public void setEscalaPosTransparenciaList10(List<EscalaPosTransparencia> escalaPosTransparenciaList10) {
		this.escalaPosTransparenciaList10 = escalaPosTransparenciaList10;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList11() {
		return escalaPosTransparenciaList11;
	}
	public void setEscalaPosTransparenciaList11(List<EscalaPosTransparencia> escalaPosTransparenciaList11) {
		this.escalaPosTransparenciaList11 = escalaPosTransparenciaList11;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList12() {
		return escalaPosTransparenciaList12;
	}
	public void setEscalaPosTransparenciaList12(List<EscalaPosTransparencia> escalaPosTransparenciaList12) {
		this.escalaPosTransparenciaList12 = escalaPosTransparenciaList12;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList13() {
		return escalaPosTransparenciaList13;
	}
	public void setEscalaPosTransparenciaList13(List<EscalaPosTransparencia> escalaPosTransparenciaList13) {
		this.escalaPosTransparenciaList13 = escalaPosTransparenciaList13;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList14() {
		return escalaPosTransparenciaList14;
	}
	public void setEscalaPosTransparenciaList14(List<EscalaPosTransparencia> escalaPosTransparenciaList14) {
		this.escalaPosTransparenciaList14 = escalaPosTransparenciaList14;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList15() {
		return escalaPosTransparenciaList15;
	}
	public void setEscalaPosTransparenciaList15(List<EscalaPosTransparencia> escalaPosTransparenciaList15) {
		this.escalaPosTransparenciaList15 = escalaPosTransparenciaList15;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList16() {
		return escalaPosTransparenciaList16;
	}
	public void setEscalaPosTransparenciaList16(List<EscalaPosTransparencia> escalaPosTransparenciaList16) {
		this.escalaPosTransparenciaList16 = escalaPosTransparenciaList16;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList17() {
		return escalaPosTransparenciaList17;
	}
	public void setEscalaPosTransparenciaList17(List<EscalaPosTransparencia> escalaPosTransparenciaList17) {
		this.escalaPosTransparenciaList17 = escalaPosTransparenciaList17;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList18() {
		return escalaPosTransparenciaList18;
	}
	public void setEscalaPosTransparenciaList18(List<EscalaPosTransparencia> escalaPosTransparenciaList18) {
		this.escalaPosTransparenciaList18 = escalaPosTransparenciaList18;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList19() {
		return escalaPosTransparenciaList19;
	}
	public void setEscalaPosTransparenciaList19(List<EscalaPosTransparencia> escalaPosTransparenciaList19) {
		this.escalaPosTransparenciaList19 = escalaPosTransparenciaList19;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList20() {
		return escalaPosTransparenciaList20;
	}
	public void setEscalaPosTransparenciaList20(List<EscalaPosTransparencia> escalaPosTransparenciaList20) {
		this.escalaPosTransparenciaList20 = escalaPosTransparenciaList20;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList21() {
		return escalaPosTransparenciaList21;
	}
	public void setEscalaPosTransparenciaList21(List<EscalaPosTransparencia> escalaPosTransparenciaList21) {
		this.escalaPosTransparenciaList21 = escalaPosTransparenciaList21;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList22() {
		return escalaPosTransparenciaList22;
	}
	public void setEscalaPosTransparenciaList22(List<EscalaPosTransparencia> escalaPosTransparenciaList22) {
		this.escalaPosTransparenciaList22 = escalaPosTransparenciaList22;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList23() {
		return escalaPosTransparenciaList23;
	}
	public void setEscalaPosTransparenciaList23(List<EscalaPosTransparencia> escalaPosTransparenciaList23) {
		this.escalaPosTransparenciaList23 = escalaPosTransparenciaList23;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList24() {
		return escalaPosTransparenciaList24;
	}
	public void setEscalaPosTransparenciaList24(List<EscalaPosTransparencia> escalaPosTransparenciaList24) {
		this.escalaPosTransparenciaList24 = escalaPosTransparenciaList24;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList25() {
		return escalaPosTransparenciaList25;
	}
	public void setEscalaPosTransparenciaList25(List<EscalaPosTransparencia> escalaPosTransparenciaList25) {
		this.escalaPosTransparenciaList25 = escalaPosTransparenciaList25;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList26() {
		return escalaPosTransparenciaList26;
	}
	public void setEscalaPosTransparenciaList26(List<EscalaPosTransparencia> escalaPosTransparenciaList26) {
		this.escalaPosTransparenciaList26 = escalaPosTransparenciaList26;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList27() {
		return escalaPosTransparenciaList27;
	}
	public void setEscalaPosTransparenciaList27(List<EscalaPosTransparencia> escalaPosTransparenciaList27) {
		this.escalaPosTransparenciaList27 = escalaPosTransparenciaList27;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList28() {
		return escalaPosTransparenciaList28;
	}
	public void setEscalaPosTransparenciaList28(List<EscalaPosTransparencia> escalaPosTransparenciaList28) {
		this.escalaPosTransparenciaList28 = escalaPosTransparenciaList28;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList29() {
		return escalaPosTransparenciaList29;
	}
	public void setEscalaPosTransparenciaList29(List<EscalaPosTransparencia> escalaPosTransparenciaList29) {
		this.escalaPosTransparenciaList29 = escalaPosTransparenciaList29;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList30() {
		return escalaPosTransparenciaList30;
	}
	public void setEscalaPosTransparenciaList30(List<EscalaPosTransparencia> escalaPosTransparenciaList30) {
		this.escalaPosTransparenciaList30 = escalaPosTransparenciaList30;
	}
    
    
}
