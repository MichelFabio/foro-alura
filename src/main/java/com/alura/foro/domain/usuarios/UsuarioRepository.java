package com.alura.foro.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByNombre(String user);

    Usuario findByEmail(String email);
}
