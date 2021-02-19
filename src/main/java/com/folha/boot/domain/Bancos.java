package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "bancos")
public class Bancos extends AbstractEntity<Long> {

	@Column(name = "codigo_banco", nullable = false, length = 50)
	private String codigoBanco;

	@Column(name = "nome_banco", nullable = false, length = 300)
	private String nomeBanco;

	@Column(name = "sigla_banco", length = 150)
	private String siglaBanco;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idBancoFk") 
	private List<PessoaBancos> pessoaBancosList;

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(codigoBanco);
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeBanco);
	}

	public String getSiglaBanco() {
		return siglaBanco;
	}

	public void setSiglaBanco(String siglaBanco) {
		this.siglaBanco = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaBanco);
	}

	public List<PessoaBancos> getPessoaBancosList() {
		return pessoaBancosList;
	}

	public void setPessoaBancosList(List<PessoaBancos> pessoaBancosList) {
		this.pessoaBancosList = pessoaBancosList; 
	}

}
