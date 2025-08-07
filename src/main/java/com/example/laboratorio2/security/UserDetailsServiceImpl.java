package com.example.laboratorio2.security;
import com.example.laboratorio2.model.Usuario;
import com.example.laboratorio2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService {
      @Autowired
    private UsuarioRepository UsuarioRepository; 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por su nombre de usuario
        // Si no se encuentra, lanzar una excepción
         Usuario usuario = UsuarioRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
// Crear y retornar un objeto UserDetails con la información del usuario
        // Aquí se puede agregar más información como roles, permisos, etc.
        // Por simplicidad, se asume que el usuario tiene un rol único
        // y que el rol se almacena en la entidad Usuario.
        return new User(
            usuario.getUsername(),
            usuario.getPassword(),
            usuario.isEnabled(),
            true, true, true, 
            Collections.singleton(new SimpleGrantedAuthority("ROLE_"+ usuario.getRol().getNombre()))
        );
    }

}
