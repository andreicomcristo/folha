package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfil")
public class Perfil extends AbstractEntity<Long> {

	@Basic(optional = false)
	@Column(name = "nome_perfil")
	private String nomePrivilegio;
	@Basic(optional = false)
	@Column(name = "descricao_perfil")
	private String descricaoPrivilegio;
	@OneToMany(mappedBy = "idPrivilegioFk")
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
		this.descricaoPrivilegio = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoPrivilegio);
	}

	public List<PessoaOperadores> getPessoaOperadoresList() {
		return pessoaOperadoresList;
	}

	public void setPessoaOperadoresList(List<PessoaOperadores> pessoaOperadoresList) {
		this.pessoaOperadoresList = pessoaOperadoresList;
	}

}
