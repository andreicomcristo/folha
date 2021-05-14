package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "classes_carreira")
public class ClassesCarreira extends AbstractEntity<Long> {

	@Column(name = "sigla_classe", nullable = false, length = 10)
	private String siglaClasse;

	@Column(name = "nome_classe", nullable = false, length = 150)
	private String nomeClasse;

	@Column(name = "descricao_classe", length = 300)
	private String descricaoClasse;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasseFk")
	private List<HistFuncionariosClasse> histFuncionariosClasseList;

	@OneToMany(mappedBy = "idClasseCarreiraAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
	
	@OneToMany(mappedBy = "idClasseCarreiraFk")
    private List<FaixasValoresGpf> faixasValoresGpfList;
	
	@OneToMany(mappedBy = "idClasseCarreiraFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;
	
	public String getSiglaClasse() {
		return siglaClasse;
	}

	public void setSiglaClasse(String siglaClasse) {
		this.siglaClasse = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaClasse);
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeClasse);
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasseList() {
		return histFuncionariosClasseList;
	}

	public void setHistFuncionariosClasseList(List<HistFuncionariosClasse> histFuncionariosClasseList) {
		this.histFuncionariosClasseList = histFuncionariosClasseList;
	}

	public String getDescricaoClasse() {
		return descricaoClasse;
	}

	public void setDescricaoClasse(String descricaoClasse) {
		this.descricaoClasse = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoClasse);
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}

	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}

	public List<FaixasValoresGpf> getFaixasValoresGpfList() {
		return faixasValoresGpfList;
	}

	public void setFaixasValoresGpfList(List<FaixasValoresGpf> faixasValoresGpfList) {
		this.faixasValoresGpfList = faixasValoresGpfList;
	}
	
	
}
