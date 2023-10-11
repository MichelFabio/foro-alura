package com.alura.foro.domain.topicos;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo,
                                 String mensaje,
                                 LocalDateTime fecha,
                                 String status,
                                 String autor,
                                 String curso) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatusRespuesta().toString(),topico.getUsuario().getNombre(),topico.getCurso().getNombre());
    }
}
