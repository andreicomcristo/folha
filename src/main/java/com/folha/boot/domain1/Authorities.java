// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="authorities", indexes={@Index(name="authorities_authority_IX", columnList="authority", unique=true), @Index(name="authoritiesIxAuthUsername", columnList="username,authority", unique=true)})
public class Authorities implements Serializable {

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="last_update")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Column(unique=true, nullable=false, length=50)
    private String authority;
    @OneToOne(optional=false, mappedBy="authorities")
    @JoinColumn(name="username", nullable=false)
    private Users users;

    /** Default constructor. */
    public Authorities() {
        super();
    }

    /**
     * Access method for authority.
     *
     * @return the current value of authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Setter method for authority.
     *
     * @param aAuthority the new value for authority
     */
    public void setAuthority(String aAuthority) {
        authority = aAuthority;
    }

    /**
     * Access method for users.
     *
     * @return the current value of users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Setter method for users.
     *
     * @param aUsers the new value for users
     */
    public void setUsers(Users aUsers) {
        users = aUsers;
    }

    /**
     * Gets the group fragment username for member users.
     *
     * @return Current value of the group fragment
     * @see Users
     */
    public String getUsersUsername() {
        return (getUsers() == null ? null : getUsers().getUsername());
    }

    /**
     * Sets the group fragment username from member users.
     *
     * @param aUsername New value for the group fragment
     * @see Users
     */
    public void setUsersUsername(String aUsername) {
        if (getUsers() != null) {
            getUsers().setUsername(aUsername);
        }
    }

}
