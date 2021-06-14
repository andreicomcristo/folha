package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "vinculos")
public class Vinculos extends AbstractEntity<Long> {

	@Column(name = "nome_vinculo", nullable = false, length = 100)
	private String nomeVinculo;

	@Column(name = "descricao_vinculo", length = 300)
	private String descricaoVinculo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculoFk")
	private List<HistFuncionariosVinculos> histFuncionariosVinculosList;

	@OneToMany(mappedBy = "idVinculoAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    
    @OneToMany(mappedBy = "idVinculoAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    
    @OneToMany(mappedBy = "idVinculoFk")
    private List<TiposDeFolhaVinculo> tiposDeFolhaVinculoList;
    
    @OneToMany(mappedBy = "idVinculoFk")
    private List<FaixasValoresGpfCedido> faixasValoresGpfCedidoList;
    
	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}
	
	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeVinculo() {
		return nomeVinculo;
	}

	public void setNomeVinculo(String nomeVinculo) {
		this.nomeVinculo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeVinculo);
	}

	public String getDescricaoVinculo() {
		return descricaoVinculo;
	}

	public void setDescricaoVinculo(String descricaoVinculo) {
		this.descricaoVinculo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoVinculo);
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
		return histFuncionariosVinculosList;
	}

	public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
		this.histFuncionariosVinculosList = histFuncionariosVinculosList;
	}

	public List<TiposDeFolhaVinculo> getTiposDeFolhaVinculoList() {
		return tiposDeFolhaVinculoList;
	}

	public void setTiposDeFolhaVinculoList(List<TiposDeFolhaVinculo> tiposDeFolhaVinculoList) {
		this.tiposDeFolhaVinculoList = tiposDeFolhaVinculoList;
	}

	public List<FaixasValoresGpfCedido> getFaixasValoresGpfCedidoList() {
		return faixasValoresGpfCedidoList;
	}

	public void setFaixasValoresGpfCedidoList(List<FaixasValoresGpfCedido> faixasValoresGpfCedidoList) {
		this.faixasValoresGpfCedidoList = faixasValoresGpfCedidoList;
	}
	
	
}
