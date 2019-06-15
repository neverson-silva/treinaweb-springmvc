package br.com.treinaweb.springmvc.security;

import br.com.treinaweb.springmvc.dominios.Usuario;
import br.com.treinaweb.springmvc.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class TreinaWebUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findByUsername(s);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getRole()));

        return new User(usuario.getUsername(), usuario.getPassword(), grantedAuthorities);
    }
}
