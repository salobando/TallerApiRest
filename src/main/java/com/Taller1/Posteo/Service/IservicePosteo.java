package com.Taller1.Posteo.Service;

import com.Taller1.Posteo.Model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IservicePosteo {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerporId(Long id);
    void guardarPosteo(Posteo posteo);

    void eliminarPosteo(Long id);
    void editarPosteo(Long id, Posteo posteoActual);
}
