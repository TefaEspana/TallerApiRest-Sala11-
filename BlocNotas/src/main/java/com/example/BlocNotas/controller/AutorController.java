package com.example.BlocNotas.controller;

import com.example.BlocNotas.model.Autor;
import com.example.BlocNotas.model.Post;
import com.example.BlocNotas.service.AutorService;
import com.example.BlocNotas.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;
    private final PostService postService;

    @Autowired

    public AutorController(AutorService autorService, PostService postService) {
        this.autorService = autorService;
        this.postService = postService;
    }

    @GetMapping // traer a todos los autores
    public List<Autor> listaAutor(){
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}") // "/{id}" pad variable
    public Autor obtenerPorId(@PathVariable Long id){
        return autorService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarAutor(@RequestBody Autor autor) {
        autorService.guardarAutor(autor);
        return ResponseEntity.ok("Autor agregado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable Long id){
        autorService.deleteAutor(id);
        return  ResponseEntity.ok("Autor eliminado exitosamente");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarAutor(@PathVariable Long id, @RequestBody Autor autor){
        autorService.editarAutor(id,autor);
        return  ResponseEntity.ok("Autor editado exitosamente");
    }

    @PostMapping("/{idAutor}/asignar-post/{idPost}")
    public ResponseEntity<String> asignarPostAutor(
            @PathVariable Long idAutor,
            @PathVariable Long idPost) {
        autorService.asignarPostAAutor(idAutor, idPost);
        return ResponseEntity.ok("Post asignado al Autor con éxito");
    }
    @PostMapping("/crear-con-post")
    public ResponseEntity<String> guardarAutorConPost(
            @RequestBody Autor autor,
            @RequestParam(required = false) Long idPost) {
        if (idPost != null) {
            Post post = postService.obtenerPorId(idPost);
            autorService.guardarPostConAutor(autor, post);
        } else {
            autorService.guardarAutor(autor);
        }
        return ResponseEntity.ok("Autor creado " + (idPost != null ? "con post" : "") + " con éxito");
    }
}
