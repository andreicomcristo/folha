package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "fonte")
public class Fonte extends AbstractEntity<Long> {

	@Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idFonteFk")
    private List<RubricaCodigo> rubricaCodigoList;
    @OneToMany(mappedBy = "idFonteFk")
    private List<CodigoDiferenciado> codigoDiferenciadoList;

    public Fonte() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nome);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}

	public List<RubricaCodigo> getRubricaCodigoList() {
		return rubricaCodigoList;
	}

	public void setRubricaCodigoList(List<RubricaCodigo> rubricaCodigoList) {
		this.rubricaCodigoList = rubricaCodigoList;
	}

	public List<CodigoDiferenciado> getCodigoDiferenciadoList() {
		return codigoDiferenciadoList;
	}

	public void setCodigoDiferenciadoList(List<CodigoDiferenciado> codigoDiferenciadoList) {
		this.codigoDiferenciadoList = codigoDiferenciadoList;
	}
    
    
      
}
