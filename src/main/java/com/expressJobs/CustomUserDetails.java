package com.expressJobs;


import com.expressJobs.models.Rol;
import com.expressJobs.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private Usuario usuario;

    public CustomUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Rol> roles = usuario.getRoles();
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//
//        for (Rol rol : roles) {
//            authorities.add(new SimpleGrantedAuthority(rol.getDes_rol()));
//        }
//
//        return authorities;
//    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getDes_rol()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
