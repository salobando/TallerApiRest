package com.Taller1.Posteo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comentario;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // MANY TO ONE
    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Posteo post;

    public Comentario() {
    }

    public Comentario(Long id_comentario, String text, LocalDateTime createdAt) {
        this.id_comentario = id_comentario;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Posteo getPosteo() {
        return post;
    }

    public void setPosteo(Posteo posteo) {
        this.post = posteo;
    }
}
