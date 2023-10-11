package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.DatosCurso;
import com.alura.foro.domain.usuarios.DatosUsuario;

public record DatosRegistroTopico(Long id,
                                  String titulo,
                                  String mensaje,
                                  DatosUsuario usuario,
                                  DatosCurso curso
                                  ) {
}
