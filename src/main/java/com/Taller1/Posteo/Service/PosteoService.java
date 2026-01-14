package com.Taller1.Posteo.Service;

import com.Taller1.Posteo.Model.Posteo;
import com.Taller1.Posteo.Repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IservicePosteo{

    private final IposteoRepository IposteoRepository;

    //inyeccion por constructor para acceder al repositorio
    @Autowired
    public PosteoService(IposteoRepository iposteoRepository) {
        IposteoRepository = iposteoRepository;
    }


    @Override
    public List<Posteo> obtenerTodos() {
        return IposteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerporId(Long id) {
        return IposteoRepository.findById(id);
    }

    @Override
    public void guardarPosteo(Posteo posteo) {
        IposteoRepository.save(posteo);
    }

    @Override
    public void eliminarPosteo(Long id) {
        IposteoRepository.deleteById(id);
    }

    @Override
    public void editarPosteo(Long id, Posteo posteoActual) {
        //Saber si exsite
        Posteo posteoExistente = IposteoRepository.findById(id).orElse(null);

        if (posteoExistente != null){
            //Actualizar los campos de persona existente
            posteoExistente.setContenido(posteoActual.getContenido());
            posteoExistente.setTitulo(posteoActual.getTitulo());
            posteoExistente.setFechaCreacion(posteoActual.getFechaCreacion());

            // Guardo a la persona actualziada
            IposteoRepository.save(posteoExistente);
        } else {
            throw new RuntimeException("Posteo no encontrado con el id: " + id);
        }
    }
}
