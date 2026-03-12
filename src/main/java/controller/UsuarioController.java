package controller;
import jakarta.annotation.Nonnull;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importação necessária
import org.springframework.web.bind.annotation.*;
import repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {

        Usuario usuarioExistente = repository.findByEmail(usuario.getEmail());

        if (usuarioExistente != null) {
            return ResponseEntity.badRequest().body("Erro: Este e-mail já está em uso!");
        }


        Usuario salvo = repository.save(usuario);
        return ResponseEntity.ok(salvo);
    }


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