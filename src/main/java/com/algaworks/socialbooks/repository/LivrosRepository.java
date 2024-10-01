package com.algaworks.socialbooks.repository;

import com.algaworks.socialbooks.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livro, Long> {



}
