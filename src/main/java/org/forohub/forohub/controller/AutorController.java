package org.forohub.forohub.controller;

import jakarta.validation.Valid;
import org.forohub.forohub.domain.autor.Autor;
import org.forohub.forohub.domain.autor.AutorRepository;
import org.forohub.forohub.domain.autor.DatosRegistroAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    private void crearAutor(@RequestBody @Valid DatosRegistroAutor datos) {

        var Autor = new Autor(datos);

        autorRepository.save(Autor);


    }



}
