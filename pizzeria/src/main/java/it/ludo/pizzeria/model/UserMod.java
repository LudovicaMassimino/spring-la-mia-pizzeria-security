package it.ludo.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class UserMod {

    @Id
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleMod> roles;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<RoleMod> getRoles() {
        return roles;
    }

}

