package com.example.BlocNotas.service;

import com.example.BlocNotas.model.Post;
import java.util.List;

public interface IpostService {

    List<Post> obtenerTodos();
    Post obtenerPorId(Long id);
    void guardarPost(Post post);
    //metodos nuevos
    void deletePost (Long id);
    void editarPost (Long id, Post postActual);
}
