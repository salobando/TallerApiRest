package com.Taller1.Posteo.Controller;

import com.Taller1.Posteo.Model.Autor;
import com.Taller1.Posteo.Service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listaAutor(){
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Autor> obtenerporId(@PathVariable Long id){
        return autorService.obtenerporId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarAutor(@RequestBody Autor autor){
        autorService.guardarAutor(autor);
        return ResponseEntity.ok("Guardado con exito");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.ok("Autor eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarAutor(@PathVariable Long id, @RequestBody Autor autorActual){
        autorService.editarAutor(id, autorActual);
        return  ResponseEntity.ok("Autor actualizada con exito");
    }

}
