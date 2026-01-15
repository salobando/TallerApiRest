package com.Taller1.Posteo.Controller;

import com.Taller1.Posteo.Model.Autor;
import com.Taller1.Posteo.Model.Comentario;
import com.Taller1.Posteo.Service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comentario> listaComentario(){
        return comentarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Comentario> obtenerporId(@PathVariable Long id){
        return comentarioService.obtenerporId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarComentario(@RequestBody Comentario comentario){
        comentarioService.guardarComentario(comentario);
        return ResponseEntity.ok("Guardado con exito");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> deleteComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.ok("Comentario eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarComentario(@PathVariable Long id, @RequestBody Comentario comentarioActual){
        comentarioService.editarComentario(id,comentarioActual);
        return  ResponseEntity.ok("Comentario actualizado con exito");
    }

    @PostMapping("/post/{postId}")
    public Comentario addComment(@PathVariable Long postId,@RequestBody Comentario comment){
        return comentarioService.agregarComentario(postId, comment);
    }
}
