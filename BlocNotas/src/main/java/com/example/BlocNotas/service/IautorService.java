package com.example.BlocNotas.service;

import com.example.BlocNotas.model.Autor;
import com.example.BlocNotas.model.Post;

import java.util.List;

public interface IautorService {
    List<Autor> obtenerTodos();
    Autor obtenerPorId(Long id);
    void guardarAutor(Autor autor);
    void deleteAutor (Long id);
    void editarAutor (Long id, Autor autorActual);
    void asignarPostAAutor(Long idAutor, Long idPost);
    void guardarPostConAutor(Autor autor, Post post);
}
