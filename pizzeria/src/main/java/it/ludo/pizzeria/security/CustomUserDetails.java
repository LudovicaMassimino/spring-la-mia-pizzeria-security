package it.ludo.pizzeria.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.ludo.pizzeria.model.RoleMod;
import it.ludo.pizzeria.model.UserMod;

public class CustomUserDetails implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public CustomUserDetails(UserMod user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        authorities = new HashSet<GrantedAuthority>();
        for (RoleMod role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return null;
    }

    @Override
    public String getPassword() {
        
        return null;
    }

    @Override
    public String getUsername() {
        
        return null;
    }

}