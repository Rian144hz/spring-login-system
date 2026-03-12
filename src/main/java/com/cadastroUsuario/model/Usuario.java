package com.cadastroUsuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobreNome;

    @Column(unique = true)
    private String email;

    private String senha;


    public Usuario() {
    }

    public Usuario(String nome, String sobreNome, String email, String senha) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.senha = senha;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public String getSobreNome() { return sobreNome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }


    public void setNome(String nome) { this.nome = nome; }
    public void setSobreNome(String sobreNome) { this.sobreNome = sobreNome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
}