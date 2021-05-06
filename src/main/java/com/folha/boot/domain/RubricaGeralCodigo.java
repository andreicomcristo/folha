package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_geral_codigo")
public class RubricaGeralCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeralFuncionario> rubricaGeralSomaFuncionarioList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<RubricaGeral> rubricaGeralSomaList;
    @JoinColumn(name = "id_natureza_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaNatureza idNaturezaFk;
    public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(codigo);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}
	public List<RubricaGeralFuncionario> getRubricaGeralSomaFuncionarioList() {
		return rubricaGeralSomaFuncionarioList;
	}
	public void setRubricaGeralSomaFuncionarioList(List<RubricaGeralFuncionario> rubricaGeralSomaFuncionarioList) {
		this.rubricaGeralSomaFuncionarioList = rubricaGeralSomaFuncionarioList;
	}
	public List<RubricaGeral> getRubricaGeralSomaList() {
		return rubricaGeralSomaList;
	}
	public void setRubricaGeralSomaList(List<RubricaGeral> rubricaGeralSomaList) {
		this.rubricaGeralSomaList = rubricaGeralSomaList;
	}
	public RubricaNatureza getIdNaturezaFk() {
		return idNaturezaFk;
	}
	public void setIdNaturezaFk(RubricaNatureza idNaturezaFk) {
		this.idNaturezaFk = idNaturezaFk;
	}
    
    
	
}
