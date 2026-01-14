package com.Taller1.Posteo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posteo")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_posteo;

    @Column(nullable = false, length = 100)
    private String titulo;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;
    @Column(nullable = false)
    private LocalDate fechaCreacion;

    // ONE TO MANY
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comentario> comentarios;

    public Posteo() {
    }

    public Posteo(Long id_posteo, String titulo, String contenido, LocalDate fechaCreacion) {
        this.id_posteo = id_posteo;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId_posteo() {
        return id_posteo;
    }

    public void setId_posteo(Long id_posteo) {
        this.id_posteo = id_posteo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
