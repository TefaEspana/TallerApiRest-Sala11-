package com.example.BlocNotas.service;

import com.example.BlocNotas.model.Autor;
import com.example.BlocNotas.model.Post;
import com.example.BlocNotas.repository.IautoRepository;
import com.example.BlocNotas.repository.IpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService implements IautorService{

    private IautoRepository autoRepository;
    private IpostService postService;

    @Autowired

    public AutorService(IautoRepository autoRepository, IpostService postService) {
        this.autoRepository = autoRepository;
        this.postService = postService;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return autoRepository.findAll();
    }

    @Override
    public Autor obtenerPorId(Long id) {
        return autoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarAutor(Autor autor) {
        autoRepository.save(autor);
    }

    @Override
    public void deleteAutor(Long id) {
        autoRepository.deleteById(id);

    }

    @Override
    public void editarAutor(Long id, Autor autorActual) {
        //saber si existe
        Autor autorExiste = autoRepository.findById(id).orElse(null);
        //
        if (autorExiste != null){
            //Actualizar los campos del autor
            autorExiste.setNombre(autorActual.getNombre());
            autorExiste.setCorreo(autorActual.getCorreo());
            //guardar el autor
            autoRepository.save(autorExiste);
        }else {
            throw new RuntimeException("Autor NO encontrado con ese Id: "+id);
        }
    }

    @Override
    public void asignarPostAAutor(Long idAutor, Long idPost) {
        Autor autor = obtenerPorId(idAutor);
        Post post = postService.obtenerPorId(idPost);

        if (autor != null && post != null) {
            post.setAutor(autor);
            autor.getPosts().add(post);
            autoRepository.save(autor);
        }
    }

    @Override
    public void guardarPostConAutor(Autor autor, Post post) {
        post.setAutor(autor);
        autor.getPosts().add(post);
        autoRepository.save(autor);
    }
}
