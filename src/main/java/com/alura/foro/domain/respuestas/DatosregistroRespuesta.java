package com.alura.foro.domain.respuestas;

import com.alura.foro.domain.topicos.DatosRegistroTopico;
import com.alura.foro.domain.usuarios.DatosUsuario;

public record DatosregistroRespuesta(String mensaje,
                                     DatosRegistroTopico topico,
                                     DatosUsuario usuario
                                     ) {
}
