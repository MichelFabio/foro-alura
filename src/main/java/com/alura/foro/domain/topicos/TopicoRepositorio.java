package com.alura.foro.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepositorio extends JpaRepository<Topico,Long> {
    List<Topico> findByActivoTrue();
    List<Topico> findByTitulo(String titulo);
}
