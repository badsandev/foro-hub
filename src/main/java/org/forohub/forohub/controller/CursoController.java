package org.forohub.forohub.controller;


import org.apache.coyote.Response;
import org.forohub.forohub.domain.curso.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoService;

    @Transactional
    @PostMapping
    public  ResponseEntity crearCurso(@RequestBody DatosRegistroCurso datos, UriComponentsBuilder uriComponentsBuilder) {

        var curso = new Curso(datos);
        cursoService.save(curso);
        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();


        return ResponseEntity.created(uri).body(new DatosDetalleCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleCurso>> listarCursos(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        var page = cursoService.findByActivoTrue(paginacion).map(DatosDetalleCurso::new);

        return ResponseEntity.ok(page);


    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCurso(@PathVariable Long id) {
        var curso = cursoService.getReferenceById(id);
        curso.eliminar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity Detallar(@PathVariable Long id) {
        var curso = cursoService.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleCurso(curso));
    }







}
