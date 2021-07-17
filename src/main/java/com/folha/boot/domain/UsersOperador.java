package com.folha.boot.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
public class UsersOperador extends AbstractEntity<Long> {

	@JoinColumn(name = "id_pessoa_operadores_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private PessoaOperadores idPessoaOperadoresFk;
	
	@JoinColumn(name = "username_fk", referencedColumnName = "username")
	@ManyToOne(optional = false)
	private Users usernameFk;

	public PessoaOperadores getIdPessoaOperadoresFk() {
		return idPessoaOperadoresFk;
	}

	public void setIdPessoaOperadoresFk(PessoaOperadores idPessoaOperadoresFk) {
		this.idPessoaOperadoresFk = idPessoaOperadoresFk;
	}

	public Users getUsernameFk() {
		return usernameFk;
	}

	public void setUsernameFk(Users usernameFk) {
		this.usernameFk = usernameFk;
	}
}
