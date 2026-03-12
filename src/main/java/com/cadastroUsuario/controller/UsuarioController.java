package com.cadastroUsuario.controller;

import com.cadastroUsuario.model.Usuario;
import com.cadastroUsuario.repository.UsuarioRepository;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        // 1. Validação: Verifica se o e-mail já existe no banco
        Usuario usuarioExistente = repository.findByEmail(usuario.getEmail());

        if (usuarioExistente != null) {
            // Retorna um erro 400 (Bad Request) com a mensagem específica
            return ResponseEntity.badRequest().body("Erro: Este e-mail já está em uso!");
        }

        // 2. Se for novo, grava e retorna Sucesso (200 OK)
        Usuario salvo = repository.save(usuario);
        return ResponseEntity.ok(salvo);
    }

    // O método de login permanece igual
    @PostMapping("/login")
    public String login(@Nonnull @RequestBody Usuario dadosLogin) {
        Usuario usuarioDoBanco = repository.findByEmail(dadosLogin.getEmail());
        if (usuarioDoBanco != null) {
            if (usuarioDoBanco.getSenha().equals(dadosLogin.getSenha())) {
                return "Sucesso";
            }
        }
        return "Erro: E-mail ou senha incorretos";
    }
}