package com.example.BlocNotas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Autor;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String correo;

    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public Autor() {
    }

    public Autor(Long id_Autor, String nombre, String correo, List<Post> posts) {
        this.id_Autor = id_Autor;
        this.nombre = nombre;
        this.correo = correo;
        this.posts = posts;
    }

    public Long getId_Autor() {
        return id_Autor;
    }

    public void setId_Autor(Long id_Autor) {
        this.id_Autor = id_Autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

