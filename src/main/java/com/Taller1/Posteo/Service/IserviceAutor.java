package com.Taller1.Posteo.Service;

import com.Taller1.Posteo.Model.Autor;
import com.Taller1.Posteo.Model.Posteo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IserviceAutor {
    List<Autor> obtenerTodos();
    Optional<Autor> obtenerporId(Long id);
    void guardarAutor(Autor autor);

    void eliminarAutor(Long id);
    void editarAutor(Long id, Autor autorActual);

    Autor asignarPosteo(Long posteoId, Long autorId);

    List<Posteo> obtenerPosteosDeAutor(Long autorId);
}
