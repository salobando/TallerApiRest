package com.Taller1.Posteo.Service;

import com.Taller1.Posteo.Model.Comentario;
import com.Taller1.Posteo.Model.Posteo;
import com.Taller1.Posteo.Repository.ComentarioRepository;
import com.Taller1.Posteo.Repository.IposteoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IserviceComentario {

    private final ComentarioRepository comentarioRepository;
    private final IposteoRepository iposteoRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, IposteoRepository iposteoRepository) {
        this.comentarioRepository = comentarioRepository;
        this.iposteoRepository = iposteoRepository;
    }

    @Override
    public List<Comentario> obtenerTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<Comentario> obtenerporId(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public void guardarComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public void editarComentario(Long id, Comentario comentarioActual) {
        Comentario comentarioExiste = comentarioRepository.findById(id).orElse(null);

        if (comentarioExiste != null){
            //Actualizar los campos
            comentarioExiste.setText(comentarioActual.getText());
            comentarioExiste.setCreatedAt(comentarioActual.getCreatedAt());

            // Guardar
            comentarioRepository.save(comentarioExiste);
        } else {
            throw new RuntimeException("Comentario no encontrado con el id: " + id);
        }
    }

    public Comentario agregarComentario(Long posteoId, Comentario comentario) {
        Posteo posteo = iposteoRepository.findById(posteoId)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        comentario.setPosteo(posteo);
        comentario.setCreatedAt(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }
}
