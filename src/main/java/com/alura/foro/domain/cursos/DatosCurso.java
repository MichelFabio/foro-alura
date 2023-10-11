package com.alura.foro.domain.cursos;

public record DatosCurso(String nombre,
                         String categoria) {
    public DatosCurso(Curso curso){
        this(curso.getNombre(), curso.getCategoria());
    }
}
