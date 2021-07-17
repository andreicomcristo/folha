package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "categoria_de_licenca")
public class CategoriaDeLicenca extends AbstractEntity<Long> {

	@Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idCategoriaFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}
	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}
    
    
      
}
