package com.example.BlocNotas.repository;

import com.example.BlocNotas.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.awt.*;
import java.util.List;

@Repository
public interface IpostRepository extends JpaRepository<Post, Long> {

//    List<Post> findAll();
//    Post findById(Long id);
//    void save(Post post);
}
