package com.alura.foro.domain.cursos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    public Curso findByNombre(String nombre);
}
