package com.alura.foro.controller;

import com.alura.foro.domain.cursos.Curso;
import com.alura.foro.domain.cursos.CursoRepository;
import com.alura.foro.domain.cursos.DatosCurso;
import com.alura.foro.domain.topicos.*;
import com.alura.foro.domain.usuarios.DatosUsuario;
import com.alura.foro.domain.usuarios.Usuario;
import com.alura.foro.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    TopicoRepositorio topicoRepositorio;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> agregarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        Topico topico  = new Topico(datosRegistroTopico);
        topico.setCurso(cursoDtoToEntity(datosRegistroTopico.curso()));
        topico.setUsuario(userDtoToEntity(datosRegistroTopico.usuario()));
        Topico topicoDb = topicoRepositorio.save(topico);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topicoDb.getTitulo(),
                topicoDb.getMensaje(),datosRegistroTopico.usuario(),
                datosRegistroTopico.curso());
        return ResponseEntity.ok(datosRespuestaTopico);
    }

    @GetMapping
    public List<DatosListadoTopico> listar(){
        List<Topico> prueba = topicoRepositorio.findAll();
        return prueba.stream().map(topico -> new DatosListadoTopico(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatusRespuesta().toString(),topico.getUsuario().getNombre(),topico.getCurso().getNombre())).toList();


    }
    @GetMapping("/{id}")
    public DatosListadoTopico mostrarTopico(@PathVariable Long id){
        Topico topico = topicoRepositorio.getReferenceById(id);
        return new DatosListadoTopico(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatusRespuesta().toString(),topico.getUsuario().getNombre(),topico.getCurso().getNombre());

    }

    private Usuario userDtoToEntity(DatosUsuario user){
        Usuario userDb = null;
        if(user != null){
            userDb = usuarioRepository.findByEmail(user.email());
            if(userDb == null){
                userDb = new Usuario(user);
            }
        }
        return userDb;
    }
    private Curso cursoDtoToEntity(DatosCurso curso){
        Curso cursoDb = null;
        if (curso != null){
            cursoDb = cursoRepository.findByNombre(curso.nombre());
            if(cursoDb == null){
                cursoDb = new Curso(curso);
            }
        }
        return cursoDb;
    }

}
