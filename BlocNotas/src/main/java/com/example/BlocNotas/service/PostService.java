package com.example.BlocNotas.service;

import com.example.BlocNotas.model.Post;
import com.example.BlocNotas.repository.IpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService implements IpostService{

    private final IpostRepository postRepository;

    @Autowired

    public PostService(IpostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> obtenerTodos() {
        return postRepository.findAll();
    }

    @Override
    public Post obtenerPorId(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void editarPost(Long id, Post postActual) {
        //saber si existe
        Post postExiste = postRepository.findById(id).orElse(null);
        //
        if (postExiste != null){
            //Actualizar los campos del post
            postExiste.setTitulo(postActual.getTitulo());
            postExiste.setContenido(postActual.getContenido());
            postExiste.setFecha(postActual.getFecha());
            //guardar el post
            postRepository.save(postExiste);
        }else {
            throw new RuntimeException("Post no encontrado con ese Id: "+id);
        }
    }
}
