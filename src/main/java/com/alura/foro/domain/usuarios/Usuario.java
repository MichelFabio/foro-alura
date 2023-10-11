package com.alura.foro.domain.usuarios;


import com.alura.foro.domain.respuestas.Respuesta;
import com.alura.foro.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    private String contrasena;
    @OneToMany(mappedBy = "usuario")
    private List<Topico> topicos = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas = new ArrayList<>();

    public Usuario(DatosUsuario datosUsuario) {
        this.nombre = datosUsuario.nombre();
        this.email = datosUsuario.email();
    }


}
