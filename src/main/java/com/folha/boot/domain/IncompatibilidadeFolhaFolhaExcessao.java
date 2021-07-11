package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "incompatibilidade_folha_folha_excessao")
public class IncompatibilidadeFolhaFolhaExcessao extends AbstractEntity<Long> {

	@Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaFuncionarios idFuncionarioFk;
    @JoinColumn(name = "id_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idFolhaFk;
    @JoinColumn(name = "id_folha_incompativel_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idFolhaIncompativelFk;

    public IncompatibilidadeFolhaFolhaExcessao() {
    }

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacao);
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}

	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}

	public TiposDeFolha getIdFolhaFk() {
		return idFolhaFk;
	}

	public void setIdFolhaFk(TiposDeFolha idFolhaFk) {
		this.idFolhaFk = idFolhaFk;
	}

	public TiposDeFolha getIdFolhaIncompativelFk() {
		return idFolhaIncompativelFk;
	}

	public void setIdFolhaIncompativelFk(TiposDeFolha idFolhaIncompativelFk) {
		this.idFolhaIncompativelFk = idFolhaIncompativelFk;
	}
    
    
      
}
