package org.auctionsense.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.checkIfAlreadyExists", query = "from User where username = :username"),
})
@UserDefinition 
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Username
    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 4, max = 16, message = "Username should have a size of [{min}, {max}]")
    private String username;

    @Password
    private String password;

    @Roles
    private String role = "user";

    public User() {
    }
    
    public User(SecurityIdentity identity) {
        this.username = identity.getPrincipal().getName();
    }

    public UUID getId() {
        return id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
