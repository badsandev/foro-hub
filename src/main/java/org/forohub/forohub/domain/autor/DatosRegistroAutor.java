package org.forohub.forohub.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroAutor(

        @NotBlank String nombre



) {

}
