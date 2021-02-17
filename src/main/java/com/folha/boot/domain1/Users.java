// Generated with g9.

package com.folha.boot.domain1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name="users")
public class Users implements Serializable {

    /** Primary key. */
    protected static final String PK = "username";

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

    @Id
    @Column(unique=true, nullable=false, length=50)
    private String username;
    @Column(nullable=false, length=200)
    private String password;
    @Column(nullable=false)
    private boolean enabled;
    @OneToOne(mappedBy="users")
    private Authorities authorities;

    /** Default constructor. */
    public Users() {
        super();
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for enabled.
     *
     * @return true if and only if enabled is currently true
     */
    public boolean getEnabled() {
        return enabled;
    }

    /**
     * Setter method for enabled.
     *
     * @param aEnabled the new value for enabled
     */
    public void setEnabled(boolean aEnabled) {
        enabled = aEnabled;
    }

    /**
     * Access method for authorities.
     *
     * @return the current value of authorities
     */
    public Authorities getAuthorities() {
        return authorities;
    }

    /**
     * Setter method for authorities.
     *
     * @param aAuthorities the new value for authorities
     */
    public void setAuthorities(Authorities aAuthorities) {
        authorities = aAuthorities;
    }

    /**
     * Compares the key for this instance with another Users.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Users and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Users)) {
            return false;
        }
        Users that = (Users) other;
        Object myUsername = this.getUsername();
        Object yourUsername = that.getUsername();
        if (myUsername==null ? yourUsername!=null : !myUsername.equals(yourUsername)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Users.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Users)) return false;
        return this.equalKeys(other) && ((Users)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        if (getUsername() == null) {
            i = 0;
        } else {
            i = getUsername().hashCode();
        }
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Users |");
        sb.append(" username=").append(getUsername());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("username", getUsername());
        return ret;
    }

}
