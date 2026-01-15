package com.Taller1.Posteo.Repository;

import com.Taller1.Posteo.Model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

}
