package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "enderecos")
public class Enderecos extends AbstractEntity<Long> {
	
	@Column(name = "endereco_logradouro", nullable = false, length = 300)
	private String enderecoLogradouro;

	@Column(name = "endereco_numero", length = 20)
	private String enderecoNumero;

	@Column(name = "endereco_complemento", length = 300)
	private String enderecoComplemento;

	@Column(name = "endereco_bairro", length = 300)
	private String enderecoBairro;

	@Column(name = "endereco_cep", length = 20)
	private String enderecoCep;

	@JoinColumn(name = "id_endereco_cidade_fk", referencedColumnName = "id")
	@ManyToOne
	private Cidades idEnderecoCidadeFk;

	@JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Pessoa idPessoaFk;

	@JoinColumn(name = "id_tipo_logradouro_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private TiposLogradouro idTipoLogradouroFk;

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoLogradouro);
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoNumero);
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoComplemento);
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoBairro);
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecoCep);
	}

	public Cidades getIdEnderecoCidadeFk() {
		return idEnderecoCidadeFk;
	}

	public void setIdEnderecoCidadeFk(Cidades idEnderecoCidadeFk) {
		this.idEnderecoCidadeFk = idEnderecoCidadeFk;
	}

	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}

	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}

	public TiposLogradouro getIdTipoLogradouroFk() {
		return idTipoLogradouroFk;
	}

	public void setIdTipoLogradouroFk(TiposLogradouro idTipoLogradouroFk) {
		this.idTipoLogradouroFk = idTipoLogradouroFk;
	}

	

}
