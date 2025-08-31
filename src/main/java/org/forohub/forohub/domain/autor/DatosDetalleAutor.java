package org.forohub.forohub.domain.autor;

public record DatosDetalleAutor(

        Long id,
        String nombre


) {
    public DatosDetalleAutor(Autor autor) {

        this(autor.getId(), autor.getNombre());
    }
}
