package com.algaworks.socialbooks.repository;

import com.algaworks.socialbooks.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
