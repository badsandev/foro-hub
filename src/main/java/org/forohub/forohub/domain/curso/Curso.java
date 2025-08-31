package org.forohub.forohub.domain.curso;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "curso")
@Entity(name = "curso")
@AllArgsConstructor
@NoArgsConstructor
@Getter

@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private boolean activo;




    public Curso(@Valid DatosRegistroCurso datos) {
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
        this.activo = true;
    }


    public void eliminar() {
        this.activo = false;
    }
}
