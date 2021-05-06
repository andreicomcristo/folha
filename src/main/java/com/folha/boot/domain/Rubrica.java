package com.folha.boot.domain;


import javax.persistence.*;



@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica")
public class Rubrica extends AbstractEntity<Long> {

	@Column(name = "valor")
    private Double valor;
    @Column(name = "percentagem")
    private Double percentagem;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_codigo_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaCodigo idCodigoFk;

    public Rubrica() {
    }

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public RubricaCodigo getIdCodigoFk() {
		return idCodigoFk;
	}

	public void setIdCodigoFk(RubricaCodigo idCodigoFk) {
		this.idCodigoFk = idCodigoFk;
	}
    
    
	
}
