package com.example.BlocNotas.repository;

import com.example.BlocNotas.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IautoRepository extends JpaRepository<Autor, Long> {
}
