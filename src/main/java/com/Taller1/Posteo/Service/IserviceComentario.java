package com.Taller1.Posteo.Service;

import com.Taller1.Posteo.Model.Comentario;

import java.util.List;
import java.util.Optional;

public interface IserviceComentario {
    List<Comentario> obtenerTodos();
    Optional<Comentario> obtenerporId(Long id);
    void guardarComentario(Comentario comentario);

    void eliminarComentario(Long id);
    void editarComentario(Long id, Comentario comentarioActual);
}
