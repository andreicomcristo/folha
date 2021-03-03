package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
public class Users extends AbstractEntity<Long>{

	@Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usernameFk")
    private List<UsersOperador> usersOperadorList;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<UsersOperador> getUsersOperadorList() {
		return usersOperadorList;
	}
	public void setUsersOperadorList(List<UsersOperador> usersOperadorList) {
		this.usersOperadorList = usersOperadorList;
	}
    
}
