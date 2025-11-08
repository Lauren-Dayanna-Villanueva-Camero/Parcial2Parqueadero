package com.usco.Parcial2Parqueadero.security;

import com.usco.Parcial2Parqueadero.Repository.UsuarioRepository;
import com.usco.Parcial2Parqueadero.model.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MiUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public MiUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔍 Buscando usuario por email: " + username);

        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseGet(() -> usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username)));

        System.out.println("✅ Usuario encontrado: " + usuario.getEmail());
        System.out.println("🔑 Password hash: " + usuario.getPassword());
        System.out.println("👤 Rol: " + usuario.getRol().getNombre());

        return User.builder()
                .username(usuario.getEmail())  // usamos email como username
                .password(usuario.getPassword())  // debe estar encriptada
                .roles(usuario.getRol().getNombre())
                .build();
    }
}