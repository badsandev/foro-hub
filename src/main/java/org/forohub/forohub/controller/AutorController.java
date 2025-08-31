package org.forohub.forohub.controller;

import jakarta.validation.Valid;
import org.forohub.forohub.domain.autor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Transactional
    @PostMapping
    public ResponseEntity<DatosDetalleAutor> crearAutor(@RequestBody @Valid DatosRegistroAutor datos, UriComponentsBuilder uriComponentsBuilder) {

        var Autor = new Autor(datos);

        autorRepository.save(Autor);

        var uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(Autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleAutor(Autor));


    }

    @GetMapping
    public ResponseEntity<Page<DatosListaAutor>> listar(
            @PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {

        var page = autorRepository.findByActivoTrue(paginacion).map(DatosListaAutor::new);
        return ResponseEntity.ok(page);
    }


    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        var autor = autorRepository.getReferenceById(id);
        autor.eliminar();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity Detalla(@PathVariable Long id) {
        var autor = autorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleAutor(autor));
    }




}
