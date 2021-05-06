package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "rubrica_codigo")
public class RubricaCodigo extends AbstractEntity<Long> {

	@Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "variacao")
    private String variacao;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<Rubrica> rubricaList;
    @OneToMany(mappedBy = "idCodigoFk")
    private List<VencimentosFuncionario> rubricaFuncionarioList;
    @JoinColumn(name = "id_natureza_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaNatureza idNaturezaFk;
    @JoinColumn(name = "id_tipo_fk", referencedColumnName = "id")
    @ManyToOne
    private RubricaTipo idTipoFk;

    public RubricaCodigo() {
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVariacao() {
		return variacao;
	}

	public void setVariacao(String variacao) {
		this.variacao = variacao;
	}

	public List<Rubrica> getRubricaList() {
		return rubricaList;
	}

	public void setRubricaList(List<Rubrica> rubricaList) {
		this.rubricaList = rubricaList;
	}

	public List<VencimentosFuncionario> getRubricaFuncionarioList() {
		return rubricaFuncionarioList;
	}

	public void setRubricaFuncionarioList(List<VencimentosFuncionario> rubricaFuncionarioList) {
		this.rubricaFuncionarioList = rubricaFuncionarioList;
	}

	public RubricaNatureza getIdNaturezaFk() {
		return idNaturezaFk;
	}

	public void setIdNaturezaFk(RubricaNatureza idNaturezaFk) {
		this.idNaturezaFk = idNaturezaFk;
	}

	public RubricaTipo getIdTipoFk() {
		return idTipoFk;
	}

	public void setIdTipoFk(RubricaTipo idTipoFk) {
		this.idTipoFk = idTipoFk;
	}
    
    
    
    
	
}
