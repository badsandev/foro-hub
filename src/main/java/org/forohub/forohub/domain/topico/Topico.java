package org.forohub.forohub.domain.topico;


import jakarta.persistence.*;
import org.forohub.forohub.domain.autor.Autor;
import org.forohub.forohub.domain.curso.Curso;

import java.time.LocalDate;

@Entity(name = "topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    LocalDate fecha_creacion;
    boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Autor id_autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso id_curso;



}
