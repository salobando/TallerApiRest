package com.Taller1.Posteo.Service;

import com.Taller1.Posteo.Model.Autor;
import com.Taller1.Posteo.Model.Posteo;
import com.Taller1.Posteo.Repository.AutorRepository;
import com.Taller1.Posteo.Repository.IposteoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IserviceAutor{

    private final AutorRepository autorRepository;
    private final IposteoRepository iposteoRepository;

    public AutorService(AutorRepository autorRepository, IposteoRepository iposteoRepository) {
        this.autorRepository = autorRepository;
        this.iposteoRepository = iposteoRepository;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> obtenerporId(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public void guardarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    @Override
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public void editarAutor(Long id, Autor autorActual) {

        Autor autorExistente = autorRepository.findById(id).orElse(null);

        if (autorExistente != null){
            //Actualizar los campos
            autorExistente.setEmail(autorActual.getEmail());
            autorExistente.setName(autorActual.getName());

            // Guardar
            autorRepository.save(autorExistente);
        } else {
            throw new RuntimeException("Autor no encontrado con el id: " + id);
        }
    }


    @Override
    public Autor asignarPosteo(Long posteoId, Long autorId) {
        Posteo posteo = iposteoRepository.findById(posteoId)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        posteo.setAuthor(autor);
        iposteoRepository.save(posteo);

        return autor;
    }

    @Override
    public List<Posteo> obtenerPosteosDeAutor(Long autorId) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        autor.getPosteos().size(); // fuerza lazy
        return autor.getPosteos();
    }
}
