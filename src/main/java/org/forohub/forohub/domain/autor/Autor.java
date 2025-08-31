package org.forohub.forohub.domain.autor;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.forohub.forohub.domain.topico.Topico;

import java.util.List;

@Table(name = "autor")
@Entity(name = "autor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Autor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean activo;


    public Autor(@Valid DatosRegistroAutor datos) {
        this.nombre = datos.nombre();
    }

    public void eliminar() {
        this.activo = false;
    }
}
