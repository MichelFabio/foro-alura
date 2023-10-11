package com.alura.foro.domain.topicos;

import com.alura.foro.domain.cursos.DatosCurso;
import com.alura.foro.domain.usuarios.DatosUsuario;

public record DatosRespuestaTopico(String titulo,
                                   String mensaje,
                                   DatosUsuario datosUsuario,
                                   DatosCurso datosCurso) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), new DatosUsuario(topico.getUsuario().getNombre(),
                topico.getUsuario().getEmail()),new DatosCurso(topico.getCurso().getNombre(),topico.getCurso().getCategoria()));
    }

}
