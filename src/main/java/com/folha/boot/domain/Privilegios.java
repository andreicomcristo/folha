package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "privilegios")
public class Privilegios extends AbstractEntity<Long> {

	@Column(name = "nome_privilegio", nullable = false, length = 300)
	private String nomePrivilegio;

	@Basic(optional = false)
	@Column(name = "descricao_privilegio", nullable = false, length = 3000)
	private String descricaoPrivilegio;

	@OneToMany(mappedBy = "seqPrivilegio")
	private List<PessoaOperadores> pessoaOperadoresList;

	public String getNomePrivilegio() {
		return nomePrivilegio;
	}

	public void setNomePrivilegio(String nomePrivilegio) {
		this.nomePrivilegio = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomePrivilegio);
	}

	public String getDescricaoPrivilegio() {
		return descricaoPrivilegio;
	}

	public void setDescricaoPrivilegio(String descricaoPrivilegio) {
		this.descricaoPrivilegio = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoPrivilegio);
	}

	public List<PessoaOperadores> getPessoaOperadoresList() {
		return pessoaOperadoresList;
	}

	public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
		this.pessoaOperadoresList = pessoaOperadoresList;
	}

}
