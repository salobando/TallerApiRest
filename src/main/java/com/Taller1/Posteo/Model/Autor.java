package com.Taller1.Posteo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_autor;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;




}
