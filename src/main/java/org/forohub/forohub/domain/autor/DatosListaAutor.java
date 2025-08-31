package org.forohub.forohub.domain.autor;

public record DatosListaAutor(
         Long id,
         String nombre

) {


    public DatosListaAutor(Autor autor) {

        this(autor.getId(),autor.getNombre());
    }


}
