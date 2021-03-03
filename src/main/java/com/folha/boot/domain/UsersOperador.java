package com.folha.boot.domain;

import java.math.BigInteger;

import javax.persistence.*;

@SuppressWarnings("serial")
public class UsersOperador extends AbstractEntity<Long> {
	
	@Column(name = "id")
    private BigInteger id;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pessoa_operadores_fk")
    private Long idPessoaOperadoresFk;
    @JoinColumn(name = "id_pessoa_operadores_fk", referencedColumnName = "id", insertable = false, updatable = false)
    
    @OneToOne(optional = false)
    private PessoaOperadores pessoaOperadores;
    
    @JoinColumn(name = "username_fk", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users usernameFk;
	
    
    /*public BigInteger getId() {
		return id;
	}
    
	public void setId(BigInteger id) {
		this.id = id;
	}*/
    
	public Long getIdPessoaOperadoresFk() {
		return idPessoaOperadoresFk;
	}
	public void setIdPessoaOperadoresFk(Long idPessoaOperadoresFk) {
		this.idPessoaOperadoresFk = idPessoaOperadoresFk;
	}
	public PessoaOperadores getPessoaOperadores() {
		return pessoaOperadores;
	}
	public void setPessoaOperadores(PessoaOperadores pessoaOperadores) {
		this.pessoaOperadores = pessoaOperadores;
	}
	public Users getUsernameFk() {
		return usernameFk;
	}
	public void setUsernameFk(Users usernameFk) {
		this.usernameFk = usernameFk;
	}
    
    
}
