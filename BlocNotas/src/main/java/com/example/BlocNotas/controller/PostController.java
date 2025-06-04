package com.example.BlocNotas.controller;


import com.example.BlocNotas.model.Post;
import com.example.BlocNotas.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    @Autowired

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping // traer a todos los post
    public List<Post> listaPost(){
        return postService.obtenerTodos();
    }

    @GetMapping("/{id}") // "/{id}" pad variable
    public Post obtenerPorId(@PathVariable Long id){
        return postService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarPost(@RequestBody Post post) {
        postService.guardarPost(post);
        return ResponseEntity.ok("Post agregado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPost(@PathVariable Long id){
        postService.deletePost(id);
        return  ResponseEntity.ok("Post eliminado exitosamente");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPost(@PathVariable Long id, @RequestBody Post post){
        postService.editarPost(id,post);
        return  ResponseEntity.ok("Post editado exitosamente");
    }
}
