package com.Taller1.Posteo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comentario;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;
    @Column(nullable = false)
    private String createdAt;

}
