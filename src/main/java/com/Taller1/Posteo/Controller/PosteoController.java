package com.Taller1.Posteo.Controller;

import com.Taller1.Posteo.Model.Posteo;
import com.Taller1.Posteo.Service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteo")
public class PosteoController {
    private final PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listaPosteos(){
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerporId(@PathVariable Long id){
        return posteoService.obtenerporId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPosteo(@RequestBody Posteo posteo){
        posteoService.guardarPosteo(posteo);
        return ResponseEntity.ok("Guardado con exito");
    }

    @PostMapping("/crear/{autorId}")
    public Posteo crearPosteo(@PathVariable Long autorId, @RequestBody Posteo posteo) {
        return posteoService.crearPosteo(autorId, posteo);
    }


    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> deletePosteo(@PathVariable Long id) {
        posteoService.eliminarPosteo(id);
        return ResponseEntity.ok("Posteo eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPosteo(@PathVariable Long id, @RequestBody Posteo posteoActualizada){
        posteoService.editarPosteo(id, posteoActualizada);
        return  ResponseEntity.ok("Posteo actualizada con exito");
    }
}
