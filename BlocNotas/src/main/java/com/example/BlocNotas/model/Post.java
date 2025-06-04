package com.example.BlocNotas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Post;
    @Column(nullable = false, length = 100)
    private String titulo;
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;
    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn (name = "id_Autor")
    @JsonBackReference
    private Autor autor;


    public Post() {
    }

    public Post(Long id_Post, String titulo, String contenido, LocalDate fecha, Autor autor) {
        this.id_Post = id_Post;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
    }

    public Long getId_Post() {
        return id_Post;
    }

    public void setId_Post(Long id_Post) {
        this.id_Post = id_Post;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
