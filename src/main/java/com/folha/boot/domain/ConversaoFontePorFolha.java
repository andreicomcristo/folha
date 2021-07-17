package com.folha.boot.domain;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "conversao_fonte_por_folha")
public class ConversaoFontePorFolha extends AbstractEntity<Long> {

	@JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    @JoinColumn(name = "id_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idFolhaFk;

    public ConversaoFontePorFolha() {
    }

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public Fonte getIdFonteFk() {
		return idFonteFk;
	}

	public void setIdFonteFk(Fonte idFonteFk) {
		this.idFonteFk = idFonteFk;
	}

	public TiposDeFolha getIdFolhaFk() {
		return idFolhaFk;
	}

	public void setIdFolhaFk(TiposDeFolha idFolhaFk) {
		this.idFolhaFk = idFolhaFk;
	}
    
    
}
