package com.Taller1.Posteo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    // ONE TO MANY
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Posteo> posteos;

    public Autor() {
    }

    public Autor(Long id_autor, String name, String email) {
        this.id_autor = id_autor;
        this.name = name;
        this.email = email;
    }

    public Long getId_autor() {
        return id_autor;
    }

    public List<Posteo> getPosteos() {
        return posteos;
    }

    public void setPosteos(List<Posteo> posteos) {
        this.posteos = posteos;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
